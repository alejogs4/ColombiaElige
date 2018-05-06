package com.app.web.ags.colombiaelige;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.app.web.ags.colombiaelige.R;

public class MainActivity extends AppCompatActivity {

    private Button openRegistryCandidateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();

        openRegistryCandidateButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,RegisterCandidate.class);
            startActivity(intent);
        });
    }

    private void connect() {
        openRegistryCandidateButton = findViewById(R.id.register_candidate_button);
    }
}
