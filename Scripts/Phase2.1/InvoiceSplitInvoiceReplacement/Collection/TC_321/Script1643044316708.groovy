import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadeAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/CommonData/CommonData').getValue('RetailerCash', 20)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty_PostM2'), [('testData1') : findTestData('Phase2.1/CommonData/CommonData').getValue(
            'ProductName', 62)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

def invAmt101 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt101)

println(invAmt101.length())

for (int i = 0; i < invAmt101.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

def invAmtText = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)


def TransMode = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Bank_Branch'), [:], FailureHandling.STOP_ON_FAILURE)

def Reference = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'),
	0)
println(Reference+ "before passing data into refrence number edit text")

AppiumDriver driver = MobileDriverFactory.getDriver()
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 0)

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.SPACE))
	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.AT))
	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.EQUALS))
  
def Reference1 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'),
	0)
println(Reference1+ "After passing data into refrence number edit text")

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/Collection/Screenshot'), [('testCaseName') : 'TC_321'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

actualtoastmessage = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage")

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(actualtoastmessage, findTestData('Phase2.1/TestData/Test_Data').getValue(2, 49), FailureHandling.STOP_ON_FAILURE)
println("error message due to reference field is empty and did not acceptING  special characters ")

Mobile.verifyEqual(Reference, Reference1, FailureHandling.STOP_ON_FAILURE)
println('Reference number edit text not accepting   special characters')


Mobile.verifyEqual(TransMode, findTestData('Phase2.1/TestData/Test_Data').getValue(3, 2), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/Collection/Screenshot'), [('testCaseName') : 'TC_321'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

