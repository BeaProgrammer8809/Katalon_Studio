import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

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
            'ProductName', 16)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 16)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_3'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 28)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 28)], FailureHandling.STOP_ON_FAILURE)

'To click on Next_Button in OrderAndInvoice Screen'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To Tap on NEXT button in Product_Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        5, 5), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.setText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        5, 1), 0)
ExtraInv1EnteredQty = Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.setText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv2_EditView_Indexing'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        5, 1), 0)

ExtraInv2EnteredQty = Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv2_EditView_Indexing'), 0)

Mobile.setText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv3_EditView_Indexing'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        5, 1), 0)

ExtraInv3EnteredQty = Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv3_EditView_Indexing'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.setText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv4_EditView_Indexing'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        5, 3), 0)

ExtraInv4EnteredQty = Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv4_EditView_Indexing'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv5_EditView_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/3_NumButton'), 0)

ExtraInv5EnteredQty = Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv5_EditView_Indexing'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_132'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), findTestData(
	'Phase2.1/TY_13/Invoice, Replacement with Sp').getValue(4, 7))

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

ActualExtraInv1Name = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

Mobile.verifyMatch(ActualExtraInv1Name, findTestData('Phase2.1/TY_13/Invoice, Replacement with Sp').getValue(2, 11), false)

def ExtraInv1QtyDisplayed = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.verifyMatch(ExtraInv1QtyDisplayed, ExtraInv1EnteredQty, false)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

def ActualExtraInv2Name = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)
println(ActualExtraInv2Name + "--- ActualExtraInv2Name displayed")

Mobile.verifyMatch(ActualExtraInv2Name , findTestData('Phase2.1/TY_13/Invoice, Replacement with Sp').getValue(3, 11), false)

def ExtraInv2QtyDisplayed = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.verifyMatch(ExtraInv2QtyDisplayed, ExtraInv2EnteredQty, false)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 6)

def ActualExtraInv3Name = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

Mobile.verifyMatch(ActualExtraInv3Name, findTestData('Phase2.1/TY_13/Invoice, Replacement with Sp').getValue(4, 11), false)

def ExtraInv3QtyDisplayed = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.verifyMatch(ExtraInv3QtyDisplayed, ExtraInv3EnteredQty, false)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 7)

def ActualExtraInv4Name = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

Mobile.verifyMatch(ActualExtraInv4Name, findTestData('Phase2.1/TY_13/Invoice, Replacement with Sp').getValue(5, 11), false)

def ExtraInv4QtyDisplayed = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.verifyMatch(ExtraInv4QtyDisplayed, ExtraInv4EnteredQty, false)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 8)

def ActualExtraInv5Name = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

Mobile.verifyMatch(ActualExtraInv5Name, findTestData('Phase2.1/TY_13/Invoice, Replacement with Sp').getValue(6, 11), false)

def ExtraInv5QtyDisplayed = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.verifyMatch(ExtraInv5QtyDisplayed, ExtraInv5EnteredQty, false)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_132AfterTapCreateInvoice'], FailureHandling.STOP_ON_FAILURE)

println('We can Partially distribute the qty line wise for Ungrouped SKU\'s')

Mobile.closeApplication()

