package basis.class01;

/**
 * 二分法：
 *      从有序数组中搜索元素
 */
public class BSExist {
    public static boolean exist(int[] sortArr,int num){
        int L = 0;
        int R = sortArr.length - 1;

        while (L < R){
            int mid = L + ((R - L) >> 1); //mid = (L + R) / 2; R - L是距离，R - L一半的距离加上L，就是中点
            if (sortArr[mid] == num){
                return true;
            } else if (sortArr[mid] > num){
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return sortArr[L] == num;
    }
}
