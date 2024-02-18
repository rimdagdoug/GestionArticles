package com.example.gestiondesarticles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Supprimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);
    }



    public void detour(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void supprimer(View view) {
        EditText libelleEdt = findViewById(R.id.editTextText);
        String libelle = libelleEdt.getText().toString();

        Log.d("Supprimer", "Libelle à supprimer : " + libelle); // Ajoutez ce log pour voir la valeur du libellé

        MyDBHelp myDBHelp = new MyDBHelp(this);
        if (libelle.isEmpty()) {
            Toast.makeText(Supprimer.this, "Veuillez saisir toutes les données.", Toast.LENGTH_SHORT).show();
            return;
        }

        myDBHelp.delete(libelle);
        Toast.makeText(Supprimer.this, "Article supprimé avec succès", Toast.LENGTH_SHORT).show();
    }

}