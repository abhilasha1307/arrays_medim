package ARRAYS_medium;

import java.util.ArrayList;

/*
PROBLEM:)
Given the array queries of positive integers between 1 and m, you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:

In the beginning, you have the permutation P=[1,2,3,...,m].
For the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the beginning of the permutation P. Notice that the position of queries[i] in P is the result for queries[i].
Return an array containing the result for the given queries.
*/

/*
APPROACH:)

*/

public class x21_queries_on_given_permutation_with_key {
 public static void main(String[] args) {
  int[] queries = new int[] { 3, 1, 2, 1 };
  int m = 5;
  int[] ans = processQueries(queries, m);
  for (int x : ans) {
   System.out.print(x + " ");
  }
 }

 public static int[] processQueries(int[] queries, int m) {
  ArrayList<Integer> P = new ArrayList<>();
  int j = 1;
  for (; j <= m; j += 1) {
   P.add(j);
  }

  int[] res = new int[queries.length];

  for (int i = 0; i < queries.length; i++) {
   // int position = P.indexOf(queries[i]);
   // res[i] = position;
   // shift(P, position);

   int temp = queries[i];
   if (P.contains(temp)) {
    res[i] = P.indexOf(temp);
    P.remove(P.indexOf(temp));
    P.add(0, temp);
   }
  }
  return res;
 }

 public static void shift(ArrayList<Integer> list, int position) {
  int temp = list.get(0);
  list.set(0, list.get(position));
  for (int i = 1; i <= position; i++) {
   int t = list.get(i);
   list.set(i, temp);
   temp = t;
  }
 }

}
