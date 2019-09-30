package Insertion;

public class InsertionSort {

    static int swaps;
    static int comp;

    static void sort (int[] arr){
        swaps = 0;
        comp = 0;

        int size = arr.length;
        for (int i = 1; i < size; ++i) {
            int current = arr[i];
            int j = i - 1;

            comp++;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                swaps++;
                j = j - 1;
            }
            arr[j + 1] = current;
            //print array
        }

    }


}
