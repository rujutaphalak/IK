import java.util.Arrays;

public class QuickSort {

    public static void main (String[] args) {
//        int[] arr = null;
//        int[] arr = {};
//        int[] arr = {2};
//        int[] arr = {2,1};
          int[] arr = {1,3,2};
//        int[] arr = {8, 15, 3, -7, 0, 5};
//        int[] arr = {1, 6, 4, 0, 2, 3};

        if (arr == null || arr.length == 0 ) {
            System.out.println("Array is null or empty");
        }
        else
        {
            arr = new int[]{1, 6, 4, 0, 2, 3};
            System.out.println("Unsorted array is " + Arrays.toString(arr));
            QuickSort qs = new QuickSort();
            qs.QuickSort(arr);
            System.out.println("Final sorted array using Quick Sort is " + Arrays.toString(arr));

            System.out.println("----------------------------------------------");

            arr = new int[]{1, 6, 4, 0, 2, 3};
            System.out.println("Unsorted array is " + Arrays.toString(arr));
            MergeSort ms = new MergeSort();
            ms.MSort(arr,0,arr.length-1);
            System.out.println("Final sorted array using Merge Sort is " + Arrays.toString(arr));

            System.out.println("----------------------------------------------");

            arr =  new int[]{1,12,9,5,6,10};
            System.out.println("Unsorted array is " + Arrays.toString(arr));
            HeapSort maxhs = new HeapSort();
            maxhs.maxheapSort(arr);
            System.out.println("Final sorted array using max heap in Heap Sort is " + Arrays.toString(arr));

            System.out.println("----------------------------------------------");

            arr =  new int[]{4,6,3,2,9};
              System.out.println("Unsorted array is " + Arrays.toString(arr));
              HeapSort minhs = new HeapSort();
              minhs.minHeapSort(arr);
              System.out.println("Final sorted array using min heap in Heap Sort is " + Arrays.toString(arr));
        }
    }
    public void QuickSort(int[] arr) {
        QSort(arr, 0, arr.length-1);
    }

    private void QSort(int[] arr, int start, int end) {

        //Base case
        if(arr == null) return;

        if(start >= end) return;

        //if start < end
        int pivot = choosePivot(arr, start, end);
        int partition = partition(arr, start, end, pivot);

        QSort(arr, start, partition - 1);
        QSort(arr, partition + 1, end);
    }

    //Return last element as the pivot
    private int choosePivot(int[] arr, int start, int end) {
        return end;
    }

    //Partition implementation with last element as the pivot
    private int partition(int[] arr, int start, int end, int pivot){
        int i=start;
        for (int j=start; j<end; j++) {
            if(arr[j] <= arr[pivot]){
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, pivot);
        return i;
    }

    //Return mid element as the pivot
//    private int choosePivot(int[] arr, int start, int end) {
//        return start+(end-start)/2;
//    }
//
//    //Partition implementation with mid element as the pivot
//    private int partition(int[] arr, int start, int end, int pivot){
//        int i=start;
//        for (int j=start; j<=end; j++) {
//            if(arr[j] <= arr[pivot]){
//                swap(arr, i, j);
//                i++;
//            }
//        }
//
//        swap(arr, i, pivot);
//        return i;
//    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
