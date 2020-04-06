package basis.class05;

/**
 * 给定两个二叉树的节点node1和node2，找到他们的最低公共祖先节点
 *
 * 对于每一颗子树，有无node1。
 * 对于每一颗子树，有无node2。
 * 你发现的最低公共祖先是谁(前两个为true的情况)
 */
public class LowestCommonAncestor {

    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static class Info{
        boolean hasO1;
        boolean hasO2;
        //最低公共祖先
        Node ans;

        public Info(boolean hasO1,boolean hasO2,Node ans) {
            this.hasO1 = hasO1;
            this.hasO2 = hasO2;

            this.ans = ans;
        }
    }

    //主函数
    public static Node lowestAncestor(Node head,Node node1,Node node2){
        if (head == null || head == node1 || head == node2) {
            return head;
        }

        return process(head,node1,node2).ans;
    }

    private static Info process(Node x,Node node1,Node node2) {

        if (x == null){
            return new Info(false,false,null);
        }

        Info leftInfo = process(x.left,node1,node2);
        Info rightInfo = process(x.right,node1,node2);

        //如果 x 就是node1 或者我左树发现node1，或者我右树发现node1
        boolean hasO1 = (x == node1) || leftInfo.hasO1 || rightInfo.hasO1;
        //node2同理
        boolean hasO2 = (x == node2) || leftInfo.hasO2 || rightInfo.hasO2;

        //默认最低公共祖先为null
        Node ans = null;

        //如果左树的ans不为null，所以答案与左树一致；同理右树
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        }
        if (rightInfo.ans != null){
            ans = rightInfo.ans;
        }

        //左树答案与右树答案不可能同时不为空，要么左树有，要么右树有；但是左右能同时空
        if (leftInfo.ans == null && rightInfo.ans == null) {
            if (hasO1 && hasO2){
                //左树没有ans，右树也没有ans，但是整颗树已经发现全了，hasO1为true，hasO2也为true
                ans = x;
            }
        }

        return new Info(hasO1,hasO2,ans);
    }
}
