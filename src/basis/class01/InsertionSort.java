package basis.class01;

import basis.SortLogarithm;

/**
 * 插入排序：
 *      首先，左端的数字已完成排序，从第二个数开始，与前面的数比较，如果小就交换，还是这个数，一直与前面的比较，直到不能交换为止，
 *      换第三个值，重复上述操作。
 *
 * 时间复杂度O(N^2);额外空间复杂度O(1)
 * 看数据规模，按最坏的情况来估算，这种排序好于冒泡和选择
 */
public class InsertionSort {
    public static void insertionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                //这里注意，是j和j+1进行比较，虽然第一次j+1=i，但是如果用i和j比较，第一次如果交换位置了，那么i上的值已经发生了变化，
                //就已经不是最开始的i的值了
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        //测试次数
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean flag = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = SortLogarithm.generateRandomArray(maxSize,maxValue);
            int[] arr2 = SortLogarithm.copyArray(arr1);

            //排序
            insertionSort(arr1);
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
