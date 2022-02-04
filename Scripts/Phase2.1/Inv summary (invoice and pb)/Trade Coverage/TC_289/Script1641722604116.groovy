import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

'To Click on Search Button'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 44), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

'To click on Next_Button in OrderAndInvoice Screen'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To click on Search Button in product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

'To tap on Search Edit Text field in Product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)

'To set the SKU name in Search Edit Text field of product buying screen'
Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 44), 0)

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

'To Tap on NEXT button in Product_Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

'To select Efectivo Radio Button'
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

// TO get the amount from AmountEdit text field efectivo mode
def amtEditTxtEfectivo = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0)

println(amtEditTxtEfectivo + '--Amount present before Entering lower amount value')

double AmtEdittxtEfectivo = Double.parseDouble(amtEditTxtEfectivo)

println(AmtEdittxtEfectivo + '--Amount In Efectivo mode before entering lesser amt ')

// To delete the amount in Efectivo Amount field
def invamt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println(invamt.length())

double InvAmtDouble = Double.parseDouble(invamt)

println(InvAmtDouble + 'Invoice Amt in Double Format')

'To tap on Amount_Edittext'
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

for (int i = 0; i < 6; i++) {
    Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/1_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/0_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/0_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/._NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/0_NumButton'), 0)

// TO get the amount from AmountEdit text field after entering lesser amount efectivo mode
def amtTxtEfectivo = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

println(amtTxtEfectivo + '--Amount present before Entering lower amount value')

double AmttxtEfectivo = Double.parseDouble(amtTxtEfectivo)

println(AmttxtEfectivo + '--Amount In Efectivo mode before entering lesser amt ')

//Calculating Balance amount
double BalanceAmt = AmtEdittxtEfectivo - AmttxtEfectivo

println(BalanceAmt + '--Expected Balance amount')

// Total Amt Paid
double totalPaid = InvAmtDouble - BalanceAmt

println(totalPaid + '--Total paid amt calculated')

//def TotalAmtPaid = totalPaid.round()

//println(TotalAmtPaid + '--Total Amount Paid Calcualted')

def ExpectedTotalPaid = findTestData('Phase2.1/TY_13/Inv summary (invoice and pb)').getValue(3, 19) + totalPaid

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), ExpectedTotalPaid, 
    FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_289TotalPaidAmt'], 
    FailureHandling.STOP_ON_FAILURE)

println('The Total Paid Amt lable is updated as Expected')

Mobile.closeApplication()

