package basis.class05;

/**
 * 折纸问题
 *
 * 自己拿出一张纸折一下，折纸次数N，与折痕L 满足： 2^N - 1 = L，即满二叉树
 * 而且该二叉树中任意一个节点的左孩子都是down，右孩子都是up
 *
 *
 * 空间复杂度 O(N)
 *
 * 如果自己构造一个二叉树再打印，那么就需要空间复杂度O(2^N -1)
 */
public class PaperFolding {
    public static void printAllFolds(int N) {
        process(1,N,true);
    }

    //递归过程，来到某一个节点
    //i 是当前节点层数，N一共的层数， flag = true 表示down；flag = false 表示up
    private static void process(int i, int N, boolean flag) {
        if (i > N) {
            return;
        }

        //左节点
        process(i + 1,N,true);

        System.out.println(flag ? "down" : "up");

        //右节点
        process(i + 1,N,false);
    }

    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }
}
