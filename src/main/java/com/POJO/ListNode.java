package com.POJO;

public class ListNode<E> {
    public E val;
    public ListNode<E> next;

    public ListNode() {};
    public ListNode(E val) {
        this.val = val;
    }
    public ListNode(E val, ListNode<E> next) {
        this.val = val;
        this.next = next;
    }
}