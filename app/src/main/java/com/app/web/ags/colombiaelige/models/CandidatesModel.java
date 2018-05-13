package com.app.web.ags.colombiaelige.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.web.ags.colombiaelige.POJOS.Candidate;
import com.app.web.ags.colombiaelige.database.DbHelper;

import java.util.ArrayList;
import java.util.List;

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
    public List<Candidate> getPresidentialCandidates() {
        open();
        String columns[] = { "dni", "name", "lastname", "politic_party" , "image"};
        Cursor cursor = sqLiteDatabase.query("candidates",columns,null,null,null,null,null);
        List<Candidate> candidates = new ArrayList<>();
        while (cursor.moveToNext()) {
            Candidate candidate = new Candidate(
                    cursor.getString(cursor.getColumnIndex("dni")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("lastname")),
                    cursor.getString(cursor.getColumnIndex("politic_party")),
                    cursor.getString(cursor.getColumnIndex("image"))
            );
            candidates.add(candidate);
        }
        close();
        return candidates;
    }

}
