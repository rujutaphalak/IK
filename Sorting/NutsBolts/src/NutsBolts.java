/*
Nuts and Bolts!





Problem Statement:



A disorganized carpenter has a mixed pile of bolts and nuts and would like to find the corresponding pairs of bolts and nuts. Each nut matches exactly one bolt and vice versa. By trying to match a bolt and a nut the carpenter can see which one is bigger, but she cannot compare two bolts or two nuts directly. Can you help the carpenter match the nuts and bolts quickly?

In other words: You are given a collection of nuts of different size and corresponding bolts. You can choose any nut & any bolt together, from which you can determine whether the nut is larger than the bolt, smaller than the bolt or matches the bolt exactly. However, there is no way to compare two nuts together or two bolts together. (i.e. we cannot sort all nuts or sort all bolts). Write an algorithm to match each bolt to its matching nut.



You can make the following assumptions:

There are equal number of nuts and bolts
A given nut uniquely matches a bolt. i.e. There are no extra unmatched nuts or extra bolts. i.e. every nut has one and only one matching bolt and vice-versa.
Note: You cannot compare a bolt to a bolt and a nut to a nut. So you cannot use in-built sorts.



Input Format:



You will be given two integer arrays, NUTS[] and BOLTS[] of size N.

There is only one to one mapping between NUTS and BOLTS. So there will be no duplicate elements.



Output Format:



Return a String array of size N with an entry for each pair of Nut and its corresponding Bolt separated by space only once.

Format: “Nut Bolt”

Order of the output does not matter.


Constraints:



1 <= N <= 10^5

1 <= NUT <= 10^9

1 <= BOLT <= 10^9



Sample Test Case:



Sample Input-1:



NUTS = [4, 32, 5, 7]

BOLTS = [32, 7, 5, 4]



Sample Output-1:



4 4

32 32

5 5

7 7
 */


public class NutsBolts {

    public static void main(String[] args) {
//      int[] nuts = null;
//      int[] bolts = null;
//      int[] nuts = {};
//      int[] bolts = {};
        int[] nuts = {4, 32, 5, 7};
        int[] bolts = {32, 7, 5, 4};

        String[] result = solve(nuts, bolts);
        if (result==null)
            System.out.println("Both or one of the nuts or bolts is empty or null");
        else {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }

    private static String[] solve ( int[] nuts, int[] bolts){
        if (nuts == null || bolts == null)
            return null;
        if (nuts.length == 0 || bolts.length == 0 || nuts.length > Math.pow(10, 5) || bolts.length > Math.pow(10, 5))
            return null;
        String[] result = new String[nuts.length];
        for (int i=0;i<bolts.length;i++) {
            for (int j=0;j<nuts.length;j++) {
                if (nuts[j] == bolts[i]) {
                    result[i] = String.valueOf(nuts[j]) +" "+ String.valueOf(bolts[i]);
                }
            }
        }
        return result;
    }
}

