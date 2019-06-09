package com.maisIdade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.maisIdade.DAO.UserDAO;
import com.maisIdade.R;
import com.maisIdade.model.User;

public class FormCadUserActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_form_cad_user);

            Button cadBtn = findViewById(R.id.cadastrarBtn);
            cadBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cadastrar();
                    setView();
                }
            });

        }

        private void setView(){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        private void cadastrar(){

            EditText nome = findViewById(R.id.emailTxt);
            EditText nomeMae = findViewById(R.id.nomeTxt);
            EditText dataText = findViewById(R.id.senhaText);

            User user = new User(nome.getText().toString(),nomeMae.getText().toString(),"carlos",dataText.getText().toString());

            UserDAO userDao = new UserDAO(getBaseContext());
            userDao.insert(user);

        }

}
