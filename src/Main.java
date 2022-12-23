import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        String driverPath = "your driver path";

        System.setProperty("webdriver.driver.firefox", driverPath);
        WebDriver driver = new FirefoxDriver();

        // Navigating to website and ignoring the cookies
        String url = "https://www.amazon.com/";
        driver.get(url);

        // maximizing the browser window
        driver.manage().window().maximize();

        wait(3);

        // searching random product
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("canon EOS");
        wait(2);
        // click search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        wait(3);

        // finding name and price of every product in the page
        List<WebElement> productNames = driver.findElements(By.className("a-size-medium"));
        List<WebElement> productPrices = driver.findElements(By.className("a-price-whole"));
        List<WebElement> productPriceFraction = driver.findElements(By.className("a-price-fraction"));

        // printing name and price of product
        for(int i = 0; i < productNames.size(); i++){
            System.out.println("Name: " + productNames.get(i).getText());
            System.out.println("Price: " + productPrices.get(i).getText() + "." + productPriceFraction.get(i).getText());
            System.out.println();

        }

    }

    // this function is adding sleep time before executing next line of code
    public static void wait(int second){
        try{
            Thread.sleep(second * 1000);
        }catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        }
    }
}
