package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class Sort extends AppCompatActivity {
    int swaps;
    int comparaciones;
    int counter;
    LinkedList steps= new LinkedList();
    Integer[] array = getArray(MainActivity.inputs);
    int type = 0;


    public Sort(){
        TextView text = findViewById(R.id.typeText);
        if (type == 0){
            bubbleSort(array);
            text.setText("Bubble Sort!");}
        else if (type == 1){
            text.setText("Selection Sort!");
        }
        else {
            text.setText("Insertion Sort!");
        }

    }
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
    }

    public void bubbleSort(Integer[] array) {
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
        if (counter == steps.size()){
            counter=0;
        }
        else{
            counter++;
        }
        String arraystr = (String)steps.get(counter);
        arraystr = counter+1+" "+ arraystr;
        return arraystr;
    }

    public Integer[] getArray(LinkedList<Integer> linkedlist){
        //MainActivity getinputs = new MainActivity();
        //LinkedList<Integer> linkedlist = new LinkedList<>();
        // linkedlist = getinputs.inputs;

        Integer[] arrayInputs = linkedlist.toArray(new Integer[linkedlist.size()]);
        return arrayInputs;
    }


}
