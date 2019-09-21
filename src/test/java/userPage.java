import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class userPage extends basePages {

    public userPage(WebDriver browser) {
        super(browser);
    }

    public addMoreInformation clickMePage(){

        browser.findElement(By.className("me")).click();
        return new addMoreInformation(browser);
    }


}
