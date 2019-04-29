package sortAlgorithm.compareSort;


import utils.ArrUtils;

import java.util.Random;

/**
 * https://blog.csdn.net/hacker00011000/article/details/52176100
 * 四种优化方式：
 * <p>
 * 优化1：当待排序序列的长度分割到一定大小后，使用插入排序
 * 原因：对于很小和部分有序的数组，快排不如插排好。当待排序序列的长度分割到一定大小后，继续分割的效率比插入排序要差，此时可以使用插排而不是快排
 * 截止范围：待排序序列长度N = 10
 * 测试数据分析：针对随机数组，使用三数取中选择枢轴+插排，效率还是可以提高一点，
 * 针对已排序的数组，是没有任何用处的。因为待排序序列是已经有序的，那么每次划分只能使待排序序列减一。此时，插排是发挥不了作用的。所以这里看不到时间的减少。
 * 另外，三数取中选择枢轴+插排还是不能处理重复数组
 */
public class QuickSortBetter {
    // 三数取中（median-of-three）+ 插入
    public static void quickSort3(int[] arr, int left, int right) {
        if (left >= right) return;

        if (right - left + 1 < 10) {//当数组长度小于10时,用插入排序
            // InsertSort.insertSort(arr,left,right);
            return;
        }//else时，正常执行快排


        //int povit = arr[left];//将数组首元素作为标准值

        int mid = left + ((right - left) >> 1);//计算数组中间的元素的下标

        //使用三数取中法选择枢轴  - 目标 【left的位置上保存这三个位置中间的值】
        if (arr[mid] > arr[right])//目标: arr[mid] <= arr[right]
        {
            ArrUtils.swap(arr, mid, right);
        }
        if (arr[left] > arr[right])//目标: arr[left] <= arr[right]
        {
            ArrUtils.swap(arr, left, right);
        }
        if (arr[mid] > arr[left]) //目标: arr[left] >= arr[mid]
        {
            ArrUtils.swap(arr, mid, left);
        }
        //此时，arr[mid] <= arr[left] <= arr[right]
        int povit = arr[left];


        int i = left;
        int j = right;
        while (i != j) {
            while (arr[j] >= povit && j > i) j--;//从尾部找到小于povit的值
            while (arr[i] <= povit && i < j) i++;//从头部找到大于povit的值
            if (i != j) ArrUtils.swap(arr, i, j);
        }

        //i和j 必相等
        arr[left] = arr[i];
        arr[i] = povit;
        quickSort3(arr, left, i - 1);
        quickSort3(arr, i + 1, right);
    }


    public static void main(String[] args) {


    }
}
