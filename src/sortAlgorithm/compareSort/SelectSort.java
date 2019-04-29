package sortAlgorithm.compareSort;

import utils.ArrUtils;


/**
 * http://blog.jobbole.com/107417/
 * 以升序为例。
 * 选择排序比较好理解，一句话概括就是依次按位置挑选出适合此位置的元素来填充。
 * <p>
 * 1. 暂定第一个元素为最小元素，往后遍历，逐个与最小元素比较，若发现更小者，与先前的”最小元素”交换位置。达到更新最小元素的目的。
 * 2. 一趟遍历完成后，能确保刚刚完成的这一趟遍历中，最的小元素已经放置在前方了。然后缩小排序范围，新一趟排序从数组的第二个元素开始。
 * 3. 在新一轮排序中重复第1、2步骤，直到范围不能缩小为止，排序完成。
 */

/**
 * 选择排序  内循环 找出最小值 然后跟外循环的起始值互换 --> 并没有在每层交换。内层的目的就是选出最小值的角标
 *
 * 所以在内循环中需要维护 最小值角标和最小值 这两个变量
 *
 *
 * // 分类 -------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- O(n^2)
 * // 最优时间复杂度 ---- O(n)
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
                //for (int j = i; j < arr.length && arr[j] < arr[minIndex]; j++) {// TODO 这样为什么不行
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
