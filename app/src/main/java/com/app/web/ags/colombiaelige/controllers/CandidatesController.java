package com.app.web.ags.colombiaelige.controllers;

import android.content.Context;
import android.widget.Toast;

import com.app.web.ags.colombiaelige.POJOS.Candidate;
import com.app.web.ags.colombiaelige.models.CandidatesModel;

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

}
