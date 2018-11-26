package test.object;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {

	WebDriver driver;
	
	WebDriverWait wait;
	//*[@id="tbUserName"]
	
	@FindBy(xpath ="//*[@id='tbUserName']")
	WebElement userName;
	//*[@id="tbPwd"]
	@FindBy(xpath ="//*[@id='tbPwd']")
	WebElement passWord;
	//*[@id="tbCode"]
	@FindBy(xpath ="//*[@id='tbCode']")
	WebElement logCode;
	//*[@id="btnLogin"]
	@FindBy(xpath ="//*[@id='btnLogin']")
	WebElement loginButton;
	
	
	
	public login(WebDriver driver){
		this.driver=driver;
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void inputUsername(String username){
		userName.clear();
		userName.sendKeys(username);
	}
	public void inputPassword(String password){
		passWord.clear();
		passWord.sendKeys(password);
		
	}
	public void inputLogCode(String logcode){
		logCode.clear();
		logCode.sendKeys(logcode);
	}
	public void clickloginButton(){
		loginButton.click();
	}
	 
	
	public void login(String name,String pwd,String verification) throws InterruptedException{
		inputUsername(name);
		Thread.sleep(2000);
		inputPassword(pwd);
		inputLogCode(verification);
		Thread.sleep(2000);
		clickloginButton();
		Thread.sleep(2000);
		
	}
	
}
