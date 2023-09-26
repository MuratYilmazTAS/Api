package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReCap01 {


    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz
     */

    /*
    1- Endpoint (url) girilecek
    2- Expected data hazirlanacak
    3- Actual data hazirlanacak
    4- Assertion islemi
     */

    @Test
    public void get01(){
        String url = "https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);
       // response.prettyPrint();
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Content Type: "+response.getContentType());
        System.out.println("Header: "+response.getHeader("Server"));
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Response Time: "+response.getTime());

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .log().all()
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");


    }


}
