package com.example.adatbazis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModositasActivity extends AppCompatActivity {

    private EditText id;
    private EditText vezNev;
    private EditText kerNev;
    private EditText jegy;
    private Button modositas;
    private Button vissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modositas);
        init();
        modositas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText().toString().isEmpty() || vezNev.getText().toString().isEmpty() || kerNev.getText().toString().isEmpty() ||  jegy.getText().toString().isEmpty()){
                    Toast.makeText(ModositasActivity.this, "Mindenek kell értéket adni!", Toast.LENGTH_SHORT).show();
                }
                else {

                }
            }
        });
        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModositasActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init()
    {
        id = findViewById(R.id.idET);
        vezNev = findViewById(R.id.vezNevModET);
        kerNev = findViewById(R.id.kerNevModET);
        jegy = findViewById(R.id.jegyModET);

        modositas = findViewById(R.id.modositBtn);
        vissza = findViewById(R.id.vissza2Btn);
    }
}