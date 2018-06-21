package com.tesis.demo.demot_mobile.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.tesis.demo.demot_mobile.R;

public class MainActivity extends AppCompatActivity {

    private EditText loginInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        PreferencesManager.getInstance(this);

        loginInput = (EditText) findViewById(R.id.login_input);
        passwordInput = (EditText)findViewById(R.id.password_input);

        // Verificar si ya está LOGUEADO
        if(PreferencesManager.getInstance().get(PreferencesManager.PREF_ISLOGGED) != null){
            startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
            finish();
        }
        */
    }
}
