import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class addMoreInformation extends basePages {


    public addMoreInformation(WebDriver browser) {
        super(browser);
    }

    public addMoreInformation moreAboutYou (){
        browser.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
        return new addMoreInformation(browser);
    }

    public addMoreInformation addMoreDataButton (){
        browser.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();
        return new addMoreInformation(browser);
    }

    public addMoreInformation selectDropDownItem (String type){
        Select drpDownItem = new Select(browser.findElement(By.name("type")));
        drpDownItem.selectByVisibleText(type);
        return new addMoreInformation(browser);
    }

    public deleteInfoUser insertContactInfo (String contact ){
        browser.findElement(By.name("contact")).sendKeys(contact);
        browser.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[2]/a")).click();
        return new deleteInfoUser(browser);
    }
}
