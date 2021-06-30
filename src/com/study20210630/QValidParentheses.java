package com.study20210630;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class QValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
               stack.add(c);
            }else {
                if(stack.size() == 0) {
                    return false;
                }
                char currentChar = stack.pop();
                if(c == ')') {
                    if(currentChar != '(')
                        return false;
                }else if(c == '}') {
                    if(currentChar != '{')
                        return false;
                }else if(c == ']') {
                    if(currentChar != '[')
                        return false;
                }
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new QValidParentheses().isValid("]"));
    }

}
