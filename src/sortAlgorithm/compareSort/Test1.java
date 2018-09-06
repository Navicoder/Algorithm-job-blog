package sortAlgorithm.compareSort;

import utils.ArrUtils;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        //int[] arr = ArrUtils.generalRandomOrder(1000000,1000000000);
        int[] arr = ArrUtils.generalNearlyOrder(1000000,1000000000);
        int[] arr0=ArrUtils.copyArr(arr);


        int[] arr2= ArrUtils.copyArr(arr);
        int[] arr3= ArrUtils.copyArr(arr);
       // int[] arr4= ArrUtils.copyArr(arr);
        int[] arr5= ArrUtils.copyArr(arr);
        int[] arr6= ArrUtils.copyArr(arr);
        System.out.println(ArrUtils.ifSame(arr,arr2));
        System.out.println(ArrUtils.ifSame(arr,arr3));
       // System.out.println(ArrUtils.ifSame(arr,arr4));
        System.out.println(ArrUtils.ifSame(arr,arr5));
        System.out.println(ArrUtils.ifSame(arr,arr6));


        long l = System.currentTimeMillis();
        Arrays.sort(arr0);
        System.out.println("Arrays.sort:"+(System.currentTimeMillis() -l)+"ms");

        ShellSort.shellSort(arr5);
        ShellSort.shellSortDichotomy(arr6);
        InsertSort.insertSort(arr3);
        SelectSort.selectSort(arr2);
        BubbleSort.bubbleSort(arr);
        //InsertSort.insertSort2(arr4);

        System.out.println(ArrUtils.ifSame(arr,arr5));
        System.out.println(ArrUtils.ifSame(arr,arr2));
        System.out.println(ArrUtils.ifSame(arr,arr3));
        //System.out.println(ArrUtils.ifSame(arr,arr4));
        System.out.println(ArrUtils.ifSame(arr,arr5));
        System.out.println(ArrUtils.ifSame(arr,arr6));

    }

    /**
     *
     * ArrUtils.generalRandomOrder(1000000,1000000000); 100万 在0~10亿 重复的很少
     *
     * true
     * true
     * true
     * true
     * Arrays.sort:195ms
     * 希尔排序shellSort:280ms,0秒0分钟0小时
     * 希尔排序shellSortDichotomy:350ms,0秒0分钟0小时
     * 插入排序:220921ms,220秒3分钟0小时
     * 选择排序:402014ms,402秒6分钟0小时
     * 冒泡排序:2044056ms,2044秒34分钟0小时
     * true
     * true
     * true
     * true
     *

     *
     * ArrUtils.generalNearlyOrder(1000000,1000000000);100万 在0~10亿 几乎有序
     * true
     * true
     * true
     * true
     * Arrays.sort:8ms
     * 希尔排序shellSort:29ms,0秒0分钟0小时
     * 希尔排序shellSortDichotomy:41ms,0秒0分钟0小时
     * 插入排序:8ms,0秒0分钟0小时
     * 选择排序:167274ms,167秒2分钟0小时
     * 冒泡排序:176085ms,176秒2分钟0小时
     * true
     * true
     * true
     * true
     * true
     *
     *
     */
}
