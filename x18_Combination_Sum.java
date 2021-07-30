package ARRAYS_medium;

import java.util.*;

//Backtracking

public class x18_Combination_Sum {

 public static void main(String[] args) {
  int[] nums = new int[] { 2, 3, 6, 7 };
  int target = 7;

  System.out.println(combinationSum(nums, target));
 }

 public static List<List<Integer>> combinationSum(int[] candidates, int target) {

  List<List<Integer>> list = new ArrayList<>();
  backtrack(list, new ArrayList<>(), candidates, target);
  return list;
 }

 private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int remain) {
  if (remain < 0)
   return;
  else if (remain == 0)
   list.add(new ArrayList<>(temp));
  else {
   for (int i = 0; i < nums.length; i++) {
    temp.add(nums[i]);
    backtrack(list, temp, nums, remain - nums[i]);
    temp.remove(temp.size() - 1);
   }
  }
 }
}
