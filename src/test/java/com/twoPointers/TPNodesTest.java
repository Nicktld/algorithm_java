package com.twoPointers;

import com.POJO.ListNode;
import com.common.ListNodeUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TPNodesTest {

    /* Class to be tested */
    TPNodes tpNodes;

    @Before
    public void setup() {
        tpNodes = new TPNodes();
    }

    @After
    public void cleanup() {
        tpNodes = null;
    }

    @Test
    public void deleteDuplicatesSuccess() {
        Integer[] arr1 = new Integer[]{1, 1, 1, 2, 2, 4, 5, 5, 6, 6, 7};
        Integer[] arr2 = new Integer[]{1, 2, 2, 2, 4, 4, 5, 5, 6, 6, 7};
        Integer[] arr3 = new Integer[]{1, 1, 1, 2, 2, 4, 5, 6, 7, 7, 7};
        Integer[] expected = new Integer[]{1, 2, 4, 5, 6, 7};
        ListNode<Integer> nodes1 = tpNodes.deleteDuplicates(ListNodeUtils.makeSinglyLinkedNodes(arr1));
        ListNode<Integer> nodes2 = tpNodes.deleteDuplicates(ListNodeUtils.makeSinglyLinkedNodes(arr2));
        ListNode<Integer> nodes3 = tpNodes.deleteDuplicates(ListNodeUtils.makeSinglyLinkedNodes(arr3));
        ListNode<Integer> expectedNodes = tpNodes.deleteDuplicates(ListNodeUtils.makeSinglyLinkedNodes(expected));

        ListNode[] inputs = new ListNode[] {nodes1, nodes2, nodes3};
        for(ListNode node : inputs) {
            ListNode<Integer> cur = expectedNodes;
            while(node != null && cur != null) {
                assertEquals(node.val, cur.val);
                node = node.next;
                cur = cur.next;
            }
        }
    }

    @Test
    public void deleteDuplicatesIISuccess() {
        Integer[] arr1 = new Integer[]{1, 1, 2, 2, 4, 4, 5, 5, 6, 6, 7};
        Integer[] arr2 = new Integer[]{1, 1, 2, 2, 2, 4, 4, 4, 6, 6, 7};
        Integer[] arr3 = new Integer[]{1, 1, 1, 2, 2, 5, 5, 6, 6, 6, 7};
        Integer[] expected = new Integer[]{7};
        ListNode<Integer> nodes1 = tpNodes.deleteDuplicatesII(ListNodeUtils.makeSinglyLinkedNodes(arr1));
        ListNode<Integer> nodes2 = tpNodes.deleteDuplicatesII(ListNodeUtils.makeSinglyLinkedNodes(arr2));
        ListNode<Integer> nodes3 = tpNodes.deleteDuplicatesII(ListNodeUtils.makeSinglyLinkedNodes(arr3));
        ListNode<Integer> expectedNodes = tpNodes.deleteDuplicatesII(ListNodeUtils.makeSinglyLinkedNodes(expected));

        ListNode[] inputs = new ListNode[] {nodes1, nodes2, nodes3};
        for(ListNode node : inputs) {
            ListNode<Integer> cur = expectedNodes;
            while(node != null && cur != null) {
                assertEquals(node.val, cur.val);
                node = node.next;
                cur = cur.next;
            }
        }
    }

    @Test
    public void getMidNodeSuccess() {
        Integer[] arr1 = new Integer[]{1, 1, 2, 2,  5, 5, 6, 6, 7};
        Integer[] expected = new Integer[]{5, 5, 6, 6, 7};
        ListNode<Integer> nodes1 = ListNodeUtils.getMidNode(ListNodeUtils.makeSinglyLinkedNodes(arr1));
        ListNode<Integer> expectedNodes = ListNodeUtils.makeSinglyLinkedNodes(expected);

        ListNode[] inputs = new ListNode[] {nodes1};
        for(ListNode node : inputs) {
            ListNode<Integer> cur = expectedNodes;
            while(node != null && cur != null) {
                assertEquals(node.val, cur.val);
                node = node.next;
                cur = cur.next;
            }
        }
    }

    @Test
    public void reverseSinglyLinkedNodesSuccess() {
        Integer[] arr1 = new Integer[]{1, 1, 2, 2,  5, 5, 6, 6, 7};
        Integer[] expected = new Integer[]{7, 6, 6, 5, 5, 2, 2, 1, 1};
        ListNode<Integer> nodes1 = ListNodeUtils.reverseSinglyLinkedNodes(ListNodeUtils.makeSinglyLinkedNodes(arr1));
        ListNode<Integer> expectedNodes = ListNodeUtils.makeSinglyLinkedNodes(expected);

        ListNode[] inputs = new ListNode[] {nodes1};
        for(ListNode node : inputs) {
            ListNode<Integer> cur = expectedNodes;
            while(node != null && cur != null) {
                assertEquals(node.val, cur.val);
                node = node.next;
                cur = cur.next;
            }
        }
    }
}
