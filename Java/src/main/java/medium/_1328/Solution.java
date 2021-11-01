package medium._1328;

class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() == 0 || palindrome.length() == 1) {
            return "";
        }

        int i = 0;
        for (; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                char[] chars = palindrome.toCharArray();
                chars[i] = 'a';
                return new String(chars);
            }
        }

        char[] chars = palindrome.toCharArray();
        chars[palindrome.length() - 1] = 'b';
        return new String(chars);
    }

}