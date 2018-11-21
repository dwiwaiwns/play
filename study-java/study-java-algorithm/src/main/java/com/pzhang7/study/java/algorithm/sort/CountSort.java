package com.pzhang7.study.java.algorithm.sort;

/**
 * @author pengz
 * @date created on 2018-10-22
 * @description 计数排序
 */
public class CountSort {

    public static void main(String[] args) {
        CountSort countSort = new CountSort();

        int[] array = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        int[] sorted = countSort.sort(array, 5);
        countSort.printArray(sorted);
    }

    public int[] sort(int[] array, int maxK) {

        int[] c = new int[maxK + 1];
        int[] b = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            c[array[i]] += 1;
        }
        int sum = 0;
        for (int i = 0; i < maxK + 1; i++) {
            sum += c[i];
            c[i] = sum;
        }
        for (int i = 0; i < array.length; i++) {
            int index = c[array[i]] - 1;
            b[index] = array[i];
            c[array[i]]--;
        }
        return b;
    }

    public void printArray(int array[]) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
