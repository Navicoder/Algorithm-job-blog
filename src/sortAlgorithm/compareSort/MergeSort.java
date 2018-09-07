package sortAlgorithm.compareSort;

import utils.ArrUtils;

/**
 * 合并排序 分为递归实现与非递归(迭代)实现
 */
public class MergeSort {

    // 递归实现的归并排序(自顶向下)
    public static void MergeSortRecursion(int arr[], int left, int right){
        if (left == right)    // 当待排序的序列长度为1时，递归开始回溯，进行merge操作
            return;
        int mid = (left + right) / 2;
        MergeSortRecursion(arr, left, mid);
        MergeSortRecursion(arr, mid + 1, right);
        Merge(arr, left, mid, right);
    }

//    Exception in thread "main" java.lang.StackOverflowError.因为 left right mid 这些取的还是原始数组的
//    // 递归实现的归并排序(自顶向下)
//    public static void MergeSortRecursion(int arr[]){
//        int left =0;
//        int right =arr.length-1;
//        if (left == right)    // 当待排序的序列长度为1时，递归开始回溯，进行merge操作
//            return;
//        int mid = (left + right) / 2;
//        MergeSortRecursion(arr);
//        MergeSortRecursion(arr);
//        Merge(arr, left, mid, right);
//    }

    // 非递归(迭代)实现的归并排序(自底向上)
    // TODO 不懂
    public static void MergeSortIteration(int arr[], int len){
        int left, mid, right;// 子数组索引,前一个为arr[left...mid]，后一个子数组为arr[mid+1...right]
        // 子数组的大小i初始为1，每轮翻倍
        for (int i = 1; i < len; i *= 2){
            left = 0;
            // 后一个子数组存在(需要归并)
            while (left + i < len){
                mid = left + i - 1;
                right = mid + i < len ? mid + i : len - 1;// 后一个子数组大小可能不够
                Merge(arr, left, mid, right);
                left = right + 1;               // 前一个子数组索引向后移动
            }
        }
    }
    // 合并两个已排好序的数组arr[left...mid]和arr[mid+1...right]
    public static void Merge(int arr[], int left, int mid, int right){
        int len = right - left + 1;
        int[] brr = new int[len];       // 辅助空间O(n)
        int index = 0;
        int i = left;                   // 前一数组的起始元素
        int j = mid + 1;                // 后一数组的起始元素
        while (i <= mid && j <= right){
            brr[index++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];  // 带等号保证归并排序的稳定性
        }
        while (i <= mid){
            brr[index++] = arr[i++];
        }
        while (j <= right){
            brr[index++] = arr[j++];
        }
        for (int k = 0; k < len; k++){
            arr[left++] = brr[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrUtils.generalRandomOrder(200,50000);
        int[] arr2= ArrUtils.copyArr(arr);
        MergeSort.MergeSortIteration(arr2,arr2.length);
        ArrUtils.printArr(arr2);

    }
}
