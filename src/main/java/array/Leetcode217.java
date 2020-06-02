package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: liuqiang
 * @create: 2020-05-19 20:23
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num: nums) {
            if (uniqueNums.contains(num)) {
                return true;
            }else {
                uniqueNums.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] array = {1,1,1,3,3,4,3,2,4,2};
        boolean isContainsDuplicate = new Leetcode217().containsDuplicate(array);
        System.out.println(isContainsDuplicate);
    }
}
