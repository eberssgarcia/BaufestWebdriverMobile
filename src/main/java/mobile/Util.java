package mobile;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
    public static void takeScreenShoot() {
        byte[] screenshot = MobileDriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
        ManageScenario.getScenario().attach(screenshot, "image/jpeg", "evidencia");
    }

}
