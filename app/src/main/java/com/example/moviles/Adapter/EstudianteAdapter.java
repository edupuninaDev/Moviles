package com.example.moviles.Adapter;

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
        }
    }

    public interface OnEstudianteClickListener{
        void onEditarClick(Estudiante estudiante);
        void onEliminarClick(Estudiante estudiante);
    }


    @NonNull
    @Override
    public EstudianteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EstudianteAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
