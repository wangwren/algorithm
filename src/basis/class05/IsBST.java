package basis.class05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 如果判断一颗二叉树是搜索二叉树(经典的搜索二叉树是没有相等的值)
 *
 * 最简单的方式是使用中序遍历，因为中序遍历得到的值是先得到左节点，这样得到的值的顺序一定是单调递增的
 */
public class IsBST {

    public static class Node{
        int valuel;
        Node left;
        Node right;

        public Node(int value){
            this.valuel = value;
        }
    }


    /**
     * 使用中序遍历的方式判断是否是搜索二叉树
     */
    public static void isBST1(Node head){
        Queue<Node> queue = new LinkedList<>();
        f(head,queue);

        //最后检查queue依次弹出，是否是单调递增的就可以了
    }

    public static void f(Node head,Queue<Node> queue){
        if (head == null){
            return;
        }

        //中序遍历
        f(head.left,queue);
        //该打印的时候，存入容器
        queue.add(head);
        f(head.right,queue);
    }


    /**
     * 二叉树的递归套路做法
     * x为头的树
     * 可能性：
     * 1.左树需要是搜索二叉树
     * 2.右树需要是搜索二叉树
     * 3.左树上的最大值要小于x上的value；右树上的最小值要大于x上的value
     *
     * 需要提供的信息，需要知道左右子树是否是搜索二叉树 boolean isBST；
     *  左树还需要提供这个树上最大值 int max；右树需要提供这棵树上的最小值 int min
     *
     *
     * 左右树要求不一样，信息取全集，即只要是子树，返回是否是isBST，max，min
     */
    public static class Info{
        boolean isBST;
        int max;
        int min;

        public Info(boolean isBST,int max,int min){
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    //主函数
    public static boolean isBST(Node head){
        if (head == null){
            return true;
        }

        Info info = process(head);
        return info.isBST;
    }


    private static Info process(Node head){
        if (head == null){
            //如果为空，对于是否是搜索二叉树，最大值，最小值都不好确定，那么就返回空信息
            return null;
        }

        //要左树信息
        Info leftInfo = process(head.left);
        //要右树信息
        Info rightInfo = process(head.right);


        //通过左左右子树的信息，来确定当前节点的信息

        //我的最小值,先默认为当前节点值
        int min = head.valuel;

        //我的最大值
        int max = head.valuel;

        //如果左树的信息不等于空，说明左树右东西,信息可用
        if (leftInfo != null) {
            //这里需要判断左树是否为空，因为head为null时，返回的是空，所以要加判断
            min = Math.min(min,leftInfo.min);
            max = Math.max(max,leftInfo.max);
        }

        //右树
        if (rightInfo != null){
            min = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
        }

        //我是不是搜索二叉树,先默认为true，是搜索二叉树
        boolean isBST = true;
        //如果我左树信息不为空，并且左树信息在左树上已经不是搜索二叉树了，isBST = false,或者左树的最大值大于等于当前节点的值就违规
        if (leftInfo != null && (!leftInfo.isBST || leftInfo.max >= head.valuel)){
            isBST = false;
        }

        //右边与左边同理
        if (rightInfo != null && (!rightInfo.isBST || rightInfo.min <= head.valuel)){
            isBST = false;
        }

        //如果以上两个if都没中，那么就维持isBST = true的状态

        return new Info(isBST,max,min);
    }

}
