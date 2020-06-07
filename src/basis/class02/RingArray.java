package basis.class02;

/**
 * 使用固定数组大小实现队列
 *  使用数组实现队列很麻烦，需要两个变量来记录位置，即第一次加入元素的位置pushi;和弹出元素的位置popi
 *  而且，如果弹出的话，第一个数组位置就为空，那popi位置达到数组最后一个元素后，其实还是可以继续添加元素的，因为元素的第一个位置为空，
 *  那么就需要判断pushi和popi的关系。
 *  这时如果再定一个变量size，用来记录此时数组中真正元素的个数，就好办多了
 *
 *
 * 使用固定数组大小实现栈很好实现，定义一个变量index记录下一个添加元素的位置即可，当要弹出数据时就弹出index - 1位置上的数据
 */
public class RingArray {
    public static class MyQueue {
        //固定大小的数组
        private int[] arr;
        //添加元素的位置
        private int pushi;
        //弹出元素的位置
        private int popi;
        //此时的大小，添加就++ ，弹出就--
        private int size;
        //数组大小
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            popi = 0;
            size = 0;
            this.limit = limit;
        }

        /**
         * 向队列中添加元素
         * @param value
         */
        public void push(int value) {
            //先判断队列中是否已满
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了！");
            }

            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        /**
         * 弹出元素
         * @return
         */
        public int poll() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了！");
            }

            size--;
            int ans = arr[popi];
            popi = nextIndex(popi);

            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }


        /**
         * 如果现在的下标是i，返回下一个位置
         * 因为这是一个循环的数组队列
         * @param i
         * @return
         */
        public int nextIndex(int i){
            return i < limit - 1 ? i + 1 : 0;
        }
    }
}
