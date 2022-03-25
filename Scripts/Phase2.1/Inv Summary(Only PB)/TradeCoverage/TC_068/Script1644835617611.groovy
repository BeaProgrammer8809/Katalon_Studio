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


//GlobalVariable.Buysku = findTestData('Phase2/Common_Data/CommonData').getValue(5, 2)
Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadeAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/TestData/Test_Data').getValue(
	3, 35), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText'), 0)

((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.H))
((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.NUMPAD_DOT))
((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_1))
((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.SPACE))
((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_1))

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_068'],
	FailureHandling.STOP_ON_FAILURE)

def Actual = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText'),
	0)
println(Actual)

def actualAlpha=Actual.subSequence(0, 1)
def actualdigit=Actual.subSequence(1, 2)


def Alphaa = findTestData('Phase2.1/TestData/Test_Data').getValue(4, 35)
println(Alphaa)
boolean Expect1 = Actual.contains(Alphaa)
Mobile.verifyMatch(Expect1.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(5, 63), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(actualAlpha, Alphaa, false, FailureHandling.STOP_ON_FAILURE)
println("Folio productBuy  accepting Alphabets ")


def Decimal = findTestData('Phase2.1/TestData/Test_Data').getValue(5, 35)
println(Decimal)
boolean Expect2 = Actual.contains(Decimal)
Mobile.verifyNotMatch(Expect2.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(5, 63), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Expect2.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(8, 35), false, FailureHandling.STOP_ON_FAILURE)
println("Folio productBuy not accepting Decimal ")

def Digit = findTestData('Phase2.1/TestData/Test_Data').getValue(6, 35)
println(Digit)
boolean Expect3 = Actual.contains(Digit)
Mobile.verifyMatch(Expect3.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(5, 63), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(actualdigit.toString(), Digit.toString(), false, FailureHandling.STOP_ON_FAILURE)
println("Folio productBuy  accepting numbers ")

def Space = findTestData('Phase2.1/TestData/Test_Data').getValue(7, 35)
println(Space)
boolean Expect4 = Actual.contains(Space)
Mobile.verifyNotMatch(Expect4.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(5, 63), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Expect4.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(8, 35), false, FailureHandling.STOP_ON_FAILURE)
println("Folio productBuy not accepting space ")

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_068'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
