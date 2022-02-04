import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2/Common_Data/CommonData_03').getValue(2, 3)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,
	0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

for (def i = 0; i < 3; i++) {
	if (i == 0) {
		GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 17)
	} else if (i == 1) {
		GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 8)
	} else {
		GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 11)
	}
	
	Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

	Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

	Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

	Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

	Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

	Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'),
	0, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

def v1 = Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

println('Is screen title displayed as Summary? ' + v1)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_No_Of_Product'), 0,
	FailureHandling.STOP_ON_FAILURE)

def invNum = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_No_Of_Product'), 0)

println('Generated Invoice number is ' + invNum)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def sku2=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0)

println "SKU2 is "+sku2

def totalPrice1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

println('Total price included for sku is ' + totalPrice1)

def pieceQty1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0)

println('invoiced qty is ' + pieceQty1)

def uPrice1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),
	0)

println('unit price for sku is ' + uPrice1)

def expectedTotalPrice1 = Double.parseDouble(uPrice1) * Double.parseDouble(pieceQty1)

DecimalFormat df = new DecimalFormat('0.00')

expectedTotalPrice1 = df.format(expectedTotalPrice1)

Mobile.verifyEqual(totalPrice1, expectedTotalPrice1, FailureHandling.STOP_ON_FAILURE)

println('Invoice amount is product of unit price and pieces')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

def sku3=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0)

println "SKU3 is "+sku3

def totalPrice2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

println('Total price included for sku is ' + totalPrice2)

def pieceQty2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0)

println('invoiced qty is ' + pieceQty2)

def uPrice2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),
	0)

println('unit price for sku is ' + uPrice2)

def expectedTotalPrice2 = Double.parseDouble(uPrice2) * Double.parseDouble(pieceQty2)

expectedTotalPrice2 = df.format(expectedTotalPrice2)

Mobile.verifyEqual(totalPrice2, expectedTotalPrice2, FailureHandling.STOP_ON_FAILURE)

println('Invoice amount is product of unit price and pieces')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 3)

def sku1=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0)

println "SKU1 is "+sku1

def totalPrice3 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

println('Total price included for sku is ' + totalPrice3)

def pieceQty3 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0)

println('invoiced qty is ' + pieceQty3)

def uPrice3 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),
	0)

println('unit price for sku is ' + uPrice3)

def expectedTotalPrice3 = Double.parseDouble(uPrice3) * Double.parseDouble(pieceQty3)

expectedTotalPrice3 = df.format(expectedTotalPrice3)

Mobile.verifyEqual(totalPrice3, expectedTotalPrice3, FailureHandling.STOP_ON_FAILURE)

println('Invoice amount is product of unit price and pieces')

def valuePrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println('Value price for sku is ' + valuePrice)

def IEPS = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(7, 9)

IEPS = Double.parseDouble(IEPS)

println(IEPS)

def IVA = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(7, 8)

IVA = Double.parseDouble(IVA)

println(IVA)

def taxIEPS = Double.parseDouble(expectedTotalPrice3) * (IEPS / 100)

println('Tax included for the sku '+sku1+' is ' + taxIEPS)

def expectedTotalPrice = Double.parseDouble(expectedTotalPrice2) + Double.parseDouble(expectedTotalPrice1)

def taxIVA = expectedTotalPrice * (IVA / 100)

println('Tax included for the skus '+sku2+' and '+sku3+' is ' + taxIVA)

def expectedValuePrice = ((Double.parseDouble(expectedTotalPrice3) + expectedTotalPrice) + taxIVA) + taxIEPS

println(expectedValuePrice)

Mobile.verifyEqual(valuePrice, expectedValuePrice, FailureHandling.STOP_ON_FAILURE)

println('Expected value price is as same as actual value price as Detail IEPS retailer is not selected')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_313_SummaryScreen'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox_Indexing'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText_Indexing'), findTestData(
		'Phase2/Common_Data/CommonData_03').getValue(15, 1), 0, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox_Indexing'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText_Indexing'), findTestData(
		'Phase2/Common_Data/CommonData_03').getValue(15, 1), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'),
	0, FailureHandling.STOP_ON_FAILURE)

def invoiceCreatedMsg = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'),
	0)

println('Invoice message ' + invoiceCreatedMsg)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'),
	0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_313_printScreen_01'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.swipe(0, 700, 0, 50)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_313_printScreen_02'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
