package Api_Testing;

import org.json.JSONObject;
import org.junit.Test;

public class C5_InnerJsonObject {

    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
    “firstname”:“Jim”,
    “additionalneeds”:“Breakfast”,
    “bookingdates”:{
                   “checkin”:“2018-01-01”,
                   “checkout”:“2019-01-01”
                   },
    “totalprice”:111,
    “depositpaid”:true,
    “lastname”:“Brown”
    }
     */

    @Test
    public void innerJson(){

        // Icice Json objeleri iceren bir body'de once icerideki JSON objesi olusturulur
        JSONObject innerObje=new JSONObject();
        innerObje.put("checkin","2018-01-01");
        innerObje.put("checkout","2019-01-01");

        // Ana JSON objemizi olustururken key,vlaue degerleri yazilir
        // Icinde inner olan key'in Value'su innerObje olacaktir
        JSONObject outerObje=new JSONObject();
        outerObje.put("firstname","Jim");
        outerObje.put("additionalneeds","Breakfast");
        outerObje.put("bookingdates",innerObje);
        outerObje.put("totalprice",111);
        outerObje.put("depositpaid",true);
        outerObje.put("lastname","Brown");
        System.out.println("Icice Json Objesi = " + outerObje);
    }
}
