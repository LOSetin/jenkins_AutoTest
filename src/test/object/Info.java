package test.object;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
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


@SuppressWarnings("unused")
public class Info {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath ="//*[@id='form1']/div[3]/div/div[1]/ul/li[7]/a")
	WebElement ClickLeave;
	//*[@id="mainContent_tbRealName"]
	@FindBy(xpath ="//*[@id='mainContent_tbRealName']")
	WebElement name;
	//*[@id="mainContent_tbPhone"]
	//*[@id="mainContent_tbPhone"]
	@FindBy(xpath ="//*[@id='mainContent_tbPhone']")
	WebElement phone;
	//*[@id="mainContent_ddlSex"]
	//@FindBy(xpath ="//*[@id='mainContent_ddlSex']/option[2]")
	//WebElement sex;
	//*[@id="mainContent_tbQQ"]
	@FindBy(xpath ="//*[@id='mainContent_tbQQ']")
	WebElement qq;
	//*[@id="mainContent_tbWeiXin"]
	@FindBy(xpath ="//*[@id='mainContent_tbWeiXin']")
	WebElement echart;
	//*[@id="mainContent_btnConfirm"]
	@FindBy(xpath ="//*[@id='mainContent_btnConfirm']")
	WebElement submit;
	
	public Info(WebDriver driver){
		this.driver=driver;
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void submit(){
		submit.click();
	}
	public void ClickLeave(){
	
		ClickLeave.click();
	}
	
	public void inputUsername(String name1){
		name.clear();
		name.sendKeys(name1);
	}
	
	public void inputphone(String phone1){
		phone.clear();
		phone.sendKeys(phone1);
	}
	
	/*public void inputsex(String sex1){
		Select select = new Select(driver.findElement(By.id("mainContent_ddlSex")));
		select .selectByValue(“2”)
	}*/
	
	public void inputqq(String qq1){
		qq.clear();
		qq.sendKeys(qq1);
	}
	
	public void inputechart(String echart1){
		echart.clear();
		echart.sendKeys(echart1);
	}
	
	public void Submit() throws Exception{
		submit();
		Thread.sleep(1000);
	}
	
	public void infotest(String name1,String echart1,String qq1,String phone1) throws InterruptedException{
		
		inputUsername(name1);
		Thread.sleep(1000);
		inputphone(phone1);
		//Thread.sleep(2000);
		//inputsex(sex1);
		//Thread.sleep(2000);
		inputqq(qq1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		inputechart(echart1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		submit();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
