package com.netcall.step_definitions;

import com.github.javafaker.Faker;
import com.netcall.pages.LoanPage;
import com.netcall.utilities.BrowserUtils;
import com.netcall.utilities.ConfigurationReader;
import com.netcall.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class loan_step_def {
    WebDriver driver = Driver.get();
    LoanPage loanPage = new LoanPage();
    Faker fk = new Faker();


    @Given("User navigate the loan page")
    public void user_navigate_the_loan_page() {

        driver.get(ConfigurationReader.get("url"));

    }

    @Then("User enter the borrow of amount")
    public void user_enter_the_borrow_of_amount() {

        Actions moveSlider = new Actions(Driver.get());
        Action action = moveSlider.dragAndDropBy(loanPage.slider1, 250, 0).build();
        action.perform();
        BrowserUtils.waitFor(2);

    }

    @Then("User enter the months")
    public void user_enter_the_months() {
        Actions moveSlider1 = new Actions(Driver.get());
        Action action1 = moveSlider1.dragAndDropBy(loanPage.slider2, 300, 0).build();
        action1.perform();

    }

    @Then("User enter the {string} for loan")
    public void user_enter_the_for_loan(String reason) {

        loanPage.getReason(reason);
        BrowserUtils.waitFor(2);
        loanPage.nextButton.click();

    }

    @Then("user enter address info")
    public void userEnterAddressInfo() {
        loanPage.getAddressInfo();

    }

    @And("User enter personal information {string}")
    public void userEnterPersonalInformation(String age) {
        loanPage.getPersonalInfo();
        if (age.contains("over")) {
            DateFormat df = new SimpleDateFormat("09/05/1985");
            Date dateObj = new Date();
            loanPage.dateOfBirth.sendKeys(df.format(dateObj));
        } else {
            DateFormat df = new SimpleDateFormat("09/05/2018");
            Date dateObj = new Date();
            loanPage.dateOfBirth.sendKeys(df.format(dateObj));
        }
        loanPage.phoneNumber.sendKeys("0" + fk.number().digits(10));
        loanPage.yesClick.click();
        loanPage.nextButton.click();
        BrowserUtils.waitFor(1);
        loanPage.manuel.click();
        BrowserUtils.waitFor(1);
    }

    @And("User should be able to see {string} message")
    public void userShouldBeAbleToSeeMessage(String expectedMessage) {

        String actualMessage = loanPage.textMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @And("User shouldn't be able to see {string} message")
    public void userShouldnTBeAbleToSeeMessage(String expectedMessage) {
        BrowserUtils.waitFor(1);
        String actualMessage = loanPage.textMessage.getText();//Thank for your app ,ERHAN
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        
    }


}
