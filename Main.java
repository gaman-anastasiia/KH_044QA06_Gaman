import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;

public class Main {
public static void main (String [] args){
    System.setProperty("webdriver.chrome.driver", "src/main/resources/Chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    try {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement searchField = driver.findElement(By.xpath("//div[1]/div[1]/div/div[2]/input"));
        searchField.sendKeys("rozetka ua");
        searchField.sendKeys(Keys.ENTER);
        WebElement searchPage = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        searchPage.click();
        WebElement searchProductField = driver.findElement(By.xpath("//form/div/div/input"));
        searchProductField.sendKeys("тостер");
        searchProductField.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement findFirstItem = driver.findElement(By.cssSelector("body > app-root > div > div > rz-category > div > main > rz-catalog > div > div > section > rz-grid > ul > li:nth-child(1) > app-goods-tile-default > div > div.goods-tile__inner > a.goods-tile__picture.ng-star-inserted"));
        findFirstItem.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement addToCart = driver.findElement(By.xpath("//div[1]/div/ul/li[1]/app-product-buy-btn/app-buy-button/button"));
        addToCart.click();

    }finally {
        driver.quit();
    }
}
}
