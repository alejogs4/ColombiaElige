package com.app.web.ags.colombiaelige;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.app.web.ags.colombiaelige.POJOS.Candidate;
import com.app.web.ags.colombiaelige.models.CandidatesModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegisterCandidate extends AppCompatActivity {

    /**Field about data of the candidates**/
    private EditText dniField;
    private EditText nameField;
    private EditText lastnameField;
    private EditText politicPartyField;
    private EditText urlImageField;

    private Button registerCandidateButton;

    private CandidatesModel candidatesModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_candidate);
        connect();

        candidatesModel = new CandidatesModel(getApplicationContext());

        registerCandidateButton.setOnClickListener(view -> {
            if(areThereAnyEmptyField()) {
                Toast.makeText(getApplicationContext(),"Tienes que llenar todos los datos",Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                Candidate candidate = new Candidate(dniField.getText().toString(),nameField.getText().toString(),
                                                    lastnameField.getText().toString(),
                                                    politicPartyField.getText().toString(),
                                                    urlImageField.getText().toString());
                candidatesModel.registryCandidate(candidate);
                Toast.makeText(getApplicationContext(),"Candidato registrado",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Verifica si existe alguno de los campos vacion
     * @return true si existe algun campo vacio, false en caso contrario
     */
    private boolean areThereAnyEmptyField() {
        return dniField.getText().toString().isEmpty() || nameField.getText().toString().isEmpty() ||
               lastnameField.getText().toString().isEmpty() || politicPartyField.getText().toString().isEmpty() ||
               urlImageField.getText().toString().isEmpty();
    }

    private void connect() {
        dniField = findViewById(R.id.dni_candidate_field);
        nameField = findViewById(R.id.name_candidate_field);
        lastnameField = findViewById(R.id.lastname_candidate_field);
        politicPartyField = findViewById(R.id.party_candidate_field);
        urlImageField = findViewById(R.id.image_candidate_field);

        registerCandidateButton = findViewById(R.id.register_candidate_execute);
    }
}
