package org.example.pagess;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LginPage {
    private WebDriver driver;

    @FindBy(name="email")
    private WebElement usernameInput;

    @FindBy(name="password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='button-input newd']")
    private WebElement loginButton;


    public LginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Constructor to initialize the WebDriver

    public void Login(String Name , String Pass) {
        usernameInput.sendKeys(Name);
        passwordInput.sendKeys(Pass);
        loginButton.click();
    }



}

