package Report;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.*;

public class Screenshot {

    public  void tirarFoto (WebDriver browser, String arq) throws Exception{
        File screenshot = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File (arq));
    }


}
