import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basePages {

    protected  WebDriver browser;

    public basePages (WebDriver browser){

        this.browser = browser;
    }

    public String captureTheFlag () {
        return browser.findElement(By.xpath("//*[@id=\"toast-container\"]/div")).getText();
    }

}

