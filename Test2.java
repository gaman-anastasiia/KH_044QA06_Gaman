import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {
    public static void main (String [] args){
        String pageUrl = "https://rozetka.com.ua/";
        By catalogButton = By.xpath("//*[@class=\"button button--medium button--with-icon menu__toggle ng-star-inserted\"]");
        By monitorsSection = By.xpath("//rz-header/header/div/div/rz-header-fat-menu/fat-menu/div/ul/li[1]/div/div[2]/div[1]/div[2]/ul[2]/li/ul/li[1]/a");
        By sellerFilters = By.xpath("//div[2]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-checkbox/ul[1]/li[1]/a/label");
        By item = By.xpath("//*[@href=\"https://hard.rozetka.com.ua/samsung_lc27g54tqwixci/p250703981/\"]");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/Chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get(pageUrl);
            WebElement catalog = driver.findElement(catalogButton);
            catalog.click();

            WebDriverWait wait1 = new WebDriverWait(driver, 5);
            wait1.until(ExpectedConditions.elementToBeClickable(monitorsSection));
            WebElement monitors = driver.findElement(monitorsSection);
            monitors.click();

            WebDriverWait wait2 = new WebDriverWait(driver,7);
            wait2.until(ExpectedConditions.elementToBeClickable(sellerFilters));
            WebElement rozetkaSeller = driver.findElement(sellerFilters);
            rozetkaSeller.click();

            WebDriverWait wait3 = new WebDriverWait(driver,7);
            wait3.until(ExpectedConditions.elementToBeClickable(item));
            WebElement firstItem = driver.findElement(item);
            firstItem.click();
        }
        finally {
            driver.quit();
        }

    }
}
