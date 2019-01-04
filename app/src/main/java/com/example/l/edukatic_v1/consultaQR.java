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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_consulta_qr );

        /*
        btnEcanear = (Button) findViewById( R.id.btnScanQR );

        if( validaPermisos()){
           btnEcanear.setEnabled( true );
        }else{
            btnEcanear.setEnabled( false );
        }
        */

    }

    private boolean validaPermisos() {

        //Se valida la version del SO del celular M para Marsmello
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return true;
        }

        if((checkSelfPermission(CAMERA)==PackageManager.PERMISSION_GRANTED)){
            return true;
        }

        if((shouldShowRequestPermissionRationale( CAMERA ))){
            cargarDialogoRecomendacion();
        }else{
            requestPermissions(new String[]{CAMERA},100);
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );

        if(requestCode==100){
            if(grantResults.length==1 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                btnEcanear.setEnabled( true );
            }else{
                
                solicitarPersmisosManual();
                
            }
        }
    }

    private void solicitarPersmisosManual() {
        final CharSequence[] opcione = {"si","no"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder( consultaQR.this );
        alertOpciones.setTitle( "¿Desea caonfigurar los permisos de forma manual?" );
        alertOpciones.setItems( opcione, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(opcione[i].equals( "si" )){
                    Intent intent = new Intent();
                    intent.setAction( Settings.ACTION_APPLICATION_DETAILS_SETTINGS );
                    Uri uri = Uri.fromParts("package",getPackageName(),null);
                    intent.setData( uri );
                    startActivity(intent);

                }else{
                    Toast.makeText( getApplicationContext(),"Los permisos no fueron aceptados", Toast.LENGTH_SHORT ).show();
                    dialogInterface.dismiss();
                }
            }
        } );

    }

    private void cargarDialogoRecomendacion() {

        //cuado de dialogo con boton de solitud de permisos
        AlertDialog.Builder dialogo = new AlertDialog.Builder( consultaQR.this );
        dialogo.setTitle( "Permisos Deactivados" );
        dialogo.setMessage( "Debe de aceptar los permisos para el correcto funcionamiento de la App" );

        //boton de solicitud de permisos "Aceptar"
        dialogo.setPositiveButton( "Aceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                requestPermissions(new String[]{CAMERA},100);
            }
        } );

        dialogo.show();

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
