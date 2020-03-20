package basis.class01;

/**
 * 找一个数组中的最大值，使用递归做
 *
 * 取一个中间值，找到左面的最大值和右面的最大值，将这两个值进行比较，取出最大值
 */
public class GetMax {
    public static int getMax(int[] arr){
        return process(arr,0,arr.length - 1);
    }

    public static int process(int[] arr,int L,int R){
        if (L == R){ //L...R范围上只有一个数，直接返回，递归操作肯定会进入到这一步的
            return arr[L];
        }

        int mid = L + ((R - L) >> 1);
        //找左面最大值
        int leftMax = process(arr,L,mid);
        //找右面最大值
        int rightMax = process(arr,mid + 1,R);

        return Math.max(leftMax,rightMax);
    }
}
