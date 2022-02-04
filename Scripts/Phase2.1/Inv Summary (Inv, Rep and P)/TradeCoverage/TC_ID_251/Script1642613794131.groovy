import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 6), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 6)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(2, 3)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Bimbo_SKU_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_251_Bimbo_SKU_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 15)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Barcel_SKU_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_251_Barcel_SKU_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Bimbo_PB_Qty=Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_251_Actual_Bimbo_PB_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.clearText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0 ,FailureHandling.OPTIONAL)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 15)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Barcel_PB_Qty=Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_251_Actual_Barcel_PB_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Bimbo_SKU_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Bimbo_Sales_Return = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Expected_Barcel_SKU_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Barcel_Sales_Return = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_251_Expected_Bimbo&Barcel_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

//Verification to check the legal entity name for Barcel
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)
def Actual_Barcel_Legal_Entity_Name = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/LegalEntityName_TextView _Indexing'), 0)
def Expected_Barcel_Legal_Entity_Name = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 128)
Mobile.verifyMatch(Actual_Barcel_Legal_Entity_Name, Expected_Barcel_Legal_Entity_Name, false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox_Indexing'), 0)

//Verification to check that pestio is displayed
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0, FailureHandling.OPTIONAL)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_251_Barcel_Pesito_Radio_Button'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

//Verification to check the legal entity name for Bimbo
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)
def Actual_Bimbo_Legal_Entity_Name = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/LegalEntityName_TextView _Indexing'), 0)
def Expected_Bimbo_Legal_Entity_Name = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 128)
Mobile.verifyMatch(Actual_Bimbo_Legal_Entity_Name, Expected_Bimbo_Legal_Entity_Name, false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox_Indexing'), 0)

//Verification to check that pestio is displayed
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_251_Bimbo_Pesito_Radio_Button'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the invoice and PB qty for Bimbo SKU
Mobile.verifyMatch(Bimbo_SKU_Pieces_Value, Expected_Bimbo_SKU_Pieces_Value, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Bimbo_PB_Qty, Expected_Bimbo_Sales_Return, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check the invoice and PB qty for Barcel SKU
Mobile.verifyMatch(Barcel_SKU_Pieces_Value, Expected_Barcel_SKU_Pieces_Value, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Barcel_PB_Qty, Expected_Barcel_Sales_Return, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()