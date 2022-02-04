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
            'Phase2.1/Common_Data/CommonData').getValue('RetailerCredit', 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 12)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 24)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 36)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 12)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 24)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 36)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

"**********************Default Invoice 1******************"

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def DefInv1SRP_Text = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text_Indexing'), 0)

double DefInv1_SRPValue = Double.parseDouble(DefInv1SRP_Text)

println(DefInv1_SRPValue)

def DefInv1QtyText=Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 0)

double DefInv1_QTY = Double.parseDouble(DefInv1QtyText)

println(DefInv1_QTY)

def DefInv1Amount=(DefInv1_SRPValue) * (DefInv1_QTY)

DecimalFormat df1 = new DecimalFormat('0.00')

Expected_DefInv1_Amount = df1.format(DefInv1Amount)
println Expected_DefInv1_Amount

"**********************Default Invoice 2******************"

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def DefInv2SRP_Text = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text_Indexing'), 0)

double DefInv2_SRPValue = Double.parseDouble(DefInv2SRP_Text)

println(DefInv2_SRPValue)

def DefInv2QtyText=Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 0)

double DefInv2_QTY = Double.parseDouble(DefInv2QtyText)

println(DefInv2_QTY)


def DefInv2Amount=(DefInv2_SRPValue) * (DefInv2_QTY)

DecimalFormat df2 = new DecimalFormat('0.00')

Expected_DefInv2_Amount = df2.format(DefInv2Amount)

println Expected_DefInv2_Amount



"**********************Default Invoice 3******************"

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 3)

def DefInv3SRP_Text = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text_Indexing'), 0)

double DefInv3_SRPValue = Double.parseDouble(DefInv3SRP_Text)

println(DefInv3_SRPValue)

def DefInv3QtyText=Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 0)

double DefInv3_QTY = Double.parseDouble(DefInv3QtyText)

println(DefInv3_QTY)

def DefInv3Amount=(DefInv3_SRPValue) * (DefInv3_QTY)

DecimalFormat df3 = new DecimalFormat('0.00')

Expected_DefInv3_Amount = df3.format(DefInv3Amount)

println Expected_DefInv3_Amount



Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

"********************1*************************"

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def DefaultInv1 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

println(DefaultInv1)

def Actual_DefInv1_Amount=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println Actual_DefInv1_Amount

"********************2*************************"
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def DefaultInv2 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

println(DefaultInv2)

def Actual_DefInv2_Amount=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println Actual_DefInv2_Amount

"********************3*************************"

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 3)

def DefaultInv3 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

println(DefaultInv3)

def Actual_DefInv3_Amount=Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println Actual_DefInv3_Amount


Mobile.verifyMatch(DefaultInv1, findTestData('Phase2.1/TY_01/TestData2').getValue(4, 54), false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(DefaultInv2, findTestData('Phase2.1/TY_01/TestData2').getValue(5, 54), false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(DefaultInv3, findTestData('Phase2.1/TY_01/TestData2').getValue(6, 54), false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyLessThanOrEqual(Actual_DefInv1_Amount, Expected_DefInv1_Amount, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyLessThanOrEqual(Actual_DefInv2_Amount, Expected_DefInv2_Amount, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyLessThanOrEqual(Actual_DefInv3_Amount, Expected_DefInv3_Amount, FailureHandling.STOP_ON_FAILURE)


Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_214'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

