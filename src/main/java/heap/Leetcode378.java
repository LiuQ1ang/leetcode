package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: liuqiang
 * @create: 2020-05-21 17:53
 * <p>
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * <p>
 * 提示：
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode378 {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int[] row : matrix) {
            for (int num : row) {
                priorityQueue.add(num);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }
        return priorityQueue.poll();
    }
}
