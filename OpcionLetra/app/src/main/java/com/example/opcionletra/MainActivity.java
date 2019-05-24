package com.example.opcionletra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText text;
    TextView txtErro, txtPala;
    String str;
    int palabras, errores;
    /*Thread mHiloPala = new Thread() {

        @Override
        public void run() {
            if (str.length() > 0 && str != null) {
                for (int i = 1;
                     i < str.length();
                     i++) {
                    if (str.charAt(i) != ' ' && str.charAt(i - 1) == ' ') {
                        palabras++;
                    }
                }
                if (str.charAt(0) != ' ')
                    palabras++;
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String tmp = palabras + "";
                    txtPala.setText(tmp);
                }
            });
            System.out.println("ya acabe");
        }

    };*/

    /* Thread mHiloChistosa = new Thread() {
        @Override
        public void run() {
            if (str.length() > 4 && str != null) {
                for (int i = 0; i <= str.length() - 4; i++) {
                    if (str.charAt(i) != 'C' && str.charAt(i + 1) == 'i' && str.charAt(i + 2) == 'o' && str.charAt(i + 3) == 'n') {
                        errores++;
                    }
                }
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String tmp2 = errores + "";
                    txtErro.setText(tmp2);
                }
            });

        }
    };*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.edtTxtText);
        txtErro = findViewById(R.id.textViewErro);
        txtPala = findViewById(R.id.textViewPala);

        new Thread(){
            @Override
            public void run(){
                while(true){
                    try {
                        Thread.sleep((long) 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    palabras=0;
                errores=0;
                str = text.getText().toString();
                if (str.length() > 0 && str != null) {
                    for (int i = 1;
                         i < str.length();
                         i++) {
                        if (str.charAt(i) != ' ' && str.charAt(i - 1) == ' ') {
                            palabras++;
                        }
                    }
                    if (str.charAt(0) != ' ')
                        palabras++;

                    if (str.length() > 4 && str != null) {
                        for (int i = 0; i <= str.length() - 4; i++) {
                            if (    str.charAt(i) == 'c' &&
                                    str.charAt(i + 1) == 'i' &&
                                    str.charAt(i + 2) == 'o' &&
                                    str.charAt(i + 3) == 'n') {
                                errores++;
                            }
                        }
                    }


                }
                runOnUiThread(new Runnable() {//hilo para poder interactuar con la interfaz
                    @Override
                    public void run() {
                        String tmp = palabras + "";
                        txtPala.setText(tmp);
                        String tmp2 = errores + "";
                        txtErro.setText(tmp2);
                    }
                });

            }
            }
        }.start();

        /* new Thread() {
            @Override
            public void run() {
                while(true){
                String str2 = text.getText().toString();
                errores=0;
                if (str2.length() > 4 && str2 != null) {
                    for (int i = 0; i <= str2.length() - 4; i++) {
                        if (    str2.charAt(i) == 'c' &&
                                str2.charAt(i + 1) == 'i' &&
                                str2.charAt(i + 2) == 'o' &&
                                str2.charAt(i + 3) == 'n') {
                            errores++;
                        }
                    }
                }
                runOnUiThread(new Runnable() { //hilo para poder interactuar con la interfaz
                    @Override
                    public void run() {

                    }
                });

            }
            }
        }.start(); */


    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
