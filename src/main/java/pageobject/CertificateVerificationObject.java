package pageobject;


import configuretions.BaseClass;

import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.time.Duration;
import java.util.Random;

public class CertificateVerificationObject extends BaseClass {
    Random rnd = new Random();
    @FindBy(xpath = "//input[@name=\"certificate\"]")
    WebElement searchField;
    @FindBy(xpath = "//button[@type = 'submit' and contains(@class, \"certificate-check_submit\")]")
    WebElement button;

    @FindBy(xpath = "//*[@class=\"certificate-check_message\"]")
    WebElement errorMassage;

    public void EnterRandomNumberInField() {
        this.searchField.sendKeys(Integer.toString(rnd.nextInt(9999999)));
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ClickOnButton() {
        this.button.click();
    }

    public void isPresentError() {
        try {
            Thread.sleep(1700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
      //  assertTrue("Надпись \"Сертифікат не знайдено\" не присутствует", this.errorMassage.isDisplayed());

        assertEquals("Сертифікат не знайдено",errorMassage.getAttribute("innerText"));
        System.out.println(errorMassage.getAttribute("innerText"));
    }

    public void closeBrowser() {
        try {
            Thread.sleep(2300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
