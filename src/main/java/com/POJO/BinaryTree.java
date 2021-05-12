package com.POJO;

public class BinaryTree<E> {
    public BinaryTree<E> left, right;
    public E val;

    public BinaryTree() {}
    public BinaryTree(E val) { this.val = val; }
    public BinaryTree(E val, BinaryTree<E> left, BinaryTree<E> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
