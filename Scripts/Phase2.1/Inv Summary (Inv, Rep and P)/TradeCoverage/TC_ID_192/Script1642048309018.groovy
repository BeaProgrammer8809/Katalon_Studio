import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/OdometerAndVanload'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 44)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)



Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_191_collection'], 
    FailureHandling.STOP_ON_FAILURE)

def InvAmount1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println(InvAmount1)

double InvAmount = Double.parseDouble(InvAmount1)

Amount = (InvAmount - 0.1)

Amount1 = Amount.toString()

def Totalpaid2 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 0)

println(Totalpaid2)

Totalpaid1 = Totalpaid2.split(': ')

Totalpaid = (Totalpaid1[1])

println(Totalpaid)

double Totalpaid = Double.parseDouble(Totalpaid)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

'entering amount less than inv amount in field'
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), Amount1, 
    0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_192_Effectivo'], 
    FailureHandling.STOP_ON_FAILURE)

def EffectivoBalance2 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0)

println(EffectivoBalance2)

EffectivoBalance1 = EffectivoBalance2.split(': ')

EffectivoBalance3 = (EffectivoBalance1[1])

EffectivoBalance3 = EffectivoBalance3.split(' of')

EffectivoBalance = (EffectivoBalance3[0])

println(EffectivoBalance)

def ActualBalance1 = InvAmount - Amount


DecimalFormat df1 = new DecimalFormat('0.00')

ActualBalance = df1.format(ActualBalance1)

ActualBalance = ActualBalance.toString()


Mobile.verifyEqual(EffectivoBalance, ActualBalance, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

'entering amount less than inv amount in field'
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), Amount1, 
    0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_192_Cheque'], 
    FailureHandling.STOP_ON_FAILURE)

def ChequeBalance2 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0)

println(ChequeBalance2)

ChequeBalance1 = ChequeBalance2.split(': ')

ChequeBalance3 = (ChequeBalance1[1])

ChequeBalance3 = ChequeBalance3.split(' of')

ChequeBalance = (ChequeBalance3[0])

println(ChequeBalance)


Mobile.verifyEqual(Totalpaid, InvAmount1, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(ChequeBalance, ActualBalance, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'),
	0)


Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

'entering amount less than inv amount in field'

Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), Amount1,
	0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_192_Electronic'], 
    FailureHandling.STOP_ON_FAILURE)

def ElectroBalance2 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0)

println(ElectroBalance2)

ElectroBalance1 = ElectroBalance2.split(': ')

ElectroBalance3 = (ElectroBalance1[1])

ElectroBalance3 = ElectroBalance3.split(' of')

ElectroBalance = (ElectroBalance3[0])

println(ElectroBalance)



Mobile.verifyEqual(Totalpaid, InvAmount1, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(ElectroBalance, ActualBalance, FailureHandling.STOP_ON_FAILURE)



Mobile.closeApplication()

