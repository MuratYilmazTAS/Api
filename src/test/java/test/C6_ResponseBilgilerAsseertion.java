package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C6_ResponseBilgilerAsseertion {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile
        bir PUT request gonderdigimizde
        {
        “title”: “Ahmet”,
        “body”: “Merhaba”,
        “userId”: 10,
        “id”: 70
        }
        donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8, ve Server isimli Header’in degerinin cloudflare,
        ve status Line’in HTTP/1.1 200 OK
     */
    @Test
    public void put01(){

        // 1- Endpoint ve RequestBody hazirlama
        String url="https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody = new JSONObject();
        /*
        {
        “title”: “Ahmet”,
        “body”: “Merhaba”,
        “userId”: 10,
        “id”: 70
        }
         */
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        // 2- Expected Data hazirlama

        // 3- Response kaydetme
        // Not: Sorgumuzda eger bir request body gonderiyorsak Data'nin formatini belirtmemiz gerekir.
        // Bunu response objesindeki given() methodundan hemen sonra pre-condition olarak girmeliyiz.
        Response response = given()
                                  .contentType(ContentType.JSON)
                           .when()
                                  .body(reqBody.toString()).put(url);
        // Response yazdirma
        response.prettyPrint();
        // 4- Assertion islemi
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");

    }
}
