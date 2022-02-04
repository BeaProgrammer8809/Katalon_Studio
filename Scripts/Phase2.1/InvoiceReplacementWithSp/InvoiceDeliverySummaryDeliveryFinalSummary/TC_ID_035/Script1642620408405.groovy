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
        'ProductName',30), 0)
"Piece Qty"
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

not_run: Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

'Verifying the Delevery_Final_Summary'
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

'Verifying the Edit   '
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Tag_Icon_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Tag_Icon_Button'), 0)

'verify Back button Arrow'

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Back_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Back_Button') , 0)


"Verify total Qty "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Total_Qty_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Total_Qty_TextView')  , 0)

"Invoice Count"
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Invoice_Count_TextView')  , 0)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Invoice_Count_TextView')  , 0)

"Verify Create Btn exist & visible "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button') , 0)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button') , 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

"Verify Delevery Final Summary Screen "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_035'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

