package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name="LoginData")
	public String [][] getData() throws IOException {
		String path=".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from testData
		ExcelUtility xlUtils=new ExcelUtility(path); //creating an object for XLUtility
		int totalrows=xlUtils.getRowCount("sheet1");
		int totalcols=xlUtils.getCellCount("sheet1", 1);
		String loginData[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				loginData[i-1][j]=xlUtils.getCellData("sheet1", i, j);
			}
		}
		return loginData;//returning two dimension array
		
	}
}
