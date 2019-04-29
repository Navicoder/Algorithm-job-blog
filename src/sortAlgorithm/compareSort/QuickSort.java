package sortAlgorithm.compareSort;

import utils.ArrUtils;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Dictionary;


//坐在马桶 http://developer.51cto.com/art/201403/430986.htm
// 分类 ------------ 内部比较排序
// 数据结构 --------- 数组
// 最差时间复杂度 ---- 每次选取的基准都是最大（或最小）的元素，导致每次只划分出了一个分区，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)
// 最优时间复杂度 ---- 每次选取的基准都是中位数，这样每次都均匀的划分出两个分区，只需要logn次划分就能结束递归，时间复杂度为O(nlogn)
// 平均时间复杂度 ---- O(nlogn)
// 所需辅助空间 ------ 主要是递归造成的栈空间的使用(用来保存left和right等局部变量)，取决于递归树的深度，一般为O(logn)，最差为O(n)
// 稳定性 ---------- 不稳定
public class QuickSort {

    // 划分函数
    public static int partition2(int arr[], int left, int right){
        int pivot = arr[right];               // 这里每次都选择最后一个元素作为基准-- 枢轴
        int tail = left - 1;                // tail为小于基准的子数组最后一个元素的索引
        for (int i = left; i < right; i++)  // 遍历基准以外的其他元素
        {
            if (arr[i] <= pivot)              // 把小于等于基准的元素放到前一个子数组末尾
            {
                ArrUtils.swap(arr, ++tail, i);
            }
        }
        ArrUtils.swap(arr, tail + 1, right);           // 最后把基准放到前一个子数组的后边，剩下的子数组既是大于基准的子数组
        // 该操作很有可能把后面元素的稳定性打乱，所以快速排序是不稳定的排序算法
        return tail + 1;                    // 返回基准的索引
    }

    //最后一个元素作为基准
    public static void quickSort2(int arr[], int left, int right){
        //  System.out.println("left:"+left+",right:"+right);
        if (left >= right)
            return;
        int pivot_index = partition2(arr, left, right); // 基准的索引
        quickSort2(arr, left, pivot_index - 1);
        quickSort2(arr, pivot_index + 1, right);
    }

    //第一个元素作为基准
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int temp = arr[left]; //temp中存的就是基准数
        int i = left;
        int j = right;

        while (i != j) {//4 继续向中间靠拢，直至汇合。
            //1 顺序很重要，要先从右边开始找,直至找到比temp即[子]数组的左边界小的位置
            while (arr[j] >= temp && i < j) j--;
            //2 再找左边的,直至找到比temp即[子]数组的左边界大的位置
            while (arr[i] <= temp && i < j) i++;
            //3  执行到这说明 {arr[j]< temp;arr[i]>temp}  交换两个数在数组中的位置
            if (i != j) ArrUtils.swap(arr, i, j);

        }
        //5 完成基准数和i与j交汇的值互换，//最终i和j 肯定相等
        arr[left]=arr[i];
        arr[i]=temp;

        //=======最终将基准数归位,实现了[left,right]数组在基准数左边的都比基准数小，右边的都比基准数大===========
        quickSort(arr, left, i - 1);//6 继续处理左边的，这里是一个递归的过程
        quickSort(arr, i + 1, right);//6 继续处理右边的 ，这里是一个递归的过程
    }

    public static void quickSort(int[] arr) {
        long l = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long ll = System.currentTimeMillis()-l;
        System.out.println("快速排序quickSort:size():" + arr.length + "耗时:" + (ll / 1000) + "." + (ll % 1000) + "秒" + (ll / 1000 / 60) + "分钟" + (ll / 1000 / 60 / 60) + "小时");
    }

    public static void quickSort2(int[] arr) {
        long l = System.currentTimeMillis();
        quickSort2(arr, 0, arr.length - 1);
        long ll = System.currentTimeMillis() - l;
        System.out.println("快速排序quickSort:size():" + arr.length + "耗时:" + (ll / 1000) + "." + (ll % 1000) + "秒" + (ll / 1000 / 60) + "分钟" + (ll / 1000 / 60 / 60) + "小时");
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");

        int[] arr = ArrUtils.generalRandomOrder(9, 1000);

//        int[] arr={4,2,7,3,10};
//        int[] arr2={4,5,2,3,10};
        // int[] arr2 = ArrUtils.copyArr(arr);

        System.out.println("=============================================================");
        //QuickSort.quickSort(arr);//1亿 19秒 5亿 90.390秒
        QuickSort.quickSort2(arr);//1亿 17秒 5亿 82.240秒
        ArrUtils.printArr(arr);

    }
}
