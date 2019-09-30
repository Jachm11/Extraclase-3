package com.example.pruebalogin.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebalogin.R;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    //Array listaNumeros = new ArrayList();
    //int[] listaNumeros = new int[5];
    //int cont = 0;
    LinkedList listaNumeros = new LinkedList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       /* loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);*/

        final EditText agregarNumero = findViewById(R.id.numero);
        final Button loginButton = findViewById(R.id.login);
        final Button showButton = findViewById(R.id.show);
        final Button sortButton = findViewById(R.id.sort);

        /*
        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });*/

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaNumeros.insertLastLink(Integer.parseInt(agregarNumero.getText().toString()));
                /*listaNumeros[cont] = Integer.parseInt(agregarNumero.getText().toString());
                cont++;*/

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
            }
        });
    }
    private void sortMethod(){
        for (int i = 0; i < listaNumeros.size()-1; i++){
            int index = i;

            for (int j = i+1; j < listaNumeros.size(); j++){
                if (listaNumeros.get(j) < listaNumeros.get(index))
                    index = j;

                int smallerNumber = (int) listaNumeros.get(index);
                listaNumeros.overwrite(listaNumeros.search(listaNumeros.get(index)), listaNumeros.get(i));
                listaNumeros.overwrite(listaNumeros.search(listaNumeros.get(i)), smallerNumber);
            }
        }
    }
}