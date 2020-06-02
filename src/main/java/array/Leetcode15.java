package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liuqiang
 * @create: 2020-05-25 15:26
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode15 {
    
    private static final int MIN_NUM = 3;
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < MIN_NUM) {
            return results;
        }
        Arrays.sort(nums);
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = num + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(num);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum > 0){
                    right--;
                }else if (sum < 0) {
                    left++;
                }
            }
        }
        return results;
    }
}
