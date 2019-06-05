package com.ianpedraza.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferencias;
    private SharedPreferences.Editor editor;
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencias = getSharedPreferences("mis_preferencias", Context.MODE_PRIVATE);
        editor = preferencias.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iniciar();
            }
        }, 3000);

    }

    private void iniciar(){
        usuario = preferencias.getString("usuario", null);

        if(usuario == null){
            Toast.makeText(this, "Usuario no loggeado: mandar a loggin", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Usuario loggeado: mandar a home", Toast.LENGTH_SHORT).show();
        }

    }
}
