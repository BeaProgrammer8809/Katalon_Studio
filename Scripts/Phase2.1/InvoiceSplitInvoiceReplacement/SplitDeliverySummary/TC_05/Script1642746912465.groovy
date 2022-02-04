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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue(2, 22)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
		6, 1), 0)

'Pieces Qty '
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'Return Qty '
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 4)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To click on Search Button in product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

'To tap on Search Edit Text field in Product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)

'To set the SKU name in Search Edit Text field of product buying screen'
Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
		6, 5), 0)

'To tap on Total_Pieces Qty '
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

'To Select DropDown'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DD_Option'), 0)

'To slect Non_Sclable DD option'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)

'To tap on Pieces_Edit_Text option'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

'Setting the value for Piecs_Edit_Text '
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

'Tapping on OK button'
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'To tap on Done Button in Product_Buying_Return Screen'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

not_run: Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

'Verifying the Delevery_Summary'
Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

DFStitle = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

println(DFStitle)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), DFStitle)

'Verifying the Product name '
Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_TextView'), 0)

productNameText = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_TextView'), 0)

println(productNameText)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_TextView'), productNameText)

'Verifying the  Stock Delivered '

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_TextView'), 0)

Stock_DeliveredText = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_TextView'), 0)

println(Stock_DeliveredText)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_TextView'), Stock_DeliveredText)

'Verifying the  SRP  '
Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_TextView'), 0)

SRP_Text = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_TextView'), 0)

println(SRP_Text)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_TextView'), SRP_Text)

'Verifying the  Totaltxt  '
Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Total_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Total_TextView'), 0)

Total_Text = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_TextView'), 0)

println(Total_Text)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_TextView'), Total_Text)

"Verify total Qty "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Total_Qty_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Total_Qty_TextView')  , 0)

"Invoice Count"
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Invoice_Count_TextView')  , 0)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Invoice_Count_TextView')  , 0)

"Invoice CountTXT Box "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

"Verify Create Btn exist & visible "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button') , 0)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button') , 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/SplitDeliverySummary/Screenshot'),
	[('testCaseName') : 'TC_05'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

