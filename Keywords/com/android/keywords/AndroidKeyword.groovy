package com.android.keywords

import java.awt.image.BufferedImage
import java.time.Duration

import javax.imageio.ImageIO

import org.apache.commons.io.FileUtils
import org.openqa.selenium.Dimension
import org.openqa.selenium.OutputType
import org.openqa.selenium.Point
import org.openqa.selenium.TakesScreenshot

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption

public class AndroidKeyword {

	public static AppiumDriver<?> addriver = MobileDriverFactory.getDriver()

	String path
	String testCaseName
	String filePath


	@Keyword
	public static void Resetapk() {

		MobileDriver<MobileElement> driver = MobileDriverFactory.getDriver()
		driver.resetApp()
		//driver.closeApp()

		//After reset APK using this keyword AfterReset_Login()
	}


	//Last Elements
	@Keyword
	public static void MobileElement(String resourceid,String countHeader, String ElementHeader){
		//	AppiumDriver<?> addriver = MobileDriverFactory.getDriver()

		List<MobileElement> elements=addriver.findElementsById(resourceid)

		int count = elements.size()

		String TotalCount = countHeader + count

		println(TotalCount)

		for (int i=0; i< count; i++){
			MobileElement element = elements.get(i)
			String text = element.getText()

			String Elementtitle = ElementHeader + text

			println(Elementtitle)
		}

	}


	@Keyword
	public static String  gettext(String resourceid){
		//	AppiumDriver<?> addriver = MobileDriverFactory.getDriver()

		MobileElement  element = addriver.findElementById(resourceid)


		println element

		String elementText= element.getText()

		return elementText

	}






	//Top to bottom swipe
	@Keyword
	public static void swipeTopToBottom(){

		AppiumDriver<?> addriver = MobileDriverFactory.getDriver()

		Dimension dimension = addriver.manage().window().getSize()

		int start_x = ((dimension.width * 0.5) as int)

		int start_y = ((dimension.height * 0.8) as int)

		int end_x = ((dimension.width * 0.2) as int)

		int end_y = ((dimension.height * 0.2) as int)

		TouchAction touch = new TouchAction(addriver)

		touch.press(PointOption.point(start_x, end_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(
				start_x, start_y)).release().perform()

	}

	//Right Swipe
	@Keyword
	public static void swipeRight(){


		Dimension dimension = addriver.manage().window().getSize()

		int start_x = ((dimension.width * 0.5) as int)

		int start_y = ((dimension.height * 0.8) as int)

		int end_x = ((dimension.width * 0.2) as int)

		int end_y = ((dimension.height * 0.2) as int)

		TouchAction touch = new TouchAction(addriver)

		touch.press(PointOption.point(start_x, end_x)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(
				end_x, end_y)).release().perform()

	}


	//Swipe Bottom To Top
	@Keyword
	public static void swipeBottomToTop(){

		AppiumDriver<?> addriver = MobileDriverFactory.getDriver()

		Dimension dim = addriver.manage().window().getSize()

		Double shStart = dim.getHeight() * 0.5

		int sStart = shStart.intValue()

		Double shEnd = dim.getHeight() * 0.2

		int sEnd = shEnd.intValue()

		TouchAction ta = new TouchAction(addriver)

		ta.press(PointOption.point(0, sStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(
				0, sEnd)).release().perform()

	}


	@Keyword
	public static String elementScreenshot(MobileDriver<MobileElement> driver, MobileElement ele,String imagename)
	{

		File screenshotLocation = null;
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			BufferedImage  fullImg = ImageIO.read(scrFile);

			Point point = ele.getLocation();

			int eleWidth = ele.getSize().getWidth()
			int eleHeight = ele.getSize().getHeight()

			BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,
					eleHeight)
			ImageIO.write(eleScreenshot, "png", scrFile)

			String path = "screenshots/" +imagename + "" + ".png"


			screenshotLocation = new File(System.getProperty("user.dir") + "/" + path)
			FileUtils.copyFile(scrFile, screenshotLocation)


			println(screenshotLocation.toString())


		} catch (IOException e) {
			e.printStackTrace()
		}
		return screenshotLocation.toString()


	}


}
