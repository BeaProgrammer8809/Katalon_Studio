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

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Bimbo_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_064_Actual_Bimbo_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 16)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Barcel_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_064_Actual_Barcel_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 29)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Ricolino_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_064_Actual_Ricolino_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

//Bimbo PB qty
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Button'), 0)
Mobile.clearText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)
Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(17, 1)
	
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Bimbo_Sales_Return1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/AddAnotherReasonQuantity_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Bimbo_Sales_Return2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)
def Actual_Bimbo_PB_Qty = Integer.parseInt(Actual_Bimbo_Sales_Return1) + Integer.parseInt(Actual_Bimbo_Sales_Return2)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_064_Actual_Sales_Return'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

//Barcel PB qty
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0 ,FailureHandling.OPTIONAL)
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 16)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Button'), 0)
Mobile.clearText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)
Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(17, 1)
	
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Barcel_Sales_Return1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/AddAnotherReasonQuantity_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Barcel_Sales_Return2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)
def Actual_Barcel_PB_Qty = Integer.parseInt(Actual_Barcel_Sales_Return1) + Integer.parseInt(Actual_Barcel_Sales_Return2)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_064_Actual_Sales_Return'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

//Ricolino PB qty
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0 ,FailureHandling.OPTIONAL)
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 29)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Button'), 0)
Mobile.clearText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)
Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(17, 1)
	
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Ricolino_Sales_Return1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/AddAnotherReasonQuantity_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Ricolino_Sales_Return2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)
def Actual_Ricolino_PB_Qty = Integer.parseInt(Actual_Ricolino_Sales_Return1) + Integer.parseInt(Actual_Ricolino_Sales_Return2)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_064_Actual_Sales_Return'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

//Bimbo
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Bimbo_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)
def Expected_Bimbo_Sales_Return = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)

//Barcel
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Expected_Barcel_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)
def Expected_Barcel_Sales_Return = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)

//Ricolino
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

def Expected_Ricolino_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)
def Expected_Ricolino_Sales_Return = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_064_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

//Bimbo Invoice Split
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_Bimbo_Invoice_Split_Name=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Bimbo_Invoice_Split_Name = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 203)
boolean Bimbo_Invoice_Split =Actual_Bimbo_Invoice_Split_Name.contains(Expected_Bimbo_Invoice_Split_Name)
def Actual_Bimbo_Invoice_Split_SKU_Qty=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)
def Expected_Bimbo_Invoice_Split_SKU_Qty = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(6, 203)

//Barcel Invoice Split
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Actual_Barcel_Invoice_Split_Name=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Barcel_Invoice_Split_Name = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 203)
boolean Barcel_Invoice_Split =Actual_Barcel_Invoice_Split_Name.contains(Expected_Barcel_Invoice_Split_Name)
def Actual_Barcel_Invoice_Split_SKU_Qty=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)
def Expected_Barcel_Invoice_Split_SKU_Qty = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(6, 203)

//Ricolino Invoice Split
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

def Actual_Ricolino_Invoice_Split_Name=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Ricolino_Invoice_Split_Name = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 203)
boolean Ricolino_Invoice_Split =Actual_Ricolino_Invoice_Split_Name.contains(Expected_Ricolino_Invoice_Split_Name)
def Actual_Ricolino_Invoice_Split_SKU_Qty=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)
def Expected_Ricolino_Invoice_Split_SKU_Qty = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(6, 203)

//Bimbo Product Buying
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

def Actual_Bimbo_PB_Split_Name=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Bimbo_PB_Split_Name = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 203)
boolean Bimbo_PB_Split=Actual_Bimbo_PB_Split_Name.contains(Expected_Bimbo_PB_Split_Name)
def Actual_Bimbo_PB_Split_SKU_Qty=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)
def Expected_Bimbo_PB_Split_SKU_Qty = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(6, 203)

//Barcel Product Buying
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

