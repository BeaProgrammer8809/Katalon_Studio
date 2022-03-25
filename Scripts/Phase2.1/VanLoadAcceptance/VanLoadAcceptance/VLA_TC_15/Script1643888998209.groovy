import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BIKPIDashboard01/KPI_Dashboard_TextView'), findTestData('Phase2.1/TY_02/TestData_01B').getValue(
        'Data1', 3))

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 10, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0, FailureHandling.STOP_ON_FAILURE)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> elements = driver.findElementsByClassName('android.widget.CheckBox')

def size = elements.size()

println size

for (int i = 0; i < size; i++) {
	GlobalVariable.index = i

	Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/DeliveryDate_Indexing'), 0, FailureHandling.OPTIONAL)
		
	Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/DeliveryDate_Indexing'), i, FailureHandling.OPTIONAL)

	elements.get(i).click()

	Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Submit_Button'), i, FailureHandling.STOP_ON_FAILURE)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Back_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.STOP_ON_FAILURE)


Mobile.tap(findTestObject('Phase2/BIHamburger01/Trade_Coverage_Button'), 0, FailureHandling.OPTIONAL)

Mobile.verifyElementText(findTestObject('Phase2/BITradeCoverage01/Trade_Coverage_TextView'), findTestData('Phase2.1/TY_02/TestData_01B').getValue(
        'Data1', 4))

Mobile.tap(findTestObject('Phase2/BITradeCoverage01/Search_Button'), 0, FailureHandling.OPTIONAL)

retailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 20)

println(retailerName)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/txt_Search'), 
    retailerName, 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Store Profile Screen/Profile_Odometer Journey not started'), 
    10, FailureHandling.OPTIONAL)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase 1.1/Resource3/Order and Invoice/Store Profile Screen/Profile_Odometer Journey not started'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase 1.1/Resource3/Order and Invoice/Store Profile Screen/Profile_Odometer Journey not started'), 0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Store Profile Screen/Profile_Odometer Journey not started'), 
    findTestData('Phase2.1/TY_02/TestData_01B').getValue('Data1', 5),FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_15'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()