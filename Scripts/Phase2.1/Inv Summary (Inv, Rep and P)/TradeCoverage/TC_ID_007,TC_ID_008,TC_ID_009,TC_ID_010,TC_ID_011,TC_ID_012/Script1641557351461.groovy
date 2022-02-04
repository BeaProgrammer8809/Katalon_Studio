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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement
import java.time.LocalDate as LocalDate

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyInvoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 30)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyReplacement_Quantity'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def ActualReplacementQuantyINOrderScreen = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 
    0)

def ActualPiecesQtyINOrderScreen = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 
    0)

def SRPPriceInOrderScreen = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/SRP_Price'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 30)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 30), 0)

def QtyInProductBuying = Mobile.getText( findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

def ReturnQtyInProductBuying= QtyInProductBuying.replaceAll('.00','')

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)


Mobile.verifyElementText( findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 28))


def ActualSkuName = Mobile.getText( findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing')
, 0)

def PiecesInSummary=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

def ReturnQtyInSummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 0)

def UnitPriceInSummary=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing') , 0)

def ReturnValueInSummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 0)

/*Verification for Sku Name  (TC_ID_007)*/

Mobile.verifyMatch(ActualSkuName,findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 30) , false,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_007'],
	FailureHandling.STOP_ON_FAILURE)
/*Verification for Pieces Quantity  (TC_ID_008) */

Mobile.verifyMatch(ActualPiecesQtyINOrderScreen, PiecesInSummary, false ,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_008'],
	FailureHandling.STOP_ON_FAILURE)

/*Verification for Actual Return  Quantity (TC_ID_009)  */

Mobile.verifyMatch(ActualReplacementQuantyINOrderScreen, ReturnQtyInSummary, false ,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_009'],
	FailureHandling.STOP_ON_FAILURE)

/*Verification for UnitPrice  (TC_ID_010)*/

Mobile.verifyMatch(SRPPriceInOrderScreen, UnitPriceInSummary, false , FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_010'],
	FailureHandling.STOP_ON_FAILURE)

/*Verification for Sales Return Quantity TC_ID_011 */

Mobile.verifyMatch(ReturnQtyInProductBuying, ReturnValueInSummary, false , FailureHandling.STOP_ON_FAILURE)


Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_011'],
	FailureHandling.STOP_ON_FAILURE)

/*Verification done to check Total price should display the SKU gross price  i.e (piece qty * U.Price) since there are no discounts are available for the sku's (TC_ID_012)*/

def PiecesAndUnitPrice = Double.parseDouble(PiecesInSummary) * Double.parseDouble(UnitPriceInSummary)

def Piecesunitprice = Math.round(PiecesAndUnitPrice)

def  CalculatedPiecesAndUnitPrice = (int) Piecesunitprice

/*def MultiplyOfPiecesAndUnitprice = PiecesAndUnitPrice.toString()
*/
def TotalPriceInSummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 0)

def Totaldoublevalue =  Double.parseDouble(TotalPriceInSummary)

def Piecesvalue = Math.round(Totaldoublevalue)

TotalPricevalueInSummary= (int) Piecesvalue

/*Verification done to check Total price should display the SKU gross price  i.e (piece qty * U.Price) since there are no discounts are available for the sku's (TC_ID_012)*/
Mobile.verifyMatch(CalculatedPiecesAndUnitPrice.toString(), TotalPricevalueInSummary.toString(), false,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_012'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()











