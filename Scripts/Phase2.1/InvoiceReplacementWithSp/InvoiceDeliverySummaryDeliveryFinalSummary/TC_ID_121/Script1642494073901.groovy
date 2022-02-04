import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue(2, 7)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIBlueLabelProcess01/Back_Button'), 0, FailureHandling.OPTIONAL)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_3'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 9)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 9)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_3'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_3'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 31)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 31)], FailureHandling.STOP_ON_FAILURE)

'To click on Next_Button in OrderAndInvoice Screen'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To Tap on NEXT button in Product_Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Product1 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_Text_Indexing'), 0)

def StockDeliveryProd1 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 
    0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Product2 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_Text_Indexing'), 0)

def StockDeliveryProd2 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 
    0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

def Product3 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_Text_Indexing'), 0)

def StockDeliveryProd3 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

TextFields = driver.findElementsByXPath("//*[@resource-id = '$GlobalVariable.Package:id/stock_and_order_listview_productname']")

List<WebElement> elements1 = driver.findElementsByXPath("//*[@resource-id = '$GlobalVariable.Package:id/stock_and_order_listview_productname']")

def NoOfProducts = elements1.size()

println('The size of Products is ::' + elements1.size())

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        5, 1), 0)

def enteredinvoicecount = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

println(enteredinvoicecount + '--Invoice Count enterd in string')

int EnteredInvoiceCount = Integer.parseInt(enteredinvoicecount)

println(EnteredInvoiceCount + '--Invoice Count enterd in Delivery Summary screen')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_121DeliverySummaryScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.verifyElementText(findTestObject('Phase2/BISplitDeliverySummary01/ProductName_TextView_Indexing'), Product1, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BISplitDeliverySummary01/StockDelivered_Qty_Indexing'), StockDeliveryProd1, 
    FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.verifyElementText(findTestObject('Phase2/BISplitDeliverySummary01/ProductName_TextView_Indexing'), Product2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BISplitDeliverySummary01/StockDelivered_Qty_Indexing'), StockDeliveryProd2, 
    FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

Mobile.verifyElementText(findTestObject('Phase2/BISplitDeliverySummary01/ProductName_TextView_Indexing'), Product3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BISplitDeliverySummary01/StockDelivered_Qty_Indexing'), StockDeliveryProd3, 
    FailureHandling.STOP_ON_FAILURE)

EditTextFields = driver.findElementsByClassName('android.widget.EditText')

List<WebElement> elements2 = driver.findElementsByClassName('android.widget.EditText')

def size2 = elements2.size()

println('The size of elements is ::' + elements2.size())

def RecordCount = size2 / NoOfProducts

println(RecordCount + '--RecordCount calculated')

Mobile.verifyEqual(EnteredInvoiceCount, RecordCount, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_121DeliverySplitSummaryScreen'], FailureHandling.STOP_ON_FAILURE)

println('Stock Delivered Qty and record count tally in both the screen- Delivery Summary and delivery Split Summary')

Mobile.closeApplication()

