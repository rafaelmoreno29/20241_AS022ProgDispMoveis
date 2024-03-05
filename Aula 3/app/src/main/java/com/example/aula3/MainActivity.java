package com.example.aula3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit3;
    AutoCompleteTextView editPais;
    String[] listaPaises;
    ArrayAdapter<String> adapterPaises;
    Spinner spinnerPais;
    CheckBox checkBox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(MainActivity.this,""+isChecked,
                    Toast.LENGTH_SHORT).show();
        });

        editPais = (AutoCompleteTextView)findViewById(R.id.textPais);
        listaPaises = getResources().getStringArray(R.array.paises_array);
        adapterPaises = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,listaPaises);
        editPais.setAdapter(adapterPaises);

        spinnerPais = (Spinner)findViewById(R.id.spinnerPais);
        spinnerPais.setAdapter(adapterPaises);


        edit3 = (EditText) findViewById(R.id.editText3);
        edit3.setOnEditorActionListener((v, actionId, event) -> {
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
            Toast.makeText(MainActivity.this,"Pesquisar!!!",
                    Toast.LENGTH_SHORT).show();
            return false;
            }
            return false;
        });
    }
}