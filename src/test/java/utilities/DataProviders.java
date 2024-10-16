package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//Dataprovider1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility eu = new ExcelUtility(path);
		int totalRows = eu.getRowCount("sheet1");
		int totalCells = eu.getCellCount("sheet1",1);
		
		String[][] loginData = new String[totalRows][totalCells];
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCells;j++) {
				loginData[i-1][j] = eu.getCelldata("sheet1", i, j); 
			}
		}
		
		return loginData;
	}

}
