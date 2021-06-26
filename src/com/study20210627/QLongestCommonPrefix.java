package com.study20210627;

public class QLongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for(String s : strs) {
            if(min > s.length()) {
                min = s.length();
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < min; i++) {

            boolean isFirst = true;
            char preChar = ' ';
            for(int j = 0; j < strs.length; j++) {
                char currentChar = strs[j].charAt(i);
                if(!isFirst) {
                    if(preChar != currentChar) {
                        return result.toString();
                    }
                }
                preChar = currentChar;
                isFirst = false;
            }
            result.append(preChar);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new QLongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
