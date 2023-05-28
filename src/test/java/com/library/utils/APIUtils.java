package com.library.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIUtils {

    public static String getToken(String email,String password){
        return given().accept(ContentType.JSON)
                .contentType(ContentType.URLENC)
                .formParam("email",email)
                .formParam("password",password)
                .post("/login")
                .then().extract().jsonPath().getString("token");
    }

    public static Response getBookByID(String token, Integer id){
        return given().header("x-library-token",token)
                .pathParam("id",id)
                .get("/get_book_by_id/{id}");
    }

}
