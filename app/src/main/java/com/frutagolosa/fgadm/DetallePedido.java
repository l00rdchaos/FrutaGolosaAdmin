package com.frutagolosa.fgadm;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.frutagolosa.fgadm.api.RegisterApi2;
import com.frutagolosa.fgadm.api.RegisterApiEstado;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DetallePedido extends AppCompatActivity {
    public static final String IDPEDIDOA="id0" ;
    public static final String IdArregloA="id2" ;
    public static final String FechaPedidoA="id3" ;
    public static final String NombreClientesA="id4" ;
    public static final String CorreoClienteA="id5" ;
    public static final String TelefonoClienteA="id6" ;
    public static final String NombreqRecibeA="id7" ;
    public static final String FechaQrecibeA="id8" ;
    public static final String TelefonoQrecibeA="id9" ;
    public static final String FranjaHorariaA="id10" ;
    public static final String CallePrincipalA="id11" ;
    public static final String CalleSecundariaA="id12" ;
    public static final String CasaempresaedifcioA="id13" ;
    public static final String referenciaA="id14" ;
    public static final String PortadaTarjetaA="id15" ;
    public static final String TextoTarjetaA="id16" ;
    public static final String EspecificacionA="id17" ;
    public static final String EstadoA="id18" ;
    public static final String EstadoB="id188" ;
    public static final String KeyAccountA="id19" ;
    public static final String ParroquiaA="id20" ;
    public static final String Costo_EnvioA="id21" ;
    public static final String GloboA="id22" ;
    public static final String SectorA="id22" ;
    public static final String CoordenadaA="id23" ;
    public static final String ROOT_URL="https://frutagolosa.com/FrutaGolosaApp";
    Bitmap bitmap;
    int PICK_IMAGE_REQUEST = 1;
    String UPLOAD_URL = "https://frutagolosa.com/FrutaGolosaApp/Upload.php";
    String KEY_IMAGE = "foto";
    String KEY_NOMBRE = "nombre";
    private final int xf=(int)(Math.random()*10000);
    private final String xf2=String.valueOf(xf);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pedido);
        setTitle("Detalles Pedido");
        final EditText IdArregloEDT=(EditText) findViewById(R.id.nombreArregloEDTX2);
        final EditText FechaEntregaEDT=(EditText) findViewById(R.id.fechaEntregaEdtx);
        final EditText NombreQRecibeEDT=(EditText) findViewById(R.id.nombre_qrecibeEDTX);
        final EditText TelefonoqRecibeEDT=(EditText) findViewById(R.id.telefonoQuienRecibeEdtX);
        final EditText FranjaHorariaEDT=(EditText) findViewById(R.id.horarioEDTX);
        final EditText CallePrincipalEDT=(EditText) findViewById(R.id.calleprincipalEDTX);
        final EditText CalleSecundariaEDT=(EditText) findViewById(R.id.callesecundariaEDTX);
        final EditText CasaempreEDT=(EditText) findViewById(R.id.casaempreEDTX);
        final EditText ReferenciaEDT=(EditText) findViewById(R.id.referenciaEDTX);
        final EditText PortadaTarEDT=(EditText) findViewById(R.id.portadaTarjetEDTX);
        final EditText TextoTarjetaEDT=(EditText) findViewById(R.id.textoTarjetaEDTX);
        final EditText EspecificacionEDT=(EditText) findViewById(R.id.especifacionEDTX);
        final EditText KeyAccountEDT=(EditText) findViewById(R.id.keyAccountEDTX);
        final EditText ParroquiaEDT=(EditText) findViewById(R.id.parroquiaEDTX);
        final EditText CostoEnvioEDT=(EditText) findViewById(R.id.costoEnvioEdtx);
        final EditText GloboEDT=(EditText) findViewById(R.id.globoEdtx);
        final EditText sectorEDT=(EditText) findViewById(R.id.sectorEDTX);


        final TextView IDPEDIDOTXTt=(TextView) findViewById(R.id.IDPEDIDOTXT2);
        final TextView Fecha_Pedidotxt=(TextView) findViewById(R.id.FechaPedidoTxt2);
        final TextView Nombre_Clientetxt=(TextView) findViewById(R.id.Nombreclientetxt2);
        final TextView Telefono_Clientetxt=(TextView) findViewById(R.id.TelefonoClienteTXT2);
        final TextView Correo_Clientetxt=(TextView) findViewById(R.id.CorreoCienteTXT2);
        final  TextView Nombre_qrecibetxt=(TextView) findViewById(R.id.vNombreQrecibetxt2);
        final TextView Fecha_qRecibetxt=(TextView) findViewById(R.id.vFechaEnt);
        final  TextView idArreglotxt=(TextView) findViewById(R.id.vArreglo);
        final TextView TelefoqRecibetxt=(TextView) findViewById(R.id.vTelefonoQrecibetxt22);

        final TextView FranjaHorariatxt=(TextView) findViewById(R.id.vFranjaHorariatxt2);
        final TextView CallePrincipaltxt=(TextView) findViewById(R.id.vCallePrincipaltxt2);
        final TextView CalleSecundariattxt=(TextView) findViewById(R.id.vCalleSecunadariatxt2);
        final TextView CasaempresaEdifciotxt=(TextView) findViewById(R.id.vCasaEmpresaEdifciotxt2);
        final TextView Referenciatxt=(TextView) findViewById(R.id.vReferenciatxt2);
        final TextView Portadatarjetatxt=(TextView) findViewById(R.id.vPortadaTarjetatxt2);
        final TextView Textotarjetatxt=(TextView) findViewById(R.id.vtextoTarjetatxt2);
        final TextView Especificaciontxt=(TextView) findViewById(R.id.vEspecificaciontxt2);

        final TextView Estadotxt=(TextView) findViewById(R.id.estadotxt2);
        final TextView KeyAccounttxt=(TextView) findViewById(R.id.vkeyaccounttxt2);
        final TextView Parroquiatxt=(TextView) findViewById(R.id.vparroquiatxt2);
        final TextView Costoenviotxt=(TextView) findViewById(R.id.vcostoenviotxt2);
        final TextView globotxt=(TextView) findViewById(R.id.vglobotxt2);
        final TextView sectortxt=(TextView) findViewById(R.id.vSectortxt2);
        final  TextView coordenadatxt=(TextView) findViewById(R.id.Coordenadastxt2);
        final TextView ViewArregloEntregado=findViewById(R.id.idViewFotoEntregado);
        final TextView ViewArregloFabricadoo=findViewById(R.id.ViewFotoArreListo);

        final ImageView FotoArregloLIsto=findViewById(R.id.ImgFotoAregloListo);

        final ImageView ImgArregloEntregado=findViewById(R.id.FotoArregloEntregado);
        final ImageView ImgArregloFabricado=findViewById(R.id.ImgFotoAregloListo);
        final ImageView ImgArreglo=findViewById(R.id.imageView5);


        final Button btnAcepPedido=(Button) findViewById(R.id.btnAcepPedido);
        Button btnCambiarEstadoPedido=(Button)findViewById(R.id.btnCambioDeEstado) ;

        final Button btnRechazaPed=(Button) findViewById(R.id.btnRechaPedido);

        final Button btnwsp=(Button) findViewById(R.id.btnwhatsaap);


        btnAcepPedido.setVisibility(View.GONE);
        btnRechazaPed.setVisibility(View.GONE);
        final String IDPEDIDO=getIntent().getStringExtra(Pedidos_PorAceptar.IdPEDIDOA);
        final String idarrelgo=getIntent().getStringExtra(Pedidos_PorAceptar.IdArregloA);
        final String nombrearreglo=idarrelgo.replace(" ","").toLowerCase().trim();
        final String Fecha_Pedido=getIntent().getStringExtra(Pedidos_PorAceptar.FechaPedidoA);
        final String Nombre_Cliente=getIntent().getStringExtra(Pedidos_PorAceptar.NombreClientesA);
        final String Telefono_Cliente=getIntent().getStringExtra(Pedidos_PorAceptar.TelefonoClienteA);
        final String Correo_Cliente=getIntent().getStringExtra(Pedidos_PorAceptar.CorreoClienteA);
        final  String Nombre_qRecibe=getIntent().getStringExtra(Pedidos_PorAceptar.NombreqRecibeA);
        final String Fecha_qRecibe=getIntent().getStringExtra(Pedidos_PorAceptar.FechaQrecibeA);
        final String Telefono_qrecibe=getIntent().getStringExtra(Pedidos_PorAceptar.TelefonoQrecibeA);
        final String Franaja_horara=getIntent().getStringExtra(Pedidos_PorAceptar.FranjaHorariaA);
        final String Calle_principal=getIntent().getStringExtra(Pedidos_PorAceptar.CallePrincipalA);
        final String Calle_secundaria=getIntent().getStringExtra(Pedidos_PorAceptar.CalleSecundariaA);
        final String Casaempresaedificio=getIntent().getStringExtra(Pedidos_PorAceptar.CasaempresaedifcioA);
        final String referencia=getIntent().getStringExtra(Pedidos_PorAceptar.referenciaA);
        final  String Portada_tarjeta=getIntent().getStringExtra(Pedidos_PorAceptar.PortadaTarjetaA);
        final String Texto_tarjeta=getIntent().getStringExtra(Pedidos_PorAceptar.TextoTarjetaA);
        final String Especificacion=getIntent().getStringExtra(Pedidos_PorAceptar.EspecificacionA);
        final String Estado=getIntent().getStringExtra(Pedidos_PorAceptar.EstadoA);
        final String Keyaccount=getIntent().getStringExtra(Pedidos_PorAceptar.KeyAccountA);
        final String Parroquia=getIntent().getStringExtra(Pedidos_PorAceptar.ParroquiaA);
        final String Costo_envio=getIntent().getStringExtra(Pedidos_PorAceptar.Costo_EnvioA);
        final String Globo=getIntent().getStringExtra(Pedidos_PorAceptar.GloboA);
        final String sector=getIntent().getStringExtra(Pedidos_PorAceptar.SectorA);
        final  String coordenadas=getIntent().getStringExtra(Pedidos_PorAceptar.CoordenadaA);

        final  String imgpago=getIntent().getStringExtra(Pedidos_PorAceptar.imagenA);
        final  String imgal=getIntent().getStringExtra(Pedidos_Fabricados.imgalaA);
        final  String imgaent=getIntent().getStringExtra(Pedidos_PorAceptar.imgaentA);

        final Spinner SpinnerEstado=findViewById(R.id.IdSpEstado);
        final Button btnCambioDeEstado=findViewById(R.id.btnCambioDeEstado);

        final ImageView Fotopagoimg=findViewById(R.id.imgvFotoPago);


        Glide.with(this).asBitmap().load("https://frutagolosa.com/FrutaGolosaApp/Administrador/images/"+nombrearreglo+".jpg").into(ImgArreglo);

        IdArregloEDT.setVisibility(View.GONE);
        NombreQRecibeEDT.setVisibility(View.GONE);
        FechaEntregaEDT.setVisibility(View.GONE);
        TelefonoqRecibeEDT.setVisibility(View.GONE);
        IdArregloEDT.setText(idarrelgo);
        FranjaHorariaEDT.setVisibility(View.GONE);
        CallePrincipalEDT.setVisibility(View.GONE);
        CalleSecundariaEDT.setVisibility(View.GONE);
        CasaempreEDT.setVisibility(View.GONE);
        ReferenciaEDT.setVisibility(View.GONE);
        PortadaTarEDT.setVisibility(View.GONE);
        TextoTarjetaEDT.setVisibility(View.GONE);
        EspecificacionEDT.setVisibility(View.GONE);
        KeyAccountEDT.setVisibility(View.GONE);
        ParroquiaEDT.setVisibility(View.GONE);
        CostoEnvioEDT.setVisibility(View.GONE);
        GloboEDT.setVisibility(View.GONE);
        sectorEDT.setVisibility(View.GONE);


        NombreQRecibeEDT.setText(Nombre_qRecibe);
        FechaEntregaEDT.setText(Fecha_qRecibe);
        TelefonoqRecibeEDT.setText(Telefono_qrecibe);

        FranjaHorariaEDT.setText(Franaja_horara);
        CallePrincipalEDT.setText(Calle_principal);
        CalleSecundariaEDT.setText(Calle_secundaria);
        CasaempreEDT.setText(Casaempresaedificio);
        ReferenciaEDT.setText(referencia);
        PortadaTarEDT.setText(Portada_tarjeta);
        TextoTarjetaEDT.setText(Texto_tarjeta);
        EspecificacionEDT.setText(Especificacion);
        KeyAccountEDT.setText(Keyaccount);
        ParroquiaEDT.setText(Parroquia);
        CostoEnvioEDT.setText(Costo_envio);
        GloboEDT.setText(Globo);
        sectorEDT.setText(sector);

        ImageView ftEimg=findViewById(R.id.FotoArregloEntregado);

        Glide.with(this).load(imgpago).into(Fotopagoimg);
        Glide.with(this).load(imgal).into(FotoArregloLIsto);
        Glide.with(this).load(imgaent).into(ftEimg);
        FotoArregloLIsto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();

            }
        });

        if (Estado.equals("Por Confirmar")){

            btnAcepPedido.setVisibility(View.INVISIBLE);
            btnRechazaPed.setVisibility(View.INVISIBLE);

        }

        IDPEDIDOTXTt.setText("ID de Pedido: "+IDPEDIDO);
        idArreglotxt.setText("Arreglo: "+idarrelgo);
        Fecha_Pedidotxt.setText("Fecha Pedido: "+Fecha_Pedido);
        Nombre_Clientetxt.setText("Nombre Cliente:"+Nombre_Cliente);
        Telefono_Clientetxt.setText("Telefono Cliente: "+Telefono_Cliente);
        Correo_Clientetxt.setText("Correo Cliente: "+Correo_Cliente);
        Nombre_qrecibetxt.setText("Recibe: "+Nombre_qRecibe);
        Fecha_qRecibetxt.setText("Fecha a Entregar: "+Fecha_qRecibe);
        TelefoqRecibetxt.setText("Telefono quien recibe: "+Telefono_qrecibe);
        FranjaHorariatxt.setText("Horario: "+Franaja_horara);
        CallePrincipaltxt.setText("Calle Principal: "+Calle_principal);
        CalleSecundariattxt.setText("Calle Secundaria: "+Calle_secundaria);
        CasaempresaEdifciotxt.setText("Estructura: "+Casaempresaedificio);
        Referenciatxt.setText("Referencia: "+referencia);
        Portadatarjetatxt.setText("Portada Tarjeta: "+Portada_tarjeta);
        Textotarjetatxt.setText("Texto Tarjeta: "+Texto_tarjeta);
        Especificaciontxt.setText("Especificacion: "+Especificacion);
        Estadotxt.setText("Estado:"+Estado);
        KeyAccounttxt.setText("Keyaccount: "+Keyaccount);
        Parroquiatxt.setText("Parroquia: "+Parroquia);
        Costoenviotxt.setText("Costo Envio: "+Costo_envio);
        globotxt.setText("Globo: "+Globo);
        sectortxt.setText("Sector: "+sector);
        coordenadatxt.setText("Coordenadas: "+coordenadas);


        btnwsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberWithCountryCode=Telefono_Cliente;
                String message="";
                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=" + numberWithCountryCode + "&text=" + message);

                Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);

                getApplicationContext().startActivity(sendIntent);
            }
        });






        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.EstadoPedidos, android.R.layout.simple_spinner_item);
        SpinnerEstado.setAdapter(adapter2);

        btnAcepPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView ViewArregloListo=findViewById(R.id.ViewFotoArreListo);
                final ImageView ImgArregloListo=findViewById(R.id.ImgFotoAregloListo);

                final Spinner SpinnerEstado=findViewById(R.id.IdSpEstado);

                final Button btnRecharazapedi=findViewById(R.id.btnRechaPedido);

                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL)
                        .build();

                RegisterApiEstado api = adapter.create(RegisterApiEstado.class);
                String a="En Espera";
                String b=IDPEDIDO;
                Estadotxt.setText(a);
                api.inseruser(
                        a,
                        b,


                        new Callback<retrofit.client.Response>() {
                            @Override
                            public void success(retrofit.client.Response result, Response response) {

                                SpinnerEstado.setVisibility(View.VISIBLE);
                                btnCambioDeEstado.setVisibility(View.VISIBLE);

                                ViewArregloListo.setVisibility(View.VISIBLE);
                                ImgArregloListo.setVisibility(View.VISIBLE);
                                BufferedReader reader = null;

                                String output = "";

                                try {
                                    reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                                    output = reader.readLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                Toast.makeText(DetallePedido.this, output, Toast.LENGTH_LONG).show();
                                btnAcepPedido.setVisibility(View.GONE);
                                btnRecharazapedi.setVisibility(View.GONE);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(DetallePedido.this, error.toString(), Toast.LENGTH_LONG).show();

                            }
                        }
                );

            }
        });


        btnCambiarEstadoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String a=SpinnerEstado.getSelectedItem().toString();
                String b=IDPEDIDO;


                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL)
                        .build();

                RegisterApiEstado api = adapter.create(RegisterApiEstado.class);

                api.inseruser(
                        a,
                        b,


                        new Callback<retrofit.client.Response>() {
                            @Override
                            public void success(retrofit.client.Response result, Response response) {

                                Estadotxt.setText("Estado:"+a);
                                BufferedReader reader = null;

                                String output = "";

                                try {
                                    reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                                    output = reader.readLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                Toast.makeText(DetallePedido.this, output, Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(DetallePedido.this, error.toString(), Toast.LENGTH_LONG).show();

                            }
                        }
                );

            }

        });





    }
    public String getStringImagen(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public void uploadImage() {
        final String Fecha_qRecibe=getIntent().getStringExtra(Pedidos_PorAceptar.FechaQrecibeA);
        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        final String nombreus=preferences.getString("nombreus","Registrese");
        final String telefonous=preferences.getString("telefonous","No");

        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo...", "Espere por favor");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        Toast.makeText(DetallePedido.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String imagen = getStringImagen(bitmap);
                String nombre = Fecha_qRecibe.replace("/","a")+nombreus+telefonous+xf2;

                Map<String, String> params = new Hashtable<String, String>();
                params.put(KEY_IMAGE, imagen);
                params.put(KEY_NOMBRE, nombre);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Seleciona imagen"), PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView si = (ImageView) findViewById(R.id.ImgFotoAregloListo);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Cómo obtener el mapa de bits de la Galería
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                bitmap = Bitmap.createScaledBitmap(bitmap, 440, 520, true);
             Glide.with(this).asBitmap().load(bitmap).into(si);
                //Configuración del mapa de bits en ImageView
insetaimagenarreglolisto();
uploadImage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private void insetaimagenarreglolisto(){
        final String IDPEDIDO=getIntent().getStringExtra(Pedidos_PorAceptar.IdPEDIDOA);
        final String Fecha_qRecibe=getIntent().getStringExtra(Pedidos_PorAceptar.FechaQrecibeA);
        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        final String nombreus=preferences.getString("nombreus","Registrese");
        final String telefonous=preferences.getString("telefonous","No");

        String a="https://frutagolosa.com/FrutaGolosaApp/uploads/"+Fecha_qRecibe.replace("/","a")+nombreus+telefonous+xf2+".png";
        String b=IDPEDIDO;

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        RegisterApi2 api = adapter.create(RegisterApi2.class);

        api.inseruser(
                a,
                b,


                new Callback<retrofit.client.Response>() {
                    @Override
                    public void success(retrofit.client.Response result, Response response) {

                        BufferedReader reader = null;

                        String output = "";

                        try {
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(DetallePedido.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(DetallePedido.this, error.toString(), Toast.LENGTH_LONG).show();

                    }
                }
        );





    }

}