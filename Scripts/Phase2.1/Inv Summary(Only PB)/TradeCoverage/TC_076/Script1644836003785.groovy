import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement
import org.testng.Assert as Assert
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadeAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2.1/TestData/Test_Data').getValue(
		3, 40), 0)

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
Mobile.sendKeys(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText'), "_-", FailureHandling.STOP_ON_FAILURE)


AppiumDriver driver = MobileDriverFactory.getDriver()

//Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText'), 0)
	

((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.H))
((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_1))

((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.AT))

((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.EQUALS))

//((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.MINUS))

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_076'],
	FailureHandling.STOP_ON_FAILURE)

def Actual = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText'),  0)

def actualUnderScore=Actual.subSequence(0, 1)
def actualHyphen=Actual.subSequence(1, 2)
//def actualHyphen=Actual.subSequence(2, 3)
//def actualHyphen=Actual.subSequence(3, 4)

def UnderScore = findTestData('Phase2.1/TestData/Test_Data').getValue(4, 39)
println(UnderScore)
boolean Expect1 = Actual.contains(UnderScore)
Mobile.verifyMatch(Expect1.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(5, 63), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(actualUnderScore.toString(), UnderScore.toString(), false, FailureHandling.STOP_ON_FAILURE)
println("Folio productBuy  accepting underscore(_) special character ")


def Hyphen = findTestData('Phase2.1/TestData/Test_Data').getValue(5, 39)
println(Hyphen)
boolean Expect2 = Actual.contains(Hyphen)
Mobile.verifyMatch(Expect2.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(5, 63), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(actualHyphen.toString(), Hyphen.toString(), false, FailureHandling.STOP_ON_FAILURE)
println("Folio productBuy  accepting Hyphen(-) special character ")

def AtTherate = findTestData('Phase2.1/TestData/Test_Data').getValue(4, 40)
println(AtTherate)
boolean Expect3 = Actual.contains(AtTherate)
Mobile.verifyNotMatch(Expect3.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(5, 63), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Expect3.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(8, 35), false, FailureHandling.STOP_ON_FAILURE)
println("Folio productBuy  not accepting @ ")

def Equals = findTestData('Phase2.1/TestData/Test_Data').getValue(5, 40)
println(Equals)
boolean Expect4 = Actual.contains(Equals)
Mobile.verifyNotMatch(Expect4.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(5, 63), false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Expect4.toString(), findTestData('Phase2.1/TestData/Test_Data').getValue(8, 35), false, FailureHandling.STOP_ON_FAILURE)
println("Folio productBuy not accepting = ")



Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_076'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

