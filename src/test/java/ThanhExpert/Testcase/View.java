package ThanhExpert.Testcase;

import ThanhExpert.Common.ExcelHelper;
import ThanhExpert.Commons.Setup;
import ThanhExpert.Pages.CreatePage;
import ThanhExpert.Pages.ViewPage;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class View extends Setup {
    WebDriver driver;
    private ViewPage viewpage;
    private CreatePage createpage;
    private ExcelHelper excelHelper;

    @BeforeClass
    public void setupWeb() {
        driver = getDriver();
        excelHelper = new ExcelHelper();
    }

    @Test
    public void all_TC01(Method result) throws Exception {
        excelHelper.setExcelFile("","");
        System.out.println("ALL_TC01: Verify the name of items are correct");
        viewpage = new ViewPage(driver);
        viewpage.verifyNameOfItem();
    }

    @Test
    public void all_TC02(Method result) throws IOException {
        System.out.println("ALL_TC02: Verify the number of items are correct");
        viewpage = new ViewPage(driver);
        viewpage.verifyTotalofItem(21);
    }

    @ Test(priority = 1)
    public void firstBtn_TC07(){
        System.out.println("FIRST_TC07: Verify that the first button is disable " +
                "when user is on first page");
        viewpage = new ViewPage(driver);
        viewpage.verifyFirstBtnDisable();
    }

    @ Test(priority = 3)
    public void firstBtn_TC08(){
        System.out.println("FIRST_TC08: Verify that the first button is enable " +
                "when user is on second page");
        viewpage = new ViewPage(driver);
        viewpage.verifyFirstBtnEnable();
    }

    @ Test(priority = 1)
    public void previousBtn_TC09(){
        System.out.println("PREVIOUS_TC09: Verify that the first button is disable " +
                "when user is on first page");
        viewpage = new ViewPage(driver);
        viewpage.verifyPreviousBtnDisable();
    }

    @ Test(priority = 5)
    public void previousBtn_TC10(){
        System.out.println("PREVIOUS_TC10: Verify that the first button is enable " +
                "when user is on number page");
        viewpage = new ViewPage(driver);
        viewpage.verifyPreviousBtnEnable();
    }

    @ Test(priority = 3)
    public void nextBtn_TC11(){
        System.out.println("NEXT_TC11: Verify that the first button is disable " +
                "when user is on first page");
        viewpage = new ViewPage(driver);
        viewpage.verifyNextBtnDisable();
    }

    @ Test(priority = 2)
    public void nextBtn_TC12(){
        System.out.println("NEXT_TC12: Verify that the first button is enable " +
                "when user is on number page");
        viewpage = new ViewPage(driver);
        viewpage.verifyNextBtnEnable();
    }

    @ Test(priority = 3)
    public void lastBtn_TC13(){
        System.out.println("LAST_TC13: Verify that the last button is disable " +
                "when user is on last page ");
        viewpage = new ViewPage(driver);
        viewpage.verifyLastBtnDisable();
    }

    @ Test(priority = 2)
    public void lastBtn_TC14(){
        System.out.println("LAST_TC14: Verify that the first button is disable " +
                "when user is on first page");
        viewpage = new ViewPage(driver);
        viewpage.verifyLastBtnEnable();
    }

    @Test()
    public void num_TC15(){
        System.out.println("NUM_TC15: Verify that the number page is change background-color" +
                " when user is on number page\n");
    }

    @Test(priority = 10)
    public void pagi_TC16(){
        System.out.println("PAGI_TC: Verify that the pagination don't add number page " +
                "when number of item per one page <= 4");
        createpage = new CreatePage(driver);
        viewpage = new ViewPage(driver);
        createpage.clickCreateBtn();
        createpage.createUsers(5,"Dang", "Dang123@", "Dang@gmail.com", "Dang", "Nguyen",
                "0371637843");
        createpage.clickCancelBtn();
        viewpage.verifyNumericPage(5);
    }

    @Test(priority = 11)
    public void pagi_TC17(){
        System.out.println("PAGI_TC: Verify that the pagination don't add number page " +
                "when number of item per one page <= 4");
        createpage = new CreatePage(driver);
        viewpage = new ViewPage(driver);
        createpage.clickCreateBtn();
        createpage.createUsers(1,"Phuc", "Phuc123@", "phuc@gmail.com", "Phuc", "Tran",
                "0821637843");
        createpage.clickCancelBtn();
        viewpage.verifyNumericPage(5);
    }

    @Test(priority = 9)
    public void pagi_TC18(){
        System.out.println("PAGI_TC17: Verify that the system still accurately displays the number of pages " +
                "when the total number of items is not divisible by the number of items displayed per page. ");
        viewpage = new ViewPage(driver);
        viewpage.verify(13,4);
    }

    @Test(priority = 9)
    public void pagi_TC19(){
        System.out.println("PAGI_TC17: Verify that the system still accurately displays the number of pages " +
                "when the total number of items divisible by the number of items displayed per page. ");
        viewpage = new ViewPage(driver);
        viewpage.verify(13,4);
    }

    @Test(priority = 9)
    public void pagi_TC20(){
        System.out.println("PAGI_TC16: Verify that the pagination correct display pages " +
                "when total item > item per one page");
        viewpage = new ViewPage(driver);
        viewpage.verifyItemPerPage(14, 4);
    }

    @Test(priority = 4)
    public void first_TC21(){
        System.out.println("FIRST_TC19: Verify that the screen move to first page when user click on first button\n" +
                "1. Click on first button\n");
        viewpage = new ViewPage(driver);
        viewpage.verifyFirstBtn();
    }

    @Test(priority = 7)
    public void previous_TC21(){
        System.out.println("PREVIOUS_TC20: Verify that the screen return to previous page is enable " +
                "when user click on previous button\n" +
                "1. Click on the previous button\n");
        viewpage = new ViewPage(driver);
        viewpage.verifyPreviousBtn();
    }

    @Test(priority = 6)
    public void next_TC22(){
        System.out.println("NEXT_TC21: Verify that the screen move to next page " +
                "when user is on next button\n" +
                "1. Click on the next button\n");
        viewpage = new ViewPage(driver);
        viewpage.verifyNextBtn();
    }

    @Test(priority = 8)
    public void last_TC23(){
        System.out.println("LAST_TC22: Verify that the screen move to last page " +
                "when user is click last button\n" +
                "1. Click on the last button\n");
        viewpage = new ViewPage(driver);
        viewpage.verifyLastBtn();
    }

    @Test(priority = 5)
    public void number_TC24(){
        System.out.println("NUMBER_TC23: Verify that the screen move to another page " +
                "when user click on number button\n" +
                "1. Click on a difference number page\n");
        viewpage = new ViewPage(driver);
        viewpage.verifysecondnumberBtn();
    }



}


