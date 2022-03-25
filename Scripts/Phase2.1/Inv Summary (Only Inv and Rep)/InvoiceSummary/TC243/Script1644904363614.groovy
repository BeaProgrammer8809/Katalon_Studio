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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

'To Click on Search Button'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/TY_13/TY_13').getValue(
        3, 32), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_4'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

//*************************************************************************************************************************
// To fetch data from Summary Screen sku pieces
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def pieces = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

println(pieces + 'Pieces Ordered')

double TotalPieces = Double.parseDouble(pieces)

println(TotalPieces + 'Total Pieces Ordered in Double Formt')

def unitPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

println(unitPrice + 'Unit Price String Format')

double UnitPrice = Double.parseDouble(unitPrice)

println(UnitPrice + 'UnitPrice Double Format')

def GrossAmount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

println(GrossAmount + 'Gross Amount String View')

double SKUGrossAmount = Double.parseDouble(GrossAmount)

println(SKUGrossAmount + 'SKU Gross Amount in Double fromat')

// To Calculate the Discount TotalDiscoount = SKUGrossAmount - (TotalPieces * UnitPrice)
double TotalDiscount = SKUGrossAmount - (TotalPieces * UnitPrice)

println(TotalDiscount + 'Total Discount Calculated')

//To Get THe Value Amount in SUMMARY Screen
Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

def valueDisplayed = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println(valueDisplayed + 'Value displayed in summary screen string format')

double ValueDisplayed = Double.parseDouble(valueDisplayed)

println(valueDisplayed + 'Value Displayed in Summery Screen Double Format')

//*************************************************************************************************************************
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/AmountSplitUp_PopUpTitle'), 
    0)

def expectedAmountSplitpopup = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/AmountSplitUp_PopUpTitle'), 
    0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_243_AmtSplitup'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_TextView'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 0)

def actualOrderValue = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 
    0)

double OrderValue = Double.parseDouble(actualOrderValue)

println(OrderValue + '--OrderValue Double format')

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_Value'), 0)

def actualTotalOrderValue = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_Value'), 
    0)

double TotalOrderValue = Double.parseDouble(actualTotalOrderValue)

println(TotalOrderValue + 'TOTAL ORDER VALUE')

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0)

def compDiscValueText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 
    0)

def compDiscLength = compDiscValueText.length()

println(compDiscLength + 'STRING LENGTH')

def compDigit = compDiscValueText.substring(2, compDiscLength)

double CompDiscAbsValue = Double.parseDouble(compDigit)

println(CompDiscAbsValue + 'COMP DISC Double view')

def CompDisc = (compDiscValueText[0]) + CompDiscAbsValue.toString()

println(CompDisc + 'Comp Disc with negitive Sign')

// To Calculate the TotalValue which is OrderValue - CompDisc
double TotalAmtCalc = (OrderValue - CompDiscAbsValue).round(2)

println(TotalAmtCalc + 'Total amount calculated')

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_Value'), 0)

distDiscValueText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_Value'), 
    0)

//*************************************************
'To Verify Total Amount Displayed in Amount Split up pop-up is as calculated'
Mobile.verifyEqual(TotalAmtCalc, TotalOrderValue)

'To check or verify is Comp Disc has -ve sign'
ExpectedSign = findTestData('Phase2.1/TY_13/TY_13').getValue(10, 32)

Mobile.verifyMatch(compDiscValueText[0], ExpectedSign, false)

'To Check if Total Discount Calculated and Comp Disc displayed in Amount Split up is equal'
Mobile.verifyMatch(TotalDiscount.toString(), CompDisc, false)

//tax calculation and percentage validation
def totalSum = SKUGrossAmount

println(totalSum + '--totalsum passed to calaculate tax')

def tax = CustomKeywords.'com.ty.keywords.MobileKeywords.taxIEPS'(totalSum)

println(tax + ' ----- Tax amount calculated using Tax keyword')

def actualTaxPercentage = findTestData('Phase2.1/CommonData/CommonData').getValue(18, 1)

def expTaxPercentage = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(tax, totalSum)

println(expTaxPercentage + '---TAX Percentage returned from keyword')

Mobile.verifyMatch(actualTaxPercentage, expTaxPercentage, false, FailureHandling.STOP_ON_FAILURE)

println('Tax IEPS is applied for sku')

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

'To Tap on Close_Button.'
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

'Calculating the total value order_value - comp_disc'
double TotalCalc = (OrderValue - CompDiscAbsValue).round(2)

println(TotalCalc + 'TOTAL CALCULATED')

'checking if the value calculated is equal to the Total Value displayed in Ampunt Split up'
Mobile.verifyEqual(TotalOrderValue, TotalCalc)

'checking if the calculated value is equal to value displayed in Summary Screen'
Mobile.verifyEqual(ValueDisplayed, TotalCalc, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/PrintPreticket_Icon'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_243_Preticket'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Pre_Ticket_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/PreTicket_Created_Successfully_Ok_Button'), 0)

Mobile.closeApplication()

