package steps;

import com.codeborne.selenide.Configuration;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.HeaderMenu;
import pages.DatesPage;
import pages.DifferentElementsPage;
import pages.Header;
import pages.IndexPage;

import static com.codeborne.selenide.Selenide.page;
import static enums.HeaderMenu.*;
import static enums.ServiceMenus.DIFFERENT_ELEMENTS;

public class Steps {

    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;
    private DatesPage datesPage;
    private Header header;

    @Before
    public void setUp(){
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1440x900";
        Configuration.baseUrl = "https://jdi-framework.github.io/tests";

        indexPage = page(IndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
        datesPage = page(DatesPage.class);
        header = page(Header.class);
    }

    @When("^I open Index page$")
    public void openIndexPage(){
        indexPage.open();
        header.open(HOME);
    }

    @When("^I login as (.*)/(.*)$")
    public void login(String name, String password){
        header.login(name, password);
    }

    @Then("^I am loginned$")
    public void checkLogin(){
        header.checkLogin();
    }


    @Then("^all interface elements on login page are correct and available$")
    public void allInterfaceElementsAreAvailable(){
        indexPage.checkInterface();
    }

    @Then("service menus are correct")
    public void serviceMenuAreCorrect(){
        header.checkServiceMenu();
        indexPage.leftBar.checkServiceMenu();
    }

    @When("I open Different elements page")
    public void openDifferentelementsPage(){
        header.open(SERVICE, DIFFERENT_ELEMENTS);
    }

    @Then("all elements are available")
    public void allElementsAreAvailable(){
        differentElementsPage.checkElements();
    }

    @When("I select (.*)")
    public void selectElement(String element){
        differentElementsPage.setSelect(element, true);
    }

    @Then("(.*) is selected")
    public void checkSelected(String element){
        differentElementsPage.checkSelected(element);
    }

    @Then("Log has info that (.*) is (.*)")
    public void checkBoxesLog(String element, boolean bool){
        differentElementsPage.rightBar.checkLog(element, bool);
    }

    @Then("Log has info that metal value changed to (.*)")
    public void radioButtonLog(String element) {
        differentElementsPage.rightBar.checkLog(element);
    }

    @Then("Log has info that color value changed to (.*)")
    public void colorLog(String color){
        differentElementsPage.rightBar.checkLog(color);
    }

    @When("I choose (.*) color")
    public void chooseColor(String color){
        differentElementsPage.chooseColor(color);
    }

    @When("I unselect (.*)")
    public void unselectElement(String element){
        differentElementsPage.setSelect(element, false);
    }

    @Then("(.*) is unselected")
    public void checkUnselected(String element){
        differentElementsPage.checkUnselected(element);
    }
}