def Actual_Barcel_PB_Split_Name=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Barcel_PB_Split_Name = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 203)
boolean Barcel_PB_Split=Actual_Barcel_PB_Split_Name.contains(Expected_Barcel_PB_Split_Name)
def Actual_Barcel_PB_Split_SKU_Qty=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)
def Expected_Barcel_PB_Split_SKU_Qty = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(6, 203)

//Ricolino Product Buying
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 6)

def Actual_Ricolino_PB_Split_Name=Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
def Expected_Ricolino_PB_Split_Name = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 203)
boolean Ricolino_PB_Split=Actual_Ricolino_PB_Split_Name.contains(Expected_Ricolino_PB_Split_Name)
def Actual_Ricolino_PB_Split_SKU_Qty=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)
def Expected_Ricolino_PB_Split_Invoice_Split_SKU_Qty = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(6, 203)

//Verification to check that Invoice split name is displayed as Expected for Bimbo
Mobile.verifyMatch(Bimbo_Invoice_Split.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 203), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that Invoice split name is displayed as Expected for Barcel
Mobile.verifyMatch(Barcel_Invoice_Split.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 203), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that Invoice split name is displayed as Expected for Ricolino
Mobile.verifyMatch(Ricolino_Invoice_Split.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 203), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that PB split name is displayed as Expected for Bimbo
Mobile.verifyMatch(Bimbo_PB_Split.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 203), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that PB split name is displayed as Expected for Barcel
Mobile.verifyMatch(Barcel_PB_Split.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 203), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that PB split name is displayed as Expected for Ricolino
Mobile.verifyMatch(Ricolino_PB_Split.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 203), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check the SKU Qty for Bimbo Invoice split
Mobile.verifyEqual(Actual_Bimbo_Invoice_Split_SKU_Qty, Expected_Bimbo_Invoice_Split_SKU_Qty, FailureHandling.STOP_ON_FAILURE)

//Verification to check the SKU Qty for Barcel Invoice split
Mobile.verifyEqual(Actual_Barcel_Invoice_Split_SKU_Qty, Expected_Barcel_Invoice_Split_SKU_Qty, FailureHandling.STOP_ON_FAILURE)

//Verification to check the SKU Qty for Ricolino Invoice split
Mobile.verifyEqual(Actual_Ricolino_Invoice_Split_SKU_Qty, Expected_Ricolino_Invoice_Split_SKU_Qty, FailureHandling.STOP_ON_FAILURE)

//Verification to check the Line value for Bimbo PB split
Mobile.verifyEqual(Actual_Bimbo_PB_Split_SKU_Qty, Expected_Bimbo_PB_Split_SKU_Qty, FailureHandling.STOP_ON_FAILURE)

//Verification to check the Line value for Barcel PB split
Mobile.verifyEqual(Actual_Barcel_PB_Split_SKU_Qty, Expected_Barcel_PB_Split_SKU_Qty, FailureHandling.STOP_ON_FAILURE)

//Verification to check the Line value for Ricolino PB split
Mobile.verifyEqual(Actual_Ricolino_PB_Split_SKU_Qty, Expected_Ricolino_PB_Split_Invoice_Split_SKU_Qty, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_064_Invoice_Split_&_PB_Split_Name_And_SKU_Qty'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the Return Qty and PB Qty for Bimbo SKU
Mobile.verifyEqual(Actual_Bimbo_Return_Qty, Expected_Bimbo_Return_Qty, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Bimbo_PB_Qty, Expected_Bimbo_Sales_Return, FailureHandling.STOP_ON_FAILURE)

//Verification to check the Return Qty and PB Qty for Barcel SKU
Mobile.verifyEqual(Actual_Bimbo_Return_Qty, Expected_Barcel_Return_Qty, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Barcel_PB_Qty, Expected_Barcel_Sales_Return, FailureHandling.STOP_ON_FAILURE)

//Verification to check the Return Qty and PB Qty for Ricolino SKU
Mobile.verifyEqual(Actual_Bimbo_Return_Qty, Expected_Ricolino_Return_Qty, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Ricolino_PB_Qty, Expected_Ricolino_Sales_Return, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()