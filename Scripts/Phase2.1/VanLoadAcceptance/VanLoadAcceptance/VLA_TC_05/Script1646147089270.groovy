import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.validator.GenericValidator
import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver


Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

//delivery date
AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> elements = driver.findElementsByClassName('android.widget.CheckBox')

def size = elements.size()
for (int i = 1; i <= size; i++) {
		GlobalVariable.index = i
		
def deliveryDatetextInVanload = Mobile.getText(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/DeliveryDate_Indexing'),
	0, FailureHandling.STOP_ON_FAILURE)

def deliveryDate= deliveryDatetextInVanload.split(':')
 
 def date = deliveryDate[1]
 
  def deliveryDatetext = date.replace(' ', '')
  
def dateformat=deliveryDatetext.replace('/', '')

def dateresult = GenericValidator.isDate(dateformat, "yyyyMMdd", true)

def Dateresulttext = dateresult.toString()

Mobile.verifyMatch(Dateresulttext, findTestData('Phase2.1/TY_05/Testdata').getValue('Data2', 29), false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_05'],
	FailureHandling.STOP_ON_FAILURE)

	println(deliveryDate)
}
Mobile.closeApplication()