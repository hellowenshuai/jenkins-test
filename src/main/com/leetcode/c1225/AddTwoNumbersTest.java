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
        // 默认jinwei为0
        int jinwei = 0;
        ListNode temp = new ListNode(-1);
        //保存结果中头指针
        ListNode res = temp;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + jinwei;
            //sum%10获取余数
            temp.next = new ListNode(sum % 10);
            //sum%10获取进位的数
            jinwei = sum / 10;
            if (l1 != null) {
                //指针向后移动
                l1 = l1.next;
            }
            if (l2 != null) {
                //指针向后移动
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (jinwei == 1) {
            temp.next = new ListNode(jinwei);
        }
        //res经过计算 ，已经在倒数第二个结点上，只有tmp还在res的头结点上
        return res.next;
    }


    public static void main(String[] args) {
        AddTwoNumbersTest test02 = new AddTwoNumbersTest();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(8);

        ListNode listNode2 = new ListNode(0);
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
