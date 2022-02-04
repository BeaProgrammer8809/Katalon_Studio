import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 6), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 6)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(2, 22)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

//Bimbo PB qty-Grouped
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)
def Actual_Bimbo_PB_Qty_Grouped=Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

//Bimbo PB qty- Non Grouped
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0 ,FailureHandling.OPTIONAL)
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 13)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)
def Actual_Bimbo_PB_Qty_Non_Grouped=Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

//Barcel PB qty - Non Grouped
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0 ,FailureHandling.OPTIONAL)
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 21)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)
def Actual_Barcel_PB_Qty_Non_Grouped=Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

//Ricolino PB qty - Non Grouped
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0 ,FailureHandling.OPTIONAL)
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 31)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)
def Actual_Ricolino_PB_Qty_Non_Grouped=Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC48_Actual_PB_Qty'], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

//Bimbo Grouped
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Bimbo_Sales_Return_Grouped = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)

//Bimbo Non Grouped
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Expected_Bimbo_Sales_Return_Non_Grouped = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)

//Barcel Non Grouped
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

def Expected_Barcel_Sales_Return_Non_Grouped = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)

//Ricolino Non Grouped
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

def Expected_Ricolino_Sales_Return_Non_Grouped = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC48_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

//Bimbo Product Buying Grouped
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_Bimbo_PB_Split_Name_Grouped=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Bimbo_PB_Split_Name_Grouped = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 204)
boolean Bimbo_PB_Split_Grouped=Actual_Bimbo_PB_Split_Name_Grouped.contains(Expected_Bimbo_PB_Split_Name_Grouped)

//Bimbo Product Buying Non Grouped
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Actual_Bimbo_PB_Split_Name_Non_Grouped=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Bimbo_PB_Split_Name_Non_Grouped = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 204)
boolean Bimbo_PB_Split_Non_Grouped=Actual_Bimbo_PB_Split_Name_Non_Grouped.contains(Expected_Bimbo_PB_Split_Name_Non_Grouped)

//Barcel Product Buying Non Grouped
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

def Actual_Barcel_PB_Split_Name_Non_Grouped=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Barcel_PB_Split_Name_Non_Grouped = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 204)
boolean Barcel_PB_Split_Non_Grouped=Actual_Barcel_PB_Split_Name_Non_Grouped.contains(Expected_Barcel_PB_Split_Name_Non_Grouped)

//Ricolino Product Buying
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

def Actual_Ricolino_PB_Split_Name_Non_Grouped=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Ricolino_PB_Split_Name_Non_Grouped = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 204)
boolean Ricolino_PB_Split_Non_Grouped=Actual_Ricolino_PB_Split_Name_Non_Grouped.contains(Expected_Ricolino_PB_Split_Name_Non_Grouped)

//Verification to check that Invoice split name is displayed as Expected for Bimbo - Grouped
Mobile.verifyMatch(Bimbo_PB_Split_Grouped.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 204), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that PB split name is displayed as Expected for Bimbo - Non Grouped
Mobile.verifyMatch(Bimbo_PB_Split_Non_Grouped.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 204), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that PB split name is displayed as Expected for Barcel - Non Grouped
Mobile.verifyMatch(Barcel_PB_Split_Non_Grouped.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 204), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that PB split name is displayed as Expected for Ricolino - Non Grouped
Mobile.verifyMatch(Ricolino_PB_Split_Non_Grouped.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 204), false, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyPB/ProductBuyingDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC48_PB_Qty_For_Grouped_&_Non_Grouped_SKU'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the PB Qty for Bimbo SKU Grouped
Mobile.verifyEqual(Actual_Bimbo_PB_Qty_Grouped, Expected_Bimbo_Sales_Return_Grouped, FailureHandling.STOP_ON_FAILURE)

//Verification to check the PB Qty for Bimbo SKU Non Grouped
Mobile.verifyEqual(Actual_Bimbo_PB_Qty_Non_Grouped, Expected_Bimbo_Sales_Return_Non_Grouped, FailureHandling.STOP_ON_FAILURE)

//Verification to check the PB Qty for Barcel SKU Non Grouped
Mobile.verifyEqual(Actual_Barcel_PB_Qty_Non_Grouped, Expected_Barcel_Sales_Return_Non_Grouped, FailureHandling.STOP_ON_FAILURE)

//Verification to check the PB Qty for Ricolino SKU Non Grouped
Mobile.verifyEqual(Actual_Ricolino_PB_Qty_Non_Grouped, Expected_Ricolino_Sales_Return_Non_Grouped, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()