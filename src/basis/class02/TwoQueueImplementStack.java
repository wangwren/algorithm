package basis.class02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用队列结构实现栈结构
 *
 *  使用两个队列来实现，queue和help，queue用来存放用户存入的数据，当用户想要弹出数据时，
 *  将queue中的数据依次存入help中，但是保留queue中的最后一个数据，留作给用户弹出，
 *  之后将help当做queue，将queue当做help，就实现了栈结构
 */
public class TwoQueueImplementStack {

    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        /**
         * 添加元素
         * @param value
         */
        public void push(T value) {
            queue.offer(value);
        }

        /**
         * 弹出元素
         * @return
         */
        public T poll() {
            if (queue.isEmpty()) {
                throw new RuntimeException("stack is empty!");
            }

            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            //记录下queue中的最后一个值，留做返回
            T ans = queue.poll();

            //互换queue和help
            Queue<T> temp = queue;
            queue = help;
            help = temp;

            return ans;
        }


        /**
         * 返回元素
         * @return
         */
        public T peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("stack is empty!");
            }

            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            //记录下queue中的最后一个值，留做返回
            T ans = queue.poll();
            //该方法只能返回元素，并不弹出，所以需要将ans再加入到help中
            help.offer(ans);

            //互换
            Queue<T> temp = queue;
            queue = help;
            help = temp;

            return ans;
        }


        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        TwoQueueStack<Integer> myStack = new TwoQueueStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");

    }
}
