package basis.class05;

/**
 * 在二叉树的中序遍历的序列中，node的下一个节点叫作node的后继节点
 */
public class SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val) {
            this.value = val;
        }
    }

    /**
     * 获取node的后继节点，node为任意一个节点
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }

        if (node.right != null) {
            //如果node有右子树，那么右子树中的左树的第一个值就是node的后继
            return getLeftMost(node.right);
        } else {
            //如果node无右子树，那就找node的父节点，找到node的父节点的使node是其左子树，那么该parent节点是node的后继
            //如果node就是中序遍历的最后一个值，那么没有后继
            Node parent = node.parent;
            if (parent != null && parent.right == node) {
                //当前节点是其父亲节点的右孩子，那就一直向上找，找到是左孩子，那么父节点就是后续，如果找到后是null，那么node没有后继
                parent = parent.parent;
            }
            return parent;
        }
    }

    /**
     * 获取最左树的值
     * @param node
     * @return
     */
    private static Node getLeftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
