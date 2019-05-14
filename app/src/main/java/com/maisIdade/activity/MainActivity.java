package com.maisIdade.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.maisIdade.DAO.UserDAO;
import com.maisIdade.R;
import com.maisIdade.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button videoAddBtn = findViewById(R.id.videoAddBtn), cartilhasAddBtn = findViewById(R.id.cartilhasAddBtn);

        if(!temAutorizacao()){
            videoAddBtn.setVisibility(View.INVISIBLE);
            cartilhasAddBtn.setVisibility(View.INVISIBLE);
        }

        CardView cardExercicoEquilibrio = findViewById(R.id.cardExercicoEquilibrio);

        cardExercicoEquilibrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),ListVideosActivity.class);
                intent.putExtra( "lista",String.valueOf(R.string.exercicios_equilibrio));
                startActivity(intent);
            }
        });

        CardView cardViewMemoria = findViewById(R.id.cardViewMemoria);

        cardViewMemoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),ListVideosActivity.class);
                intent.putExtra( "lista",String.valueOf(R.string.exercicios_memoria));
                startActivity(intent);
            }
        });

        CardView cardViewQuedas = findViewById(R.id.cardViewQuedas);

        cardViewQuedas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),ListVideosActivity.class);
                intent.putExtra( "lista",String.valueOf(R.string.prevencao));
                startActivity(intent);
            }
        });

        CardView cardViewDisfagia = findViewById(R.id.cardViewDisfagia);

        cardViewDisfagia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),ListVideosActivity.class);
                intent.putExtra( "lista",String.valueOf(R.string.dicas_Saude));
                startActivity(intent);
            }
        });

        CardView cardViewIncontUrinaria = findViewById(R.id.cardViewIncontUrinaria);

        cardViewIncontUrinaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),ListVideosActivity.class);
                intent.putExtra( "lista",String.valueOf(R.string.incontinencia_urinaria));
                startActivity(intent);
            }
        });

        CardView cardViewEstatutoIdoso = findViewById(R.id.cardViewEstatutoIdoso);

        cardViewEstatutoIdoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),ListVideosActivity.class);
                intent.putExtra( "lista",String.valueOf(R.string.direitos));
                startActivity(intent);
            }
        });

        videoAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),AddVideoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private User getUser(){

        SharedPreferences sharedPreferences = getSharedPreferences("preferences", getBaseContext().MODE_PRIVATE);
        int result = sharedPreferences.getInt("userId", -1);
        UserDAO userDAO = new UserDAO(getBaseContext());
        User user = userDAO.userList().get(result-1);
        return user;
    }

    private boolean temAutorizacao(){
       return getUser().getEmail().equals("pdayrell@gmail.com");
    }
}
