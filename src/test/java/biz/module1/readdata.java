package biz.module1;

import org.testng.annotations.Test;

import biz.utility.ExcelFileReader;
@Test
public class readdata {
  public void read()
  {
	  ExcelFileReader data=new ExcelFileReader("./src/test/java/files/test.xlsx");
	  int rows=data.totalRow("Sheet1");
	  System.out.println(rows);
	  int cols=data.totalColumn("Sheet1");
	  System.out.println(cols);
	  String celdata=data.getData("Sheet1", 2, 1);
	  System.out.println(celdata);
	  data.setData("Sheet1" ,5,1, "testing");
	  data.setData("Sheet1" ,6,1, "testing");
	  data.setData("Sheet1" ,8,1, "testing");
	  data.setData("Sheet1" ,20,5, "testing");
  }
  
}
