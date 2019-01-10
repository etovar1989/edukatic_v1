package com.example.l.edukatic_v1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class d1ValQR extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView myScannerView;
    Button btnEcanear;
    String dato,cc,tipo,opc;
    TextView textoTipo;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d1_val_qr );

        //Recupero texto enviado
        tipo = getIntent().getStringExtra( "tipo" );

        //busco texto para cambiar el texto que este muestra
        textoTipo = (TextView) findViewById( R.id.txtTipo2 );
        //Envio el texto recuperado del inten
        textoTipo.setText( tipo );

        img1 = (ImageView) findViewById( R.id.imgB4 );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );


    }

    public void Escanear(View vista){
        myScannerView = new ZXingScannerView( this );
        setContentView( myScannerView );
        myScannerView.setResultHandler( this );
        myScannerView.startCamera();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );

    }

    @Override
    public void handleResult(Result result) {
        dato = result.getText();
        opc = getIntent().getStringExtra( "opc" );
        tipo = getIntent().getStringExtra( "tipo" );
        Toast.makeText( this,"Consulta "+dato, Toast.LENGTH_SHORT).show();
        //myScannerView.resumeCameraPreview( this );

        Intent in = new Intent( d1ValQR.this, d1Resultado.class );
        in.putExtra( "cc",dato);
        in.putExtra( "opc",opc );
        in.putExtra( "tipo",tipo );
        startActivity( in );
        finish();

    }
}
