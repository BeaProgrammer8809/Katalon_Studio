import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue(2, 7)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIBlueLabelProcess01/Back_Button'), 0, FailureHandling.OPTIONAL)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

//to add JINCY_SKU_01_SD, Bimbo product
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_3'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

//to add JINCY_SKU_17_SD, Baracel product
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 17), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_5'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

// To add JINCY_SKU_32_SD, Ricolino Product
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 29), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

//To add product buying qty for Ricolino Product
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 29)], FailureHandling.STOP_ON_FAILURE)

'To Tap on NEXT button in Product_Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/SplitInvoiceReplacementAndProductBuying/Screenshot'),
	[('testCaseName') : 'TC_244DeliveryFinalSummeryScreen'], FailureHandling.STOP_ON_FAILURE)
//
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def invoice_split3_amt_txt = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'),
	0)

double Invoice_Split3_Amt = Double.parseDouble(invoice_split3_amt_txt)

println(Invoice_Split3_Amt + '--->Invoice split3 amt displayed')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def invoice_split4_amt_txt = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'),
	0)

double invoice_split4_amt = Double.parseDouble(invoice_split4_amt_txt)

println(invoice_split4_amt + '--> invoice Split 4 amt displayed')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

def invoice_split5_amt_txt = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'),
	0)

double invoice_split5_amt = Double.parseDouble(invoice_split5_amt_txt)

println(invoice_split5_amt + '--> invoice Split 4 amt displayed')


GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

def prodbuy_amt_txt = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

double ProdBuy_Amt = Double.parseDouble(prodbuy_amt_txt)

println(ProdBuy_Amt + '--> PrdoBuy amount displayed.')

def AmtDisplayedInCash = invoice_split4_amt - ProdBuy_Amt

println(AmtDisplayedInCash + '--> Amount to be displayed in Deafult_Invoice Efectivo mode')

//
AppiumDriver driver = MobileDriverFactory.getDriver()

EditTextFields = driver.findElementsByClassName('android.widget.EditText')

List<WebElement> elements = driver.findElementsByClassName('android.widget.EditText')

def size_fields = elements.size()

println('The size of elements is ::' + elements.size())

println(size_fields + '----> No of Edit folio edit text fields')

double expected_highest = 0

int expected_index = 0

for (def i : (1..size_fields - 1)) {
	GlobalVariable.index = i

	double highest_amt = Double.parseDouble(Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'),
			0))

	if (expected_highest < highest_amt) {
		expected_highest = highest_amt

		expected_index = i
	}
}

//
println(expected_highest + '--> Highest amt')

println(expected_index + '--> Highest amt Index')

GlobalVariable.index = expected_index

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'), prodbuy_amt_txt)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/SplitInvoiceReplacementAndProductBuying/Screenshot'),
	[('testCaseName') : 'TC_244ProdBuyAmtInCreditMode'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), AmtDisplayedInCash.toString())

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/SplitInvoiceReplacementAndProductBuying/Screenshot'),
	[('testCaseName') : 'TC_244balanceAmtInEfectivoMode'], FailureHandling.STOP_ON_FAILURE)

println('ProdBuy amount is Adjusted in highest amount invoice, when having different split group SKUs.')

Mobile.closeApplication()