import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 6), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 6)], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIStartOfTheDay01/Odometer_Button'), 2)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Odometer_Button'), 0)

	 Mobile.setText(findTestObject('Phase2/BIOdometer01/Start_Trip_Reading_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
		'OdometerReading', 1), 0)

	 Mobile.tap(findTestObject('Phase2/BIOdometer01/Start_Journey_Button'), 0)

	  Mobile.tap(findTestObject('Phase2/BIOdometer01/OK_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

if (Mobile.verifyElementExist(findTestObject('Phase2/BIVanloadAcceptance01/Checkbox'), 0, FailureHandling.OPTIONAL)) {
	checkboxes = driver.findElementsByClassName('android.widget.CheckBox')

	List<WebElement> elements = driver.findElementsByClassName('android.widget.CheckBox')

	def size = elements.size()

	println('The size of elements is ::' + elements.size())

		for (int i = 0; i < size; i++){
		elements.get(i).click()

		Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

		Mobile.verifyElementAttributeValue(findTestObject('Phase2/BIVanloadAcceptance01/Submit_Button'), 'enabled', findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
			18, 120), 0)
		
		Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Submit_Button'), 0, FailureHandling.STOP_ON_FAILURE)
		
		def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()
				
		def Expected_Toast_Message = findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(5, 120)
		
		println(Actual_Toast_Message)
		
		Mobile.verifyMatch(Actual_Toast_Message, Expected_Toast_Message, false, FailureHandling.STOP_ON_FAILURE)
		}
}

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_126'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
