package go;

import common.ListNode;

/**
 * @author: liuqiang
 * @create: 2020-05-18 14:09
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Go22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listnode4 = new ListNode(4);
        ListNode listnode3 = new ListNode(3);
        ListNode listnode2 = new ListNode(2);
        ListNode listnode1 = new ListNode(1);

        listnode1.next = listnode2;
        listnode2.next = listnode3;
        listnode3.next = listnode4;

        ListNode head = new Go22().getKthFromEnd(listnode1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
