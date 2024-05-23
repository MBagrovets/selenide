package com.itacademy;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiParsingXML {
    @Test
    public void validateXML(){
        Response response = given()
                .get("https://mocktarget.apigee.net/xml")
                .then().statusCode(200).log().all().extract().response();
        System.out.println(response.xmlPath().getString("root.city"));
        XmlPath xmlPath = new XmlPath(response.asString());
    }
}
