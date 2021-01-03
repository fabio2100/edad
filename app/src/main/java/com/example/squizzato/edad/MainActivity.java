package com.example.squizzato.edad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private EditText dian;
    private EditText mesn;
    private EditText anon;
    private TextView fechadia;
    private TextView fechames;
    private TextView fechaano;
    private TextView edad;
    private Button boton;
    Date d=new Date();
    Calendar c1 = new GregorianCalendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1.setTime(d);
        final int diaennro,mesennro,anoennro;

        fechadia=findViewById(R.id.fechadia);
        fechames=findViewById(R.id.fechames);
        fechaano=findViewById(R.id.fechaano);
        dian=findViewById(R.id.dn);
        mesn=findViewById(R.id.mn);
        anon=findViewById(R.id.an);
        boton=findViewById(R.id.boton);
        edad=findViewById(R.id.edad);

        diaennro=c1.get(Calendar.DATE);
        mesennro=c1.get(Calendar.MONTH)+1;
        anoennro=c1.get(Calendar.YEAR);

        String dia,mes,ano;
        dia = Integer.toString(diaennro);
        mes = Integer.toString(mesennro);
        ano = Integer.toString(anoennro);
        fechadia.setText(dia);
        fechames.setText(mes);
        fechaano.setText(ano);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ma=mesennro;
                int aa = anoennro;
                int da=diaennro;
                int edads=0;
                String m1=mesn.getText().toString();
                int m=Integer.parseInt(m1);
                String a1=anon.getText().toString();
                int a=Integer.parseInt(a1);
                String d1=dian.getText().toString();
                int d=Integer.parseInt(d1);


                if (ma > m) {
                    edads = aa - a;
                }
                if (ma < m) {
                    edads = aa - (a + 1);
                }
                if (ma == m) if (da > d) {
                    edads = aa - a;
                }
                if (ma == m) {
                    if (da < d) {
                        edads = aa - (a + 1);
                    }
                }
                if (ma == m) {
                    if (da == d) {
                        edads = aa - a;
                    }
                }
                String edadsta = Double.toString(edads);
                edad.setText(edadsta);

            }
        });
    }
}
