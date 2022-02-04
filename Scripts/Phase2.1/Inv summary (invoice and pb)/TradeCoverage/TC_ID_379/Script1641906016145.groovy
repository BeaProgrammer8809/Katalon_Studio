import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName,
	0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_379'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 0)

////Mobile.tap(findTestObject('Object Repository/Phase2/BIEnterTheFolioNoPopup01/FolioNo._EditText'), 0)
//Mobile.setText(findTestObject('Object Repository/Phase2/BIEnterTheFolioNoPopup01/FolioNo._EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(15, 1), 0)
//
////Verification to check that user is able to pay full amount in cash mode by selecting Effectivo checkbox
//Mobile.checkElement(findTestObject('Object Repository/Phase2/BIEnterTheFolioNoPopup01/Efectivo_CheckBox'), 0)
//
//Mobile.callTestCase(findTestCase('Phase2.1/Trade_Coverage/Invoice_Summary/Taking_only_Inv_And_PB/Screenshot'), [('testCaseName') : 'TC_ID_378_Efectivo Checkbox_Checked'], FailureHandling.STOP_ON_FAILURE)
//
//Mobile.tap(findTestObject('Object Repository/Phase2/BIEnterTheFolioNoPopup01/OK_Button'), 0)
//Verification that invoice is successfully created.
//Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 0, FailureHandling.STOP_ON_FAILURE)
//
//println "user is able to pay full amount in cash mode by selecting Effectivo checkbox"
//Based on MayuriMam Clarification
def ActualInvAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0, FailureHandling.STOP_ON_FAILURE)

def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println(invAmt.length())

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Double ActualSubInvAmt = Double.parseDouble(ActualInvAmt) - 1

println (ActualSubInvAmt)

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), ActualSubInvAmt.toString(), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_379'], FailureHandling.STOP_ON_FAILURE)

def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()

def Expected_Toast_Message = findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(5, 30)

println(Actual_Toast_Message)

Actual_Toast_Message.contains(Expected_Toast_Message)
//Mobile.verifyMatch(Actual_Toast_Message, Expected_Toast_Message, false, FailureHandling.STOP_ON_FAILURE)

println('User should not generate the invoice')

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_379'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

