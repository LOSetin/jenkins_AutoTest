package test.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.common.OperateBrower;
import test.common.Total;
import test.object.Info;
import test.object.VacationOperation;
import test.object.login;

public class Test_case {
	WebDriver driver;
	login loginPage;
	VacationOperation vacationOperation;
	Info Info;
	String loginpath="src//test//resources//data//login.xlsx";
	//String LeaveInfo="src//test//resources//data//LeaveInfo.xlsx";
	String info="src//test//resources//data//Info.xlsx";
  @BeforeClass
  public void setUp() throws Exception{
	  driver = OperateBrower.OpenChrome();
	  OperateBrower.OpenURL(Total.LoginData(1, 3, loginpath));
	 
  }
  @AfterClass
  public void tearDown(){
	  OperateBrower.CloseBrower();
  }
  @Test
  public void testlogin() throws Exception{
	  loginPage= new login(driver);
	  System.out.println("��ʼ");
	  for(int i=1;i<Total.RowData_length(loginpath);i++){
          loginPage.login(Total.LoginData(i,0,loginpath),Total.LoginData(i,1,loginpath),Total.LoginData(i,2,loginpath));
      }
	  Thread.sleep(2000);
   /* vacationOperation = new VacationOperation(driver);
	  vacationOperation.ClickLeave();
	  for(int i=1;i<Total.RowData_length(LeaveInfo);i++){
		  vacationOperation.VacationOperationImpl(Total.LoginData(i, 0, LeaveInfo),Total.LoginData(i, 1, LeaveInfo),Total.LoginData(i, 2, LeaveInfo),Total.LoginData(i, 3, LeaveInfo),Total.LoginData(i, 4, LeaveInfo),Total.LoginData(i, 5, LeaveInfo).toString(),Total.LoginData(i, 6, LeaveInfo),Total.LoginData(i, 7, LeaveInfo));
		  System.out.println(Total.LoginData(i, 0, LeaveInfo));
	  }*/
	  Info = new Info(driver);
	  Info.ClickLeave();
	  for(int i=1;i<Total.RowData_length(info);i++){
		  Info.infotest(Total.LoginData(i, 0, info),Total.LoginData(i, 1, info),Total.LoginData(i, 2, info),Total.LoginData(i, 3, info));
		  System.out.println(Total.LoginData(i, 0, info));
	  } 
	    }
  
}
