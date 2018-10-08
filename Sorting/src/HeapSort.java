public class HeapSort {

    public void maxheapSort(int[] array) {
        //Build the max heap
        buildMaxHeap(array);

        //Continue heap sorting until we have one element left.
        //lastElement is array.length-1 because we start with 0 here to do max heapify.
        //NOTE: while building maxheap we pass array.length and not array.length-1
        for(int lastElement=array.length-1; lastElement>=0; lastElement--) {
            swap(array,0,lastElement);
            maxHeapify(array,0,lastElement);
        }
    }

    private void buildMaxHeap(int[] arr){
        //Find the parent node in the lowest level
        int size = arr.length;

        for(int i=(size/2)-1; i>=0;i--){
            maxHeapify(arr,i,size);
        }
    }

    private void maxHeapify(int[] arr, int i, int size){
        int index = i, lc = 2*i+1, rc=2*i+2;
        if(lc<size && arr[lc]>arr[index])
            index=lc;

        if(rc<size && arr[rc]>arr[index])
            index=rc;

        if(index != i) {
            swap(arr, index, i);
            maxHeapify(arr, index, size);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void minHeapSort(int[] array) {
        //Build the min heap
        buildMinHeap(array);

        //Continue heap sorting until we have one element left.
        //lastElement is array.length-1 because we start with 0 here to do min heapify.
        //NOTE: while building maxheap we pass array.length and not array.length-1
        for(int lastElement=array.length-1; lastElement>=0; lastElement--) {
            swap(array,0,lastElement);
            minHeapify(array,0,lastElement);
        }
    }


    private void buildMinHeap(int[] arr){
        //Find the parent node in the lowest level
        int size = arr.length;

        for(int i=(size/2)-1; i>=0;i--){
            minHeapify(arr,i,size);
        }
    }

    private void minHeapify(int[] arr, int i, int size){
        int index = i, lc = 2*i+1, rc=2*i+2;
        if(lc<size && arr[lc]<arr[index])
            index=lc;

        if(rc<size && arr[rc]<arr[index])
            index=rc;

        if(index != i) {
            swap(arr, index, i);
            minHeapify(arr, index, size);
        }
    }
}
