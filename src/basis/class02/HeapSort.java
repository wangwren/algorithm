package basis.class02;

import basis.SortLogarithm;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 1){
            return;
        }
        //使用heapInsert实现大根堆
        for (int i = 0; i < arr.length; i++) { //O(N)
            heapInsert(arr,i); // O(logN)
        }

        //形成大根堆后，将根顶与最后一个交换，保证数组中最后一个值最大，之后对根顶做heapify操作
        int heapLength = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            //交换
            swap(arr,0,i);
            heapLength--;
            heapify(arr,0,heapLength);
        }
    }

    //给定数组形成大根堆的过程
    private static void heapInsert(int[] arr, int i) {
        //一直与其父节点比较，直到小于父节点或已经达到最顶部停
        while (arr[i] > arr[(i - 1) / 2]){
            swap(arr,i,(i - 1) / 2);
            //交换后，将i指定到其父节点位置，继续判断
            i = (i - 1) / 2;
        }
    }

    //heapfiy过程，此时arr已经是一个大根堆
    private static void heapify(int[] arr,int index, int heapLength){
        //记录当前要做heapify的位置，默认从头开始
        int left = 2 * index + 1;
        //如果下方还有孩子的时候
        while (left < heapLength){
            int right = left + 1;
            //找出左右子树的最大值对应的索引。如果右子树不超过数组长度并且右子树比左子树大，返回右子树下标；否则返回左子树
            int maxIndex = left + 1 < heapLength && arr[right] > arr[left] ? right : left;
            //比较父和较大的孩子谁大，谁大就把下标给maxIndex
            maxIndex = arr[index] > arr[maxIndex] ? index : maxIndex;
            if (maxIndex == index){
                //父比孩子大，跳出循环，不需要继续heapify
                break;
            }

            //否则交换
            swap(arr,index,maxIndex);
            index = maxIndex;
            left = 2 * index + 1;
        }
    }

    //交换
    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
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
            heapSort(arr1);
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
