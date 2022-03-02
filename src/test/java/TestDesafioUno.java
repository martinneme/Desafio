import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class TestDesafioUno {
    private String URLMarket = PropertiesFile.getProperty("URLdemo");
    private WebDriver driver = DriverFactory.getWebDriverBrowser();


    @Test
    public void NavigateToMarketDemoblaze() throws InterruptedException {
        driver.navigate().to(URLMarket);
        driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[class='hrefch']")).click();
        Thread.sleep(5000);
        String nameProd = driver.findElement(By.cssSelector("h2[class='name']")).getText();
        String  priceProd = driver.findElement(By.cssSelector("h3[class='price-container']")).getText();
        System.out.println("El producto "+nameProd+" cuesta "+priceProd.substring(0,4));
        driver.findElement(By.cssSelector("a[class*='btn']")).click();
        Thread.sleep(2000);
        String MsjPrompt = driver.switchTo().alert().getText();
        Assert.assertEquals("Product added",MsjPrompt);

        driver.quit();
    }



}
