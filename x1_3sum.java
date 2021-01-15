package ARRAYS.ARRAYS_medium;

import java.util.*;
/*
========================================
PROBLEM:) 15
========================================
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.
0 <= nums.length <= 3000
-105 <= nums[i] <= 105

===========================
EXAMPLES :

Input : nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Input: nums = [0]
Output: []

Input: nums = []
Output: []
===========================
*/

/*
================================================
APPROACH:)
================================================
We sort the array (to easily eliminate duplicate pairs and for using binary search)
for each element 'i' in the array (till nums.length-2 becoz we have to find 2 more elements after that) we will try to find 2 elements such that the sum of there two elements 
is -nums[i] (b+c = -a)
as the array is sorted we use binary search to search for this sum
to avoid duplicate pairs, we have to see whether the element just before the current element is same as the current element, if not, then we continue, if yes, we skip that element

if we find a pair that satisfies the condition, we add it to the list (list.add(Arrays.asList(nums[i],nums[j],nums[k])))

after having traversed the entire array we return the list

Time : O(N^2)
Space : O(1) or O(N^2)
*/

public class x1_3sum {
  public static void main(String[] args) {

    int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };

    System.out.println(threeSum(nums));

    System.out.println(Practice.threeSum(nums));
  }

  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> res = new ArrayList<>();
    if (nums.length < 3)
      return res;
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
      if (i == 0 || i > 0 && nums[i] != nums[i - 1]) { // skip same result
        int j = i + 1, k = nums.length - 1;
        int target = -nums[i];
        while (j < k) {
          if (nums[j] + nums[k] == target) {
            res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            j++;
            k--;
            while (j < k && nums[j] == nums[j - 1])
              j++; // skip same result
            while (j < k && nums[k] == nums[k + 1])
              k--; // skip same result
          } else if (nums[j] + nums[k] > target) {
            k--;
          } else {
            j++;
          }
        }
      }
    }
    return res;
  }

}

class Practice {

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    if (nums.length < 3)
      return list;

    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
        int a = -nums[i];
        int j = i + 1;
        int k = nums.length - 1;

        while (j < k) {
          if (nums[j] + nums[k] == a) {
            list.add(Arrays.asList(nums[i], nums[j], nums[k]));
            j++;
            k--;

            while (j < k && nums[j] == nums[j - 1]) {
              j++;
            }

            while (j < k && nums[k] == nums[k + 1]) {
              k--;
            }
          } else if (nums[j] + nums[k] > a) {
            k--;
          } else {
            j++;
          }
        }
      }
    }

    return list;
  }

}