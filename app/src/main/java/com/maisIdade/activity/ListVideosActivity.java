package com.maisIdade.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.maisIdade.DAO.PdfDAO;
import com.maisIdade.DAO.VideoDAO;
import com.maisIdade.R;
import com.maisIdade.model.Pdf;
import com.maisIdade.model.Video;

import java.util.ArrayList;
import java.util.List;

public class ListVideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_videos);

        List<Video> list = setListaVideo();

        ArrayAdapter<Video> adapter = new ArrayAdapter<Video>(this, android.R.layout.simple_list_item_1, list);

        final ListView lista = findViewById(R.id.listView);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Video video = (Video) lista.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), VideoActivity.class);
                intent.putExtra("videoId", video.getId());
                startActivity(intent);
            }
        });


        final ListView listaPdf = findViewById(R.id.listPdf);

        List<Pdf> listPdf = setListPdf();
        ArrayAdapter<Pdf> adapter2 = new ArrayAdapter<Pdf>(this, android.R.layout.simple_list_item_1, listPdf);
        listaPdf.setAdapter(adapter2);

        listaPdf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pdf pdf = (Pdf) listaPdf.getItemAtPosition(position);
                Uri uri = Uri.parse(pdf.getLink()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
    private List<Pdf> setListPdf(){
        List<Pdf> atividade = new ArrayList<>();
        Intent it = getIntent();
        String informacao = it.getStringExtra("lista");

        TextView titleTextList = findViewById(R.id.titleTextList);

        if(informacao.equals(String.valueOf(R.string.exercicios_equilibrio))){
            titleTextList.setText("Exercicios para o equilibrio");
            PdfDAO videoDAO = new PdfDAO(getApplicationContext());
            atividade = videoDAO.videoList("Exercicio Equilibrio");

        }else{
            if(informacao.equals(String.valueOf(R.string.exercicios_memoria))){
                titleTextList.setText("Exercicios para Memoria");
                PdfDAO videoDAO = new PdfDAO(getApplicationContext());
                atividade = videoDAO.videoList("Exercicio Memoria");

            }else{
                if(informacao.equals(String.valueOf(R.string.prevencao))){
                    titleTextList.setText("Previnindo Contra Quedas");
                    PdfDAO videoDAO = new PdfDAO(getApplicationContext());
                    atividade = videoDAO.videoList("prevençao contra quedas");

                }else{
                    if(informacao.equals(String.valueOf(R.string.dicas_Saude))){
                        titleTextList.setText("Dicas de Saúde");
                        PdfDAO videoDAO = new PdfDAO(getApplicationContext());
                        atividade = videoDAO.videoList("dicas saude");

                    }else{
                        if(informacao.equals(String.valueOf(R.string.incontinencia_urinaria))){
                            titleTextList.setText("Incontinencia Urinaria");
                            PdfDAO videoDAO = new PdfDAO(getApplicationContext());
                            atividade = videoDAO.videoList("incontinencia urinaria");

                        }else{
                            if(informacao.equals(String.valueOf(R.string.direitos))){
                                titleTextList.setText("Seus Direitos");
                                PdfDAO videoDAO = new PdfDAO(getApplicationContext());
                                atividade = videoDAO.videoList("direitos");
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


    private List<Video> setListaVideo(){
        List<Video> atividade = new ArrayList<>();
        Intent it = getIntent();
        String informacao = it.getStringExtra("lista");

        TextView titleTextList = findViewById(R.id.titleTextList);

        if(informacao.equals(String.valueOf(R.string.exercicios_equilibrio))){
            titleTextList.setText("Exercicios para o equilibrio");
            VideoDAO videoDAO = new VideoDAO(getApplicationContext());
            atividade = videoDAO.videoTypeList("Exercicio Equilibrio");

        }else{
            if(informacao.equals(String.valueOf(R.string.exercicios_memoria))){
                titleTextList.setText("Exercicios para Memoria");
                VideoDAO videoDAO = new VideoDAO(getApplicationContext());
                atividade = videoDAO.videoTypeList("Exercicio Memoria");

            }else{
                if(informacao.equals(String.valueOf(R.string.prevencao))){
                    titleTextList.setText("Previnindo Contra Quedas");
                    VideoDAO videoDAO = new VideoDAO(getApplicationContext());
                    atividade = videoDAO.videoTypeList("prevençao contra quedas");

                }else{
                    if(informacao.equals(String.valueOf(R.string.dicas_Saude))){
                        titleTextList.setText("Dicas de Saúde");
                        VideoDAO videoDAO = new VideoDAO(getApplicationContext());
                        atividade = videoDAO.videoTypeList("dicas saude");

                    }else{
                        if(informacao.equals(String.valueOf(R.string.incontinencia_urinaria))){
                            titleTextList.setText("Incontinencia Urinaria");
                            VideoDAO videoDAO = new VideoDAO(getApplicationContext());
                            atividade = videoDAO.videoTypeList("incontinencia urinaria");

                        }else{
                            if(informacao.equals(String.valueOf(R.string.direitos))){
                                titleTextList.setText("Seus Direitos");
                                VideoDAO videoDAO = new VideoDAO(getApplicationContext());
                                atividade = videoDAO.videoTypeList("direitos");
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
