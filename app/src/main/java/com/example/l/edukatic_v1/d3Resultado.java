package com.example.l.edukatic_v1;

import android.graphics.Color;
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

public class d3Resultado extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    String opc,cc, taller;
    TextView texto;
    String dato1="";

    RequestQueue rq;
    JsonRequest jrq;

    ImageView img1,img2, img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_d3_resultado );




        //Toast.makeText( this,"OK "+taller, Toast.LENGTH_SHORT).show();
        //Toast.makeText( this,"OK "+opc, Toast.LENGTH_SHORT).show();
        //Toast.makeText( this,"OK "+cc, Toast.LENGTH_SHORT).show();

        rq = Volley.newRequestQueue(this);
        validarCedula();


        /*

        */
        //texto.setcolor(#RGB);




    }

    private void validarCedula( ) {
        opc = getIntent().getStringExtra( "opc" );
        cc = getIntent().getStringExtra( "cc" );
        taller = getIntent().getStringExtra( "taller" );
        String url="http://edukatic.icesi.edu.co/complementos_apk/d3Validacion.php?idU=" + cc +"&taller="+taller+"&opc="+opc;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText( this,"Error contactate con el administrador", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onResponse(JSONObject response) {

        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            dato1 = ( jsonObject.optString( "validador" ) );
            //Toast.makeText( this,dato1, Toast.LENGTH_SHORT).show();
            texto = (TextView)findViewById( R.id.txtRespuesta );
            texto.setText( dato1 );
            if(dato1.equals( "No hay datos" ) || dato1.equals( "usuario no pertenece a ese taller" )){
                texto.setTextColor( Color.RED);
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
