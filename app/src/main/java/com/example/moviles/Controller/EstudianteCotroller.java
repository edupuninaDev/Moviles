package com.example.moviles.Controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.moviles.Adapter.EstudianteAdapter;
import com.example.moviles.Model.Estudiante;
import com.example.moviles.Network.ApiService;
import com.example.moviles.Network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstudianteCotroller {

    private Context context;

    public EstudianteCotroller(Context context) {
        this.context = context;
    }

    public void cargarEstudiante(EstudianteAdapter.OnEstudianteClickListener listener, final RecyclerView recycler){
        ApiService api= RetrofitClient.getClient().create(ApiService.class);
        api.obtenerEstudiante().enqueue(new Callback<List<Estudiante>>() {
            @Override
            public void onResponse(Call<List<Estudiante>> call, Response<List<Estudiante>> response) {
                if (response.isSuccessful() && response.body()!=null){
                    EstudianteAdapter adapter=new EstudianteAdapter(response.body(),listener);
                    recycler.setAdapter(adapter);
                }else{
                    Log.e("Api","Respuesta vacia:"+response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Estudiante>> call, Throwable t) {
                Log.e("Api","Error de conexion:"+t.getMessage());
            }
        });
    }

    public void eliminarEstudiante(String cedula, Runnable onSucces, Runnable onError){
        ApiService api=RetrofitClient.getClient().create(ApiService.class);
        api.eliminarEstudiante(cedula).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()){
                    Toast.makeText(context, "Estudiante Eliminado", Toast.LENGTH_SHORT).show();
                    onSucces.run();
                }else{
                    Toast.makeText(context, "Error al  eliminar", Toast.LENGTH_SHORT).show();
                    onError.run();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(context, "Error de conexion", Toast.LENGTH_SHORT).show();
                onError.run();
            }
        });

    }
}
