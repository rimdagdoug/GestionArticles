package com.example.gestiondesarticles;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelp extends SQLiteOpenHelper {
    private static final String DB_Name = "polytechnique.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "etudiant";
    private static final String ID_COL = "id";
    private static final String LIBELLE_COL = "libelle";
    private static final String QTE_COL = "qte";
    private static final String PRIX_COL = "prix";

    public MyDBHelp(Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LIBELLE_COL + " TEXT, "
                + QTE_COL + " INTEGER, "
                + PRIX_COL + " REAL)";
        db.execSQL(query);
    }

    public void add(String libelle, int qte, double prix) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LIBELLE_COL, libelle);
        values.put(QTE_COL, qte);
        values.put(PRIX_COL, prix);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void delete(String libelle) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, LIBELLE_COL + "=?", new String[]{libelle});
        db.close();
    }

    public Cursor getListe() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
