/*
Group the numbers





Problem Statement:



You are given an array of non-negative integers only. Group them in-place into evens and odds in such a way that all evens appear on the left side and all odds on the right side.



Input Format:



0 <= element <= 10^9



Integer array
Repeats possible.


Output Format:



Return the same integer array, with evens on left side and odds on the right side. There is no need to preserve order within odds or within evens.



Constraints:



1 <= n <= 10^5

Given array may contain duplicate numbers.

Solutions with linear time complexity and constant auxiliary space is expected.



Sample Test Case:



Sample Input:



[1, 2, 3, 4]



Sample Output:



[4, 2, 1, 3]



Explanation:



Order does not matter. Other valid solutions are

[2, 4, 1, 3]

[2, 4, 3, 1]

[4, 2, 3, 1]


 */

import java.util.Arrays;

public class GroupNumbers {

    public static void main (String[] args){
//        int[] arr = null;
//        int[] arr = {};
//        int[] arr ={1, 2, 3, 4};
//        int[] arr ={2, 6, 3, 4};
//        int[] arr ={1, 5, 3, 4};
//        int[] arr ={2, 4, 0, 4};
//        int[] arr ={5, 9, 4, 2};
        int[] arr ={5, 9, 3, 7};

        if(arr !=null ) {
            int[] result = solve(arr);
            System.out.println(Arrays.toString(result));
        }
        else{
            System.out.println("Array is null or empty");
        }
    }

    private static int[] solve(int[] arr){
        if (arr.length < 1){
            return arr;
        }
        int i=0,j=1,size=arr.length;

        while(j<size){
            if (arr[i]%2==1 && arr[j]%2==0){
                swap(arr,i,j);
                i=i+1;
                if(i==j) {
                    j=j+1;
                }
            }

            else if (arr[i]%2==1 && arr[j]%2==1){
                    j=j+1;
            }

            else if (arr[i]%2==0 && arr[j]%2==0){
                i=i+2;
                j=j+2;
            }

            else {
                i=i+1;
                j=j+1;
            }
        }
        return arr;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
