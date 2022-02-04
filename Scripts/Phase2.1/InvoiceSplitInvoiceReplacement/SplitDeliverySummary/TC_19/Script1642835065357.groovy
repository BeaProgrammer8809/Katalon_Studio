import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.keyword.builtin.VerifyNotEqualKeyword as VerifyNotEqualKeyword
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
            'Phase2.1/Common_Data/CommonData').getValue(2, 7)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 10), 0)

'Pieces Qty '
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'Return Qty '
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 4)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'O&I piece and return  Qty '
ReturnQtyText1 = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

int ReturnQtyVal1 = Integer.parseInt(ReturnQtyText1)

println(ReturnQtyVal1)

pieceQtyText1 = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

int pieceQtyVal1 = Integer.parseInt(pieceQtyText1)

println(pieceQtyVal1)

TotPieceAndReturn = (pieceQtyVal1 + ReturnQtyVal1)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To click on Search Button in product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

'To tap on Search Edit Text field in Product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)

'To set the SKU name in Search Edit Text field of product buying screen'
Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 21), 0)

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

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/PreTicket_Created_Successfully_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0 ,FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'),0,   FailureHandling.STOP_ON_FAILURE)


InvoiceNameText = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice_Name_TextView'), 0 ,FailureHandling.STOP_ON_FAILURE)

println(InvoiceNameText + "InvoiceNameText ")



"Verify Invoice name visible And Exist "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice_Name_TextView'), 0 ,FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice_Name_TextView'),0 ,FailureHandling.STOP_ON_FAILURE)

InvoiceNameText = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice_Name_TextView'), 0 )
println(InvoiceNameText + "InvoiceNameText ")

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Invoice_Name_TextView') , InvoiceNameText ,FailureHandling.STOP_ON_FAILURE)


"Verify line visible And Exist "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Lines_TextView'), 0 ,FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Lines_TextView'), 0 ,FailureHandling.STOP_ON_FAILURE)
linesText = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Lines_TextView'), 0 )

println(linesText + "linesText ")

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Lines_TextView') , linesText ,FailureHandling.STOP_ON_FAILURE)



"Verify SKU's Qty  visible And Exist "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Skus_Qty_TextView'), 0 ,FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Skus_Qty_TextView'), 0 ,FailureHandling.STOP_ON_FAILURE)

SKUsQtyText = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Skus_Qty_TextView'), 0)

println(SKUsQtyText+ "SKUsQtyText ")

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Skus_Qty_TextView') , SKUsQtyText ,FailureHandling.STOP_ON_FAILURE)

"Verify Amount  visible And Exist "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Amount_TextView'), 0 ,FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Amount_TextView'), 0  ,FailureHandling.STOP_ON_FAILURE)

AmountText = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Amount_TextView'), 0)

println(AmountText + "AmountText ")

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Amount_TextView') , AmountText ,FailureHandling.STOP_ON_FAILURE)

"Verify Folio no. visible And Exist "
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Folio_No._TextView'), 0 ,FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Folio_No._TextView'), 0 ,FailureHandling.STOP_ON_FAILURE)

FolioN0Text = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Folio_No._TextView'), 0)

println(FolioN0Text + "AmountText ")

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Folio_No._TextView') , FolioN0Text ,FailureHandling.STOP_ON_FAILURE)

"Verify Payment"
Mobile.verifyElementExist( findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0 ,FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'),0 ,FailureHandling.STOP_ON_FAILURE)

PaymentText = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0 )

println(PaymentText + "PaymentText ")

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox') ,PaymentText ,FailureHandling.STOP_ON_FAILURE)

"Verify  Efectivo"
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Efectivo_CheckBox'), 0 ,FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Efectivo_CheckBox'),0  ,FailureHandling.STOP_ON_FAILURE)

EfectivoText = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Efectivo_CheckBox'), 0)

println( EfectivoText + "EfectivoText")

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Efectivo_CheckBox') ,EfectivoText  ,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/SplitDeliverySummary/Screenshot'), [('testCaseName') : 'TC_19'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

