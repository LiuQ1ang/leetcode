package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: liuqiang
 * @create: 2020-05-22 20:58
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * <p>
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> subResults = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur;
                if (flag) {
                    cur = queue.pollLast();
                    if (cur.right != null) {
                        queue.addLast(cur.right);
                    }
                    if (cur.left != null) {
                        queue.addLast(cur.left);
                    }
                } else {
                    cur = queue.pollFirst();
                    if (cur.right != null) {
                        queue.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.addFirst(cur.right);
                    }
                }
                subResults.add(cur.val);
            }
            flag = flag ? false : true;
            results.add(subResults);
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);

        TreeNode left2 = new TreeNode(12);
        TreeNode right2 = new TreeNode(13);
        TreeNode left1 = new TreeNode(15);
        TreeNode right1 = new TreeNode(7);

        root.left = left;
        root.right = right;
        root.right.left = left1;
        root.right.right = right1;

        root.left.left = left2;
        root.left.right = right2;

        List<List<Integer>> results = new Leetcode103().zigzagLevelOrder(root);
        for (List<Integer> row : results) {
            for (Integer num : row) {
                System.out.print(" " + num);
            }
            System.out.println("");
        }
    }
}
