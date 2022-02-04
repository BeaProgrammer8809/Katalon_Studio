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

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 2)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIStartOftheday01/Odometer_Button'), 2)

Mobile.tap(findTestObject('Phase2/BIStartOftheday01/Odometer_Button'), 0)


Mobile.setText(findTestObject('Phase2/BIOdometer01/Start_Trip_Reading_EditText'), findTestData('Phase2/Common_Data/CommonData').getValue(
			'OdometerReading', 1), 0)

Mobile.tap(findTestObject('Phase2/BIOdometer01/Start_Journey_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOdometer01/OK_Button'), 0)
