package com.app.web.ags.colombiaelige;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class SelectVote extends AppCompatActivity {

    private Button presidential;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_vote);
        connect();

        presidential.setOnClickListener(view -> {
            Intent intent = new Intent(SelectVote.this,PresidentialVote.class);
            startActivity(intent);
        });
    }

    private void connect() {
        presidential = findViewById(R.id.president_button);
    }
}
