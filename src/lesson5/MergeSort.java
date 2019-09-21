package lesson5;

import java.util.Arrays;

public class MergeSort {
    int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        int[] arr = {13, 16, 9, 15, 7, 11, 5, 1};
        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.mergeSort();
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort()
    {
        int[] workSpace = new int[arr.length];
        recMergeSort(workSpace, 0, arr.length - 1);
    }

    private void recMergeSort(int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound+upperBound) / 2;
            // sort low half
            recMergeSort(workSpace, lowerBound, mid);
            // sort high half
            recMergeSort(workSpace, mid + 1, upperBound);
            // merge them
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(int[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;                             // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound-lowerBound + 1;       // # of items

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (arr[lowPtr] < arr[highPtr])
                workSpace[j++] = arr[lowPtr++];
            else
                workSpace[j++] = arr[highPtr++];
        }

        while(lowPtr <= mid)
            workSpace[j++] = arr[lowPtr++];

        while(highPtr <= upperBound)
            workSpace[j++] = arr[highPtr++];

        for(j = 0; j < n; j++)
            arr[lowerBound + j] = workSpace[j];
    }
}
