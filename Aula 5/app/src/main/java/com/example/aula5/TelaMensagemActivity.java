package com.example.aula5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class TelaMensagemActivity extends AppCompatActivity {
    Button btnEnviar, btnVoltar;
    EditText textMensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_mensagem);
        btnEnviar = (Button) findViewById(R.id.buttonEnviar);
        btnVoltar = (Button) findViewById(R.id.buttonVoltar);
        textMensagem = (EditText) findViewById(R.id.textMensagem);

        btnVoltar.setOnClickListener(v -> {
            finish();
        });
        btnEnviar.setOnClickListener(v -> {
            Intent intent = new Intent();
            String msg = textMensagem.getText().toString();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,msg);
            intent.setType("text/plain");
            startActivity(intent);
        });
    }
}