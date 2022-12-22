package steps;

import configuretions.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageobject.CertificateVerificationObject;

public class MyStepdefs extends BaseClass {
    static CertificateVerificationObject certificateVerificationObject = PageFactory.initElements(driver, CertificateVerificationObject.class);

    @When("Open {string} page")
    public void openPage(String url) {
        driver.get(url);
    }

    @And("Enter random data of certificate")
    public void enterRandomDataOfCertificate() {
        certificateVerificationObject.EnterRandomNumberInField();
    }

    @And("Click on Button Verify")
    public void clickOnButtonVerify() {
        certificateVerificationObject.ClickOnButton();
    }

    @Then("Find error massage about wrong certificate")
    public void findErrorMassageAboutWrongCertificate() {
        certificateVerificationObject.isPresentError();
    }
}
