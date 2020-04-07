package basis.class05;

import com.sun.istack.internal.localization.NullLocalizable;
import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是完全二叉树
 */
public class IsCBT {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 使用宽度优先遍历
     * @param head
     * @return
     */
    public static boolean isBST(Node head){
        if (head == null) {
            return true;
        }

        //队列
        Queue<Node> queue = new LinkedList<>();
        //是否遇到过左右两个孩子不双全的节点，默认为false
        boolean isMeet = false;
        //左孩子
        Node left = null;
        //右孩子
        Node right = null;

        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            //左孩子
            left = head.left;
            //右孩子
            right = head.right;

            //如果无左节点，有右节点;或者遇到了左右孩子不双全的节点后，别的节点还有左右还自己
            if ((left == null && right != null) || (isMeet && !(left == null && right == null))) {
                return false;
            }

            //如果左孩子不为空，加入队列
            if (left != null) {
                queue.add(left);
            }
            //如果右孩子不为空，加入队列
            if (right != null) {
                queue.add(right);
            }

            //如果遇到了左右两个孩子不双全的节点,有可能左节点不为空，右节点为空，那么剩下的就应该是叶子节点
            if (left == null || right == null) {
                isMeet = true;
            }
        }

        return true;
    }
}
