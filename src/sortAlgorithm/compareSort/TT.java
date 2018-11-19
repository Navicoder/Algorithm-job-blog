package sortAlgorithm.compareSort;

import utils.ArrUtils;

public class TT {

   private static void quicksort(int[] arr,int left,int right){

       if(left>right)
            return;
       int temp=arr[left]; //temp中存的就是基准数
       int i=left,j=right;
       while(i!=j){//4 继续向中间靠拢，直至汇合。
            //1 顺序很重要，要先从右边开始找,直至找到比temp即[子]数组的左边界小的位置
            while(arr[j]>=temp && i<j)
                j--;
            //2 再找左边的,直至找到比temp即[子]数组的左边界大的位置
            while(arr[i]<=temp && i<j)
                i++;
            //3 交换两个数在数组中的位置
            if(i<j){
               ArrUtils.swap(arr,i,j);
            }
       }
        //5 完成基准数和i与j交汇的值互换，最终将基准数归位,实现了[left,right]数组在基准数左边的都比基准数小，右边的都比基准数大
        arr[left]=arr[i];
        arr[i]=temp;


        quicksort(arr,left,i-1);//6 继续处理左边的，这里是一个递归的过程
        quicksort(arr,i+1,right);//6 继续处理右边的 ，这里是一个递归的过程
    }
   public static void quicksort(int[] arr) {
        long l = System.currentTimeMillis();
        quicksort(arr,0,arr.length-1);
        long ll = System.currentTimeMillis()-l;
        System.out.println("快速排序quicksort:size():"+arr.length+"耗时:"+(ll)+"ms,"+(ll/1000)+"秒"+(ll/1000/60)+"分钟"+(ll/1000/60/60)+"小时");
   }



    public static void main(String[] args) {
        int[] arr = ArrUtils.generalRandomOrder(100000,Integer.MAX_VALUE);//2147483647- 21亿
        int[] arr2 = ArrUtils.copyArr(arr);
        TT.quicksort(arr);
        MergeSort.MergeSortRecursion(arr2);

        System.out.println(ArrUtils.ifSame(arr,arr2));
    }

}
