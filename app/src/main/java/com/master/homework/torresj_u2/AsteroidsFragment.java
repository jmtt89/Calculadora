package com.master.homework.torresj_u2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * (X) Practica: Creación de aplicación Asteroides (importante)
 * (X) Practica: Recursos alternativos en Asteroides
 * (X) Ejercicio: Traducción de Asteroides
 * (X) Practica: Creando un Layout para tabletas en Asteroides
 * (X) Practica: Creando un estilo en Asteroides
 * (X) Practica: Creando un tema en Asteroides
 *
 * En el caso del tema tiene que asignarse a todos los fragments porque los temas se asignan por
 * actividad.
 */
public class AsteroidsFragment extends Fragment {
    public AsteroidsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asteroids, container, false);
    }

}
