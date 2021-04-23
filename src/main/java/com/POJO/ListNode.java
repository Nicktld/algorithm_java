package com.POJO;

public class ListNode<V> {
    public V val;
    public ListNode<V> next;

    public ListNode() {};
    public ListNode(V val) {
        this.val = val;
    }
    public ListNode(V val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}