import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.testng.Assert;

public class JawyTvPage {

        @FindBy(xpath = "//*[@id='translation-btn'] ")
        public WebElement languageButton;

        @FindBy(xpath = "//*[@id='currency-lite']/b")
        public WebElement litePrice;

        @FindBy(xpath = "//*[@id='currency-classic']/b")
        public WebElement classicPrice;

        @FindBy(xpath = "//*[@id='currency-premium']/b")
        public WebElement premiumPrice;

        @FindBy(id = "name-lite")
        public WebElement liteTypePlan;

        @FindBy(id = "name-classic")
        public WebElement classicTypePlan;

        @FindBy(id = "name-premium")
        public WebElement premiumTypePlan;

        @FindBy(id = "arrow")
        public WebElement listOfCountriesbutton;

        @FindBy(xpath = "//*[@id='country-selct']/a")
        public List<WebElement> listOfCountries;

        @FindBy(id = "currency-lite")
        public WebElement litePriceCurrency;

        @FindBy(id = "currency-classic")
        public WebElement classicPriceCurrency;

        @FindBy(id = "currency-premium")
        public WebElement premiumPriceCurrency;

        public JawyTvPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
        public void chooseSpeceficCountry(int i, WebDriver driver){
            WebElement element = driver.findElement(By.xpath("(//*[@id='country-selct']/a)["+i+"]"));
            element.click();
        }
        public String getNameOfChosenCountry(int i, WebDriver driver){
        WebElement element = driver.findElement(By.xpath("(//*[@id='country-selct']/a)["+i+"]"));
        return element.getText();
        }

    }

