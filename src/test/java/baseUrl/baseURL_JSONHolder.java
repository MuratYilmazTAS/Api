package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.runner.Request;
import org.testng.annotations.BeforeTest;

public class baseURL_JSONHolder {

    // BaseURL olustururken RequestSpecification interface'i uzerinden bir specobje olusturduk


   protected RequestSpecification specJSONHolder;
   @Before
    public void setUp(){
       specJSONHolder = new RequestSpecBuilder()
                                           .setBaseUri("https://jsonplaceholder.typicode.com")
                                           .build();

   }
}
