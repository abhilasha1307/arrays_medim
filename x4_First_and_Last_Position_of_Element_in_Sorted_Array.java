package ARRAYS_medium;

/*
========================================================
PROBLEM:)
=========================================================
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
Follow up: Could you write an algorithm with O(log n) runtime complexity?

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

=============================================================
EXAMPLES:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
=============================================================
*/

/*
===========================================================
APPROACH:)
============================================================
We make a array result and initialize it to [-1,-1], in case the target is not in the array given, we return this
we find the first position by binary search and using a boolean variable
we continue to search until lo == hi and they contain some index at which target can be found.
we are returning l and not m becoz we need the leftmost and the rightmost occurance, and therefore we are also using a boolean variable

to find the last occurence we keep the boolean var false, as we will have to search the right subarray even if the target is found in at at said index 'i'

Time: O(logN)
Space: O(1)
*/

/*
==================================================================
ALTERNATE CODE: USE 2 BS
==================================================================
public  int[] searchRange(int[] nums, int target) {
 int hi = nums.length - 1;
 int low = 0;
 int[] rs = new int[2];

 if(nums == null || nums.length == 0)
  return new int[]{-1, -1 };
  while(low < hi){
   int mid = low + (hi - low) /2;
   if(target > nums[mid]){
    low = mid + 1;
   }else{
    hi = mid;
   }
  }

 if(target == nums[low]){
  rs[0] = low;
 }else{
  rs[0] = -1;
 }

 hi = nums.length - 1;
 while(low < hi){
  int mid = (low + (hi - low) /2 ) + 1;
  if(target < nums[mid]){
   hi = mid - 1;
  }else{
   low = mid;
  }
 }   
 if(target == nums[hi]){
  rs[1] = hi;
 }else{
 rs[1] = -1;
 }

 return rs;
 }

 Time : O(Log n)
 Space : O(1)

*/
public class x4_First_and_Last_Position_of_Element_in_Sorted_Array {

 public static void main(String[] args) {
  int[] nums = new int[] { 8, 8, 8, 8, 8, 8 };

  int target = 8;

  int[] arr = searchRange(nums, target);
  for (int i = 0; i < arr.length; i++) {
   System.out.print(arr[i] + " ");
  }
  System.out.println();
 }

 public static int[] searchRange(int[] nums, int target) {

  int[] result = { -1, -1 };

  int left = first_and_last_index(nums, target, true);

  if (left == nums.length || nums[left] != target) {
   return result;
  }

  result[0] = left;
  result[1] = first_and_last_index(nums, target, false) - 1;

  return result;
 }

 public static int first_and_last_index(int[] nums, int target, boolean b) {
  int l = 0;
  int h = nums.length;

  while (l < h) {
   int m = (l + h) / 2;

   if (nums[m] > target || (b && nums[m] == target)) {
    h = m;
   }

   else {
    l = m + 1;
   }

  }
  return l;
 }

}
