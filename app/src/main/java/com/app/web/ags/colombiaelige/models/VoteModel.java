package com.app.web.ags.colombiaelige.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;


import com.app.web.ags.colombiaelige.POJOS.Candidate;
import com.app.web.ags.colombiaelige.POJOS.Citizen;
import com.app.web.ags.colombiaelige.POJOS.Votes;
import com.app.web.ags.colombiaelige.POJOS.VotesResults;
import com.app.web.ags.colombiaelige.database.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class VoteModel {

    /** Atributos **/
    private DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public VoteModel(Context context) {
        dbHelper = new DbHelper(context);
        this.context = context;
    }

    /** Abre conexion a la base de datos **/
    private void open() { sqLiteDatabase = dbHelper.getWritableDatabase(); }

    /** Cierra conexion a la base de datos **/
    private void close() { sqLiteDatabase.close(); }

    /**
     * Verifica si el ciudadano puede votar
     * @return true si el ciudadano puede votar falso en caso contrario
     */
    public boolean canCitizenToVote(String dni) {
        open();
        String columns[] = { "*" };
        String selection[] = { dni };
        Cursor cursor = sqLiteDatabase.query("votes",columns,"cedula=?",selection,null,null,null);
        boolean isAvaible = !cursor.moveToFirst();
        close();
        return isAvaible;
    }

    /**
     * Registra a un ciudadano para poder votar
     * @param citizen objeto con los datos del ciudadano
     */
    public void registryCitizen(Citizen citizen) {
        open();
        sqLiteDatabase.insert("voters", null, citizen.toValues());
        close();
    }

    /**
     * Registra voto del ciudadano
     * @param votes objeto con los datos del voto
     */
    public void registryVote(Votes votes) {
        open();
        sqLiteDatabase.insert("votes", null, votes.toValues());
        close();
    }

    /**
     * Consigue una lista de los candidatos con su respectivo numero de votos
     * @return List<VotesResults> con los resultados electorales
     */
    public List<VotesResults> counts() {
        open();
        List<VotesResults> votesResults = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT c.name AS nombre, COUNT(v.dni) AS votos FROM candidates AS c INNER JOIN votes AS v ON c.dni = v.dni GROUP BY c.name",null,null);
        if(cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("nombre"));
                int votes = cursor.getInt(cursor.getColumnIndex("votos"));

                // Agregamos a la lista un nuevo resultado
                votesResults.add(new VotesResults(name, votes));
            } while(cursor.moveToNext());
        }
        close();
        return votesResults;
    }

}
