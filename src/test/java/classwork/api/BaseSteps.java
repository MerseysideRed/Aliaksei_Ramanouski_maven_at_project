package classwork.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseSteps {
    public static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri("http://178.124.206.46:8001/app/ws/")
            //.setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static User getUser(String name) {

        Data data = null;
        try {
            data = new ObjectMapper()
                    .readValue(new File("src/test/resources/users.json"), Data.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data.data.stream()
                .filter(user -> user.username.equalsIgnoreCase(name))
                .findFirst().get();
    }
}
