import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import java.text.SimpleDateFormat as SimpleDateFormat
import io.appium.java_client.AppiumDriver as AppiumDriver
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
import org.openqa.selenium.WebElement as WebElement

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/InvoicePBReplacement3LegalEntity_Reusable'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Efectivo_CheckBox_Indexing'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Efectivo_CheckBox_Indexing'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Efectivo_CheckBox_Indexing'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Create_Final_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Preticket_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully_OK_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_355'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), findTestData('Phase2.1/TY_06/InvoiceSplitInvoiceReplacement/TradeCoverage').getValue(
        2, 1), FailureHandling.STOP_ON_FAILURE)

def Sheet = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

def RFCID = findTestData('Phase2.1/TY_06/InvoiceSplitInvoiceReplacement/TradeCoverage').getValue(3, 16)

boolean flag = Sheet.contains(RFCID)

Mobile.comment('Verifying the RFC format')

Mobile.verifyMatch(flag.toString(), findTestData('Phase2.1/TY_06/InvoiceSplitInvoiceReplacement/TradeCoverage').getValue(
        4, 1), false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

