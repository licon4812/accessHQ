package com.accessHQ.API;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestSuite {
    @Test
    public void Api_StatusCode_is200(){
        given().
                header("auth-key", "1ce06293-733b-4776-8fcb-0250b712a0c9").
                param("q", "Tascott").
                param("state", "NSW").
        when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json").
                then().
                assertThat().statusCode(200);
    }
}
