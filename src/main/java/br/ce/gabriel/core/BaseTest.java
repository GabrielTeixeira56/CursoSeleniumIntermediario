package br.ce.gabriel.core;

import static br.ce.gabriel.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(
				"target/screenshot/" + testName.getMethodName() + ".jpg"));

		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
