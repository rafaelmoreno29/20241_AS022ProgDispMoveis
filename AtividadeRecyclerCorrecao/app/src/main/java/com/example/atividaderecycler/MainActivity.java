package com.example.atividaderecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.atividaderecycler.dataset.FilmeDataset;
import com.example.atividaderecycler.recycler.FilmeAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FilmeAdapter filmeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        filmeAdapter = new FilmeAdapter(FilmeDataset.getFilmes());
        recyclerView.setAdapter(filmeAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
    }
}