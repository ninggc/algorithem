package com.ninggc;

public class DropEggs {
    public class Solution {
        /**
         * @param n: An integer
         * @return: An integer
         */
        public int dropEggs(int n) {
            // write your code here

            // 1. 一层一层测试
            int i = 0;
            while (i < n) {
                ++i;
            }

            return i;
        }
    }
}
