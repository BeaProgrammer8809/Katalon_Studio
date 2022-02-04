import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
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
import java.text.DecimalFormat as DecimalFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        'ProductName', 22), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

value_value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

double value_val_Summary = Double.parseDouble(value_value)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Invoice_Summary/Screenshot'), [('testCaseName') : 'TC_219'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.comment('verifying CompDisc_Value')

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0)

Mobile.comment('verifying OrderValue_Value')

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 0)

Order_value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 0)

double Oder_Val = Double.parseDouble(Order_value)

Comp_Disc = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0)

ls = Comp_Disc.length()

def val_1 = Comp_Disc.substring(2, ls)

double Comp_val = Double.parseDouble(val_1)

E_total = (Oder_Val - Comp_val)

DecimalFormat df = new DecimalFormat('0.00')

Es_Total = df.format(E_total)

Double Expected_total = Double.parseDouble(Es_Total)

Total = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_Value'), 0)

double Actual_Total = Double.parseDouble(Total)

println(Actual_Total)

Mobile.verifyEqual(Expected_total, Actual_Total, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(value_val_Summary, Actual_Total, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/PrintPreticket_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Pre_Ticket_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/PreTicket_Created_Successfully_Ok_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Invoice_Summary/Screenshot'), [('testCaseName') : 'TC_219 PrintPreviewScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

