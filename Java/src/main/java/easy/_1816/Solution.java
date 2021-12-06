package easy._1816;

/**
 * @description: TODO
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/12/6 12:51
 * @version:v1.0
 */
class Solution {
    public String truncateSentence(String s, int k) {
        byte blank = 0;
        short i = 0;
        char[] chars = s.toCharArray();
        for (; i < s.length(); i++) {
            if (chars[i] == ' ') {
                ++blank;
                if (blank == k) {
                    break;
                }
            }
        }

        return s.substring(0, i);
    }
}