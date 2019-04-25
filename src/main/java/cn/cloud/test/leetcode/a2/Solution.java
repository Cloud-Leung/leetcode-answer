package cn.cloud.test.leetcode.a2;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * }
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        addTo(l1, l2, result);
        return result;
    }

    private void addTo(ListNode l1, ListNode l2, ListNode result) {

        int val = getVal(l1) + getVal(l2) + getVal(result);
        int carry = val >= 10 ? 1 : 0;

        result.val = val >= 10 ? val - 10 : val;

        ListNode next1 = getNext(l1);
        ListNode next2 = getNext(l2);
        if (next1 == null && next2 == null) {
            if (carry > 0) {
                result.next = new ListNode(carry);
            }
            return;
        }
        result.next = new ListNode(carry);
        addTo(next1, next2, getNext(result));
    }

    private int getVal(ListNode node) {
        return node == null ? 0 : node.val;
    }

    private ListNode getNext(ListNode node) {
        return node == null ? null : node.next;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(9);
        ListNode t2 = new ListNode(9);
        t1.next = t2;
        ListNode t3 = new ListNode(9);
        t2.next = t3;

        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        n1.next = n2;
        ListNode n3 = new ListNode(4);
        n2.next = n3;

        ListNode temp = new Solution().addTwoNumbers(t1, n1);
        do {
            System.out.println(temp.val);
        } while ((temp = temp.next) != null);
    }
}

