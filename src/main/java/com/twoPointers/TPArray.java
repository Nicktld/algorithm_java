package com.twoPointers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TPArray {
    private static final Logger LOGGER = LogManager.getLogger(TPArray.class);

    /* 283. Move Zeroes */
    public void moveZeros(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        LOGGER.info("Inside Method moveZeros :: Non-0 values are moved forward!");
        while(slow < nums.length) {
            nums[slow++] = 0;
        }
        LOGGER.info("Inside Method moveZeros :: 0 values are filled out for the rest positions!");
    }
}
