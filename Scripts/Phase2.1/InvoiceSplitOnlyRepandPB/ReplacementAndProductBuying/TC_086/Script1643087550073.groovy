import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
	'Phase2/Common_Data/CommonData_03').getValue(2, 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 26)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 3)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/AddAnotherReasonQuantity_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

GlobalVariable.DropdownName = findTestData('Phase2/Common_Data/CommonData_03').getValue(17, 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'),
0, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def SkuName=Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0)

println "Ricolino sku name is "+ SkuName

def ReturnQty=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),
		0)

def ProductBuyQty=Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 0)

def SRP=Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_086_SummaryScreen'],
FailureHandling.STOP_ON_FAILURE)

DecimalFormat df=new DecimalFormat("0.00")

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def invName1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'),
		0)

def line1=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), 0)

def skuQty1=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

def amount1=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

def expInvName1=findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(2, 25)+'3'

Mobile.verifyMatch(invName1, expInvName1, false, FailureHandling.OPTIONAL)

println "Invoice name as expected"

def expAmt1=Double.parseDouble(SRP)*Double.parseDouble(skuQty1)

expAmt1=df.format(expAmt1)

Mobile.verifyGreaterThanOrEqual(amount1, expAmt1, FailureHandling.STOP_ON_FAILURE)

println "Expected amount is greater than or equal to actual amount as tax is considered for sku"

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

def invName2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'),
		0)

def line2=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), 0)

def skuQty2=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

def amount2=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

def expInvName2=findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(2, 36)+'1'

Mobile.verifyMatch(invName2, expInvName2, false, FailureHandling.OPTIONAL)

println "Invoice name as expected"

def expAmt2=Double.parseDouble(skuQty2)*Double.parseDouble(SRP)

expAmt2=df.format(expAmt2)

Mobile.verifyGreaterThanOrEqual(amount2, expAmt2, FailureHandling.STOP_ON_FAILURE)

println "Amount is as expected and tax is considered"

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_086_DeliveryFinalSummaryScreen'],
FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

