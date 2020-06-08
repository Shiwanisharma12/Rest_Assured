import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class Delete_req
{
        @Test
        public void update()
        {
            RestAssured.baseURI = "https://reqres.in/";
            RequestSpecification request_object = RestAssured.given();
            JSONObject parameters = new JSONObject();

            request_object.body(parameters.toJSONString());

            Response response = request_object.request(Method.DELETE, "/api/users/2");
            String Body = response.getBody().asString();
            System.out.println(Body);

            int status_code = response.getStatusCode();
            Assert.assertEquals(status_code, 204);
            String line = response.getStatusLine();
            System.out.println("Status line is" + line);


        }
    }


