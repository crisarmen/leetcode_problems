package com.personal.exercises;

import com.personal.exercises.utils.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }

        ListNode p = head;
        int i = 1;
        while(i <= n  && p != null) {
            p = p.next;
            i++;
        }

        if(p == null) {
            if(i == n + 1) {
                head = head.next;
            }
            return head;
        } else {
            ListNode p1 = head;
            while(p.next != null) {
                p = p.next;
                p1 = p1.next;
            }
            p1.next = p1.next.next;
            return head;
        }
    }
}
