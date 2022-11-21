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

    private Button btnAgregar; //Almacenará el objeto Button de la UI
    private int resultado = 0; //Almacena y actualiza el resultado. Se pasa como bundle al fragment
    private final String BUNDLE_KEY = "KEY"; //Constante que nos sirve como clave para pasar al bundle

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnAgregar = findViewById(R.id.btn_agregar);
        btnAgregar.setOnClickListener(clickAgregar);
    }

    protected View.OnClickListener clickAgregar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            resultado++; //Aumentamos el resultado +1
            Bundle bundle = new Bundle(); //Creamos el bundle que transferirá valores a la otra activity
            bundle.putInt(BUNDLE_KEY,resultado); //Asignamos al bundle un par clave valor con el dato que queremos pasar.

            //Si está en modo portrait
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                //Creamos un intent que definirá desde y hasta donde nos movemos (cambio de activities)
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                //Le asignamos el bundle que tendrá que llevarse consigo mismo
                intent.putExtras(bundle);
                //Iniciamos la activity con el intent pasado
                startActivity(intent); //Con esto pasamos directamente a la nueva activity y mandamos el paquete de parámetros
            }
            //Si está en modo landscape
            else{
                //Este método nos devuelve un Fragment Manager sobre el que seteamos los parámetros (clave, valor) que
                // queremos pasarle al fragment directamente
                getSupportFragmentManager().setFragmentResult(BUNDLE_KEY,bundle);
            }
        }
    };
}