package com.maisIdade.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.maisIdade.DAO.PdfDAO;
import com.maisIdade.DAO.VideoDAO;
import com.maisIdade.R;
import com.maisIdade.model.Pdf;
import com.maisIdade.model.Video;

import java.util.ArrayList;
import java.util.List;

public class AddVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video);

        final AutoCompleteTextView  tipoVideoEditText = findViewById(R.id.tipoVideoEditText);
        tipoVideoEditText.setAdapter(getAdapter());

        final EditText nomeVideoEditText = findViewById(R.id.nomeVideoEditText), urlEditText = findViewById(R.id.urlEditText);
        Button addVideoButton = findViewById(R.id.addVideoButton), cancelarAddVideoBtn = findViewById(R.id.cancelarAddVideoBtn);

        addVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton videoRB = findViewById(R.id.videoRB), pfdRB = findViewById(R.id.pdfRB);
                if(videoRB.isChecked()){
                    Video video = new Video(nomeVideoEditText.getText().toString(),tipoVideoEditText.getText().toString(),urlEditText.getText().toString());
                    VideoDAO videoDAO = new VideoDAO(getBaseContext());
                    videoDAO.insert(video);
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    if(pfdRB.isChecked()){
                        Pdf pdf = new Pdf(nomeVideoEditText.getText().toString(),tipoVideoEditText.getText().toString(),urlEditText.getText().toString());
                        PdfDAO pdfDAO = new PdfDAO(getBaseContext());
                        pdfDAO.insert(pdf);
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }

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

    private ArrayAdapter<String> getAdapter(){

        List<String> list = new ArrayList<>();
        list.add("Exercicio Equilibrio");
        list.add("Exercicio Memoria");
        list.add("prevençao contra quedas");
        list.add("dicas saude");
        list.add("incontinencia urinaria");
        list.add("direitos");
        ArrayAdapter<String> adapter = new ArrayAdapter(getBaseContext(),android.R.layout.simple_expandable_list_item_1,list);

        return adapter;
    }

}
