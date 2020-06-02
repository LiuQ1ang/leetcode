package LinkedList;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: liuqiang
 * @create: 2020-01-13 18:49
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode234 {

    /**
     * 借助数组，头尾比较 时间空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode currentListNode = head;
        List<Integer> values = new ArrayList<>();
        while (currentListNode != null) {
            values.add(currentListNode.val);
            currentListNode = currentListNode.next;
        }

        int headIndex = 0;
        int tailIndex = values.size() - 1;
        while (headIndex < tailIndex) {
            if (!Objects.equals(values.get(headIndex), values.get(tailIndex))) {
                return false;
            }
            headIndex++;
            tailIndex--;
        }

        return true;
    }

    /**
     * 找到链表中间位置
     * 翻转链表后半部分
     * 前半部分和后半部分链表进行对比
     * 恢复链表后半部分
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {

        return true;
    }
}
