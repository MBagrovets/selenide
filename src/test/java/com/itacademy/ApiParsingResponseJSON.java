package com.itacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApiParsingResponseJSON {

    @BeforeMethod
    public void setUP() {
        RestAssured.baseURI = "https://reqres.in";
    }
    @Test
    void testJsonResponse(){
        Response response = given().log().all().when().get("/api/users/2").then().log().all().extract().response();
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getHeader("Connection"), "keep-alive");
        System.out.println("ID: " + response.jsonPath().getInt("data.id"));
        System.out.println("FIRST NAME: " + response.jsonPath().getString("data.first_name"));
        //JsonPath jsonPath = new JsonPath(response.asString()); //можно дальше работать с респонсом
    }

    @Test
    public void updateUserIt() {
        String name = "new name";
        Map<String, String> bodyInfo = new HashMap<>();
        bodyInfo.put("name", name);
        bodyInfo.put("job", "new job");
        String responseName =  given().log().all().contentType(ContentType.JSON).body(bodyInfo)
                .when().put("/api/users/1").jsonPath().getString("name");   //name, потому что первый уровень вложенности
        assertEquals(name, responseName);
    }
}
