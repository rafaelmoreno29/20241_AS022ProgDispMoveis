package com.example.atividaderecycler.recycler;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividaderecycler.R;

public class FilmeHolder extends RecyclerView.ViewHolder {
    TextView txtTitulo, txtDiretor, txtAno;
    ImageView imagem;
    Button btnSinopse;

    public FilmeHolder(@NonNull View itemView) {
        super(itemView);
        txtAno = (TextView) itemView.findViewById(R.id.textViewAno);
        txtDiretor = (TextView) itemView.findViewById(R.id.textViewDiretor);
        txtTitulo = (TextView) itemView.findViewById(R.id.textViewTitulo);
        imagem = (ImageView) itemView.findViewById(R.id.imageView);
        btnSinopse = (Button) itemView.findViewById(R.id.buttonSinopse);
    }
}
