package basis.class02;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小值的功能
 *
 *  pop、push、getMin操作的时间复杂度都是O(1)
 *  设计的栈类型可以使用现有的栈结构
 *
 *  思路：使用两个栈来实现，其中一个栈stackData就是用来存放用户添加的数据，另一个栈stackMin用来存放最小值，
 *      当用户添加第一个值时，stackData存放，stackMin同时也存放
 *      当用户再添加一个值时，stackData存放，此时与stackMin栈顶元素比较，如果新加入的值比栈顶元素小，那么stackMin加入新值，
 *         如果比栈顶元素大，那么stackMin重复加入栈顶元素
 *
 *      如果想要弹出元素，stackData正常弹出元素返回，但是stackMin也要正常弹出，但是不返回，保证stackMin与stackData的数据量同步
 *
 *      当想要知道栈中的最小值时，返回stackMin中的栈顶元素即可，注意是返回，并不弹出元素
 */
public class GetMinStack {

    public static class MyStack {

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        /**
         * 添加元素
         */
        public void push(Integer value) {
            if (stackData.isEmpty()) {
                //如果栈为空，直接添加
                stackMin.push(value);
            } else if(value < stackMin.peek()) {
                stackMin.push(value);
            } else {
                stackMin.push(stackMin.peek());
            }

            stackData.push(value);
        }

        /**
         * 弹出元素
         * @return
         */
        public Integer pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is Empty!");
            }

            stackMin.pop();
            return stackData.pop();
        }

        /**
         * 获取栈中的最小值
         * @return
         */
        public Integer getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is Empty!");
            }

            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(3);
        System.out.println(stack1.getMin());

        stack1.push(4);
        System.out.println(stack1.getMin());

        stack1.push(1);
        System.out.println(stack1.getMin());

        System.out.println(stack1.pop());

        System.out.println(stack1.getMin());

        System.out.println("=============");
    }
}
