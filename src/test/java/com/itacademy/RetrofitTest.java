package com.itacademy;

import com.itacademy.serviceRetrofit.UserService;
import com.itacademy.modelRetrofit.listusers.Root;
import com.itacademy.modelRetrofit.post.UserRequest;
import com.itacademy.modelRetrofit.post.UserResponse;
import com.itacademy.modelRetrofit.simpleuser.SimgleRoot;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RetrofitTest {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private UserService userService = retrofit.create(UserService.class);

    @Test
    public void getUsers() throws IOException {
        Response<Root> rootresponse = userService.getUsers(2).execute();
        assertTrue(rootresponse.isSuccessful());
        Root root = rootresponse.body();
        assertEquals(rootresponse.code(), 200);
        System.out.println(root.getData().get(0).getFirst_name());
    }

    @Test
    public void getUserById() throws IOException {
        int id = 1;
        Response<SimgleRoot> rootresponse = userService.getUserById(id).execute();
        assertTrue(rootresponse.isSuccessful());
        SimgleRoot root = rootresponse.body();
        System.out.println(root.getSupport().getUrl());
    }

    @Test
    public void createUser() throws IOException {
        UserRequest userRequest = new UserRequest("Petya", "AQA");
        Response<UserResponse> response = userService.createUser(userRequest).execute();
        assertTrue(response.isSuccessful());
        assertEquals(response.code(), 201);
        UserResponse user = response.body();
        assertEquals(userRequest.getName(), user.getName());
        assertEquals(userRequest.getJob(), user.getJob());
    }

    @Test
    public void deleteUser() throws IOException {
        Response<Void> response = userService.deleteUser(2).execute();
        assertEquals(response.code(), 204);
    }


}
