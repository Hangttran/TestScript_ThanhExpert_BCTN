package ThanhExpert.Pages;

import ThanhExpert.Common.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ViewPage {
    WebDriver driver;
    private Validate validate;

    public ViewPage(WebDriver driver){
        this.driver = driver;
        validate = new Validate(driver);
    }

    //xpath item
    private By userID = By.xpath("//table//tr[1]/th");
    private By login = By.xpath("//table//tr[1]/th[2]");
    private By password = By.xpath("//table//tr[1]/th[3]");
    private By name = By.xpath("//table//tr[1]/th[4]");
    private By surname = By.xpath("//table//tr[1]/th[5]");
    private By phone = By.xpath("//table//tr[1]/th[6]");
    private By email = By.xpath("//table//tr[1]/th[7]");
    private By role = By.xpath("//table//tr[1]/th[8]");
    private By management = By.xpath("//table//tr[1]/th[9]");

    //selector number of
    private By allItem = By.cssSelector("th, li.page-link, li.page-link.disabled, li.page-link.active," +
            " a.fas.fa-trash-alt.fa-2x.red-text, a.fas fa-trash-alt fa-2x red-text");

    //xpath pagination
    private By firstBtn = By.xpath("//li[a[normalize-space(text())='First']]");
    private By previousBtn = By.xpath("//li[a[normalize-space(text())='Previous']]");
    private By nextBtn = By.xpath("//li[a[normalize-space(text())='Next']]");
    private By lastBtn = By.xpath("//li[a[normalize-space(text())='Last']]");
    private By paginationBtn = By.xpath("//ul[contains(@class, 'pagination')]//a");
    private By showTotalofitem = By.xpath("//ul[contains(@class, 'pagination')]//a");
    private By itemTable = By.xpath("//table/tbody/tr/");
//    private By selector = By.cssSelector("body > div.container-fluid > div:nth-child(4) > nav > ul > li:nth-child(1) > a");
    private By row = By.xpath("//table/tbody/tr");
    private By column = By.xpath("//table/tbody/tr//td[3]");

    //xpath url page of pagination
    private String url1 = "http://localhost:8084/admin/users/page/1";
    private String url2 = "http://localhost:8084/admin/users/page/2";
    private String url3 = "http://localhost:8084/admin/users/page/3";

    public void verifyNameOfItem(){
        Assert.assertEquals(validate.getText1(userID), "User ID",
                "The item name is not 'UserID'");
        Assert.assertEquals(validate.getText1(login), "Login",
                "The item name is not 'Login'");
        Assert.assertEquals(validate.getText1(password), "Password",
                "The item name is not 'Password'");
        Assert.assertEquals(validate.getText1(name), "Name",
                "The item name is not 'Name'");
        Assert.assertEquals(validate.getText1(surname), "Surname",
                "The item name is not 'Surname'");
        Assert.assertEquals(validate.getText1(phone), "Phone",
                "The item name is not 'Phone'");
        Assert.assertEquals(validate.getText1(email), "Email",
                "The item name is not 'Email'");
        Assert.assertEquals(validate.getText1(role), "Role",
                "The item name is not 'Role'");
        Assert.assertEquals(validate.getText1(management), "Management",
                "The item name is not 'Management'");
    }

    public void verifyTotalofItem(int expected){
        Assert.assertEquals(validate.getTotalofItemView(allItem, showTotalofitem), expected);
    }

    public void verifyFirstBtnDisable(){
        Assert.assertTrue(validate.verifyStatusDisableBtn(firstBtn), "The first button is enable");
    }

    public void verifyFirstBtnEnable(){
        validate.getButton("4");
        Assert.assertFalse(validate.verifyStatusDisableBtn(firstBtn), "The first button is enable");;
    }

    public void verifyPreviousBtnDisable(){
        Assert.assertTrue(validate.verifyStatusDisableBtn(previousBtn), "The previous button is enable");
    }

    public void verifyPreviousBtnEnable(){
        Assert.assertFalse(validate.verifyStatusDisableBtn(previousBtn), "The previous button is disable");
    }

    public void verifyNextBtnDisable(){
        Assert.assertTrue(validate.verifyStatusDisableBtn(nextBtn), "The next button is enable");
    }

    public void verifyNextBtnEnable(){
        Assert.assertFalse(validate.verifyStatusDisableBtn(nextBtn), "The next button is disable");
    }

    public void verifyLastBtnDisable(){
        Assert.assertTrue(validate.verifyStatusDisableBtn(lastBtn), "The last button is enable");;
    }

    public void verifyLastBtnEnable(){
        Assert.assertFalse(validate.verifyStatusDisableBtn(lastBtn), "The last button is disable");
    }

    public void verifyPagination(int maxItemPerPage, String value){
        validate.getTotalItemCount(itemTable);
        validate.getValue(paginationBtn, value);
        validate.verifyNoExtraPageCreated(itemTable, paginationBtn, maxItemPerPage);
    }

//    public void verifyPage(int total, int item){
//        Assert.assertTrue(validate.verifyNumericPage(showTotalofitem,total, item), "Incorrect display items per one page");
//    }

    public void verifyItemPerPage(int total, int item){
        Assert.assertEquals(Validate.verifyNumberofPage(total, item),validate.getNumericPage(showTotalofitem), "Incorrect display items per one page");

    }

    public void verify(int total, int item){

        Assert.assertEquals(Validate.verifyNumberofPage(total, item),validate.getNumericPage(showTotalofitem),
                "Incorrect display items per one page");
            List<Integer> counts = validate.verifyNummeric(row, total, item);
            System.out.println(counts);
        for (int i = 0; i < counts.size() - 1; i++){
            System.out.println("Expected: " + item + "\nActual: " + counts.get(i).intValue() );
            Assert.assertEquals(counts.get(i).intValue(), item, "Incorrect number of item per page " + (i+1) +  item);
        }
        System.out.println("Expected: " + total % item+ "\nActual : " + counts.get(counts.size()-1).intValue() );
        Assert.assertEquals(
                counts.get(counts.size()-1).intValue(), total % item,
                "Trang cuối không hiển thị đúng số bản ghi còn lại"
        );
    }

    public void verifyFirstBtn(){
        validate.getButton("1");
//        validate.clickElement(By.xpath("xpath"));
        validate.getUrl(url1);
    }

    public void verifyPreviousBtn(){
        validate.getButton("2");
//        validate.clickElement(By.xpath("xpath"));
        validate.getUrl(url1);
    }

    public void verifyNextBtn(){
        validate.clickElement(nextBtn);
        validate.getUrl(url3);
    }

    public void verifyLastBtn(){
        validate.clickElement(nextBtn);
        validate.getUrl(url3);
    }

    public void verifysecondnumberBtn(){
        validate.getButton("2");
//        validate.clickElement(By.xpath("xpath"));
        validate.getUrl(url2);
    }

    public static int getTotalItemCount(WebDriver driver, By recordSelector, int totalPages, String baseUrl) {
        int totalCount = 0;
        for (int page = 1; page <= totalPages; page++) {
            driver.get(baseUrl + "?page=" + page);
            List<WebElement> items = driver.findElements(recordSelector);
            totalCount += items.size();
        }
        return totalCount;
    }

    public void verifyNumericPage(int expected){
        System.out.println("Pages number of pagination is: " + validate.getNumericPage(showTotalofitem));
        Assert.assertEquals(validate.getNumericPage(showTotalofitem), expected, "The page number of incorrect");

    }



}
