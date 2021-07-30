package ARRAYS_medium;

import java.util.*;

//import java.util.Arrays;

/*
===========================================
PROBLEM:) 1590
============================================
Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
A subarray is defined as a contiguous block of elements in the array.
*/

/*

*/

public class x7_make_sum_divisible_by_P {

 public static int minSubarray(int[] nums, int p) {
  int mod = 0, r_mod = 0, min_w = nums.length;
  for (var n : nums)
   mod = (mod + n) % p;
  if (mod == 0)
   return 0;
  Map<Integer, Integer> pos = new HashMap<>();
  pos.put(0, -1);
  for (int i = 0; i < nums.length; ++i) {
   r_mod = (r_mod + nums[i]) % p;
   int comp = (p - mod + r_mod) % p; // explain???
   if (pos.containsKey(comp))
    min_w = Math.min(min_w, i - pos.get(comp));
   pos.put(r_mod, i);
  }
  return min_w >= nums.length ? -1 : min_w;
 }

 public static void main(String[] args) {
  int[] arr = new int[] { 1, 3, 4, 2 };
  int p = 6;
  System.out.println(minSubarray(arr, p));

 }
}
