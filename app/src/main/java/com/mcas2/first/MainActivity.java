package com.mcas2.first;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

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

        Button callDialogButton = findViewById(R.id.callDialogButton);
        callDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setIcon(R.drawable.logo)
                        .setTitle("Hola " + name)
                        .setMessage("Bienvenidos a nuevo estilo de Alert Dialog")
                        .setPositiveButton("Ese no es mi nombre", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Snackbar.make(view, "Si ese no es tu nombre puedes cambiarlo", Snackbar.LENGTH_SHORT)
                                        .setAction("Cambiar", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Toast.makeText(MainActivity.this, "Clickado", Toast.LENGTH_SHORT).show(); 
                                            }
                                        })
                                         .show();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Has cancelado", Toast.LENGTH_SHORT).show();
                            }
                        })
                        //.setView(R.layout.custom_alert_dialog)
                        ;
                materialAlertDialogBuilder.show();
            }
        });

        welcomeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setIcon(R.drawable.logo);
                dialogBuilder.setTitle("Bienvenido a Walkers");
                dialogBuilder.setMessage("Hola " + name);
                dialogBuilder.setCancelable(true);
                dialogBuilder.setPositiveButton("Sí, soy yo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Qué pena que no seas tú", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}