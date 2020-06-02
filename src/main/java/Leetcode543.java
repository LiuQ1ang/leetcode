import common.TreeNode;

import java.util.Objects;

/**
 * @author: liuqiang
 * @create: 2020-04-03 19:25
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Leetcode543 {

    private int num = 1;

    public int diameterOfBinaryTree(TreeNode root) {
         depthOfTree(root);
         return num - 1;
    }

    private int depthOfTree(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return 0;
        }

        int left = depthOfTree(treeNode.left);
        int right = depthOfTree(treeNode.right);
        num = Math.max(num, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode leftNode1 = new TreeNode(2);
        TreeNode rightNode1 = new TreeNode(3);

        TreeNode leftNode11 = new TreeNode(4);
        TreeNode leftNode12 = new TreeNode(5);

        root.left = leftNode1;
        root.right = rightNode1;

        leftNode1.left = leftNode11;
        leftNode1.right = leftNode12;

        int maxDepth = new Leetcode543().diameterOfBinaryTree(root);
        System.out.println("max depth of tree is " + maxDepth);
    }
}
