import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "D:\\Alura\\SeleniumTest\\src\\test\\java\\resources\\infUser.csv")

public class registerUserTest {
    private WebDriver browser;

    @Before
    public void setUp() {

        browser = new ChromeDriver();
        browser.get("http://www.juliodelima.com.br/taskit");
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void login(
            @Param(name = "tipo") String tipo,
            @Param(name = "contact") String contact,
            @Param(name = "login") String login,
            @Param(name = "senha") String senha) {

        String statu = new signInForms(browser).signIn(login, senha)
                 .clickMePage()
                 .moreAboutYou()
                 .addMoreDataButton()
                 .selectDropDownItem(tipo)
                .insertContactInfo(contact).captureTheFlag();
        String msg =  new deleteInfoUser(browser).deletInfo().captureTheFlag();
        System.out.println(statu);
        System.out.println(msg);

    }

   // @Test
    public void testDeleteuser (){

    }

    //@After
    public void tearDown (){
        browser.quit();
    }
}
