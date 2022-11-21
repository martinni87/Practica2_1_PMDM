package com.elcampico.practica2_fragments_martincordoba;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFragment extends Fragment {

    //Creamos la clave para recibir el bundle y resultado para almacenar el valor que agregamos
    private final String BUNDLE_KEY = "KEY";
    private int resultado;

    public ResultFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    //Comenzamos a traer valores cuando la vista se ha creado
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);

        //Al crearse la vista, usamos el Fragment Manager para  crear un Listener que detecte cuando
        // se pasa un parámetro por bundle al fragment.
        getParentFragmentManager().setFragmentResultListener(BUNDLE_KEY, this, new FragmentResultListener() {
            //El tercer parámetro es un FragmentResultListener, es el encargado de detecetar que se está pasando un FragmentResult desde la Activity anterior.
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                resultado = bundle.getInt(BUNDLE_KEY); //Recogemos el valor del bundle y lo pasamos a resultado
                TextView frText = rootView.findViewById(R.id.fr_textView); //Creamos el TextView y le asignamos su vista
                frText.setText(String.valueOf(resultado)); //Seteamos el valor del texto al nuevo resultado
            }
        });
        return rootView;
    }
}