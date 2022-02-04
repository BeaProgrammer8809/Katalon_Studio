import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue(2, 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

//Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
//            6, 1)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 8)], FailureHandling.STOP_ON_FAILURE)

//Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
//            6, 16)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 21)], FailureHandling.STOP_ON_FAILURE)

//Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
//            6, 30)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 31)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 31)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

println('Summary screen displayed')

Mobile.verifyElementNotExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

println('Collection I-CON not Exist and user can not able to do the colletion transaction without entering the invoice Qty')

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 
    0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('Delivery Summary screen displayed')

Mobile.verifyElementNotExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

println('Collection screen is not visible')

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
		24, 84), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_038'], 
    FailureHandling.STOP_ON_FAILURE)

def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()

def Expected_Toast_Message = findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(5, 95)

println(Actual_Toast_Message)

Mobile.verifyMatch(Actual_Toast_Message, Expected_Toast_Message, false, FailureHandling.STOP_ON_FAILURE)

println('Extra Invoice is not applicable when only Replacement and Product Buying has taken for group skus')

//GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)
//
//Mobile.setText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
//        10, 90), 0)
//
//GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)
//
//Mobile.setText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
//		10, 90), 0)
//
//Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Create_Final_Invoice_Button'), 0)
//
//println('As there is no invoice hence no collection required')
//
//Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Do_You_Want_To_Print_Invoicing_Without_Preticket_OK_Button'), 0)
//
//Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully_OK_Button'), 0)
//
//Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
//
//println('Collection screen should not come as only replacement and product buying has taken and transaction is completed without entering invoice count')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'), [('testCaseName') : 'TC_038'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()



