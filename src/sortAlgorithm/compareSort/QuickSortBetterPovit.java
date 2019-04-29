package sortAlgorithm.compareSort;


import utils.ArrUtils;

import java.util.Random;

/**
 * 通过选取基准获得优化
 * <p>
 * https://blog.csdn.net/hacker00011000/article/details/52176100
 * 我们介绍三种选择基准的方法：(3种)
 * <p>
 * 方法(1)：固定位置 首元素和尾元素  如QuickSort.java中。
 * 测试数据分析：如果输入序列是随机的，处理时间可以接受的。如果数组已经有序时，此时的分割就是一个非常不好的分割。因为每次划分只能使待排序序列减一，此时为最坏情况，快速排序沦为【起泡排序】，时间复杂度为【Θ(n^2)】。而且，输入的数据是有序或部分有序的情况是相当常见的。因此，使用第一个元素作为枢纽元是非常糟糕的，为了避免这个情况，就引入了下面两个获取基准的方法。
 * <p>
 * 方法(2)：随机选取基准 取待排序列中任意一个元素作为基准
 * 引入的原因：在待排序列是部分有序时，固定选取枢轴使快排效率底下，要缓解这种情况，就引入了随机选取枢轴
 * 测试数据分析：:这是一种相对安全的策略。由于枢轴的位置是随机的，那么产生的分割也不会总是会出现劣质的分割。在整个数组数字全相等时，仍然是最坏情况，时间复杂度是O(n^2）。实际上，随机化快速排序得到理论最坏情况的可能性仅为1/(2^n）。所以随机化快速排序可以对于绝大多数输入数据达到O(nlogn）的期望时间复杂度。一位前辈做出了一个精辟的总结：“随机化快速排序可以满足一个人一辈子的人品需求。”
 * <p>
 * 方法(3)：三数取中（median-of-three）
 * 引入的原因：虽然随机选取枢轴时，减少出现不好分割的几率，但是还是最坏情况下还是O(n^2），要缓解这种情况，就引入了三数取中选取枢轴
 * 分析：最佳的划分是将待排序的序列分成等长的子序列，最佳的状态我们可以使用序列的中间的值，也就是第N/2个数。可是，这很难算出来，并且会明显减慢快速排序的速度。这样的中值的估计可以通过随机选取三个元素,并用它们的中值作为枢纽元而得到。事实上，随机性并没有多大的帮助，因此一般的做法是使用左端、右端和中心位置上的三个元素的中值作为枢纽元。显然使用三数中值分割法消除了预排序输入的不好情形，并且减少快排大约14%的比较次数
 * 测试数据分析：使用三数取中选择枢轴优势还是很明显的，但是还是处理不了重复数组
 */
public class QuickSortBetterPovit {

    //1 固定位置-首元素
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
        arr[left] = arr[i];
        arr[i] = povit;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    //2 随机选取基准
    public static void quickSort2(int[] arr, int left, int right) {
        if (left >= right) return;
        //int povit = arr[left];//将数组首元素作为标准值

        int random = new Random().nextInt(right - left) + left;
        int povit = arr[random];//随机角标
        ArrUtils.swap(arr, random, left);

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
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    //3 三数取中（median-of-three）
    public static void quickSort3(int[] arr, int left, int right) {
        if (left >= right) return;
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

        int[] arr = ArrUtils.generalRandomOrder(100, 1000);
        //int[] arr={4,2,7,3,10};

        // QuickSortBetterPovit.quickSort(arr,0,arr.length-1);
        System.out.println("=============================================================");
        QuickSortBetterPovit.quickSort3(arr, 0, arr.length - 1);
        ArrUtils.printArr(arr);


    }
}
