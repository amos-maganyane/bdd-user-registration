package steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import utils.ConfigManager;

import java.time.Duration;

public class RegistrationPageSteps {

    private static final String REGISTRATION_PAGE_URL =
            ConfigManager.getProperty("frontend.registration.url");

    WebDriver driver;
    WebDriverWait wait;

    @Given("I open the registration page")
    public void i_open_the_registration_page() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1280,800");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get(REGISTRATION_PAGE_URL+"/index.html");
    }

    @When("I enter {string} and {string}")
    public void i_enter_credentials(String name, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I submit the form")
    public void i_submit_the_form() {
        driver.findElement(By.tagName("form")).submit();
    }

    @Then("I should see a success alert")
    public void i_should_see_a_success_alert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        assert alert.getText().contains("Success");
        alert.accept();
        driver.quit();
    }
}
