package com.leetcode.c1225;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbersTest {
    /**
     * （head1.val + head2.val + jinwei） % 10 就是结果中此位置的值。而新的进位为（head1.val + head2.val + jinwei） / 10 。
     * 有两个地方是主要注意的。
     * 1、可能会出现head1或者head2已经为null了的情况。**
     * 2、最后head1和head2均为null以后，还要考虑jinwei如果不为0的情况，此时要加其加至链表末尾。**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 默认为0
        int jinwei = 0;
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + jinwei;
            //sum%10获取余数
            res.next = new ListNode(sum % 10);
            //sum%10获取整数
            jinwei = sum / 10;
            //指针向后移动
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + jinwei;
            //sum%10获取整数
            res.next = new ListNode(sum % 10);
            jinwei = sum / 10;
            //指针向后移动
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + jinwei;
            //sum%10获取整数
            res.next = new ListNode(sum % 10);
            jinwei = sum / 10;
            //指针向后移动
            res = res.next;
            l2 = l2.next;
        }
        if (jinwei == 1) {
            res.next = new ListNode(1);
        }
        //res经过计算 ，已经在倒数第二个结点上，只有tmp还在res的头结点上
        return tmp.next;
    }


    public static void main(String[] args) {
        AddTwoNumbersTest test02 = new AddTwoNumbersTest ();
        ListNode listNode = new ListNode(9);
        listNode.next = new ListNode(8);

        ListNode listNode2 = new ListNode(1);
        ListNode numbers = new ListNode(-1);
        try {
            numbers = test02.addTwoNumbers(listNode, listNode2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        while (numbers != null) {
            System.out.print(numbers.val);
            numbers = numbers.next;
        }
    }
}
