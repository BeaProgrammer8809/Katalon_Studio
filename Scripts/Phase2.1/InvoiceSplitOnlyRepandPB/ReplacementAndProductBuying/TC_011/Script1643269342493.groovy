import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 12)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 24)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 34)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 12)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
	'ProductName', 24)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
	'ProductName', 34)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

def number1 = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), number1, 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

def actualtoastmessage1 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage1")

def ExpectedToastMessage1 = findTestData('Phase2.1/TY_11/TestData').getValue(2, 86)
println(ExpectedToastMessage1)

Mobile.verifyMatch(actualtoastmessage1, ExpectedToastMessage1, false)

Mobile.verifyElementNotExist(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)


Mobile.clearText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

def number2 = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), number2, 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)



def actualtoastmessage2 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage2")

def ExpectedToastMessage2 = findTestData('Phase2.1/TY_11/TestData').getValue(2, 86)
println(ExpectedToastMessage2)

Mobile.verifyMatch(actualtoastmessage2, ExpectedToastMessage2, false)

Mobile.clearText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.verifyElementNotExist(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)



Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

def number3 =  findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 3)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), number3, 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)



def actualtoastmessage3 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage3")

def ExpectedToastMessage3 = findTestData('Phase2.1/TY_11/TestData').getValue(2, 86)
println(ExpectedToastMessage3)

Mobile.verifyMatch(actualtoastmessage3, ExpectedToastMessage3, false)



Mobile.verifyElementNotExist(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

def number4 =  findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 4)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), number4, 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)



def actualtoastmessage4 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage4")

def ExpectedToastMessage4 = findTestData('Phase2.1/TY_11/TestData').getValue(2,86)
println(ExpectedToastMessage4)

Mobile.verifyMatch(actualtoastmessage4, ExpectedToastMessage4, false)



Mobile.verifyElementNotExist(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

def number5 =  findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), number5, 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)



def actualtoastmessage5 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage5")

def ExpectedToastMessage5 = findTestData('Phase2.1/TY_11/TestData').getValue(2,86)
println(ExpectedToastMessage5)

Mobile.verifyMatch(actualtoastmessage5, ExpectedToastMessage5, false)

Mobile.verifyElementNotExist(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

def number6 =  findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 6)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), number6, 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)



def actualtoastmessage6 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage6")

def ExpectedToastMessage6 = findTestData('Phase2.1/TY_11/TestData').getValue(2,86)
println(ExpectedToastMessage6)

Mobile.verifyMatch(actualtoastmessage6, ExpectedToastMessage6, false)

Mobile.verifyElementNotExist(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyRepandPB/ReplacementAndProductBuying/Screenshot'),
	[('testCaseName') : 'TC_011'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

