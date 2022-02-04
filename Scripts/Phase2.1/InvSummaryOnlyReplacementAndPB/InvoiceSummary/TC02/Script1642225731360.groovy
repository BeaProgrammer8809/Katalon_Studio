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

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIProductBuyingScreen01/Product_Buying_Screen_Title'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIProductBuyingScreen01/Product_Buying_Screen_Title'), findTestData('Phase2.1/TY_13/Inv summary(onlyReplacement and pb)').getValue(
        3, 3), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_ID_002'],
	FailureHandling.STOP_ON_FAILURE)

println('We are able to Navigate to Product Buying Screen from Order And Invoice screen without doing Replacement .')

Mobile.closeApplication()

