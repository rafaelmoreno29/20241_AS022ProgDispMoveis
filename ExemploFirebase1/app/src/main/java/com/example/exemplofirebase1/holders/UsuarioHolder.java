package com.example.exemplofirebase1.holders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplofirebase1.R;

public class UsuarioHolder extends RecyclerView.ViewHolder {
    TextView textNome;
    ImageButton buttonEditar,buttonExcluir;

    public UsuarioHolder(View item){
        super(item);
        textNome = item.findViewById(R.id.textNome);
        buttonEditar = item.findViewById(R.id.buttonEdit);
        buttonExcluir = item.findViewById(R.id.buttonDelete);
    }
}
