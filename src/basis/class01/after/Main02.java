package basis.class01.after;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Main02 {


    /*public boolean Find(int target, int [][] array) {
        int hang=array[0].length;
        int lie =array.length;

        for(int j=0;j<lie;j++){
            for(int i=0;i<hang;i++){
                if(array[j][i]==target){

                    return true;
                }
            }
        }
        return false;
    }*/


    /*public static void main(String[] args) {
        *//*int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };*//*

        int [][] arr = {};

        int target = 4;

        Main02 main02 = new Main02();
        boolean find = main02.Find(target, arr);
        System.out.println(find);
    }

    public boolean Find(int target, int [][] array) {
        //根据给定的二维数组的特征，先判断第一行中的最后一个数字是否比target大
        //如果target小，那就在第一行中找是否有这个数;
        //如果target大，那就再找第二行，重复做上述操作

        if (array == null || array.length == 0){
            return false;
        }
        int length = array.length;

        for (int i = 0; i < length; i++) {
            //拿到一维数组中最后一个值
            int end = array[i][array[i].length - 1];
            if (target <= end){
                if (target == end){
                    return true;
                }
                //用二分法找
                *//*int find = findMid(0,array[i].length - 1,array[i],target);

                if (target == find){
                    return true;
                }*//*

                for (int j = 0; j < array[i].length; j++) {
                    if (target == array[i][j]){
                        return true;
                    }
                }


            }
        }

        return false;
    }


    public int findMid(int l,int r,int[] arr,int target){
        if (l == r){
            return arr[l];
        }

        int mid = (l + r) >> 1;
        int aims = arr[mid];
        if (target == aims){
            return aims;
        } else if (target < aims){
            return findMid(l,mid,arr,target);
        } else {
            return findMid(mid + 1,r,arr,target);
        }
    }*/
}
