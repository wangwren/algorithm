package basis.class05;

/**
 * 判断一棵树是否是满二叉树
 */
public class IsFull {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 信息，以x为头节点的树的信息
     *
     * 需要知道以x为节点的树，左右子树的高度和节点数，来算出x的高度和节点数
     */
    public static class Info{
        //高度
        int height;
        //节点数
        int nodes;

        public Info(int height,int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }

    /**
     * 对于任何以x为头节点的子树，左右子树返回的都是相同的规则，要求一样，信息确定
     * 对于每个节点要求一样，就可以用递归，对于每个节点都需要返回信息
     * @param head
     * @return
     */
    public static Info process(Node head){

        if (head == null) {
            //如果head为空，很好理解，返回0高度，0个节点
            return new Info(0,0);
        }

        //需要先跟左右子树要信息，才能算出当前head节点的信息

        //左树信息
        Info leftInfo = process(head.left);
        //右树信息
        Info rightInfo = process(head.right);

        //得到了左右子树的信息，当前的head节点也要返回对应的信息啊，需要根据左右子树的信息来计算

        //对于高度，肯定是求左右子树最大值，之后再加1，需要把当前节点自己算进去
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        //对于节点数，需要将左右子树的节点数加起来，再加上自己的1
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;

        return new Info(height,nodes);
    }


    /**
     * 判断是否是满二叉树
     * @param head
     * @return
     */
    public static Boolean isFull(Node head){
        Info info = process(head);
        //得到整颗数的层数
        int L = info.height;
        //得到整棵树的节点数
        int N = info.nodes;

        //满二叉树满足：2^L - 1 = N
        return N == (1 << L) - 1;
    }

}
