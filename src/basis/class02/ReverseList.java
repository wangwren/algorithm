package basis.class02;

/**
 * 链表反转
 *
 * 时间复杂度O(N)
 * 额外空间复杂度O(1)
 */
public class ReverseList {
    //单链表结构
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    /**
     * 单链表反转,画图就会明白
     * @param head 传入头节点
     * @return 返回一个节点
     */
    public static Node reverseList(Node head) {
        //记录下一个节点
        Node next = null;
        //记录
        Node pre = null;

        while (head != null) {
            //记录head的下一个节点
            next = head.next;

            //之后将head的next指向pre，即将原始的连接断开；第一次进循环，head的下一个节点需要指向null，是连接断了，不是将下一个节点赋值为空了
            head.next = pre;

            //将此时的head赋值给pre
            pre = head;

            //head往下走
            head = next;
        }

        return pre;
    }

    /**
     * 双向链表结构
     */
    public static class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 反转双向链表，单链表弄懂了，双向链表就懂了
     * @param head
     * @return
     */
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode next = null;
        DoubleNode pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));

    }
}
