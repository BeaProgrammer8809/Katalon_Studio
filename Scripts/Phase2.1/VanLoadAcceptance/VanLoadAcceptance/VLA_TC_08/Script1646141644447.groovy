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
import java.time.*
import java.text.SimpleDateFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

GlobalVariable.index=findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)
def actualDateWithtext=Mobile.getText(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/DeliveryDate_Indexing'), 0)
def list=actualDateWithtext.split(' ')

Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Back_Button'), 0)



def date = new Date()
def sdf = new SimpleDateFormat("yyyy/MM/dd")
presentDate = sdf.format(date)
println(presentDate)


Mobile.comment('verifying past date')

Mobile.verifyNotMatch(list[2], presentDate, false, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('verifying the popup')

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/AcceptPendingChargesWithASaleDateForToday and earlier to continue'),
	0 , FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/AcceptPendingChargesWithASaleDateForToday and earlier to continue'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_08'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()