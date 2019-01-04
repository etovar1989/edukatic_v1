package com.example.l.edukatic_v1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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


public class ConsultaCCFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    RequestQueue rq;
    JsonRequest jrq;

    EditText cajaCC;
    Button consultarCC;
    String nombre = "";
    String taller = "";
    String ubicacion = "";
    String requisitos = "";
    String expositor = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate( R.layout.fragment_consulta_cc,container,false );
        cajaCC = (EditText)vista.findViewById( R.id.txtConCC );
        consultarCC = (Button) vista.findViewById( R.id.btnConCC );

        rq = Volley.newRequestQueue(getContext());
        consultarCC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCedula();
            }
        } );



        return vista;

    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText( getContext(),"No esta registrada la cedula "+cajaCC.getText().toString(), Toast.LENGTH_LONG).show();

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


        Intent carajo = new Intent( getContext(), ResutadoConsultaCC.class );
        carajo.putExtra( "nombre",nombre);
        carajo.putExtra( "taller",taller);
        carajo.putExtra( "ubicacion",ubicacion);
        carajo.putExtra( "requisitos",requisitos);
        carajo.putExtra( "expositor",expositor);

        startActivity( carajo );

        //Toast.makeText( getContext(),"OK "+nombre, Toast.LENGTH_SHORT).show();



    }


    /*Envia la consulta a el php*/
    private void validarCedula(){
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_usuario.php?idU="+cajaCC.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
        cajaCC.setText("");

    }
}
