package ThanhExpert.Pages;

import ThanhExpert.Common.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.sql.*;

public class CreatePage {
    WebDriver driver;
    private Validate validate;

    public CreatePage(WebDriver driver){
        this.driver = driver;
        validate = new Validate(driver);
    }

    private String url = "http://localhost:8084/admin/users";
    private String url1 = "http://localhost:8084/admin/users/new";
    private String message = "";
    private String errormessageLogin1 = "Please input alphabet or alphabet and number (No accents).";
    private String errormessageLogin2 = "Login is required.";
    private String errormessagePass1 = "Please input alphabet, numbers, and special characters (No spaces or accents).";
    private String errormessagePass2 = "Password is required.";
    private String errormessageEmail1 = "Email must be in the format: username@example.com.";
    private String errormessageEmail2 = "Email is required.";
    private String errormessageEmail3 = "Don't input more than 128 characters.";
    private String errormessageEmail4 = "Please input at least 8 character.";
    private String errormessageName_Sur1 = "Please input alphabet or alphabet and number characters (No accents).";
    private String errormessageName = "Name is required.";
    private String errormessageSurname = "Surame is required.";
    private String errormessagePhone = "Phone is required.";
    private String errormessagePhone1 = "Please input a valid phone number.";
    private String errormessageNumberof1 = "Please input 4~128 characters.";
    private String errormessageNumberof2 = "Please input 4~65 characters.";
    private String messageSubmit1 = "The user was saved successfully";
    private String messagePopup = "There is another user with login: hangshow";
    private By all1 = By.xpath("");
    private By all = By.cssSelector("label, input[type='password'], input[type='email'], " +
            "button[type='submit'], button[type='button'], input[type='radio']");
    private By titleLogin = By.xpath("//label[contains(text(),\"Login\")]");
    private By titlePass = By.xpath("//label[contains(text(),\"Password\")]");
    private By titleEmail = By.xpath("//label[contains(text(),\"Email\")]");
    private By titleName = By.xpath("//label[contains(text(),\"Name\")]");
    private By titleSurname = By.xpath("//label[contains(text(),\"Surname\")]");
    private By titlePhone = By.xpath("//label[contains(text(),\"Phone\")]");
    private By titleRole = By.xpath("//label[contains(text(),\"Role\")]");
    private By errorLogin = By.xpath("//*[@id=\"login-error\"]");
    private By errorPass = By.xpath("//*[@id=\"password-error\"]");
    private By errorEmail = By.xpath("//*[@id=\"email-error\"]");
    private By errorName = By.xpath("//*[@id=\"name-error\"]");
    private By errorSurname = By.xpath("//*[@id=\"surname-error\"]");
    private By errorPhone = By.xpath("//*[@id=\"phone-error\"]");
    private By createBtn = By.xpath("//*[@href=\"/admin/users/new\"]");
    private By loginField = By.xpath("//*[@id=\"login\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By emailField = By.xpath("//*[@id=\"email\"]");
    private By nameField = By.xpath("//*[@id=\"name\"]");
    private By surnameField = By.xpath("//*[@id=\"surname\"]");
    private By phoneField = By.xpath("//*[@id=\"phone\"]");
    private By userBtn = By.xpath("//*[@id=\"role1\"]");
    private By adminBtn = By.xpath("//*[@id=\"role2\"]");
    private By submitBtn = By.xpath("(//button[@type='submit'])[2]");
    private By cancelBtn = By.xpath("//button[@id=\"cancelBtn\"]");
    private By messageSubmit = By.xpath("/html/body/div[1]/div[2]");
    private By errorPopup = By.xpath("//*[@id=\"modalBody\"]");

    public void verifyNameOfItem(){
        Assert.assertEquals(validate.getText1(titleLogin),
                "Login","The item name is not 'Login'");
        Assert.assertEquals(validate.getText1(titlePass),
                "Password", "The item name is not 'Password'");
        Assert.assertEquals(validate.getText1(titleEmail),
                "Email", "The item name is not 'Email'");
        Assert.assertEquals(validate.getText1(titleName),
                "Name", "The item name is not 'Name'");
        Assert.assertEquals(validate.getText1(titleSurname),
                "Surname", "The item name is not 'Surname'");
        Assert.assertEquals(validate.getText1(titlePhone),
                "Phone", "The item name is not 'Phone'");
        Assert.assertEquals(validate.getText1(titleRole),
                "Role", "The item name is not 'Role'");
    }

    public void ALL_TC02(){
        Assert.assertEquals(validate.getText1(titleLogin), "Login");
    }

    public void verifyTotalofItem(int expected){
        Assert.assertEquals(validate.getTotalofItemCreate(all), expected);
    }

    public void clickCreateBtn(){
        validate.clickElement(createBtn);
    }

    public void clickCancelBtn(){
        validate.clickElement(cancelBtn);
    }

    public void verifyLoginField(String loginValue){
        validate.setText(loginField, loginValue);
        Assert.assertTrue(validate.getText(errorLogin,message), "The error message display");
        validate.clearText(loginField);
    }

    public void verifyLoginField1(String loginValue){
        validate.clearText(loginField);
        validate.setText(loginField, loginValue);
        Assert.assertTrue(validate.getText(errorLogin,errormessageLogin1),
                "The error message don't display");
        Assert.assertEquals(validate.getText1(errorLogin), "Please input alphabet or alphabet and number (No accents).");
        validate.clearText(loginField);
    }

    public void verifyLoginField2(){
        validate.clearText(loginField);
        Assert.assertTrue(validate.getText(errorLogin,errormessageLogin2),
                "The error message don't display");
        Assert.assertEquals(validate.getText1(errorLogin), "Login is required.");
        validate.clickElement(passwordField);
    }

    public void verifyLoginField3(String loginValue){
        validate.clearText(loginField);
        validate.setText(loginField, loginValue);
        Assert.assertTrue(validate.getText(errorLogin,errormessageNumberof1),
                "The error message don't display");
        Assert.assertEquals(validate.getText1(errorLogin), "Please input 4~128 characters.");
        validate.clearText(loginField);
    }

    public void verifyLoginField4(String loginValue, int expected){
        validate.setText(loginField, loginValue);
        validate.getNumberofCharacter(loginField, expected);
        validate.clearText(loginField);
    }

    public void verifyPassField(String passValue){
        validate.clearText(passwordField);
        validate.setText(passwordField, passValue);
        Assert.assertTrue(validate.getText(errorPass,message), "Display the error message.");
    }

    public void verifyPassField1(String passValue){
        validate.clearText(passwordField);
        validate.setText(passwordField, passValue);
        Assert.assertTrue(validate.getText(errorPass,errormessagePass1),
                "The error message is displayed.");

    }

    public void verifyPassField2(){
        validate.clearText(passwordField);
        validate.clickElement(loginField);
        Assert.assertTrue(validate.getText(errorPass,errormessagePass2), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorPass), "Password is required.");
    }

