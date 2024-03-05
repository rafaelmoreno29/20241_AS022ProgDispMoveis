package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView texto2;
    private EditText texto1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("OnCreate","Entrou no método Oncreate");
        setContentView(R.layout.activity_main);
        texto1 = (EditText) findViewById(R.id.textTexto1);
        texto2 = (TextView) findViewById(R.id.textTexto2);
    }

    public void buttonCopiarClick(View view){
        texto2.setText(texto1.getText().toString());
        Toast.makeText(this,"TEXTO!!!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("OnStart","Entrou no método OnStart");
    }

    @Override
    protected void onResume() {
        Log.i("OnResume","Entrou no método OnResume");
        super.onResume();
    }
}