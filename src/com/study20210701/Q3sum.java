package com.study20210701;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/3sum
public class Q3sum {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        if(nums[0] == 0 && nums[nums.length-1] == 0) {
            return Arrays.asList(Arrays.asList(0,0,0));
        }

        int target = 0;
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum  = nums[i] + nums[left] + nums[right];

                if(sum == 0) {
                    ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }

                if (sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return ret.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new Q3sum().threeSum(new int[]{-2,0,1,1,2}));
    }
}
