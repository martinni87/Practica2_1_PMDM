package com.elcampico.practica2_fragments_martincordoba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

//'    private int resultado = 0;'
    private final String BUNDLE_KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = getIntent().getExtras();
        int valor = bundle.getInt(BUNDLE_KEY);
        getSupportFragmentManager().setFragmentResult(BUNDLE_KEY,bundle);
    }
}