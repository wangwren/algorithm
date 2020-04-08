package basis.class05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 */
public class SerializeAndReconstructTree {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 使用先序遍历序列化，以head为头的树，序列化成字符串形式返回
     * @param head
     * @return
     */
    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }

        /*StringBuilder res = new StringBuilder();

        res.append(head.value).append("_");
        res.append(serialByPre(head.left));
        res.append(serialByPre(head.right));*/

        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);

        return res.toString();
    }

    /**
     * 将字符串反序列化为树，通过先序遍历
     * @return
     */
    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }

        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }

        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);

        return head;
    }

    /**
     * 按层遍历，宽度优先
     * @param head
     * @return
     */
    public static String serialByLevel(Node head) {
        if (head == null) {
            return "#_";
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        String res = head.value + "_";

        while (!queue.isEmpty()) {
            head = queue.poll();
            //如果左右子树不为空，加入队列，拼接字符串；如果左右子树为空，不加入队列，只拼接字符串
            if (head.left != null) {
                queue.add(head.left);
                res += head.left.value + "_";
            } else {
                res += "#_";
            }

            if (head.right != null) {
                queue.add(head.right);
                res += head.right.value + "_";
            } else {
                res += "#_";
            }
        }

        return res;
    }

    /**
     * 字符串反序列化，按层
     * @return
     */
    public static Node reconByLevelString(String levelStr) {
        String[] values = levelStr.split("_");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    private static Node generateNodeByString(String value) {
        if ("#".equals(value)) {
            return null;
        }
        return new Node(Integer.valueOf(value));
    }


    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    // for test
    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    // for test
    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        /*head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");
*/
    }
}
