package com.twoPointers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TPArrayTest {

    /* Class To Be Tested */
    TPArray tpArray;

    @Before
    public void setup() {
        tpArray = new TPArray();
    }

    @After
    public void cleanup() {
        tpArray = null;
    }

    @Test
    public void moveZerosSuccess() {
        int[][] inputs = new int[][]{
                {1, 0, 2, 0, 3, 0, 0, 5},
                {1, 2, 0, 0, 3, 0, 0, 5},
                {1, 0, 2, 3, 5, 0, 0, 0}};
        int[] expect = new int[]{1, 2, 3, 5, 0, 0, 0, 0};

        for(int[] input : inputs) {
            tpArray.moveZeros(input);
            assertArrayEquals(expect, input);
        }
    }

    @Test
    public void moveZerosInvalidInput() {
        tpArray.moveZeros(null);
        tpArray.moveZeros(new int[0]);
    }
}