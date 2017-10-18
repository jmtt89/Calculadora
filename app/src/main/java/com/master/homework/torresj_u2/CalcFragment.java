package com.master.homework.torresj_u2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * (X) Desafío: Creación de una lengüeta que solo visualice la calculadora
 * (X) Desafío: Programación de la calculadora para convertir de € en ₧
 * (X) Desafío: Verificación de entradas incorrectas en calculadora
 * (X) Desafío: Programación de la calculadora para que sume
 */
public class CalcFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = "CalcFragment";
    protected static final double ptsEquiv = 166.386;

    protected TextView result;

    protected int trailingZeros = 0;
    protected double value = 0.0;
    protected double carry = 0.0;
    protected int operation= -1;
    protected boolean decimalMode;

    public CalcFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = setupView(inflater, container);
        setupOutput(view);
        setupNumberButtons(view);
        setupOperationsButtons(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        //La calculadora de Android despues de aplicar una operacion borra el contenido si se
        //escribe algun numero, esto como no lo dicen las intrucciones lo dejo comentado
//        switch (operation){
//            case 0:
//            case 2:
//                operation = -1;
//                value = 0;
//                break;
//        }

        if(!decimalMode){ //Si es entero
            //se agrega a la derecha del entero el numero
            value = value * 10 + Integer.parseInt((String) view.getTag());
        }else if(view.getTag().equals("0")){
            trailingZeros += 1;
            result.setText(result.getText()+"0");
            return;
        }else{
            String valueStr = String.valueOf(value);
            int dotPosition = valueStr.indexOf('.');
            int decimals = valueStr.length() - (dotPosition + 1);
            Log.d(TAG, "value:"+valueStr+" decimals:"+decimals+" dotPosition:"+dotPosition);
            String newValue;

            String tail = "";
            for (int i = 0; i < trailingZeros; i++) {
                tail += "0";
            }
            tail += (String)view.getTag();
            if(decimals == 1 && valueStr.charAt(dotPosition+1)=='0'){
                // Se Sobre Escribe el 0
                newValue = valueStr.substring(0, dotPosition+1) + tail;
            }else{
                // Se agrega a la derecha de la parte fraccionaria
                newValue = value + tail;
            }
            trailingZeros = 0;
            Log.d(TAG, "value: "+value);
            Log.d(TAG, "newValue: "+newValue);
            value = Double.parseDouble(newValue);
            Log.d(TAG, "value: "+value);
        }
        result.setText(formatNumber(value));
    }

    protected View setupView(LayoutInflater inflater, ViewGroup container){
        return inflater.inflate(R.layout.fragment_calc, container, false);
    }

    protected void setupOutput(View view){
        result = view.findViewById(R.id.result);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(result, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
    }

    protected void setupNumberButtons(View view){
        view.findViewById(R.id.btn_0).setOnClickListener(this);
        view.findViewById(R.id.btn_1).setOnClickListener(this);
        view.findViewById(R.id.btn_2).setOnClickListener(this);
        view.findViewById(R.id.btn_3).setOnClickListener(this);
        view.findViewById(R.id.btn_4).setOnClickListener(this);
        view.findViewById(R.id.btn_5).setOnClickListener(this);
        view.findViewById(R.id.btn_6).setOnClickListener(this);
        view.findViewById(R.id.btn_7).setOnClickListener(this);
        view.findViewById(R.id.btn_8).setOnClickListener(this);
        view.findViewById(R.id.btn_9).setOnClickListener(this);
    }

    protected void setupOperationsButtons(View view){
        view.findViewById(R.id.btn_op_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = -1;
                trailingZeros = 0;
                carry = 0.0;
                value = 0.0;
                decimalMode = false;
                result.setText(formatNumber(value));
            }
        });

        view.findViewById(R.id.btn_op_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (operation){
                    case 0:
                    case 1: //Plus
                        value += carry;
                        operation = 0;
                        break;
                    default:
                        operation = -1;
                        break;
                }
                if(value % 1 == 0){//cambiar a modo entrada decimal
                    decimalMode = true;
                }
                trailingZeros = 0;
                carry = 0.0;
                result.setText(formatNumber(value));
            }
        });

        view.findViewById(R.id.btn_op_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 1;
                carry += value;
                trailingZeros = 0;
                value = 0.0;
                decimalMode = false;
                result.setText(formatNumber(value));
            }
        });

        view.findViewById(R.id.btn_op_convert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 2;
                carry = 0.0;
                trailingZeros = 0;
                value *= ptsEquiv;
                if(value % 1 == 0){//cambiar a modo entrada decimal
                    decimalMode = true;
                }
                result.setText(formatNumber(value));
            }
        });
    }

    protected String formatNumber(double value){
        String tmp = String.valueOf(value);
        int idx = tmp.indexOf(".0");
        if(idx+2 == tmp.length()){
            //Si los ultimos caracteres son ".0" se eliminan
            return tmp.substring(0, idx);
        }else{
            return tmp;
        }
    }

}
