package basis;

import java.util.Arrays;

/**
 * 用于验证数组排序的对数器
 */
public class SortLogarithm {
    //暴力，一定正确的排序
    public static void comparator(int[] arr){
        //使用类库中自带的排序来验证
        Arrays.sort(arr);
    }

    //生成随机数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        //定义数组大小
        //Math.random() -> [0,1)所有的小数，等概率返回一个
        //Math.random() * N -> [0,N)所有小数，等概率返回一个
        //(int)(Math.random() * N) -> [0,N-1]所有整数，等概率返回一个
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            //生成随机值
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }

        return arr;
    }

    //拷贝数组
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

    //判断两个数组是否相同
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

    //打印数组
    public static void printArray(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
