package cn.cloud.test.leetcode.a2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
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
            if(carry > 0){
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

