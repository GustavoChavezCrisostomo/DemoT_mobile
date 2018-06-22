package com.tesis.demo.demot_mobile.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tesis.demo.demot_mobile.R;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void callHistoria(View view){
        startActivity(new Intent(PrincipalActivity.this, HistoriaActivity.class));
    }

    public void callCaptura(View view){
        startActivity(new Intent(PrincipalActivity.this, CapturaActivity.class));
    }

}
