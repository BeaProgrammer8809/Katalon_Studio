import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent


Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
			'Username', 5), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue('Password', 5)],
	FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 19)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)


Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 2)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_1'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)


GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()
				
((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.AT))

((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.AT))

((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.SPACE))

((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.EQUALS))


GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)
def FolioNum= Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), 0)

def AcceptFolioNum= findTestData('Phase2.1/TY_05/Collection').getValue(3, 77)

Mobile.verifyNotMatch(FolioNum, AcceptFolioNum, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyPB/ProductBuyingDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_81'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()