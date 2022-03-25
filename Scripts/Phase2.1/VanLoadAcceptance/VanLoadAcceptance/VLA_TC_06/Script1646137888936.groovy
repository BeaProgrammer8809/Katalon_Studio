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

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(
            2, 11), ('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 11)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Back_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIStartOfTheDay01/Start_Of_The_Day_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIStartOfTheDay01/Start_Of_The_Day_Button'), 0, FailureHandling.STOP_ON_FAILURE)

println('Start of the day screen is visible')

Mobile.verifyElementNotVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/AcceptPendingChargesWithASaleDateForToday and earlier to continue'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('Please Select the Pending Previous Date for Acceptance pop up is not visible')

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), ["testCaseName":"VLA_TC_06"], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

