import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
	1, 26), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 39)], FailureHandling.STOP_ON_FAILURE)


Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Schemes/Scheme/Screenshot'), [('testCaseName') : 'SC_TC_20 '],FailureHandling.STOP_ON_FAILURE)


Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIHamburger01/Schemes_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist( findTestObject('Object Repository/Phase2/BIHamburger01/Schemes_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

