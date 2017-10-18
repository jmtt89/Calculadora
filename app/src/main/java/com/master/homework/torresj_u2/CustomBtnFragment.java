package com.master.homework.torresj_u2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * (X) Ejercicio: Un botón con gráficos personalizados
 * (X) Ejercicio: Acceder y modificar las propiedades de las vistas
 *
 * Segun tengo entendido asignar el atributo onClick en el layout no funciona desde Fragments,
 * por tal motivo utilizo un approach alternativo, implementar la interface onClickListener
 * y hacer una comparacion por el id.
 *
 * Me parece que no tiene demasiado sentido esta vista, ni se entiende muy bien lo que se pide,
 * me costo varios intentos descifrar correctamente lo que creo entendi. Creo que Tuviese MUCHO mas
 * sentido un boton "limpiar" en lugar del boton "0" y que este "limpiara" la entrada.
 */
public class CustomBtnFragment extends Fragment implements View.OnClickListener{

    private EditText entrada;
    private Button customBtn;
    private TextView salida;
    private Button addZero;

    public CustomBtnFragment() {
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
        View view = inflater.inflate(R.layout.fragment_custom_btn, container, false);
        entrada = view.findViewById(R.id.input);
        customBtn = view.findViewById(R.id.btn_custom);
        salida = view.findViewById(R.id.output);
        addZero = view.findViewById(R.id.btn_add_zero);

        customBtn.setOnClickListener(this);
        addZero.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_custom:
                sePulsa(view);
                break;
            case R.id.btn_add_zero:
                sePulsa0(view);
                break;
        }
    }

    public void sePulsa(View view){
//        Toast.makeText(getContext(), "Pulsado", Toast.LENGTH_SHORT).show();
        String plainInput = entrada.getText().toString();
        Float parse = 0.0f;
        if(plainInput.length() > 0){
            parse = Float.parseFloat(plainInput);
        }
        salida.setText(String.valueOf(parse*2.0));
    }

    public void sePulsa0(View view){
        entrada.setText(entrada.getText()+(String)view.getTag());
    }

}
