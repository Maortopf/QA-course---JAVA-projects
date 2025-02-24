package Final_selenium_exam;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Pizza_Page {

    WebDriver driver;

    public Pizza_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }



    // Finding WebElements ///////////

    @FindBy(xpath = "//span[@class='ginput_total ginput_total_5']")
    private WebElement Price_element;

    @FindBy(xpath = "//option[@value='Delivery|3']")
    private WebElement DeliveryOption_element;

    @FindBy(xpath = "//option[@value='Pick Up|0']")
    private WebElement PickUpOption_element;

    @FindBy(xpath = "//input[@id='input_5_22_3']")
    private WebElement FirstName_Field;

    @FindBy(xpath = "//input[@id='input_5_22_6']")
    private WebElement LastName_Field;

    @FindBy(tagName = "textarea")
    private WebElement TextArea_field;

    @FindBy(id = "gform_submit_button_5")
    private WebElement SubmitButton;

    @FindBy(xpath = "//*[@id='field_5_19']/iframe")
    private WebElement Iframe_identifyer;




    // Methods or "Steps" ////////////
    @Step("get and return Starting price")
    public double GetFirstPrice(){
        if(Double.parseDouble(Price_element.getText().replace("$","")) > 7.50){
            PickUpOption_element.click();
        }
        return Double.parseDouble(Price_element.getText().replace("$",""));
    }


    @Step("check that delivery is choosed and return updated price")
    public double GetUpdatedPrice(){
        if (Double.parseDouble(Price_element.getText().replace("$","")) <= 7.50){
            DeliveryOption_element.click();
        }
    return  Double.parseDouble(Price_element.getText().replace("$","").replace(" ",""));
    }


    @Step("takes only the couponCode")
    public String Get_Coupon_Code(){
        driver.switchTo().frame(Iframe_identifyer);
        String Coupon_Number = driver.findElement(By.id("coupon_Number")).getText();
        driver.switchTo().defaultContent();
        return Coupon_Number;
    }


    @Step("make an order and return the text in the PopUp")
    public String GetOrderWithCoupon(String Firstname, String Lastname){
        FirstName_Field.sendKeys(Firstname);
        LastName_Field.sendKeys(Lastname);
    //inFrame
        String coupon = Get_Coupon_Code();
    //ExitFrame
        TextArea_field.sendKeys(coupon);
        SubmitButton.click();
    //inAlert
        String OrderText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
    //ExitAlert
            return OrderText;
    }





}
