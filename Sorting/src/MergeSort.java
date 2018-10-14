public class MergeSort {

    public void MSort(int[] arr, int start, int end){

        //base case
        if (start >= end) return;

       int mid = start + (end-start)/2;

       //These can never be as follows as it will fail when there are 2 elements, mid will be 0, start will be 0 and end will become -1
       // MergeSort(arr, start, mid-1);
       // MergeSort(arr, mid, end);
       MSort(arr, start, mid);
       MSort(arr, mid+1, end);

       Merge(arr, start, mid, end);
    }

    private void Merge(int[] arr, int start, int mid, int end) {

        //base case
        if(start > end) return;

        int arrayLength1 = (mid-start)+1;
        int arrayLength2 = end-mid;

        int[] array1 = new int[arrayLength1];
        int[] array2= new int[arrayLength2];
        for(int i=start,j=0;i<=mid;i++){
            array1[j] = arr[i];
            j++;
        }
        for(int i=mid+1,j=0;i<=end;i++){
            array2[j] = arr[i];
            j++;
        }

        int i=0, j=0, k=start;

        while(i<arrayLength1 && j<arrayLength2) {
            if (array1[i] <= array2[j]) {
                arr[k] = array1[i];
                k++;
                i++;
            }
            else {
                arr[k] = array2[j];
                k++;
                j++;
            }
        }

        while(i < arrayLength1){
            arr[k] = array1[i];
            k++; i++;
        }

        while(j < arrayLength2){
            arr[k] = array2[j];
            k++; j++;
        }
    }
}