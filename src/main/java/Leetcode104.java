import java.util.Stack;

/**
 * @author: liuqiang
 * @create: 2019-09-17 11:14
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class TreeNodePair {
        private TreeNode currentTreeNode;
        private int depth;

        public TreeNodePair(TreeNode currentTreeNode, int depth) {
            this.currentTreeNode = currentTreeNode;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }

        Stack<TreeNodePair> stack = new Stack();
        stack.push(new TreeNodePair(root, 1));
        while (!stack.isEmpty()) {
            TreeNodePair currentTreeNodePair = stack.pop();
            TreeNode currentTreeNode = currentTreeNodePair.currentTreeNode;
            if (currentTreeNodePair != null && currentTreeNode != null) {
                int currentTreeDepth = currentTreeNodePair.depth;
                maxDepth = Math.max(maxDepth, currentTreeDepth);
                stack.push(new TreeNodePair(currentTreeNode.left, currentTreeDepth + 1));
                stack.push(new TreeNodePair(currentTreeNode.right, currentTreeDepth + 1));
            }
        }
        return maxDepth;
    }
}
