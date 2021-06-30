package com.study20210628;

//https://leetcode.com/problems/roman-to-integer/
public class QRomanToInteger {

    private enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000),
        ;

        Roman(int num) {
            this.num = num;
        }

        private int num;

        public int getNum() {
            return this.num;
        }
    }

    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            Roman roman = Roman.valueOf(s.substring(i, i + 1));

            Roman nextRoman = null;
            if(i < s.length() - 1) {
                nextRoman = Roman.valueOf(s.substring(i + 1, i + 2));
            }

            if(nextRoman != null) {
                if(roman.getNum() >= nextRoman.getNum()) {
                    result += roman.getNum();
                }else {
                    result += nextRoman.getNum() - roman.getNum();
                    i++;
                }
            }else {
                result += roman.getNum();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new QRomanToInteger().romanToInt("LVIII"));
    }
}
