import enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationTests extends BaseTest {
    final String url = "https://www.google.com";
    final String urlMystore = "http://automationpractice.com/index.php";
    private WebDriver _childWebDriver = get_webDriver(WebDriverType.CHROME);


    //WebDriver _childWebDriver = get_webDriver(WebDriverType.CHROME);
    @Test
    public void testOpenBrowser(){
        _childWebDriver.get(url);
        _childWebDriver.manage().window().maximize();
    }

    @Test
    public void testGetPageTitle(){
        _childWebDriver.get((urlMystore));
        String pageTitleActual = _childWebDriver.getTitle();
        String pageTitleExpected = "My Store";
        System.out.println("Page title is: " + pageTitleActual);
        Assert.assertEquals(pageTitleExpected, pageTitleActual);
    }
    @Test
    public void testGetPageTitleNegative() {
        _childWebDriver.get((urlMystore));
        String pageTitleActual = _childWebDriver.getTitle();
        String pageTitleNotExpected = "My Store ";
        System.out.println("Page title is: " + pageTitleActual);
        Assert.assertNotEquals(pageTitleActual, pageTitleNotExpected);
    }

    @Test
    public void testGetPageTitleFalse() {
        _childWebDriver.get((urlMystore));
        String pageTitleActual = _childWebDriver.getTitle();
        String pageTitleNotExpected = "My Store ";
        System.out.println("Page title is: " + pageTitleActual);
        Assert.assertFalse(urlMystore.equals(pageTitleActual + "?"), "Testing assert false");
    }
}
