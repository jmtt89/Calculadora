package com.master.homework.torresj_u2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jmtt on 10/5/17.
 *
 * (X) Otras mejoras propuestas que quieras añadir
 *
 * Calc+ extiende la funcionalidad de la calculadora que se pidio y modifica radicalmente la vista
 * mucho mas inspiado en la aplicacion de calculadora oficial tambien es mucho mas bonita.
 *
 * Se utiliza la herancia para no repetir codigo sino reutilizar lo que ya teniamos funcionando.
 */
public class CalcFragmentPlus extends CalcFragment {

    protected TextView prevTotal;

    public CalcFragmentPlus() {
        super();
    }

    @Override
    protected View setupView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_calc_plus, container, false);
    }

    @Override
    protected void setupOutput(View view) {
        super.setupOutput(view);
    }

    @Override
    protected void setupOperationsButtons(View view) {
        super.setupOperationsButtons(view);
        view.findViewById(R.id.btn_opt_decimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!decimalMode && value % 1 == 0){//cambiar a modo entrada decimal
                    decimalMode = true;
                    result.setText(result.getText()+".");
                }
            }
        });

        view.findViewById(R.id.btn_op_convert_rev).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 2;
                trailingZeros = 0;
                carry = 0.0;
                value /= ptsEquiv;
                if(value % 1 == 0){//cambiar a modo entrada decimal
                    decimalMode = true;
                }
                result.setText(formatNumber(value));
            }
        });

    }
}
