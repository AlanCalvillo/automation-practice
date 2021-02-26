package api;

import api.mocks.Courses;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTests {

    @Test
    public void testWithMocks(){

        JsonPath js = new JsonPath(Courses.mockCourses());

        int count = js.getInt("courses.size()");

        System.out.println(count);

        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        String firstCourse = js.getString("courses[0].title");
        System.out.println(firstCourse);

       for(int i = 0; i < count; i++){
           String courseTitle = js.getString("courses["+i+"].title");
           System.out.println(courseTitle);
           if(courseTitle.equalsIgnoreCase("RPA")){
               System.out.println(js.getString("courses["+i+"].copies"));
           }
           //System.out.println(js.getString("courses["+i+"].price"));
       }
    }
    @Test
    public void testSum(){
        JsonPath js = new JsonPath(Courses.mockCourses());
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        int totalPrice = 0;
        for(int i = 0; i < js.getInt("courses.size()"); i++){
            totalPrice += js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
        }
        Assert.assertEquals(totalAmount,totalPrice);
    }

    public static class BooksTest {
    }
}

