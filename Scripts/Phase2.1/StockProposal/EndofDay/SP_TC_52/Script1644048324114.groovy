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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 10, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

Mobile.waitForElementPresent(findTestObject('Phase2/BIHamburger01/End_Of_The_Day_Button'), 2, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Stock_Proposal_Header'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_EditText'), 0)

'To set the SKU name in Search Edit Text field of Stock Proposal Screen'
Mobile.setText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 1), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/OP_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposal_NumberKeyPad/Num_1'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Save_Button'), 5, FailureHandling.OPTIONAL)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Save_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Save_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/It will sync immediately. Do you want to continue TextView'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/DoYouWannaContinue OK_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/DoYouWannaContinue Cancel_Button'), 
    0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/DoYouWannaContinue OK_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Saved Successfully. TextView'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/SavedSuccesfully. CancelButton'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/SavedSuccesfully. PrintButton'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/SavedSuccesfully. PrintButton'), 0)

def date = new Date()

def sdf = new SimpleDateFormat('MM/dd/yyyy')

presentDate = sdf.format(date)

println(presentDate)

def PrintPreviewScreen = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

boolean ActualDate = PrintPreviewScreen.contains(presentDate)

def ActualDate1 = ActualDate.toString()

println(ActualDate1)

// Date Verification
Mobile.verifyMatch(ActualDate1, findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data2', 9), false, FailureHandling.STOP_ON_FAILURE)

// DELIVERY DATE Verification
boolean deliveryDate = PrintPreviewScreen.contains(findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data6', 9))

def deliveryDate1 = deliveryDate.toString()

println(deliveryDate1)

Mobile.verifyMatch(deliveryDate1, findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data2', 9), false, FailureHandling.STOP_ON_FAILURE)

//ROUTE CODE verification
boolean routecodetxt = PrintPreviewScreen.contains(findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data7', 9))

def routecodetxt1 = routecodetxt.toString()

println(routecodetxt1)

Mobile.verifyMatch(routecodetxt1, findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data2', 9), false, FailureHandling.STOP_ON_FAILURE)

// ORD REQ DATE Verification
boolean OrdReqDate = PrintPreviewScreen.contains((findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data4', 9) + ' ') + 
    presentDate)

println(OrdReqDate)

def OrdReqDate1 = OrdReqDate.toString()

println(OrdReqDate1)

Mobile.verifyMatch(OrdReqDate1, findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data2', 9), false, FailureHandling.STOP_ON_FAILURE)

//Product code with short desc Verification
def SkuCode = findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data3', 9)

boolean ActualSkuCode = PrintPreviewScreen.contains(SkuCode)

def ActualSkuCode1 = ActualSkuCode.toString()

println(ActualSkuCode1)

Mobile.verifyMatch(ActualSkuCode1, findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data2', 9), false, FailureHandling.STOP_ON_FAILURE)

//Price quantity and Total verification
def quantitydetail = findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data5', 9)

boolean totalquantityandprice = PrintPreviewScreen.contains(quantitydetail)

def totalquantityandprice1 = totalquantityandprice.toString()

println(totalquantityandprice1)

Mobile.verifyMatch(totalquantityandprice1, findTestData('Phase2.1/TY_05/TestData_03B').getValue('Data2', 9), false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), [('testCaseName') : 'SP_TC_52'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

