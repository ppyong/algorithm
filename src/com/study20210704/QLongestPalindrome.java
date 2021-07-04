package com.study20210704;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/longest-palindrome
public class QLongestPalindrome {

    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();
        char[] cArr = s.toCharArray();
        for(char c : cArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int a = map.entrySet().stream().filter(e -> e.getValue() >= 2)
                .collect(Collectors.summingInt(entity -> entity.getValue() / 2  * 2));
        if(a < s.length()) {
            return a + 1;
        }
        return a;
    }

    public static void main(String[] args) {
        new QLongestPalindrome().longestPalindrome("abccccdd");
    }
}
