package com.twoPointers;


import com.POJO.ListNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
}
