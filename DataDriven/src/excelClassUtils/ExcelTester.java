package excelClassUtils;

public class ExcelTester {

	public static void main(String[] args) throws Throwable {

		ExcelFileUtil efu = new ExcelFileUtil();

		int totalRows = efu.rowCount("DumSheet");
		System.out.println(totalRows);

		int totalcolCount = efu.colCount("DumSheet");
		System.out.println(totalcolCount);

		String celldata = efu.getData("DumSheet", 1, 6);
		System.out.println(celldata);

		efu.SetData("DumSheet", 5, 6, "not executed ");

	}

}
	