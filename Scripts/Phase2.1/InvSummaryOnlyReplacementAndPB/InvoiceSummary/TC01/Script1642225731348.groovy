import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Order_And_Invoice_Screen_Title'), 0)

def Actual_Title = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Order_And_Invoice_Screen_Title'), 0)

println(Actual_Title + ' --Actual title of order and invoice page.')

def Expected_Title = findTestData('Phase2.1/TY_13/Inv summary(onlyReplacement and pb)').getValue(3, 2)

println(Expected_Title + '--Partial Expected Title')

boolean TitleComparisionResult = Actual_Title.contains(Expected_Title)

def VerifyTheTitle = TitleComparisionResult.toString()

println(VerifyTheTitle + '--Boolean Value')

Mobile.verifyMatch(VerifyTheTitle, findTestData('Phase2.1/TY_13/Inv summary(onlyReplacement and pb)').getValue(5, 2), false, 
    FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_ID_001'],
	FailureHandling.STOP_ON_FAILURE)

println('We are able to Navigate to Order and Invoice screen.')

Mobile.closeApplication()

