package basis.class02;

import basis.SortLogarithm;

/**
 * 归并排序
 *  将数组分两半，结合分割进行合并，按照数字的升序移动，使得合并后的数字在组内按升序排列。
 *  合并一组中包含多个数字时，比较开头的数字，移动较小的数字。
 *  递归地重复组合并操作，知道所有的数字都在一个组中。
 *
 *  时间复杂度：O(N*logN);额外空间复杂度O(N)，合并时开辟了一个新数组
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr,0,arr.length - 1);
    }

    public static void process(int[] arr,int L,int R){
        if (L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        //分割左边
        process(arr,L,mid);
        //分割右边
        process(arr,mid + 1,R);

        //合并
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr,int L,int M,int R){
        //开辟一个新数组,注意这里开辟新数组的大小
        int[] help = new int[R - L + 1];

        //记录新数组的位置
        int i = 0;
        //记录位置
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R){
            //每次将小的值放前
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //上面的while循环走完之后，左面或者右面肯定会有剩下的值没有进到help数组中，但是这时左右都已经是有序的了，直接放就行
        while (p1 <= M){
            help[i++] = arr[p1++];
        }

        while (p2 <= R){
            help[i++] = arr[p2++];
        }

        //最终将help中的值赋值到arr中，因为L不一定就是0开始，所以从L + i开始赋值；i重新赋值0
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
        /*int[] arr = {2,7,4,9,3,6};

        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();*/

        //测试次数
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean flag = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = SortLogarithm.generateRandomArray(maxSize,maxValue);
            int[] arr2 = SortLogarithm.copyArray(arr1);

            //排序
            mergeSort(arr1);
            SortLogarithm.comparator(arr2);

            if (!SortLogarithm.isEqual(arr1,arr2)){
                flag = false;
                //失败打印两个数组
                SortLogarithm.printArray(arr1);
                SortLogarithm.printArray(arr2);
                break;
            }
        }

        System.out.println(flag ? "Nice!" : "Fucking fucked!");
    }
}
