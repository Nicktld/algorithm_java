package com.common;

import com.POJO.ListNode;

import java.util.List;

public class ListNodeUtils {

    public static ListNode DUMMY;

    public static <V> ListNode<V> makeSinglyLinkedNodes(V[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        DUMMY = new ListNode<V>();
        ListNode<V> cur = DUMMY;
        for(V v : arr) {
            cur.next = new ListNode<V>(v);
            cur = cur.next;
        }
        return DUMMY.next;
    }

    /* 876. Middle of the Linked List */
    public static <V> ListNode<V> getMidNode(ListNode<V> node) {
        DUMMY = new ListNode<V>();
        DUMMY.next = node;
        ListNode<V> slow = DUMMY, fast = DUMMY;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    /* 206. Reverse Linked List */
    public static <V> ListNode<V> reverseSinglyLinkedNodes(ListNode<V> node) {
        DUMMY = new ListNode<V>();
        ListNode<V> cur = DUMMY;
        while(node != null) {
            ListNode<V> tmp = node.next;
            node.next = cur.next;
            cur.next = node;
            node = tmp;
        }
        return DUMMY.next;
    }
}
