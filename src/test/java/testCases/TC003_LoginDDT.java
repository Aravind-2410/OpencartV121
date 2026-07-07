package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
Data is valid -- Login Success -- Test Passed -> logout
Data is valid -- Login Failed -- Test fail

Data is Invalid -- Login Success -- Test fail -> logout
Data is Invalid -- Login failed -- Test Passed 
*/ 

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class,groups="datagriven")
	//getting data provider from diff class
	public void Verify_loginDDT(String email,String pwd, String exp)
	{

		logger.info("*** Started TC003_LoginDDT ****");
		
		try
		{
	//Homepage 

		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
			
	// Login Page
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);
		lp.setPassword(pwd);
		
		lp.clickLogin();
			
	//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
	
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
		
		else
		 {
			Assert.assertTrue(false);
		 }
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
		
		else
		 {
			Assert.assertTrue(true);
		 }

		}
	} 
		catch(Exception e)
		{

			Assert.fail();
		}
		
		logger.info("*** Finished TC003_LoginDDT ****");
		
	
	}
}
