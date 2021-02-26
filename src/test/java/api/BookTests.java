package api;

import api.files.PayloadBook;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.*;

public class BookTests {

    @BeforeTest
    public void setup(){
        baseURI = "http://216.10.245.166";
        basePath = "/Library";
        requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
                //.addQueryParam("key","qaclick123")
                .build();
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
                .build();
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        //requestSpecification = new RequestSpecBuilder()
    }
    @Test
    public void addBook(){
        JsonPath path = given().body(PayloadBook.addBook())
                            .when().post("/Addbook.php")
                            .then().extract().response().jsonPath();
    }
}
