import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.fasterxml.jackson.annotation.JacksonInject.Value as Value
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
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
import java.math.RoundingMode
import java.text.DecimalFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_GaneshNormalCreditEkomercio'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 31)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 
    0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def Pieces = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0)

Double pieces = ((Pieces) as Double)



def UPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),
	0)

Double uprice = ((UPrice) as Double)

  
  def Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)
  
  Double value = ((Value) as Double)
  
  def BuyPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	  0)
  DecimalFormat format = new DecimalFormat("##.00");
  Double Buyprice = ((BuyPrice) as Double)
  def totalPrice1 =Double.parseDouble(BuyPrice)
  
  def totalAmt = value-Double.parseDouble(BuyPrice)
  
  def total =Double.parseDouble(BuyPrice)+totalAmt
  format.setRoundingMode(RoundingMode.UP)
  def Total = format.format(total)
  
  def totalPrice=value-Double.parseDouble(Total)
  println "$totalPrice"
  'Use this for IEPS tax'
  def taxIEPS=CustomKeywords.'com.ty.keywords.MobileKeywords.taxIEPS'(totalPrice)
  println"$taxIEPS"
  'use this for IVA tax'
  def taxIVA=CustomKeywords.'com.ty.keywords.MobileKeywords.taxIVA'(totalPrice1)
  
  println"$taxIVA"
  def returnPiecesValue = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Actual_Return_Value'), 0)
  def totalSum = Double.parseDouble(returnPiecesValue) * uprice
  
  Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)
  
  def OrderValue = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'),
	  0)
  Double ordervalue =OrderValue as Double
  def SkuGross = pieces * uprice
  
  DecimalFormat df1 = new DecimalFormat('0.00')
  
  TotalDisc = df1.format(SkuGross)
  
  println('SkuGross==' + SkuGross)
  
  
  def tax=CustomKeywords.'com.ty.keywords.MobileKeywords.tax'(value, Buyprice)
  
  def OrderValue1=SkuGross + taxIEPS + taxIVA
  
  println('ordervalue' + OrderValue1)
  
  Mobile.verifyEqual(OrderValue, OrderValue1, FailureHandling.STOP_ON_FAILURE)
  
  def actualTaxPercentage = findTestData('Phase2.1/Common_Data/CommonData').getValue('IVA%', 1)
  
  def expTaxPercentage2 = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(tax, Buyprice)
  def expTaxPercentage1=expTaxPercentage2.split('-')
  def expTaxPercentage= expTaxPercentage1[1]
  
  Mobile.verifyMatch(actualTaxPercentage, expTaxPercentage, false, FailureHandling.STOP_ON_FAILURE)
  
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC_153_Amount'], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/PrintPreticket_Icon'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Pre_Ticket_Ok_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/PreTicket_Created_Successfully_Ok_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/PreTicket_Print_Preview_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC_153_printScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

