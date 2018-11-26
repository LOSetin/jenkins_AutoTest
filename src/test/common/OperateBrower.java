package test.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
/**
 * Created by y8733 on 2018/10/22.
 */
public class OperateBrower {

    static WebDriver driver;

    public static WebDriver OpenChrome() throws IOException {
        //selenium鐗堟湰鏇存柊鎹簡涓�绉嶅啓娉�
//        File firefoxFile=new File("D:\\soft\\MozillaFirefox\\firefox.exe");
//        FirefoxBinary binary=new FirefoxBinary(firefoxFile);
//        driver =new FirefoxDriver(binary,null);
        String driverPath="C:\\Users\\28770\\Desktop\\re\\JTPHRTest\\src\\test\\resources\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        return driver;
    }
    public static void OpenURL(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
//    Thread.sleep(2000);
    }
    public static void CloseBrower(){
        driver.close();
    }

    public static void main(String[] args) throws Exception {
//    File directory = new File("");// 鍙傛暟涓虹┖
//    String courseFile = directory.getCanonicalPath();
//    System.out.println(courseFile);
        OperateBrower.OpenChrome();
        OperateBrower.OpenURL("http://localhost:8080/JTP_Leave/");
        //OperateBrower.CloseBrower();

    }

}
