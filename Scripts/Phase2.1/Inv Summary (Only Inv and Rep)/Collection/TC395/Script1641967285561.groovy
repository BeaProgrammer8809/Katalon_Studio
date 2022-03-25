import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 2)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 2), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC395_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC395_Expected_Piece_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.checkElement(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0, FailureHandling.STOP_ON_FAILURE)

/*Verification to check the "Payment mode option sequence should be like below in collection screen
 1.Credit Note 2.Pesito Credit 3.Efectivo 4.Cheques 5.Transferenceia Electronicas"*/

AppiumDriver driver = MobileDriverFactory.getDriver()
List<WebElement> Elements = driver.findElementsByClassName('android.widget.RadioButton')
def Actual_Credit_Note= Elements.get(0).getText()
def Actual_Pesito_Credit= Elements.get(1).getText()
def Actual_Efectivo= Elements.get(2).getText()
def Actual_Cheque= Elements.get(3).getText()
def Actual_TransferenciasElectronicas= Elements.get(4).getText()

def Expected_Credit_Note = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 8)
def Expected_Pesito_Credit = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 8)
def Expected_Efectivo = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(6, 8)
def Expected_Cheque = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 8)
def Expected_TransferenciasElectronicas = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(8, 8)

//Verification of CreditNote radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Credit_Note, Expected_Credit_Note, false, FailureHandling.STOP_ON_FAILURE)

//Verification of PesitoCredit radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Pesito_Credit, Expected_Pesito_Credit, false, FailureHandling.STOP_ON_FAILURE)

//Verification of Effectivo radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Efectivo, Expected_Efectivo, false, FailureHandling.STOP_ON_FAILURE)

//Verification of Cheque radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Cheque, Expected_Cheque, false, FailureHandling.STOP_ON_FAILURE)

//Verification of TransferenciasElectronicas radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_TransferenciasElectronicas, Expected_TransferenciasElectronicas, false, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC395_Elements_Verification'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the invoice qty
Mobile.verifyMatch(Actual_Pieces_Value, Expected_Pieces_Value, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()