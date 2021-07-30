package ARRAYS_medium;

import java.util.ArrayList;

public class x23_interval_list_intesections {
 public static void main(String[] args) {
  int[][] firstList = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
  int[][] secondList = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

  int[][] List = intervalIntersection(firstList, secondList);
  for (int[] x : List) {
   for (int a : x) {
    System.out.print(a + " ");
   }
   System.out.println();
  }
 }

 public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
  ArrayList<int[]> list = new ArrayList<>();

  int i = 0, j = 0;
  while (i < firstList.length && j < secondList.length) {
   int low = Math.max(firstList[i][0], secondList[j][0]);
   int high = Math.min(firstList[i][1], secondList[j][1]);

   if (low <= high)
    list.add(new int[] { low, high });

   if (firstList[i][1] < secondList[j][1]) {
    i++;
   } else {
    j++;
   }
  }

  return list.toArray(new int[list.size()][]);
 }
}
