import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 7), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 7)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/Before Invoice Collection/Screenshot'), [('testCaseName') : 'TC_ID_452_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/Before Invoice Collection/Screenshot'), [('testCaseName') : 'TC_ID_452_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def Amount1=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)
for (int i = 0; i < Amount1.length(); i++)
{
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)
def Inv=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)
def Amt=Inv.split(" ")
def Actual_Inv_Amount=Amt[0]

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

def Amount=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)
DecimalFormat df = new DecimalFormat('0.00')
def Actual_Amount=df.format(Double.parseDouble(Amount))

//Verification to check that Full invoice is granted in pesito credit mode
Mobile.verifyNotEqual(Actual_Inv_Amount, Actual_Amount, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/Before Invoice Collection/Screenshot'), [('testCaseName') : 'TC_ID_452_Partial_Invoice_Amount'], FailureHandling.STOP_ON_FAILURE)

//Verification to check that Cheque mode is selected
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)
Mobile.verifyElementHasAttribute(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 'selected', 0, FailureHandling.STOP_ON_FAILURE)

def Amount2=Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'), 0)
for (int i = 0; i < Amount2.length(); i++)
{
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

//Verification to check the Toast Message when tried to submit the partial invoice amount
AppiumDriver driver = MobileDriverFactory.getDriver()
def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/Before Invoice Collection/Screenshot'), [('testCaseName') : 'TC_ID_450_Toast_Message'], FailureHandling.STOP_ON_FAILURE)

def Expected_Toast_Message = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 77)
boolean value =Actual_Toast_Message.contains(Expected_Toast_Message)

//Verification to check whether Toast message is matching as Expected
Mobile.verifyMatch(value.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 77), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check the Invoice Qty
Mobile.verifyEqual(Actual_Pieces_Value, Expected_Pieces_Value, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()