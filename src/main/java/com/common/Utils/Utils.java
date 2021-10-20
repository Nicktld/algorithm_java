package com.common.Utils;

public class Utils {

    /*
    * Swap two values of an Array
    * V : The value type [String, Integer]
    * */
    public static final <V> void swap(V[] arr, int idx1, int idx2) {
        // Input Validation
        if(arr == null || idx1 < 0 || idx2 >= arr.length) {
            return;
        }
        V tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
        return;
    }

    /*
     * Swap two Int values of an Array
     * */
    public static final <V> void swapInt(int[] arr, int idx1, int idx2) {
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
