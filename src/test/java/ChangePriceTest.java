import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.example.pagess.ChangePricePage;
import org.example.pagess.LginPage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
public class ChangePriceTest {
    private WebDriver driver;
    private LginPage loginPage;
    private ChangePricePage ChangePrice;

    @BeforeTest
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://transmission-dev.azurewebsites.net/login");
    }

    @DataProvider(name = "dp")
    public String[] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/main/resources/LoginData.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject userLoginObject = (JSONObject) obj;
        JSONArray userLoginArray = (JSONArray) userLoginObject.get("userLogin");
        String arr[] = new String[userLoginArray.size()];
        for (int i = 0 ; i < userLoginArray.size(); i++)
        {
            JSONObject users = (JSONObject) userLoginArray.get(i);
            String user = (String) users.get("email");
            String password = (String) users.get("pass");
            arr[i] = user+ "," +password;
        }
        return arr;
    }

    @Test(priority = 1 , dataProvider = "dp")
    public void login( String data ) throws InterruptedException {
        //String newData = (String) data;
        String user[] = data.split(",");
        loginPage = new LginPage(driver);
        loginPage.Login(user[0] , user[1]);

    }

//    @Test (priority = 2)
//    public void NewCatalog() throws InterruptedException {
//        ChangePrice = new ChangePricePage(driver);
//        ChangePrice.Addnewcatalog();
////        driver.findElement(By.className("catalog-icon")).click();
////        Thread.sleep(5000);
////        driver.findElement(By.xpath("//*[@id=\"tab2\"]/div[2]/div[1]/div[1]/a")).click();
////        driver.findElement(By.id("add_name_en")).sendKeys("Yousef");
////        WebElement ArabicName =   driver.findElement(By.id("add_name_ar"));
////        Actions act = new Actions(driver);
////        act.sendKeys(ArabicName,"يوسف احمد").build().perform();
////        WebElement DoneButton =   driver.findElement(By.xpath("//*[@id=\"popup2-branch\"]/div/div[2]/input"));
////        DoneButton.click();
//    }
//    @Test (priority = 3)
//    public void Editnewcatalog() throws InterruptedException{
//        ChangePrice = new ChangePricePage(driver);
//        ChangePrice.editCategory();
//    }
    @Test (priority = 4)
    public void Deletenewcatalog() throws InterruptedException{
        ChangePrice = new ChangePricePage(driver);
        ChangePrice.deleteCategory();
    }




}

//    @Test (priority = 1,dataProvider = "dp")
//    public void loginTest(String data) throws InterruptedException {
////d     data.
//        loginPage = new LginPage(driver);
//        loginPage.Login("testbotitb2@dist.com" , "123456");
//    }
//}







//
//
//
//
//
//
//
//
//
//
//
//
//    @DataProvider(name = "TestData")
//    public static Object[][]Data (){
//        return new Object[][]{
//                {"400,500,600"},
//        };
//    }
//
//    @Test(priority = 2)
//    public void Searchoptions() throws InterruptedException{
//        ChangePrice = new ChangePricePage(driver);
//        ChangePrice.SearchOption("Backpack Olive");
//    }
//    @Test  (priority = 3)
//    public void ChangeTest() throws InterruptedException {
//        ChangePrice = new ChangePricePage(driver);
//        ChangePrice.ChangePricePram();
//    }
//    @Test(priority = 4,dataProvider = "TestData")
//    public void EditProductandsave(String DataProviderPrice) throws InterruptedException {
//        ChangePrice = new ChangePricePage(driver);
//        ChangePrice.EditProduct(DataProviderPrice);
//    }
////    @AfterTest
////    public void tearDown() {
////        driver.quit();
////    }
//}

