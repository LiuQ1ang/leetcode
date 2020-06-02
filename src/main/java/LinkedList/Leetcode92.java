package LinkedList;

import common.ListNode;

/**
 * @author: liuqiang
 * @create: 2020-05-28 00:43
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode cur = head;
        int start = 1, end = 1;
        ListNode startListNode = null , endListNode = null;
        ListNode prev = null, next = null;

        int size = n - m + 1;
        int count = 1;
        while (cur != null) {
            ++count;
            if (count == m) {
                prev = cur;
                startListNode = cur.next;
            }else if (count == n) {
                next = cur.next;
                endListNode = cur;
            }else if (count>m && count < n) {

            }
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = prev;
            prev = tmp;

        }

        ListNode listNode = reverseList(startListNode, m, n);
        prev.next = listNode;
        return null;
    }

    private ListNode reverseList(ListNode startListNode, int m, int n) {
        ListNode prev = null, cur = startListNode;

        while (cur != null ) {

        }
        return prev;
    }

}
