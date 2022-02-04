import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 31)], FailureHandling.STOP_ON_FAILURE)

INVQTY = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 31)], FailureHandling.STOP_ON_FAILURE)

SRP = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/SRP_Price'), 0)

def SRPPrice =Double.parseDouble(SRP)

def SRPPrice1 = Math.ceil(SRPPrice)

int ActualSRPPrice  = (int)SRPPrice1

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 31)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
PBQTY = Mobile.getText(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

def ActualCompDiscount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'),
	0)

ActualCompDiscount = ActualCompDiscount.split(' ')

Dicount=ActualCompDiscount[1]

def ActualCompDisc1 =Double.parseDouble(Dicount)

def ActualCompDisc2 = Math.ceil(ActualCompDisc1)

int ActualCompDisc  = (int)ActualCompDisc2



Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def TotalSkuPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)



def TotalSKUPrice =Double.parseDouble(TotalSkuPrice)

def ActualTotalSKUPrice = Math.ceil(TotalSKUPrice)

int TotalProductPrice  = (int)ActualTotalSKUPrice

def value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)
def value1 =Double.parseDouble(value)

def Actualvalue1 = Math.ceil(value1)

int Actualvalue  = (int)Actualvalue1


def Tax =  Actualvalue- TotalProductPrice

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def Amount = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

def Amount1 =Double.parseDouble(Amount)

def ActualAmount1 = Math.ceil(Actualvalue1)

int ActualAmount  = (int)ActualAmount1

EXPTotal = (((Integer.parseInt(INVQTY) * ActualSRPPrice) + Tax) - ActualCompDisc)

Mobile.verifyEqual(Actualvalue, EXPTotal, FailureHandling.STOP_ON_FAILURE)


Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)



Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/SplitDeliverySummary/Screenshot'), [('testCaseName') : 'TC_43'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
