import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: liuqiang
 * @create: 2019-09-23 21:29
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode448 {

    /**
     * hash表 时间空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numSets = fillHashMap(nums);
        List<Integer> disappearedNumbers = new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numSets.contains(i)) {
                disappearedNumbers.add(i);
            }
        }
        return disappearedNumbers;
    }

    private Set<Integer> fillHashMap(int[] nums) {
        Set<Integer> numSets = new HashSet<Integer>();
        for (int num : nums) {
            numSets.add(num);
        }
        return numSets;
    }

    /**
     * 下标标记法 空间复杂度O(1),时间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        markRepeatedNumbersNegative(nums);
        List<Integer> disappearedNumbers = new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] > 0) {
                disappearedNumbers.add(i);
            }
        }
        return disappearedNumbers;
    }

    private void markRepeatedNumbersNegative(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new Leetcode448().findDisappearedNumbers1(nums));
    }
}
