package ui.drivers;

import com.google.common.base.Supplier;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static final Supplier<WebDriver> chromeSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };
    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };
    private static final Supplier<WebDriver> edgeSupplier = () ->{
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    };
    private static final Map<Browsers, Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put(Browsers.CHROME,chromeSupplier);
        MAP.put(Browsers.FIREFOX,firefoxSupplier);
        MAP.put(Browsers.EDGE,edgeSupplier);
    }

    public static WebDriver getDriver(Browsers browser){
        return MAP.get(browser).get();
    }
}
