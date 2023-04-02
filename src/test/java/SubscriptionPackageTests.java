import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.management.snmp.jvminstr.JvmOSImpl;

import java.io.FileNotFoundException;

public class SubscriptionPackageTests extends BaseTest {
    private JawyTvPage jawyTvPage;
    private JsonObject userInfo;

    @BeforeClass
    public void init() throws FileNotFoundException {
        jawyTvPage = new JawyTvPage(driver);
        userInfo = Util.getJsonObject("src/main/resources/Info.json");
    }

    @BeforeMethod
    public void navigateToSauceDemo() {
        driver.get(userInfo.get("url").getAsString());
    }

    /**
     * A test case to validate subscription packages(Lite, Classic, and Premium)
     */
    @Test
    public void VerifySubscriptionTypesAreDsiplayedAsExpectedForAllCountries() {
        jawyTvPage.languageButton.click();
        int size = jawyTvPage.listOfCountries.size();
        for (int i = 1; i <= size; i++) {
            jawyTvPage.listOfCountriesbutton.click();
            jawyTvPage.chooseSpeceficCountry(i, driver);
            Assert.assertEquals(jawyTvPage.liteTypePlan.getText(), "LITE");
            Assert.assertEquals(jawyTvPage.classicTypePlan.getText(), "CLASSIC");
            Assert.assertEquals(jawyTvPage.premiumTypePlan.getText(), "PREMIUM");
        }
    }

    /**
     * A test case to validate subscription price and currency
     */
    @Test
    public void VerifyPricesAndCurrencyAreDisplayedAsExpectedForAllCountries() {
        jawyTvPage.languageButton.click();
        int size = jawyTvPage.listOfCountries.size();
        for (int i = 1; i <= size; i++) {
            jawyTvPage.listOfCountriesbutton.click();
            String countryName = jawyTvPage.getNameOfChosenCountry(i, driver);
            jawyTvPage.chooseSpeceficCountry(i, driver);
            if (countryName.equalsIgnoreCase("Egypt")) {
                checkPriceAndCurrency("0.25 USD/month", "0.5 USD/month", "1 USD/month");
            } else if (countryName.equalsIgnoreCase("UAE")) {
                checkPriceAndCurrency("5.4 USD/month", "10.9 USD/month", "16.3 USD/month");
            } else if (countryName.equalsIgnoreCase("Algeria")) {
                checkPriceAndCurrency("2.7 USD/month", "5.3 USD/month", "8 USD/month");
            } else if (countryName.equalsIgnoreCase("Djibouti")) {
                checkPriceAndCurrency("2.4 USD/month", "4.8 USD/month", "7.2 USD/month");
            } else if (countryName.equalsIgnoreCase("Chad")) {
                checkPriceAndCurrency("2.4 USD/month", "4.8 USD/month", "7.2 USD/month");
            } else if (countryName.equalsIgnoreCase("Iraq")) {
                checkPriceAndCurrency("2.4 USD/month", "4.1 USD/month", "6.2 USD/month");
            } else if (countryName.equalsIgnoreCase("Jordan")) {
                checkPriceAndCurrency("2.7 USD/month", "5.2 USD/month", "8 USD/month");
            } else if (countryName.equalsIgnoreCase("Lebanon")) {
                checkPriceAndCurrency("2.4 USD/month", "4.8 USD/month", "7.2 USD/month");
            } else if (countryName.equalsIgnoreCase("Morocco")) {
                checkPriceAndCurrency("2 USD/month", "3.9 USD/month", "5.8 USD/month");
            } else if (countryName.equalsIgnoreCase("Oman")) {
                checkPriceAndCurrency("5 USD/month", "10 USD/month", "15 USD/month");
            } else if (countryName.equalsIgnoreCase("Tunisia")) {
                checkPriceAndCurrency("1.7 USD/month", "3.4 USD/month", "5.8 USD/month");
            } else if (countryName.equalsIgnoreCase("Yemen")) {
                checkPriceAndCurrency("2.4 USD/month", "4.8 USD/month", "7.2 USD/month");
            } else {
                checkPriceAndCurrency("2.4 USD/month", "4.8 USD/month", "7.2 USD/month");
            }
        }

    }
    @Test
    public void verifyThatPremiumPriceIsGreaterThanClassicAndClassicIsGreaterThanLite(){
        jawyTvPage.languageButton.click();
        int size = jawyTvPage.listOfCountries.size();
        for (int i = 1; i <= size; i++) {
            jawyTvPage.listOfCountriesbutton.click();
            jawyTvPage.chooseSpeceficCountry(i, driver);
            Assert.assertTrue(Double.parseDouble(jawyTvPage.premiumPrice.getText())>Double.parseDouble(jawyTvPage.classicPrice.getText()));
            Assert.assertTrue(Double.parseDouble(jawyTvPage.classicPrice.getText())>Double.parseDouble(jawyTvPage.litePrice.getText()));
        }
    }

    private void checkPriceAndCurrency(String litePriceCurrency, String classicPriceCurrency, String premiumPriceCurrency) {
        Assert.assertEquals(jawyTvPage.litePriceCurrency.getText(), litePriceCurrency);
        Assert.assertEquals(jawyTvPage.classicPriceCurrency.getText(), classicPriceCurrency);
        Assert.assertEquals(jawyTvPage.premiumPriceCurrency.getText(), premiumPriceCurrency);
    }
}

