import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
	1, 5), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 5)], FailureHandling.STOP_ON_FAILURE)


Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIHamburger01/Schemes_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Schemes/Scheme/Screenshot'), [('testCaseName') : 'SC_TC_13 before '],FailureHandling.STOP_ON_FAILURE)

Product_Name_HeaderBefore = Mobile.getText( findTestObject('Object Repository/Phase2/BIMainMenu_SchemesScreen/Product_Name_Header'), 0)

println(Product_Name_HeaderBefore + "  Product_Name_HeaderBefore")

Mobile.tap( findTestObject('Object Repository/Phase2/BIMainMenu_SchemesScreen/Product_Name_Header'), 0, FailureHandling.OPTIONAL)

Mobile.setText(findTestObject('Object Repository/Phase2/BIMainMenu_SchemesScreen/Product_Name_Header') , "asdfjkl", 0, FailureHandling.OPTIONAL)

Product_Name_HeaderAfter = Mobile.getText( findTestObject('Object Repository/Phase2/BIMainMenu_SchemesScreen/Product_Name_Header'), 0)

println(Product_Name_HeaderAfter + "  Product_Name_HeaderAfter")

Mobile.verifyMatch(Product_Name_HeaderAfter, Product_Name_HeaderBefore, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Schemes/Scheme/Screenshot'), [('testCaseName') : 'SC_TC_13 After '],FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()