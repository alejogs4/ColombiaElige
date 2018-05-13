package com.app.web.ags.colombiaelige;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.web.ags.colombiaelige.POJOS.Citizen;
import com.app.web.ags.colombiaelige.models.VoteModel;

public class SelectVote extends AppCompatActivity {

    private Button presidential;
    private EditText dniField;
    private VoteModel voteModel;

    private TextView showStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_vote);
        connect();
        voteModel = new VoteModel(getApplicationContext());

        presidential.setOnClickListener(view -> {
            if( !dniFieldIsEmpty() ) {
                String dni = dniField.getText().toString().trim();
                if( voteModel.canCitizenToVote(dni) ) {
                    Intent intent = new Intent(SelectVote.this,PresidentialVote.class);
                    intent.putExtra("dni", dni);
                    startActivity(intent);
                    return;
                }
                Toast.makeText(getApplicationContext(),"Ya has votado anteriormente",Toast.LENGTH_SHORT)
                .show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Debes de ingresar tu cedula",Toast.LENGTH_SHORT)
                .show();
            }
        });

        showStatistics.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ShowStatistics.class);
            startActivity(intent);
        });
    }

    /**
     * Verifica si el dni esta vacio
     * @return
     */
    private boolean dniFieldIsEmpty() {
        return  dniField.getText().toString().isEmpty();
    }

    private void connect() {
        presidential = findViewById(R.id.president_button);
        dniField = findViewById(R.id.citizen_dni);
        showStatistics = findViewById(R.id.statistics);
    }
}
