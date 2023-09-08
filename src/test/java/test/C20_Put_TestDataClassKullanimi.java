package test;

import baseUrl.baseURL_JSONHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import testdatas.JSONPlaceData;

import static io.restassured.RestAssured.given;

public class C20_Put_TestDataClassKullanimi extends baseURL_JSONHolder {
    /*
    C19_Put_TestDataClassKullanimi
          https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
          PUT request yolladigimizda donen response’in
          status kodunun 200, content type’inin “application/json; charset=utf-8”,
          Connection header degerinin “keep-alive”
          ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
          Request Body
          {
          "title": "Ahmet",
          "body": "Merhaba",
          "userId": 10,
          "id": 70
          }
          Expected Data :
          {
          "title": "Ahmet",
          "body": "Merhaba",
          "userId": 10,
          "id": 70
          }
     */
    @Test
    public void testdata02(){

        // 1- url ve request body hazirlama
        specJSONHolder.pathParams("pp1","posts","pp2",70);
        JSONPlaceData jsonPlaceData=new JSONPlaceData();

        JSONObject reqData=jsonPlaceData.requestBodyOlusturJSON();

        // 2- expected data olusturma
        JSONObject expData=jsonPlaceData.requestBodyOlusturJSON();

        // 3- Response Kaydetme
        Response response=given()
                                .spec(specJSONHolder)
                                .contentType(ContentType.JSON)
                .when()
                                .body(reqData.toString())
                                .put("/{pp1}/{pp2}");

        // 4- Assertion
        JsonPath resJP=response.jsonPath();

        Assert.assertEquals(jsonPlaceData.basariliStatsuCode,response.getStatusCode());
        Assert.assertEquals(jsonPlaceData.contentType,response.getContentType());
        Assert.assertEquals(jsonPlaceData.header,response.getHeader("Connection"));
        Assert.assertEquals(expData.get("userId"),resJP.get("userId"));
        Assert.assertEquals(expData.get("title"),resJP.get("title"));
        Assert.assertEquals(expData.get("body"),resJP.get("body"));
        Assert.assertEquals(expData.get("id"),resJP.get("id"));


    }
}
