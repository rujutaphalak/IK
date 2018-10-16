/*
3 Sum





Problem Statement:



Given an array of N integers, find all triplets that sum to 0 (zero).



Triplets may or may not be consecutive numbers.
The array can include duplicate elements.
Array is not necessarily sorted.
Print output as shown. i.e. as strings, one per line, comma separated elements. See sample for clarity.
Order of elements inside the answer triplets does not matter. i.e. if your output elements are the same, but only in different order, then it's an acceptable solution.
Do not print duplicate triplets. Eg: 1,1,-2 and 1,-2,1 are duplicates.
If no such triplets are found, then print nothing.


Input Format:



Integer array
Input may or may not be sorted
Repeats possible


Output Format:



Return a String array containing all possible triplets who sum to 0. One String for one triplet.

Order of output does not matter.



Constraints:



1 <= N <= 2000

-10^3 <= element <= 10^3

Given array may contains duplicate numbers.



Sample Test Case:



Sample Input-1:



arr = [10, 3, -4, 1, -6, 9];



Sample Output-1:



10,-4,-6

3,-4,1



Sample Input-2:



arr = [12, 34, -46];



Sample Output-2:



12,-46,34



Sample Input-3:



arr = [0, 0, 0];



Sample Output-3:



0,0,0



Sample Input-4:



arr = [-2, 2, 0 -2, 2];



Sample Output-4:



2,-2,0
 */
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static void main (String[] args){
//        int[] arr = null;
//        int[] arr = {};
//        int[] arr = {10, 3, -4, 1, -6, 9};
//        int[] arr = {12,34,-46};
//        int[] arr = {0,0,0};
        int[] arr = {-2, 2, 0 -2, 2};  //not working for this.

        if(arr.length >2) {
            String[] result = findZeroSum(arr);
            System.out.println(Arrays.toString(arr));
            for (String res : result)
                System.out.println(res);
        }
    }

    private static String[] findZeroSum(int[] arr) {
        ArrayList<String> result = new ArrayList<>();

        //sort the array using quick sort.
        quickSort(arr);

        //remove duplicates and return the new size of the array
        int newSize = removeDuplicates(arr);

        //then sum the zero and store in a string array
        int i=0;
        while(i<newSize-1) {
            int j = i+1,k=newSize-1;
            while (k > j) {
                if (arr[i] + arr[j] + arr[k] == 0) {
                    if (!result.contains(arr[i] + "," + arr[j] + "," + arr[k]))
                        result.add(arr[i] + "," + arr[j] + "," + arr[k]);
                }
                k--;
            }
            i++;
        }
        return result.toArray(new String[0]);
    }

    private static void quickSort(int[] arr){
        qsort(arr,0, arr.length-1);
    }

    private static void qsort(int[] arr, int start, int end) {

        if(start>=end) return;

        int pivot=choosePivot(arr, start, end);
        int index=partition(arr,start,pivot,end);

        qsort(arr,start,index-1);
        qsort(arr,index+1,end);

    }

    private static  int choosePivot(int[] arr, int start, int end){
        return end;
    }

    private static int partition(int[] arr, int start,int index, int end){
        int i=start,j=start;
        while(j<end){
            if (arr[i] <= arr[index]) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr,i,index);
        return index;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static int removeDuplicates(int[] arr){
        int i=0;
        for(int j=0;j<arr.length-1;j++){
            if(arr[j] != arr[j+1]){
                arr[i] = arr[j];
                i++;
            }
        }
        arr[i]=arr[arr.length-1];
        return i+1;
    }
}
