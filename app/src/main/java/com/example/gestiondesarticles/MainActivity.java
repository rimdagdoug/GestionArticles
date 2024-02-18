package com.example.gestiondesarticles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void ajouterArticle(View view) {
        Intent i = new Intent(this,Ajouter.class);
        startActivity(i);
    }

    public void supprimerArticle(View view) {
        Intent i = new Intent(this,Supprimer.class);
        startActivity(i);
    }

    public void consult(View view) {
        Intent i = new Intent(this,List.class);
        startActivity(i);
    }
}