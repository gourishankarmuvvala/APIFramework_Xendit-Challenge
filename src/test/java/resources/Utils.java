package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public Properties 			prop =	new Properties();
	public FileInputStream 		        fis;
	public JsonPath   			js;
	public static RequestSpecification 	req;
	public String 				resp;
	public PrintStream 			log;

	public RequestSpecification requestSpecification_Update(String qr_code_id_Value) throws IOException
	{
		
		if(req==null)
		{
			log   =	new PrintStream(new FileOutputStream("logging.txt"));
			
		 	req   =	new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
							.addParameter("qr_code_id", qr_code_id_Value)'
							.header("Authorization", "Bearer " + token);
							.addFilter(RequestLoggingFilter.logRequestTo(log))
							.addFilter(ResponseLoggingFilter.logResponseTo(log))
							.setContentType(ContentType.JSON).build();

		 return req;
		}
		return req;		
		
	}
	
		
	public static String getGlobalValue(String key) throws IOException
	{
		fis =new FileInputStream(System.getProperty("user.dir")+"\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);			
	}
		
	public String getJsonPath(Response response,String key)
	{
		resp = response.asString();
		js   = new JsonPath(resp);
		
		return ( js.get(key).toString() );
	}
}
