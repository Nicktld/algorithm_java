package com.common;

import com.POJO.ListNode;
import java.util.List;
import java.util.function.BiFunction;

public class ListNodeUtils {

    public static ListNode DUMMY;

    public static <V> ListNode<V> makeSinglyListNodes(V[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        DUMMY = new ListNode<V>();
        ListNode<V> curr = DUMMY;
        for(V v : arr) {
            curr.next = new ListNode<V>(v);
            curr = curr.next;
        }
        return DUMMY.next;
    }

    /* 876. Middle of the Linked List */
    public static <V> ListNode<V> getMidNode(ListNode<V> node) {
        ListNode<V> slow = node, fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static <V> ListNode<V> getMidNode(ListNode<V> node, Boolean isCutOff) {
        ListNode<V> prev = null, slow = node, fast = node;
        while(fast != null && fast.next != null) {
            if(isCutOff) prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return isCutOff ? prev : slow;
    }

    /* 206. Reverse Linked List */
    public static <V> ListNode<V> reverseSinglyListNodes(ListNode<V> node) {
        ListNode prev = null, curr = node;
        while(curr != null) {
            ListNode<V> tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    /* 21. Merge Two ListNodes */
    public static <V> ListNode<V> mergeTwoListNodes(ListNode<V> node1, ListNode<V> node2,
                                                    BiFunction<ListNode<V>, ListNode<V>, Boolean> comparator) {
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        DUMMY = new ListNode<V>();
        ListNode<V> curr = DUMMY;
        Boolean res;
        while(node1 != null && node2 != null) {
            res = comparator.apply(node1, node2);
            if(res) {
                curr.next = node2;
                node2 = node2.next;
            } else {
                curr.next = node1;
                node1 = node1.next;
            }
            curr = curr.next;
        }
        curr.next = (node1 == null) ? node2 : node1;
        return DUMMY.next;
    }

    /* 141. Linked List Cycle */
    public static <V> boolean hasCycle(ListNode<V> listnode) {
        ListNode<V> slow = listnode, fast = listnode;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}