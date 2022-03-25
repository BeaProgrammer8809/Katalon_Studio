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
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)
Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(14, 16), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_02').getValue(6, 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

//Verification to check Scheme buy sku should be displayed in delivery summary screen,when scheme buy and get sku should be added in different split group
GlobalVariable.Buysku = findTestData('Phase2/Common_Data/CommonData_02').getValue('Buysku', 1)

GlobalVariable.Getsku = findTestData('Phase2/Common_Data/CommonData_02').getValue('Getsku', 1)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_BUY_SKU_Name = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
println(Actual_BUY_SKU_Name)

def Actual_BUY_Pieces = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
println(Actual_BUY_Pieces)

def Actual_BUY_Order_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
println(Actual_BUY_Order_Qty)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.takeScreenshot()

def Actual_Delivery_BUY_SKU_Name = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Product_Name_Text'), 30, FailureHandling.STOP_ON_FAILURE)
println(Actual_Delivery_BUY_SKU_Name)

def Actual_Delivery_Stock_Delivered = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text'), 30, FailureHandling.STOP_ON_FAILURE)
println(Actual_Delivery_Stock_Delivered)

def Actual_Delivery_SRP = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/SRP_Text'), 30, FailureHandling.STOP_ON_FAILURE)
println(Actual_Delivery_SRP)

Mobile.verifyMatch(Actual_BUY_SKU_Name, Actual_Delivery_BUY_SKU_Name, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_BUY_Pieces, Actual_Delivery_Stock_Delivered, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_BUY_Order_Qty, Actual_Delivery_SRP, false, FailureHandling.STOP_ON_FAILURE)

Mobile.takeScreenshot()
Mobile.closeApplication()
