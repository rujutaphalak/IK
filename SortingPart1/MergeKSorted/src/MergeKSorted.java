public class MergeKSorted {

    public static void main(String[] args) {

        int k = 3, n =  4;

        int arr[][] = { {1, 3, 5, 7},
                        {2, 4, 6, 8},
                        {0, 9, 10, 11}
                      };

    }

    static int[] mergeArrays(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;
        int y=0,j=0,i=0;
        int[] result = new int[n*k];
        int[] minHeap = new int[k];

        while(j<n) {
            while(i<k)
            {
                minHeap[i] = arr[i][j];
            }

            buildMinHeap(minHeap);
                swap(minHeap, 0, i);
                result[y] = minHeap[i];
                y = y + 1;
                j=;
                i=
            }

        }
        return result;
    }

    private static void buildMinHeap(int[] arr){
        for(int i=arr.length/2-1;i>=0;i--){
            minHeapify(arr, i);
        }
    }

    private static void minHeapify(int[] arr, int i){

        int index=i,lc=2*i+1,rc=2*i+2,size=arr.length;
        if (lc<size && arr[lc]<arr[index])
            index=lc;
        if (rc<size && arr[rc]<arr[index])
            index=rc;

        if(index!=i)
            swap(arr,index,i);
            minHeapify(arr,index);

    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

