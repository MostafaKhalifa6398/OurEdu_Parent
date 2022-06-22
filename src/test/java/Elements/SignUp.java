package Elements;

import StepDefinition.OpenOurEdu;
import com.github.javafaker.Faker;
import io.netty.handler.codec.http.multipart.FileUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class SignUp {
    int upperBound = 100000;
    Random rand = new Random();
    Faker fake = new Faker();
    SoftAssert soft = new SoftAssert();

    public SignUp(WebDriver driver)
    {
        OpenOurEdu.driver = driver;
    }
    public void clickOnSignUp() throws InterruptedException {
        Thread.sleep(1000);
        WebElement sign_up = OpenOurEdu.driver.findElement(By.xpath("/html/body/div/div/div/main/div/div/div/div/div/form/div/div[1]/div[3]/div/span/a"));
        sign_up.click();
        Thread.sleep(1000);
    }

    public void enterNationalId() throws InterruptedException {
        Thread.sleep(1000);
        WebElement nationalId = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/form/div/div[1]/fieldset/div/input"));
        nationalId.click();
        int id = rand.nextInt(upperBound);
        nationalId.sendKeys(Integer.toString(id));

        WebElement confirm = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/form/div/div[2]/button"));
        confirm.click();
        Thread.sleep(1000);
    }

    public void enterMobileNumber() throws InterruptedException {
        //enter mobile number
        Thread.sleep(1000);
        WebElement closeMessage = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/header/button"));
        closeMessage.click();

        Thread.sleep(1000);
        WebElement mobileNumber = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/form/div/div[1]/div[1]/input"));
        mobileNumber.click();
        Thread.sleep(1000);
        mobileNumber.sendKeys("+201002365101");

        WebElement confirm = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/form/div/div[2]/button"));
        confirm.click();
        Thread.sleep(1000);

        //enter verification code
        Thread.sleep(1000);
        WebElement verify = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/form/div/div[1]/fieldset/div/input"));
        verify.click();
        verify.sendKeys("123456");
        Thread.sleep(1000);
        
        WebElement submit = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/form/div/div[2]/button[1]"));
        submit.click();
        Thread.sleep(1000);


        //validation
        String URL = OpenOurEdu.driver.getCurrentUrl();
        soft.assertEquals(URL,"https://frontend.oetest.tech/registration/ar/user/register");
        Thread.sleep(2000);
    }

    public void enterParentData() throws InterruptedException {
        //send firstName
        WebElement firstName = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div/form/div[1]/div[1]/fieldset/div/div[1]/input"));
        firstName.click();
        String first_Name = fake.name().firstName();
        firstName.sendKeys(first_Name);
        Thread.sleep(2000);


        //send secondName
        WebElement secondName = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div/form/div[1]/div[2]/fieldset/div/div[1]/input"));
        secondName.click();
        String second_Name = fake.name().lastName();
        secondName.sendKeys(second_Name);
        Thread.sleep(2000);

        //select image
        WebElement image = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div/form/div[1]/div[3]/div/div[1]/fieldset/div/div[1]/input"));
        Thread.sleep(1000);
        image.sendKeys("F:\\OurEdu_Parent\\src\\main\\resources\\avatar.jpg");
        Thread.sleep(1000);

        //send email
        WebElement email = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div/form/div[1]/div[4]/fieldset/div/div[1]/input"));
        email.click();
        email.sendKeys(first_Name + "." +second_Name + "@ouredu.net");
        Thread.sleep(2000);

        //send location
        WebElement locationIcon = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div/form/div[1]/div[8]/fieldset/div/i"));
        locationIcon.click();
        Thread.sleep(2000);

        WebElement locationField = OpenOurEdu.driver.findElement(By.cssSelector("#locationMapModal___BV_modal_body_ > div > div.modalBody > div > div.vue-map > div > div > div:nth-child(2) > div:nth-child(2)"));
        locationField.click();
        Thread.sleep(1000);

        WebElement save = OpenOurEdu.driver.findElement(By.cssSelector("#locationMapModal___BV_modal_body_ > div > div.modalFooter > button"));
        save.click();
        Thread.sleep(1000);

        //send password
        WebElement password = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div/form/div[1]/div[9]/fieldset/div/div[1]/input"));
        password.click();
        String pass = "12345678";
        password.sendKeys(pass);
        Thread.sleep(1000);

        WebElement confirmPassword = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div/form/div[1]/div[10]/fieldset/div/div[1]/input"));
        password.click();
        confirmPassword.sendKeys(pass);
        Thread.sleep(1000);

        //agree conditions and /create account
        WebElement conditions = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div/form/div[1]/div[11]/fieldset/div/div[1]/div/label/div"));
        conditions.click();
        Thread.sleep(2000);

        WebElement createAccountButton = OpenOurEdu.driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div/form/div[2]/button"));
        createAccountButton.click();
        Thread.sleep(1000);
    }


}