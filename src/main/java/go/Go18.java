package go;

import common.ListNode;

/**
 * @author: liuqiang
 * @create: 2020-05-18 13:32
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 *
 * 说明：
 *
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Go18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head;
        while(cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                return head;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listnode4 = new ListNode(4);
        ListNode listnode3 = new ListNode(3);
        ListNode listnode2 = new ListNode(2);
        ListNode listnode1 = new ListNode(1);

        listnode1.next = listnode2;
        listnode2.next = listnode3;
        listnode3.next = listnode4;

        ListNode head = new Go18().deleteNode(listnode1, 5);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
