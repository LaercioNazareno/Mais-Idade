package com.maisIdade.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.maisIdade.DAO.PdfDAO;
import com.maisIdade.DAO.VideoDAO;
import com.maisIdade.R;
import com.maisIdade.model.Pdf;
import com.maisIdade.model.Video;

import java.util.List;

public class EditarArquivosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_arquivos);

        VideoDAO videoDAO = new  VideoDAO(getApplicationContext());
        List<Video> list = videoDAO.videoList() ;

        ArrayAdapter<Video> adapter = new ArrayAdapter<Video>(this, android.R.layout.simple_list_item_1, list);

        final ListView lista = findViewById(R.id.vidoist2);
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


        final ListView listaPdf = findViewById(R.id.pdfList2);
        PdfDAO pdfDAO = new PdfDAO(getApplicationContext());

        List<Pdf> listPdf = pdfDAO.pdfList();
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
}
