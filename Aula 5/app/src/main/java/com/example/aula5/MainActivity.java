package com.example.aula5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonEnviaMensagem, buttonLigacao,buttonSite,
    buttonMapa, buttonNavegacao, buttonTirarFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTirarFoto = (Button)findViewById(R.id.buttonTirarFoto);
       buttonEnviaMensagem = (Button) findViewById(R.id.buttonTelaMensagem);
       buttonLigacao = (Button)findViewById(R.id.buttonLigacao);
       buttonSite = (Button)findViewById(R.id.buttonSite);
       buttonMapa = (Button)findViewById(R.id.buttonMapa);
       buttonNavegacao = (Button)findViewById(R.id.buttonNavegar);

       buttonTirarFoto.setOnClickListener(v -> {
           Intent intent = new Intent(MainActivity.this,FotoActivity.class);
           startActivity(intent);
       });

       buttonNavegacao.setOnClickListener(v -> {
           Uri gmmIntentUri = Uri.parse("google.navigation:q=Avenida+general+carneiro+1427");
           Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//   mapIntent.setPackage("com.google.android.apps.maps");
           startActivity(mapIntent);

       });

       buttonMapa.setOnClickListener(v -> {
           Uri gmmIntentUri = Uri.parse("geo:0,0?q=Avenida+general+carneiro+1427");
           Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//   mapIntent.setPackage("com.google.android.apps.maps");
           startActivity(mapIntent);
       });

       buttonSite.setOnClickListener(v ->{
           Uri uri = Uri.parse("https://facens.br");
           Intent intent = new Intent(Intent.ACTION_VIEW,uri);
           startActivity(intent);
       });

       buttonLigacao.setOnClickListener(v -> {
           Uri uri = Uri.parse("tel:15999999999");
           Intent intent = new Intent(Intent.ACTION_CALL,uri);
           int permissionCheck = ContextCompat.
                   checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);
           if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
               ActivityCompat.requestPermissions(this,
                       new String[]{android.Manifest.permission.CALL_PHONE},1);
           } else {
               startActivity(intent);
           }
       });

       buttonEnviaMensagem.setOnClickListener(v -> {
           Intent intent =
                   new Intent(MainActivity.this,TelaMensagemActivity.class);
           startActivity(intent);
       });
    }
}