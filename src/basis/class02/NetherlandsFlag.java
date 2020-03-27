package basis.class02;

/**
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num
 * ，请把小于num的数放在数组的左边
 * ，等于num的数放在数组的中间
 * ，大于num的数放在数组的右边。
 *
 * 要求额外空间复杂度O(1)，时间复杂度O(N)。
 */
public class NetherlandsFlag {
    public static int[] partition(int[] arr,int L,int R,int p){
        //左边界
        int less = L - 1;
        //右边届
        int more = R + 1;

        while (L < more){ //L是当前数的下标
            if (arr[L] < p){
                //如果小于指定数，先将less+1，再与L位置交换，之后L+1。
                swap(arr,++less,L++);
            } else if (arr[L] > p){
                //如果大于指定数，more-1，再与L位置交换，之后L不动。因为交换后的L位置上的数还是需要和指定的数比较的
                swap(arr,--more,L);
            } else {
                //如果等于指定数，L+1，别的都不动
                L++;
            }
        }

        //返回左边界和右边界
        return new int[]{less + 1,more - 1};
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
