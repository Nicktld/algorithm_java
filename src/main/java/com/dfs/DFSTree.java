package com.dfs;

import com.common.POJO.BinaryTree;
import com.common.Utils.BinaryTreeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DFSTree {
    public static final Logger LOGGER = LogManager.getLogger(DFSTree.class);

    /*
    110. Balanced Binary Tree
     */
    public static <E> boolean isBalanced(BinaryTree<E> root) {
        if(root == null) return true;

        int left = BinaryTreeUtils.maxDepth(root.left);
        int right = BinaryTreeUtils.maxDepth(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(left - right) <= 1;
    }

    public static <E> boolean isBalancedII(BinaryTree<E> root) {
        return getHeight(root) != -1;
    }
    private static <E> int getHeight(BinaryTree<E> root) {
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    /*
    545. Boundary of Binary Tree - Elegant Recursion Usage
     */
    public static <E> List<E> boundaryofBinaryTree(BinaryTree<E> root) {
        List<E> boundaryList = new ArrayList<>();
        if(root == null) return boundaryList;

        boundaryList.add(root.val);
        getLeftBoundary(root.left, boundaryList);
        getLeaves(root.left, boundaryList);
        getLeaves(root.right, boundaryList);
        getRightBoundary(root.right, boundaryList);
        return boundaryList;
    }
    private static <E> void getLeftBoundary(BinaryTree<E> node, List<E> list) {
        if(node == null) return;
        if(node.left == null && node.right == null) return;
        list.add(node.val);
        if(node.left == null) getLeftBoundary(node.right, list);
        else getLeftBoundary(node.left, list);
    }
    private static <E> void getRightBoundary(BinaryTree<E> node, List<E> list) {
        if(node == null) return;
        if(node.left == null && node.right == null) return;
        if(node.right == null) getRightBoundary(node.left, list);
        else getRightBoundary(node.right, list);
        list.add(node.val);
    }
    private static <E> void getLeaves(BinaryTree<E> node, List<E> list) {
        if(node == null) return;
        if(node.left == null && node.right == null) list.add(node.val);
        getLeaves(node.left,list);
        getLeaves(node.left,list);
    }
}
