package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: liuqiang
 * @create: 2020-05-25 12:12
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode230 {

    public int kthSmallest(TreeNode root, int k) {
//        return kthSmallestByRecursion(root, k);
        return kthSmallestByIteration(root, k);
    }

    /**
     * 递归
     * @param root
     * @param k
     * @return
     */
    private int kthSmallestByRecursion(TreeNode root, int k) {
        List<Integer> results = new ArrayList<>();
        BFS(results, root);
        return results.get(k - 1);
    }

    private void BFS(List<Integer> results, TreeNode root) {
        if (root == null) {
            return;
        }
        BFS(results, root.left);
        results.add(root.val);
        BFS(results, root.right);
    }

    /**
     * 迭代
     * @param root
     * @param k
     * @return
     */
    private int kthSmallestByIteration(TreeNode root, int k) {
        LinkedList<TreeNode> results = new LinkedList<>();
        while (true) {
            while (root != null) {
                results.add(root);
                root = root.left;
            }

            root = results.pollLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode left_right = new TreeNode(2);

        root.left = left;
        root.right = right;
        root.left.right = left_right;

        int i = new Leetcode230().kthSmallest(root, 1);
        System.out.println(i);
    }

}
