package QualiTest.Twitterproject;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.Base;
import resources.resources;

public class Get_trends extends Base {
	
	String INDIA="23424848";
	String US="23424977";
	String UK="23424975";
	String ISRAEL="23424852";
	Integer statusCode=200;
	
Properties prop=new Properties();
    
    private static Logger log=LogManager.getLogger(Twitter.class.getName());

    @Test(dataProvider="getData")
    public void API_test(String location) throws IOException {
        
        // Getting latest tweet   	
    	
		FileInputStream fis=new FileInputStream("C:\\javascripts\\RESTAssuredTestProject\\src\\main\\java\\QualiTest\\RESTAssuredTestProject\\data.properties");
		prop.load(fis);  	
        RestAssured.baseURI=prop.getProperty("TWITTERHOST");
        Response res=given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
        queryParam("id","location").
        when().get("place.json").
        then().assertThat().statusCode(200).extract().response();
        
        String response=res.asString();
        JsonPath js=new JsonPath(response);
        List<String>abc=js.get("trends.name");
        listToElement(abc);
    }
    
    @DataProvider
    public String[] getData() {
    	String[] abcd= {INDIA,US,UK,ISRAEL};
    	return abcd;
    }
    
    @AfterTest
    public void print() {
    	if(statusCode==200)  {
    		log.info("TRENDS IN US:");
    		log.info("TRENDS IN UK:");
    		log.info("TRENDS IN Israel:");
    		
    	}
    }
}
