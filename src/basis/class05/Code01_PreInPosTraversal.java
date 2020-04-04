package basis.class05;

import java.util.Stack;

/**
 * 先序、中序、后序遍历
 * 递归、非递归的实现方式
 */
public class Code01_PreInPosTraversal {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 先序遍历，递归方式
     * 头左右
     * @param head 传入头节点
     */
    public static void preOrderRecur(Node head){
        if (head == null) {
            return;
        }

        //先序遍历先打印
        System.out.print(head.value + " ");
        //找左子树
        preOrderRecur(head.left);
        //找右子树
        preOrderRecur(head.right);
    }


    /**
     * 先序遍历，非递归方式
     * 申请一个栈
     * 先序是头左右，所以先往栈中放入头节点，再压入右节点，再压入左节点
     *
     * 栈是先进后出，先压入右节点，那么右节点就会最后出
     * @param head
     */
    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            //先放入头节点
            stack.add(head);
            while (!stack.isEmpty()){
                //如果栈不空

                //弹出，赋值到head上，再从head上找左右子树
                head = stack.pop();
                //打印
                System.out.print(head.value + " ");

                if (head.right != null) {
                    //如果右子树不为空，压栈
                    stack.push(head.right);
                }
                if (head.left != null) {
                    //如果左子树不为空，压栈
                    stack.push(head.left);
                }
            }
        }

        System.out.println();

    }

    /**
     * 中序遍历，递归方式
     * 左头右
     * @param head
     */
    public static void inOrderRecur(Node head){
        if (head == null) {
            return;
        }

        inOrderRecur(head.left);
        //打印
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 中序遍历，非递归方式
     * 申请一个栈
     * 左头右
     *
     * 先将树的左边界全部进栈，当无左边界时，弹出打印，之后去右子树，去右子树重复此操作（左边全部进栈）
     */
    public static void inOrderUnRecur(Node head){
        System.out.println("in-order");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    //每一次的进栈，也都把头节点带进去了
                    stack.push(head);
                    head = head.left;
                } else {
                    //当无左节点时，就会进入else，弹出，打印，去右节点
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }

        System.out.println();
    }

    /**
     * 后序遍历，递归方式
     * @param head
     */
    public static void posOrderRecur(Node head){
        if (head == null) {
            return;
        }

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 后序遍历，非递归方式
     * 申请两个栈，其中一个栈的作用与先序使用的栈相同，另一个栈用作容器
     *
     * 后序是左右头，先序是头左右，把先序的非递归压栈方式改成先压左子树，再压右子树，在先序的打印部分不打印，而是存到另一个栈容器中。
     * 这样先序变成了头右左 的形式放在栈中，此时依次弹出，就是后序。
     * @param head
     */
    public static void posOrderUnRecur(Node head){
        System.out.println("pos-Order");
        if (head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();

            stack1.push(head);

            while (!stack1.isEmpty()) {
                //打印的部分，压入stack2中
                head = stack1.pop();
                stack2.push(head);

                if (head.left != null) {
                    stack1.push(head.left);
                }

                if (head.right != null) {
                    stack1.push(head.right);
                }
            }

            //输出stack2
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().value + " ");
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur(head);

    }
}
