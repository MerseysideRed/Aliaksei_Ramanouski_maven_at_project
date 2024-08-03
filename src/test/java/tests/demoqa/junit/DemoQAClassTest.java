package tests.demoqa.junit;

import org.junit.Test;
import pages.demoqa.MainPage;

import java.io.IOException;

public class DemoQAClassTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    public  void selectTest() throws IOException {
        mainPage.chooseSelectValue("oldSelectMenu", "4");
        mainPage.chooseSelectValue("cars", "saab");
        mainPage.takeScreenshot();
    }
}
