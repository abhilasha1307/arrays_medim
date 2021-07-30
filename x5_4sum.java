package ARRAYS_medium;

import java.util.*;

/*
===============================================
PROBLEM:)  18
===============================================
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Notice that the solution set must not contain duplicate quadruplets

0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

============================================================
EXAMPLES:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
============================================================
*/

/*
============================================================
APPROACH:)
============================================================
Sort the input array nums.
Call kSum with start = 0, k = 4, and target, and return the result.
Check if the sum of k smallest values is greater than target, or the sum of k largest values is smaller than target. Since the array is sorted, the smallest value is nums[start], and largest is the last element in nums.
If so, no need to continue - there are no k elements that sum to target.

kSum function:
If k equals 2, call twoSum and return the result.
Iterate i through the array from start:
If the current value is the same as the one before, skip it (no duplicates quadruplets)
Recursively call kSum with start = i + 1, k = k - 1, and target - nums[i].
For each returned set of values:
Include the current value nums[i] into set.
Add set to the result res.
Return the result res.

twoSum function: 
Set the low pointer lo to start, and high pointer hi to the last index.
While low pointer is smaller than high:
If the sum of nums[lo] and nums[hi] is less than target, increment lo.
Also increment lo if the value is the same as for lo - 1.
If the sum is greater than target, decrement hi.
Also decrement hi if the value is the same as for hi + 1.
Otherwise, we found a pair:
Add it to the result res.
Decrement hi and increment lo.
Return the result res.

Time : O(n^(k-1)), we have k-2 loops, and O(N) for twosum
for k > 2, sorting the array does not change the overall time complexity.

Space :O(N)
We need O(k) space for the recursion. k can be the same as n in the worst case for the generalized algorithm
*/
public class x5_4sum {
  public static void main(String[] args) {

    int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
    int target = 0;

    System.out.println(fourSum(nums, target));
  }

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
}
