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

    public void bubbleSort() {
        comparaciones = 0;
        steps.clear();
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
                }
                comparaciones++;
            }

            steps.add(arrayToString(array));

        }

        System.out.println(" ");
        System.out.println("Swaps: "+swaps);
        System.out.println("Comparaciones: "+comparaciones);
        printArray(array);
    }

    public void selectionSort(){
        for (int i = 0; i < array.length; i++){
            int index = i;
            boolean entrada = false;

            for (int j = i+1; j < array.length; j++) {

                if (array[j] < array[index]) {
                    entrada = true;
                    //System.out.println(listaNumeros.get(j)+" < "+listaNumeros.get(index));
                    index = j;
                    //swaps += 1;
                    //swaps += 1;
                    //swaps++;
                    //comparaciones++;
                }
                comparaciones++;
            }

            if (entrada)
                swaps++;


            /*int smallerNumber = listaNumeros.get(index);
            listaNumeros.overwrite(listaNumeros.search(listaNumeros.get(index)), listaNumeros.get(i));
            listaNumeros.overwrite(listaNumeros.search(listaNumeros.get(i)), smallerNumber);*/
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;

            /*
            System.out.println("");
            for (int x = 0; x<listaNumeros.size(); x++){
                System.out.print(listaNumeros.get(x) + " ");
            }*/
        }
    }

    public void insertionSort (){
        steps.clear();
        comparaciones = 0;
        printArray(array);
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
                }
                comparaciones++;
                array[j + 1] = array[j];
                swaps++;
                j = j - 1;
            }
            if (array[j+1] > current && j != -1){
                comparaciones++;
            }
            array[j + 1] = current;
            printArray(array);
            steps.add(arrayToString(array));
        }

        System.out.println("swaps "+swaps);
        System.out.println("comps "+comparaciones);
    }

    public void printArray(Integer[] array){
        String arrayStr;
        arrayStr ="Array: [";
        //System.out.print("Array: [");
        for (int i =0; i<array.length;i++){
            arrayStr = arrayStr+array[i]+" ";
            //System.out.print(array[i]+" ");
        }
        arrayStr = arrayStr+"]";
        //System.out.print("]");
        System.out.println(arrayStr);
    }

    public String arrayToString(Integer[] array){
        String str;
        str="[";

        for (int i =0; i<array.length;i++){
            str=str+array[i]+" ";
        }
        str=str+"]";

        return str;
    }
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

    public Integer[] getArray(LinkedList<Integer> linkedlist){

        Integer[] arrayInputs = linkedlist.toArray(new Integer[linkedlist.size()]);
        return arrayInputs;
    }
}