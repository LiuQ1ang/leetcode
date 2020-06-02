package go;

import common.ListNode;

/**
 * @author: liuqiang
 * @create: 2020-05-28 00:10
 *
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 *
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Go0206 {

    /**
     * 1.寻找链表中间节点
     * 2.翻转后半部分链表
     * 3.比较前后两半部分链表节点是否相同
     * 4.还原后半部分链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode halfListNode = halfOfList(head);
        ListNode reversedList = reverseList(halfListNode);
        boolean isPalindrome = doJudgeIsPalindrome(head, reversedList);
        reverseList(reversedList);
        return isPalindrome;
    }

    private boolean doJudgeIsPalindrome(ListNode head, ListNode halfListNode) {
        ListNode curA = head, curB = halfListNode;
        while (curA != null && curB != null) {
            if (curA.val != curB.val) {
                return false;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode halfListNode) {
        ListNode prev = null, cur = halfListNode;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = prev;
            prev = tmp;
        }
        return prev;
    }

    private ListNode halfOfList(ListNode head) {
        ListNode slow = head, fast= head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);

        head.next = listNode1;
        listNode1.next = listNode2;

        new Go0206().isPalindrome(head);
    }
}
