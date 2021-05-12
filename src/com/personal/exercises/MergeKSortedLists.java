package com.personal.exercises;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.personal.exercises.utils.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1 == null) {
                    if(o2 == null) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    if(o2 == null) {
                        return 1;
                    } else {
                        return Integer.compare(o1.val, o2.val);
                    }
                }
            }
        });

        ListNode merged = new ListNode(0);
        ListNode dummyHead = merged;
        for(int j = 0; j < lists.length; j++) {
            if(lists[j] != null) {
                q.add(lists[j]);
            }
        }

        while (!q.isEmpty()) {
            ListNode el = q.poll();
            merged.next = new ListNode(el.val);
            merged = merged.next;

            if(el.next != null) {
                q.add(el.next);
            }
        }

        return dummyHead.next;
    }
}
