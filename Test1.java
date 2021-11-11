import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {
    public static void main(String[] args) {
        String pageUrl = "https://rozetka.com.ua/";
        String query = "корм для кота";
        By searchField = By.cssSelector("div input");
        By item = By.cssSelector("a[href^=\"https://rozetka.com.ua/purina_7613033566325/p59052028/\"]");
        By addToCartButton = By.xpath("//*[@class=\"buy-button button button_with_icon button_color_green button_size_large ng-star-inserted\"]");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/Chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get(pageUrl);

            WebDriverWait wait1 = new WebDriverWait(driver, 5);
            wait1.until(ExpectedConditions.elementToBeClickable(searchField));
            WebElement searchInput = driver.findElement(searchField);
            searchInput.sendKeys(query);
            searchInput.sendKeys(Keys.ENTER);

            WebDriverWait wait2 = new WebDriverWait(driver, 7);
            wait2.until(ExpectedConditions.elementToBeClickable(item));
            WebElement wantedItem = driver.findElement(item);
            wantedItem.click();

            WebDriverWait wait3 = new WebDriverWait(driver, 5);
            wait3.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            WebElement buyButton = driver.findElement(addToCartButton);
            buyButton.click();
        } finally {
            driver.quit();
        }
    }
}



