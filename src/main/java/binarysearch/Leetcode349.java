package binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: liuqiang
 * @create: 2020-05-21 16:59
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>(nums1.length);
        for (int num1 : nums1) {
            num1Set.add(num1);
        }

        Set<Integer> num2Set = new HashSet<>(nums2.length);
        for (int num2 : nums2) {
            num2Set.add(num2);
        }

        if (num1Set.size() < num2Set.size()) {
            return doIntersection(num1Set, num2Set);
        }else {
            return doIntersection(num2Set, num1Set);
        }
    }

    private int [] doIntersection(Set<Integer> num1Set, Set<Integer> num2Set) {
        int [] results = new int[num1Set.size()];
        int pos = 0;
        for(Integer num1 : num1Set) {
            if (num2Set.contains(num1)) {
                results[pos++] = num1;
            }
        }
        return Arrays.copyOf(results, pos);
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] results = new Leetcode349().intersection(num1, num2);
        for (int result: results) {
            System.out.println(result);
        }
    }
}
