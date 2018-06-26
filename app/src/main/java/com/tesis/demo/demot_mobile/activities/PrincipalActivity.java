package com.tesis.demo.demot_mobile.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.tesis.demo.demot_mobile.R;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.exit:
                logout();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void callHistoria(View view){
        startActivity(new Intent(PrincipalActivity.this, HistoriaActivity.class));
        finish();
    }

    public void callCaptura(View view){
        startActivity(new Intent(PrincipalActivity.this, CapturaActivity.class));
        finish();
    }

    public void logout(){
        finish();
    }

}
