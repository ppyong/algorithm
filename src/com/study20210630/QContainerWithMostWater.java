package com.study20210630;

//https://leetcode.com/problems/container-with-most-water/
public class QContainerWithMostWater {

    public int maxArea(int[] height) {

        int max = 0;

        for(int i = 0; i < height.length; i++) {

            for(int j = height.length -1; j > i; j--) {
                int iHeight = height[i];
                int jHeight = height[j];

                int min = Math.min(iHeight, jHeight);
                int ret = min * (j-i);

                if(ret > max) {
                    max = ret;
                }

                if(jHeight >= iHeight)
                    break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new QContainerWithMostWater().maxArea(new int[]{4,3,2,1,4}));
    }
}
