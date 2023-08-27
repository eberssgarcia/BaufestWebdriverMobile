package mobile;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseView {

    public BaseView() {
        PageFactory.initElements(new AppiumFieldDecorator(MobileDriverManager.getDriver()), this);
    }
}
