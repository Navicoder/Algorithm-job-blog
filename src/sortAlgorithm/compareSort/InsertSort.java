package sortAlgorithm.compareSort;

import utils.ArrUtils;

/**
 * 插入排序是从一个乱序的数组中依次取值，插入到一个已经排好序的数组中。这看起来好像要两个数组才能完成，但如果只想在同一个数组内排序，也是可以的。此时需要想象出两个区域：前方有序区和后方乱序区。
 *
 * 1    分区。开始时前方有序区只有一个元素，就是数组的第一个元素。然后把从第二个元素开始直到结尾的数组作为乱序区。
 *          从乱序区取第一个元素，把它正确插入到前方有序区中。把它与前方无序区的最后一个元素比较，亦即与它的前一个元素比较。
 *          如果比前一个元素要大，则不需要交换，这时有序区扩充一格，乱序区往后缩减一格，相当于直接拼在有序区末尾。
 *          如果和前一个元素相等，
 *              则继续和前二元素比较、再和前三元素比较……如果往前遍历到头了，发现前方所有元素值都长一个样的话(囧)，那也可以，不需要交换，这时有序区扩充一格，乱序区往后缩减一格，相当于直接拼在有序区末尾;
 *              如果比前一个元素大呢？对不起作为有序区不可能出现这种情况。如果比前一个元素小呢，请看下一点。
 *          如果比前一个元素小，则交换它们的位置。交换完后，继续比较取出元素和它此时的前一个元素，若更小就交换，若相等就比较前一个，直到遍历完成。
 * 2    至此，把乱序区第一个元素正确插入到前方有序区中。
 * 3    往后缩小乱序区范围，继续取缩小范围后的第一个元素，重复第2步骤。直到范围不能缩小为止，排序完成。
 */

/**
 * 插入排序
 *  将后面的元素插入到之前的已经排好序的数组中，然后i++再放下一个元素
 *
 *
 * // 分类 ------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
 * // 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
 * // 平均时间复杂度 ---- O(n^2)
 * // 所需辅助空间 ------ O(1)
 * // 稳定性 ------------ 稳定
 *
 * 插入排序不适合对于数据量比较大的排序应用。但是，如果需要排序的数据量很小，比如量级小于千，那么插入排序还是一个不错的选择
 */
public class InsertSort {

    public static void insertSort(int[] arr, int left, int right) {
        long l = System.currentTimeMillis();
        if (left + 1 > right) return;
        if (arr != null && arr.length > 0) {
            //插入排序
            for (int i = left + 1; i <= right; i++) {
                //arr[j] < arr[j-1]要加在循环条件中，不然会有很多多余的遍历步骤--> 如果arr[j] >= arr[j-1]时，该元素arr[i]已经在它应该的位置了，遍历下一个元素
                for (int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {//每当查出需要替换的时候 就替换；一次交换，涉及到三次赋值，所以下边有优化的
                    ArrUtils.swap(arr, j, j - 1);
                }
            }
//
//            冒泡排序
//            for (int i = 0; i < arr.length-1; i++) {
//                for (int j =0; j < arr.length-1-i; j++) {
//                    if (arr[j] > arr[j+1]) {
//                        ArrUtils.swap(arr, j, j + 1);
//                    }
//                }
//            }
        }
        long ll = System.currentTimeMillis()-l;
        System.out.println("插入排序:size():"+arr.length+"耗时:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }
    //=============插入时，将一个需要交换的值在每次比较时复制;另一个需要交换的值( -- 需要插入的值)，先做保存，一次复制=====================

    //定义了两个变量 val和index 分别为本次要处理的元素的值和应该存放的位置。显然没有3好
    public static void insertSort2(int[] arr){
        long l = System.currentTimeMillis();
        if (arr != null && arr.length > 0) {
            for (int i = 1; i < arr.length; i++) {//找出arr[i]应放的位置
                int val = arr[i];
                int index = i;
                for (int j = i; j >= 1 && arr[j - 1] > val; j--) {
                    arr[j] = arr[j - 1];//插入时，将一个需要交换的值在每次比较时复制
                    index = j - 1;
                }
                arr[index] = val;//另一个需要交换的值( -- 需要插入的值)一次复制
            }
        }
        System.out.println("插入排序3:size():" + arr.length + "耗时:" + (System.currentTimeMillis() - l) + "ms");
    }

    //定义了一个变量 val 为本次要处理的元素的值,应该存放的位置则用内部循环的j存放，即内部循环结束时j的值；比2省了一个变量定义和内部循环时的赋值：index = j-1;
    public static void insertSort3(int[] arr) {
        long l = System.currentTimeMillis();
        if (arr != null && arr.length > 0) {
            for (int i = 1; i < arr.length; i++){
                int val = arr[i];//拿到本次应该处理的数值
                int j;//定义在外面是拿到最后应该放置的位置
                for (j = i; j >=1 && arr[j-1] > val; j--)  {
                    arr[j]=arr[j-1];//插入时，将一个需要交换的值在每次比较时复制
                }
                arr[j]=val;//另一个需要交换的值( -- 需要插入的值)一次复制
            }
        }
        long ll = System.currentTimeMillis()-l;
        System.out.println("插入排序2:size():"+arr.length+"耗时:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }


    public static void main(String[] args) {
        int[] arr = ArrUtils.generalRandomOrder(10, 1000);


        int[] arr2 = ArrUtils.copyArr(arr);// int[] arr2 =arr;
        int[] arr3 = ArrUtils.copyArr(arr);// int[] arr2 =arr;
        InsertSort.insertSort(arr, 0, arr.length - 1);
//        InsertSort.insertSort2(arr2);
//        InsertSort.insertSort3(arr3);

        ArrUtils.printArr(arr);
    }
}
