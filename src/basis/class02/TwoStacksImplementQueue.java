package basis.class02;

import java.util.Stack;

/**
 * 使用栈结构实现队列
 *
 * 即使用两个栈来实现，stackPush,stackPop
 *  stackPush栈用来存放用户添加的元素，当用户想要弹出元素时，将stackPush中的元素全部倒入stackPop中
 *
 *  但是stackPush倒入stackPop中必须要满足两个条件：
 *      1. stackPop栈中必须为空，才能向里面倒入元素
 *      2. 如果要倒入元素，必须一次性将stackPush中的元素倒完，不能倒入一半
 *
 *  保证以上条件后，再何时倒入数据都可以了
 */
public class TwoStacksImplementQueue {

    public static class TwoStacksQueue {

        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        /**
         * push栈向pop栈倒入数据
         */
        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        /**
         * 添加元素
         * @param value
         */
        public void add(Integer value) {
            stackPush.push(value);
            pushToPop();
        }

        /**
         * 弹出元素
         * @return
         */
        public Integer poll() {

            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is Empty!");
            }

            pushToPop();
            return stackPop.pop();
        }

        /**
         * 返回元素
         * @return
         */
        public Integer peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is Empty!");
            }

            pushToPop();
            return stackPop.peek();
        }
    }


    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
