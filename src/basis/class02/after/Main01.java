package basis.class02.after;

import java.util.Scanner;

/**
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
 *
 * 接口说明
 * 原型：
 * void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag);
 *
 * 输入参数：
 * Integer[] pIntegerArray：整型数组
 * int  iSortFlag：排序标识：0表示按升序，1表示按降序
 *
 * 输出参数：
 * 无
 * 返回值：
 * void
 *
 *
 * 示例1
 * 输入
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 输出
 * 1 2 3 4 9 25 55 64
 */
public class Main01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组的大小
        Integer num = 0;
        //排序标识
        Integer flag = 0;

        while (sc.hasNext()){
            //输入数组大小
            num = sc.nextInt();
            //输入值
            Integer[] arr = new Integer[num];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            //输入排序标识
            flag = sc.nextInt();

            //排序
            sortIntegerArray(arr,flag);

            //输出
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 排序
     * @param arr 输入的数组
     * @param iSortFlag 排序标识：0表示按升序，1表示按降序
     */
    public static void sortIntegerArray(Integer[] arr, int iSortFlag){
        //用插入吧
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (arr[j] > arr[j + 1] && iSortFlag == 0){
                    swap(arr,j,j + 1);
                } else if (arr[j] < arr[j + 1] && iSortFlag == 1){
                    swap(arr,j,j + 1);
                }
            }
        }
    }

    public static void swap(Integer[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
