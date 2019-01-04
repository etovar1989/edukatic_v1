package com.example.l.edukatic_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoConsultaQR extends AppCompatActivity {

    private TextView tv1;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_resultado_consulta_qr );

        tv1 = (TextView)findViewById( R.id.txtC);
        String dato1 = getIntent().getStringExtra( "cc" );
        tv1.setText(dato1);


        img1 = (ImageView) findViewById( R.id.imgBk );
        img1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

    }
}
