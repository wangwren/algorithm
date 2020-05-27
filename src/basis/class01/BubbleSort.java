package basis.class01;

import basis.SortLogarithm;

/**
 * 冒泡排序
 * 时间复杂度O(N^2);额外空间复杂度O(1)
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        //从前往后，将大的值向后放
        /*for (int i = arr.length - 1; i > 0; i--) { // 确定 i
            for (int j = 0; j < i; j++) { //保证0 ~ i 上i的值最大
                if (arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                }
            }
            //第一次内部循环一次之后，能确定数组的最后一个值就是最大值，重复这个操作
        }*/
        
        //从后往前，将小的值向前放
        for (int i = 0; i < arr.length; i++) { //确定 i
            for (int j = arr.length - 1; j > i; j--) { //保证 i ~ N 上 i 位置最小
                //每次都是两个值比较，如果前面值大，就交换
                if (arr[j - 1] > arr[j]){
                    swap(arr,j - 1,j);
                }
            }
            //第一次内部循环一次后，能确定数组的第一个值是最小值，重复这个操作
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        //使用 ^ 异或交换两个值;
        // 使用这种方式，i和j不能相同，数组下标指的的内存地址相同，所以i,j不能相同；如果相同，指的是相同的内存地址，值会变成0
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
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
            bubbleSort(arr1);
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
