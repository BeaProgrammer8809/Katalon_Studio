import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 44)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_180_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

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
Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_180_Actual_Sales_Return'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.checkElement(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check Total paid amount is lesser than invoice amount
def Inv_Amt=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)
def Inv_Amt1=Inv_Amt.split(" ")
def Inv_Amt2=Inv_Amt1[0]
DecimalFormat df1 = new DecimalFormat('0.00')
def Expected_Inv_Amt=df1.format(Float.parseFloat(Inv_Amt2))
Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_381_Expected_Inv_Amt'], FailureHandling.STOP_ON_FAILURE)

//Total Paid field is automatically filled with the invoice amount (value) displayed in Summary screen
def Actual_Total_Amt1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'),0)
def amount1 = Actual_Total_Amt1.split(' ')
def Expected_Total_Amt_Present = amount1[3]
Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_386_Expected_Total_Amt_Present'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_386_Toast_Message'], FailureHandling.STOP_ON_FAILURE)

AppiumDriver driver = MobileDriverFactory.getDriver()
def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()
def Expected_Toast_Message = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(8, 40)

//Verification of Toast message when Total paid amount is lesser than invoice amount
Actual_Toast_Message.contains(Expected_Toast_Message)
println(Actual_Toast_Message)

//Verification to check that Pay Minimum amount to proceed the invoice message is displayed and it is not allowing to Submit collection with Total paid amount less than Invoice amount
def Expected_Total_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'),0)
Mobile.verifyLessThan(Expected_Total_Amt, Expected_Inv_Amt, FailureHandling.STOP_ON_FAILURE)

//Verification to check the invoice and Product Buying qty
Mobile.verifyMatch(Actual_Pieces_Value, Expected_Pieces_Value, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Sales_Return, Expected_Return_Qty, false, FailureHandling.STOP_ON_FAILURE)

println('Pay Minimum amount to proceed the invoice message is displayed and it should not allow to Submit collection with Total paid amount less than Invoice amount')
Mobile.closeApplication()