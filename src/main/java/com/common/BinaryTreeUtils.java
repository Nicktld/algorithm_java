package com.common;

import com.POJO.BinaryTree;
import com.twoPointers.TPNodes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class BinaryTreeUtils {

    public static final Logger LOGGER = LogManager.getLogger(BinaryTreeUtils.class);

    public static <E> BinaryTree<E> buildTree(E[] arr) {
        if(arr != null || arr.length == 0) {
            return null;
        }
        BinaryTree<E> root = new BinaryTree<>(arr[0]);
        Deque<BinaryTree<E>> queue = new ArrayDeque<>();
        queue.offer(root);
        int pos = 1;
        while(!queue.isEmpty()) {
            BinaryTree<E> node = queue.poll();
            while(pos < arr.length) {
                if(arr[pos] != null) {
                    node.left = new BinaryTree<>(arr[pos]);
                    queue.offer(node.left);
                }
                if(arr[pos + 1] != null) {
                    node.right = new BinaryTree<>(arr[pos + 1]);
                    queue.offer(node.right);
                }
                pos += 2;
            }
        }
        if(pos != arr.length) {
            LOGGER.error("Inside Method buildTree :: The Input Array is invalid!");
        }
        return root;
    }

    public static <E> List<E> preorder(BinaryTree<E> root) {
        List<E> travList = new ArrayList<>();
        if(root == null) return travList;

        Deque<BinaryTree<E>> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            BinaryTree<E> node = stack.pop();
            travList.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return travList;
    }

    public static <E> List<E> inorder(BinaryTree<E> root) {
        List<E> travList = new ArrayList<>();
        if(root == null) return travList;

        Deque<BinaryTree<E>> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            travList.add(root.val);
            root = root.right;
        }
        return travList;
    }

    public static <E> List<E> postorder(BinaryTree<E> root) {
        List<E> travList = new LinkedList<>();
        if(root == null) return travList;

        Deque<BinaryTree<E>> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {

            BinaryTree<E> node = stack.pop();
            travList.add(0, node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return travList;
    }
}
