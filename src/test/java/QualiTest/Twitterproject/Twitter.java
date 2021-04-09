package QualiTest.Twitterproject;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.resources;
import io.restassured.path.xml.XmlPath;

public class Twitter {
	

    private static Logger log=LogManager.getLogger(Twitter.class.getName());
	Properties prop=new Properties();
    
    @Test
    public void getTweet() throws IOException {
        
        // Getting latest tweet   	
    	
		FileInputStream fis=new FileInputStream("C:\\javascripts\\RESTAssuredTestProject\\src\\main\\java\\QualiTest\\RESTAssuredTestProject\\data.properties");
		prop.load(fis);  	
        RestAssured.baseURI=prop.getProperty("TWITTERHOST");
        Response res=given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
       // Response res=given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
        queryParam("count","1").
        when().get(resources.getTweetResource()).then().extract().response();      
        String responseString=res.asString();
        log.info(responseString);      
        JsonPath js=new JsonPath(responseString);
        String id=js.get("id").toString();
        log.info(id);
       // System.out.println(id);
        String text=js.get("text").toString();
        log.info(text);
       // System.out.println(text);
         
    }
}
    
    /*
    @Test
    public void createTweet() {
        
        // creating or posting tweet
        
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
        Response res=given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
        queryParam("status","This is my tweet for automation").
        when().post("/update.json").then().extract().response();
        
        String responseString=res.asString();
        System.out.println(responseString);
        
        JsonPath js=new JsonPath(responseString);
        String id=js.get("id").toString();
        System.out.println(id);
        String text=js.get("text").toString();
        System.out.println(text);
         
    }
    
    */
    /*@Test    
    public void deleteTweet() {
        
        // deleting tweet
        
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
        Response res=given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).queryParam("status","This is my new tweet for automation duplicate").
        
        when().post(resources.createTweetResource()).then().extract().response();
        
        String responseString=res.asString();
        log.info(responseString);
       // System.out.println(responseString);
        JsonPath js=new JsonPath(responseString);
        String id=js.get("id").toString();
        log.info(id);
       // System.out.println(id);
        String text=js.get("text").toString();
        log.info(text);
       // System.out.println(text);
        
        given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
        when().post(resources.deleteTweetResource1()+id+resources.deleteTweetResource2()).then().assertThat().statusCode(200);
         
    }
}*/
 