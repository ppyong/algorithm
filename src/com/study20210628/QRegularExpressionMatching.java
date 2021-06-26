package com.study20210628;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/regular-expression-matching/
public class QRegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if(s.equals(p)){
            return true;
        }

        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        go(queue, p, 0);
        if(queue.isEmpty()) {
            return true;
        }
        return false;
    }

    private void go(Queue<Character> queue, String regex, int idx) {

        char c = regex.charAt(idx);
        char topChar = queue.poll();
        if(c != '.' && c != '*') {
            if(c != topChar){
                return;
            }
            else {
                idx++;
            }
        }else if(c == '.'){
            idx++;
        }else if(c == '*'){
            // *
            char preC = regex.charAt(idx - 1);
            if(preC == topChar) {
                idx++;
            } else if(preC == '.'){
                idx++;
            } else {
                return;
            }
        }

        //모두 일치
        if(queue.size() == 0 && idx == regex.length()) {
            return;
        }
        go(queue, regex, idx);
    }

    public static void main(String[] args) {
        System.out.println(new QRegularExpressionMatching().isMatch("aab", "c*a*b"));
    }
}
