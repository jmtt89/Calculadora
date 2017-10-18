package com.master.homework.torresj_u2;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 * (X) Ejercicio: Creación de un layout con ConstraintLayout
 * (X) Ejercicio: Líneas guía y cadenas en ConstraintLayout
 *
 * Tuve que cambiar los tamanos fijados en la practica para que cupiese mejor en pantallas pequenas (4')
 * mi equipo tiene este tipo de pantalla y se veia bastante sobrecargado con las dimensiones fijadas
 * en el pdf/libro.
 *
 * Adicionalmente agregue una tercera seccion que cambia dinamicamente el estilo de la cadena.
 *
 * Los textos en esta seccion quedan en ingles ya que la traduccion espanol no es intuitiva
 *
 * Se agrega una nueva distribucion de este tab para landscape, en esta distribucion se agrega un
 * guideline vertical que divide la pantalla en 4 al 50%. Cada cuarto tiene un ejercicio con los
 * controles para modificar dinamicamente estilo de la cadena.
 *
 */
public class ConstraintExampleFragment extends Fragment {
    private ConstraintLayout cWrapper;
    private TextView chainType;

    private ImageView chainImageA;
    private ImageView chainImageB;
    private ImageView chainImageC;

    private Button btnPackage;
    private Button btnSpread;
    private Button btnSpreadInside;

    public ConstraintExampleFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_constraint_example, container, false);

        cWrapper = (ConstraintLayout) view;
        chainType = view.findViewById(R.id.chain_style_selected);

        chainImageA = view.findViewById(R.id.chainA);
        chainImageB = view.findViewById(R.id.chainB);
        chainImageC = view.findViewById(R.id.chainC);

        btnPackage = view.findViewById(R.id.btn_apply_package);
        btnPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chainType.setText(R.string.label_chain_style_package);
                ConstraintSet ct = new ConstraintSet();
                ct.clone(cWrapper);
                ct.setHorizontalChainStyle(chainImageA.getId(), ConstraintSet.CHAIN_PACKED);
                ct.setHorizontalChainStyle(chainImageB.getId(), ConstraintSet.CHAIN_PACKED);
                ct.setHorizontalChainStyle(chainImageC.getId(), ConstraintSet.CHAIN_PACKED);
                ct.applyTo(cWrapper);
            }
        });

        btnSpread = view.findViewById(R.id.btn_apply_spread);
        btnSpread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chainType.setText(R.string.label_chain_style_spread);
                ConstraintSet ct = new ConstraintSet();
                ct.clone(cWrapper);
                ct.setHorizontalChainStyle(chainImageA.getId(), ConstraintSet.CHAIN_SPREAD);
                ct.setHorizontalChainStyle(chainImageB.getId(), ConstraintSet.CHAIN_SPREAD);
                ct.setHorizontalChainStyle(chainImageC.getId(), ConstraintSet.CHAIN_SPREAD);
                ct.applyTo(cWrapper);
            }
        });

        btnSpreadInside = view.findViewById(R.id.btn_apply_spread_inside);
        btnSpreadInside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chainType.setText(R.string.label_chain_style_spread_inside);
                ConstraintSet ct = new ConstraintSet();
                ct.clone(cWrapper);
                ct.setHorizontalChainStyle(chainImageA.getId(), ConstraintSet.CHAIN_SPREAD_INSIDE);
                ct.setHorizontalChainStyle(chainImageB.getId(), ConstraintSet.CHAIN_SPREAD_INSIDE);
                ct.setHorizontalChainStyle(chainImageC.getId(), ConstraintSet.CHAIN_SPREAD_INSIDE);
                ct.applyTo(cWrapper);
            }
        });

        return view;
    }
}
