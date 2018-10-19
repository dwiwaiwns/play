package com.pzhang7.study.java.algorithm.sort;

/**
 * @author pengz
 * @date created on 2018-10-11
 * @description 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int array[] = new int[]{123, 234, 543, 324, 568, 975, 547, 672, 783, 239};
        RadixSort radixSort = new RadixSort();
        int[] sort = radixSort.lsdSort(array);
        radixSort.printArray(sort);

        array = new int[]{123, 234, 543, 324, 568, 975, 547, 672, 783, 239};
        int digit = radixSort.getMaxDigit(array);
        sort = radixSort.msdSort(array, digit);
        radixSort.printArray(sort);
    }

    /**
     * MSD 从高位向低位排序
     *
     * @param array
     */
    public int[] msdSort(int array[], int digit) {
        if (array.length <= 1) {
            return array;
        }
        int base = (int) Math.pow(10, digit - 1);
        int[] count = new int[10];
        int[] tmp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            count[array[i] / base % 10]++;
        }
        int[] start = new int[10];
        for (int i = 1; i < count.length; i++) {
            start[i] = start[i - 1] + count[i - 1];
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            int index = start[array[i] / base % 10]++;
            tmp[index] = array[i];
        }
        array = tmp;

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            int[] subTmp = new int[count[i]];
            for (int j = 0; j < subTmp.length; j++) {
                subTmp[j] = array[index++];
            }
            subTmp = msdSort(subTmp, digit - 1);
            for (int j = 0; j < subTmp.length; j++) {
                array[index - count[i] + j] = subTmp[j];
            }
        }

        return array;
    }

    /**
     * LSD 从低位向高位排序
     *
     * @param array
     */
    public int[] lsdSort(int array[]) {
        if (array.length <= 1) {
            return array;
        }
        int digit = getMaxDigit(array);
        int base = 1;
        while (digit-- > 0) {
            int[] count = new int[10];
            int[] tmp = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                count[array[i] / base % 10]++;
            }
            int[] start = new int[10];
            for (int i = 1; i < count.length; i++) {
                start[i] = start[i - 1] + count[i - 1];
            }
            for (int i = 0; i < array.length; i++) {
                int index = start[array[i] / base % 10]++;
                tmp[index] = array[i];
            }
            array = tmp;
            base *= 10;
        }
        return array;
    }

    public int getMaxDigit(int array[]) {
        int digit = 1;
        int base = 10;
        for (int i = 0; i < array.length; i++) {
            while (array[i] > base) {
                ++digit;
                base *= 10;
            }
        }
        return digit;
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
