package com.study20210628;

//https://leetcode.com/problems/remove-element/
public class QRemoveElement {

    public int removeElement(int[] nums, int val) {
        int same = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]  == val) {
                same++;
                continue;
            }
            nums[i - same] = nums[i];
        }
        return nums.length - same;
    }
    // 1224

    public static void main(String[] args) {
        System.out.println(new QRemoveElement().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
