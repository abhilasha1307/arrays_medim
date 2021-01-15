package ARRAYS.ARRAYS_medium;

//not submitted
import java.util.*;
/*
PROBLEM:)
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Notice that the solution set must not contain duplicate quadruplets
*/

/*
APPROACH:)

*/
public class x5_4sum {
 public static List<List<Integer>> fourSum(int[] nums, int target) {
  Arrays.sort(nums);
  return kSum(nums, target, 0, 4);
 }

 public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
  List<List<Integer>> res = new ArrayList<>();
  if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
   return res;
  if (k == 2)
   return twoSum(nums, target, start);
  for (int i = start; i < nums.length; ++i)
   if (i == start || nums[i - 1] != nums[i])
    for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
     res.add(new ArrayList<>(Arrays.asList(nums[i])));
     res.get(res.size() - 1).addAll(set);
    }
  return res;
 }

 public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
  List<List<Integer>> res = new ArrayList<>();
  int lo = start, hi = nums.length - 1;
  while (lo < hi) {
   int sum = nums[lo] + nums[hi];
   if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
    ++lo;
   else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
    --hi;
   else
    res.add(Arrays.asList(nums[lo++], nums[hi--]));
  }
  return res;
 }

 public static void main(String[] args) {

  int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
  int target = 0;

  System.out.println(fourSum(nums, target));
 }
}
