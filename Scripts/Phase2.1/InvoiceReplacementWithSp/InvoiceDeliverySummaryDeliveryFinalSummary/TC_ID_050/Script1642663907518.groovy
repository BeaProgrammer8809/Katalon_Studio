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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue(2, 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
		'ProductName', 52), 0)

ProdNameBefore = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), 0)

println( ProdNameBefore + "ProdNameBefore ")
"Piece Qty"
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'Return Qty '
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

"Fetching the Piece and return Value"
Pieces_EditText= Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)
int piece_value = Integer.parseInt(Pieces_EditText)
println(piece_value)

Mobile.delay(5)
Returns_Edit_Text= Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)
int Return_value = Integer.parseInt(Pieces_EditText)
println(Return_value)

//totalpeiceDiffReturn = piece_value -  Return_value

totalpeiceAndReturn = piece_value +  Return_value

println(totalpeiceAndReturn+ "    totalpeiceAndReturn")

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

not_run: Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

DStitle = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

println(DStitle)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), DStitle)

StockDelevered= Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text'), totalpeiceAndReturn)
println(StockDelevered+ " StockDelevered ")
int stockDeleveredVal = Integer.parseInt(StockDelevered)
println(stockDeleveredVal)

println(piece_value+" ############")

println(Return_value+"###########")

Mobile.verifyEqual(stockDeleveredVal, piece_value, FailureHandling.STOP_ON_FAILURE)


//"to Verify Both Peice And return Value is Taken"
//Total_Qty_Text = Mobile.getText( findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Total_Qty_Text') , 0)
//println(Total_Qty_Text+"Total_Qty_Text")
//
//int Total_Qty_Val = Integer.parseInt(Total_Qty_Text)
//
//println(Total_Qty_Val)
//
//Mobile.verifyEqual(Total_Qty_Val ,totalpeiceAndReturn  , FailureHandling.STOP_ON_FAILURE)
////total Qty == peice +returnQty 
//



"Verifu the Product Detail prod name in deleviry summary screen"

ProdNameDeleveryScreen = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Product_Name_Text'), 0)

Mobile.verifyMatch(ProdNameBefore, ProdNameDeleveryScreen, false, FailureHandling.STOP_ON_FAILURE)


"Delete line of code "

Product_Name_TextView = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Product_Name_TextView')  , 0)

println(Product_Name_TextView+"Product_Name_TextView ")


Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_050'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

