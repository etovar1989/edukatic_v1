package com.example.l.edukatic_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.*;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class dia3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ImageView img1,img2,img3,img4;
    private Spinner spT;
    String dato,opc;

    private AsyncHttpClient cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia3 );

        spT = (Spinner)findViewById( R.id.spTalleres );



        cliente = new AsyncHttpClient( );

        llenatSpinner();

        spT.setOnItemSelectedListener(this);

        img4 = (ImageView) findViewById( R.id.imgB5 );
        img4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

        img1 = (ImageView) findViewById( R.id.imgD3M1 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opc="1";
                Intent in = new Intent( dia3.this, d3Menu.class );
                in.putExtra( "opc",opc );
                in.putExtra( "taller",dato );
                startActivity( in );
            }
        } );

        img2 = (ImageView) findViewById( R.id.imgD3M2 );
        img2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opc="2";
                Intent in = new Intent( dia3.this, d3Menu.class );
                in.putExtra( "opc", opc);
                in.putExtra( "taller",dato );
                startActivity( in );
            }
        } );


        img3 = (ImageView) findViewById( R.id.imgD3M3 );
        img3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opc="3";
                Intent in = new Intent( dia3.this, d3Menu.class );
                in.putExtra( "opc",opc );
                in.putExtra( "taller",dato );
                startActivity( in );
            }
        } );




    }

    private void llenatSpinner() {
        String url="http://edukatic.icesi.edu.co/complementos_apk/d3Taller.php";
        cliente.post( url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    cargarSpinner(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        } );
    }

    private void cargarSpinner(String respuesta) {
        ArrayList<Talleres> lista = new ArrayList<Talleres>();

        try{
            JSONArray jsonArreglo = new JSONArray( respuesta );
            for(int i=0; i< jsonArreglo.length(); i++){

                Talleres t = new Talleres();
                t.setNombre( jsonArreglo.getJSONObject( i ).getString("nombreTaller") );
                lista.add( t );
            }

            ArrayAdapter <Talleres> a = new ArrayAdapter<Talleres>(this,android.R.layout.simple_dropdown_item_1line,lista);
            spT.setAdapter( a );


        }catch (Exception e){

        }

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        dato = parent.getItemAtPosition(position).toString();
        //Toast.makeText( getApplicationContext(),dato, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }



}
