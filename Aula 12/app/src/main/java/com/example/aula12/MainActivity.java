package com.example.aula12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtNumero;
    Button btnIniciar;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumero = (TextView) findViewById(R.id.textViewNumero);
        btnIniciar = (Button) findViewById(R.id.buttonIniciar);

        btnIniciar.setOnClickListener(v -> {
            progress = new ProgressDialog(MainActivity.this);
            progress.setMessage("Carregando...");
            progress.setCancelable(false);
            progress.show();
           new Thread(() -> {
               for (int i =0; i <= 10; i++){
                   final int x = i;
                   runOnUiThread(() -> {
                       txtNumero.setText(""+x);
                       if(x == 10)
                       {
                           progress.dismiss();
                       }
                   });
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
           }).start();
        });
    }
}