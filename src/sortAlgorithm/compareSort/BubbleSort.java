package sortAlgorithm.compareSort;

import utils.ArrUtils;

/**
 * // 分类 -------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- O(n^2)
 * // 最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
 * // 平均时间复杂度 ---- O(n^2)
 * // 所需辅助空间 ------ O(1)
 * // 稳定性 ------------ 稳定
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        long l = System.currentTimeMillis();
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length - 1; i++)// 每次最大元素就像气泡一样"浮"到数组的最后;  由于每次比较是i与i+1 比较，所以i的最大值是arr.length - 1，而不是arr.length
            {
                for (int j = 0; j < arr.length - 1 - i; j++) // 依次比较相邻的两个元素,使较大的那个向后移
                {
                    if (arr[j] >arr[j + 1])            // 如果条件改成A[j] >= A[j + 1],则变为不稳定的排序算法
                    {
                        ArrUtils.swap(arr, j, j + 1);
                    }
                }
            }
        }
        long ll = System.currentTimeMillis()-l;
        System.out.println("冒泡排序:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }

    /**
     * 鸡尾酒排序，也叫定向冒泡排序，是冒泡排序的一种改进。此算法与冒泡排序的不同处在于从低到高然后从高到低，而冒泡排序则仅从低到高去比较序列里的每个元素
     *
     *
     * // 分类 -------------- 内部比较排序
     * // 数据结构 ---------- 数组
     * // 最差时间复杂度 ---- O(n^2)
     * // 最优时间复杂度 ---- 如果序列在一开始已经大部分排序过的话,会接近O(n)
     * // 平均时间复杂度 ---- O(n^2)
     * // 所需辅助空间 ------ O(1)
     * // 稳定性 ------------ 稳定
     * @param A
     * @param n
     */
    public static void CocktailSort(int A[], int n)
    {
        int left = 0;                            // 初始化边界
        int right = n - 1;
        while (left < right)
        {
            for (int i = left; i < right; i++)   // 前半轮,将最大元素放到后面
            {
                if (A[i] > A[i + 1])
                {
                    ArrUtils.swap(A, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--)   // 后半轮,将最小元素放到前面
            {
                if (A[i - 1] > A[i])
                {
                    ArrUtils.swap(A, i - 1, i);
                }
            }
            left++;
        }
    }
    public static void main(String[] args) {
        int[] arr = ArrUtils.generalRandomOrder(10000,89602);

        BubbleSort.bubbleSort(arr);

        ArrUtils.printArr(arr);
    }

}
