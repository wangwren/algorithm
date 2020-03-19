package basis.class01;

import java.util.Arrays;

/**
 * 选择排序:
 *      线性搜索数列并找到最小值。将最小值替换为列中左端的数字并进行排序。
 *      如果最小值已经在左端，则不执行任何操作。
 *      重复相同操作，直到所有数字都被排序。
 *
 * 时间复杂度O(N^2);额外空间复杂度O(1)
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) { //i ~ N-1
            //最小值下标，初始值为i
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //找 i~ N-1上最小值的下标，循环一圈找到最小值再替换
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //循环完成后，做交换
            swap(arr,i,minIndex);
        }
    }

    /**
     * 交换
     */
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    //test
    public static void comparator(int[] arr){
        //使用类库中自带的排序来验证
        Arrays.sort(arr);
    }

    //test 生成随机数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        //定义数组大小
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            //生成随机值
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }

        return arr;
    }

    //test 拷贝数组
    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    //test 判断两个数组是否相同
    public static boolean isEqual(int[] arr1,int [] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }

        if (arr1 == null && arr2 == null){
            return true;
        }

        if (arr1.length != arr2.length){
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }

    //test 打印数组
    public static void printArray(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //测试次数
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean flag = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);

            //排序
            selectionSort(arr1);
            comparator(arr2);

            if (!isEqual(arr1,arr2)){
                flag = false;
                //失败打印两个数组
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println(flag ? "Nice!" : "Fucking fucked!");
    }
}
