package healthcare.equniox;

import org.testng.annotations.Test;

import patientmodule.MMPUtility;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.commons.lang3.EnumUtils;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends sselenium.lib.FrameworkLibrary {
//			id="username"
//			id="password"
//			name="submit"
//			//h3[normalize-space()='Patient Portal']
//
//			String expectedText = "Patient Portal";
	
	@DataProvider(name="DP")
	public String[][] feedData() throws IOException
	{
		String inputData[][] = EnumUtils.getCellData("/Users/kanchanapoojar/IITWorkForceProject2025/equniox/mmpdata.xlsx");
		return inputData;
	}
	
	@Test(dataProvider="DP")
	public void testLogin(String username,String password)
	{
		 
		MMPUtility mmpUtil = new MMPUtility(driver);
		launchBrowser(prop.getProperty("patient_url"));
		mmpUtil.login(username,password);
		String actualText = driver.findElement(By.xpath("//h3[normalize-space()='Patient Portal']")).getText();
		String expectedText = "Patient Portal";
		AssertJUnit.assertEquals(actualText, expectedText);
		launchBrowser(prop.getProperty("patient_url"));
		
		 
	}

}
