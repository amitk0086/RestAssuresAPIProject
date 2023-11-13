package api.test;

import static org.hamcrest.CoreMatchers.both;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;

import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User payload;
	
	public Logger logger;
	@BeforeClass
	public void setData()
	{
		faker= new Faker();
		payload =new User();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setPassword(faker.internet().password());
		payload.setEmail(faker.internet().emailAddress());
		payload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//log
		logger= LogManager.getLogger(this.getClass());
		
	}

	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("*****************Posting the User ***********");
		Response response=UserEndPoints.createUser(payload);
		response.then().log().all();
	    Assert.assertEquals(response.getStatusCode(), 200); 	
	}
	
	@Test(priority=2)
	public void testGetUser()
	{
		Response response=UserEndPoints.readUser(this.payload.getUsername());
		response.then().log().all();
	    Assert.assertEquals(response.getStatusCode(), 200); 	
	}
	
	@Test(priority=3)
	public void testUpdateUser()
	{
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		
		Response response=UserEndPoints.updateUser(this.payload.getUsername(),payload);
		response.then().log().body();
	    Assert.assertEquals(response.getStatusCode(), 200); 	
	}
	
	@Test(priority=4)
	public void testdeleteUser()
	{
		Response response=UserEndPoints.deleteUser(this.payload.getUsername());
		response.then().log().body();
	    Assert.assertEquals(response.getStatusCode(), 200); 	
	}
}
