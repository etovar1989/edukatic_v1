package com.example.l.edukatic_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class dia1 extends AppCompatActivity {

    ImageView img1,img2,img3;
    String opc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia1 );




        img1 = (ImageView) findViewById( R.id.imgD1m1 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                opc = "d1m1";
                com.example.l.edukatic_v1.User usuario = new com.example.l.edukatic_v1.User();
                usuario.setD1m( opc );

                Intent in = new Intent( dia1.this, d1Menu.class );
                in.putExtra( "opc",opc );
                startActivity( in );
            }
        } );











        img3 = (ImageView) findViewById( R.id.imgB1 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

    }
}
