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

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), findTestData('Phase2.1/TY_05/Collection').getValue(3, 61), 0)
def refnum= Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Submit_Button'), 0)

def RefNumber= findTestData('Phase2.1/TY_05/Collection').getValue(3, 61)

Mobile.verifyEqual(refnum, RefNumber, FailureHandling.STOP_ON_FAILURE)



Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/BeforeInvoiceCollection/Screenshot'), [('testCaseName') : 'TC_490_Collection'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
