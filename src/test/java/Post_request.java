import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class Post_request
{
    @Test
    public void post_Req()
    {

        RestAssured.baseURI="https://reqres.in/";
        RequestSpecification request_object= RestAssured.given();
        JSONObject parameters= new JSONObject();
        parameters.put("name","morpheus");
        parameters.put("job","leader");

        request_object.header("Content-Type","application/json");
        request_object.body(parameters.toJSONString());

         Response response = request_object.request(Method.POST,"/api/users");
         String Body= response.getBody().asString();
         System.out.println(Body);
        int status_code=  response.getStatusCode();
        Assert.assertEquals(status_code,201);
        String line= response.getStatusLine();
        System.out.println("Status line is"+line);

     }
}
