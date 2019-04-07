package com.ustc.leetcode;

import org.junit.Test;

/**
 * @Author Matthew Huang
 * @Date 2019/4/7 13:54
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; } //自定义的有参构造方法
}

public class AddTwoNumbers_2 {
    @Test
    public void test(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4); l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6); l2.next.next = new ListNode(4); l2.next.next.next = new ListNode(1);

        //计算的是342+1465=1807
        ListNode l3 = addTwoNumbers(l1,l2);
        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummpHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummpHead;
        int carry = 0;
        while (p != null || q != null | carry != 0){
            if (p != null){
                carry += p.val;
                p = p.next;
            }
            if (q != null){
                carry += q.val;
                q = q.next;
            }
            curr.next = new ListNode(carry % 10);
            carry /= 10;
            curr = curr.next;
        }
        if (carry != 0)
            curr.next = new ListNode(carry);

        return dummpHead.next;

    }
}
