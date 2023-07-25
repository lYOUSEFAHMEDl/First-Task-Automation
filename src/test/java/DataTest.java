import org.example.pagess.LginPage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
public class DataTest {
    private WebDriver driver;
    private LginPage loginPage;
    @BeforeTest
    public void setUp()
    {
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
}
//        driver.findElement(By.name("email")).sendKeys(user[0]); //Email
//        driver.findElement(By.name("password")).sendKeys(user[1]); //Password
//        driver.findElement(By.xpath("//input[@class='button-input newd']")).click();
        //logout();










//    @Test (priority = 2)
//    public void logout()
//    {
//        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[2]/a")).click();
//    }

/*

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
*/


