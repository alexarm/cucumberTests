package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceMenus;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LeftBar {

    @FindBy(css = ".sub-menu")
    private SelenideElement serviceToggle;

    @FindBy(css = ".sub>li>a>p>span")
    private ElementsCollection serviceMenus;

    public void checkServiceMenu(){
        serviceToggle.click();

        for (SelenideElement serviceMenu: serviceMenus){
            Assert.assertTrue(ServiceMenus.getMenuNames().contains(serviceMenu.getText().toLowerCase()));
        }

    }
}
