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
import java.text.SimpleDateFormat as SimpleDateFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_EditText'), 0)

'To set the SKU name in Search Edit Text field of Stock Proposal Screen'
Mobile.setText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 1), 0)

Mobile.setText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/OC_EditText'), '1', 0)

//def deliveryDate = Mobile.getText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Delivery_Date_Dynamic'), 0)
def singlePeicePrice = Mobile.getText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/SRP_Price'), 0)

println singlePeicePrice

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Save_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/DoYouWannaContinue OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/SavedSuccesfully. PrintButton'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

def PrintPreviewScreen = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

println PrintPreviewScreen

String trayQty = findTestData('Phase2.1/TY_01/TestData_01B').getValue(2, 4)

def qty= Double.parseDouble(trayQty)

def spp =Double.parseDouble(singlePeicePrice)

println spp

def calculatedValue = spp * qty

println calculatedValue

def expResult = "\$"+calculatedValue 

println expResult

boolean expRes=PrintPreviewScreen.contains(expResult)

Mobile.verifyMatch(expRes.toString(),findTestData('Phase2.1/TY_01/TestData_01B').getValue(2, 3), false ,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndOfDay/Screenshot'), [('testCaseName') : 'SP_TC_56'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

