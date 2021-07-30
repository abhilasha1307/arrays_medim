package ARRAYS_medium;

/*
===========================================================
PROBLEM:) 33
============================================================
You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.
Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
If target is found in the array return its index, otherwise, return -1

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104

================================================
EXAMPLES:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
=================================================
*/

/*
==========================================================
APPROACH:)
==========================================================
We set low and high at 0 and last element of the array respectively
and we use binary search with a little change

as we have to search in the sorted part (there are two sorted parts the given array)
if the part betwee l and mid is sorted, we search in that part of the array, else we search between mid and h
In the first case, we check if the target lies between l and mid, if yes, we shift h to m-1 else we shift l to m+1
In the 2nd case, we check if the target lies between m and h, we shift l to m+1 else h to m-1
keep decreasing the search length till we find the element or l>h (return -1)

Time : O(logN)
Space : O(1)
*/

public class x3_search_in_rotated_sorted_array {

 public static void main(String[] args) {
  int[] nums = new int[] { 6, 7, 0, 1, 2, 3 };
  int target = 2;

  System.out.println(search(nums, target));

 }

 public static int search(int[] nums, int target) {

  int l = 0;
  int h = nums.length - 1;

  while (l <= h) {
   int m = (l + h) / 2;
   if (nums[m] == target) {
    return m;
   }

   if (nums[l] <= nums[m]) {
    if (target >= nums[l] && target < nums[m]) {
     h = m - 1;
    }

    else {
     l = m + 1;
    }
   }

   else {
    if (target > nums[m] && target <= nums[h]) {
     l = m + 1;
    }

    else {
     h = m - 1;
    }
   }
  }
  return -1;
 }
}
