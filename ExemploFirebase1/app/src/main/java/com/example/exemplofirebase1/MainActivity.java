package com.example.exemplofirebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.exemplofirebase1.models.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    FloatingActionButton buttonSalvar;
    Usuario usuario;
    EditText txtNome,txtSobrenome, txtFoto,txtAno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.editTextNome);
        txtSobrenome = (EditText)findViewById(R.id.editTextSobrenome);
        txtAno = (EditText)findViewById(R.id.editTextAno);
        txtFoto= (EditText)findViewById(R.id.editTextFoto);
        buttonSalvar = (FloatingActionButton) findViewById(R.id.buttonSalvar);
        usuario = new Usuario();
        db = FirebaseFirestore.getInstance();

        if(getIntent().getExtras()!= null){
            //passou parametro
            usuario.setId(getIntent().getStringExtra("id"));
            usuario.setNome(getIntent().getStringExtra("nome"));
            usuario.setSobrenome(getIntent().getStringExtra("sobrenome"));
            usuario.setFoto(getIntent().getStringExtra("foto"));
            usuario.setAnoNascimento(getIntent()
                                    .getIntExtra("anoNascimento",0));
            txtNome.setText(usuario.getNome());
            txtSobrenome.setText(usuario.getSobrenome());
            txtAno.setText(usuario.getAnoNascimento() + "");
            txtFoto.setText(usuario.getFoto());
        }

        buttonSalvar.setOnClickListener(v -> {
            usuario.setAnoNascimento(Integer.parseInt(txtAno.getText().toString()));
            usuario.setNome(txtNome.getText().toString());
            usuario.setSobrenome(txtSobrenome.getText().toString());
            usuario.setFoto(txtFoto.getText().toString());

            if(getIntent().getExtras()!= null) {            //editar

                db.collection("usuarios").document(usuario.getId()).set(usuario);

            }else{
                //inserir
                db.collection("usuarios").add(usuario);
            }
            finish();
        });

    }

}