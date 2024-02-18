package com.example.gestiondesarticles;



import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MyDBHelp myDB;

        ListView listeArticle = findViewById(R.id.listView);

        myDB = new MyDBHelp(this);

        ArrayList<String> list = new ArrayList<>();
        Cursor data = myDB.getListe();
        if(data.getCount() == 0){
            Toast.makeText(this, "LISTE VIDE", Toast.LENGTH_SHORT).show();
        } else {
            while(data.moveToNext()){
                // Adapter le code en fonction des nouveaux attributs
                int id = data.getInt(data.getColumnIndexOrThrow("id"));
                String libelle = data.getString(data.getColumnIndexOrThrow("libelle"));
                int qte = data.getInt(data.getColumnIndexOrThrow("qte"));
                double prix = data.getDouble(data.getColumnIndexOrThrow("prix"));

                // Ajouter les données à la liste
                list.add(id + " : " + libelle + ", Quantité: " + qte + ", Prix: " + prix);
            }
            // Définir l'adaptateur en dehors de la boucle pour éviter de le réinitialiser à chaque itération
            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            listeArticle.setAdapter(listAdapter);
        }
    }
}
