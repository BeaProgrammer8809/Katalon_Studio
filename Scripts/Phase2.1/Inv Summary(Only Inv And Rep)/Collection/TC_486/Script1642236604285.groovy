import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 19)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName,
	0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def invamt=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)

def Amount=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println(invamt.length())

for (int i = 0; i < invamt.length(); i++) {
	
	Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

//def Amount = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)
for (int i = 0; i < invamt.length(); i++) {
	
	Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), findTestData('Phase2.1/TY_05/Collection').getValue(3, 11), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/1_NumButton'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/2_NumButton'), 0)

def Actualtoastmessage = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println('Actualresult=' + Actualtoastmessage)

def Expectedtoastmessage = findTestData('Phase2.1/TY_05/Collection').getValue(4, 16)

println('Expectedresult=' + Expectedtoastmessage)

Mobile.verifyEqual(Actualtoastmessage, Expectedtoastmessage, FailureHandling.STOP_ON_FAILURE)

println(Actualtoastmessage)

def Pesito_grand=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

Mobile.verifyGreaterThan(Amount,Pesito_grand)

println(' user not able to collect the amount toast massage should be generated')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only Inv And Rep)/Collection/Screenshot'), [('testCaseName') : 'TC_486'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()