package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path =System.getProperty("user.dir")+"//testData//userdata.xlsx";
	
		int row= XLUtils.getRowCount(path, "Sheet1");
		int col=  XLUtils.getCellCount(path, "Sheet1", 1);
		
		String apiData[][]= new String[row][col];
		for(int i=1; i<=row;i++)
		{
			for(int j=0;j<col;j++)
			{
				apiData[i-1][j] =XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return apiData;
	}
	
	@DataProvider(name="username")
	public String[] getusername() throws IOException
	{
		String path =System.getProperty("user.dir")+"//testData//userdata.xlsx";
		XLUtils xl= new XLUtils(path);
		int row= XLUtils.getRowCount(path, "Sheet1");
		
		
		String usernameData[]= new String[row];
		for(int i=1; i<=row;i++)
		{
				usernameData[i-1] =XLUtils.getCellData(path, "Sheet1", i,1);
		}
	
		return usernameData;
	}

}
