package com.octopusthu.dev.exercises;

/**
 * arr = [3,2,1,3], val = 3<br>
 * =><br>
 * 2, arr = [2,1,any,any]<br>
 * or<br>
 * 2, arr = [1,2,any,any]<br>
 * <p><br>
 * Space complexity must be O(1)
 */
public class RemoveArrayElement {
    int removeArrayElement(int[] arr, int val) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int p1 = 0, p2 = arr.length - 1;
        while (p1 < p2) {
            if (arr[p1] == val) {
                while (p1 < p2) {
                    if (arr[p2] == val) {
                        p2--;
                        continue;
                    }
                    arr[p1] = arr[p1] + arr[p2];
                    arr[p2] = arr[p1] - arr[p2];
                    arr[p1] = arr[p1] - arr[p2];
                    p1++;
                    p2--;
                }
            } else {
                p1++;
            }
        }
        // p1 == p2 or p1 == p2 + 1
        return arr[p1] == val ? p1 : p1 + 1;
    }
}
