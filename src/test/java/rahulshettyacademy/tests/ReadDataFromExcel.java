package rahulshettyacademy.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import rahulshetyacademy.TestComponents.BaseTest;

public class ReadDataFromExcel extends BaseTest {

	public static void main(String[] args) throws IOException {
	
			Object[][] data=getDataFromExcel();
	}		
	
		// TODO Auto-generated method stub
	public static Object[][] getDataFromExcel() throws IOException{
			FileInputStream fis = new FileInputStream("D:\\eclipse-java-2020-09-R-win32-x86_64\\Automation\\SeleniumFrameworkDesign\\datasetLogin.xlsx");
			XSSFWorkbook wb;
			XSSFSheet sheet;
			XSSFRow row;
			XSSFCell cell = null;
			
			 wb= new XSSFWorkbook(fis);
			sheet=wb.getSheetAt(0);
			int rowCount=sheet.getPhysicalNumberOfRows();
			row=sheet.getRow(0); // created to get cell number in next line
			int colcount = row.getLastCellNum(); //no direct method to find number of cells, hence we create row and then row.metod
			Object data[][]= new Object[rowCount][colcount];
			for(int i = 1; i<=rowCount; i++) {
				row=sheet.getRow(i); 
				for(int j = 0; j<colcount; j++) {
					 data[i][j]=row.getCell(j).getStringCellValue();
					
					System.out.println(row.getCell(j).getStringCellValue());
					
				}
			}
			return (Object[][])data;
			
		}//method
	}//


