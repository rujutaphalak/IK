import java.util.Arrays;

public class QuickSort {

    public static void main (String[] args) {
//        int[] arr = null;
//        int[] arr = new int[]{};
//        int[] arr = new int[]{2};
//        int[] arr = new int[]{1,3,2};
        int[] arr = new int[]{1, 6, 4, 0, 2, 3};

        if (arr == null || arr.length == 0 ) {
            System.out.println("Array is null or empty");
        }
        else
        {
            System.out.println("Unsorted array is " + Arrays.toString(arr));
            QSort(arr,0,arr.length-1);
            System.out.println("Final sorted array is " + Arrays.toString(arr));
        }
    }

    public static void QSort(int[] arr, int start, int end) {

        if(arr == null) return;

        if(start == end) return;

        if(start<end) {
            int pivot = choosePivot(arr, start, end);
            int partition = partition(arr, start, end, pivot);

            QSort(arr, start, partition - 1);
            QSort(arr, partition + 1, end);
        }
    }

    public static int choosePivot(int[] arr, int start, int end) {
        return end;
    }

    public static int partition(int[] arr, int start, int end, int pivot){
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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
