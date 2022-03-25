import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 38)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

boolean isKeyboardShown = driver.isKeyboardShown();

def keyboardValue = isKeyboardShown.toString()

Mobile.verifyMatch(keyboardValue, findTestData('Phase2.1/TY_11/TestData').getValue(2, 87), false, FailureHandling.STOP_ON_FAILURE)

'taping on keyboard values from 1-9 and verifying that '



	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_1))
	

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_2))
	
	Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
		[('testCaseName') : 'TC_ID_099_12'], FailureHandling.STOP_ON_FAILURE)
	
	def input =Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)
	Mobile.clearText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_3))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_4))
	
	Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
		[('testCaseName') : 'TC_ID_099_34'], FailureHandling.STOP_ON_FAILURE)
	
	input = input + Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)
	Mobile.clearText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_5))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_6))
	
	Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
		[('testCaseName') : 'TC_ID_099_56'], FailureHandling.STOP_ON_FAILURE)
	
	input = input + Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)
	Mobile.clearText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)


	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_7))

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_8))
	
	Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
		[('testCaseName') : 'TC_ID_099_78'], FailureHandling.STOP_ON_FAILURE)
	
	input = input + Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)
	
	Mobile.clearText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)


	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_9))
	
	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_0))
	
	Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
		[('testCaseName') : 'TC_ID_099_90'], FailureHandling.STOP_ON_FAILURE)
	
	input = input + Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

    def value1 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DEL))
	
	Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
		[('testCaseName') : 'TC_ID_099_del'], FailureHandling.STOP_ON_FAILURE)
	
	def value =  Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)
	
	((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.ESCAPE))
	
	boolean isKeyboardHidden = driver.isKeyboardShown();
	
	def keyboardValue1 = isKeyboardHidden.toString()
	
	'verifying keyboard is hidden after tapping on X'
	
	Mobile.verifyMatch(keyboardValue1, findTestData('Phase2.1/TY_11/TestData').getValue(3, 87), false, FailureHandling.STOP_ON_FAILURE)
	
	

	'verifying inputed value is same as 123456789'

	Mobile.verifyMatch(input, findTestData('Phase2.1/TY_11/TestData').getValue(2, 88), false, FailureHandling.STOP_ON_FAILURE)
	
	'verifying after pressing on DEL last inputed value deleted'
	
	Mobile.verifyNotMatch(value, value1, false, FailureHandling.STOP_ON_FAILURE)


Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_099'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()