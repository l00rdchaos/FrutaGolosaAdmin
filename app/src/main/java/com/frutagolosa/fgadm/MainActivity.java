package com.frutagolosa.fgadm;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.frutagolosa.fgadm.model.Contact;
import com.frutagolosa.fgadm.api.ApiInterface;
import com.frutagolosa.fgadm.adapter.RecyclerAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<Contact> contacts;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button PedAcp= (Button) findViewById(R.id.PedAceptarbtn);
        Button PedEsp= (Button) findViewById(R.id.PedidoEnEsperabtn);
        Button PedFab= (Button) findViewById(R.id.PedidosFabricadosbtn);
        Button PedEnRu= (Button) findViewById(R.id.PedidosEnRutabtn);
        Button PedEntreg= (Button) findViewById(R.id.PedidosEntregadosbtn);
        Button PedFF= (Button) findViewById(R.id.PedidosFF);
        PedAcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this, com.frutagolosa.fgadm.Pedidos_PorAceptar.class);
                startActivity(a);
            }
        });

        setTitle("Administrador");
        PedEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this, PedidosEsperar.class);
                startActivity(a);
            }
        });

        PedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this, Pedidos_Fabricados.class);
                startActivity(a);
            }
        });

        PedEnRu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this, Pedidos_Enruta.class);
                startActivity(a);
            }
        });

        PedEntreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this, Pedidos_Entregados.class);
                startActivity(a);
            }
        });

        PedFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this, PedidosDespachados.class);
                startActivity(a);
            }
        });


    }
}