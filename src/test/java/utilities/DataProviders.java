package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	// Data Provider 1
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx"; // taking xl file from testdata
		
		ExcelUtility xlutil=new ExcelUtility(path); // creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("sheet1");
		int totalcols=xlutil.getCellCount("sheet1", 1);
		
		String logindata[][]=new String[totalrows][3]; // created for two dimension array which can store 
		
		for(int i=1;i<=totalrows;i++) //1 //read data from xl storing in two dimensional array
		{
			for(int j=0;j<3;j++) //0 i is for rows & j is for columns
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j); //1,0
			}
		}
	
	return logindata; // returning two dimensional array
	}
	
	// Data Provider 2
	
	// Data Provider 3
  
	// Data Provider 4

}


