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

//Recursive solution
public class CoinPlay {

    public static void main(String[] args){
        int[] v = {8,15,3,7};
        int maxProfit = maxWin(v);
        System.out.println(maxProfit);
    }


    public static int maxWin(int[] v){
        return maxWin(v,0,v.length-1);
    }

    private static int maxWin(int [] v, int i, int j) {
         if(i==j)
             return v[i];
         if(j==i+1)
             return Math.max(v[i],v[j]);

         return Math.max(v[i] + Math.min(maxWin(v, i + 2, j), maxWin(v, i + 1, j - 1)),
                         v[j] + Math.min(maxWin(v,i+1,j-1), maxWin(v,i,j-2)));

    }
}

