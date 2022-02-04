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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue(2, 7)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIBlueLabelProcess01/Back_Button'), 0, FailureHandling.OPTIONAL)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_3'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_3'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 21)], FailureHandling.STOP_ON_FAILURE)

'To Tap on NEXT button in Product_Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_No._TextView'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.setText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
        4, 10), 0)

def FolioNOEnteredIndex1 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), 0)
Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox_Indexing'), 0)
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)
Mobile.setText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
        4, 10), 0)
def FolioNOEnteredIndex2 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), 0)
Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox_Indexing'), 0)
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)
Mobile.setText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
        4, 10), 0)
def FolioNOEnteredIndex3 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)
Mobile.setText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
        4, 10), 0)
def FolioNOEnteredIndex4 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_255AcceptedFolioNo'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyNotMatch(FolioNOEnteredIndex1, findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
	4, 10), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyNotMatch(FolioNOEnteredIndex2, findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
	4, 10), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyNotMatch(FolioNOEnteredIndex3, findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
	4, 10), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyNotMatch(FolioNOEnteredIndex4, findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
	4, 10), false, FailureHandling.STOP_ON_FAILURE)

println("We cannot enter more than 15 cahracters for Folio No field")

Mobile.closeApplication()