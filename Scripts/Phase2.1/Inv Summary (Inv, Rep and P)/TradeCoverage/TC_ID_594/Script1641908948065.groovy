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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Product_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Product_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 15)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Product_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 27)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText_Indexing'), 
    findTestData('Phase2.1/Common_Data/CommonData').getValue('Folio number', 1), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText_Indexing'), 
    findTestData('Phase2.1/Common_Data/CommonData').getValue('Folio number', 2), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 3)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText_Indexing'), 
    findTestData('Phase2.1/Common_Data/CommonData').getValue('Folio number', 3), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/PrintPreview_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/PrintPreview_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIPrintPreviewScreen/Printer_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIPrintPreviewScreen/Printer_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_594'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

