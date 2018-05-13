package com.app.web.ags.colombiaelige;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.app.web.ags.colombiaelige.Adapters.CandidatesAdapter;
import com.app.web.ags.colombiaelige.POJOS.Candidate;
import com.app.web.ags.colombiaelige.POJOS.Citizen;
import com.app.web.ags.colombiaelige.POJOS.Votes;
import com.app.web.ags.colombiaelige.models.CandidatesModel;
import com.app.web.ags.colombiaelige.models.VoteModel;

import java.util.List;

public class PresidentialVote extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Candidate> candidates;
    private CandidatesAdapter candidatesAdapter;

    private CandidatesModel candidatesModel;
    private VoteModel voteModel;
    private boolean isVote = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presidential_vote);

        candidatesModel = new CandidatesModel(getApplication());
        candidates = candidatesModel.getPresidentialCandidates();
        voteModel = new VoteModel(getApplicationContext());

        recyclerView = findViewById(R.id.presidential_candidates);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        Bundle extras = getIntent().getExtras();
        String dni = extras.getString("dni");

        candidatesAdapter = new CandidatesAdapter(getApplicationContext(),candidates);
        recyclerView.setAdapter(candidatesAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                try {
                    View view = rv.findChildViewUnder(e.getX(),e.getY());
                    if(view != null && !isVote) {
                        int position = rv.getChildAdapterPosition(view);
                        // Registro ciudadano y registro voto
                        voteModel.registryCitizen(new Citizen(dni));
                        voteModel.registryVote(new Votes(candidates.get(position).getDni(),dni));
                        Toast.makeText(getApplicationContext(),"Felicitaciones por votar",Toast.LENGTH_SHORT).show();
                        isVote = true;
                        finish();
                        return true;
                    }
                }
                catch (Exception exception) {
                    Toast.makeText(getApplicationContext(),exception.getMessage(),Toast.LENGTH_SHORT).show();

                }
                return false;
            }
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) { }
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) { }
        });
    }
}
