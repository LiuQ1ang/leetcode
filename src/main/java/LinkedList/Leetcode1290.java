package LinkedList;

import common.ListNode;

/**
 * @author: liuqiang
 * @create: 2020-05-27 16:14
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 示例 1：
 *
 * 1 -> 0 -> 1
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 *
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 *
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 *
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 *
 * 提示：
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1290 {

    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans = ans * 2 + cur.val;
            cur = cur.next;
        }
        return ans;
    }

    public int getDecimalValue1(ListNode head) {

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        cur = head;
        int sum = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (cur.val == 0 ) {
                cur = cur.next;
                continue;
            }else {
                cur = cur.next;
                sum += Math.pow(2, i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);

        head.next = listNode1;
        listNode1.next = listNode2;

        int decimalValue = new Leetcode1290().getDecimalValue(head);
        System.out.println(decimalValue);
    }
}
