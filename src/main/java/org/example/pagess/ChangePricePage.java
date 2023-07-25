package org.example.pagess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
public class ChangePricePage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/ul/li[1]/a")
    private WebElement catalogButton;
    @FindBy(className = "tab-label-2")
    private WebElement ItemButton;
    @FindBy(className = "text-search")
    private WebElement Searchbar;
    @FindBy(className = "search-button")
    private WebElement SearchIcon;
    @FindBy(className = "edit-action")
    private WebElement EditButton;
    @FindBy(name = "mainPrice")
    private WebElement PriceField;
    @FindBy(className = "exit-button")
    private WebElement SaveButton;

    @FindBy (xpath = "//*[@id=\"tab2\"]/div[2]/div[1]/div[1]")
    private WebElement addnewcatalog;

    @FindBy (id = "add_name_en")
    private WebElement addenname;

    @FindBy (id = "add_name_ar")
    private  WebElement addarname;

    @FindBy (xpath = "//*[@id=\"popup2-branch\"]/div/div[2]/input")
    private WebElement DoneButton;
    @FindBy (xpath = "//*[@id=\"itemContainerother\"]/tbody/tr[7]/td[3]/div[1]/div[1]/div[1]/a")
    private WebElement EditnewCatalog;
    @FindBy (xpath = "//table[@id=\"itemContainerother\"]//tbody//tr[2]//td[3]//a")
    private  WebElement editCategoryBtn;
    @FindBy(xpath = "//*[@id=\"popup1-branch\"]/div/div[2]/div/div/input[1]")
    private  WebElement yesButton;

    public ChangePricePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SearchOption(String SearchItem) throws InterruptedException {
        Searchbar.sendKeys(SearchItem);
        SearchIcon.click();
    }

    public void ChangePricePram() throws InterruptedException {
        catalogButton.click();
        Thread.sleep(5000);
        ItemButton.click();
    }

    public void EditProduct(String Price) throws InterruptedException {
        EditButton.click();
        PriceField.clear();
        PriceField.sendKeys(Price);
        Thread.sleep(6000);
        SaveButton.click();

    }

    public void Addnewcatalog () throws InterruptedException {
        catalogButton.click();
        Thread.sleep(8000);
        addnewcatalog.click();
        addenname.click();
        addenname.sendKeys("Yousef");
        WebElement ArabicName =  addarname;
        Actions act = new Actions(driver);
        act.sendKeys(ArabicName,"يوسف احمد").build().perform();
        DoneButton.click();
    }
//    public  void EditNewCatalog() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Thread.sleep(5000);
//
//        catalogButton.click();
//        List <WebElement> categoryTableElement =driver.findElements(By.xpath("//table[@id=\"itemContainerother\"]//tbody//tr"));
//        //*[@id="itemContainerother"]/tbody/tr[1]
//        String coulmnFirst ="//*[@id=\"itemContainerother\"]/tbody/tr[";
//        String coulmnLast ="]//td//div//div//a//h2";
//        String coulmns;
//        String tableCoulmns;
//        boolean findCtategory=false;
//
//        for (int i = 1; i < categoryTableElement.size(); i++) {
//            coulmns = coulmnFirst + i + coulmnLast;
//
//            tableCoulmns = driver.findElement(By.xpath(coulmns)).getText();
//
//            System.out.println(tableCoulmns);
//            if (tableCoulmns.equals("Yousef")) {
//                findCtategory = true;
//                editCategoryBtn.click();
//
//
//                break;
//
//
//            }
//        }
//}
public  void editCategory() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    Thread.sleep(5000);
    catalogButton.click();
    List <WebElement> categoryTableElement =driver.findElements(By.xpath("//table[@id=\"itemContainerother\"]//tbody//tr"));
    String coulmnFirst ="//table[@id=\"itemContainerother\"]//tbody//tr[";
    String coulmnLast ="]//td//div//div//a//h2";
    String coulmns;
    String editCategroyfirst="//table[@id=\"itemContainerother\"]//tbody//tr[";
    String editCategroylast ="]//td[3]//a";
    String editCategories ;
    WebElement selectedediticon ;
    String tableCoulmns;
    boolean findCtategory=false;

    for (int i = 1; i < categoryTableElement.size(); i++) {
        coulmns = coulmnFirst + i + coulmnLast;
        editCategories = editCategroyfirst + i + editCategroylast;

        tableCoulmns = driver.findElement(By.xpath(coulmns)).getText();
        selectedediticon = driver.findElement(By.xpath(editCategories));
        System.out.println(tableCoulmns);
        if (tableCoulmns.equals("Yousef")) {
            findCtategory = true;
            selectedediticon.click();
            break;
        }
    }



}

public  void deleteCategory()throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    Thread.sleep(5000);
    catalogButton.click();
    List <WebElement> categoryTableElement =driver.findElements(By.xpath("//table[@id=\"itemContainerother\"]//tbody//tr"));
    String coulmnFirst ="//table[@id=\"itemContainerother\"]//tbody//tr[";
    String coulmnLast ="]//td//div//div//a//h2";
    String coulmns;
    String deleteCategroyfirst="//table[@id=\"itemContainerother\"]//tbody//tr[";
    String deleteCategroylast ="]/td[3]/div[1]/div[1]/div[2]";
    //*[@id="itemContainerother"]/tbody/tr[1]/td[3]/div[1]/div[1]/div[2]
    String deteteCategories ;
    WebElement selectedDeletedicon ;
    String tableCoulmns;
    boolean findCtategory=false;
//*[@id="itemContainerother"]/tbody/tr[1]/td[3]/div[1]/div[1]/div[2]
    for (int i = 1; i < categoryTableElement.size(); i++) {
        coulmns = coulmnFirst + i + coulmnLast;
        deteteCategories = deleteCategroyfirst + i + deleteCategroylast;

        tableCoulmns = driver.findElement(By.xpath(coulmns)).getText();
        selectedDeletedicon = driver.findElement(By.xpath(deteteCategories));
        System.out.println(tableCoulmns);
        if (tableCoulmns.equals("Yousef Ahmed Test")) {
            findCtategory = true;
            selectedDeletedicon.click();
            yesButton.click();
            break;
        }
    }
}

}
