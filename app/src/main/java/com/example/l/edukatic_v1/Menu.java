package com.example.l.edukatic_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    private TextView tv1;
    ImageView img1,img2,img3,img4,img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu );

        tv1 = (TextView)findViewById( R.id.txtNombres );

        String dato1 = getIntent().getStringExtra( "nombres" );
        String dato2 = getIntent().getStringExtra( "apellidos" );
        tv1.setText( dato1+" "+dato2 );


        img1 = (ImageView) findViewById( R.id.imgVerUs );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent( Menu.this, validarUsuarios.class );
                startActivity( in );
            }
        } );


        img2 = (ImageView) findViewById( R.id.imgD1 );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent in = new Intent( Menu.this, dia1.class );
                //startActivity( in );
            }
        } );


        img3 = (ImageView) findViewById( R.id.imgD2 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent in = new Intent( Menu.this, dia2.class );
                //startActivity( in );
            }
        } );

        img4 = (ImageView) findViewById( R.id.imgD3 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent in = new Intent( Menu.this, dia3.class );
                //startActivity( in );
            }
        } );

        img5 = (ImageView) findViewById( R.id.imgSalir );
        img5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit( 0 );

            }
        } );






    }


    public void dia1(View view){
        Toast.makeText( this,"Dìa 1",Toast.LENGTH_SHORT ).show();
        //Intent in = new Intent( Menu.this, dia1.class );
        //startActivity( in );
    }

    public void dia2(View view){
        Toast.makeText( this,"Dìa 2",Toast.LENGTH_SHORT ).show();
        //Intent in = new Intent( Menu.this, dia2.class );
        //startActivity( in );
    }

    public void dia3(View view){
        Toast.makeText( this,"Dìa 3",Toast.LENGTH_SHORT ).show();
        //Intent in = new Intent( Menu.this, dia3.class );
        //startActivity( in );
    }
}
