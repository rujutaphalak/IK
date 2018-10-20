/*
Merge K sorted arrays, size N each





Problem Statement:



This is a popular facebook problem. Given K sorted arrays of size N each, merge them and print the sorted output. Assume N is very large compared to K. N may not even be known. The arrays could be just sorted streams, for instance, timestamp streams.

All arrays might be sorted in increasing manner or decreasing manner. Sort all of them in the manner they appear.



Don't use inbuilt sorts or any standard sorting algorithm after simply merging the lists.



Note:



Repeats are allowed.
Negative numbers and zeros are allowed.
Assume all arrays are sorted in the same order. Preserve that sort order in output.
It is possible to find out the sort order from at least one of the arrays.


Input Format:



2-D Integer array
Repeats possible
Individual integer array is sorted


Output Format:



Return an integer array containing all elements from all individual arrays combined.



Constraints:



2 <= N <= 500

1 <= K <= 500

-10^6 <= element <= 10^6



Sample Test Case:



Sample Input-1:



K = 3, N =  4

arr[][] = { {1, 3, 5, 7},

            {2, 4, 6, 8},

            {0, 9, 10, 11}} ;



Sample Output-1:



[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 */

import java.util.Arrays;

public class MergeKSorted {

    public static void main(String[] args) {

        int k = 3, n =  4;

        int arr[][] = { {1, 3, 5, 7},
                        {2, 4, 6, 8},
                        {0, 9, 10, 11}
                      };
        int[] result = mergeArrays(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeArrays(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;
        int x=0,y=0,i=0;
        int[] result = new int[n*k];
        int[] minHeap = new int[k];

        while(y<n) {
            while (x < k) {
                if (!contains(minHeap, arr[x][y]))
                    minHeap[i++] = arr[x++][y];
                x++;
            }

            buildMinHeap(minHeap);
            int j = 0;
            int lastElem = minHeap.length - 1;
            while (lastElem >= 0) {
                swap(minHeap, 0, lastElem);
                result[j++] = minHeap[lastElem];
                lastElem--;
            }
        }
        return result;
    }

    private static void buildMinHeap(int[] arr){
        for(int i=arr.length/2-1;i>=0;i--){
            minHeapify(arr, i, arr.length);
        }
    }

    private static void minHeapify(int[] arr, int i, int size){

        int index=i,lc=2*i+1,rc=2*i+2;
        if (lc<size && arr[lc]<arr[index])
            index=lc;
        if (rc<size && arr[rc]<arr[index])
            index=rc;

        if(index!=i) {
            swap(arr, index, i);
            minHeapify(arr, index, size);
        }

    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static boolean contains(int[] arr, int item) {
        for (int n : arr) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }
}

