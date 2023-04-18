package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // find username field
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        //Verify the text “PRODUCTS”
        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // find username field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualNumber = number.size();
        int expectedNumber = 6;
        Assert.assertEquals("6 product not displayed", expectedNumber, actualNumber);

    }

    @After
    public void close() {
        driver.close();
    }
}