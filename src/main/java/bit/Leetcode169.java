package bit;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuqiang
 * @create: 2019-09-19 17:39
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        int limit = nums.length / 2 + 1;
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
            max = Math.max(max, map.get(num));
            if (max >= limit) {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] a = {2,2,1,1,1,2,2};
        int majorityElement = new Leetcode169().majorityElement(a);
        System.out.println("the majority element is : " + majorityElement);
    }
}
