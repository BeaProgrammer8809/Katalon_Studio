import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue(2, 7)], FailureHandling.STOP_ON_FAILURE)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 31)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 31)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_055InvoiceSummaryScreen'], 
    FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def DefaultInv3 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 0)
int Defaultinv3 = Integer.parseInt(DefaultInv3)
def DefaultProdBuy3 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 0)
int Defaultprodbuy3 = Integer.parseInt(DefaultProdBuy3)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)
def DefaultInv2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 0)
int Defaultinv2 = Integer.parseInt(DefaultInv2)
def DefaultProdBuy2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 0)
int Defaultprodbuy2 = Integer.parseInt(DefaultProdBuy2)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)
def DefaultInv1 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 0)
int Defaultinv1 = Integer.parseInt(DefaultInv1)
def DefaultProdBuy1 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 0)
int Defaultprodbuy1 = Integer.parseInt(DefaultProdBuy1)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

//
AppiumDriver driver = MobileDriverFactory.getDriver()
EditTextFields = driver.findElementsByClassName('android.widget.EditText')
List<WebElement> elements = driver.findElementsByClassName('android.widget.EditText')
def size_fields = elements.size()
println(size_fields + '----> No of Edit folio edit text fields')
//

def linescount = (Defaultinv3 + Defaultinv2 + Defaultinv1 + Defaultprodbuy3 + Defaultprodbuy2 + Defaultprodbuy1)
def LinesCount = (linescount / size_fields)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)
def InvoiceIndex1 = (Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)).split('-')[0]
def ExpectedInvoiceText1 = findTestData('Phase2.1/TY_13/InvoiceSplitOnlyRepandPB').getValue(3, 13)
Mobile.verifyMatch(InvoiceIndex1, ExpectedInvoiceText1, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), LinesCount.toString(),
	FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), DefaultInv3, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)
def InvoiceIndex2 = (Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)).split('-')[0]
def ExpectedInvoiceText2 = findTestData('Phase2.1/TY_13/InvoiceSplitOnlyRepandPB').getValue(3, 13)
Mobile.verifyMatch(InvoiceIndex2, ExpectedInvoiceText2, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), LinesCount.toString(),
	FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), DefaultInv2, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)
def InvoiceIndex3 = (Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)).split('-')[0]
def ExpectedInvoiceText3 = findTestData('Phase2.1/TY_13/InvoiceSplitOnlyRepandPB').getValue(3, 13)
Mobile.verifyMatch(InvoiceIndex3, ExpectedInvoiceText3, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), LinesCount.toString(),
	FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), DefaultInv1, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)
def InvoiceIndex4 = (Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)).split('-')[0]
def ExpectedInvoiceText4 = findTestData('Phase2.1/TY_13/InvoiceSplitOnlyRepandPB').getValue(3, 14)
Mobile.verifyMatch(InvoiceIndex4, ExpectedInvoiceText4, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), LinesCount.toString(),
	FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), DefaultProdBuy3, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)
def InvoiceIndex5 = (Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)).split('-')[0]
def ExpectedInvoiceText5 = findTestData('Phase2.1/TY_13/InvoiceSplitOnlyRepandPB').getValue(3, 14)
Mobile.verifyMatch(InvoiceIndex5, ExpectedInvoiceText5, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), LinesCount.toString(),
	FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), DefaultProdBuy2, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 6)
def InvoiceIndex6 = (Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)).split('-')[0]
def ExpectedInvoiceText6 = findTestData('Phase2.1/TY_13/InvoiceSplitOnlyRepandPB').getValue(3, 14)
Mobile.verifyMatch(InvoiceIndex6, ExpectedInvoiceText6, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), LinesCount.toString(),
	FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), DefaultProdBuy1, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_055DeliveryFinalSummary'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
