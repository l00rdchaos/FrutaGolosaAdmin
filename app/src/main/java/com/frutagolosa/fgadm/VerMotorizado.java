package com.frutagolosa.fgadm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.frutagolosa.fgadm.adapter.RecyclerAdapter2;
import com.frutagolosa.fgadm.api.ApiClient;
import com.frutagolosa.fgadm.api.ApiInterfaceMoto2;

import com.frutagolosa.fgadm.model.Motorizado;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class VerMotorizado extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter2 adapter;
    private List<Motorizado> contacts;
    private ApiInterfaceMoto2 apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_motorizado);

        recyclerView = findViewById(R.id.recyclerViewM);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        setTitle("Detalle Motorizado");
        apiInterface = ApiClient.getApiClient().create(ApiInterfaceMoto2.class);
       // final  String motorizado=getIntent().getStringExtra(DetallePedido.MotorizadoA);
        Call<List<Motorizado>> call = apiInterface.getContacts("https://frutagolosa.com/FrutaGolosaApp/ListarMotorizado.php?a=");

        call.enqueue(new Callback<List<Motorizado>>() {
            @Override
            public void onResponse(Call<List<Motorizado>> call, Response<List<Motorizado>> response) {
                contacts = response.body();
                adapter = new RecyclerAdapter2(contacts);
                recyclerView.setAdapter(adapter);




                adapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        String coordenadas=contacts.get(recyclerView.getChildAdapterPosition(view)).getCoordenadas();



                        String map = "http://maps.google.co.in/maps?q=" + coordenadas;
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                        getBaseContext().startActivity(intent);

                    }
                });

            }



            @Override
            public void onFailure(Call<List<Motorizado>> call, Throwable t) {

            }
        });

    }
}
