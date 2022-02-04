import java.sql.DriverManager as DriverManager
import java.sql.ResultSet as ResultSet
import java.sql.Statement as Statement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

String txtInvoiceNo = 'Invoice No : MX12713_211001266003'

invoiceNumber = txtInvoiceNo.replaceAll('Invoice No : ', '')

println(invoiceNumber)

String dbInvoiceNo = ('\'' + invoiceNumber) + '\''

println(dbInvoiceNo)

String url = findTestData('DataBase Credentials/Database Info').getValue(1, 1)

println(url)

String databaseName = findTestData('DataBase Credentials/Database Info').getValue('Database-name', 1)

println(databaseName)

String userName = findTestData('DataBase Credentials/Database Info').getValue('Username', 1)

println(userName)

String passWord = findTestData('DataBase Credentials/Database Info').getValue('Password', 1)

println(passWord)

String conn = (((((('jdbc:sqlserver://' + url) + ';databaseName=') + databaseName) + ';user=') + userName) + ';password=') + 
passWord

println(conn)

connection = DriverManager.getConnection(conn)

Statement stm = connection.createStatement()

//select sum(SIH_Amount+SIH_Tax) as SumOfNetAmount1,sum(SIH_Sale_Net_Amount+SIH_Sale_IEPS_TAX) as SumOfNetAmount2 from AppData_INT_Sales_Invoice_Header where SIH_No='MX12713_211001265003'
String queryString = ('select sum(SIH_Amount+SIH_Tax) as SumOfSihNetAmount from AppData_INT_Sales_Invoice_Header where SIH_No=' + 
dbInvoiceNo) + ''

println(queryString)

ResultSet rs = stm.executeQuery(queryString)

def recordSet = rs

String SIHNetAmount

String SIHSaleNetAmount

while (recordSet.next()) {
    Object netamt1 = recordSet.getObject('SumOfSihNetAmount')

    SIHNetAmount = netamt1.toString()

    println(SIHNetAmount)
}

println('sum of SIH NetAmount: ' + SIHNetAmount)

//Mobile.verifyMatch(txtBottomTotalValue, SIHNetAmount, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch('12.20', SIHNetAmount, false, FailureHandling.STOP_ON_FAILURE)

//NetAmt Calculation End
//select sum(SIH_Sale_Net_Amount-SIH_Sale_IEPS_TAX) as SumOfSihNetAmount from AppData_INT_Sales_Invoice_Header where SIH_No='MX12713_211001266003'
String queryString1 = ('select sum(SIH_Sale_Net_Amount-SIH_Sale_IEPS_TAX) as SumOfSihNetAmount1 from AppData_INT_Sales_Invoice_Header where SIH_No=' + 
dbInvoiceNo) + ''

println(queryString1)

ResultSet rs1 = stm.executeQuery(queryString1)

def recordSet1 = rs1

String SIHNetAmount1

while (recordSet1.next()) {
    Object netamt2 = recordSet1.getObject('SumOfSihNetAmount1')

    SIHNetAmount1 = netamt2.toString()

    println(SIHNetAmount1)
}

println(SIHNetAmount1)

float sihNetValue = Float.parseFloat(SIHNetAmount1)

SIHNetamt1 = String.format('%.2f', sihNetValue)

println(SIHNetamt1)

Mobile.verifyMatch('11.30', SIHNetamt1, false, FailureHandling.STOP_ON_FAILURE)
//Mobile.verifyMatch(GlobalVariable.totalPrice, SIHNetamt1, false, FailureHandling.STOP_ON_FAILURE)