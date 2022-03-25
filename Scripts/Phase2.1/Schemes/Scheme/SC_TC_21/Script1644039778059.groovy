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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
	1, 40), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 40)], FailureHandling.STOP_ON_FAILURE)


Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Schemes/Scheme/Screenshot'), [('testCaseName') : 'SC_TC_21 '],FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Object Repository/Phase2/BIHamburger01/Schemes_Button')  , 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotExist(findTestObject('Object Repository/Phase2/BIHamburger01/Schemes_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()