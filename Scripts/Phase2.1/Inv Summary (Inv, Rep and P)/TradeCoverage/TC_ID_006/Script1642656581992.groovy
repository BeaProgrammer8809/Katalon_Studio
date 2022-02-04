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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
	'RetailerCredit', 2)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyInvoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 30)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyReplacement_Quantity'), [:], FailureHandling.STOP_ON_FAILURE)

def InvoiceQuantity = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 
    0)

def Pieces = Double.parseDouble(InvoiceQuantity)

def Piecesvalue = Math.round(Pieces)

int InvoiceQuantityInOrderScreen = ((Piecesvalue) as int)

def ReturnQuantity = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 
    0)

def Return = Double.parseDouble(ReturnQuantity)

def returnqty = Math.round(Return)

int ReturnQuantityInOrderScreen = ((returnqty) as int)

def Unitprice = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Total_Qty'), 0)

def UnitPrice = Double.parseDouble(Unitprice)

def pricequantity = Math.round(UnitPrice)

int UnitpriceInOrderScreen = ((pricequantity) as int)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 30)], FailureHandling.STOP_ON_FAILURE)

def PBQuantity = Mobile.getText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

def pbquantity = Double.parseDouble(PBQuantity)

def buyingquantity = Math.round(pbquantity)

int PBQuantityInPBScreen = ((buyingquantity) as int)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

/*verification for summary screen*/
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 
    'text', findTestData('Phase2.1/TY_05/Testdata').getValue('Data2', 3), 0)

/*verification done to check edit icon */
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Tag_Icon'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Tag_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

/*Verification done to check the Preticket icon*/
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/PrintPreticket_Icon'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/PrintPreticket_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

/*verification done to check Invoice Number is displaying*/
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_No_Of_Product'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_No_Of_Product'), 0, FailureHandling.STOP_ON_FAILURE)

/*Verification done to check the i icon is displaying */
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

/*Verification done to check the Total Qunatity is displaying  */
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Total_Qty_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Total_Qty_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

/*Verification done to check the Total Value is displaying  */
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

/*Verification done to check the Invoice button is displaying  */
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)

/*Verification done to check Order and invoice or Product buying taken for the SKU should be displayed with its Total value*/
def TotalSkuvalue = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

def Totalvalue = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

Mobile.verifyMatch(TotalSkuvalue, Totalvalue, false, FailureHandling.STOP_ON_FAILURE)

/*The Pieces,Actual Return, U.Price and Sales Return quantity should display with respect to the Order and invoice and Product buying screen*/
Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    InvoiceQuantityInOrderScreen.toString())

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 
    ReturnQuantityInOrderScreen.toString())

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 
    PBQuantityInPBScreen.toString())

def UnitPriceInsummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

def unitpriceinsummary = Double.parseDouble(UnitPriceInsummary)

def pricequantityinsummary = Math.round(unitpriceinsummary)

int UnitpriceInSummaryScreen = ((pricequantityinsummary) as int)

Mobile.verifyMatch(UnitpriceInSummaryScreen.toString(), UnitpriceInOrderScreen.toString(), false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_006'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
