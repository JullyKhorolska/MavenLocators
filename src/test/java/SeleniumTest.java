import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    static WebDriver chromeDriver;
    static Login login;
    static  WebElement username, password, btnLogin;
    static ChromeOptions options = new ChromeOptions();
    @BeforeAll
    public static void init (){
        chromeDriver = new ChromeDriver();
    }
    @BeforeAll
    public static void initNameAndPassword (){
        login = new Login("tomsmith", "SuperSecretPassword!","helloWord!", "https://www.google.com/");
    }
    @BeforeEach
    public void openStartPage () throws InterruptedException {
        chromeDriver.get(login.getUrl());
        Thread.sleep(5000);
    }
    @BeforeEach
    public void getUserNameElement() {
        username = chromeDriver.findElement(By.xpath("//input[@name='username']"));
        username.clear();
    }
    @BeforeEach
    public void getPasswordElement() {
        password = chromeDriver.findElement(By.xpath("//input[@name='password']"));
        password.clear();
    }
    @BeforeEach
    public void getButtonElement(){
        btnLogin = chromeDriver.findElement(By.xpath("//button[@type='submit']"));
    }
    @Test
    @DisplayName("Success test")
    public void validPasswordOpenPage() throws InterruptedException {
        username.sendKeys(login.getUserName());
        password.sendKeys(login.getPassword());
        Thread.sleep(2000);
        btnLogin.click();
        Thread.sleep(5000);
        WebElement successPage = chromeDriver.findElement(By.xpath("//div[@class = 'flash success']"));
        Assertions.assertTrue(successPage.isDisplayed());
    }
    @Test
    @DisplayName("Error test")
    public void inValidPasswordOpenPage() throws InterruptedException {
        username.sendKeys(login.getUserName());
        password.sendKeys(login.getPasswordError());
        Thread.sleep(2000);
        btnLogin.click();
        Thread.sleep(5000);

        WebElement errorPage = chromeDriver.findElement(By.xpath("//div[@class = 'flash error']"));
        Assertions.assertTrue(errorPage.isDisplayed());
    }

    @AfterAll
    public static void closeWebDriver() {
        chromeDriver.quit();
    }

    @BeforeAll
    public static void constructorNull(){
         login = null;
    }
}

