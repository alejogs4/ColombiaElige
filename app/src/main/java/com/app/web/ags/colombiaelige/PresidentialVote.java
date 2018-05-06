package com.app.web.ags.colombiaelige;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.app.web.ags.colombiaelige.Adapters.CandidatesAdapter;
import com.app.web.ags.colombiaelige.POJOS.Candidate;
import com.app.web.ags.colombiaelige.controllers.CandidatesController;

import java.util.List;

public class PresidentialVote extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Candidate> candidates;
    private CandidatesAdapter candidatesAdapter;

    private CandidatesController candidatesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presidential_vote);
        candidatesController = new CandidatesController(getApplication());
        candidates = candidatesController.getPresidentialCandidate();
        recyclerView = findViewById(R.id.presidential_candidates);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        candidatesAdapter = new CandidatesAdapter(getApplicationContext(),candidates);
        recyclerView.setAdapter(candidatesAdapter);
    }

}
