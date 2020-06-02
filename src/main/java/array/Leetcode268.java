package array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: liuqiang
 * @create: 2020-05-19 18:33
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * <p>
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode268 {

    public int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return expectedSum - sum;
    }

    public int missingNumber1(int[] nums) {
        Set<Integer> numbers = new HashSet<>(nums.length);
        for (int num : nums) {
            numbers.add(num);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!numbers.contains(i)){
                return i;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        int [] array = {9,6,4,2,3,5,7,0,1};
        int missingNumber = new Leetcode268().missingNumber(array);
        System.out.println(missingNumber);
        missingNumber = new Leetcode268().missingNumber1(array);
        System.out.println(missingNumber);
        missingNumber = new Leetcode268().missingNumber2(array);
        System.out.println(missingNumber);
    }
}
