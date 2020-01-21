package com.frutagolosa.fgadm.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.frutagolosa.fgadm.model.Contact;
import com.frutagolosa.fgadm.R;



import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements View.OnClickListener {

    List<Contact> contacts;
    private View.OnClickListener listener;

    public RecyclerAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.fechapedido.setText(contacts.get(position).getFecha_pedido());
        holder.telefonocliente.setText(contacts.get(position).getTelefono_cliente());
        holder.nombre.setText(contacts.get(position).getNombreCliente());
        holder.nombre_qrecibe.setText(contacts.get(position).getNombre_qRecibe());
        holder.nombre_arreglo.setText(contacts.get(position).getNombre_arreglo());
        String na=contacts.get(position).getNombre_arreglo().replace(" ","").toLowerCase().trim();
        holder.sector.setText(contacts.get(position).getSector());
        holder.telefono_qrecibe.setText(contacts.get(position).getTelefono_qRecibe());
        holder.correo_cliente.setText(contacts.get(position).getCorreo_cliente());
        holder.fecha_qrecibe.setText(contacts.get(position).getFechaEntrega());
        holder.franja_horaria.setText(contacts.get(position).getFranja_horaria());
        holder.calle_principal.setText(contacts.get(position).getCalle_principal());
        holder.calle_secundaria.setText(contacts.get(position).getCalle_secundaria());
        holder.casaempresaedificio.setText(contacts.get(position).getCasaempresaedificio());
        holder.referencia.setText(contacts.get(position).getReferencia());
        holder.portada_tarjeta.setText(contacts.get(position).getPortada_tarjeta());
        holder.estado.setText(contacts.get(position).getEstado());
        holder.globo.setText(contacts.get(position).getGlobo());
        holder.coordenadas.setText(contacts.get(position).getCoordenadas());
        holder.costo_envio.setText(contacts.get(position).getCosto_envio());
        holder.motorizado.setText(contacts.get(position).getMotorizado());
        holder.numeracion.setText(contacts.get(position).getNumeracion());
        holder.parroquia.setText(contacts.get(position).getParroquia());
        holder.keyaccount.setText(contacts.get(position).getKeyaccount());
        holder.texto_tarjeta.setText(contacts.get(position).getTexto_tarjeta());
        holder.especificacion.setText(contacts.get(position).getEspecificacion());
        holder.IDPEDIDO.setText(contacts.get(position).getID_PEDIDO());
        holder.imgpago.setText(contacts.get(position).getimagen());
        holder.imgal.setText(contacts.get(position).getimgal());
        holder.imgaent.setText(contacts.get(position).getImgaent());
        Glide.with(holder.itemView.getContext()).asBitmap().load("https://frutagolosa.com/FrutaGolosaApp/Administrador/images/"+na+".jpg").into(holder.ArregloIMG);

    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);

        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView IDPEDIDO, fechapedido, nombre, telefonocliente, nombre_qrecibe, nombre_arreglo, telefono_qrecibe, sector, correo_cliente,
                fecha_qrecibe,franja_horaria,calle_principal, calle_secundaria,casaempresaedificio,referencia,portada_tarjeta,texto_tarjeta,especificacion,
                numeracion,disenador,motorizado,estado,keyaccount,parroquia,costo_envio,regalo,cd,globo,coordenadas, imgpago,imgal,imgaent;

       ImageView ArregloIMG;


        public MyViewHolder(View itemView) {
            super(itemView);
            IDPEDIDO=itemView.findViewById(R.id.text);
            fechapedido = itemView.findViewById(R.id.Fecha_Pedido);
            nombre = itemView.findViewById(R.id.NombreCliente);
            telefonocliente = itemView.findViewById(R.id.TelfClienteTxt);
            nombre_qrecibe = itemView.findViewById(R.id.QuienRcibe);
            nombre_arreglo= itemView.findViewById(R.id.ArregloTXT);
            telefono_qrecibe=itemView.findViewById(R.id.TelefonoQrecibe);
            sector=itemView.findViewById(R.id.SectorTxt);
            correo_cliente=itemView.findViewById(R.id.correoclientetxt);
            fecha_qrecibe=itemView.findViewById(R.id.Fecha_entTxt);
            franja_horaria=itemView.findViewById(R.id.FranajaHorariaTxt);
            calle_principal=itemView.findViewById(R.id.calle_printxt);
            calle_secundaria=itemView.findViewById(R.id.calle_sectxt);
            casaempresaedificio=itemView.findViewById(R.id.casaempresaedificiotxt);
            referencia=itemView.findViewById(R.id.referenciatxt);
            portada_tarjeta=itemView.findViewById(R.id.portada_tarjetatxt);
            texto_tarjeta=itemView.findViewById(R.id.texto_tarjetatxt);
            especificacion=itemView.findViewById(R.id.especificaciontxt);
            numeracion=itemView.findViewById(R.id.numeracionTxt);
            disenador=itemView.findViewById(R.id.disenadortxt);
            motorizado=itemView.findViewById(R.id.motorizadotxt);
            estado=itemView.findViewById(R.id.estadotxt);
            keyaccount=itemView.findViewById(R.id.keyaccounttxt);
            parroquia=itemView.findViewById(R.id.parroquia_txt);
            costo_envio=itemView.findViewById(R.id.costo_enviotxt);
            regalo=itemView.findViewById(R.id.regalotxt);
            globo=itemView.findViewById(R.id.globotxt);
            coordenadas=itemView.findViewById(R.id.coordenadastxt);
            imgpago=itemView.findViewById(R.id.txtiimgpago);
            imgal=itemView.findViewById(R.id.txtimgal);
            imgaent=itemView.findViewById(R.id.txtimgaent);
             ArregloIMG=itemView.findViewById(R.id.imageView2);

        }
    }
}