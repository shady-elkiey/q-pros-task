import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.*;

public class Util {

        private Util() {

        }
        public static void takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
                TakesScreenshot srcShot = ((TakesScreenshot) driver);
                File srcFile = srcShot.getScreenshotAs((OutputType.FILE));
                File destFile = new File(System.getProperty("user.dir")+ "/src/main/resources/screenshots"+ screenshotName+ ".png");
                FileHandler.copy(srcFile, destFile);

        }
        public static JsonObject getJsonObject(String path) throws FileNotFoundException {
            return JsonParser.parseReader(new FileReader(path)).getAsJsonObject();
        }
    }


