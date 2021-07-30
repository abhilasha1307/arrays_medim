package ARRAYS_medium;

import java.util.Arrays;
import java.util.LinkedList;

public class x19_Merge_intervals {

 public static void main(String[] args) {
  int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

  int[][] res = merge(intervals);
  for (int i = 0; i < res.length; i++) {
   for (int j = 0; j < res[i].length; j++) {
    System.out.print(res[i][j] + " ");
   }
   System.out.println();
  }
 }

 public static int[][] merge(int[][] intervals) {
  Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
  LinkedList<int[]> list = new LinkedList<>();

  for (int[] interval : intervals) {
   if (list.isEmpty() || list.getLast()[1] < interval[0]) {
    list.add(interval);
   } else {
    list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
   }
  }

  return list.toArray(new int[list.size()][]);
 }

}
