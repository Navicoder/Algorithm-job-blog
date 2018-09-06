package sortAlgorithm.compareSort;

import utils.ArrUtils;

/**
 *
 * // 分类 -------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
 * // 最优时间复杂度 ---- O(n)
 * // 平均时间复杂度 ---- 根据步长序列的不同而不同。
 * // 所需辅助空间 ------ O(1)
 * // 稳定性 ------------ 不稳定
 *
 *
 *
 * 希尔排序就是[有增量的]直接插入排序,即递减增量排序，是插入排序的一种更高效的改进版本。
 *
 *  插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率; 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位.
 *
 *
 *
 *  希尔排序的这个间隔怎么确定，这是个数学难题，至今没有解答。但是通过大量的实验，还是有个经验值。一般        h=3*b+1 1,4,13,40,121,364。最大值不超过数组的大小
 */
public class ShellSort {


    /**
     * gap间隔通过二分递减
     * @param arr
     */
    public static void shellSortDichotomy(int[] arr){
        long l = System.currentTimeMillis();
        //增量gap
        for (int gap = arr.length/2; gap > 0 ; gap/=2) {//每次会数组分为gap组
            System.out.println("gap:"+gap);
            for (int i=gap;  i < arr.length ; i++) {
                int j =i;//如果子序列中只有两个元素 这两值是一样的; 主要是如果这个子序列有不止两个元素时，如 2 9 8 7 交换完一次后，减少j 进一步比较
                while (j-gap >= 0 && arr[j] < arr[j-gap]) {//这里是while 而不是if
                    ArrUtils.swap(arr,j,j-gap);
                    j-=gap;//交换完第一次后，减少j 进一步比较.
                }
            }
        }
        long ll = System.currentTimeMillis()-l;
        System.out.println("希尔排序shellSortDichotomy:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }
    /**
     * gap间隔是 [3*gap + 1] 这样的序列从大到1
     * @param arr
     */
    public static void shellSort(int[] arr){
        long l = System.currentTimeMillis();
        int gap =0;
        while (gap <= arr.length){// 生成初始增量
            gap = 3 * gap+ 1;  // h=3*b+1 1,4,13,40,121,364。length为30的话 序列为1,4,13
        }
        while(gap >=1){
            System.out.println("gap:"+gap);
            for (int i = gap; i < arr.length; i++) {
                int j =i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    ArrUtils.swap(arr,j,j-gap);
                    //子序列中继续向左比较
                    j-=gap;
                }
            }
            //更换间隔 对新产生的子序列排序
            gap = (gap-1)/3;
        }

        long ll = System.currentTimeMillis()-l;
        System.out.println("希尔排序shellSort:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }
    public static void shellSortError2(int[] arr){
        long l = System.currentTimeMillis();
        int gap =0;
        while (gap <= arr.length){// 生成初始增量
            gap = 3 * gap+ 1;  // h=3*b+1 1,4,13,40,121,364。length为30的话 序列为1,4,13
        }
        //TODO ERROR2: 先while 把gap 加上来，再在本层级子序列排序后 在减下来，主要是为了让gap从大值减至1.但是 while之后的值肯定是大于等于length的，并且一般情况下都是大于length的，所以才需要加一个 while(gap > 1)
        for (int i = gap; i < arr.length; i++) {
            System.out.println("gap:"+gap);
            int j =i;
            while(j-gap>=0 && arr[j]<arr[j-gap]){
                ArrUtils.swap(arr,j,j-gap);
                //子序列中继续向左比较
                j-=gap;
            }
            //更换间隔 对新产生的子序列排序
            gap = (gap-1)/3;
        }
        long ll = System.currentTimeMillis()-l;
        System.out.println("希尔排序2:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }

    public static void shellSortError(int[] arr){
        long l = System.currentTimeMillis();
        int gap = (arr.length-1)/3;//TODO  ERROR:  间隔没有减至1
        for (int i = gap; i < arr.length; i++) {
            System.out.println("gap:"+gap);
            int j =i;
            while(j-gap>=0 && arr[j]<arr[j-gap]){
                ArrUtils.swap(arr,j,j-gap);
                //子序列中继续向左比较
                j-=gap;
            }
        }
        long ll = System.currentTimeMillis()-l;
        System.out.println("希尔排序2:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
    }

    public static void main(String[] args) {
        int[] arr = ArrUtils.generalRandomOrder(888,5000);
        int[] arr2= ArrUtils.copyArr(arr);

        ShellSort.shellSort(arr);
        System.out.println("=============================================================");
        ShellSort.shellSortDichotomy(arr2);
        System.out.println(ArrUtils.ifSame(arr,arr2));
    }
}
