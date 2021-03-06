package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.TextsUnderPictures;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static enums.TextsAbove.*;

public class IndexPage{
    public LeftBar leftBar = page(LeftBar.class);

    @FindBy(css = ".icons-benefit")
    private ElementsCollection mainIcons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderPictures;

    public void open(){
        Selenide.open("/");
    }


    public void checkPictures(){
        for (SelenideElement icon: mainIcons){
            icon.should(visible);
        }
    }

    public void checkTextsUnderPictures(){

        for(SelenideElement text: textsUnderPictures){
            Assert.assertTrue(TextsUnderPictures.getTexts().contains(text.getText()));
        }

    }

    public void checkTextsAbove(){
        $(".main-title").should(visible).should(text(MAIN_TITLE.text));
        $(".main-txt").should(visible).should(text(MAIN_TXT.text));
    }

    public void checkInterface(){
        this.checkPictures();
        this.checkTextsUnderPictures();
        this.checkTextsAbove();
    }
}

