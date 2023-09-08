package test;

import baseUrl.baseURLHerOkuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlQueryParam extends baseURLHerOkuapp {

    /*
     https://restful-booker.herokuapp.com/booking endpointine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response'un status code'unun 200 oldugunu ve
    "firstname" degerinin "Ahmet" oldugunu test edin
 {
    "firstname" : "Ahmet",
    "lastname" : "Bulut", "
    totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" : {
                        "checkin" : "2021-06-01",
                        "checkout" : "2021-06-10"
                    },
    "additionalneeds" : "wi-fi"
}
     */
    @Test
    public void post01(){
        // 1- url ve requestBody hazirlama
        specHerOkuApp.pathParam("pp1","booking");
        JSONObject inner = new JSONObject();

        JSONObject reqBody = new JSONObject();

        inner.put("checkin","2021-06-01");
        inner.put("checkout","2021-06-10");

        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("otalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",inner);
        reqBody.put("additionalneeds","wi-fi");

        // 2- Expected hazirlama

        // 3- Response kaydetme
        Response response=given()
                                .spec(specHerOkuApp)
                                .contentType(ContentType.JSON)
                           .when()
                                .body(reqBody.toString())
                                .post("/{pp1}");

        // 4- Assertion
        response.then().assertThat()
                                   .statusCode(200)
                                   .body("booking.firstname", Matchers.equalTo("Ahmet"));
    }
    @Test
    public void query01(){
        /*
        https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query   parametrelerini yazarak “firstname” degeri “Eric” olan
        rezervasyon oldugunu test   edecek bir GET request gonderdigimizde,
        donen response’un status code’unun 200  oldugunu ve “Eric” ismine sahip
        en az bir booking oldugunu test edin
         */

        // 1- Url Hazirlama
        specHerOkuApp.pathParam("pp1","booking")
                     .queryParam("firstname","Eric");

        //2- ExpectedData hazirmala
        //3- Response kaydetme
        Response response=given().spec(specHerOkuApp).when().get("/{pp1}");
         response.prettyPrint();

        // 4- Assertion
        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(2));
    }
}
