package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class Sort extends AppCompatActivity {
    int swaps;
    int comparaciones;
    int counter;
    LinkedList steps= new LinkedList();
    Integer[] array = getArray(MainActivity.inputs);
    int type = MainActivity.sortType;

    /**
     * Método principal de esta pantalla, invoca el método de ordenamiento.
     * @param savedInstanceState muestra la pantalla.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        final TextView stepText = findViewById(R.id.stepList);
        Button btnNext = findViewById(R.id.btnNextStep);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stepText.setText(printbySteps());
            }
        });
        sort();
    }

    /**
     * Se obtiene el método de ordenamiento seleccionado.
     */
    public void sort(){
        TextView text = findViewById(R.id.typeText);
        TextView swapTxt = findViewById(R.id.swapText);
        TextView compTxt = findViewById(R.id.compText);
        TextView arrayTxt = findViewById(R.id.arrayText);
        if (type == 1){
            bubbleSort();
            text.setText("Bubble Sort!");
        } else if (type == 2){
            selectionSort();
            text.setText("Selection Sort!");

        } else {
            insertionSort();
            text.setText("Insertion Sort!");
        }
        System.out.println(swaps);
        System.out.println(comparaciones);
        swapTxt.setText("Swaps: "+swaps);
        compTxt.setText("Comparaciones: "+comparaciones);
        arrayTxt.setText("Lista Ordenada: "+ arrayToString(array));
    }

    /**
     * Método de ordenamiento: BubbleSort.
     */
    public void bubbleSort() {
        comparaciones = swaps = 0;
        steps.clear();
        steps.add(arrayToString(array));

        int n = array.length;
        int temp;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(array[j-1] > array[j]){
                    //Swap
                    swaps++;
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    steps.add(arrayToString(array));
                }
                comparaciones++;
            }
        }
        System.out.println("Swaps: "+swaps);
        System.out.println("Comparaciones: "+comparaciones);
    }

    /**
     * Método de ordenamiento: SelectionSort.
     */
    public void selectionSort(){
        comparaciones = swaps = 0;
        steps.clear();
        steps.add(arrayToString(array));

        for (int i = 0; i < array.length; i++){
            int index = i;
            boolean entrada = false;

            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    entrada = true;
                    index = j;
                }
                comparaciones++;
            }

            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;

            if (entrada){
                swaps++;
                steps.add(arrayToString(array));
            }
        }
        System.out.println("Swaps: "+swaps);
        System.out.println("Comparaciones: "+comparaciones);
    }

    /**
     * Método de ordenamiento: InsertionSort.
     */
    public void insertionSort (){
        comparaciones = swaps = 0;
        steps.clear();

        int size = array.length;
        for (int i = 1; i < size; ++i) {
            int current = array[i];
            int j = i - 1;

            boolean ajuste = false;

            comparaciones++;
            while (j >= 0 && array[j] > current) {
                if (!ajuste){
                    comparaciones--;
                    ajuste = true;
                    swaps++;
                    steps.add(arrayToString(array));
                }
                comparaciones++;
                array[j + 1] = array[j];
                j = j - 1;
            }
            if (array[j+1] > current && j != -1)
                comparaciones++;
            array[j + 1] = current;
        }
        steps.add(arrayToString(array));
        System.out.println("Swaps: "+swaps);
        System.out.println("Comparaciones: "+comparaciones);
    }

    /**
     * Método para convertir un arreglo a String.
     * @param array Recibe un arreglo con todos los números introducidos por el usuario. (Integer[])
     * @return retorna una cadena con todos los números del arreglo. (String)
     */
    public String arrayToString(Integer[] array){
        String str;
        str="[";

        for (int i =0; i<array.length;i++){
            str=str+array[i]+" ";
        }
        str=str+"]";

        return str;
    }

    /**
     * Método encargado de mostrar el paso a paso de los swaps del ordenamiento.
     * @return Retorna una cadena con los caracteres tras cada swap. (String)
     */
    public String printbySteps(){
        String arraystr = (String)steps.get(counter);
        arraystr = counter+1+" "+ arraystr;

        if (counter == steps.size()-1){
            counter=0;
        }
        else{
            counter++;
        }
        return arraystr;
    }

    /**
     * Método para obtener el arreglo de la primera pantalla.
     * @param linkedlist Recibe la lista con los números a ordenar. (LinkedList)
     * @return retorna el arreglo con los números introducidos en la primera pantalla. (Integer[])
     */
    public Integer[] getArray(LinkedList<Integer> linkedlist){
        Integer[] arrayInputs = linkedlist.toArray(new Integer[linkedlist.size()]);
        return arrayInputs;
    }
}