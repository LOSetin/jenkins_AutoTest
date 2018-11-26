package test.object;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VacationOperation {
	WebDriver driver;
	WebDriverWait wait;
	//*[@id="form1"]/div[3]/div/div[1]/ul/li[7]/a
	@FindBy(xpath ="//*[@id='form1']/div[3]/div/div[1]/ul/li[7]/a")
	WebElement ClickLeave;
	
	/*@FindBy(xpath ="//*[@id=\'f1']/table/tbody/tr[3]/td[2]/div/div/div/input")
	WebElement ApprovalOfficer;*/
	@FindBy(xpath ="//*[@id=\'f1']/table/tbody/tr[5]/td[2]/div/div/dl/dd[9]")
	WebElement CC1;
	@FindBy(xpath ="//*[@id=\'f1']/table/tbody/tr[4]/td[2]/div/div/div/input")
	WebElement CC2;
	@FindBy(xpath ="//*[@id=\'f1']/table/tbody/tr[6]/td[2]/div/input")
	WebElement CCMail;
	/*@FindBy(xpath ="//*[@id=\'f1']/table/tbody/tr[6]/td[2]/div/input")
	WebElement StartDate;
	@FindBy(xpath ="//*[@id=\'layui-laydate2']/div/div[2]/table/tbody/tr[2]/td[4]")
	WebElement EndDate;*/
	@FindBy(xpath ="//*[@id=\'f1']/table/tbody/tr[10]/td[2]/div/textarea")
	WebElement Reason;
	@FindBy(xpath ="//*[@id=\'f1']/table/tbody/tr[13]/td/div/input")
	WebElement Submit;
	
	public VacationOperation(WebDriver driver){
		this.driver=driver;
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	public void submit(){
		Submit.click();
	}
	public void ClickLeave(){
	
		ClickLeave.click();
	}
	public void LeaveCategory(String Category){
		driver.switchTo().frame("demoAdmin");
		
		if(Category.equals("Graduation Leave")){
			driver.findElement(ByXPath.xpath("//*[@id=\'qq2']/div")).click();
		}
		if(Category.equals("Personal leave")){
			driver.findElement(ByXPath.xpath("//*[@id=\'f1']/table/tbody/tr[2]/td[2]/div/div[2]")).click();
		}
		if(Category.equals("Sick leave")){
			driver.findElement(ByXPath.xpath("//*[@id=\'f1']/table/tbody/tr[2]/td[2]/div/div[3]")).click();
		}
		if(Category.equals("Marriage holiday")){
			driver.findElement(ByXPath.xpath("//*[@id=\'qq1']/div[1]")).click();
		}
		if(Category.equals("Maternity leave")){
			driver.findElement(ByXPath.xpath("//*[@id=\'qq1']/div[2]")).click();
		}
	
	}
	public void ApprovalOfficer(String approvalOfficer){
		
		//*[@id="f1"]/table/tbody/tr[3]/td[2]/div/div/dl
		
		driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[3]/td[2]/div/div/div/input")).click();
		String content = driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[3]/td[2]/div/div/dl")).getText();
		String content2 = content.replace("\n", ",");
		String[] content3 = content2.split(",");
		System.out.println(approvalOfficer);
		System.out.println(content3[1]);
		for(int i=1;i<=content3.length-1;i++){
			if(content3[i].contains(approvalOfficer)){
				int a = i+1;
				System.out.println("傻逼");
				driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[3]/td[2]/div/div/dl/dd["+a+"]")).click();
			}
		}
		
	}
	public void CC1(String cc1){
		driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[4]/td[2]/div/div/div/input")).click();
		String content = driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[4]/td[2]/div/div/dl")).getText();
		String content2 = content.replace("\n", ",");
		String[] content3 = content2.split(",");
		System.out.println(cc1);
		System.out.println(content3[1]);
		for(int i=1;i<=content3.length-1;i++){
			if(content3[i].contains(cc1)){
				int a = i+1;
				System.out.println("傻逼2");
				driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[4]/td[2]/div/div/dl/dd["+a+"]")).click();
			}
		}
	}
	public void CC2(String cc2){
		driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[5]/td[2]/div/div/div/input")).click();
		String content = driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[5]/td[2]/div/div/dl")).getText();
		String content2 = content.replace("\n", ",");
		String[] content3 = content2.split(",");
		System.out.println(cc2);
		System.out.println(content3[1]);
		for(int i=1;i<=content3.length-1;i++){
			if(content3[i].contains(cc2)){
				int a = i+1;
				System.out.println("傻逼3");
				driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[5]/td[2]/div/div/dl/dd["+a+"]")).click();
			}
		}
	}
	public void CCMail(String ccMail){
		
		CCMail.sendKeys(ccMail);
	}
	public void StartDate(String startDate) throws Exception{
		driver.findElement(By.xpath("//*[@id=\'date2']")).click();
		String a1 = driver.findElement(By.xpath("//*[@id=\'layui-laydate2']/div/div[2]/table/tbody/tr[1]")).getAttribute("innerHTML");
		String[] b1 = a1.split("</td>");
		String a2 = driver.findElement(By.xpath("//*[@id=\'layui-laydate2']/div/div[2]/table/tbody/tr[2]")).getAttribute("innerHTML");
		String[] b2 = a2.split("</td>");
		String a3 = driver.findElement(By.xpath("//*[@id=\'layui-laydate2']/div/div[2]/table/tbody/tr[3]")).getAttribute("innerHTML");
		String[] b3 = a3.split("</td>");
		String a4 = driver.findElement(By.xpath("//*[@id=\'layui-laydate2']/div/div[2]/table/tbody/tr[4]")).getAttribute("innerHTML");
		String[] b4 = a4.split("</td>");
		String a5 = driver.findElement(By.xpath("//*[@id=\'layui-laydate2']/div/div[2]/table/tbody/tr[5]")).getAttribute("innerHTML");
		String[] b5 = a5.split("</td>");
		String a6 = driver.findElement(By.xpath("//*[@id=\'layui-laydate2']/div/div[2]/table/tbody/tr[6]")).getAttribute("innerHTML");
		String[] b6 = a6.split("</td>");
		String[][] ab = new String[6][7];
		for(int i=0;i<7;i++){
			ab[0][i]=b1[i];
		}
		for(int i=0;i<7;i++){
			ab[1][i]=b2[i];
		}
		for(int i=0;i<7;i++){
			ab[2][i]=b3[i];
		}
		for(int i=0;i<7;i++){
			ab[3][i]=b4[i];
		}
		for(int i=0;i<7;i++){
			ab[4][i]=b5[i];
		}
		for(int i=0;i<7;i++){
			ab[5][i]=b6[i];
		}
		String startDate1 = startDate.replace("-0", "-");
		String startDate2 = "\""+startDate1+"\"";
		String date="lay-ymd="+startDate2+"";
		System.out.println(date);
		String s= ab[1][4];
		System.out.println(s);
		Boolean z = s.contains(date);
		System.out.println(z);
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				if(ab[i][j].contains(date)){
					System.out.println("傻逼4");
					int c=i+1,d=j+1;
					driver.findElement(By.xpath("//*[@id=\'layui-laydate2']/div/div[2]/table/tbody/tr["+c+"]/td["+d+"]")).click();
					
					Thread.sleep(3000);
				
				}
			}
		}
	}
	public void EndDate(String endDate) throws Exception{
		driver.findElement(By.xpath("//*[@id=\'date3']")).click();
		String a1 = driver.findElement(By.xpath("//*[@id=\'layui-laydate3']/div/div[2]/table/tbody/tr[1]")).getAttribute("innerHTML");
		String[] b1 = a1.split("</td>");
		String a2 = driver.findElement(By.xpath("//*[@id=\'layui-laydate3']/div/div[2]/table/tbody/tr[2]")).getAttribute("innerHTML");
		String[] b2 = a2.split("</td>");
		String a3 = driver.findElement(By.xpath("//*[@id=\'layui-laydate3']/div/div[2]/table/tbody/tr[3]")).getAttribute("innerHTML");
		String[] b3 = a3.split("</td>");
		String a4 = driver.findElement(By.xpath("//*[@id=\'layui-laydate3']/div/div[2]/table/tbody/tr[4]")).getAttribute("innerHTML");
		String[] b4 = a4.split("</td>");
		String a5 = driver.findElement(By.xpath("//*[@id=\'layui-laydate3']/div/div[2]/table/tbody/tr[5]")).getAttribute("innerHTML");
		String[] b5 = a5.split("</td>");
		String a6 = driver.findElement(By.xpath("//*[@id=\'layui-laydate3']/div/div[2]/table/tbody/tr[6]")).getAttribute("innerHTML");
		String[] b6 = a6.split("</td>");
		String[][] ab = new String[6][7];
		for(int i=0;i<7;i++){
			ab[0][i]=b1[i];
		}
		for(int i=0;i<7;i++){
			ab[1][i]=b2[i];
		}
		for(int i=0;i<7;i++){
			ab[2][i]=b3[i];
		}
		for(int i=0;i<7;i++){
			ab[3][i]=b4[i];
		}
		for(int i=0;i<7;i++){
			ab[4][i]=b5[i];
		}
		for(int i=0;i<7;i++){
			ab[5][i]=b6[i];
		}
		String startDate1 = endDate.replace("-0", "-");
		String startDate2 = "\""+startDate1+"\"";
		String date="lay-ymd="+startDate2+"";
		System.out.println(date);
		String s= ab[1][4];
		System.out.println(s);
		Boolean z = s.contains(date);
		System.out.println(z);
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				if(ab[i][j].contains(date)){
					System.out.println("傻逼4");
					int c=i+1,d=j+1;
					driver.findElement(By.xpath("//*[@id=\'layui-laydate3']/div/div[2]/table/tbody/tr["+c+"]/td["+d+"]")).click();
					
					Thread.sleep(3000);
				
				}
			}
		}
	}
	
	public void Reason(String reason){
	     if(reason.equals("Reply")){
	    	 driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[11]/td/div/input[1]")).click();
	     }
	     if(reason.equals("Sick")){
	    	 driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[11]/td/div/input[2]")).click();
	     }
	     if(reason.equals("Tourism")){
	    	 driver.findElement(By.xpath("//*[@id=\'f1']/table/tbody/tr[11]/td/div/input[3]")).click();
	     }
	     if(!reason.equals("Reply") && !reason.equals("Sick") && !reason.equals("Tourism")){
	    	 Reason.sendKeys(reason);
	     }
	}
	public void Operation() throws Exception{
		ClickLeave();
		Thread.sleep(1000);
	}
	public void Submit() throws Exception{
		submit();
		Thread.sleep(1000);
	}
	public void VacationOperationImpl(String Category,String approvalOfficer,String cc1,String cc2,String ccMail,String startDate,String endDate,String reason) throws Exception{
		
		LeaveCategory(Category);
		Thread.sleep(2000);
		ApprovalOfficer(approvalOfficer);
		Thread.sleep(2000);
		CC1(cc1);
		Thread.sleep(2000);
		CC2(cc2);
		Thread.sleep(2000);
		CCMail(ccMail);
		Thread.sleep(2000);
		StartDate(startDate);
		Thread.sleep(3000);
		EndDate(endDate);
		Thread.sleep(3000);
		Reason(reason);
		Thread.sleep(1000);
		Submit();
		Thread.sleep(1000);
	}
}
