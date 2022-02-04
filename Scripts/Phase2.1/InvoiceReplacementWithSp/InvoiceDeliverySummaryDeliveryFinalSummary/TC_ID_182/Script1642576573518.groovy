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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2/Common_Data/CommonData_03').getValue(2, 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

for (def i = 0; i < 6; i++) {
    if (i == 0) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 1)
    } else if (i == 1) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 18)
    } else if (i == 2) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 26)
    } else if (i == 3) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 8)
    } else if (i == 4) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 21)
    } else {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 32)
    }
    
    Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

    Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

    Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def invName4 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 
    0)

println('Invoice name generated is ' + invName4)

def expInvName4 = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(2, 25) + '3'

Mobile.verifyMatch(invName4, expInvName4, false, FailureHandling.STOP_ON_FAILURE)

println(' Invoice name is as expected')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

def invName5 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 
    0)

println('Invoice name generated is ' + invName5)

def expInvName5 = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(2, 25) + '4'

Mobile.verifyMatch(invName5, expInvName5, false, FailureHandling.STOP_ON_FAILURE)

println(' Invoice name is as expected')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 3)

def invName1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 
    0)

println('Invoice name generated is ' + invName1)

def expInvName1 = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(2, 24) + '1'

Mobile.verifyMatch(invName1, expInvName1, false, FailureHandling.STOP_ON_FAILURE)

println(' Invoice name is as expected ')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 4)

def invName2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 
    0)

println('Invoice name generated is ' + invName2)

def expInvName2 = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(2, 24) + '2'

Mobile.verifyMatch(invName2, expInvName2, false, FailureHandling.STOP_ON_FAILURE)

println(' Invoice name is as expected ')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 5)

def invName3 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 
    0)

println('Invoice name generated is ' + invName3)

def expInvName3 = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(2, 24) + '3'

Mobile.verifyMatch(invName3, expInvName3, false, FailureHandling.STOP_ON_FAILURE)

println(' Invoice name is as expected ')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_182_DelieverySummaryScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

