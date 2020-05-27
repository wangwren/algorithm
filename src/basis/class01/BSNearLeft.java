package basis.class01;

/**
 * 使用二分，查找>=某个数最左侧的位置
 */
public class BSNearLeft {
    public static int nearLeft(int[] sortArray,int num){
        int L = 0;
        int R = sortArray.length - 1;
        int index = -1; //记录最左的位置
        while (L <= R){
            int mid = (L + (R - L) >> 1); //mid = (L + R) / 2; R - L是距离，R - L一半的距离加上L，就是中点
            if (sortArray[mid] >= num){
                //如果大于等于num，就记录一下这个位置，之后继续循环找
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return index;
    }
}
