package com.example.moviles.Network;

import com.example.moviles.Model.Estudiante;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiService {

    @GET("ApiRest.php")
    Call<List<Estudiante>> obtenerEstudiante();

    @POST("ApiRest.php")
    Call<Object> insertarEstudiante(@Body Estudiante estudiante);

    @PUT("ApiRest.php")
    Call<Object> actualizarEstudiante(@Query("cedula") String cedula,@Body Estudiante estudiante);

    @DELETE("ApiRest.php")
    Call<Object> eliminarEstudiante(@Query("cedula") String cedula);
}
