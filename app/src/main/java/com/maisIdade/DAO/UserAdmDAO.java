package com.maisIdade.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.maisIdade.Conexao;
import com.maisIdade.model.User;
import com.maisIdade.model.UserAdm;

import java.util.ArrayList;
import java.util.List;

public class UserAdmDAO {
    private Conexao conexao;
    private SQLiteDatabase base;

    public UserAdmDAO(Context context){

        conexao = new Conexao(context);
        base = conexao.getWritableDatabase();
    }

    public long create(UserAdm user){

        ContentValues values = new ContentValues();
        values.put("nome", user.getNome());
        values.put("email", user.getEmail());
        values.put("data_nasci", user.getSenha());
        return base.insert("user_adm", null,values);
    }

    public List<UserAdm> listDespesas(){

        List<UserAdm> userList = new ArrayList<>();
        Cursor cursor = base.query("user_adm", new String[]{"nome","email","senha"},null,null, null,null,null);

        while(cursor.moveToNext()){
            UserAdm user = new UserAdm();
            user.setNome(cursor.getColumnName(0));
            user.setEmail(cursor.getColumnName(1));
            user.setSenha(cursor.getColumnName(2));
        }


        return userList;
    }
}
