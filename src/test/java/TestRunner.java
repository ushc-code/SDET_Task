import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestRunner {
    public static WebDriver driver = new ChromeDriver();
    private static final String LINK = "https://demoqa.com/automation-practice-form";
    public static final String PATH = "C:\\Users\\irush\\IdeaProjects\\SDET_Task\\img\\img.png";
    public static final String MESSAGE = "Thanks for submitting the form";
    JavascriptExecutor js = (JavascriptExecutor) driver;
    RegisterPage registerPage = new RegisterPage(driver);


    @BeforeClass
    public void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(LINK);

    }

    @Test
    public void register() {
        registerPage.fillFirstName(UserData.FIRSTNAME.getValue());
        registerPage.fillLastName(UserData.LASTNAME.getValue());
        registerPage.fillEmail(UserData.EMAIL.getValue());
        registerPage.chooseGender();
        registerPage.fillNumber(UserData.MOBIlE.getValue());
        registerPage.chooseDate(UserData.MONTHBIRTH.getValue(), UserData.YEARBIRTH.getValue(), UserData.DAYBIRTH.getValue());
        registerPage.fillSubject(UserData.SUBJECT.getValue());
        registerPage.chooseHobbies();
        registerPage.uploadImage(PATH);
        registerPage.fillAddress(UserData.ADDRESS.getValue());
        registerPage.chooseState(UserData.STATE.getValue());
        registerPage.chooseCity(UserData.CITY.getValue());
        registerPage.submitForm(js);

    }
    @Test
    public void verify() throws InterruptedException {
        registerPage.verifyForm(MESSAGE);
        Thread.sleep(5000);
    }
    @AfterClass
    public void close(){
        driver.close();
    }
}
