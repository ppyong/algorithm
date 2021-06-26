package com.study20210628;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://coding-factory.tistory.com/607 조합, 순열
//https://leetcode.com/problems/3sum/
public class Q3Sum {

    public Q3Sum() {
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int max = nums.length;
        boolean check[] = new boolean[max];

        Set<List<Integer>> list = new HashSet<>();
        combination(0,0,3, max, check, nums, list);
        //0,0,2

        return list.stream().filter(this::isValid).collect(Collectors.toList());
    }

    private boolean isValid(List<Integer> list) {
        //i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

//        long cnt = list.stream().distinct().count();
//        if(cnt != list.size()) {
//            return false;
//        }
        long sum = list.stream().mapToInt(Integer::intValue).sum();
        if(sum != 0){
            return false;
        }
        return true;
    }

    private void combination(int idx, int n, int r, int max, boolean[] check, int[] nums, Set<List<Integer>> list) {
        if (n == r) {
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < max; i++) {
                if (check[i] == true) {
                    newList.add(nums[i]);
                }
            }
            list.add(newList);
            return;
        }

        for (int i = idx; i < max; i++) {
            if (check[i] == true){
                continue;
            }
            check[i] = true;

            combination(i,n+1, r, max, check, nums, list);

            check[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q3Sum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
