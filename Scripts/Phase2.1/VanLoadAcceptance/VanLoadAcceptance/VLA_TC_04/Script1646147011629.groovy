import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.validator.GenericValidator as GenericValidator
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

//Load Created date
AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> elements = driver.findElementsByClassName('android.widget.CheckBox')

def size = elements.size()

for (int i = 1; i <= size; i++) {
	GlobalVariable.index = i

	def loadDatetextInVanload = Mobile.getText(findTestObject('Phase2/BIVanloadAcceptance01/VanloadDate_indexing'),
		0, FailureHandling.STOP_ON_FAILURE)
	
	println loadDatetextInVanload

	def dateformat = loadDatetextInVanload.replace('/', '')

	def dateresult = GenericValidator.isDate(dateformat, 'yyyyMMdd', true)

	def Dateresulttext = dateresult.toString()

	Mobile.verifyMatch(Dateresulttext, findTestData('Phase2.1/TY_05/Testdata').getValue('Data2', 29), false, FailureHandling.STOP_ON_FAILURE)

	Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_04'],
		FailureHandling.STOP_ON_FAILURE)

	println(loadDatetextInVanload)
}

Mobile.closeApplication()
