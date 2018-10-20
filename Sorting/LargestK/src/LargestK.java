/*
Top K



Problem Statement:



You are given an array of integers which is analogous to a continuous stream of input. Find K largest elements from a given stream of numbers. By definition, we don't know the size of the input stream. Hence produce K largest elements seen so far, at any given time. For repeated numbers, return them only once.



If there are less than K unique elements, return all of them.



Note:

Represent input stream as an array. Don't rely on its size.
Feel free to use built-in functions if you need a specific data-structure.


Input Format:



Integer array
Repeats are possible
Input may or may not be sorted


Output Format:



Return an integer array containing K largest elements. If there are less than K unique elements, return all of them. If there are duplicates, return only one instance.
Order of output does not matter.


Constraints:



1 <= N <= 10^5

1 <= K <= 10^5

Given array may contain duplicate numbers.



Sample Test Case:



Sample Input-1:



arr = [1, 5, 4, 4, 2]; k = 2



Sample Output-1:



[4, 5]



Sample Input-2:



arr = [1, 5, 1, 5, 1]; k = 3



Sample Output-2:



[5, 1]
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestK {
    public static void main (String[] args){
//        int[] arr = null;
//        int[] arr = {};
        int[] arr = {1, 5, 4, 4, 2};
//        int[] arr = {1, 5, 1, 5, 1};
        int k = 3;

        if(arr !=null ) {
            int[] sortedHeap = topK(arr,k);
            System.out.println(Arrays.toString(sortedHeap));
        }
        else{
            System.out.println("Array is null or empty");
        }
    }

    private static int[] topK(int[] arr, int k) {
        if (arr.length < k)
            return arr;

        int[] heap = new int[k];
        int i=0,j=0;
        while(j<k && i<arr.length){
            if(!contains(heap,arr[i])) {
                heap[j++] = arr[i];
            }
            i=i+1;
        }

        buildMinHeap(heap);

        while(i < arr.length){
            if (!contains(heap,arr[i]) && arr[i]>heap[0]) {
                heap[0] = arr[i];
                minHeapify(heap, k, 0);
            }
            i=i+1;
        }
        return heap;
    }

    private static void buildMinHeap(int[] arr){
        int size = arr.length;
        for(int i=size/2-1;i>=0;i--){
            minHeapify(arr,size,i);
        }
    }

    private static void minHeapify(int[] arr,int size,int i){
        int index=i,lc=2*i+1,rc=2*i+2;
        if(lc<size && lc<arr[index])
            index=lc;
        if(rc<size && rc<arr[index])
            index=rc;
        if(index!=i) {
            swap(arr, i, index);
            minHeapify(arr, size, index);
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
