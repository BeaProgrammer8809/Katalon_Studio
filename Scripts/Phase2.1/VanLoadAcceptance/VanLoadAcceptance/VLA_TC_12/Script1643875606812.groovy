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
import org.openqa.selenium.Keys as Keys

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BIKPIDashboard01/KPI_Dashboard_TextView'), findTestData('Phase2.1/TY_02/TestData_01B').getValue(
        'Data1', 3))

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 10, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

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

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_12'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

