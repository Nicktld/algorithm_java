package com.random;

import java.util.Random;

public class RandomPickIndex {
    /***
     * Reservoir Sampling
     */
    int[] nums;
    Random rd;
    RandomPickIndex(int[] nums) {
        rd = new Random();
        this.nums = nums;
    }

    int pick(int target) {
        int res = -1;
        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                res = rd.nextInt(++total) == 0 ? i : res;
            }
        }
        return res;
    }
}
