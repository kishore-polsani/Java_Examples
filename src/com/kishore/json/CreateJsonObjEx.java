package com.kishore.json;

import javax.json.*;
import java.io.StringWriter;

public class CreateJsonObjEx {

    public static void main(String[] a) {

        JsonObjectBuilder envJsonBuilder = Json.createObjectBuilder();
        envJsonBuilder.add("username", "Kishore");
        envJsonBuilder.add("authenticationMethod", "email");

        // create Json array with only values
        /*JsonArrayBuilder carbonCopiesBuilder = Json.createArrayBuilder();
        carbonCopiesBuilder.add("Rakesh");
        carbonCopiesBuilder.add("John");
        
        JsonObjectBuilder builder = Json.createObjectBuilder()
                .add("success", "")
                .add("deletedSize", "");        
        JsonArray arr = carbonCopiesBuilder.build();
        // the array got created, add it to the json as a child element
        envJsonBuilder.add("direct_contacts", arr);*/

        // create an array of key-value pairs
        JsonArrayBuilder carbonCopiesBuilder = Json.createArrayBuilder();
        // create each key-value pair as seperate object and add it to the array
        carbonCopiesBuilder.add(Json.createObjectBuilder().add("email", "Kishore@gmail.com")
            .add("name", "Kishore")
            .add("recipientId", "1")
            .add("routingOrder", "1").build());

        JsonArray carbonCopiesArr = carbonCopiesBuilder.build();
        // add contacts array object
        envJsonBuilder.add("carbonCopies", carbonCopiesArr);

        JsonObject empObj = envJsonBuilder.build();
        // here we are writing to String writer. 
        // if you want you can write it to a file as well
        StringWriter strWtr = new StringWriter();
        JsonWriter jsonWtr = Json.createWriter(strWtr);
        jsonWtr.writeObject(empObj);
        jsonWtr.close();

        System.out.println(strWtr.toString());
    }
}