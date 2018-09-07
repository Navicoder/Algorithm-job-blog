package sortAlgorithm.compareSort;

import utils.ArrUtils;

/**
 * 选择排序  内循环 找出最小值 然后跟外循环的起始值互换
 *
 * 所以在内循环中需要维护 最小值角标和最小值 这两个变量
 *
 *
 * // 分类 -------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- O(n^2)
 * // 最优时间复杂度 ---- O(n^2)
 * // 平均时间复杂度 ---- O(n^2)
 * // 所需辅助空间 ------ O(1)
 * // 稳定性 ------------ 不稳定
 *
 * { 5, 8, 5, 2, 9 }，一次选择的最小元素是2，然后把2和第一个5进行交换，从而改变了两个元素5的相对次序。
 */
public class SelectSort {
    public static void selectSort(int[] arr){
        long l = System.currentTimeMillis();
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length; i++){        // i为已排序序列的末尾
                int minIndex =i;// 找到[i,end]的最小值

                int minValue=arr[minIndex];
                //for (int j = i; j < arr.length && arr[j] < arr[minIndex]; j++) {// TODO 这样为什么不想
                for (int j = i; j < arr.length; j++) {                   // 未排序序列
                    if ( arr[j] < minValue) {
                        minIndex = j;

                        minValue=arr[j];
                    }
                }
                ArrUtils.swap(arr, i, minIndex);//把i位置的值 和[i,end]中最小值互换
            }
        }
        long ll = System.currentTimeMillis()-l;
        System.out.println("选择排序:size():"+arr.length+"耗时:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }

    public static void main(String[] args) {
        int[] arr = ArrUtils.generalRandomOrder(10000,89602);
        SelectSort.selectSort(arr);
        ArrUtils.printArr(arr);
    }
}
