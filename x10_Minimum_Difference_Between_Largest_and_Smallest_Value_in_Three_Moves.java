package ARRAYS.ARRAYS_medium;

import java.util.Arrays;

//heap
/*
===================================
PROBLEM:) 1509
===================================
Given an array nums, you are allowed to choose one element of nums and change it by any value in one move.
Return the minimum difference between the largest and smallest value of nums after perfoming at most 3 moves.

1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
*/

/*
APPROACH:)


*/

/*
ITERATIVE SOLUTION:)
public int minDifference(int[] nums) {
        
        if(nums.length <=4)
        {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        
       for(int i=0;i<4;i++){min=Math.min(min,nums[n-4+i]-nums[i]);}
       return min;
}
*/
public class x10_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {

 public static int minDifference(int[] nums) {

  if (nums.length <= 4) {
   return 0;
  }

  Arrays.sort(nums);

  int min = Integer.MAX_VALUE;
  int n = nums.length;

  min = Math.min(min, nums[n - 4] - nums[0]);
  min = Math.min(min, nums[n - 3] - nums[1]);
  min = Math.min(min, nums[n - 2] - nums[2]);
  min = Math.min(min, nums[n - 1] - nums[3]);

  return min;

 }

 public static void main(String[] args) {
  int[] arr = new int[] { 6, 6, 0, 1, 1, 4, 6 };

  System.out.println(minDifference(arr));
 }
}
