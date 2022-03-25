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

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

'Click on stock proposal'
Mobile.tap(findTestObject('Object Repository/Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        'ProductName', 37), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Bag_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposal_NumberKeyPad/Num_1'), 0)

def bagQty = Mobile.getText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Bag_EditText'), 0)

int BagQty = Integer.parseInt(bagQty)

def conversionQty = findTestData('Phase2.1/TY_02/TestData_01B').getValue('ConversionQuantity', 8)

int ConversionQty = Integer.parseInt(conversionQty)

def Totalpieces = BagQty*ConversionQty

def SRPPrice = Mobile.getText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/SRP_Price'), 0)

double SRPprice = Double.parseDouble(SRPPrice)

def TotalAmt = Totalpieces*SRPprice

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Save_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/DoYouWannaContinue OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/SavedSuccesfully. PrintButton'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), findTestData('Phase2.1/TY_02/TestData_01B').getValue(
        'Data1', 1), FailureHandling.STOP_ON_FAILURE)



def PrintPreviewScreen = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

def TotalValue = findTestData('Phase2.1/TY_02/TestData_01B').getValue('PrintPreviewVerification', 8)+Totalpieces+"       " +"\$"+TotalAmt

println(TotalValue)

boolean ActualTotalValue = PrintPreviewScreen.contains(TotalValue)

def ActualTotalValue1 = ActualTotalValue.toString()

Mobile.verifyMatch(ActualTotalValue1,findTestData('Phase2.1/TY_02/TestData_01B').getValue(
	'Data2', 8),false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndOfDay/Screenshot'), [('testCaseName') : 'SP_TC_59'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()