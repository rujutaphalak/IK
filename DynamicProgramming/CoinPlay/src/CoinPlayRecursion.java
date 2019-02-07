/*
Coin Play

Problem Statement:

Consider a row of n coins of values v1 . . . vn. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.
Assume full competency by both players.

Input Format:
You will be given an array of integers, v

Output Format:
Return an integer denoting the maximum possible amount of sum that you can accumulate.

Constraints:
1 <= length(v) <= 1000

1 <= v[i] <= 10^6

Sample Test Case:
Sample Input-1:
v = [8, 15, 3, 7]

Sample Output-1:
22

Explanation-1:
Player 1 can start two different ways: either picking 8 or picking 7. Depending on the choice s/he makes, the end reward will be different. We want to find the maximum reward the first player can collect.

1.
Player-1 chooses 8.
Opponent chooses 15.
Player-1 chooses 7.
Opponent chooses 3.
Total value collected by Player-1 is 15(8 + 7) (Greedy strategy i.e. pick the highest at every step)

2.
Player-1 chooses 7.
Opponent chooses 8.
Player-2 chooses 15.
Opponent chooses 3.
Total value collected by Player-1 is 22(7 + 15)

Given these two strategies, we want 22 as the answer, and not 15.
 */

/**
 * Editorial section by IK
 *
 *
 Recursive solution



 There are two choices:

 1. The user chooses the ith coin with value Vi: The opponent either chooses (i+1)th coin or jth coin. The opponent intends to choose the coin which leaves the user with minimum value.

 i.e. The user can collect the value Vi + min(F(i+2, j), F(i+1, j-1) )

 coinGame1



 2. The user chooses the jth coin with value Vj: The opponent either chooses ith coin or (j-1)th coin. The opponent intends to choose the coin which leaves the user with minimum value.

 i.e. The user can collect the value Vj + min(F(i+1, j-1), F(i, j-2) )



 Recurrence relationship



 F(i, j) ==> represents the maximum value the user can collect from i'th coin to j'th coin.



 F(i, j) = Max(Vi + min(F(i+2, j), F(i+1, j-1)), Vj + min(F(i+1, j-1), F(i, j-2) ))



 Base Cases

 F(i, j) = Vi      If j == i

 F(i, j) = max(Vi, Vj) If j == i+1



 Optimal solution



 We can memoize the recurrence relationship mentioned above or build an iterative version for the same problem.



 Space Complexity: O(n^2)

 Time Complexity: O(n^2)
 */

//Recursive solution
public class CoinPlayRecursion {

    public static void main(String[] args){
        int[] v = {8,15,3,7};
        int maxProfit = maxWin(v);
        System.out.println(maxProfit);
    }

    //SECOND ATTEMPT. DELETED THE FIRST ATTEMPTED AS SECOND IS MORE CLEAR
    public static int maxWin(int[] v){
      return maxWin(v,0,v.length-1);
    }

    private static int maxWin(int [] v, int first, int last) {
//      if(first>last) return 0;
      if(first == last)
        return  v[first];

      if(last == first + 1)
        return Math.max(v[first],v[last]);

      int opt1 = v[first] + Math.min(maxWin(v,first+2, last),maxWin(v,first+1, last-1));
      int opt2 = v[last] + Math.min(maxWin(v,first+1, last-1),maxWin(v,first, last-2));

      return Math.max(opt1,opt2);
    }
}

