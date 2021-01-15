package ARRAYS.ARRAYS_medium;

public class x3_search_in_rotated_sorted_array {

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

 public static void main(String[] args) {
  int[] nums = new int[] { 6, 7, 0, 1, 2, 3 };
  int target = 2;

  System.out.println(search(nums, target));

 }

}
