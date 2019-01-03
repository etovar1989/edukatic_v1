package com.example.l.edukatic_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class validarUsuarios extends AppCompatActivity {


    ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_validar_usuarios );

        img1 = (ImageView) findViewById( R.id.imgConCC );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent in = new Intent( validarUsuarios.this, consultaCC.class );
                //startActivity( in );
                //finish();
            }
        } );

        img2 = (ImageView) findViewById( R.id.imgConQR );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        } );


        img3 = (ImageView) findViewById( R.id.imgBack );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


    }



}
