package com.example.exemplofirebase1.holders;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplofirebase1.MainActivity;
import com.example.exemplofirebase1.R;
import com.example.exemplofirebase1.models.Usuario;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioHolder>
{
    private final ArrayList<Usuario> usuarios;

    public UsuarioAdapter(ArrayList<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsuarioHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_usuario,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.textNome.setText(usuario.getNome());
        holder.buttonExcluir.setOnClickListener(v -> {
            usuarios.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position,usuarios.size());
        });
        holder.buttonEditar.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Clicou editar",
                    Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return usuarios != null ? usuarios.size() : 0;
    }
}
