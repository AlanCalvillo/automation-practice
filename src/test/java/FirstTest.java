import files.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hamcrest.MatcherAssert;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.DEFAULT)
public class FirstTest {
    static String placeId;
    @Before
    public void setUp(){
        baseURI = "https://rahulshettyacademy.com";
        basePath = "/maps";
        requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
                                                        .addQueryParam("key","qaclick123")
                                                        .build();
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
                                                            .build();
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        //requestSpecification = new RequestSpecBuilder()
    }

    @Test
    public void placeProcess(){
        //given - all input details
        //when = submit the api
        // then - validate the response
        String newAddress = "Summer walk, Africa";

        String respPost = given().body(Payload.addPlace())
                                .when().post("/api/place/add/json")
                                .then().assertThat().body("scope",equalTo("APP")).header("Server",equalTo("Apache/2.4.18 (Ubuntu)"))
                                .extract().response().asString();

        JsonPath path = new JsonPath(respPost);
        this.placeId = path.getString("place_id");

       JsonPath respPut =  given().body(Payload.updatePlace(this.placeId,newAddress))
                                .when().put("/api/place/update/json")
                                .then().assertThat().body("msg",equalTo("Address successfully updated"))
                                .extract().response().jsonPath();

       JsonPath respGet = given().queryParam("place_id",placeId)
                                .when().get("/api/place/get/json")
                                .then().assertThat().body("address",equalTo(newAddress))
                                .extract().response().jsonPath();
        Assert.assertEquals(respGet.get("address"),"Summer walk, Africa");

       String respDel =  given().body(Payload.deletePlace(placeId))
                                .when().get("/api/place/delete/json")
                                .then().assertThat().body("status",equalTo("OK"))
                                .extract().response().asString();
    }

}
