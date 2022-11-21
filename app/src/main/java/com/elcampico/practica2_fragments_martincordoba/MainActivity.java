package com.elcampico.practica2_fragments_martincordoba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAgregar;
    private int resultado;
    private final String BUNDLE_KEY = "KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            resultado = savedInstanceState.getInt(BUNDLE_KEY);
        }
        else {
            resultado = 0;
        }
        setContentView(R.layout.activity_main);
        btnAgregar = findViewById(R.id.btn_agregar);
        btnAgregar.setOnClickListener(clickAgregar);
    }

    protected View.OnClickListener clickAgregar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            resultado++;
            Bundle bundle = new Bundle();
            bundle.putInt(BUNDLE_KEY,resultado);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                getSupportFragmentManager().setFragmentResult(BUNDLE_KEY,bundle);
            }
            else{
                getSupportFragmentManager().setFragmentResult(BUNDLE_KEY,bundle);
            }

        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("resultado",resultado);
    }
}