package com.beibei.homework.graph.collection;

/**
 * Author:zp
 * Date:2018/1/2 0002
 * Description:子集
 */
public class SubCollection<T> {

    /**
     * 包含的节点
     */
    private Node<T> nodes[];
    /**
     * 权重
     */
    private int weight;

    private boolean deleted = false;

    public SubCollection(Node<T>[] nodes) {
        this.nodes = nodes;
    }

    public SubCollection(Node<T>[] nodes, int weight) {
        this.nodes = nodes;
        this.weight = weight;
    }

    public Node<T>[] getNodes() {
        return nodes;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 是否包含节点node
     *
     * @param node
     * @return
     */
    public boolean contain(Node<T> node) {
        for (Node<T> tNode : nodes) {
            if (tNode.equals(node)) {
                return true;
            }
        }
        return false;
    }

    public boolean contain(T[] anotherNodes) {
        for (T anotherNode : anotherNodes) {
            // 是否存在另一个集合中的该点
            boolean existAnotherNode = false;
            for (Node<T> tNode : nodes) {
                if (tNode.equals(anotherNode)) {
                    existAnotherNode = true;
                }
            }
            if (!existAnotherNode) {
                return false;
            }
        }
        return true;
    }

}
