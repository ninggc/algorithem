package medium._1218;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @description: Solution
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/11/5 12:41:30
 * @version:v1.0
 */
class Solution {

    public int longestSubsequence(int[] arr, int difference) {

        int first = arr[0];
        if (first < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= first;
            }
        }
        Map<Integer, List<Integer>> group = new HashMap<>(arr.length);
        for (int i : arr) {
            int remainder = difference == 0 ? difference : i % difference;
            if (remainder < 0) {
                remainder += difference < 0 ? -difference : difference;
            }
            group.putIfAbsent(remainder, new LinkedList<>());
            group.get(remainder).add(i);
        }

        int max = 0;
        for (List<Integer> value : group.values()) {
            Iterator<Integer> iterator = value.iterator();
            Integer pre = iterator.next();
            int sum = 1;
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next - pre == difference) {
                    ++sum;
                    pre = next;
                }
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}