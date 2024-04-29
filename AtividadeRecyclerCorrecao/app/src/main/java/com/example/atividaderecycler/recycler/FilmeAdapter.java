package com.example.atividaderecycler.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividaderecycler.R;
import com.example.atividaderecycler.models.Filme;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeHolder> {
    private List<Filme> filmes;

    public FilmeAdapter(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public FilmeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new FilmeHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeHolder holder, int position) {
        Filme f = filmes.get(position);
        holder.txtTitulo.setText(f.getTitulo());
        holder.txtDiretor.setText(f.getDiretor());
        holder.txtAno.setText(f.getAno());
        holder.imagem.setImageResource(f.getImagem());
        holder.btnSinopse.setOnClickListener(v -> {
            Toast.makeText(v.getContext(),f.getSinopse(),Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return filmes != null ? filmes.size() : 0;
    }
}
