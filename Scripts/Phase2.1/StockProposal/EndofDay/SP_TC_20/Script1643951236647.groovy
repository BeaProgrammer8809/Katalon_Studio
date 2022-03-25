import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.VerifyElementVisibleInViewportKeyword as VerifyElementVisibleInViewportKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

'Click on stock proposal'
Mobile.tap(findTestObject('Object Repository/Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

'click on search option'
Mobile.tap(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_Button'), 0)

def product = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 2)

Mobile.setText(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_EditText'), product, 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.delay(2)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

//def quantity = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def TrayQtyBeforeProvidingQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/OC_EditText'), 
    0)

'Provide Tray quantity'
Mobile.tap(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/OC_EditText'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/PleaseSelectAnItem_PopupTitle'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/PleaseSelectAnItem_PopupTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/OK_ButtonSelectAnItemPopup'), 0)

'Capturing the Bag quantity'
def TrayQtyAfterProvingQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/OC_EditText'), 
    0)

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), [('testCaseName') : 'SP_TC_20'], FailureHandling.STOP_ON_FAILURE)

Mobile.comment('User Should not allow to take stock proposal in bag')

'Before and after stock proposal should be same'
Mobile.verifyMatch(TrayQtyBeforeProvidingQty, TrayQtyAfterProvingQty, false, FailureHandling.STOP_ON_FAILURE)

'Verifyed with default quantity'
Mobile.verifyMatch(TrayQtyAfterProvingQty, findTestData('Phase2.1/TY_06/StockProposal/EndOfDay').getValue(3, 2), false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

