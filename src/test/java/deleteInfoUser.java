import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class deleteInfoUser extends basePages {

    public deleteInfoUser(WebDriver browser) {
        super(browser);
    }

    public deleteInfoUser deletInfo (){


        browser.findElement(By.xpath("//span[text()='11111111265968598']/following-sibling::a")).click();
        //aceitando a janela de confirmacao
      //  browser.switchTo().alert().accept();

        return this;
    }
}
