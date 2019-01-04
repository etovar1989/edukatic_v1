package com.example.l.edukatic_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultadoConsultaQR extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    RequestQueue rq;
    JsonRequest jrq;
    private TextView tv1;

    String datosCC="";
    String nombre = "";
    String taller = "";
    String ubicacion = "";
    String requisitos = "";
    String expositor = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_resultado_consulta_qr );

        tv1 = (TextView)findViewById( R.id.textoCC );
        String dato = getIntent().getStringExtra( "cc" );
        tv1.setText(dato);
        datosCC = tv1.toString();
        rq = Volley.newRequestQueue(this);
        validarCedula();

    }

    private void validarCedula() {
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_usuario.php?idU="+datosCC;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText( this,"No esta registrada la cedula ", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onResponse(JSONObject response) {

        //Toast.makeText( getContext(),"OK ", Toast.LENGTH_SHORT).show();

        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            nombre = ( jsonObject.optString( "nombreU" ) );
            taller = ( jsonObject.optString( "nombreTaller" ) );
            ubicacion = ( jsonObject.optString( "salaTaller" ) );
            requisitos = ( jsonObject.optString( "reqTaller" ) );
            expositor = ( jsonObject.optString( "expositorTaller" ) );

        } catch (JSONException e) {
            e.printStackTrace();
        }


        Toast.makeText( this,"OK "+nombre, Toast.LENGTH_SHORT).show();



    }


}
