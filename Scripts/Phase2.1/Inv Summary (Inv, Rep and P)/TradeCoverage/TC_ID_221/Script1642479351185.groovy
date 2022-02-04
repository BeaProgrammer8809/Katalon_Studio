import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 4), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 6)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(2, 3)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 44)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_221_Actual_Pieces_Value_And_Actual_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_221_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 0)

def Amount1=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)
for (int i = 0; i < Amount1.length(); i++)
{
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Collection_Dropdown_Script'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/1_NumButton'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/2_NumButton'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/3_NumButton'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/4_NumButton'), 0)

def Actual_Current_Date = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_221_Actual_Current_Date'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BICalenderPopup/NextMonth_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BICalenderPopup/23_Date'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BICalenderPopup/OK_button'), 0)

def Expected_Presentt_Date = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_221_Expected_Presentt_Date'], FailureHandling.STOP_ON_FAILURE)

//Verification to check that whether able to select furtue cheque
Mobile.verifyNotMatch(Actual_Current_Date, Expected_Presentt_Date, false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

//Verification to check that whether able to submit with future cheque date
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_221_Summary_Screen_Is_Visible'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the Invoice Qty, Return Qty and PB Qty
Mobile.verifyEqual(Actual_Pieces_Value, Expected_Pieces_Value, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Return_Qty, Expected_Return_Qty, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()