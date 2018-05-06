package com.app.web.ags.colombiaelige.controllers;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.app.web.ags.colombiaelige.POJOS.Candidate;
import com.app.web.ags.colombiaelige.models.CandidatesModel;

import java.util.ArrayList;
import java.util.List;

public class CandidatesController {

    private CandidatesModel candidatesModel;

    public CandidatesController(Context context) {
        candidatesModel = new CandidatesModel(context);
    }

    /**
     * Ejecuta registro del usuario
     * @param candidate
     */
    public void registryCandidate(Candidate candidate) {
        candidatesModel.registryCandidate(candidate);
    }

    /**
     * Recorre los registros de los candidatos y devuelve un listado con la informacion de cada uno
     * @return List con la informacion de cada candidatos
     */
    public List<Candidate> getPresidentialCandidate() {
        List<Candidate> candidates = new ArrayList<>();
        Cursor cursor = candidatesModel.getPresidentialCandidates();
        while (cursor.moveToNext()) {
            Candidate candidate = new Candidate(
                    cursor.getString(cursor.getColumnIndex("dni")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("lastname")),
                    cursor.getString(cursor.getColumnIndex("politic_party")),
                    cursor.getString(cursor.getColumnIndex("image")),
                    cursor.getString(cursor.getColumnIndex("type"))
            );
            candidates.add(candidate);
        }
        return candidates;
    }

}
