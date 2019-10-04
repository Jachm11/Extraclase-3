package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    static LinkedList<Integer> inputs = new LinkedList<>();
    static int sortType = 0; // 0 null, 1 bubble, 2 selection, 3 insertion
    int swaps = 0;
    int comparaciones = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Text input
        final EditText entrie = findViewById(R.id.entries);

        //Text view
        final TextView lista = findViewById(R.id.lista);


        //Boton de add
        final Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(entrie.getText().toString().equals(""))) {
                    Integer integer = Integer.parseInt((entrie.getText()).toString());
                    inputs.add(integer);
                    entrie.setText(null);
                    lista.setText(inputs.toString());

                }
            }
        });

        //Boton de clear
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputs = new LinkedList<>();
                lista.setText(inputs.toString());
            }
        });

        //Radio group
        RadioButton bubble = findViewById(R.id.bubble);
        bubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortType = 1;
                System.out.println(sortType);
            }
        });

        RadioButton selection = findViewById(R.id.selection);
        selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortType = 2;
                System.out.println(sortType);
            }
        });

        RadioButton insertion = findViewById(R.id.insertion);
        insertion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortType = 3;
                System.out.println(sortType);
            }
        });


        //Boton de sort
        final Button sort = findViewById(R.id.sort);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer[] array = inputs.toArray(new Integer[inputs.size()]);
                System.out.println(array);
                sortList();
               /*
               switch (sortType){
                   case 1:

                       sortList();
                       //Llamada al metodo void de Bubble(array)

                   case 2:
                       sortList();
                       //Llamada al metodo void de Selection(array)

                   case 3:
                       sortList();
                       //Llamada al metodo void de Insertion(array)
               */
                // Para estos metodos opino q lo mejor esq modifiquen variables en su clase
                // Para a hacer algo asi: simpre y cuando los metods de arriba esten en una clase.
                //Sino es lo mismo pero para cada metodo

               /*
                 comparaciones = claseDelMetodo.getComps();
                 swaps = claseDelMetodo.getSwaps();
                */
            }

            // Ejecuta el metodo que muestra en la pantalla lo que queremos
            //Puede ser algo como: mostrar(comparaciones,swaps,array de arrays)

            //}
        });

    }
    public void sortList(){
        Intent intent = new Intent(this , Sort.class);
        startActivity(intent);


    }

}
