package com.example.moviles.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviles.Model.Estudiante;
import com.example.moviles.R;

import java.util.List;

public class EstudianteAdapter extends RecyclerView.Adapter<EstudianteAdapter.ViewHolder> {

    private List<Estudiante> lista;
    private OnEstudianteClickListener listener;

    public EstudianteAdapter(List<Estudiante> lista, OnEstudianteClickListener listener) {
        this.lista = lista;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView cedula,nombre,apellido,telefono,direccion;
        Button btnEditar;
        ImageButton btnEliminar;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            cedula=itemView.findViewById(R.id.txtCedula);
            nombre=itemView.findViewById(R.id.txtNombre);
            apellido=itemView.findViewById(R.id.txtApellido);
            telefono=itemView.findViewById(R.id.txtTelefono);
            direccion=itemView.findViewById(R.id.txtDireccion);
            btnEditar=itemView.findViewById(R.id.btnEditar);
            btnEliminar=itemView.findViewById(R.id.btnEliminar);
        }
    }

    public interface OnEstudianteClickListener{
        void onEditarClick(Estudiante estudiante);
        void onEliminarClick(Estudiante estudiante);
    }


    @NonNull
    @Override
    public EstudianteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudiante,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EstudianteAdapter.ViewHolder holder, int position) {
     Estudiante estudiante=lista.get(position);
     holder.cedula.setText(estudiante.getCedula());
     holder.nombre.setText(estudiante.getNombre());
     holder.apellido.setText(estudiante.getApellido());
     holder.telefono.setText(estudiante.getTelefono());
     holder.direccion.setText(estudiante.getDireccion());
     holder.btnEditar.setOnClickListener(v->listener.onEditarClick(estudiante));
     holder.btnEliminar.setOnClickListener(v->listener.onEliminarClick(estudiante));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
