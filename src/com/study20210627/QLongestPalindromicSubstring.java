package com.study20210627;

//https://leetcode.com/problems/longest-palindromic-substring/
public class QLongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }

        String maxPalindrome = s.substring(0,1);
        for(int i = 0; i < s.length(); i++) {
            for(int j = 2; i + j <= s.length(); j++) {
                String str = s.substring(i, i + j);
                if(maxPalindrome.length() > str.length())
                    continue;

                if(isPalindrome(str)) {
                    if(maxPalindrome.length() < str.length()) {
                        maxPalindrome = str;
                    }
                }
            }
        }
        return maxPalindrome;
    }

    private boolean isPalindrome(String str) {
        int max = str.length() / 2;
        for(int i = 0; i < max; i++) {
            if(str.charAt(i) != str.charAt(str.length() -1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new QLongestPalindromicSubstring().longestPalindrome("bb"));
    }
}
