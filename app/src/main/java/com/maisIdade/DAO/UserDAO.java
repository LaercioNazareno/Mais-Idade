package com.maisIdade.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.maisIdade.Conexao;
import com.maisIdade.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Conexao connection;
    private SQLiteDatabase base;

    public UserDAO(Context context){

        connection = new Conexao(context);
        base = connection.getWritableDatabase();

    }

    public long insert(User user){

        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("last_name", user.getLastName());
        values.put("password",user.getPassword());
        return base.insert("user",null, values);
    }

    public void update(User user){
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("last_name", user.getLastName());
        values.put("password",user.getPassword());
        base.update("user",values,"id=?",new String[]{String.valueOf(user.getId())});
    }

    public List<User> userList(){

        List<User> users = new ArrayList<>();

        Cursor cursor = base.query("user",new String[]{"name","last_name","email","password","id"},
                null,null,null,null,null);


        while(cursor.moveToNext()){

            User user = new User();
            user.setName(cursor.getString(0));
            user.setLastName(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            user.setPassword(cursor.getString(3));
            user.setId(cursor.getInt(4));

            users.add(user);
        }

        return users;

    }

}
