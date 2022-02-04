package anen

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.awt.Desktop.Action

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverCommand
import org.openqa.selenium.chrome.ChromeDriverCommandExecutor
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.xpath.internal.compiler.Keywords

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

public class webUILogin04 {

	@Keyword
	public void sabari_salesLogin() {



		System.setProperty('webdriver.chrome.driver', GlobalVariable.chromedriverpath)

		WebDriver driver = new ChromeDriver()

		DriverFactory.changeWebDriver(driver)

		driver.manage().window().maximize()


		driver.get('https://bimbo-mx-02-qa.ivycpg.com/web/DMS')

		String logintext= WebUI.getText(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/webUI_png02/Click to Login'), FailureHandling.STOP_ON_FAILURE)

		println logintext

		if(WebUI.verifyElementVisible(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/webUI_png02/Click to Login'), FailureHandling.STOP_ON_FAILURE))


			WebUI.click(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/webUI_png02/Click to Login'))

		WebUI.sendKeys(findTestObject('Phase 2.4/Surendran/Web/Login/input_User Name_UserName'), 'vishnu.L2')

		WebUI.setText(findTestObject('Phase 2.4/Surendran/Web/Login/input__Password'), '1')

		WebUI.click(findTestObject('Phase 2.4/Surendran/Web/Login/button_Login'))

		WebUI.waitForPageLoad(5)
	}


	@Keyword
	public void l1_Login() {



		System.setProperty('webdriver.chrome.driver', GlobalVariable.chromedriverpath)

		WebDriver driver = new ChromeDriver()

		DriverFactory.changeWebDriver(driver)

		driver.manage().window().maximize()


		driver.get('https://bimbo-mx-02-qa.ivycpg.com/web/DMS')

		//		String logintext= WebUI.getText(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/webUI_png02/Click to Login'), FailureHandling.STOP_ON_FAILURE)
		//
		//		println logintext

		//		if(WebUI.verifyElementVisible(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/webUI_png02/Click to Login'), FailureHandling.STOP_ON_FAILURE))


		//			WebUI.click(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/webUI_png02/Click to Login'))

		WebUI.setText(findTestObject('Phase 1.1/Resource1/Web/Login Screen/input_Username'), 'l1_user')

		WebUI.sendKeys(findTestObject('Phase 1.1/Resource1/Web/Login Screen/input_Password'), 'password1')



		WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Login Screen/button_Login'))

		WebUI.waitForPageLoad(5)
	}


	@Keyword
	public void catalog_Login() {



		System.setProperty('webdriver.chrome.driver', GlobalVariable.chromedriverpath)

		WebDriver driver = new ChromeDriver()

		DriverFactory.changeWebDriver(driver)

		driver.manage().window().maximize()


		driver.get('https://bimbo-mx-02-qa.ivycpg.com/web/DMS')

		//		String logintext= WebUI.getText(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/webUI_png02/Click to Login'), FailureHandling.STOP_ON_FAILURE)
		//
		//		println logintext

		//		if(WebUI.verifyElementVisible(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/webUI_png02/Click to Login'), FailureHandling.STOP_ON_FAILURE))


		//			WebUI.click(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/webUI_png02/Click to Login'))

		WebUI.setText(findTestObject('Phase 1.1/Resource1/Web/Login Screen/input_Username'), 'bimbo_catalog')

		WebUI.sendKeys(findTestObject('Phase 1.1/Resource1/Web/Login Screen/input_Password'), 'password1')



		WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Login Screen/button_Login'))

		WebUI.waitForPageLoad(5)
	}

	@Keyword
	public void launchMobile_sabari_sales() {

		import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
		import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
		import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
		import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
		import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
		import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
		import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
		import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
		import com.kms.katalon.core.model.FailureHandling as FailureHandling
		import com.kms.katalon.core.testcase.TestCase as TestCase
		import com.kms.katalon.core.testdata.TestData as TestData
		import com.kms.katalon.core.testobject.TestObject as TestObject
		import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
		import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
		import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
		import internal.GlobalVariable as GlobalVariable

		Mobile.startApplication('C:\\Users\\anen.shyil\\Katalon Studio\\Png Mobile Testing\\PNGIndia_Mobile_Testing 2.4\\APK File\\Phase 3\\Phase 3.2\\IvyDMS_PNGIndia_140_5958.apk',
				false)

		if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase 3/Phase 3.2/Call Test Case/Allow_button_1'), 0,
		FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Phase 3/Phase 3.2/Call Test Case/Allow_button_1'), 0)

			Mobile.tap(findTestObject('Object Repository/Phase 3/Phase 3.2/Call Test Case/Allow_button_1'), 0)
		}

		if (Mobile.verifyElementVisible(findTestObject('Phase 3/Phase 3.2/Call Test Case/Activation Key'), 0, FailureHandling.OPTIONAL)) {
			Mobile.sendKeys(findTestObject('Phase 3/Phase 3.2/Call Test Case/Activation Key'), 'X9F28VIOBY4RXK7D', FailureHandling.STOP_ON_FAILURE)

			Mobile.tap(findTestObject('Phase 3/Phase 3.2/Call Test Case/Go button'), 0)

			Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

			Mobile.startApplication('C:\\Users\\anen.shyil\\Katalon Studio\\Png Mobile Testing\\PNGIndia_Mobile_Testing 2.4\\APK File\\Phase 3\\Phase 3.2\\IvyDMS_PNGIndia_140_5958.apk',
					false)

			Mobile.waitForElementPresent(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'), 0)

			Mobile.tap(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'), 0)

			Mobile.hideKeyboard()

			Mobile.sendKeys(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'), findTestData('Phase 3/Phase 3.2/Anen/LoginDetails').getValue(
					'Username', 1), FailureHandling.STOP_ON_FAILURE)

			Mobile.sendKeys(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Password'), findTestData('Phase 3/Phase 3.2/Anen/LoginDetails').getValue(
					'pwd', 2), FailureHandling.STOP_ON_FAILURE)

			Mobile.hideKeyboard()

			Mobile.tap(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Login_Button'), 0)

			Mobile.delay(60, FailureHandling.STOP_ON_FAILURE)
		} else {
			if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'),
			10, FailureHandling.OPTIONAL)) {
				Mobile.tap(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'), 0)

				Mobile.hideKeyboard()

				Mobile.sendKeys(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'), findTestData('Phase 3/Phase 3.2/Anen/LoginDetails').getValue(
						'Username', 1), FailureHandling.STOP_ON_FAILURE)

				Mobile.sendKeys(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Password'), findTestData('Phase 3/Phase 3.2/Anen/LoginDetails').getValue(
						'pwd', 2), FailureHandling.STOP_ON_FAILURE)

				Mobile.hideKeyboard()

				Mobile.tap(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Login_Button'), 0)

				Mobile.delay(90, FailureHandling.STOP_ON_FAILURE)
			} else {

				Mobile.delay(6, FailureHandling.STOP_ON_FAILURE)

				Mobile.waitForElementPresent(findTestObject('Phase 3/Phase 3.2/Call Test Case/Username_noneditable'), 0)

				String userName = Mobile.getText(findTestObject('Phase 3/Phase 3.2/Call Test Case/Username_noneditable'), 0)

				println(userName)

				if (userName != 'sabari_sales') {
					Mobile.startApplication('C:\\Users\\anen.shyil\\Katalon Studio\\Png Mobile Testing\\PNGIndia_Mobile_Testing 2.4\\APK File\\Phase 3\\Phase 3.2\\IvyDMS_PNGIndia_140_5958.apk',
							true)

					Mobile.sendKeys(findTestObject('Phase 3/Phase 3.2/Call Test Case/Activation Key'), 'X9F28VIOBY4RXK7D', FailureHandling.STOP_ON_FAILURE)

					Mobile.tap(findTestObject('Phase 3/Phase 3.2/Call Test Case/Go button'), 0)

					Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

					Mobile.startApplication('C:\\Users\\anen.shyil\\Katalon Studio\\Png Mobile Testing\\PNGIndia_Mobile_Testing 2.4\\APK File\\Phase 3\\Phase 3.2\\IvyDMS_PNGIndia_140_5958.apk',
							false)

					Mobile.tap(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'), 0)

					Mobile.hideKeyboard()

					Mobile.sendKeys(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'), findTestData('Phase 3/Phase 3.2/Anen/LoginDetails').getValue(
							'Username', 1), FailureHandling.STOP_ON_FAILURE)

					Mobile.sendKeys(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Password'), findTestData('Phase 3/Phase 3.2/Anen/LoginDetails').getValue(
							'pwd', 2), FailureHandling.STOP_ON_FAILURE)

					Mobile.hideKeyboard()

					Mobile.tap(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Login_Button'), 0)

					Mobile.delay(60, FailureHandling.STOP_ON_FAILURE)

					not_run: Mobile.setText(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Password'), findTestData('Phase 3/Phase 3.2/Anen/LoginDetails').getValue(
					'pwd', 2), 0)

					not_run: Mobile.hideKeyboard()

					not_run: Mobile.tap(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Login_Button'), 0)

					not_run: Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)
				} else {
					not_run: Mobile.tap(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'), 0)

					not_run: Mobile.hideKeyboard()

					not_run: Mobile.setText(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Username'), findTestData('Phase 3/Phase 3.2/Anen/LoginDetails').getValue(
					'Username', 2), 0)

					Mobile.sendKeys(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Password'), findTestData('Phase 3/Phase 3.2/Anen/LoginDetails').getValue(
							'pwd', 2), FailureHandling.STOP_ON_FAILURE)

					Mobile.hideKeyboard()

					Mobile.tap(findTestObject('Phase 3/Phase 3.2/Anen/Dashboard,Filter/Login_Button'), 0)

					Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)
				}
			}
		}
	}
}
