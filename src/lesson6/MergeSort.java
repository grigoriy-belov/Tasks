package lesson6;

import java.util.Arrays;

public class MergeSort {
    int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        int[] arr = {13, 16, 9, 15, 7, 11, 5, 1};
        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.sort();
        System.out.println(Arrays.toString(arr));
    }

    public void sort() {
        int[] workSpace = new int[arr.length];
        recMergeSort(workSpace, 0, workSpace.length - 1);
    }

    private void recMergeSort(int[] workSpace, int lowerBound, int upperBound) {
        if (upperBound == lowerBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            // sort low half
            recMergeSort(workSpace, lowerBound, mid);
            // sort high half
            recMergeSort(workSpace, mid + 1, upperBound);
            // merge them
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(int[] workspace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;                  // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;    // # of items

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (arr[lowPtr] < arr[highPtr]) {
                workspace[j++] = arr[lowPtr++];
            } else {
                workspace[j++] = arr[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            workspace[j++] = arr[lowPtr++];
        }

        while (highPtr <= upperBound) {
            workspace[j++] = arr[highPtr++];
        }

        for (int i = 0; i < n; i++) {
            arr[lowerBound + i] = workspace[i];
        }
    }
}
