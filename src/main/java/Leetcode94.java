import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author: liuqiang
 * @create: 2019-09-17 09:42
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode94 {

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
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root != null) {
            results.addAll(inorderTraversal(root.left));
            results.add(root.val);
            results.addAll(inorderTraversal(root.right));
        }
        return results;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalByIteration(TreeNode root) {
        Stack<Integer>  roots = new Stack<Integer>();
        while(root != null) {

        }
        return null;
    }
}
