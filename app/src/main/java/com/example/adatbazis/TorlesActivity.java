package com.example.adatbazis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TorlesActivity extends AppCompatActivity {

    private EditText id;
    private Button torles;
    private Button vissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torles);
        init();
        torles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText().toString().isEmpty()){
                    Toast.makeText(TorlesActivity.this, "Meg kell adni egy ID-t!", Toast.LENGTH_SHORT).show();
                }
                else {

                }
            }
        });
        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TorlesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init(){
        id = findViewById(R.id.idTorolET);
        torles = findViewById(R.id.torolBtn);
        vissza = findViewById(R.id.vissza3Btn);
    }
}