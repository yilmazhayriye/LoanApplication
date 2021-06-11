package com.netcall.pages;

import com.github.javafaker.Faker;
import com.netcall.utilities.BrowserUtils;
import com.netcall.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LoanPage {

    Faker fk = new Faker();
    public LoanPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "(//span)[2]")
    public WebElement slider1;

    @FindBy(xpath = "(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]")
    public WebElement slider2;

    @FindBy(xpath = "//select[@class='required col-form-value valid_choice input_dropdown form-control']")
    public WebElement selectReason;

    @FindBy(xpath = "//*[@class=\"fragment_presenter_template_edit btn bg-green btn-large\"]")
    public WebElement nextButton;

    @FindBy(xpath = "//*[@class=\"required col-form-value valid_string valid_max_length form-control\"]")
    public List<WebElement> nameAndEmail;

    @FindBy(xpath = "//*[@class=\"required valid_custom_validator ajax_validation col-form-value valid_date form-control datepicker hasDatepicker\"]")
    public WebElement dateOfBirth;

    @FindBy(xpath = "//*[@class=\"required col-form-value valid_mobile form-control\"]")
    public WebElement phoneNumber;

    @FindBy(xpath = "(//*[@class=\"custom-control custom-radio\"])[2]")
    public WebElement yesClick;

    @FindBy(xpath = "(//*[@class=\"col-form-value required col-form-value valid_string valid_max_length form-control\"])[1]")
    public WebElement addressLine1;


    @FindBy(xpath = "(//*[@class=\"col-form-value required col-form-value valid_string valid_max_length form-control\"])[2]")
    public WebElement town;

    @FindBy(xpath = "//*[@class=\"col-form-value required col-form-value valid_uk_postcode form-control\"]")
    public WebElement postcode;

    @FindBy(xpath = "(//*[@class=\"required col-form-value valid_string valid_max_length form-control\"])[1]")
    public WebElement bankName;

    @FindBy(xpath = "(//*[@class=\"required col-form-value valid_string valid_max_length form-control\"])[2]")
    public WebElement sortCode;

    @FindBy(xpath = "(//*[@class=\"required col-form-value valid_integer form-control\"])[1]")
    public WebElement accountNumber;

    @FindBy(xpath = "(//*[@class=\"value-as-text\"])[1]")
    public WebElement textMessage;

    @FindBy(xpath = "(//*[@class=\"custom-control custom-radio\"])[2]")
    public WebElement manuel;


    public void getReason(String reason){

        Select select= new Select(selectReason);
        selectReason.click();
        select.selectByVisibleText(reason);

    }
    public void getPersonalInfo() {

        nameAndEmail.get(0).sendKeys(fk.name().firstName());
        nameAndEmail.get(1).sendKeys(fk.name().lastName());
        nameAndEmail.get(2).sendKeys(fk.internet().emailAddress());




    }
    public void getAddressInfo(){
        addressLine1.sendKeys(fk.address().fullAddress());
        town.sendKeys(fk.address().cityName());
        postcode.sendKeys("BB97QP");
        nextButton.click();
        bankName.sendKeys("Nation Wide Bank");
        sortCode.sendKeys("09-09-08");
        accountNumber.sendKeys("12345678");
        nextButton.click();
        BrowserUtils.waitFor(2);
        nextButton.click();



    }

}
