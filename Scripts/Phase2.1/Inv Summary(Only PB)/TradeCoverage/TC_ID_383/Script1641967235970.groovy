import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.sun.media.sound.DirectAudioDevice.DirectDL.Balance
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 44)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_180_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 44)

Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Sales_Return = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_180_Actual_Sales_Return'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 0)

//Verification to check that efectivo mode is selected
Mobile.verifyElementHasAttribute(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 'selected', 0, FailureHandling.STOP_ON_FAILURE)

//Inv amount
def Inv_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
DecimalFormat df=new DecimalFormat('0.0')
def Actual_Inv_Amt=df.format(Float.parseFloat(Inv_Amt))

//By default the Total paid field is updated with full Invoice amount
def Actual_Total__Paid_Amt=Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
println Actual_Total__Paid_Amt

//Verification to check Balance: 0 of Inv amount is display
def Actual_Balance_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
def Balance = Actual_Balance_Amt.split(" ")
def New_Balance = Balance[2]
def Expected_Balance_Amt = New_Balance + Actual_Inv_Amt
println(Expected_Balance_Amt)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_383_Expected_Amount'], FailureHandling.STOP_ON_FAILURE)

def Bal=New_Balance + 'of' + Actual_Inv_Amt
println Bal

//Verification to check that Balance is displayed as 0 of Inv amount
Bal.compareTo(Actual_Balance_Amt)
println Bal

//Verification to check the invoice and Product Buying qty
Mobile.verifyMatch(Actual_Pieces_Value, Expected_Pieces_Value, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Sales_Return, Expected_Return_Qty, false, FailureHandling.STOP_ON_FAILURE)

println "By default the Total paid field is updated with full Invoice amount hence the Balance is displayed as 0 of Inv amount"
Mobile.closeApplication()