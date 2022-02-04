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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 19)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 19)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def NetAmount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println(NetAmount)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def InvAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)

println(InvAmt)

def InvoiceAmount = 'Total Paid : ' + InvAmt

println(InvoiceAmount)

def EfectivoTotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    0)

println("$EfectivoTotalPaid")

Mobile.verifyEqual(InvoiceAmount, EfectivoTotalPaid, FailureHandling.STOP_ON_FAILURE)

println('Total paid is equal to aggregated amount in Efectivo mode')

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

def ChequeTotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/TotalPaid_TextView'), 
    0)

println(ChequeTotalPaid)

Mobile.verifyEqual(InvoiceAmount, ChequeTotalPaid, FailureHandling.STOP_ON_FAILURE)

println('Total paid is equal to aggregated amount in Cheque mode')

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

def TransferenciasTotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/TotalPaid_TextView'), 
    0)

println(TransferenciasTotalPaid)

Mobile.verifyEqual(InvoiceAmount, TransferenciasTotalPaid, FailureHandling.STOP_ON_FAILURE)

println('Total paid is equal to aggregated amount in Transferencias mode')

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

def CreditTotalPaid=Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/TotalPaid_TextView'), 0)
println CreditTotalPaid

Mobile.verifyEqual(InvoiceAmount, CreditTotalPaid, FailureHandling.STOP_ON_FAILURE)

println('Total paid is equal to aggregated amount in Credit mode')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_109'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()