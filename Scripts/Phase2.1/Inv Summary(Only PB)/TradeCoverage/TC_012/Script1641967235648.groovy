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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 19)

Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
def Actual_Bag_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Bag_Value_Indexing'), 0)
def Actual_Return_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 0)
def Actual_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)
def Actual_Total_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Total_Qty_Value'), 0)
def Actual_Sales_Return = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 0)
def Actual_Price_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_012_Element_Values_Before_Editing'], FailureHandling.STOP_ON_FAILURE)
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), '12', 0, FailureHandling.OPTIONAL)
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Bag_Value_Indexing'), '12', 0, FailureHandling.OPTIONAL)
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), '12', 0, FailureHandling.OPTIONAL)
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), '12', 0, FailureHandling.OPTIONAL)
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Total_Qty_Value'), '12', 0, FailureHandling.OPTIONAL)
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), '12', 0, FailureHandling.OPTIONAL)
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), '12', 0, FailureHandling.OPTIONAL)

//Verification to check that Fields are non-editable in in the grid in summary screen
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 'text', Actual_Pieces_Value, 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Bag_Value_Indexing'), 'text', Actual_Bag_Value, 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 'text', Actual_Return_Value, 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 'text',  Actual_Value, 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Total_Qty_Value'), 'text', Actual_Total_Value, 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 'text', Actual_Sales_Return, 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 'text', Actual_Price_Value, 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_012_Element_Values_After_Editing'], FailureHandling.STOP_ON_FAILURE)

println('Fields are non-editable in in the grid in summary screen')
Mobile.closeApplication()