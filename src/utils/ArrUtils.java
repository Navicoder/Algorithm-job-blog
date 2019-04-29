package utils;

import java.util.Random;

/**
 * 数组工具类
 */
public class ArrUtils {
    static Random r = new Random();

    /**
     * 不包括临界点
     * @param size
     * @param end
     * @return
     */
    public static int[] generalRandomOrder(int size,int end){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(end);
        }
        return arr;
    }
    /**
     * 不包括临界点 产生几乎有序的数据
     * @param size
     * @param sizeRandom 随机乱序的个数
     * @return
     */
    public static int[] generalNearlyOrder(int size,int sizeRandom){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        //sizeRandom个乱序的
        for (int i = 0; i < sizeRandom; i++) {
            int ra = r.nextInt(size-1);
            arr[ra] = ra;
        }
        return arr;
    }

    /**
     * 把数组i位置的元素替换成j位置的元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j){
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] =a;
    }
    public static void printArr(int[] arr){
        System.out.println("数组大小:"+arr.length);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static boolean ifSame(int[] arr1,int[] arr2){
        boolean flag =true;
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length ; i++) {
                if (arr1[i] != arr2[i]) {
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }
    public static int[] copyArr(int[] arr){
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            arr2[i] =arr[i];
        }
        return arr2;
    }

    public static void main(String[] args) {
        int[] arr =  generalRandomOrder(2,45);
        printArr(arr);
        swap(arr, 0,1);
        printArr(arr);
    }
}
