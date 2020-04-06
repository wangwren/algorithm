package basis.class05;

/**
 * 判断是否是平衡二叉树
 *
 * 1.左树是平衡二叉树
 * 2.右树是平衡二叉树
 * 3.左右子树的高度差的绝对值 <= 1
 *
 * 左右子树信息，是否是平衡二叉树，高度，信息即要求
 */
public class IsBalancedTree {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static class Info{
        int height;
        boolean flag;

        public Info(int height,boolean flag){
            this.height = height;
            this.flag = flag;
        }
    }

    private static Info process(Node head){
        if (head == null){
            //如果为空时，高度为0，默认平衡
            return new Info(0,true);
        }

        //左树信息
        Info leftInfo = process(head.left);
        //右树信息
        Info rightInfo = process(head.right);

        //我的高度,左右子树的高度的最大值，再加上自己
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;

        //我是不是平衡，默认平衡
        boolean flag = true;

        if (!leftInfo.flag || !leftInfo.flag) {
            //如果左子树不平衡，或者右子树不平衡，那我自己就不平衡
            flag = false;
        }

        if (Math.abs(leftInfo.height - rightInfo.height) > 1){
            //如果左子树高度减右子树高度差绝对差大于1
            flag = false;
        }


        return new Info(height,flag);
    }
}
