package basis.class02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 双向链表实现栈和队列
 */
public class DoubleEndsQueueToStackAndQueue {

    /**
     * 双向链表
     * @param <T>
     */
    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node (T value){
            this.value = value;
        }
    }

    /**
     * 实现双向链表的方法
     */
    public static class DoubleEndsQueue<T> {

        //头指针
        public Node<T> head;

        //尾指针

        public Node<T> tail;

        /**
         * 从头部加入数据
         * @param value
         */
        public void addFromHead(T value) {
            Node<T> cur = new Node<>(value);

            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                //如果头部节点不为空，那么表示链表已经存在数据，需要换头
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        /**
         * 从尾部加入数据
         * @param value
         */
        public void addFromBottom(T value) {
            Node<T> cur = new Node<>(value);

            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
        }

        /**
         * 从头部弹出数据
         */
        public T popFromHead() {
            if (head == null) {
                return null;
            }

            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                //由于是双向链表，需要断开前后节点，否则jvm不会自动释放，因为一直有引用存在
                head.last = null;
                cur.next = null;
            }

            return cur.value;
        }


        /**
         * 从底部弹出数据
         * @return
         */
        public T popFromBottom() {
            if (head == null) {
                return null;
            }

            Node<T> cur = tail;

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }

            return cur.value;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }


    /**
     * 根据上面封装的方法实现栈
     * 栈：先进后出
     *
     * 所以只需要上面的两个方法就可以实现，即从头部进，从头部出;或从底部进，从底部出
     * @param <T>
     */
    public static class MyStack<T> {

        private DoubleEndsQueue<T> stack;

        public MyStack (){
            stack = new DoubleEndsQueue();
        }

        /**
         * 添加元素
         * @param value
         */
        public void push(T value) {
            stack.addFromHead(value);
        }

        /**
         * 弹出元素
         * @return
         */
        public T pop() {
            return stack.popFromHead();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }


    /**
     * 根据上面封装的方法实现队列
     * 队列：先进后出
     *
     * 所以只需要上面两个方法就可以实现，即从头部进，从底部出;或从底部进，从头部出
     * @param <T>
     */
    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<>();
        }

        /**
         * 添加元素
         * @param value
         */
        public void push(T value) {
            queue.addFromHead(value);
        }

        /**
         * 弹出元素
         * @return
         */
        public T poll() {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }



    //测试

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }


    //对数器，验证手撸的栈和队列
    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();

            //系统提供的栈和队列
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}
