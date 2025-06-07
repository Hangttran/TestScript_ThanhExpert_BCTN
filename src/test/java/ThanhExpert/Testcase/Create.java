package ThanhExpert.Testcase;

import ThanhExpert.Common.ExcelHelper;
import ThanhExpert.Commons.Setup;
import ThanhExpert.Pages.CreatePage;
import ThanhExpert.Pages.ViewPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class Create extends Setup {
    WebDriver driver;
    private CreatePage createPage;
    private ExcelHelper excelHelper;
    @BeforeClass
    public void setupWeb() {
        driver = getDriver();
        createPage = new CreatePage(driver);
        createPage.clickCreateBtn();
        excelHelper = new ExcelHelper();
    }

    @Test
    public void all_TC01(){
        createPage = new CreatePage(driver);
        createPage.verifyNameOfItem();
    }

    @Test
    public void all_TC02(){
        createPage = new CreatePage(driver);
        createPage.verifyTotalofItem(17);
    }

    @Test(priority = 1)
    public void login_TC20() throws Exception {
        excelHelper.setExcelFile("src/test/resources/DataTest_ThanhExpert.xlsx","Login_CreateNewUser");
        System.out.println("LOGIN_TC20: Verify that nothing happen in the login textbox \" " +
                "when user input alphabet or alphabet and number character\n" +
                "1. Input into Login field\n");
        createPage = new CreatePage(driver);
        createPage.verifyLoginField(excelHelper.getCellData("Login",1));
    }

    @Test(priority = 1)
    public void login_TC21() {
        System.out.println("LOGIN_TC21: Verify that the error message:\" Please input alphabets or alphabets \" " +
                "and number character.\" is displayed \" " +
               "when user input special/emoji character into login textbox\n" +
                "1. Input into Login field\n");
        createPage = new CreatePage(driver);
        createPage.verifyLoginField1("@");
    }

    @Test(priority = 1)
    public void login_TC22() {
        System.out.println("LOGIN_TC22: Verify that nothing happen in the login textbox \" " +
                "\"when user input into 4 valid character\n" +
                "1. Input 4 characters into Login field\n");
        createPage = new CreatePage(driver);
        createPage.verifyLoginField("Nga1");
    }

    @Test(priority = 1)
    public void login_TC23() {
        System.out.println("LOGIN_TC23: Verify that the error message: \" Please input 4~128 characters. \" is displayed " +
                "when user input into 3 character\n" +
                "1. Input 3 alphabets character into Login field\n");
        createPage = new CreatePage(driver);
        createPage.verifyLoginField3("Nga");
    }

    @Test(priority = 1)
    public void login_TC24() {
        System.out.println("LOGIN_TC24: Verify that unable to continue input " +
                "when user input more than 128 character into login textbox\n" +
                "1. Input 129 characters into Login field.\n");
        createPage = new CreatePage(driver);
        createPage.verifyLoginField4("aaB3cD4EfG5hIjK6LmNo7PqRs8TuVw9XyZa1bC2dE3fGhIjK4lMnOp5QrStU" +
                "v6WxYz7AbCdEfGhIjKlMnOpQr8StUvWxYz9aBcDeFgHiJkLmNoPqRsTuVwXyZ01234567", 128);
    }

    @Test(priority = 1)
    public void login_TC25() {
        System.out.println("LOGIN_TC25: Verify that the error message:\"Login is required.\" is displayed \n" +
                "when user don't input into login textbox\n" +
                "1. Don't input into Login field\n" +
                "2. Click on password field.\n");
        createPage = new CreatePage(driver);
        createPage.verifyLoginField2();
    }

    @Test(priority = 2)
    public void pass_TC26() throws InterruptedException {
        System.out.println("PASS_TC26: Verify that nothing happen in the password textbox " +
                "when user input special,alphabet and number character into password textbox\n" +
                "1. Input into Password field\n");
        createPage = new CreatePage(driver);
        createPage.verifyPassField("Hang@1");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void pass_TC27() {
        System.out.println("PASS_TC27: Verify that the error message:\" Please input special," +
                " aphalbets and number character.\" is displayed \" " +
                "when user input special/emoji/number/aphabet/number " +
                "and aphabet character into password textbox\n" +
                "1. Input number characters into Password field\n");
        createPage = new CreatePage(driver);
        createPage.verifyPassField1("1111");
    }

    @Test(priority = 2)
    public void pass_TC28() {
        System.out.println("PASS_TC28: Verify that nothing happen in the password textbox" +
                "when user input into 4 valid character\n" +
                "1. Input 4 characters into Password field\n");
        createPage = new CreatePage(driver);
        createPage.verifyPassField("Ha2!");
    }

    @Test(priority = 2)
    public void pass_TC29() {
        System.out.println("PASS_TC29: Verify that the error message: \" Please input 4~128 characters. \"" +
                " is displayed when user input into 3 character\n" +
                "1. Input 3 alphabets character into Password field\n");
        createPage = new CreatePage(driver);
        createPage.verifyPassField3("H@2");
    }

    @Test(priority = 2)
    public void pass_TC30() {
        System.out.println("PASS_TC30: Verify that unable to continue input " +
                "when user input more than 128 character into password textbox\n" +
                "1. Input 129 characters into Password field.\n");
        createPage = new CreatePage(driver);
        createPage.verifyPassField4("aaB3cD4EfG5hIjK6LmNo7PqRs8TuVw9XyZa1bC2dE3fGhIjK4lMnOp5QrStU" +
                "v6WxYz7AbCdEfGhIjKlMnOpQr8StUvWxYz9aBcDeFgHiJkLmNoPqRsTuVwXyZ01234567", 128);
    }

    @Test(priority = 2)
    public void pass_TC31() {
        System.out.println("PASS_TC31: Verify that the error message:\"Password is required.\" is displayed \n" +
                "when user don't input into password textbox\n" +
                "1. Don't input into Password field\n" +
                "2. Click on login field.\n");
        createPage = new CreatePage(driver);
        createPage.verifyPassField2();
    }

    @Test(priority = 3)
    public void email_TC32() throws InterruptedException {
        System.out.println("EMAIL_TC32: Verify that nothing happen in the email textbox " +
                "when user input a valid email\n" +
                "1. Input a valid into Email field\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField("Hang@gmail.com");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void email_TC33() {
        System.out.println("EMAIL_TC33: Verify that the error message:\" Email is required.\" " +
                "is displayed when user doesn't input into email textbox " +
                "1. Don't input into email textbox\n" +
                "2. Click on password textbox");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField2();
    }

    @Test(priority = 3)
    public void email_TC34() {
        System.out.println("EMAIL_TC35: Verify that the error message: \" Email must be in the format: username@example.com. \"" +
                " is displayed when user input a missing the email prefix\n" +
                "1. Input the email missing the prefix\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField1("@gmail.com");
    }

    @Test(priority = 3)
    public void email_TC35() {
        System.out.println("EMAIL_TC35: Verify that the error message: \" Email must be in the format: username@example.com. \"" +
                " is displayed when user input is missing the @ symbol \n" +
                "1.  Input the email missing the @ symbol\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField1("Hanggmail.com");
    }

    @Test(priority = 3)
    public void email_TC36() {
        System.out.println("EMAIL_TC36: Verify that the error message: \" Email must be in the format: username@example.com. \"" +
                " is displayed when user input an extra @ symbol\n" +
                "1. Input the email extra the @ symbol\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField1("Hang@@gmail.com");
    }

    @Test(priority = 3)
    public void email_TC37() {
        System.out.println("EMAIL_TC37: Verify that the error message: \" Email must be in the format: username@example.com. \"" +
                " is displayed when user  input an email prefix that start with a dot \n" +
                "1. Input email with a prefix starting with a dot\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField1(".Hang@gmail.com");
    }

    @Test(priority = 3)
    public void email_TC38() {
        System.out.println("EMAIL_TC38: Verify that the error message: \" Email must be in the format: username@example.com. \"" +
                " is displayed when user  input 2 consecutive dots in the email prefix\n" +
                "1. Input the email with 2 consecutive dots in the prefix\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField1("Ha..ng@gmail.com");
    }

    @Test(priority = 3)
    public void email_TC39() {
        System.out.println("EMAIL_TC39: Verify that the error message: \" Email must be in the format: username@example.com. \"" +
                " is displayed when user end prefix with a dot\n" +
                "1. Input email with a prefix ending with a dot\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField1("Hang.@gmail.com");
    }

    @Test(priority = 3)
    public void email_TC40() {
        System.out.println("EMAIL_TC40: Verify that the error message: \" Email must be in the format: username@example.com. \"" +
                " is displayed when user input a missing domain name\n" +
                "1. Input the email missing the domain name\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField4("Hang@");
    }

    @Test(priority = 3)
    public void email_TC41() {
        System.out.println("EMAIL_TC41: Verify that the error message: \" Email must be in the format: username@example.com. \"" +
                " is displayed when user input domain name starts with a dot\n" +
                "1. Input the email with a domain name starting with a dot\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField1("Ha@.gmail.com");
    }

    @Test(priority = 3)
    public void email_TC42() {
        System.out.println("EMAIL_TC42: Verify that the error message: \" Email must be in the format: username@example.com. \"" +
                " is displayed when user input is missing a top-level domain\n" +
                "1. Input the email missing a top-level domain\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField1("Ha@gmail");
    }

    @Test(priority = 3)
    public void email_TC43() {
        System.out.println("EMAIL_TC43: Verify that nothing happen " +
                "when user input 8 character into email textbox\n" +
                "1. Input 8 characters valid into Email textbox\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField("Tan@g.com");
    }

    @Test(priority = 3)
    public void email_TC44() {
        System.out.println("EMAIL_TC44: Verify that the error message: \"Please input at least 8 characters.\"" +
                " is displayed when user input 7 character into email textbox\n" +
                "1. Input 7 character valid into Email textbox\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField4("T@g.com");
    }

    @Test(priority = 3)
    public void email_TC45() {
        System.out.println("EMAIL_TC45: Verify that the error message: \"Please input more than 128 characters.\"" +
                " is displayed when user input 129 character into email textbox\n" +
                "1. Input 129 characters into Email field.\n");
        createPage = new CreatePage(driver);
        createPage.verifyEmailField3("Abc123Def456Ghi789Jkl012Mno345Pqr678Stu901VXYZ789mno456pq" +
                "wx234Yza567Bcd890Efg123Hij456Klm789Nop012Qrs345Tuv678Wxy901Zab23@gmail.com\n");
    }

    @Test(priority = 4)
    public void name_TC46() {
        System.out.println("NAME_TC46: Verify that nothing happen in the Name textbox " +
                "when user input alphabet or alphabet and number character into Name textbox\n" +
                "1. Input alphabets character.\n");
        createPage = new CreatePage(driver);
        createPage.verifyNameField("Sang");
    }

    @Test(priority = 4)
    public void name_TC47() {
        System.out.println("NAME_TC47: Verify that the error message:\"Please input alphabets or aphalbets and number character.\" is displayed \n" +
                "when user input special/emoji character into name textbox\n" +
                "1. Input special character.\n");
        createPage = new CreatePage(driver);
        createPage.verifyNameField1("****");
    }

    @Test(priority = 4)
    public void name_TC48() {
        System.out.println("NAME_TC48: Verify that nothing happen when user input into 4 character into Name textbox\n" +
                "1. Input 4 alphabets character.\n");
        createPage = new CreatePage(driver);
        createPage.verifyNameField("Huyen");
    }

    @Test(priority = 4)
    public void name_TC49() {
        System.out.println("NAME_TC49: Verify that the error message:\"Please input 4~65 characters.\" is displayed \n" +
                "when user into 3 character into name textbox\n" +
                "1. Input 3 alphabets character.\n");
        createPage = new CreatePage(driver);
        createPage.verifyNameField3("Dao");
    }

    @Test(priority = 4)
    public void name_TC50() {
        System.out.println("NAME_TC50: Verify that unable to continue input " +
                "when user input more than 65 character into name textbox\n" +
                "1. Input 129 character\n");
        createPage = new CreatePage(driver);
        createPage.verifyNameField4("Abc123Def456Ghi789Jkl012Mno345Pqr678Stu901Vwx234" +
                "Yza567Bcd890Efg123Hij456Klm789Nop012Qrs345Tuv678Wxy901Zab234Cde523123456", 65);
    }

    @Test(priority = 4)
    public void name_TC51() {
        System.out.println("NAME_TC51: Verify that the error message:\"Name is required.\" is displayed"  +
                            " when user don't input into Name textbox\n" +
                            "1. Blank name textbox\n");
        createPage = new CreatePage(driver);
        createPage.verifyNameField2();
    }

    @Test(priority = 4)
    public void name_TC52() {
        System.out.println("NAME_TC52: Verify that nothing happen in the Name textbox " +
                "when user input alphabet or alphabet and number character into Name textbox\n" +
                "1. Input alphabets character.\n");
        createPage = new CreatePage(driver);
        createPage.verifyNameField("Thanh");
    }

    @Test(priority = 5)
    public void surname_TC53() {
        System.out.println("SURNAME_TC53: Verify that the error message:" +
                "\" Please input alphabets or aphalbets and number character.\" is displayed " +
                "when user input special/emoji character into Surname textbox\n" +
                "1. Input special character.\n");
        createPage = new CreatePage(driver);
        createPage.verifySurnameField1("@@@@");
    }

    @Test(priority = 5)
    public void surname_TC54() {
        System.out.println("SURNAME_TC54: Verify that nothing happen when user input into 4 character " +
                "into Surname textbox\n" +
                "1. Input 4 alphabets character.");
        createPage = new CreatePage(driver);
        createPage.verifySurnameField("Thanh");
    }

    @Test(priority = 5)
    public void surname_TC55() {
        System.out.println("SURNAME_TC55: Verify that the error message: " +
                "\" Please input 4~65 characters.\" is displayed " +
                "when user input into 3 character into Surname textbox\n" +
                "1. Input 3 alphabets character.\n");
        createPage = new CreatePage(driver);
        createPage.verifySurnameField3("Nga");
    }

    @Test(priority = 5)
    public void surname_TC56() {
        System.out.println("SURNAME_TC56: Verify that unable to continue input " +
                "when user input more than 65 character into Surname textbox\n" +
                "1. Input 129 character\n");
        createPage = new CreatePage(driver);
        createPage.verifySurnameField4("Abc123Def456Ghi789Jkl012Mno345Pqr678Stu901Vwx234" +
                "Yza567Bcd890Efg123Hij456Klm789Nop012Qrs345Tuv678Wxy901Zab234Cde523123456", 65);
    }

    @Test(priority = 5)
    public void surname_TC57() {
        System.out.println("SURNAME_TC57: Verify that the error message: \"Surname is required\" " +
                "is displayed when user don't input into Surname textbox\n" +
                "1. Blank Surname textbox\n");
        createPage = new CreatePage(driver);
        createPage.verifyPassField2();
    }

    @Test(priority = 6)
    public void phone_TC58() {
        System.out.println("PHONE_TC58: Verify that nothing happen in the phone textbox " +
                "when user input phone number with a format valid\n" +
                "1. Input a valid phone number\n");
        createPage = new CreatePage(driver);
        createPage.verifyPhoneField("0982042644");
    }

    @Test(priority = 6)
    public void phone_TC59() {
        System.out.println("PHONE_TC59: Verify that the error message:\"Please input a valid phone number\" is displayed " +
                "when user input 9 number character\n" +
                "1. Input 9 number character.\n");
        createPage = new CreatePage(driver);
        createPage.verifyPhoneField2("098204264");
    }



    @Test
    public void phone_TC60() {
        System.out.println("PHONE_TC60: Verify that nothing happen in the phone textbox " +
                "when user input 10 number character\n" +
                "1. Input 11 number character\n");
        createPage = new CreatePage(driver);
        createPage.verifyPhoneField3("09820426444", 10);
    }

    @Test(priority = 6)
    public void phone_TC61() {
        System.out.println("PHONE_TC60: Verify that the error message:\"Please input a valid phone number\" is displayed " +
                "when user input 11 number character\n" +
                "1. Input 11 number character\n");
        createPage = new CreatePage(driver);
        createPage.verifyPhoneField3("09820426444", 10);
    }

    @Test(priority = 6)
    public void phone_TC62() {
        System.out.println("PHONE_TC61: Verify that the error message:\" Phone is required.\" is displayed " +
                "when user don't input into Phone textbox\n" +
                "1. Don't input into Phone textbox\n");
        createPage = new CreatePage(driver);
        createPage.verifyPhoneField1();
    }

    @Test(priority = 6)
    public void phone_TC63() {
        System.out.println("PHONE_TC62: Verify that the error message:\"Please input a valid phone number\" is displayed " +
                "when user input incorrect mobile network prefix entered character\n" +
                "1. Input 10 number character\n");
        createPage = new CreatePage(driver);
        createPage.verifyPhoneField2("0082042644");
    }

    @Test(priority = 7)
    public void role_TC64(){
        System.out.println("ROLE_TC63: Verify that the radio button is only seleted 1 value " +
                "when user click on role button\n" +
                "1. Click on user button\n" +
                "2. Click on admin button\n");
        createPage = new CreatePage(driver);
        createPage.verifyRoleField();
    }

    @Test(priority = 7)
    public void role_TC65(){
        createPage = new CreatePage(driver);
        createPage.verifyRoleField1();
    }

    @Test(priority = 8)
    public void submit_66(){
        System.out.println("SUBMIT_TC67: Verify that the screen move to Manage User, the message:" +
                "\"The user was saved successfully\" and 1 saved record is displayed " +
                "when user click  on the submit button\n" +
                "1. Input valid values into all textbox\n" +
                "2. 2. Click the submit button\n");
        createPage = new CreatePage(driver);
        createPage.verifySubmitBtn("Thanh", "Thanh123@", "thanh@gmail.com", "Thanh", "Tong",
                "0361273521");
        createPage.verifySubmitSuccess();
        createPage.verifyRecord("Thanh");
    }

    @Test(priority = 8)
    public void submit_67(){
        System.out.println("SUBMIT_TC67: Verify that the screen move to Manage User, the message:" +
                "\"The user was saved successfully\" and 1 saved record is displayed " +
                "when user click 2 times on the submit button\n" +
                "1. Input valid values into all textbox\n" +
                "2. 2. Click the submit button\n");
        createPage = new CreatePage(driver);
        createPage.clickCreateBtn();
        createPage.verifySubmitBtnmultiple("Hoang", "Hoang123@", "hoang@gmail.com", "Hoang", "Truong",
                "0361273521");
        createPage.verifySubmitSuccess();
        createPage.verifyRecord("Hoang");
    }

    @Test(priority = 9)
    public void submit_TC68() throws InterruptedException {
        System.out.println("SUBMIT_TC68: Verify that the popup with error message: " +
                "\"There is another user with login:\" + value of login is displayed " +
                "when user input valid all textbox except login textbox" +
                "1. Input valid values into all textbox except Phone textbox\n" +
                "2. Click the submit button");
        createPage = new CreatePage(driver);
        createPage.clickCreateBtn();
        createPage.verifySubmitBtn("Nhat", "Thanh123@", "thanh@gmail.com", "Thanh", "Tong",
                "0361273521");
        Thread.sleep(2000);
        createPage.verifyUniqueLogin();
    }

    @Test(priority = 10)
    public void submit_TC69(){
        createPage = new CreatePage(driver);
        createPage.verifySubmitBtn("Thach", "Thach", "thach@gmail.com", "Thach", "Tong",
                "0361273521");
        createPage.verifyUrl();
    }

    @Test(priority = 11)
    public void cancel_TC70(){
        createPage = new CreatePage(driver);
        createPage.verifyCancelBtn();
    }
    @Test
        public void testTooltipOnHover() {

            WebElement input = driver.findElement(By.id("name"));// id=xpath

            // Hover vào textbox
            Actions actions = new Actions(driver);
            actions.moveToElement(input).perform();

            // Lấy giá trị tooltip từ attribute title
            String tooltipText = input.getAttribute("title");
            System.out.println(tooltipText);
            // So sánh với text mong muốn
            Assert.assertEquals(tooltipText, "Name is required");
        }
    }




