package com.example.l.edukatic_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class d1ValCC extends AppCompatActivity {

    EditText cajaCC;
    Button consultarCC;
    String cc,tipo,opc;
    ImageView img1;
    TextView textoTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d1_val_cc );

        //busco caja de texto para obtener los datos de esta
        cajaCC = (EditText)findViewById( R.id.txtD1CC );

        //Recupero texto enviado
        tipo = getIntent().getStringExtra( "tipo" );

        //busco texto para cambiar el texto que este muestra
        textoTipo = (TextView) findViewById( R.id.txtTipo1 );
        //Envio el texto recuperado del inten
        textoTipo.setText( tipo );

        consultarCC = (Button) findViewById( R.id.btnD1Consultar );
        consultarCC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opc = getIntent().getStringExtra( "opc" );
                Intent in = new Intent( d1ValCC.this, d1Resultado.class );
                in.putExtra( "cc",cajaCC.getText().toString());
                in.putExtra( "opc",opc );
                in.putExtra( "tipo",tipo );
                startActivity( in );
                cajaCC.setText( "" );

            }
        } );

        img1 = (ImageView) findViewById( R.id.imgB );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );




    }





}
