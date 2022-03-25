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
import org.openqa.selenium.WebElement as WebElement

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyInvoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 19)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyReplacement_Quantity'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def InvoiceAmountInSummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 
    0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def InvoiceAmount = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

def Invoiceamount =Double.parseDouble(InvoiceAmount)

def Actualvalue = Math.round(Invoiceamount)

int ActualInvoiceAmount  = (int)Actualvalue



Integer length = InvoiceAmount.length()

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

for (int i = 0; i <= length; i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0, FailureHandling.OPTIONAL)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

/*Verification done to check Balance : 0 of Invoice amount is displaying in Transferencias mode(TC_ID_134)*/

def ActualBalanceText1=Mobile.getText( findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'), 0)

def TotalPaid1=findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 13)

def ExpectedBalanceText1= TotalPaid1 + ' ' + InvoiceAmount

Mobile.verifyMatch(ActualBalanceText1, ExpectedBalanceText1, false,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_134_A'],
	FailureHandling.STOP_ON_FAILURE)


/*Verification done to check Total Paid:Invoice amount is displaying in Transferencias mode(TC_ID_135)*/

def ActualTotalPaidText1=Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/TotalPaid_TextView'), 0)

def TotalPaid2=findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 14)

def ExpectedTotalPaidText1= TotalPaid2 + ' ' + InvoiceAmount

Mobile.verifyMatch(ActualTotalPaidText1, ExpectedTotalPaidText1, false,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_134'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()




/*Verification done to check Balance : 0 of Invoice amount is displaying in Credit Note mode(TC_ID_134)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

def ActualBalanceText2=Mobile.getText( findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'), 0)

def BalanceText2=findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 13)

def ExpectedBalanceText2= BalanceText2 + ' ' + InvoiceAmount

Mobile.verifyMatch(ActualBalanceText2, ExpectedBalanceText2, false,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_134_B'],
	FailureHandling.STOP_ON_FAILURE)

Verification done to check Total Paid:Invoice amount is displaying in Credit Note mode (TC_ID_135)

def ActualTotalPaidText2=Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/TotalPaid_TextView'), 0)

def TotalPaid2=findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 14)

def ExpectedTotalPaidText2= TotalPaid2 + ' ' + InvoiceAmount

Mobile.verifyMatch(ActualTotalPaidText2, ExpectedTotalPaidText2, false,FailureHandling.STOP_ON_FAILURE)

Verification done to check Balance : 0 of Invoice amount is displaying in Effectivo mode(TC_ID_134)

Mobile.tap( findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def ActualBalanceText3=Mobile.getText( findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'), 0)

def BalanceText3=findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 13)

def ExpectedBalanceText3= BalanceText3 + ' ' + InvoiceAmount

Mobile.verifyMatch(ActualBalanceText3, ExpectedBalanceText3, false,FailureHandling.STOP_ON_FAILURE)

Verification done to check Total Paid:Invoice amount is displaying in Effectivo mode (TC_ID_135)

def ActualTotalPaidText3=Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/TotalPaid_TextView'), 0)

def TotalPaid3=findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 14)

def ExpectedTotalPaidText3= TotalPaid3 + ' ' + InvoiceAmount

Mobile.verifyMatch(ActualTotalPaidText3, ExpectedTotalPaidText3, false,FailureHandling.STOP_ON_FAILURE)

Verification done to check Balance : 0 of Invoice amount is displaying in Cheques mode(TC_ID_134)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

def ActualBalanceText4=Mobile.getText( findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'), 0)

def BalanceText4=findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 13)

def ExpectedBalanceText4= BalanceText4 + ' ' + InvoiceAmount

Mobile.verifyMatch(ActualBalanceText4, ExpectedBalanceText4, false,FailureHandling.STOP_ON_FAILURE)


Verification done to check Total Paid:Invoice amount is displaying in Cheques mode (TC_ID_135)

def ActualTotalPaidText4=Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/TotalPaid_TextView'), 0)

def TotalPaid4=findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 14)

def ExpectedTotalPaidText4= TotalPaid4 + ' ' + InvoiceAmount

Mobile.verifyMatch(ActualTotalPaidText4, ExpectedTotalPaidText4, false,FailureHandling.STOP_ON_FAILURE)

*/






