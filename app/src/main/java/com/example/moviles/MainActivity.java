package com.example.moviles;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviles.Adapter.EstudianteAdapter;
import com.example.moviles.Controller.EstudianteCotroller;
import com.example.moviles.Model.Estudiante;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler ;
    EstudianteCotroller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  EdgeToEdge.enable(this);
  setContentView(R.layout.activity_main);
recycler=findViewById(R.id.recyclerEstudiantes);
recycler.setLayoutManager(new LinearLayoutManager(this));
controller=new EstudianteCotroller(this);

EstudianteAdapter.OnEstudianteClickListener listener=new EstudianteAdapter.OnEstudianteClickListener(){
    @Override
    public void onEditarClick(Estudiante estudiante) {
    }

    @Override
    public void onEliminarClick(Estudiante estudiante) {
confirmarElimnar(estudiante);
    }
};
controller.cargarEstudiante(listener,recycler);
    }
    private void eliminarEstudiante(String cedula){
        controller.eliminarEstudiante(cedula,()->controller.cargarEstudiante(new EstudianteAdapter.OnEstudianteClickListener() {
                    @Override
                    public void onEditarClick(Estudiante estudiante) {
                    }
                    @Override
                    public void onEliminarClick(Estudiante estudiante) {
                        confirmarElimnar(estudiante);
                    }
                },recycler)
                ,()->{
                });
    }
private void confirmarElimnar(Estudiante estudiante){
 new AlertDialog.Builder(this).setTitle("Confirmar eliminacion")
         .setMessage("Desea eliminar al estudiante con cedula: "+estudiante.getCedula()+"?")
         .setPositiveButton("Eliminar",(dialog, which) -> eliminarEstudiante(estudiante.getCedula()))
         .setNegativeButton("Cancelar",null)
         .show();
}

}