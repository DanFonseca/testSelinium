import Report.Generator;
import Report.Screenshot;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "D:\\Alura\\SeleniumTest\\src\\test\\java\\resources\\infUser.csv")

public class testeUtilizandoSelenium {
    private WebDriver browser;

    @Rule
    public TestName nomeClasse = new TestName();

    @Before
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //acessando a página julio
        browser.get("http://www.juliodelima.com.br/taskit");
        //logar no site
        browser.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li/a")).click();
        //colocar usuario
        browser.findElement(By.xpath("/html/body/div[4]/div[1]/form/div[2]/div[1]/input")).sendKeys("julio0001");
        //colocar senha
        browser.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[2]/input")).sendKeys("123456");
        //ir em signin
        browser.findElement(By.xpath("/html/body/div[4]/div[2]/a")).click();

    }

    @Test
    public void adicionarInfor(@Param(name = "tipo")String tipo, @Param(name = "contact") String contact) {


        //clicar no nome do usuario
        browser.findElement(By.className("me")).click();
        //clicar em morea bout you
        browser.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
        //add more data
        browser.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        //maximizando a janela
        //browser.manage().window().maximize();

        //selecionar fone
        WebElement comboBox = browser.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[2]/select"));
        new Select(comboBox).selectByVisibleText(tipo);

        //adicionar nova info
        browser.findElement(By.name("contact")).sendKeys(contact);

        //clicar em salvar
        browser.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[2]/a")).click();



    }

    //@Test
    public void deletarContent () throws Exception {

        //selecionando um botao delete
        browser.findElement(By.xpath("//span[text()='5581999999999']/following-sibling::a")).click();
        //aceitando a janela de confirmacao
        browser.switchTo().alert().accept();

        String texto = browser.findElement(By.xpath("//*[@id='toast-container']/div")).getText();

        Generator gn =  new Generator();
        String nomeArq = gn.Getdatahora();
        Screenshot s = new Screenshot();

        s.tirarFoto(browser, "D:\\" + nomeArq + nomeClasse);

        //browser.findElement(By.id("logout")).click();

    }

@After
    public void tearDown (){
        browser.quit();
}

}
