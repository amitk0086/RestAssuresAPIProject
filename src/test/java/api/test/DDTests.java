package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;



import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUsers(String id, String UserName, String fname, String lname, String email, String pwd, String ph)
	{
		
		User payload =new User();
		
		payload.setId(Integer.parseInt(id));
		payload.setUsername(UserName);
		payload.setFirstName(fname);
		payload.setLastName(lname);
		payload.setEmail(email);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		Response response= UserEndPoints.createUser(payload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

	
	@Test(priority=2, dataProvider="username", dataProviderClass=DataProviders.class)
	public void deleteuserbyName(String userName)
	{
		Response response= UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
		
}
