package ARRAYS.ARRAYS_medium;

//
public class x4_First_and_Last_Position_of_Element_in_Sorted_Array {

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
  int h = nums.length; // point

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

 public static void main(String[] args) {
  int[] nums = new int[] { 8, 8, 8, 8, 8, 8 };

  int target = 8;

  int[] arr = searchRange(nums, target);
  for (int i = 0; i < arr.length; i++) {
   System.out.print(arr[i] + " ");
  }
  System.out.println();
 }
}
