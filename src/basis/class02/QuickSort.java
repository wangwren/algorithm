package basis.class02;

import basis.SortLogarithm;


/**
 * 随机快排
 */
public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr,0,arr.length - 1);
    }

    //arr[L...R]排好序
    private static void quickSort(int[] arr,int L,int R){
        if (L < R){
            //随机生成一个在arr数组范围内的数，与最后一个位置上的值交换。之后最后一个值就是需要比较的指定值
            swap(arr,L + (int) (Math.random() * (R - L + 1)),R);
            //最后一个值为指定值
            int num = arr[R];
            int[] res = partition(arr, L, R,num);

            //递归调用
            quickSort(arr,L,res[0] - 1);
            quickSort(arr,res[1] + 1 ,R);
        }
    }

    /**
     * arr[R]为指定值。与荷兰国旗的partition差不多。
     * 区别在more = R，荷兰国旗是more = R - 1.
     */
    private static int[] partition(int[] arr,int L,int R){
        int less = L - 1;
        int more = R;
        while (L < more){
            if (arr[L] < arr[R]){
                swap(arr,++less,L++);
            } else if (arr[L] > arr[R]){
                swap(arr,--more,L);
            } else {
                L++;
            }
        }
        //由于more最开始是从R位置划分，与荷兰国旗代码有区别，R的位置一直是指定的数，所以最后需要单独给R的位置做替换
        swap(arr,more,R);
        return new int[]{less + 1,more};
    }

    //与荷兰国旗一样的partition。num为指定值
    public static int[] partition(int[] arr,int L,int R,int num){
        int less = L - 1;
        int more = R + 1;
        while (L < more){
            if (arr[L] < num){
                swap(arr,++less,L++);
            } else if (arr[L] > num){
                swap(arr,--more,L);
            } else {
                L++;
            }
        }
        return new int[]{less + 1,more - 1};
    }

    private static void swap(int arr[],int i,int j){
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
            quickSort(arr1);
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
