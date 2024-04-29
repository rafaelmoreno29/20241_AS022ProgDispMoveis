package com.example.atividaderecycler.dataset;

import com.example.atividaderecycler.R;
import com.example.atividaderecycler.models.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeDataset {
    public static List<Filme> getFilmes(){
        ArrayList<Filme> filmes =  new ArrayList<>();
        filmes.add(new Filme("Coração Valente","1995","Mel Gibson","Sinopse Coração Valente", R.mipmap.coracao));
        filmes.add(new Filme("O último dos Moicanos","1992","Michael Mann","Sinopse Moicanos", R.mipmap.moicanos));
        filmes.add(new Filme("Forrest Gump","1994","Robert Zemeckis","Sinopse Forrest", R.mipmap.forest));

        return  filmes;
    }
}
