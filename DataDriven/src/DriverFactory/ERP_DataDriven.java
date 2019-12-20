package DriverFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonFunLibrary.ERP_Functions;
import excelClassUtils.ExcelFileUtil;

public class ERP_DataDriven {

ERP_Functions erp= new ERP_Functions();
	
	
	@BeforeMethod
	 
	public void LaunchApp() throws Exception{
		
		String Launch=erp.launchApp("http://webapp.qedge.com/login.php");
		System.out.println(Launch);
		String login=erp.Login("admin", "master");
		System.out.println(login);
		
	}
	
	@Test
	 
	public void supplier() throws Throwable{
		
	ExcelFileUtil xl= new ExcelFileUtil();	
		
	int rc=xl.rowCount("DumSheet");
	int cc=xl.colCount("DumSheet");
 
	System.out.println("no of rows::" +rc+ " " + "no of columns:: "+cc+" " );
		

	for(int i=1; i<=rc; i++)
	{
		String sname= xl.getData("DumSheet", i, 0);
		String address = xl.getData("DumSheet", i, 1);
		String city = xl.getData("DumSheet", i, 2);
		String country = xl.getData("DumSheet", i, 3);
		String cperson = xl.getData("DumSheet", i, 4);
		String pnumber = xl.getData("DumSheet", i, 5);
		String mail = xl.getData("DumSheet", i, 6);
		String mnumber = xl.getData("DumSheet", i, 7);
		String note = xl.getData("DumSheet", i, 8);
		   
	String results=erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
		
		xl.SetData("DumSheet", i, 9, "Pass");
	}
	
	}
	

	@AfterMethod
	public void logout() throws Exception
	{
		erp.logout();
	}
	
	

}
