import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Unload_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIUnload/Salable/Product_Name_Indexing'), 'enabled', 
    findTestData('Phase2.1/TY_04/Phase2.1').getValue(20, 46), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_030'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

