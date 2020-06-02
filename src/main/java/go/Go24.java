package go;

import common.ListNode;

/**
 * @author: liuqiang
 * @create: 2020-05-18 13:10
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *  
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Go24 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = prev;
            prev = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listnode6 = new ListNode(6);
        ListNode listnode5 = new ListNode(5);
        ListNode listnode4 = new ListNode(4);
        ListNode listnode3 = new ListNode(3);
        ListNode listnode2 = new ListNode(2);
        ListNode listnode1 = new ListNode(1);

        listnode1.next = listnode2;
        listnode2.next = listnode3;
        listnode3.next = listnode4;
        listnode4.next = listnode5;
        listnode5.next = listnode6;

        ListNode head = new Go24().reverseList(listnode1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
