package com.bdmysql.utils.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriversManager {

	public static WebDriver driver;

	public static WebDriver abrirBrowser(String browser) {		

		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();					
			
//			options.addArguments("--headless"); // executa sem abrir o browser
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-infobars"); // barra de informação
			options.addArguments("--enable-javascript");
			options.addArguments("--test-type");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-web-security");
			options.addArguments("-force-device-scale-factor=1.0"); // escala
			options.addArguments("--lang=pt-BR");
			options.addArguments("--disable-geolocation");
			options.addArguments("enable-automation");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			options.addArguments("--allow-running-insecure-content");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		} else {			
			System.out.println("Não foi possível abrir o browser escolhido");		
		}
		
		driver.manage().window().maximize();
		return driver;
	}
}



