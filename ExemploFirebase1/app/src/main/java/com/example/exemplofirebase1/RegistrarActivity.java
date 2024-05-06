package com.example.exemplofirebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrarActivity extends AppCompatActivity {
    EditText txtEmail, txtSenha;
    ProgressBar progressBar;
    Button buttonSalvar;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        txtEmail = (EditText) findViewById(R.id.editEmail);
        txtSenha = (EditText) findViewById(R.id.editSenha);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        mAuth = FirebaseAuth.getInstance();
        buttonSalvar.setOnClickListener(v -> inserirUsuario());
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(getApplicationContext(),ListaUsuarioActivity.class);
            startActivity(i);
            finish();
        }
    }


    public void inserirUsuario(){
        if(TextUtils.isEmpty(txtEmail.getText())){
            Toast.makeText(getApplicationContext(),
                    "E-mail obrigatório",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(txtSenha.getText())){
            Toast.makeText(getApplicationContext(),
                    "Senha obrigatória",Toast.LENGTH_SHORT).show();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(
          txtEmail.getText().toString(), txtSenha.getText().toString())
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),
                            "Salvo com sucesso!",Toast.LENGTH_SHORT).show();
                        Intent i =
                         new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                     Toast.makeText(getApplicationContext(),
                             "Erro ao salvar!",Toast.LENGTH_SHORT).show();
                    }
                    progressBar.setVisibility(View.GONE);
                });
    }
}