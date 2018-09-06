package sortAlgorithm.compareSort;

<<<<<<< HEAD
import jdk.nashorn.tools.Shell;
=======
>>>>>>> ccc025ff86bafdcf795c828a02efb80f756bafea
import utils.ArrUtils;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = ArrUtils.generalRandomOrder(1000000,1000000000);
        //int[] arr = ArrUtils.generalNearlyOrder(1000000,1000000000);

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
<<<<<<< HEAD
     *  【1】ArrUtils.generalRandomOrder(1000000,89602);100万 在0~9万之间 有很多重复的
     * true
     * true
     * 冒泡排序:2131509ms 2131秒 35分钟
     * 选择排序:397783ms  397秒  6分钟
     * 插入排序:256444ms  256秒  4分钟
     * true
     * true
=======
>>>>>>> ccc025ff86bafdcf795c828a02efb80f756bafea
     *
     * ArrUtils.generalRandomOrder(1000000,1000000000); 100万 在0~10亿 重复的很少
     *
     * true
     * true
     * true
<<<<<<< HEAD
     * 希尔排序:274ms,0秒0分钟0小时
     * 插入排序:206259ms,206秒3分钟0小时
     * 选择排序:376675ms,376秒6分钟0小时
     * 冒泡排序:2018527ms,2018秒33分钟0小时
=======
     * true
     * Arrays.sort:195ms
     * 希尔排序shellSort:280ms,0秒0分钟0小时
     * 希尔排序shellSortDichotomy:350ms,0秒0分钟0小时
     * 插入排序:220921ms,220秒3分钟0小时
     * 选择排序:402014ms,402秒6分钟0小时
     * 冒泡排序:2044056ms,2044秒34分钟0小时
     * true
>>>>>>> ccc025ff86bafdcf795c828a02efb80f756bafea
     * true
     * true
     * true
     *
<<<<<<< HEAD
     * ArrUtils.generalRandomOrder(10000,1000000000);1 万 在0~10亿 几乎没有重复的
     *
     * true
     * true
     * true
     * 希尔排序:5ms,0秒0分钟0小时
     * 插入排序:37ms,0秒0分钟0小时
     * 选择排序:54ms,0秒0分钟0小时
     * 冒泡排序:208ms,0秒0分钟0小时
     * true
     * true
     * true
     *
     *
     * ArrUtils.generalNearlyOrder(1000000,1000000000);100万 在0~10亿 几乎有序
     * true
     * true
     * 插入排序:6ms,0秒0分钟0小时
     * 选择排序:159296ms,159秒2分钟0小时
     * 冒泡排序:183095ms,183秒3分钟0小时
     * true
     * true
     *
=======

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
>>>>>>> ccc025ff86bafdcf795c828a02efb80f756bafea
     */
}
