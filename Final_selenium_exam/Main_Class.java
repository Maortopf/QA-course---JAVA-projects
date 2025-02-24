package Final_selenium_exam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Main_Class {

    WebDriver driver;
    Pizza_Page Pizza;


    final String Base_Url = "https://atidcollege.co.il/Xamples/pizza";
    final String Firstname = "Maor";
    final String Lastname = "Topf";
    final double Expected_Starting_price = 7.5;
    final double Expected_Updated_price = 10.5;

    @BeforeClass
    public void Start_Session(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Page initiating
        Pizza = new Pizza_Page(driver);
        driver.get(Base_Url);
    }
    @AfterClass
    public void End_Session(){
        driver.quit();
    }



    @Test(description = "verify the starting price")
    public void Test01_VerifyIf_Starting_PriceCorrect(){
        Assert.assertEquals(Expected_Starting_price, Pizza.GetFirstPrice(), "expected was: "+Expected_Starting_price+" | but actual was: "+Pizza.GetFirstPrice());
    }

    @Test(description = "verify if the delivery price is added to the starting price correctly")
    public void Test02_VerifyIf_Updated_PriceCorrect(){
        Assert.assertEquals(Expected_Updated_price, Pizza.GetUpdatedPrice(), "expected was: "+Expected_Updated_price+" | but actual was: "+Pizza.GetUpdatedPrice());
    }

    @Test(description = "will make an order and check the Alert's popup String")
    public void Test03_VerifyPopUpText_AfterOrder(){
        String FinalAlertText = Pizza.GetOrderWithCoupon(Firstname,Lastname);
        Assert.assertEquals(FinalAlertText, Firstname+" "+Lastname+" "+Pizza.Get_Coupon_Code(), "test finds: "+FinalAlertText+" --- and the String built is: "+ Firstname+" "+Lastname+" "+Pizza.Get_Coupon_Code());
    }
}
