import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'To click on Order and Invoice Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

'To click on Search Logo Button'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

'To Click on Search Edit Text Field'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), 0)

'Driving the Test Data and setting value for Search_Edit_Text Field'
Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/TY_13/TY_13').getValue(
        3, 13), 0)

'Clicking on PIeces_Edit_Text Field'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

//Entering the value for Pieces using Global_Data..
GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'To Click on OrderAndInvoice Screen Next button'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To Click on Next_Button on Product_Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

'To verify if the collection icon exists'
Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

'To verify is the collection icon is visible'
Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

'To click on Collection icon'
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

'To select Efectivo Radio Button'
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

'To tap on Amount_Edittext'
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

//To clear the amount from Amount_EditText.
for (def i : (1..6)) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

//Mobile.clearText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)
'To Click on Pesito_Radio_Button'
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

'To Tap on Amount_EditText'
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

//To clear the amount from Amount_EditText.
for (def i : (1..6)) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/3_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/0_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/._NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/0_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/0_NumButton'), 0)

'To get the Invoice amount.'
def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

double InvoiceAmount = Double.parseDouble(invAmt)

println(InvoiceAmount + 'Invoice Amount')

'To get the total amount paid'
def totalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 0)

int EndIndex = totalPaid.length() - 1

println(EndIndex)

double TotalAmtPaid = Double.parseDouble(totalPaid[(13..EndIndex)])

println(TotalAmtPaid + 'Total Amount Paid')

//double PesitoComission = 3.0
//Remaining amoubnt should be displayed in the toast message
double RemainingAmt = (InvoiceAmount - TotalAmtPaid).round(1)

println(RemainingAmt + 'Remaining Amount')

'To click on submit button.'
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/BeforeInvoiceCollection/Screenshot'), [('testCaseName') : 'TC_554'], FailureHandling.STOP_ON_FAILURE)

// for Toast Message
AppiumDriver driver = MobileDriverFactory.getDriver()

def Actual_ToastMessage = driver.findElementByXPath('//android.widget.Toast[1]').getText()
println(Actual_ToastMessage)

def Expected_ToastMessage = findTestData('Phase2.1/TY_13/TY_13').getValue(5, 13)
println(Expected_ToastMessage)

boolean ToastMessageResult = Actual_ToastMessage.contains(Expected_ToastMessage)
def verifytheToastMessage = ToastMessageResult.toString()

Mobile.verifyMatch(verifytheToastMessage, findTestData('Phase2.1/TestData/Test_Data').getValue(5, 63), false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

