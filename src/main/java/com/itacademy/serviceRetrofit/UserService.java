package com.itacademy.serviceRetrofit;

import com.itacademy.modelRetrofit.listusers.Root;
import com.itacademy.modelRetrofit.post.UserRequest;
import com.itacademy.modelRetrofit.post.UserResponse;
import com.itacademy.modelRetrofit.simpleuser.SimgleRoot;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {

    @GET("/api/users")
    Call<Root> getUsers(@Query("page") int id);

    @GET("/api/users/{id}")
    Call<SimgleRoot> getUserById(@Path("id") int id);

    @POST("/api/users")
    Call<UserResponse> createUser(@Body UserRequest userRequest);

    @DELETE("/api/users/{id}")
    Call<Void> deleteUser(@Path("id")int id);
}
