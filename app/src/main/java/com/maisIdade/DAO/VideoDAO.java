package com.maisIdade.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.maisIdade.Conexao;
import com.maisIdade.model.User;
import com.maisIdade.model.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    private Conexao connection;
    private SQLiteDatabase base;

    public VideoDAO(Context context){

        connection = new Conexao(context);
        base = connection.getWritableDatabase();

    }

    public long insert(Video video){

        ContentValues values = new ContentValues();
        values.put("name", video.getNome());
        values.put("tipo", video.getTipo());
        values.put("url", video.getUrl());
        return base.insert("video",null, values);
    }

    public void update(Video video){
        ContentValues values = new ContentValues();
        values.put("name", video.getNome());
        values.put("tipo", video.getTipo());
        base.update("user",values,"id=?",new String[]{String.valueOf(video.getId())});
    }

    public List<String> videoTitleList(){

        List<String> videos = new ArrayList<>();

        Cursor cursor = base.query("video",new String[]{"name","tipo","url","id"},
                null,null,null,null,null);


        while(cursor.moveToNext()){

            videos.add(cursor.getString(0));
        }

        return videos;

    }

    public Video getVideoById(int id){
        Cursor cursor = base.query("video",new String[]{"name","tipo","url","id"},
                null,null,null,null,null);
        Video video = new Video();

        while(cursor.moveToNext()){


            if(cursor.getInt(3) == id) {
                video.setNome(cursor.getString(0));
                video.setTipo(cursor.getString(1));
                video.setUrl(cursor.getString(2));
                video.setId(cursor.getInt(3));
            }
        }

        return video;
    }

    public List<Video> videoList(){

        List<Video> videos = new ArrayList<>();

        Cursor cursor = base.query("video",new String[]{"name","tipo","url","id"},
                null,null,null,null,null);


        while(cursor.moveToNext()){

            Video video = new Video();
            video.setNome(cursor.getString(0));
            video.setTipo(cursor.getString(1));
            video.setUrl(cursor.getString(2));
            video.setId(cursor.getInt(4));

            videos.add(video);
        }

        return videos;

    }

}
