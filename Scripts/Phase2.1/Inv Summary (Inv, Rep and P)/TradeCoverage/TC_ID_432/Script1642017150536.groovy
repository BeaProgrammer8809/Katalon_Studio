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

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_432_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_432_Actual_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_432_Expected_Qty_Values'], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_432_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

//Verification that Folio number popup is displayed
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/EnterTheFolioNumber_PopupTitle'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check that 1.“Folio No” & “Folio ProdBuy”fields should accept the given input
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 52), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_432_Actual_Folio_Num'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 0, FailureHandling.OPTIONAL)
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Submit_Button'), 0)

//Verifying whether Folio number is accepted
//Mobile.verifyElementHasAttribute(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'),'Test_123-345', 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'), 'text', 'Test_123-345', 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

//Verifying that input is accepted and invoice created popup is displayed
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

//Verification to check that 2.Invoice should get generate for the given “Folio No” & “Folio ProdBuy” input 
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_432_Expected_Print_Preview_Folio_Number'], FailureHandling.STOP_ON_FAILURE)

def Print_Preview_text = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)
def Folio = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(6, 57)
def No = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 57)
def FoiloNo = Folio + No
boolean Actual_Number = Print_Preview_text.contains(FoiloNo)

//Verification of Folio number in Print Preview screen
Mobile.verifyMatch(Actual_Number.toString(),findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 51), false,FailureHandling.STOP_ON_FAILURE)

//Verification to check the Invoice Qty andReturn Qty
Mobile.verifyEqual(Actual_Pieces_Value, Expected_Pieces_Value, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Return_Qty, Expected_Return_Qty, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()