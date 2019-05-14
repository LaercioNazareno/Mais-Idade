package com.maisIdade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.maisIdade.DAO.VideoDAO;
import com.maisIdade.R;
import com.maisIdade.model.Video;

public class AddVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video);

        final EditText nomeVideoEditText = findViewById(R.id.nomeVideoEditText), tipoVideoEditText = findViewById(R.id.tipoVideoEditText),
                urlEditText = findViewById(R.id.urlEditText);
        Button addVideoButton = findViewById(R.id.addVideoButton), cancelarAddVideoBtn = findViewById(R.id.cancelarAddVideoBtn);

        addVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Video video = new Video(nomeVideoEditText.getText().toString(),tipoVideoEditText.getText().toString(),urlEditText.getText().toString());
                VideoDAO videoDAO = new VideoDAO(getBaseContext());
                videoDAO.insert(video);
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cancelarAddVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
