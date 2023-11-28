package com.example.vinted.utils;



import com.example.vinted.data_json.JsonProductoData;
import com.example.vinted.data_json.JsonUserData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
     public static final String URL = "http://192.168.104.55:8080/untitled/";

      @Headers({
              "Accept: application/json",
              "Content-Type: application/json"
      })

      //Call<MyData> getDataUser(@Query("ACTION") String action);
      @GET("MyServlet")
        Call<JsonUserData> getDataUser(@Query("ACTION") String action,
                                       @Query("EMAIL") String email,
                                       @Query("PASSWORD") String pass);

        @GET("MyServlet")
        Call<JsonProductoData> getDataProductos(@Query("ACTION") String action,
                                                @Query("FILTRO") String filtro);





        //@GET("MyServlet")
        //Call<DataMovies> getDataMovies2(@Query("ACTION") String action);


//        @GET("MyServlet")
//          Call<MyData> getMyData(@Query("id") String id);
/*
        @GET("MyServlet/{id}")
        Call<MyData> getMyDataURL(@Path("id") String id);
*/

//        @FormUrlEncoded
//        @POST("/login")
//        Call<ApiResponse> login(@Field("username") String username, @Field("password") String password);

}