    public void verifyPassField3(String passValue){
        validate.clearText(passwordField);
        validate.setText(passwordField, passValue);
        Assert.assertTrue(validate.getText(errorPass,errormessageNumberof1), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorPass), "Please input 4~128 characters.");
    }

    public void verifyPassField4(String passValue, int expected){
        validate.clearText(passwordField);
        validate.setText(passwordField, passValue);
        validate.getNumberofCharacter(passwordField, expected);
    }

    public void verifyEmailField(String emailValue){
        validate.clearText(emailField);
        validate.setText(emailField, emailValue);
        Assert.assertTrue(validate.getText(errorEmail,message), "Display the error message.");
        validate.clearText(emailField);
    }

    public void verifyEmailField1(String emailValue){
        validate.clearText(emailField);
        validate.setText(emailField, emailValue);
        Assert.assertTrue(validate.getText(errorEmail,errormessageEmail1), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorEmail), "Email must be in the format: username@example.com.");
    }

    public void verifyEmailField2(){
        validate.clearText(emailField);
        validate.clickElement(nameField);
        Assert.assertTrue(validate.getText(errorEmail,errormessageEmail2), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorEmail), "Email is required.");
    }

    public void verifyEmailField3(String emailValue){
        validate.clearText(emailField);
        validate.setText(emailField, emailValue);
        Assert.assertTrue(validate.getText(errorEmail,errormessageEmail3), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorEmail), "Don't input more than 128 characters.");
        validate.clearText(emailField);
    }

    public void verifyEmailField4(String emailValue){
        validate.clearText(emailField);
        validate.setText(emailField, emailValue);
        Assert.assertTrue(validate.getText(errorEmail,errormessageEmail4), "The error message don't display.");
        Assert.assertEquals(validate.getText1(errorEmail), "Please input at least 8 character.");
    }

    public void verifyNameField(String nameValue){
        validate.clearText(nameField);
        validate.setText(nameField, nameValue);
        Assert.assertTrue(validate.getText(errorName,message), "Display the error message.");
        validate.clearText(nameField);
    }

    public void verifyNameField1(String nameValue){
        validate.clearText(nameField);
        validate.setText(nameField, nameValue);
        Assert.assertTrue(validate.getText(errorName,errormessageName_Sur1), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorName), "Please input alphabet or alphabet and number characters (No accents).");
    }

    public void verifyNameField2(){
        validate.clearText(nameField);
        validate.clickElement(surnameField);
        Assert.assertTrue(validate.getText(errorName,errormessageName), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorName), "Name is required.");
    }

    public void verifyNameField3(String surnameValue){
        validate.clearText(nameField);
        validate.setText(nameField, surnameValue);
        Assert.assertTrue(validate.getText(errorName,errormessageNumberof2), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorName), "Please input 4~65 characters.");
    }

    public void verifyNameField4(String nameValue, int expected){
        validate.clearText(nameField);
        validate.setText(nameField, nameValue);
        validate.getNumberofCharacter(nameField, expected);
    }

    public void verifySurnameField(String surnameValue){
        validate.clearText(surnameField);
        validate.setText(surnameField, surnameValue);
        Assert.assertTrue(validate.getText(errorSurname,message), "Display the error message.");
    }

    public void verifySurnameField1(String surnameValue){
        validate.clearText(surnameField);
        validate.setText(surnameField, surnameValue);
        Assert.assertTrue(validate.getText(errorSurname,errormessageName_Sur1), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorSurname), "Please input alphabet or alphabet and number characters (No accents).");
    }

    public void verifySurnameField2(){
        validate.clickElement(emailField);
        Assert.assertTrue(validate.getText(errorSurname,errormessageSurname), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorSurname), "Surname is required.");
    }

    public void verifySurnameField3(String surnameValue){
        validate.clearText(surnameField);
        validate.setText(surnameField, surnameValue);
        Assert.assertTrue(validate.getText(errorSurname,errormessageNumberof2), "The error message don't display");
        Assert.assertEquals(validate.getText1(errorSurname), "Please input 4~65 characters.");
    }

    public void verifySurnameField4(String surnameValue, int expected){
        validate.clearText(surnameField);
        validate.setText(surnameField, surnameValue);
        validate.getNumberofCharacter(surnameField, expected);
        validate.clearText(surnameField);
    }

    public void verifyPhoneField(String phoneValue){
        validate.clearText(phoneField);
        validate.setText(phoneField, phoneValue);
        Assert.assertTrue(validate.getText(errorPhone,message), "Display the error message.");
    }

    public void verifyPhoneField1(){
        validate.clearText(phoneField);
        validate.clickElement(phoneField);
        validate.clickElement(submitBtn);
        Assert.assertTrue(validate.getText(errorPhone,errormessagePhone),
                "The error message don't display");
        Assert.assertEquals(validate.getText1(errorPhone), "Phone is required.");
    }

    public void verifyPhoneField2(String phoneValue){
        validate.clearText(phoneField);
        validate.setText(phoneField, phoneValue);
        Assert.assertTrue(validate.getText(errorPhone,errormessagePhone1),
                "The error message don't display");
        Assert.assertEquals(validate.getText1(errorPhone), "Please input a valid phone number.");
        validate.clearText(phoneField);
    }

    public void verifyPhoneField3(String phoneValue, int expected){
        validate.clearText(phoneField);
        validate.clearText(phoneField);
        validate.setText(phoneField, phoneValue);
        validate.getNumberofCharacter(phoneField, expected);
        validate.clearText(phoneField);
    }

    public void verifyRoleField(){
        validate.clickElement(phoneField);
        validate.clickElement(submitBtn);
        Assert.assertTrue(validate.getText(errorPhone,errormessagePhone),
                "The error message don't display");
        Assert.assertEquals(validate.getText1(errorPhone), "Phone is required.");
    }

    public void verifyRoleField1(){
        validate.clickElement(userBtn);
        validate.clickElement(adminBtn);
        validate.selectedRadioBtn(userBtn);
    }

    public void verifySubmitBtn(String login, String pass, String email, String name,
                                String surname, String phone){
        driver.navigate().refresh();
        validate.setText(loginField, login);
        validate.setText(passwordField, pass);
        validate.setText(emailField, email);
        validate.setText(nameField, name);
        validate.setText(surnameField, surname);
        validate.setText(phoneField, phone);
        validate.clickElement(userBtn);
        validate.clickElement(submitBtn);
    }

    public void verifySubmitBtnmultiple(String login, String pass, String email, String name,
                                String surname, String phone){
        driver.navigate().refresh();
        validate.setText(loginField, login);
        validate.setText(passwordField, pass);
        validate.setText(emailField, email);
        validate.setText(nameField, name);
        validate.setText(surnameField, surname);
        validate.setText(phoneField, phone);
        validate.clickElement(userBtn);
        validate.submit(submitBtn);
        Assert.assertNotEquals(validate.getCurrentUrl(),url1);
    }

    public void verifyUniqueLogin() throws InterruptedException {
        Assert.assertTrue(validate.getText2(errorPopup),"The message don't display");
        Assert.assertEquals(validate.getText1(errorPopup), "There is another user with login: Nhat");

    }

    public void verifySubmitSuccess(){
        Assert.assertTrue(validate.getText(messageSubmit, messageSubmit1),"The message don't display");
        Assert.assertEquals(validate.getText1(messageSubmit), "The user was saved successfully");
    }

    public boolean verifyRecord(String login){
        String url = "jdbc:sqlserver://localhost:1433;databaseName=web_store_test;encrypt=false";
        String username = "sa";
        String password = "123";
        boolean exists = false;
        String query = "SELECT COUNT(*) FROM users WHERE login = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                int count = rs.getInt(1);
                System.out.println("Number of records found with login " + login + ": " + count);  // In ra số bản ghi
                exists = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public void multiple(){
        for (int i = 1; i < 3; i++) {
            validate.clickElement(submitBtn);
        }
    }

    public void verifyUrl(){
        Assert.assertTrue(validate.getUrl(url1));
    }

    public void verifyCancelBtn(){
        validate.clickElement(cancelBtn);
        Assert.assertTrue(validate.getUrl(url));
    }

    //setup for view_account(create use test pagi)
    public void createUsers(int n, String login, String pass, String email, String name,
                            String surname, String phone){
        validate.setupData(loginField, passwordField, emailField, nameField, surnameField, phoneField, userBtn,
                submitBtn, createBtn,n, login, pass, email, name, surname, phone);
    }
}
