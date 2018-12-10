/*
Possible To Achieve Target Sum?
Problem Statement:

Given an array arr of size n and a target sum k.

You have to determine, whether there exists a group of numbers (numbers need not to be contiguous and group can not be empty) in arr such that their sum equals to k.

Input Format:
There are two argument. First one is arr and second one is k.

Output Format:
Return a boolean denoting your answer.

Constraints:

1 <= n <= 18
-10^17 <= arr[i], k <= 10^17

Sample Test Cases:

Sample Input 1:
arr = [2 4 8]
k = 6


Sample Output 1:
True

Explanation 1:
arr[0] + arr[1] = 6

Sample Input 2:
arr = [2 4 6]
k = 5

Sample Output 2:
False

Explanation 2:
There does not exists any group such that its sum equals to k.
 */
public class NonEmptySubsetSum {

    public static void main(String []args){
        long[] arr = {1,-50};
        int k = 5;
        if(check_if_sum_possible(arr,k))
            System.out.println("Found a subset with target");
        else
            System.out.println("Did not find a subset with target");
    }

    public static boolean check_if_sum_possible(long[] arr, long k) {
        return check_sum_rec(arr,0,k,false);
    }

    /* We can keep a total/difference(will need one int variable less than total) at each subset. To handle empty subsets
       with target of 0, that should not return true, hence there is a flag to check in the recurring function that tells if the set
       is empty or not.
    */
    private static boolean check_sum_rec(long[] arr, int i, long difference, boolean notEmpty){

        if(difference == 0 && notEmpty == true)
            return true;

        if(i == arr.length)
            return false;

        return check_sum_rec(arr, i+1, difference, notEmpty) || check_sum_rec(arr, i+1, difference-arr[i],true);
    }
}
