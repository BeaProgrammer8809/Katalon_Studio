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

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Reusable Cases/Order_Invoice_Inv Summary_Return'), 
    [:], FailureHandling.STOP_ON_FAILURE)

txtinvoiceAmt = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/invoice_amt'), 
    0)

println(txtinvoiceAmt)

txtinvoiceReturnAmt = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/invoice_return_amt'), 
    0, FailureHandling.STOP_ON_FAILURE)

println(txtinvoiceReturnAmt)

Float totPaidValue = Float.parseFloat(txtinvoiceAmt) - Float.parseFloat(txtinvoiceReturnAmt)

println(totPaidValue)

String totalInvoiceAmt = String.format('%.02f', totPaidValue)

println(totalInvoiceAmt)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/PayMentCheckBox'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Efectivo_CollectionTextbox'), 
    0)

txtBeforePaidAmount = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Efectivo_CollectionTextbox'), 
    0)

println(txtBeforePaidAmount)

Mobile.verifyMatch(totalInvoiceAmt, txtBeforePaidAmount, false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/header_Collection'), 
    0)

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/header_Collection'), 
    0)

if (Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/header_Collection'), 
    0)) {
    println('Collection icon should be hidden after submitting the invoice amount in any collection modes')
}

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/PayMentCheckBox'), 
    0)

txtAfterSubmitPaidAmount = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Efectivo_CollectionTextbox'), 
    0)

println(txtAfterSubmitPaidAmount)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0)

Mobile.verifyMatch(txtBeforePaidAmount, txtAfterSubmitPaidAmount, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

