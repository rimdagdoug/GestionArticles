package com.example.gestiondesarticles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Ajouter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
    }

    public void retourmain(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void ajouter(View view) {
        EditText libelleEdt = findViewById(R.id.editTextTextLibelle);
        EditText qteEdt = findViewById(R.id.editTextTextQte);
        EditText prixEdt = findViewById(R.id.editTextTextPrix);

        String libelle = libelleEdt.getText().toString();
        String qteStr = qteEdt.getText().toString();
        String prixStr = prixEdt.getText().toString();

        // Vérifier si les champs obligatoires sont vides
        if (libelle.isEmpty() || qteStr.isEmpty() || prixStr.isEmpty()) {
            Toast.makeText(Ajouter.this, "Veuillez saisir toutes les données.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convertir qte et prix en entier et double respectivement
        int qte = Integer.parseInt(qteStr);
        double prix = Double.parseDouble(prixStr);

        // Créer une instance de MyDBHelp
        MyDBHelp myDBHelp = new MyDBHelp(this);

        // Ajouter l'étudiant avec les informations saisies
        myDBHelp.add(libelle, qte, prix);

        // Afficher un message de succès
        Toast.makeText(Ajouter.this, "Produit ajouté avec succès.", Toast.LENGTH_SHORT).show();
    }
}