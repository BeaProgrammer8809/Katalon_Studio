import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        2, 18), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        3, 18), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        5, 17), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_05').getValue(7, 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberPad/Num- 1'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 
    0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 
    0)

def Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 
    0)

def Expected = findTestData('Phase2/TY_05/Applying_Scheme').getValue(4, 18)

Mobile.verifyMatch(Actual, Expected, false, FailureHandling.STOP_ON_FAILURE)

println('Delivery Split Screen Page Should displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/InvoiceName_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/InvoiceName_TextView'), 0)

println('Invoice Name should displayed')

Mobile.verifyElementVisible(findTestObject('Phase2/BISplitDeliverySummary01/Stock Delivered_Text'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BISplitDeliverySummary01/Stock Delivered_Text'), 0)

println('StockDelivered should displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/ExtraInv1_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/ExtraInv1_TextView'), 0)

println('ExtraInvioce should displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 
    0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 
    0)

Mobile.verifyElementText(findTestObject('Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        5, 18), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/DeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_336'], 
    FailureHandling.STOP_ON_FAILURE)

println('Create Final Invoice Button')

Mobile.closeApplication()

