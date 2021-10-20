package com.common.POJO;

/*
* ListNode<E> : Defines a ListNode
* E : The value type [String, Integer, Boolean]
* */
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