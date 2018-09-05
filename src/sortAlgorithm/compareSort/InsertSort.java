package sortAlgorithm.compareSort;

import utils.ArrUtils;

/**
 * 插入排序
 *
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
 *
 *
 *
 * 插入排序不适合对于数据量比较大的排序应用。但是，如果需要排序的数据量很小，比如量级小于千，那么插入排序还是一个不错的选择
 */
public class InsertSort {

    public static void insertSort(int[] arr){
        long l = System.currentTimeMillis();
        if (arr != null && arr.length > 0) {
            for (int i = 1; i < arr.length; i++)
            {
                for (int j = i; j >=1 && arr[j] < arr[j - 1]; j--)  {//每当查出需要替换的时候 就替换；一次交换，涉及到三次赋值，所以下边有优化的
                    ArrUtils.swap(arr, j, j - 1);
                }
            }
        }
        long ll = System.currentTimeMillis()-l;
        System.out.println("插入排序:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }


    /**
     * 2 和 3 的区别 还是不懂啊 2是对的
     *
     * @param arr
     */

    //插入时，将一个需要交换的值在每次比较时复制;另一个需要交换的值( -- 需要插入的值)，先做保存，一次复制
    public static void insertSort2(int[] arr){
        long l = System.currentTimeMillis();
        if (arr != null && arr.length > 0) {
            for (int i = 1; i < arr.length; i++){
                int val = arr[i];
                int j;
                for (j = i; j >=1 && arr[j-1] > val; j--)  {
                    arr[j]=arr[j-1];//插入时，将一个需要交换的值在每次比较时复制
                }
                arr[j]=val;//另一个需要交换的值( -- 需要插入的值)一次复制
            }
        }
        long ll = System.currentTimeMillis()-l;
        System.out.println("插入排序2:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }
    public static void insertSort3(int[] arr){
        long l = System.currentTimeMillis();
        if (arr != null && arr.length > 0) {
            for (int i = 1; i < arr.length; i++){//找出arr[i]应放的位置
                int val = arr[i];
                int index = i;
                for (int j = i; j >=1 && arr[j-1] > val; j--)  {
                    arr[j]=arr[j-1];//插入时，将一个需要交换的值在每次比较时复制
                    index = j;
                }
                arr[index]=val;//另一个需要交换的值( -- 需要插入的值)一次复制
            }
        }
        System.out.println("插入排序3:"+(System.currentTimeMillis()-l)+"ms");
    }

    public static void main(String[] args) {
        int[] arr = ArrUtils.generalRandomOrder(10000,89602);

        InsertSort.insertSort3(arr);

        ArrUtils.printArr(arr);
    }
}
