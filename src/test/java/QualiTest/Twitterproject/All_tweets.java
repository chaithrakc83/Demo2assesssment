package QualiTest.Twitterproject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;

public class All_tweets {
	
	
	
	 public Properties prop;
	    @Test    
	    public void Tweet() throws IOException
	    {
	        prop=new Properties();
	        FileInputStream fis=new FileInputStream("C:\\javascripts\\RESTAssuredTestProject\\src\\main\\java\\QualiTest\\RESTAssuredTestProject\\data.properties");
	        prop.load(fis);
	        RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
	        Response res=given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
	        //queryParam("count","1").
	        when().get("/home_timeline.json").then().extract().response();
	        
	        String response=res.asString();
	        System.out.println(response);
	        JsonPath js=new JsonPath(response);
	        //String id= js.get("id").toString();
	        //System.out.println(id);
	        String text= js.get("text").toString();
	        System.out.println(text);
    
	        	        
	    }
	}
	 


