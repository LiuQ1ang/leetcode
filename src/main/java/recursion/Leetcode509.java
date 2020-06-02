package recursion;

/**
 * @author: liuqiang
 * @create: 2020-05-18 17:58
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *  
 * 提示：
 * 0 ≤ N ≤ 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode509 {

    /**
     * 递归
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 迭代
     *
     * @param N
     * @return
     */
    public int fib1(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }

        int cur = 0;
        int prev = 1;
        int prevPrev = 1;
        for (int i = 3; i <= N; i++) {
            cur = prev + prevPrev;
            prevPrev = prev;
            prev = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode509().fib(10));
        System.out.println(new Leetcode509().fib1(10));
    }
}
