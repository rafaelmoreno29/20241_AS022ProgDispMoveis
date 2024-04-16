package com.example.exemplofirebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.exemplofirebase1.holders.UsuarioAdapter;
import com.example.exemplofirebase1.models.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListaUsuarioActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UsuarioAdapter usuarioAdapter;
    public ArrayList<Usuario>usuarios;
    FirebaseFirestore db;
    FloatingActionButton btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);
        db = FirebaseFirestore.getInstance();
        usuarios = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewUsuario);
        btnadd = (FloatingActionButton)findViewById(R.id.floatingActionButtonAdd);
        btnadd.setOnClickListener(v -> {
            Intent i = new Intent(ListaUsuarioActivity.this,MainActivity.class);
            startActivity(i);
        });
        getUsuariosFireStore();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getUsuariosFireStore();

    }

    public void iniciarRecycler(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
       // LinearLayoutManager manager = new LinearLayoutManager(this,
         //       LinearLayoutManager.HORIZONTAL,false);
        //GridLayoutManager manager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(manager);
//        usuarioAdapter = new UsuarioAdapter(Usuario.getUsuarios());
        usuarioAdapter = new UsuarioAdapter(usuarios,db);
        recyclerView.setAdapter(usuarioAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL));
    }

    public void getUsuariosFireStore(){
       usuarios = new ArrayList<>();
        db.collection("usuarios").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Usuario usu = document.toObject(Usuario.class);
                        usu.setId(document.getId());
                        usuarios.add(usu);
                    }
                    Log.i("usuarios",usuarios.toString());
                    iniciarRecycler();
                }
            }
        });
    }
}