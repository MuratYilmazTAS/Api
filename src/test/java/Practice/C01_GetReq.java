package Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetReq {
    @Test
    public void test01(){

        /*
        url : https://regres.in/api/users/
        get request

        cevabini yazdirin
         */



        // api'dan donen cevap response objesi icine kaydolur
        Response response=given().when().get("https://reqres.in/api/users/");

        // api'den donen cevbi yazdiralim
        response.prettyPrint();


    }
}
