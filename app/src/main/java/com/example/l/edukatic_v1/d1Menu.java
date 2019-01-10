package com.example.l.edukatic_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class d1Menu extends AppCompatActivity {

    ImageView img1,img2,img3;
    String dato1, dato2;
    TextView textoTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d1_menu );


        com.example.l.edukatic_v1.User usuario = new com.example.l.edukatic_v1.User();
        String opcM = usuario.getD1m();

        dato1 = getIntent().getStringExtra( "opc" );
        dato2 = getIntent().getStringExtra( "tipo" );

        textoTipo = (TextView)findViewById( R.id.txtTipo );
        textoTipo.setText( dato2 );

        //Toast.makeText( this,"OK "+dato1, Toast.LENGTH_SHORT).show();



        img1 = (ImageView) findViewById( R.id.imgValCC );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d1Menu.this, d1ValCC.class );
                in.putExtra( "opc",dato1 );
                in.putExtra( "tipo",dato2 );
                startActivity( in );
            }
        } );


        img2 = (ImageView) findViewById( R.id.imgValQR );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent( d1Menu.this, d1Menu.class );
                in.putExtra( "opc",dato1 );
                startActivity( in );
            }
        } );




        img3 = (ImageView) findViewById( R.id.imgB2 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );
    }
}
