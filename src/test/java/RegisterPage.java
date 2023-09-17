import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RegisterPage {


    WebDriver driver;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;

    }

    public void fillFirstName(String firstName) {
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    public void fillEmail(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    public void chooseGender() {
        driver.findElement(By.cssSelector("[for = 'gender-radio-2']")).click();
    }

    public void fillNumber(String number) {
        driver.findElement(By.cssSelector("[placeholder = 'Mobile Number']")).sendKeys(number);
    }

    public void chooseDate(String month, String year, String day) {
        driver.findElement(By.id("dateOfBirthInput")).click();
        Select monthOfBirthDropdown = new Select(driver.findElement(By.cssSelector(".react-datepicker__month-select")));
        monthOfBirthDropdown.selectByValue(month);
        Select yearOfBirthDropdown = new Select(driver.findElement(By.cssSelector(".react-datepicker__year-select")));
        yearOfBirthDropdown.selectByValue(year);
        driver.findElement(By.cssSelector(".react-datepicker__day--" + day)).click();
    }

    public void fillSubject(String subject) {
        driver.findElement(By.id("subjectsInput")).sendKeys(subject);
    }

    public void chooseHobbies() {
        driver.findElement(By.cssSelector("[for = 'hobbies-checkbox-3']")).click();
    }

    public void uploadImage(String path) {
        driver.findElement(By.id("uploadPicture")).sendKeys(path);
    }

    public void fillAddress(String address) {
        driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    public void chooseState(String state) {
        driver.findElement(By.id("react-select-3-input")).sendKeys(state, Keys.ENTER);
    }

    public void chooseCity(String city) {
        driver.findElement(By.id("react-select-4-input")).sendKeys(city, Keys.ENTER);
    }

    public void submitForm(JavascriptExecutor js) {
        WebElement submitButton = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitButton);
    }

    public void verifyForm(String trueMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        String message = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        assertEquals(trueMessage, message, "messages don't match");

        // вывод данных из таблицы
        List<WebElement> elements = driver.findElements(By.cssSelector("tr td:last-child"));
        for (WebElement e : elements) {
            System.out.println(e.getText());
        }
    }


}
