package org.automation.pages;

import org.automation.base.BasePage;
import org.openqa.selenium.By;

public class HamburgerMenu extends BasePage {

    public By hamburgerButton = By.xpath("//i[@class='hamburger align-self-center']");
        public void clickHamburgerButton(){
            clickBtn(hamburgerButton);
        }



}
