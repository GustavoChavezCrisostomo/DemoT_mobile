package com.tesis.demo.demot_mobile.activities;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tesis.demo.demot_mobile.R;
import com.tesis.demo.demot_mobile.model.Alumno;
import com.tesis.demo.demot_mobile.service.ApiService;
import com.tesis.demo.demot_mobile.service.ApiServiceGenerator;
import com.tesis.demo.demot_mobile.util.PreferencesManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int MAIN_FORM_REQUEST = 100;

    private EditText loginInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferencesManager.getInstance(this);

        loginInput = (EditText) findViewById(R.id.login_input);
        passwordInput = (EditText)findViewById(R.id.password_input);

        // Verificar si ya está LOGUEADO
        if(PreferencesManager.getInstance().get(PreferencesManager.PREF_ISLOGGED) != null){
            startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
            finish();
        }

    }

    public void callLogin(View view) {

        String login = loginInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(login.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Completar los campos requeridos", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<Alumno> call = null;

        call = service.correo(login, password);

        call.enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {

                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        Alumno alumno = response.body();
                        Log.d(TAG, "responseMessage: " + alumno);
                        // Grabar los datos en el SP
                        PreferencesManager.getInstance().set(PreferencesManager.PREF_ID, ""+alumno.getId());
                        PreferencesManager.getInstance().set(PreferencesManager.PREF_CORREO, ""+alumno.getCorreo());
                        PreferencesManager.getInstance().set(PreferencesManager.PREF_ISLOGGED, "1");

                        //Toast.makeText(MainActivity.this, usuario.getMessage(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
                        finish();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }

            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
