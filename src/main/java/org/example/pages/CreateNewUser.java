package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewUser {
    WebDriver driver;

    public CreateNewUser(WebDriver driver) {
        this.driver = driver;
    }
    public void ClickIcon() {
        WebElement Usericon = driver.findElement(By.xpath("//*[@href=\"#loginModal\"]"));
        Usericon.click();
    }

    public void InputLogin1(String login1) {
        WebElement Login1 = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        Login1.sendKeys(login1);
    }

    public void InputPass1(String pass) {
        WebElement Password1 = driver.findElement(By.xpath("//*[@name=\"password\"]"));
        Password1.sendKeys(pass);
    }
    public void clickSignIn() {
        WebElement Signin = driver.findElement(By.xpath("//div[@id='loginModal']//form//button"));
        Signin.click();
    }
    public void clickDropList() {
        WebElement droplist = driver.findElement(By.xpath(" //*[@id=\"navbarDropdownMenuLink-4\"]"));
        droplist.click();
    }
    public void clickAdmin() {
        WebElement admin = driver.findElement(By.xpath(" //*[@href=\"/admin\"]"));
        admin.click();
    }
    public void clickUsers() {
        WebElement users = driver.findElement(By.xpath(" //*[@href=\"/admin/users\"]"));
        users.click();
    }

    public void clickCreate() {
        WebElement create = driver.findElement(By.xpath(" //*[@href=\"/admin/users/new\"]"));
        create.click();
    }

    public void InputLogin(String login) {
        WebElement Login = driver.findElement(By.xpath(" //*[@id=\"login\"]"));
        Login.sendKeys(login);
    }
    public String GetErrorMessage() {
        WebElement LoginInValid = driver.findElement(By.xpath(" //*[@id=\"login-error\"]"));
        return LoginInValid.getText();
    }
}

