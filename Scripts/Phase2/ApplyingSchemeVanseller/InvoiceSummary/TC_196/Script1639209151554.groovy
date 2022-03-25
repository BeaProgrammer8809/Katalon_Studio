import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

GlobalVariable.Getsku = findTestData('Phase2/Common_Data/CommonData_01').getValue(6, 3)

GlobalVariable.Buysku = findTestData('Phase2/Common_Data/CommonData_01').getValue(5, 3)

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_01/Test_Data').getValue(
        2, 24), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def BuyPieces = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

println(BuyPieces)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def BuyUnitPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

println(BuyUnitPrice)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def Expected_InvoiceAmount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

println(Expected_InvoiceAmount)

def InvoiceAmount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println(InvoiceAmount)

// pieces*unit_price = invoice amount
def Actual_Amount = Integer.parseInt(BuyPieces) * Float.parseFloat(BuyUnitPrice)

println(Actual_Amount)

DecimalFormat df = new DecimalFormat('0.00')

Actual_Amount = df.format(Actual_Amount)

println(Actual_Amount)

//compare total value with buyprice value for tax verification-------------------
Mobile.verifyMatch(Actual_Amount, Expected_InvoiceAmount, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyNotMatch(InvoiceAmount, Expected_InvoiceAmount, false, FailureHandling.STOP_ON_FAILURE)

println('Tax is  applied for the scheme free sku')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 2)

def get_price = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

println(get_price)

//Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/GetSchemeDetails/Get_Price_Value_1'), 0)
Mobile.verifyEqual(get_price, findTestData('Phase2/TY_01/Test_Data').getValue(4, 24))

println('No price is included for GetSku')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_196'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

