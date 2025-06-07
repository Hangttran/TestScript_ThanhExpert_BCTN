package ThanhExpert.Commons;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class Setup {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;// lay gia tri drive tra ve da khoi tao
    }

    @BeforeClass
    public WebDriver setDriver() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8084/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='70%'");
        WebElement Usericon = driver.findElement(By.xpath("//*[@href=\"#loginModal\"]"));
        Usericon.click();
        WebElement Login1 = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        Login1.sendKeys("admin");
        WebElement Password1 = driver.findElement(By.xpath("//*[@name=\"password\"]"));
        Password1.sendKeys("admin123@");
        WebElement Signin = driver.findElement(By.xpath("//div[@id='loginModal']//form//button"));
        Signin.click();
        WebElement droplist = driver.findElement(By.xpath(" //*[@id=\"navbarDropdownMenuLink-4\"]"));
        droplist.click();
        WebElement admin = driver.findElement(By.xpath(" //*[@href=\"/admin\"]"));
        admin.click();
        WebElement users = driver.findElement(By.xpath(" //*[@href=\"/admin/users\"]"));
        users.click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("document.body.style.zoom='70%'");
        return driver;
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        // Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
        // Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        // passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Tạo tham chiếu của TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Gọi hàm capture screenshot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

