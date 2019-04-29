package sortAlgorithm.compareSort;

import utils.ArrUtils;

/**
 * http://developer.51cto.com/art/201403/430986.htm
 */
public class TT {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int povit = arr[left];//将数组首元素作为标准值
        int i = left;
        int j = right;
        while (i != j) {
            while (arr[j] >= povit && j > i) j--;//从尾部找到小于povit的值
            while (arr[i] <= povit && i < j) i++;//从头部找到大于povit的值
            if (i != j) ArrUtils.swap(arr, i, j);
        }

        //i和j 必相等
        arr[left]=arr[i];
        arr[i] = povit;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);


    }

    public static void main(String[] args) {
        int[] arr = ArrUtils.generalRandomOrder(10, 1);
        quickSort(arr, 0, arr.length - 1);

        ArrUtils.printArr(arr);

    }
}