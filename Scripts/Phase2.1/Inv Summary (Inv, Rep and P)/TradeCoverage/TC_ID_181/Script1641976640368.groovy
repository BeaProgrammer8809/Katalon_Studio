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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/OdometerAndVanload'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def ExpectedReturnQty = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIReturnProductBuyingScreen01/Return_Text-View'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(17, 1)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text_Indexing'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def ExpectedSalesReturn = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'),
	0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

'Entering value test@12.4 01 throght keypad and verifying its not entered in the folio number edit text field'

AppiumDriver driver = MobileDriverFactory.getDriver()

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BIEnterTheFolioNoPopup01/FolioNo._EditText_Indexing'), 0)

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.T))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.E))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.S))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.T))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.AT))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_1))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_2))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.NUMPAD_DOT))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_4))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.SPACE))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_0))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_1))

Mobile.hideKeyboard()

def FolioNOEnteredIndex1 = Mobile.getText(findTestObject('Phase2/BIEnterTheFolioNoPopup01/FolioNo._EditText_Indexing'),
	0)

Mobile.verifyNotMatch(FolioNOEnteredIndex1, findTestData('Phase2.1/TY_11/TestData').getValue(
		3, 65), false, FailureHandling.STOP_ON_FAILURE)


Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_181'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
