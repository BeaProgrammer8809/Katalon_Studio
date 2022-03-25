import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> elements = driver.findElementsByClassName('android.widget.CheckBox')
	
	def size = elements.size()

	for (int i = 1; i <= size; i++) {
		
		GlobalVariable.index = i

		Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/VanloadDate_indexing'), 0, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/VanloadDate_indexing'), i, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/DeliveryDate_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/DeliveryDate_Indexing'), i, FailureHandling.STOP_ON_FAILURE)
	}
	

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_02'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()