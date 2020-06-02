package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: liuqiang
 * @create: 2020-05-27 15:05
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 * 示例 1：
 *
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 *
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * 示例 3：
 *
 * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * 示例 4：
 *
 * 输入：N = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 * 示例 5：
 *
 * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] 是完全不同的
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-town-judge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode997 {

    public int findJudge(int N, int[][] trust) {
        int [] persons = new int[N + 1];
        int [] judges = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            persons[i] = 0;
            judges[i] = 0;
        }
        for (int[] trustGroup :trust) {
            persons[trustGroup[0]]++;
            judges[trustGroup[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (persons[i] == 0 && judges[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [][] trust = {{1,2}};
        int judge = new Leetcode997().findJudge(2, trust);
        System.out.println(judge);
    }
}
