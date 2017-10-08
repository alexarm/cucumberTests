package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.CheckBoxes;
import enums.Colors;
import enums.RadioButtons;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPage {
    public RightBar rightBar = page(RightBar.class);

    @FindBy(css = ".label-checkbox>input")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio>input")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors select")
    public SelenideElement selectElement;

    public void checkElements(){
        checkBoxes.shouldHaveSize(4);
        for (SelenideElement checkBox: checkBoxes){
            Assert.assertTrue(CheckBoxes.getCheckBoxesLabels().contains(checkBox.closest("label").text().toUpperCase()));
        }

        radioButtons.shouldHaveSize(4);
        for (SelenideElement radioButton: radioButtons){
            Assert.assertTrue(RadioButtons.getRadioLabels().contains(radioButton.closest("label").text().toUpperCase()));
        }

        selectElement.shouldBe(visible);
        ElementsCollection selectOption = $$("select > option");
        for (SelenideElement option: selectOption){
            Assert.assertTrue(Colors.getColors().contains(option.getText()));
        }
    }

    public void setSelect(String element, Boolean bool){
        boolean exist = false;
        SelenideElement setElement = null;
        if (CheckBoxes.getCheckBoxesLabels().contains(element)) {
            for (SelenideElement checkBox : checkBoxes) {
                if (checkBox.closest("label").text().equalsIgnoreCase(element)) {
                    exist = true;
                    setElement = checkBox;
                    break;
                }
            }
        }
        else if (RadioButtons.getRadioLabels().contains(element)){
            for (SelenideElement radioButton : radioButtons) {
                if (radioButton.closest("label").text().equalsIgnoreCase(element)) {
                    exist = true;
                    setElement = radioButton;
                    break;
                }
            }
        }
        else {
            throw new NullPointerException("Element to set not found");
        }
        if (exist){
            setElement.setSelected(bool);
        }
        else {
            throw new NullPointerException("Element to set not found");
        }


    }

    public void checkSelected(String element){
        if (CheckBoxes.getCheckBoxesLabels().contains(element)) {
            for (SelenideElement checkBox : checkBoxes) {
                if (checkBox.closest("label").text().equalsIgnoreCase(element)) {
                    checkBox.shouldBe(selected);
                }
            }
        }
        else if (RadioButtons.getRadioLabels().contains(element)){
            for (SelenideElement radioButton : radioButtons) {
                if (radioButton.closest("label").text().equalsIgnoreCase(element)) {
                    radioButton.shouldBe(selected);
                }
            }
        }
    }

    public void checkUnselected(String element) {
        if (CheckBoxes.getCheckBoxesLabels().contains(element)) {
            for (SelenideElement checkBox : checkBoxes) {
                if (checkBox.closest("label").text().equalsIgnoreCase(element)) {
                    checkBox.shouldNotBe(selected);
                }
            }
        }
        else if (RadioButtons.getRadioLabels().contains(element)){
            for (SelenideElement radioButton : radioButtons) {
                if (radioButton.closest("label").text().equalsIgnoreCase(element)) {
                    radioButton.shouldNotBe(selected);
                }
            }
        }
    }

    public void chooseColor(String color){
        selectElement.selectOption(color);
    }


}
