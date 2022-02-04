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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/EnterPiecesQuantity'), [('ProductName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 1)], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/EnterReturnQuantityC'), [('ProductName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/EnteringProductBuyingQuantity'), [('ProductName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 1), ('DropdownName') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'DropdownOption', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.T))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.E))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.S))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.T))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.I))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.N))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.G))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_0))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_1))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_2))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_3))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_5))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_0))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_9))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_0))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_1))

    ((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.ENTER))

def folioNum = Mobile.getAttribute(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), 'text', 5)

println('folioNum' + folioNum)

def expectedFolioNum = findTestData('Phase2.1/TY_14/TestData').getValue('Folio_Number', 66)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.verifyNotMatch(folioNum, expectedFolioNum, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_275'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

