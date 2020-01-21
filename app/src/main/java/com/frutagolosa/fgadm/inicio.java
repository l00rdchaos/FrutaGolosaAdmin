package com.frutagolosa.fgadm;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.frutagolosa.fgadm.api.ApiInterfaceVersion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        final Button btnreiniciarapp=findViewById(R.id.btnReiniciarApp);
        final Button btncerrarapp=findViewById(R.id.btnCerrarApp);
        final TextView dato=(TextView)findViewById(R.id.textdato);
        final String version="0.0.1";
        final ProgressDialog loading = ProgressDialog.show(this, "Cargando...", "Espere por favor");
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint("https://frutagolosa.com/FrutaGolosaApp/versiona.php?z="+version)
                        .build();

                ApiInterfaceVersion api = adapter.create(ApiInterfaceVersion.class);

                String z=version;
                api.evaluaversion(
                        z,




                        new Callback<Response>() {
                            @Override
                            public void success(Response result, Response response) {

                                BufferedReader reader = null;
                                String output = "";

                                try {
                                    reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                                    output = reader.readLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if(output.equals("Actual")){

                                    SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
                                    String claveus=preferences.getString("claveus","Registrese");

                                    if(claveus.equals("Registrese")) {
                                        Intent ra = new Intent(inicio.this, Clave.class);

                                        startActivity(ra);

                                    }else {
                                        Intent d = new Intent(inicio.this, MainActivity.class);


                                        startActivity(d);
                                        finish();

                                    }
                                }else {

                                    btncerrarapp.setVisibility(View.VISIBLE);
                                    btnreiniciarapp.setVisibility(View.VISIBLE);
                                    dato.setVisibility(View.VISIBLE);
                                    loading.dismiss();
                                    dato.setText("Su aplicacion esta desactualizada, por favor actualice para continuar.");
                                }

                            }

                            @Override
                            public void failure(RetrofitError error) {

                                btncerrarapp.setVisibility(View.VISIBLE);
                                btnreiniciarapp.setVisibility(View.VISIBLE);
                                dato.setVisibility(View.VISIBLE);
                                dato.setText("Problemas de conexion,Revise e intente de nuevo");
                                loading.dismiss();
                            }
                        }
                );







            }
        },3000);

        btncerrarapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnreiniciarapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }


}
