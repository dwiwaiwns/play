package com.beibei.homework.graph.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:zp
 * Date:2018/1/2 0002
 * Description:
 */
public class CovertAlgorithm<T extends Object> {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);


        Node nodes[] = {node1, node2, node3, node4};

        int degrees[] = {1, 1, 3, 1};

        List<SubCollection<Integer>> subCollection = new ArrayList<>();
        subCollection.add(new SubCollection<Integer>(new Node[]{node1}, 5));
        subCollection.add(new SubCollection<Integer>(new Node[]{node2, node3}, 1));
        subCollection.add(new SubCollection<Integer>(new Node[]{node1, node2, node3}, 1));
        subCollection.add(new SubCollection<Integer>(new Node[]{node4}, 1));

        List<Node[]> neighborNode = new ArrayList<>();
        neighborNode.add(new Node[]{node2});
        neighborNode.add(new Node[]{node1});
        neighborNode.add(new Node[]{node1, node2, node4});
        neighborNode.add(new Node[]{node3});


        CovertAlgorithm<Integer> covertAlgorithm = new CovertAlgorithm<>();
        List<Integer> minCovertCollectionIndex = covertAlgorithm.getCovertCollectionIndex(nodes, degrees, subCollection, neighborNode);
        System.out.println("覆盖集为：");
        for (Integer index : minCovertCollectionIndex) {
            subCollection.get(index).getNodes();
            System.out.println("    " + covertAlgorithm.formatCollection(subCollection.get(index).getNodes()));
        }
    }

    public List<Integer> getCovertCollectionIndex(Node<T> nodes[], int degrees[], List<SubCollection<T>> subCollectionList, List<Node[]> neighborNode) {
        // 接点标识，删除标示，true表示该节点需要查找覆盖集
        int[][] flags = new int[nodes.length][subCollectionList.size()];
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < subCollectionList.size(); j++) {
                flags[i][j] = 0;
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < subCollectionList.size(); j++) {
                if (subCollectionList.get(j).contain(nodes[i])) {
                    flags[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            Node currentNode = nodes[i];
            if (currentNode.isDeleted()) {
                // 节点已经被删除了
                continue;
            }
            // 1.步骤一
            // 1.1.获取唯一覆盖node的子集合
            int uniqueCollectionIndex = getUniqueCollectionIndex4Node(subCollectionList, currentNode);
            if (uniqueCollectionIndex != -1) {
                // 1.1.1.找到了包含node的唯一子集

                // 1.1.2.删除node
                currentNode.setDeleted(true);
                // 1.1.3.删除子集
                subCollectionList.get(uniqueCollectionIndex).setDeleted(true);
                // 1.1.4.删除子集包含的node
                for (Node<T> node : subCollectionList.get(uniqueCollectionIndex).getNodes()) {
                    int nodeIndex = getNodeIndex(nodes, node);
                    nodes[nodeIndex].setDeleted(true);
                }
                flags[i][uniqueCollectionIndex] = 2;
                continue;
            }
            // 2.步骤二
            int minWeight = getMinWeightMaxCollection(subCollectionList, currentNode);
            // 2.1.
            if (minWeight != -1) {
                // 2.1.1.删除node
                currentNode.setDeleted(true);
                // 2.1.2.删除子集
                subCollectionList.get(minWeight).setDeleted(true);
                // 2.1.3.删除子集包含的node
                for (Node<T> node : subCollectionList.get(minWeight).getNodes()) {
                    int nodeIndex = getNodeIndex(nodes, node);
                    nodes[nodeIndex].setDeleted(true);
                }
                flags[i][minWeight] = 2;
                continue;
            }
            // 3.步骤三
            // 3.1.步骤一&步骤二有操作

            // 4.步骤四
            int minDegreeIndex = getMinDegreeIndex(degrees);
            if (degrees[minDegreeIndex] == 1) {
                // 返回所有子集的index
                List<Integer> indexList = new ArrayList<>(subCollectionList.size());
                for (int j = 0; j < subCollectionList.size(); j++) {
                    indexList.add(j);
                }
                return indexList;
            }
            // 5.步骤五
            if (minCollectionContainNode(subCollectionList, flags, currentNode)) {
                // 5.1.2.结点在最小加权集合覆盖中，此时删除结点及其邻点集中包含的结点
                currentNode.setDeleted(true);
                for (Node neighbor : neighborNode.get(i)) {
                    int neighborIndex = getNodeIndex(nodes, neighbor);
                    nodes[neighborIndex].setDeleted(true);
                }
            } else {
                // 最小权集合不包含该节点,删除当前节点
                nodes[i].setDeleted(true);
            }
        }
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < subCollectionList.size(); j++) {
                if (flags[i][j] == 2 && !indexList.contains(j)) {
                    indexList.add(j);
                }
            }
        }
        return indexList;
    }

    public int getNodeIndex(Node<T> nodes[], Node<T> node) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals(node)) {
                return i;
            }
        }
        return -1;
    }

    public String formatCollection(Node<T> nodes[]) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i].getValue());
            if (i != nodes.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // --------------------------------------------------------------------------------

    private boolean minCollectionContainNode(List<SubCollection<T>> subCollectionList, int[][] flags, Node<T> node) {
        for (int i = 0; i < flags.length; i++) {
            for (int j = 0; j < flags[0].length; j++) {
                if (flags[i][j] != 2) {
                    continue;
                }
                if (subCollectionList.get(j).contain(node)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getMinDegreeIndex(int[] degrees) {
        int minIndex = degrees[0];
        for (int i = 1; i < degrees.length; i++) {
            if (degrees[i] <= degrees[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int getMinWeightMaxCollection(List<SubCollection<T>> subCollectionList, Node<T> node) {
        int index = -1;
        boolean existed = false;// 是否存在这样的集合
        for (int i = 0; i < subCollectionList.size(); i++) {
            if (subCollectionList.get(i).isDeleted()) {
                // 该子集已被删除
                continue;
            }
            if (!subCollectionList.get(i).contain(node)) {
                continue;
            }
            if (index == -1) {
                index = i;
                continue;
            }
            SubCollection subCollectionA = subCollectionList.get(index);
            SubCollection subCollectionB = subCollectionList.get(i);
            // 已经存在一个包含node的集合了，判断当前两个集合的是否有包含关系
            // a 不包含 b, b 也不包含 a
            if (!subCollectionA.contain(subCollectionB.getNodes()) && !subCollectionB.contain(subCollectionA.getNodes())) {
                continue;
            }
            // 判断权重
            if (subCollectionA.contain(subCollectionB.getNodes()) && subCollectionA.getWeight() <= subCollectionB.getWeight()) {
                // 删除b
                existed = true;
                subCollectionB.setDeleted(true);
                continue;
            }
            if (subCollectionB.contain(subCollectionA.getNodes()) && subCollectionB.getWeight() <= subCollectionA.getWeight()) {
                // 删除b
                index = i;
                existed = true;
                subCollectionB.setDeleted(true);
                continue;
            }
        }
        if (existed) {
            return index;
        }
        return -1;
    }

    private int getUniqueCollectionIndex4Node(List<SubCollection<T>> subCollectionList, Node<T> node) {
        int index = -1;
        for (int i = 0; i < subCollectionList.size(); i++) {
            if (subCollectionList.get(i).isDeleted()) {
                // 该子集已被删除
                continue;
            }
            if (!subCollectionList.get(i).contain(node)) {
                // 该子集不包含给定节点
                continue;
            }
            if (index != -1) {
                // 已有存在包含node的节点，所以不存在包含node唯一子集
                return -1;
            }
            index = i;
        }
        return index;
    }

}


