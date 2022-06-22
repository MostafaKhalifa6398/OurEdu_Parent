package StepDefinition;

import Elements.SignUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.testng.asserts.SoftAssert;

public class ParentSignup {
    SignUp signup = new SignUp(OpenOurEdu.driver);
    SoftAssert soft = new SoftAssert();

    @When("user click on sign up as a parent")
    public void clickSignUp() throws InterruptedException {
        signup.clickOnSignUp();
    }

    @And("user enter his national id for check")
    public void enterValidNationalId() throws InterruptedException {
        signup.enterNationalId();
    }

    @And("user enter his mobile number and verification code")
    public void enterMobile() throws InterruptedException {
        signup.enterMobileNumber();
    }

    @And("user enter his data")
    public void userData() throws InterruptedException {
        signup.enterParentData();
    }

    @And("user can sign up successfully")
    public void signupSuccessfully() throws InterruptedException {
        String URLHome = "https://frontend.oetest.tech/registration/ar";
        soft.assertEquals(URLHome, "https://frontend.oetest.tech/registration/ar");
        Thread.sleep(3000);
    }
}