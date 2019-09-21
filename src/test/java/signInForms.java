import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInForms extends basePages {


    public signInForms(WebDriver browser){
        super(browser);
    }

    public  userPage signIn (String login, String  password){

        browser.findElement(By.linkText("Sign in")).click();
        browser.findElement(By.xpath("/html/body/div[4]/div[1]/form/div[2]/div[1]/input")).sendKeys(login);
        browser.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[2]/input")).sendKeys(password);
        browser.findElement(By.xpath("/html/body/div[4]/div[2]/a")).click();

        return new userPage(browser);
    }






}
