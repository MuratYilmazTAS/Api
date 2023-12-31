package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C11_JSONArrayKullanimi {

    /*
     {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */

    @Test
    public void JSONArray (){
        JSONObject ceptel = new JSONObject();
        ceptel.put("type","iPhone");
        ceptel.put("number","0123-4567-8888");

        JSONObject evtel = new JSONObject();
        evtel.put("type","home");
        evtel.put("type","0123-4567-8910");

        // Burada verilen phoneNumbers ogesi Array oldugu icin icindeki objeleri koyacagimiz
        // JSONArray olusturduk
        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.put(0,ceptel);
        phoneNumbers.put(1,evtel);

        JSONObject adres=new JSONObject();
        adres.put("streetAddress","naist street");
        adres.put("city","Nara");
        adres.put("postalCode","630-0192");

        JSONObject kisiBilgisi=new JSONObject();
        kisiBilgisi.put("firstName","John");
        kisiBilgisi.put("lastName","Doe");
        kisiBilgisi.put("age","26");
        kisiBilgisi.put("address",adres);
        kisiBilgisi.put("phoneNumbers",phoneNumbers);
        System.out.println("kisiBilgisi"+kisiBilgisi);

    }
}
