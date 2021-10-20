package com.twoPointers;

import com.common.POJO.ListNode;
import com.common.Utils.ListNodeUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        ListNode<Integer> nodes1 = tpNodes.deleteDuplicates(ListNodeUtils.makeSinglyListNodes(arr1));
        ListNode<Integer> nodes2 = tpNodes.deleteDuplicates(ListNodeUtils.makeSinglyListNodes(arr2));
        ListNode<Integer> nodes3 = tpNodes.deleteDuplicates(ListNodeUtils.makeSinglyListNodes(arr3));

        Integer[] arr4 = new Integer[]{1, 2, 4, 5, 6, 7};
        ListNode<Integer> expect = tpNodes.deleteDuplicates(ListNodeUtils.makeSinglyListNodes(arr4));

        ListNode[] inputs = new ListNode[] {nodes1, nodes2, nodes3};
        for(ListNode actual : inputs) {
            assertTrue(ListNodeUtils.compareListNodes(expect, actual));
        }
    }

    @Test
    public void deleteDuplicatesIISuccess() {
        Integer[] arr1 = new Integer[]{1, 1, 2, 2, 4, 4, 5, 5, 6, 6, 7};
        Integer[] arr2 = new Integer[]{1, 1, 2, 2, 2, 4, 4, 4, 6, 6, 7};
        Integer[] arr3 = new Integer[]{1, 1, 1, 2, 2, 5, 5, 6, 6, 6, 7};
        ListNode<Integer> nodes1 = tpNodes.deleteDuplicatesII(ListNodeUtils.makeSinglyListNodes(arr1));
        ListNode<Integer> nodes2 = tpNodes.deleteDuplicatesII(ListNodeUtils.makeSinglyListNodes(arr2));
        ListNode<Integer> nodes3 = tpNodes.deleteDuplicatesII(ListNodeUtils.makeSinglyListNodes(arr3));

        Integer[] arr4 = new Integer[]{7};
        ListNode<Integer> expect = tpNodes.deleteDuplicatesII(ListNodeUtils.makeSinglyListNodes(arr4));

        ListNode[] inputs = new ListNode[] {nodes1, nodes2, nodes3};
        for(ListNode actual : inputs) {
            assertTrue(ListNodeUtils.compareListNodes(expect, actual));
        }
    }

    @Test
    public void sortListNodeSuccess() {
        Integer[] arr1 = new Integer[]{1, 2, 6, 5, 4, 3};
        ListNode<Integer> actual = tpNodes.sortListNode(ListNodeUtils.makeSinglyListNodes(arr1));

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5, 6};
        ListNode<Integer> expect = ListNodeUtils.makeSinglyListNodes(arr2);

        assertTrue(ListNodeUtils.compareListNodes(expect, actual));
    }

    /*
    ListNodeUtils :: getMidNode
     */
    @Test
    public void getMidNodeSuccess() {
        Integer[] arr1 = new Integer[]{1, 1, 2, 2,  5, 5, 6, 6, 7};
        ListNode<Integer> actual = ListNodeUtils.getMidNode(ListNodeUtils.makeSinglyListNodes(arr1));

        Integer[] arr2 = new Integer[]{5, 5, 6, 6, 7};
        ListNode<Integer> expect = ListNodeUtils.makeSinglyListNodes(arr2);

        assertTrue(ListNodeUtils.compareListNodes(expect, actual));
    }

    /*
    ListNodeUtils :: reverseSinglyListNodes
     */
    @Test
    public void reverseSinglyListNodesSuccess() {
        Integer[] arr1 = new Integer[]{1, 1, 2, 2,  5, 5, 6, 6, 7};
        ListNode<Integer> actual = ListNodeUtils.reverseSinglyListNodes(ListNodeUtils.makeSinglyListNodes(arr1));

        Integer[] arr2 = new Integer[]{7, 6, 6, 5, 5, 2, 2, 1, 1};
        ListNode<Integer> expect = ListNodeUtils.makeSinglyListNodes(arr2);

        assertTrue(ListNodeUtils.compareListNodes(expect, actual));
    }

    /*
    ListNodeUtils :: mergeTwoListNodes
     */
    @Test
    public void mergeTwoListNodesSuccess() {
        Integer[] arr1 = new Integer[]{1, 2, 4, 5, 7};
        Integer[] arr2 = new Integer[]{3, 6, 8};
        ListNode<Integer> node1 = ListNodeUtils.makeSinglyListNodes(arr1);
        ListNode<Integer> node2 = ListNodeUtils.makeSinglyListNodes(arr2);
        ListNode<Integer> actual = ListNodeUtils.mergeTwoListNodes(node1, node2, (a, b) -> a.val > b.val);

        Integer[] arr3 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        ListNode<Integer> expect = ListNodeUtils.makeSinglyListNodes(arr3);

        assertTrue(ListNodeUtils.compareListNodes(expect, actual));
    }
}
