package bit;

/**
 * @author: liuqiang
 * @create: 2020-05-22 18:23
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode371 {

    public int getSum(int a, int b) {

        int i = a ^ b;
        int i1 = a & b;

        return a | b;
    }

    public static void main(String[] args) {
        int sum = new Leetcode371().getSum(2, 3);
        System.out.println(sum);
    }
}
