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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 1002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

def productName = findTestData('Phase2.1/Common_Data/CommonData').getValue('Onsite Products', 11)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), productName, 0)

'Provide Product Buying quantity'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIReturnProductBuyingScreen01/Return_Text-View'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

def PbqtyText = Mobile.getText(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

double Pbqty = Double.parseDouble(PbqtyText)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 5, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioProdBuy_EditText'), findTestData(
        'Phase2.1/Common_Data/CommonData').getValue('Folio number', 1), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterPaymentPopup01/OK_Button'), 0)

Mobile.comment('Verifyed the status and UUID generated ')

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/Save _Succesfully_Text'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/Save _Succesfully_Text'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC299(1)'], 
    FailureHandling.STOP_ON_FAILURE)

def UUIDMsg = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/Save _Succesfully_Text'), 0)

def UUIDNo = UUIDMsg.substring(42)

def length = UUIDNo.length()

Mobile.verifyMatch(length.toString(), findTestData('Phase2.1/TY_06/Invoice_Summary/InvoiceSummary').getValue(3, 1), false, 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/OK_Button_Uuid'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), findTestData('Phase2.1/TY_06/Invoice_Summary/InvoiceSummary').getValue(
        2, 1), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC299(2)'], 
    FailureHandling.STOP_ON_FAILURE)

def invSheet = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

def status = findTestData('Phase2.1/TY_06/Invoice_Summary/InvoiceSummary').getValue(4, 1)

boolean res = invSheet.contains(status)

Mobile.comment('Verifying status as success')

Mobile.verifyMatch(res.toString(), findTestData('Phase2.1/TY_06/Invoice_Summary/InvoiceSummary').getValue(5, 1), false, 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

