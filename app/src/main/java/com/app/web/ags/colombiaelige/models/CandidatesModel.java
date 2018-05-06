package com.app.web.ags.colombiaelige.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.web.ags.colombiaelige.POJOS.Candidate;
import com.app.web.ags.colombiaelige.database.DbHelper;

public class CandidatesModel {

    private DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public CandidatesModel(Context context) {
        this.dbHelper = new DbHelper(context);
    }

    /**
     * Realiza conexion a la base de datos
     */
    private void open() { sqLiteDatabase = dbHelper.getWritableDatabase(); }

    /**
     * Cierra conexion a la base de datos
     */
    private void close() { sqLiteDatabase.close(); }


    /**
     * Registra candidato en la base de datos
     * @param candidate
     */
    public void registryCandidate(Candidate candidate) {
        open();
        sqLiteDatabase.insert("candidates",null,candidate.toValues());
        close();
    }

    /**
     * Consigue el cursor para recorrer y asi conseguir los candidatos presidenciales
     * @return
     */
    public Cursor getPresidentialCandidates() {
        open();
        String columns[] = { "dni", "name", "lastname", "politic_party" , "image" , "type" };
        String condition[] = { "Presidencial" };
        Cursor cursor = sqLiteDatabase.query("candidates",columns,"type=?",condition,null,null,null);
        return cursor;
    }

}
