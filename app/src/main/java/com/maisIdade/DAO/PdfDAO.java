package com.maisIdade.DAO;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.maisIdade.Conexao;
import com.maisIdade.model.Pdf;
import com.maisIdade.model.Video;

import java.util.ArrayList;
import java.util.List;

public class PdfDAO {

    private Conexao connection;
    private SQLiteDatabase base;

    public PdfDAO(Context context){

        connection = new Conexao(context);
        base = connection.getWritableDatabase();

    }

    public long insert(Pdf video){

        ContentValues values = new ContentValues();
        values.put("name", video.getNome());
        values.put("tipo", video.getTipo());
        values.put("url", video.getLink());
        return base.insert("pdf",null, values);
    }

    public void update(Video video){
        ContentValues values = new ContentValues();
        values.put("name", video.getNome());
        values.put("tipo", video.getTipo());
        base.update("pdf",values,"id=?",new String[]{String.valueOf(video.getId())});
    }

    public List<Pdf> pdfList(){

        List<Pdf> videos = new ArrayList<>();

        Cursor cursor = base.query("pdf",new String[]{"name","tipo","url","id"},
                null,null,null,null,null);


        while(cursor.moveToNext()){
            Pdf video = new Pdf();
            video.setNome(cursor.getString(0));
            video.setTipo(cursor.getString(1));
            video.setLink(cursor.getString(2));
            video.setId(cursor.getInt(3));
            videos.add(video);
        }

        return videos;

    }

    public Pdf getVideoById(int id){
        Cursor cursor = base.query("video",new String[]{"name","tipo","url","id"},
                null,null,null,null,null);

        Pdf video = new Pdf();

        while(cursor.moveToNext()){


            if(cursor.getInt(3) == id) {
                video.setNome(cursor.getString(0));
                video.setTipo(cursor.getString(1));
                video.setLink(cursor.getString(2));
                video.setId(cursor.getInt(3));
            }
        }

        return video;
    }

    public List<Pdf> videoList(String type) {

        List<Pdf> videos = new ArrayList<>();

        Cursor cursor = base.query("pdf", new String[]{"name", "tipo", "url", "id"},
                null, null, null, null, null);


        while (cursor.moveToNext()) {

            if (cursor.getString(1).equals(type)) {
                Pdf video = new Pdf();
                video.setNome(cursor.getString(0));
                video.setTipo(cursor.getString(1));
                video.setLink(cursor.getString(2));
                video.setId(cursor.getInt(3));

                videos.add(video);
            }

        }

        return videos;
    }

}
