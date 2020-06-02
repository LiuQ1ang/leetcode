import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: liuqiang
 * @create: 2019-09-18 11:42
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * /  \
 * 2    2
 * / \  / \
 * 3  4 4   3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val)
            && isMirror(left.right, right.left)
            && isMirror(left.left, right.right);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
        treeNodeQueue.add(root);
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode left = treeNodeQueue.poll();
            TreeNode right = treeNodeQueue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            treeNodeQueue.add(left.left);
            treeNodeQueue.add(right.right);
            treeNodeQueue.add(left.right);
            treeNodeQueue.add(right.left);
        }
        return true;
    }
}
