package com.twoPointers;


import com.POJO.ListNode;
import com.common.ListNodeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.BiFunction;

public class TPNodes {
    public static final Logger LOGGER = LogManager.getLogger(TPNodes.class);

    /* 83. remove-duplicates-from-sorted-list */
    public <V> ListNode<V> deleteDuplicates(ListNode<V> head) {
       ListNode<V> cur = head;
       while(cur != null && cur.next != null) {
           if(cur.val == cur.next.val) {
               cur.next = cur.next.next;
           } else {
               cur = cur.next;
           }
       }
       LOGGER.info("Inside Method deleteDuplicates :: The duplicates are removed from LinkedList");
       return head;
    }

    /* 82. remove-duplicates-from-sorted-list-ii */
    public <V> ListNode<V> deleteDuplicatesII(ListNode<V> head) {
        ListNode<V> dummy = new ListNode<>();
        dummy.next = head;
        ListNode<V> cur = dummy;
        while(head != null) {
            while(head != null && cur.next.val.equals(head.val)) {
                head = head.next;
            }
            if(cur.next.next == head) {
                cur = cur.next;
            } else {
                cur.next = head;
            }
            if(head != null) {
                head = head.next;
            }
        }
        return dummy.next;
    }

    /* 148. Sort List */
    public <V> ListNode<V> sortListNode(ListNode<V> listNode) {
        if(listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode<V> tailNode = ListNodeUtils.getMidNode(listNode, true);
        ListNode<V> second = tailNode.next;
        tailNode.next = null;

        ListNode<V> node1 = sortListNode(listNode);
        ListNode<V> node2 = sortListNode(second);

        BiFunction<ListNode<V>, ListNode<V>, Boolean> bi = null;
        if(listNode.val instanceof Integer) {
            bi = (a, b) -> (Integer) a.val > (Integer) b.val;
        }
        return ListNodeUtils.mergeTwoListNodes(node1, node2, bi);
    }
}
