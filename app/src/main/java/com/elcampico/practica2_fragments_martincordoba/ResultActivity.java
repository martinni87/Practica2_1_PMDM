package com.elcampico.practica2_fragments_martincordoba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    private final String BUNDLE_KEY = "KEY";    //Creamos una constante con la clave que necesitamos
                                                // buscar en el bundle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Creamos el bundle y le asignamos el intent cargado con los parámetros del bundle enviado
        Bundle bundle = getIntent().getExtras();

        //Ejecutamos Fragment Manager seteado con el conjunto clave valor del bundle para lanzar el
        // fragment con el resultado. Este método necesita haber creado un Listener en el Fragment objetivo
        getSupportFragmentManager().setFragmentResult(BUNDLE_KEY,bundle);
    }
}