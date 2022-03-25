import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement
import java.text.DecimalFormat as DecimalFormat

GlobalVariable.Getsku = findTestData('Phase2/Common_Data/CommonData_01').getValue(6, 3)

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.size()

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_01/Test_Data').getValue(
		2, 19), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0, FailureHandling.OPTIONAL)

//def Get_price = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/GetSchemeDetails/Get_Price_Value'),
//	0)
//
//println("$Get_price")
GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 2)

def Actual_Get_price = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0, FailureHandling.OPTIONAL)

println("$Actual_Get_price")

println('Get price is Zero so not included in invoice Amount')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def BuyPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

println(BuyPrice)

def invoiceQyt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Total_Qty_Value'), 0)

int invoice_qyt = Integer.parseInt(invoiceQyt)

println(invoice_qyt)

def Amount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println(Amount)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

def compDisc = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0)

println(compDisc)

StringBuffer strbufComDisc = new StringBuffer(compDisc)

StringBuffer strComDisc = strbufComDisc.deleteCharAt(compDisc.length() - 2)

StringBuffer str1ComDisc = strbufComDisc.deleteCharAt(compDisc.length() - 3)

println(str1ComDisc)

String stCompDisc = new String(str1ComDisc)

println(stCompDisc)

double comDiscount = Double.parseDouble(stCompDisc)

println(comDiscount)

//def  Discount=Math.abs(compDisc)
//println Discount
def DistDisc = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_Value'), 0)

println(DistDisc)

StringBuffer strbufDistDisc = new StringBuffer(DistDisc)

StringBuffer strDistDisc = strbufDistDisc.deleteCharAt(compDisc.length() - 2)

StringBuffer str1DistDisc = strbufDistDisc.deleteCharAt(compDisc.length() - 3)

println(str1DistDisc)

String stDistDisc = new String(str1DistDisc)

println(stDistDisc)

double DistDiscount = Double.parseDouble(stDistDisc)

println(DistDiscount)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def SRP_Text = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text'), 0)

double SRP = Double.parseDouble(SRP_Text)

println("$SRP")

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def Actual_Amount = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value'), 0)

println("$Actual_Amount")

double Tax = Double.parseDouble(Amount) - Double.parseDouble(BuyPrice)

println(Tax)

def Discount = comDiscount + DistDiscount

println(Discount)

//def Invoice_qyt = findTestData('Phase2/TY_01/Test_Data').getValue(4, 19)
//
//double invoice = Double.parseDouble(Invoice_qyt)
//
//println("$invoice")
//
//def Discount = findTestData('Phase2/TY_01/Test_Data').getValue(6, 19)
//
//double discount = Double.parseDouble(Discount)
//
//println("$discount")
//
//def tax = findTestData('Phase2/TY_01/Test_Data').getValue(8, 19)
//
//double Tax = Double.parseDouble(tax)
//
//println(Tax)
//def Expected_Amount = findTestData('Phase2/TY_01/Test_Data').getValue(10, 19)
double FirstGrossAmount = (SRP * invoice_qyt) - comDiscount

println(FirstGrossAmount)

double SecondGrossAmount = FirstGrossAmount - DistDiscount

println(SecondGrossAmount)

TotalAmount = (SecondGrossAmount + Tax)

println(TotalAmount)

DecimalFormat df = new DecimalFormat('0.00')

Expected_Amount = df.format(TotalAmount)

//Expected_Amount = (Amount + '')
println(Expected_Amount)

Mobile.verifyEqual(Actual_Amount, Expected_Amount, FailureHandling.STOP_ON_FAILURE)

println('Amount is calculated and displayed')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/DeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_323'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()