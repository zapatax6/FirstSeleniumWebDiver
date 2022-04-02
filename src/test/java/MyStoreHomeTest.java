import enums.WebDriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStoreHomeTest extends BaseTest{

    final String urlMystore = "http://automationpractice.com/index.php";
    private WebDriver _childWebDriver = get_webDriver(WebDriverType.CHROME);

    final String logoCSSLocator ="div#header_logo";
    final String logoCSSLocatorFalse ="div.header_logo";
    final String carritoLocator = "div.shopping_cart > a";
    final String searchBoxLocator = "div > form#searchbox";
    final String searchTextBoxIdLocator = "search_query_top";
    final String btnSearchButtonCSSLocator = "form#searchbox > button";
    //final String alertSearchResultCSSLocator = "div#"
    //private WebDriver _childWebDriver = webDriver;

    @Test
    public void testSearchFirstElement() {
        openMyStore();
        WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
        System.out.println(logo.isDisplayed());
    }
    @Test
    public void testManejoDeExceptions() {
        openMyStore();
        try {
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocatorFalse));
            System.out.println("Codigo Try" + logo.isDisplayed());
        } catch (NoSuchElementException logoNoLocalizado) {
            System.out.println("El Localizador" + logoCSSLocatorFalse + "no funsiona");
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
            System.out.println("El logo se esta mostrando: " + logo.isDisplayed());
        }
    }
        @Test
        public void testManejoDeExceptions2 () {
            openMyStore();
            try {
                WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
                Assert.assertTrue(logo.isDisplayed(),"Mensaje de error");
                System.out.println("El elemento fue localizado usando: " +logoCSSLocator);
            } catch (NoSuchElementException elementoNoLocalizado) {
                Assert.fail("El elemento no fue encontrado con el localizador: " + logoCSSLocatorFalse);
            }
        }

        //1. Abrir My Store
        //2. Click en carrito
        //3. Verificar que la URL que se abre es:
        @Test
        public void testOpenBrowser1(){
            openMyStore();
            _childWebDriver.manage().window().maximize();
        }
    @Test
    public void testClickCarrito(){
        openMyStore();
        _childWebDriver.manage().window().maximize();
        WebElement carrito = _childWebDriver.findElement(By.cssSelector(carritoLocator));
        carrito.click();
        System.out.println("El elemento fue localizado con el localizador: " + carritoLocator);

    }
    @Test
    public void testValidateURL(){
        openMyStore();
        _childWebDriver.manage().window().maximize();
        WebElement carrito = _childWebDriver.findElement(By.cssSelector(carritoLocator));
        System.out.println("El elemento fue localizado con el localizador: " + carritoLocator);

    }

    @Test
    public void testSearchBoxPresent(){
        openMyStore();
        WebElement searchBox = _childWebDriver.findElement(By.cssSelector(searchBoxLocator));
        Assert.assertTrue(searchBox.isDisplayed());


    }

    @Test
    public void testSendTextToSearchTextBox(){
        openMyStore();
        WebElement searchTextBox = _childWebDriver.findElement(By.id(searchTextBoxIdLocator));
        WebElement buttonSearch = _childWebDriver.findElement(By.cssSelector(btnSearchButtonCSSLocator));

        //Variables que se van a usar en la prueba
       //searchTextBox.sendKeys("Women");
        String textToSearch = "women";

       //Acciones o pasos de prueba
        //openMyStore();
        searchTextBox.sendKeys(textToSearch);
        buttonSearch.click();

        SearchResultPage resultsPage = new SearchResultPage(_childWebDriver);
        Boolean resultsDisplayed = resultsPage.verifySearchResults();

        System.out.println("Results displayed : " + resultsDisplayed);

    }
        private void openMyStore () {
            _childWebDriver.get(urlMystore);
            System.out.println("El navegador a abierto la URL" + urlMystore);
        }

}
