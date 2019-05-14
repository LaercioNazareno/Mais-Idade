package com.maisIdade;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "mais_idade_db";
    private static final int version = 1;


    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table user(id integer primary key autoincrement," +
                "name varchar(50), " +
                "last_name varchar(50), " +
                "email varchar(50), " +
                "password varchar(10))");

        db.execSQL("create table video(id integer primary key autoincrement," +
                "name varchar(50), " +
                "tipo varchar(50), " +
                "url varchar(100))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
