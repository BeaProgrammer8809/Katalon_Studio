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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Filter_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementHasAttribute(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Filter_Button'), 'enabled', 
    0, FailureHandling.STOP_ON_FAILURE)

def titleBfr = Mobile.getText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Stock_Proposal_Header'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Filter_Button'), 0)

def titleAfter = Mobile.getText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/Filter_Title'), 
    0)

Mobile.verifyNotMatch(titleBfr, titleAfter, false, FailureHandling.STOP_ON_FAILURE)

println('Filter button is enabled in Stock proposal menu')

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), [('testCaseName') : 'SP_TC_07_SPScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

