package go;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: liuqiang
 * @create: 2020-05-18 11:22
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Go0201 {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> uniqueListNodes = new HashSet<>();
        ListNode cur = head, prev = null;
        while (cur != null) {
            if (uniqueListNodes.contains(cur.val)) {
                prev.next = prev.next.next;
                cur = cur.next;
            }else {
                uniqueListNodes.add(cur.val);
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listnode6 = new ListNode(1);
        ListNode listnode5 = new ListNode(2);
        ListNode listnode4 = new ListNode(3);
        ListNode listnode3 = new ListNode(3);
        ListNode listnode2 = new ListNode(2);
        ListNode listnode1 = new ListNode(1);

        listnode1.next = listnode2;
        listnode2.next = listnode3;
        listnode3.next = listnode4;
        listnode4.next = listnode5;
        listnode5.next = listnode6;

        ListNode head = new Go0201().removeDuplicateNodes(listnode1);

        while(head != null) {
            System.out.println("the list node is " + head.val);
            head = head.next;
        }
    }
}
