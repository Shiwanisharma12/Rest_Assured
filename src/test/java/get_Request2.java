import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class get_Request2 {

    @Test
    public void get_Req()
    {
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification type= RestAssured.given();
        Response response=type.request(Method.GET,"/api/users?page=2");
        String body= response.getBody().asString();
        System.out.println(body);
        System.out.println("Status code is : ");
        int code=response.getStatusCode();
        System.out.println("status code is:"+code);
        Assert.assertEquals(code,200);
        String Statusline= response.getStatusLine();
        System.out.println(Statusline);

    }
}
