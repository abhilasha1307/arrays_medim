package ARRAYS_medium;

import java.util.ArrayList;

public class x22_find_all_duplicates {
 public static void main(String[] args) {
  int[] arr = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
  System.out.println(findDuplicates(arr));
 }

 public static ArrayList<Integer> findDuplicates(int[] nums) {
  ArrayList<Integer> list = new ArrayList<>();
  for (int i = 0; i < nums.length; i++) {
   int x = Math.abs(nums[i]) - 1;
   if (nums[x] < 0) {
    list.add(x + 1);
   }
   nums[x] = -nums[x];
  }
  return list;
 }
}