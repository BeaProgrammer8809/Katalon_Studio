import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2/Common_Data/CommonData').getValue(2, 3)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue(5, 4)

Mobile.setText(findTestObject('Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 18)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName,
		0)

def actualInvoicedSKU = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

println('Actual invoiced sku is ' + actualInvoicedSKU)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def actualInvoicedQty = Mobile.getAttribute(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 'text',
		0)

println('Actual inoviced qty for sku is ' + actualInvoicedQty)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

def actualProductBuyingSKU = Mobile.getText(findTestObject('Phase2/BIProductBuyingScreen01/Scheme_Buy_SKU_Text_View'), 0)

println('Actual product buying sku is ' + actualProductBuyingSKU)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

def actualProductBuyingQty = Mobile.getAttribute(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 'text',
		0)

println('Actual product buying qty is ' + actualProductBuyingQty)

Mobile.verifyGreaterThanOrEqual(actualInvoicedQty, actualProductBuyingQty, FailureHandling.STOP_ON_FAILURE)

println('Entered invoiced qty is greater than product buying qty')

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'),
0, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterPaymentPopup01/Payment_CheckBox'), 0)

'Collection Screen'
Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Collection_Title'),
		0)

println('Collection Screen Title is displayed')

'Invoice amount'
Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0, FailureHandling.STOP_ON_FAILURE)

println('Invoice amount is displayed')

'Min amount'
Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/MinAmt_Value'), 0, FailureHandling.STOP_ON_FAILURE)

println('Min amount is displayed')

'Cheque Radio button'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

println('Cheque mode is avilable')

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

'cheque radio button selected'
Mobile.verifyElementHasAttribute(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 'selected', 0, FailureHandling.STOP_ON_FAILURE)

println('Cheque radio button is selected')

'Balance X of XXXX'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Balance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

println('Balance X of XXX is displayed')

'Total paid amount'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/TotalPaid_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

println('Total paid amount is displayed')

'Select Bank'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0, FailureHandling.STOP_ON_FAILURE)

println('Select Bank dropdown is displayed')

'Select Branch'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 0, FailureHandling.STOP_ON_FAILURE)

println('Select Branch dropdown is displayed')

'select cheque type'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectChequeType_DropDown'), 0,
		FailureHandling.STOP_ON_FAILURE)

println('Select cheque type drop down is selected')

'cheque number'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

println('Cheque number edit box is displayed')

'date'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0, FailureHandling.STOP_ON_FAILURE)

println('Date link is displayed')

'upload Image'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Camera_Button'), 0, FailureHandling.STOP_ON_FAILURE)

println('image button is displayed')

'Sumbit button'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0, FailureHandling.STOP_ON_FAILURE)

println('Submit button is displayed')

'Key pad'
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/KeyPad_Complete_Frame'), 0, FailureHandling.STOP_ON_FAILURE)

println('Kay pad is displayed')

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/ScreenShot'),
		[('testCaseName') : 'TC_ID_0393_CollectionScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()