package QualiTest.Twitterproject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import resources.Base;
import resources.Payload;
import resources.resources;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.path.xml.XmlPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

	public class Blockuser extends Base {

	    String ConsumerKey="7C1las31LFZ1sqh8VOHkhAI8M";
	    String ConsumerSecret="i8cjjdZIbJwcWhDy0oATBfeOztJ7CNAK82YQcUVMfdg0NKOE7p";
	    String Token="1366702057093099523-vcxMlPU6tkUOgH6VU80AyhVZXFtqKY";
	    String TokenSecret="o7RsPSdjhEUC9jbXU1HgY40uiWewgJE5NdD3obQc5XpRy";
	    
	     private static Logger log = LogManager.getLogger(Twitter1.class.getName());
	    
	@Test
	public void block_user() throws IOException {
	    RestAssured.baseURI="https://api.twitter.com/1.1/blocks/";
	    Response res=given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
	    queryParam("screen_name","SeemaChikkamma1").when().post("create.json").then().extract().response();
	    String response=res.asString();
	    JsonPath jp=new JsonPath(response);
	    String name=jp.get("name");
	    log.info(name);
	}
	}


