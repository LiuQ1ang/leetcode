import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuqiang
 * @create: 2019-09-16 17:46
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1 {

    /**
     * 暴力法
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 哈希表法
     */
    public int[] twoSumByHashMap(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (valueMap.containsKey(complement)) {
                return new int[]{valueMap.get(complement), i};
            }
            valueMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] results = new Leetcode1().twoSum(nums, 17);
        System.out.println("the results is "+ results[0] + " and " + results[1]);
        int[] resultsByHashMap = new Leetcode1().twoSumByHashMap(nums, 26);
        System.out.println("the results by hash map is " + resultsByHashMap[0] + " and " + resultsByHashMap[1]);
    }
}
