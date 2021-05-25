package core;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage()
    {
        PageFactory.initElements(Driver.get(), this);
    }
    Actions action = new Actions(Driver.get());
}