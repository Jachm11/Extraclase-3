package Insertion;

public class InsertionSort {

    static int swaps;
    static int comp;

    static void sort (int[] arr){
        swaps = 0;
        comp = 0;
        printArray(arr);
        int size = arr.length;
        for (int i = 1; i < size; ++i) {
            int current = arr[i];
            int j = i - 1;

            boolean ajuste = false;

            comp++;
            while (j >= 0 && arr[j] > current) {
                if (!ajuste){
                    comp--;
                    ajuste = true;
                }
                comp++;
                arr[j + 1] = arr[j];
                swaps++;
                j = j - 1;
            }
            if (arr[j+1] > current && j != -1){
                comp++;
            }
            arr[j + 1] = current;
            printArray(arr);
    }

        System.out.println("swaps "+swaps);
        System.out.println("comps "+comp);


    }
    public static void printArray(int[] array){
        System.out.print("Array: [");
        for (int i =0; i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("]");
    }


}
