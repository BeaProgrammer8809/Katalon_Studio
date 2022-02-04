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
            'Phase2.1/Common_Data/CommonData').getValue(2, 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 50)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 50)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 55)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 55)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 56)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 56)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/ToTravelToDeliverySummaryScreen'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
        24, 26), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.setText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), findTestData(
		'Phase2.1/TY_04/Phase2.1_Sheet3').getValue(3, 26), 0)

def Fst_ExtInv1 = Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

println(Fst_ExtInv1)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.verifyElementAttributeValue(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 'enabled',
	findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(12, 26), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.verifyElementAttributeValue(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 'enabled',
	findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(12, 26), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv2_EditView_Indexing'), 0)

Mobile.setText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv2_EditView_Indexing'), findTestData(
		'Phase2.1/TY_04/Phase2.1_Sheet3').getValue(3, 26), 0)

def Fst_ExtInv2 = Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

println(Fst_ExtInv2)

def Fst_ExtInv = Integer.parseInt(Fst_ExtInv1) + Integer.parseInt(Fst_ExtInv2)

println(Fst_ExtInv)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

def Sku_Qty1 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

println(Sku_Qty1)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

def Sku_Qty2 = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

println(Sku_Qty2)

def Sku_Qty = Integer.parseInt(Sku_Qty1) + Integer.parseInt(Sku_Qty2)

println(Sku_Qty)

Mobile.verifyEqual(Fst_ExtInv, Sku_Qty, FailureHandling.STOP_ON_FAILURE)

println('SKUs Qty contains Sum of SKUs Qty entered under ExtraInvoices')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_166'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
