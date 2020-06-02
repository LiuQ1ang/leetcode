import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: liuqiang
 * @create: 2020-01-13 17:37
 * <p>
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode226 {

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        final Queue<TreeNode> treeNodes = new LinkedList<TreeNode>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.poll();
            if (treeNode == null) {
                continue;
            }
            TreeNode tmpTreeNode = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmpTreeNode;
            if (treeNode.left != null) {
                treeNodes.add(treeNode.left);
            }

            if (treeNode.right != null) {
                treeNodes.add(treeNode.right);
            }
        }
        return root;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeByRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTreeNode = invertTreeByRecursion(root.left);
        TreeNode rightTreeNode = invertTreeByRecursion(root.right);

        root.right = leftTreeNode;
        root.left = rightTreeNode;
        return root;
    }
}
