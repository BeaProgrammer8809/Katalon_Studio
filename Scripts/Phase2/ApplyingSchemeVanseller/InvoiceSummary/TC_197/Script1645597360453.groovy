import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

GlobalVariable.Getsku = findTestData('Phase2/Common_Data/CommonData_01').getValue(6, 3)

GlobalVariable.Buysku = findTestData('Phase2/Common_Data/CommonData_01').getValue(5, 3)

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/Common_Data/CommonData_03').getValue(
        'ProductName', 63), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

def BuySkuPiecePrice = Mobile.getText(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

double BuySkuPiecePrice1 = Double.parseDouble(BuySkuPiecePrice)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

def BuySkuUnitPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_U.Price_Value'), 
    0)

double BuySkuUnitPrice1 = Double.parseDouble(BuySkuUnitPrice)

double BuySkuTotalPrice = (BuySkuPiecePrice1 * BuySkuUnitPrice1)

double BuySkuTotalPrice1 = ( BuySkuTotalPrice * (10/100))

double ExpectedBuySkuPrice = (BuySkuTotalPrice - BuySkuTotalPrice1)

ExpectedBuySkuPrice = ExpectedBuySkuPrice.round(2)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def ActualBuySkuPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 0)

double ActualBuySkuPrice1 = Double.parseDouble(ActualBuySkuPrice)

Mobile.verifyMatch(ActualBuySkuPrice, ExpectedBuySkuPrice.toString(), false, FailureHandling.STOP_ON_FAILURE)

def ActualGetSkuPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/GetSchemeDetails/Get_Price_Value'), 
    0)

println(ActualGetSkuPrice)

def ExpectedGetSkuPrice = findTestData('Phase2/Common_Data/CommonData_03').getValue('Number', 10)

'Verification for Get Sku that whether 100% Discount is added or not'

Mobile.verifyMatch(ActualGetSkuPrice, ExpectedGetSkuPrice, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_197'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

