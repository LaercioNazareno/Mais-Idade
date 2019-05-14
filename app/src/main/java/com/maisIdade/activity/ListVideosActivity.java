package com.maisIdade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.maisIdade.DAO.VideoDAO;
import com.maisIdade.R;

import java.util.ArrayList;
import java.util.List;

public class ListVideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_videos);

        List<String> list = setLista();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);

        ListView lista = findViewById(R.id.listView);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getBaseContext(), VideoActivity.class);
                intent.putExtra("videoId",position);
                startActivity(intent);
            }
        });

    }


    private List<String> setLista(){
        List<String> atividade = new ArrayList<>();;
        Intent it = getIntent();
        String informacao = it.getStringExtra("lista");

        TextView titleTextList = findViewById(R.id.titleTextList);

        if(informacao.equals(String.valueOf(R.string.exercicios_equilibrio))){
            titleTextList.setText("Exercicios para o equilibrio");
            VideoDAO videoDAO = new VideoDAO(getApplicationContext());
            atividade = videoDAO.videoTitleList();

        }else{
            if(informacao.equals(String.valueOf(R.string.exercicios_memoria))){
                titleTextList.setText("Exercicios para Memoria");

            }else{
                if(informacao.equals(String.valueOf(R.string.prevencao))){
                    titleTextList.setText("Previnindo Contra Quedas");

                }else{
                    if(informacao.equals(String.valueOf(R.string.dicas_Saude))){
                        titleTextList.setText("Dicas de Saúde");

                    }else{
                        if(informacao.equals(String.valueOf(R.string.incontinencia_urinaria))){
                            titleTextList.setText("Incontinencia Urinaria");

                        }else{
                            if(informacao.equals(String.valueOf(R.string.direitos))){
                                titleTextList.setText("Seus Direitos");
                            }else {
                                titleTextList.setText("Lista vazia");
                            }
                        }
                    }
                }
            }
        }
        return atividade;
    }
}
