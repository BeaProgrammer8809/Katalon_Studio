import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.sun.org.apache.xpath.internal.compiler.Keywords as Keywords
import java.sql.Connection as Connection
import java.sql.DriverManager as DriverManager
import java.sql.ResultSet as ResultSet
import java.sql.Statement as Statement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv summary_invoice and pb/Cash Retailer Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Store Activity Screen/Order and  Invoice'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv Summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search icon'), 0)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search input field'), findTestData('Phase 1/Anen/Inv summary_invoice and pb/Sku List').getValue(
        'sku_only_tax_IVA_and_Item_level_discounts', 1), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/input_1st Row Piece'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/Backspace'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/Backspace'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/Backspace'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/2'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Unit_price_Order&Invoice'
total_Value = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Total Value value'), 0)

println(total_Value)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Product Buying Screen Title'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search icon'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

not_run: Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search input field'), findTestData('Phase 1/Anen/Inv Summary(Only PB)/Inv Summary(Only PB)').getValue(
        'ricolinosku', 1), 0)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search input field'), findTestData('Phase 1/Anen/Inv summary_invoice and pb/Sku List').getValue(
        'sku_only_tax_IVA_and_Item_level_discounts', 1), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Total Piece 1st Row'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Select Reason Drop down'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Salable'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/1'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Add another Reason  Quantity'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Select Reason Drop down'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Non-Salable'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input 0'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/1'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Done Button'), 0)

'PB Toal Value'
total_ValuePB = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Value amout'), 0)

println(total_ValuePB)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

summary_Total = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Sku right Value 1st Row'), 0)

println(summary_Total)

summaryValue_Total = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Value value bottom'), 0)

println(summaryValue_Total)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Information icon Bottom'), 0)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_158'], 
    FailureHandling.STOP_ON_FAILURE)

Order_Value = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Amount split up(info-icon)/Order Value value'), 
    0)

println(Order_Value)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Amount split up(info-icon)/Close X Button'), 0)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_041_092'], 
    FailureHandling.STOP_ON_FAILURE)

invoice_no = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - Invoice No'), 
    0)

println(invoice_no)

invoice_no = invoice_no.substring(invoice_no.indexOf(':') + 2)

println(invoice_no)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Button - Invoice'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Invoice Pop-up/Do you want to save'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Invoice Pop-up/Button - OK'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Invoice Pop-up/TextView - Invoice created successfully.'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Invoice Pop-up/Button - OK'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Summary/Button - Create Ticket Invoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Summary/Button - Create Ticket Invoice'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Header - Delivery Final Summary'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Payment - CheckBox'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/checkbox_Efectivo'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/button_Submit'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), '111111')

    if (Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/2nd Row input Folio No.'), 
        0, FailureHandling.STOP_ON_FAILURE)) {
        Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/2nd Row input Folio No.'), '111111')
    }
}

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/Create Final Invoice Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/Popup OK Button'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/OK - Spliited Invoice Saved'), 
    70)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/OK - Spliited Invoice Saved'), 10)

Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_041_092_158(1)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Call Analysis Objects/button_backarrow'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Call Analysis/Call Analysis'), [:], FailureHandling.STOP_ON_FAILURE)

Double neteamt = 0.0

Double iepsamt = 0.0

Double ivaamt = 0.0

Double discountamt = 0.0

url = findTestData('DataBase Credentials/Database Info').getValue('ServerName', 1)

dbname = findTestData('DataBase Credentials/Database Info').getValue('Database-name', 1)

username = findTestData('DataBase Credentials/Database Info').getValue('Username', 1)

password = findTestData('DataBase Credentials/Database Info').getValue('Password', 1)

String conn = (((((('jdbc:sqlserver://' + url) + ';databaseName=') + dbname) + ';user=') + username) + ';password=') + password

connection = DriverManager.getConnection(conn)

String invoiceno = invoice_no

String inv_no = ('\'' + invoiceno) + '\''

//String user = findTestData('PNG ASEAN/Login Credentials/Mobile Credentials').getValue(1, 1)
//
//String userName = ('\'' + user) + '\''
//
//String game = 'GAME'
//
//String gameID = ('\'' + game) + '\''
Statement stm = connection.createStatement()

'select * from AppData_INT_Sales_Invoice_Header where SIH_No=\'MX21739_212001246004\' order by 1 desc'
queryString = (('select SIH_Amount,SIH_Sale_IVA_Tax,SIH_Sale_IEPS_TAX,SIH_Sale_Discount from AppData_INT_Sales_Invoice_Header where SIH_No=' + 
inv_no) + ' order by 1 desc')

ResultSet rs = stm.executeQuery(queryString)

def recordSet = rs

while (recordSet.next()) {
    Object output = recordSet.getObject('SIH_Amount')

    String result = output

    print(result)

    net_Amount = result

    println(net_Amount)

    neteamt = Double.parseDouble(net_Amount)

    println(neteamt)

    Object output1 = recordSet.getObject('SIH_Sale_IVA_Tax')

    String result1 = output1

    print(result1)

    iva_Tax = result1

    println(iva_Tax)

    ivaamt = Double.parseDouble(iva_Tax)

    println(ivaamt)

    Object output2 = recordSet.getObject('SIH_Sale_IEPS_TAX')

    String result2 = output2

    print(result2)

    ieps_Tax = result2

    println(ieps_Tax)

    iepsamt = Double.parseDouble(ieps_Tax)

    println(iepsamt)

    Object output3 = recordSet.getObject('SIH_Sale_Discount')

    String result3 = output3

    print(result3)

    discount = result3

    println(discount)

    discountamt = Double.parseDouble(discount)

    println(discountamt)
}

println(neteamt)

println(ivaamt)

println(iepsamt)

//total_Amount = ((neteamt + ivaamt) + iepsamt)
//
//println(total_Amount)
total_Amount = (neteamt - discountamt)

println(total_Amount)

totalValueamt = ((total_Amount + ivaamt) + iepsamt)

println(totalValueamt)

total_order = ((neteamt + ivaamt) + iepsamt)

println(total_order)

String totalorder = String.format('%.2f', total_order)

String total = String.format('%.2f', total_Amount)

String totalValue = String.format('%.2f', totalValueamt)

Mobile.verifyMatch(summary_Total, total, false)

Mobile.verifyMatch(summaryValue_Total, totalValue, false)

Mobile.verifyMatch(Order_Value, totalorder, false)

Mobile.closeApplication()

