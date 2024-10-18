package com.mcas2.first;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        TextView addedText = findViewById(R.id.addedText);

        SharedPreferences sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("userName", "anónimo");
        String password = sharedPreferences.getString("userPassword", "contraseña");


        welcomeText.setText("Hola "+name);
        addedText.setText("Tu contraseña es "+password);
    }
}