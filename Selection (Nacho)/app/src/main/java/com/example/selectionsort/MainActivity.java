package com.example.selectionsort;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    LinkedList listaNumeros = new LinkedList();
    int comparaciones = 0;
    int swaps = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText agregarNumero = findViewById(R.id.numero);
        final Button loginButton = findViewById(R.id.login);
        final Button showButton = findViewById(R.id.show);
        final Button sortButton = findViewById(R.id.sort);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaNumeros.insertLastLink(Integer.parseInt(agregarNumero.getText().toString()));

                agregarNumero.setText("");
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < listaNumeros.size(); i++) {
                    System.out.println(listaNumeros.get(i));
                }
            }
        });

        sortButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sortMethod();
                for (int i = 0; i < listaNumeros.size(); i++){
                    System.out.println(listaNumeros.get(i));
                }
                System.out.println("Swaps: "+swaps);
                System.out.println("Comparaciones: "+comparaciones);
            }
        });
    }

    private void sortMethod(){
        for (int i = 0; i < listaNumeros.size()-1; i++){
            int index = i;
            boolean entrada = false;

            for (int j = i+1; j < listaNumeros.size(); j++) {

                if (listaNumeros.get(j) < listaNumeros.get(index)) {
                    entrada = true;
                    System.out.println(listaNumeros.get(j)+" < "+listaNumeros.get(index));
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


            int smallerNumber = listaNumeros.get(index);
            listaNumeros.overwrite(listaNumeros.search(listaNumeros.get(index)), listaNumeros.get(i));
            listaNumeros.overwrite(listaNumeros.search(listaNumeros.get(i)), smallerNumber);


            System.out.println("");
            for (int x = 0; x<listaNumeros.size(); x++){
                System.out.print(listaNumeros.get(x) + " ");
            }
        }
    }
}