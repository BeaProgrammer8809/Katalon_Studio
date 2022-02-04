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
import java.text.DecimalFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 2)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 12)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 15)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 24)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 26)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 36)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 2)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 12)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 15)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 24)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 26)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 36)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)


GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def InvspAmt1=Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

def InvoiceSplitAmt1=Double.parseDouble(InvspAmt1)
println InvoiceSplitAmt1

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def DefInvAmt1=Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

def ExpectedDefInvAmt1=Double.parseDouble(DefInvAmt1)
println ExpectedDefInvAmt1

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 3)

def InvspAmt2=Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

def InvoiceSplitAmt2=Double.parseDouble(InvspAmt2)
println InvoiceSplitAmt2

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 4)

def DefInvAmt2=Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

def ExpectedDefInvAmt2=Double.parseDouble(DefInvAmt2)
println ExpectedDefInvAmt2


GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)
InvspAmt3=Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

def InvoiceSplitAmt3=Double.parseDouble(InvspAmt3)
println InvoiceSplitAmt3

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 6)
def DefInvAmt3=Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

def ExpectedDefInvAmt3=Double.parseDouble(DefInvAmt3)
println ExpectedDefInvAmt3

def InvoiceAmount= (InvoiceSplitAmt1) + (InvoiceSplitAmt2) + (InvoiceSplitAmt3)

println InvoiceAmount

DecimalFormat df = new DecimalFormat('0.00')

ExpectedInvoiceAmount = df.format(InvoiceAmount)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def Invoice_Split_Text = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

println(Invoice_Split_Text)

def split = Invoice_Split_Text.split('-')

Actual_Invoice_split = (split[0])

println(Actual_Invoice_split)

def ActualInvoiceAmount=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println ActualInvoiceAmount


GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def DefaultInv1 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

println(DefaultInv1)

def ActualDefInvAmount1=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println ActualDefInvAmount1

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 3)

def DefaultInv2 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

println(DefaultInv2)

def ActualDefInvAmount2=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println ActualDefInvAmount2

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 4)

def DefaultInv3 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

println(DefaultInv3)

def ActualDefInvAmount3=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println ActualDefInvAmount3

Mobile.verifyMatch(Actual_Invoice_split, findTestData('Phase2.1/TY_01/TestData2').getValue(4, 58), false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(DefaultInv1, findTestData('Phase2.1/TY_01/TestData2').getValue(5, 58), false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(DefaultInv2, findTestData('Phase2.1/TY_01/TestData2').getValue(6, 58), false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(DefaultInv3, findTestData('Phase2.1/TY_01/TestData2').getValue(7, 58), false, FailureHandling.STOP_ON_FAILURE)


Mobile.verifyLessThanOrEqual(ActualInvoiceAmount, ExpectedInvoiceAmount, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyLessThanOrEqual(ActualDefInvAmount1, ExpectedDefInvAmt1, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyLessThanOrEqual(ActualDefInvAmount2, ExpectedDefInvAmt2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyLessThanOrEqual(ActualDefInvAmount3, ActualDefInvAmount3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_218'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()


