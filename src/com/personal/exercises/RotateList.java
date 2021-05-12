package com.personal.exercises;

import com.personal.exercises.utils.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null) {
                return head;
            }
            int length = listLength(head);
            k = k % length;
            int newHeadIdx = (length - k) % length;

            ListNode newHead = extractNth(head, newHeadIdx);
            ListNode newHeadPrev = extractNth(head, (length - k - 1 + length) % length);
            ListNode lastElement = extractNth(head, length - 1);

            lastElement.next = head;
            newHeadPrev.next = null;

            return newHead;
        }

        private int listLength(ListNode head) {
            int l = 0;
            while (head != null) {
                l++;
                head = head.next;
            }
            return l;
        }

        private ListNode extractNth(ListNode head, int n) {
            if ( n == 0 ) {
                return head;
            } else {
                return extractNth(head.next, n - 1);
            }
        }
    }
}
