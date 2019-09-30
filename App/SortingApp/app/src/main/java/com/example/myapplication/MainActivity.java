package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<Integer> inputs = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Boton de sort
        Button sort = findViewById(R.id.sort);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("hola");
            }
        });

        //Text input
        final EditText entrie = findViewById(R.id.entries);

        //Text view
        final TextView lista = findViewById(R.id.lista);


        //Boton de add
        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(entrie.getText());
                Integer integer = Integer.parseInt((entrie.getText()).toString());
                inputs.add(integer);
                entrie.setText(null);
                lista.setText(inputs.toString());
                
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

    }

}
