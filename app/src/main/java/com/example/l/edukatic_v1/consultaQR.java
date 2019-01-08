package com.example.l.edukatic_v1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class consultaQR extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView myScannerView;
    Button btnEcanear;
    String dato="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_consulta_qr );

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );

    }

    public void btnEscanear(View vista){
        myScannerView = new ZXingScannerView( this );
        setContentView( myScannerView );
        myScannerView.setResultHandler( this );
        myScannerView.startCamera();

    }


    @Override
    public void handleResult(Result result) {

        //Log.v("HnadleResult", result.getText());

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Resultado del Scan" );
        builder.setMessage( result.getText() );
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        */

        dato = result.getText();

        Toast.makeText( this,"Consulta "+dato, Toast.LENGTH_SHORT).show();
        Intent in = new Intent( consultaQR.this, ResultadoConsultaQR.class );
        in.putExtra( "cc",dato);
        startActivity( in );
        finish();


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
