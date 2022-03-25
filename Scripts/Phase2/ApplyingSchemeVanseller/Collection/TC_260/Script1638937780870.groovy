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

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_03/TestData').getValue(2, 19)

println(GlobalVariable.SchemeBuySkuName)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.SchemeBuySkuName, 5)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_5'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

def invPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println('Invoice price is ' + invPrice)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

def ActualGetSKU_Price = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

println('Get SKU total Price is' + ActualGetSKU_Price)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/Collection/Screenshot'), [('testCaseName') : 'TC_260_SummaryScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println('Invoice Amount in Collection screen is ' + invAmt)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 0)

def RefNumBfr = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    0)

println('Refernce number before entering ' + RefNumBfr)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/5_NumButton'), 0)

def n1 = Mobile.getText(findTestObject('Phase2/BINumberKeyboardCollection01/5_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/._NumButton'), 0)

def n2 = Mobile.getText(findTestObject('Phase2/BINumberKeyboardCollection01/._NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/6_NumButton'), 0)

def n3 = Mobile.getText(findTestObject('Phase2/BINumberKeyboardCollection01/6_NumButton'), 0)

println((('The number entered in refernce number edit box is : ' + n1) + n2) + n3)

println((('Actual number entered is ' + n1) + n2) + n3)

def ActualNumAccepted = Mobile.getAttribute(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    'text', 0)

println(ActualNumAccepted)

Mobile.verifyNotEqual(n1 + n2 + n3, ActualNumAccepted, FailureHandling.STOP_ON_FAILURE)

println('Reference number edit box is not accepting decimal point')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/Collection/Screenshot'), [('testCaseName') : 'TC_260_CollectionScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

