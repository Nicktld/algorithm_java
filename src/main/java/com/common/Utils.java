package com.common;

public class Utils {

    public static final void swap(int[] arr, int idx1, int idx2) {
        // Input Validation
        if(arr == null || idx1 < 0 || idx2 >= arr.length) {
            return;
        }
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
        return;
    }
}
