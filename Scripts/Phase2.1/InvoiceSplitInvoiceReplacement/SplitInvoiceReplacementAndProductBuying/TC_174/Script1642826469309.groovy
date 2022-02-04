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
            'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Product_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 19)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox_Indexing'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

println('Collection title is visible')

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

println(' Cheques mode is displayed')

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

println(' CreditNote mode is displayed')

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

println(' Efectivo mode is displayed')

Mobile.waitForElementPresent(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

boolean radiobutton = Mobile.getAttribute(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 'selected', 
    0)

def verifyradiobuttonchecked = radiobutton.toString()

Mobile.verifyMatch(verifyradiobuttonchecked, findTestData('Phase2.1/TY_01/TestData2').getValue(4, 71), false, FailureHandling.STOP_ON_FAILURE)

println('Efectivo mode is selected default')

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

println('TransferenciasElectronicas mode is displayed')

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 
    0)

println "pesitoCredit mode is displayed"

def MinAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/MinAmt_Value'), 0)

println(MinAmt)

println(' Minimum amount details is displayed')

def InvAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)

println(InvAmt)

def InvoiceAmount = 'Total Paid : ' + InvAmt

println(InvoiceAmount)

println('Invoice Amount details is displayed')

def CashBalance = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0)

println(CashBalance)

println('Balance is displayed')

Mobile.verifyElementVisible(findTestObject('Phase2/BINumberKeyboardCollection01/NumberKeyBoard_ALL'), 0, FailureHandling.STOP_ON_FAILURE)

println('keypad is displayed')

def CashTotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    0)

println(CashTotalPaid)

Mobile.verifyMatch(InvoiceAmount, CashTotalPaid, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/SplitInvoiceReplacementAndProductBuying/Screenshot'), 
    [('testCaseName') : 'TC_174'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

