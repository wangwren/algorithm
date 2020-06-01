package basis.class02;

/**
 * 删除链表中的指定元素
 */
public class DeleteGivenValue {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 给定头节点，删除对应的value值
     * @param head 头节点
     * @param value 要删除的值
     * @return 返回删除指定值后的头节点
     */
    public static Node removeNode(Node head, int value) {
        while (head != null) {
            //先判断要删除的值是不是头节点
            if (head.value != value) {
                //如果不是头节点，跳出
                break;
            }
            //如果是头节点，头节点下移，相当于删除掉头节点
            head = head.next;
        }

        //head最终是要被返回的
        //cur 记录当前节点
        Node cur = head;
        //记录cur的前一个节点
        Node pre = head;

        //要删除的节点不是头节点
        while (cur != null) {
            if (cur.value == value) {
                //如果等于，cur的前一个节点指向cur的下一个节点
                pre.next = cur.next;
            } else {
                //如果不等，pre来到cur的位置
                pre = cur;
            }
            //cur去下一个节点
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(4);

        head = removeNode(head, 4);
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
    }
}
