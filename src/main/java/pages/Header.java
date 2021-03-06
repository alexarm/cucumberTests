package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.HeaderMenu;
import enums.ServiceMenus;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static enums.Users.USER1;

public class Header {

    @FindBy(css = ".fa-user")
    private SelenideElement userIcon;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".fa-sign-in")
    private SelenideElement signInButton;

    @FindBy(css = ".dropdown a[href='page1.htm']")
    private SelenideElement serviceToggle;

    @FindBy(css = ".m-l8>li")
    private ElementsCollection headerMenus;

    @FindBy(css = ".dropdown-menu>li>a")
    private ElementsCollection serviceMenus;

    public void login(String username, String password){
        userIcon.should(visible).click();
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.should(visible).click();
    }


    public void checkLogin(){
        $(".profile-photo span").shouldBe(visible).should(text(USER1.name));
    }

    public void openMain(Enum<HeaderMenu> page){

    }


    public void open(Enum... pages){
        if (pages.length == 1){
            for (SelenideElement headerMenu: headerMenus){
                if (headerMenu.innerText().equalsIgnoreCase(pages[0].toString())){
                    headerMenu.click();
                }
            }
        }
        else {
            for (SelenideElement serviceMenu : serviceMenus) {
                if (serviceMenu.innerText().equalsIgnoreCase(pages[1].toString())) {
                    serviceToggle.click();
                    serviceMenu.click();
                }
            }
        }
    }

    public void openIndexPage(){
        $("a[href='index.htm']").click();
    }

    public void checkServiceMenu(){
        serviceToggle.click();
        for (SelenideElement serviceMenu: serviceMenus){
            Assert.assertTrue(ServiceMenus.getMenuNames().contains(serviceMenu.getText().toLowerCase()));
        }
    }

    public void openDifferentElementsPage(){
        serviceToggle.click();
        serviceMenus.get(5).click();
    }

    public void openDatesPage(){
        serviceToggle.click();
        serviceMenus.get(1).click();
    }


}
