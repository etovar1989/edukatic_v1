package com.example.l.edukatic_v1;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class consultaQR extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView myScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_consulta_qr );
    }

    public void btnEscanear(View vista){
        myScannerView = new ZXingScannerView( this );
        setContentView( myScannerView );
        myScannerView.setResultHandler( this );
        myScannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {

        Log.v("HnadleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Resultado del Scan" );
        builder.setMessage( result.getText() );
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {



    }
}
