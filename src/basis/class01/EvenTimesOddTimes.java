package basis.class01;

/**
 * 异或运算的应用
 */
public class EvenTimesOddTimes {

    /**
     * arr中，只有一种数出现了奇数次，其余的数出现了偶数次，打印出出现奇数次的数
     *
     * 定义一个变量eor = 0，分别与数组中的每个数做异或运算，最后eor的值就是要求的值
     * 运用了异或运算的交换律和结合律，偶数次的数异或最终都是0
     */
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    /**
     * arr中，有两种数出现了奇数次，其余数都出现了偶数次，打印出这两个数。
     *
     * 假设a，b为这两个数
     * int eor = 0,===> eor = a ^ b ===> a和b出现奇数次，a和b肯定不相等，那么此时 eor 肯定不等于 0，那么根据异或运算的性质，
     *  eor 上肯定有 1，那么a和b在某个位置上肯定不相同，一个为1，一个为0 ====>
     *  设在 x 位置上有 1，那么arr数组就可以分为在 x 位置上有1，和 x 位置上没有 1；
     * 求出 eor=a^b的最右侧的1，值为eor'，之后定义一个新变量onlyOne=0 与arr数组分类中x位置上有1的值做异或，求出a或b
     *  以上操作就是分隔开a 和 b,此时onlyOne已经是a 或 b 了（假如onlyOne=a），之后再试用 eor ^ onlyOne = a^b^a=b
     *
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //此时eor的值为 a ^ b,求eor最右侧为1的值
        int rightOne = eor & ((~eor) + 1);
        int onlyOne = 0;
        //假如： eor'   0001000
        //     &arr[i] 0101010
        //             0001000  如果 x 位置上是1，结果就不是0，如果不是1结果就是0

        for (int i = 0; i < arr.length; i++) {
            //也可以是等于0，也可以等于0
            if ((rightOne & arr[i]) != 0) {
                //如果不是 x 位置上是1，就做异或操作
                onlyOne ^= arr[i];
            }
        }

        //onlyOne最终值为a或是b,再与eor做异或运算得到b或a，最终得到结果,整个时间复杂度为O(n)
        System.out.println(onlyOne + " " + (onlyOne ^ eor));
    }


    public static void main(String[] args) {
        /*int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);*/

        //只有2出现了奇数次
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        //3  2
        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);
    }
}
