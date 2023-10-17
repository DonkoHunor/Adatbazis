package com.example.adatbazis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button olvasas;
    private Button rogzites;
    private Button modositas;
    private Button torles;
    private TextView TV;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        TV.setMovementMethod(new ScrollingMovementMethod());
        rogzites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdatrogzitesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        modositas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ModositasActivity.class);
                startActivity(intent);
                finish();
            }
        });

        torles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TorlesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        olvasas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adatLekerdezes();
            }
        });
    }

    public void adatLekerdezes() {
        Cursor adatok = dbHelper.adatLekerdezes();
        if(adatok.getCount() == 0){
            Toast.makeText(this, "Nincs az adatbázisban bejegyzés", Toast.LENGTH_SHORT).show();
        }
        else{
            StringBuffer builder = new StringBuffer();
            while (adatok.moveToNext()){
                builder.append("ID: ").append(adatok.getInt(0)).append("\n");
                builder.append("Vezetéknév: ").append(adatok.getString(1)).append("\n");
                builder.append("Keresztnév: ").append(adatok.getString(2)).append("\n");
                builder.append("Jegy: ").append(adatok.getInt(4)).append("\n\n");
            }
            TV.setText(builder);
        }

    }
    public void init(){
        olvasas = findViewById(R.id.olvasasBtn);
        rogzites = findViewById(R.id.rogzitesBtn);
        modositas = findViewById(R.id.modositasBtn);
        torles = findViewById(R.id.torlesBtn);

        TV = findViewById(R.id.TV);

        dbHelper = new DBHelper(MainActivity.this);
    }
}