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
import java.text.SimpleDateFormat as SimpleDateFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 10, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

Mobile.waitForElementPresent(findTestObject('Phase2/BIHamburger01/End_Of_The_Day_Button'), 2, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/NumberKeyBoard_ALL'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/NumberKeyBoard_ALL'),
	0)
//Verify  if the numeric keyboard is enabled
for (i = 1; i <= 10; i++) {
	GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', i)
	
	Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BINumberKeypad01/Number'),'enabled',true.toString(),0, FailureHandling.STOP_ON_FAILURE)
}
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'),'enabled',true.toString(),0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/NumberKeyBoard_ALL'),'enabled',true.toString(),0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyPB/DeliveryFinalSummary/Screenshot'), [('testCaseName') : 'SP_TC_25'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

