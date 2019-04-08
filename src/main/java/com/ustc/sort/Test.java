package com.ustc.sort;

public class Test{

    static int len = 11;

    public static void main(String[] args) {
        int[] arrayUnsorted = {2, -1, 6, 0, 2, 3, 1, -2, 4, 5, -1};
        System.out.print("1.After insert sort is: ");
        InsertSort.insertSort(arrayUnsorted);

        arrayUnsorted = new int[]{2, -1, 6, 0, 2, 3, 1, -2, 4, 5, -1};
        System.out.print("2.After bubble sort is: ");
        BubbleSort.bubbleSort(arrayUnsorted);

        arrayUnsorted = new int[]{2, -1, 6, 0, 2, 3, 1, -2, 4, 5, -1};
        System.out.print("3.After select sort is: ");
        SelectSort.selectSort(arrayUnsorted);

        arrayUnsorted = new int[]{2, -1, 6, 0, 2, 3, 1, -2, 4, 5, -1};
        System.out.print("4.After shell  sort is: ");
        ShellSort.shellSort(arrayUnsorted);

        arrayUnsorted = new int[]{2, -1, 6, 0, 2, 3, 1, -2, 4, 5, -1};
        System.out.print("5.After quick  sort is: ");
        QuickSort.quickSort(arrayUnsorted);

        arrayUnsorted = new int[]{2, -1, 6, 0, 2, 3, 1, -2, 4, 5, -1};
        System.out.print("6.After heap   sort is: ");
        HeapSort.heapSort(arrayUnsorted);

        arrayUnsorted = new int[]{2, -1, 6, 0, 2, 3, 1, -2, 4, 5, -1};
        System.out.print("7.After merge  sort is: ");
        MergeSort.mergeSort(arrayUnsorted);

        arrayUnsorted = new int[]{2, -1, 6, 0, 2, 3, 1, -2, 4, 5, -1};
        System.out.print("8.After count  sort is: ");
        CountingSort.countingSort(arrayUnsorted);
    }
}
