package com.common;

import com.POJO.BinaryTree;
import com.twoPointers.TPNodes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class BinaryTreeUtils {

    public static final Logger LOGGER = LogManager.getLogger(BinaryTreeUtils.class);

    /*
    297. Serialize and Deserialize Binary Tree
     */
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

    /*
    144. Binary Tree Preorder Traversal
     */
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

    /*
    94. Binary Tree Inorder Traversal
     */
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

    /*
    145. Binary Tree Postorder Traversal
     */
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

    /*
    104. Maximum Depth of Binary Tree - DFS Preferred
     */
    public static <E> int maxDepth(BinaryTree<E> root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return (int) Math.max(left, right) + 1;
    }

    /*
    111. Minimum Depth of Binary Tree - BFS Preferred
     */
    public static <E> int minDepth(BinaryTree<E> root) {
        if(root == null) return 0;

        Deque<BinaryTree<E>> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                BinaryTree<E> node = queue.poll();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return level;
    }
}
