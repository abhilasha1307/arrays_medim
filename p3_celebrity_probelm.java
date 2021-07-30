package ARRAYS_medium;

/*
========================================================================================
PROBLEM:)
=========================================================================================
A celebrity is a person who is known to all but does not know anyone at a party; only one person is known to everyone. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
for simplicity we have assumed that the celebrity does not know itself
Note: Follow 0 based indexing.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

============================================================================
EXAMPLES:)
N = 3
M[][] = {{0 1 0},
        {0 0 0}, 
        {0 1 0}}
1 is the celebrity
==========================================================================
*/

/*
==========================================================================
APPROACH:) By Elimination
==========================================================================
in the first loop we ELIMINATE (and find the potential celebrity) by checking if 'a' knows 'b' (a is not the celebrity so a++) or 'b' knows 'a' (b is not the celebrity so b--)
we will stop when a = b in which case we will have to check if 'a' is actually a celebrity

so for every other index in the matrix (other than a itself as the celebrity does not know itself) we will check for conditions
a should not know any other person in the matrix ==> M[a][i] = 0; and
all the i's should know a ==> M[i][a] = 1

we will check if the above conditons are false; even if its for just one index, that would imply that 'a' is not a celebrity

Time: O(n) 
space: O(1)
*/

public class p3_celebrity_probelm {
        public static void main(String[] args) {
                int N = M.length;
                int res = findCeleb(N);
                if (res == -1) {
                        System.out.println("No celebrity in the given matrix");
                }

                else {
                        System.out.println(res);
                }
        }

        static int M[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };

        private static int findCeleb(int N) {
                int a = 0;
                int b = N - 1;
                while (a < b) {
                        if (M[a][b] == 1) {
                                a++;
                        } else {
                                b--;
                        }
                }

                for (int i = 0; i < N; i++) {
                        if (i != a && (M[a][i] == 1 || M[i][a] == 0)) { // M[2][1] == 1
                                return -1;
                        }
                }
                return a;
        }

}
