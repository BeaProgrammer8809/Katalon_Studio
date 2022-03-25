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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

//Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
	1, 17), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 17)], FailureHandling.STOP_ON_FAILURE)


Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

def productName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 21)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), productName, 0)

'Provide order quantity'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

'capturing required data'
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def piecesText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

double pieces = Double.parseDouble(piecesText)

def SkuGrossText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

double SkuGross = Double.parseDouble(SkuGrossText)

def UpriceText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

double Uprice = Double.parseDouble(UpriceText)

def ValueText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

double Value = Double.parseDouble(ValueText)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC_165(1)'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.comment('verifying screen title')

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/AmountSplitUp_PopUpTitle'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/AmountSplitUp_PopUpTitle'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/AmountSplitUp_PopUpTitle'), 
    findTestData('Phase2.1/TY_06/Summary/Summary').getValue(2, 1))


Mobile.comment('verifying the Comp Disc')

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0, FailureHandling.STOP_ON_FAILURE)

'capturing CompDisc from mobile'
def CompDisc = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0)
CompDisc=CompDisc.replace(' ','')
double CompDiscvalue = Double.parseDouble(CompDisc)



//def expected = '- ' + findTestData('Phase2.1/TY_06/Summary/Summary').getValue(3, 1)
//Mobile.verifyMatch(CompDisc, expected, false)
Mobile.comment('verifying  (-) sign indicated before the amount')

//def compDisc = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0)
def expresult = CompDisc.substring(0, 1)

Mobile.verifyMatch(expresult, findTestData('Phase2.1/TY_06/Summary/Summary').getValue(4, 1), false)

//
'Calculation'

/*'Total_Disc=SkuGross -(piece * UPrice )'
double Total_Disc = SkuGross - (pieces * Uprice)

Total_Disc = Total_Disc.round()*/

'Disc Calculation'
def itemDiscText=findTestData('Phase2.1/TY_06/Trade_Coverage/Invoice_Summary/Invoice_Summary02').getValue(6, 3)

double itemDiscPercentage=Double.parseDouble(itemDiscText)

double itemDiscAmt=(pieces * Uprice)*(itemDiscPercentage/100)

double AmountAfterItemDisc=(pieces * Uprice)-itemDiscAmt

def CategoryText=findTestData('Phase2.1/TY_06/Trade_Coverage/Invoice_Summary/Invoice_Summary02').getValue(7, 1)

double CategoryDiscPercentage=Double.parseDouble(CategoryText)

double CategoryDiscAmt=AmountAfterItemDisc*(CategoryDiscPercentage/100)


double CompDiscValueCalculated=CategoryDiscAmt+itemDiscAmt


//def Total_DiscText = Total_Disc + ''
Mobile.comment('verifying the Comp Disc')

Mobile.verifyEqual(CompDiscvalue.round(2), -CompDiscValueCalculated.round(2))

'Tax Calculation'

'Tax=Value-SKUGross'
double TaxAmt = Value - SkuGross

'Calculation of Tax percentage'
double TaxPercentage = (TaxAmt / SkuGross) * 100

int Tax = Math.round(TaxPercentage)

def TaxText = Tax + ''

Mobile.comment('verifying  TAX Percentage')

Mobile.verifyEqual(TaxText, findTestData('Phase2.1/TY_06/Summary/Summary').getValue(6, 1))


Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/PrintPreticket_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Pre_Ticket_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/PreTicket_Created_Successfully_Ok_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/PreTicket_Print_Preview_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/PreTicket_Print_Preview_Title'), 0, FailureHandling.STOP_ON_FAILURE)

//
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC_165(2)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

