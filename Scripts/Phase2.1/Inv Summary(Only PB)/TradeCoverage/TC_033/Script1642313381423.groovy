import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 10, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

Mobile.waitForElementPresent(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 2, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIStartOfTheDay01/Odometer_Button'), 2)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Odometer_Button'), 0)

if (Mobile.verifyElementExist(findTestObject('Phase2/BIOdometer01/End_Journey_Button'), 5, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Phase2/BIOdometer01/Back_Button'), 0)

	Mobile.tap(findTestObject('Phase2/BIOdometer01/OK_Button'), 0)
} else {
	Mobile.setText(findTestObject('Phase2/BIOdometer01/Start_Trip_Reading_EditText'), findTestData('Phase2/Common_Data/CommonData').getValue(
			'OdometerReading', 1), 0)

	Mobile.tap(findTestObject('Phase2/BIOdometer01/Start_Journey_Button'), 0)

	Mobile.tap(findTestObject('Phase2/BIOdometer01/OK_Button'), 0)
}

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

if (Mobile.verifyElementExist(findTestObject('Phase2/BIVanloadAcceptance01/Checkbox'), 0, FailureHandling.OPTIONAL)) {
	checkboxes = driver.findElementsByClassName('android.widget.CheckBox')

	List<WebElement> elements = driver.findElementsByClassName('android.widget.CheckBox')

	def size = elements.size()

	println('The size of elements is ::' + elements.size())

	for (int i = 0; i < size; i++) {
		elements.get(i).click()

		Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Submit_Button'), 0, FailureHandling.OPTIONAL)

		Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)
	}
	
	Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Back_Button'), 0)
} else {
	Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Back_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Unload_Button'), 0)

def Expected_Text_Present = Mobile.getText(findTestObject('Phase2/BIUnload/Unload_Frame'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_033'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()