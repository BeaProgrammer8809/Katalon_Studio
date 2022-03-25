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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Back_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIVanloadAcceptance01/AcceptPendingChargesWithASaleDateForToday and earlier to continue'), 
    0)

Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/OK_ButtonAcceptPendingChargesPopup'), 0)

//verification
Mobile.verifyElementNotExist(findTestObject('Phase2/BIVanloadAcceptance01/AcceptPendingChargesWithASaleDateForToday and earlier to continue'), 
    0)

Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Back_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIVanloadAcceptance01/AcceptPendingChargesWithASaleDateForToday and earlier to continue'), 
    0)

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_10'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

