import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

        //WebElement radioMale = driver.findElement(By.id("gender-radio-1"));
        //radioMale.click();

        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(By.id("gender-radio-1"))).click().perform();

        //System.out.println(radio.get(1).getText());

        WebElement numberInput = driver.findElement(By.id("userNumber"));
        numberInput.sendKeys("1919252536");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
/*
        //calendario
        WebElement birtInput = driver.findElement(By.id("dateOfBirthInput"));
        birtInput.click();
        birtInput.clear();
        birtInput.sendKeys("25 Oct 2021");
        birtInput.sendKeys(Keys.TAB);
*/

        /*
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("dateOfBirthInput")));
        actions.click();
        actions.build().perform();
        WebElement input = driver.findElement(By.id("dateOfBirthInput"));
        input.clear();
        input.sendKeys("09112013");
        input.sendKeys(Keys.TAB);
*/

        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys("Mi asunto");

        act.moveToElement(driver.findElement(By.id("hobbies-checkbox-1"))).click().perform();
        act.moveToElement(driver.findElement(By.id("hobbies-checkbox-3"))).click().perform();

        WebElement adressInput = driver.findElement(By.id("currentAddress"));
        adressInput.sendKeys("Mi dirección");

        js.executeScript("window.scrollBy(0,1000)");

        act.moveToElement(driver.findElement(By.id("submit"))).click().perform();

        String realFinalMessage;
        String expectedFinalMessage = "Thanks for submitting the form";
        js.executeScript("window.scrollBy(0,2000)");

        WebElement lblFinalMessage = driver.findElement(By.id("example-modal-sizes-title-lg"));
        WebDriverWait wait = new WebDriverWait(driver,5); //tiempo a esperar
        wait.until(ExpectedConditions.textToBePresentInElement(lblFinalMessage,"Thanks for submitting the form"));

        realFinalMessage = lblFinalMessage.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(realFinalMessage,expectedFinalMessage);//correcto

    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }

}
