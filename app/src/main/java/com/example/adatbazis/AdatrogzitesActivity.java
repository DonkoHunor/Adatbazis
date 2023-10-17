package com.example.adatbazis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdatrogzitesActivity extends AppCompatActivity {

    private EditText vezNev;
    private EditText kerNev;
    private EditText jegy;
    private Button rogzites;
    private Button vissza;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adatrogzites);
        init();
        rogzites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vezNev.getText().toString().isEmpty() || kerNev.getText().toString().isEmpty() ||  jegy.getText().toString().isEmpty()){
                    Toast.makeText(AdatrogzitesActivity.this, "Mindenek kell értéket adni!", Toast.LENGTH_SHORT).show();
                }
                else {
                    adathozzaAdas();
                }
            }
        });
        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdatrogzitesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void adathozzaAdas(){
        if(dbHelper.rogzites(vezNev.getText().toString(),kerNev.getText().toString(),Integer.parseInt(jegy.getText().toString()))){
            Toast.makeText(this, "Sikeres mentés", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Sikertelen adatfelvétel", Toast.LENGTH_SHORT).show();
        }
    }

    public void init(){
        vezNev = findViewById(R.id.vezNevET);
        kerNev = findViewById(R.id.kerNevET);
        jegy = findViewById(R.id.jegyET);

        rogzites = findViewById(R.id.rogzitesBtn);
        vissza = findViewById(R.id.vissza1Btn);

        dbHelper = new DBHelper(AdatrogzitesActivity.this);
    }
}