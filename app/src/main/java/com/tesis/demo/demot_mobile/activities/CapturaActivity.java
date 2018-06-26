package com.tesis.demo.demot_mobile.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tesis.demo.demot_mobile.R;

public class CapturaActivity extends AppCompatActivity {

    ImageView img_captura;
    Button btn_takefoto;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.atras:
                atras();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);

        btn_takefoto = (Button) findViewById(R.id.btn_takeFoto);
        img_captura = (ImageView) findViewById(R.id.img_captura);

        btn_takefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarIntent();
            }
        });
    }

    private void llamarIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img_captura.setImageBitmap(imageBitmap);
        }
    }

    private void atras() {
        startActivity(new Intent(CapturaActivity.this, PrincipalActivity.class));
        finish();
    }
}
