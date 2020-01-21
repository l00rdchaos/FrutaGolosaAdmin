package com.frutagolosa.fgadm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Clave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clave);
        final EditText edtPass=(findViewById(R.id.edtPassword));


        Button  btnpass=(findViewById(R.id.btnAceptaPassword));
    btnpass.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String a= edtPass.getText().toString().trim();
            if(a.equals("GYE221523")||a.equals("UIO151217")){
                savepreferences();
                Intent d = new Intent(Clave.this, MainActivity.class);
                startActivity(d);
                finish();


            }else{
                Toast.makeText(Clave.this, "Clave Incorrecta", Toast.LENGTH_SHORT).show();


            }



        }
    });

    }



    private void savepreferences(){
        EditText edtPass=(findViewById(R.id.edtPassword));
        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
   String clave=edtPass.getText().toString().trim();

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("claveus",clave);

        editor.commit();

    }


}
