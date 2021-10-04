import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static utilities.RandomEmail.randomEmail;

public class TestForm1 extends Base{

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void test() throws InterruptedException {
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("Abel");
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Guerra");
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys(randomEmail());

        //List<WebElement> radio = driver.findElements(By.name("gender"));
        //radio.get(1).click();
        WebElement radioMale = driver.findElement(By.id("gender-radio-1"));
        radioMale.click();
        //System.out.println(radio.get(1).getText());

        WebElement numberInput = driver.findElement(By.id("userNumber"));
        numberInput.sendKeys("1919252536");
        WebElement birtInput = driver.findElement(By.id("dateOfBirthInput"));
        birtInput.clear();
        birtInput.sendKeys("25 Nov 2021");

        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys("Mi asunto");

     //   WebElement hobbyBtn1 = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
     //   hobbyBtn1.click();

        WebElement adressInput = driver.findElement(By.id("currentAddress"));
        adressInput.sendKeys("Mi dirección");
        Thread.sleep(4000);
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }

}
