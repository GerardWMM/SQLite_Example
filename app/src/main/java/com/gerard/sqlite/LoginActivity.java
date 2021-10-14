package com.gerard.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gerard.sqlite.Models.Usuario;
import com.gerard.sqlite.sqlite.DbUsuario;

public class LoginActivity extends AppCompatActivity {
    EditText txtClave,txtEmail;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.txtEmail);
        txtClave = findViewById(R.id.txtClave);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String clave = txtClave.getText().toString();

                DbUsuario dbuser = new DbUsuario(LoginActivity.this);

                Usuario user = dbuser.login(email,clave);
                if(user == null){
                    Toast.makeText(LoginActivity.this, "Credenciales invalidas", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Bienvenid@ "+user.getNombres(), Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}