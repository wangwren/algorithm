package basis.class05.after;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        List<Integer> list = inorderTraversal(node);

        System.out.println();
    }
}
