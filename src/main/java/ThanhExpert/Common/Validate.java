package ThanhExpert.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Validate {
    private static WebDriver driver;

    public Validate(WebDriver _driver) {
        driver = _driver;
    }

    // VALIDATE OF CREATE_NEW_ACCOUNT

//    public String getTitle(By element,String value){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(element)).perform();
//        String tooltip = driver.findElements(element).getAttribute(value);
//        return tooltip;
//    }

    public int getTotalofItemView(By element, By cssselector){
        List<WebElement> all = driver.findElements(cssselector);
        List<WebElement> all1 = driver.findElements(element);
        return all.size() + all1.size();
    }

    public int getTotalofItemCreate(By cssselector){
        List<WebElement> all = driver.findElements(cssselector);
        return all.size();
    }

    public void setText(By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    public void clearText(By element) {
        driver.findElement(element).clear();
    }

    public void clickElement(By element) {
        driver.findElement(element).click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("document.body.style.zoom='70%'");
    }

    public boolean getText(By element, String value) {
        return driver.findElement(element).getText().equals(value);
    }

    public boolean getText2(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public String getText1(By element) {
        return driver.findElement(element).getText().trim();
    }

    public boolean getUrl(String url) {
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);
        return driver.getCurrentUrl().contains(url);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean getNumberofCharacter(By element, int expectedLength) {
        String actualValue = driver.findElement(element).getAttribute("value");
        int actualLength = actualValue != null ? actualValue.length() : 0;
        return actualLength == expectedLength;
    }

    public boolean selectedRadioBtn(By element) {
        boolean radio = driver.findElement(element).isSelected();
        if (radio == true) {
            System.out.println("Radio button can select multiple values");
        } else {
            System.out.println("Radio button select only value");
        }
        return radio;
    }


    // VALIDATE OF VIEW_ACCOUNT

    public boolean verifyStatusDisableBtn(By element) {
        WebElement liElement = driver.findElement(element);
        String classAttr = liElement.getAttribute("class");
        return classAttr != null && classAttr.contains("disabled");
    }

//    public boolean verifyStatusDisableBtn(String buttonvalue) {
//        String xpath = String.format("//li[a[normalize-space(text())='%s']]", buttonvalue);
//        WebElement liElement = driver.findElement(By.xpath(xpath));
//        String classAttr = liElement.getAttribute("class");
//        return classAttr != null && classAttr.contains("disabled");
//    }

    public void getButton(String buttonValue){
        String xpath =  String.format("//li[a[normalize-space(text())='%s']]", buttonValue);
        driver.findElement(By.xpath(xpath)).click();
    }

    public int getTotalItemCount(By element) {
        List<WebElement> items = driver.findElements(element);
        return items.size();
    }

    public boolean verifyNoExtraPageCreated(By allItemLocator, By paginationPageLocator, int maxItemsPerPage) {

        List<WebElement> allItems = driver.findElements(allItemLocator);
        int totalItems = allItems.size();
        System.out.println("Tổng số item: " + totalItems);

   
        List<WebElement> pages = driver.findElements(paginationPageLocator);
        int numericPageCount = 0;
        for (WebElement page : pages) {
            String txt = page.getText().trim();
            if (txt.matches("\\d+")) {
                numericPageCount++;
            }
        }
        System.out.println("Số trang hiển thị trong pagination: " + numericPageCount);

    
        int expectedPageCount = (int) Math.ceil((double) totalItems / maxItemsPerPage);
        System.out.println("Số trang cần thiết: " + expectedPageCount);


        if (numericPageCount <= expectedPageCount) {
            System.out.println("PASSED: Không tạo trang số mới vượt quá số trang cần thiết");
            return true;
        } else {
            System.out.println("FAILED: Pagination tạo trang số vượt quá số trang cần thiết");
            return false;
        }
    }

    public int getValue(By element, String value) {
        List<WebElement> pages = driver.findElements(element);
        int count = 0;
        for (WebElement page : pages) {
            if (page.getText().trim().matches(value)) {
                count++;
            }
        }
        return count;
    }

//    static int expectedPages; //biến toàn cục

    public static int verifyNumberofPage(int total, int item){
        return (int) Math.ceil((double) total / item);
    }

    public int getNumericPage(By element) {
        List<WebElement> pageButtons = driver.findElements(element);
        int numericPageCount = 0;
        for (WebElement page : pageButtons) {
            String txt = page.getText().trim();
            if (txt.matches("\\d+")) {
                numericPageCount++;
            }
        }
        return numericPageCount;
    }

    public static List<Integer> verifyNummeric(By element, int totals, int items) {
        int actual = verifyNumberofPage(totals, items);
        int expectedLastPageRecords = totals % items;
        List<Integer> itemCount = new ArrayList<>();
        for (int page = 1; page <= actual; page++) {
            driver.get("http://localhost:8084/admin/users/page/" + page);
            List<WebElement> record = driver.findElements(element);
            itemCount.add(record.size());
        }
        return itemCount;
    }

    public void submit(By element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(element));
    }

    //setup for view_account
    public void setupData(By element, By element1, By element2,By element3,By element4,By element5,By element6,By element7, By element8,int n,
                          String value,String value1,String value2,String value3,String value4,String value5){
        for (int i = 1; i <= n; i++) {
            String login = value + i;
            String pass = value1;
            String email = value2;
            String name = value3;
            String surname = value4;
            String phone = value5;
            driver.findElement(element).sendKeys(login);
            driver.findElement(element1).sendKeys(pass);
            driver.findElement(element2).sendKeys(email);
            driver.findElement(element3).sendKeys(name);
            driver.findElement(element4).sendKeys(surname);
            driver.findElement(element5).sendKeys(phone);
            driver.findElement(element6).click();
            driver.findElement(element7).click();
            driver.findElement(element8).click();
        }
    }
}




