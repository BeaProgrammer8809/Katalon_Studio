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
import java.sql.Connection as Connection
import java.sql.DriverManager as DriverManager
import java.sql.ResultSet as ResultSet
import java.sql.Statement as Statement


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

String invoiceno = 'MX21739_212001249005'

String inv_no = ('\'' + invoiceno) + '\''




Statement stm = connection.createStatement()

"select * from AppData_INT_Sales_Invoice_Header where SIH_ADH_ID = 3 and SIH_No='MX21739_212001246004' order by 1 desc"

queryString = 'select SIH_Sale_Net_Amount,SIH_Sale_IVA_Tax,SIH_Sale_IEPS_TAX,SIH_Sale_Discount from AppData_INT_Sales_Invoice_Header where SIH_ADH_ID = 3 and SIH_No='+inv_no+' order by 1 desc'

ResultSet rs = stm.executeQuery(queryString)

def recordSet = rs

while (recordSet.next()) {
	
	Object output = recordSet.getObject('SIH_Sale_Net_Amount')

	String result = output

	print(result)

	net_Amount = result
	
	println(net_Amount)
	
	neteamt=Double.parseDouble(net_Amount)
	
		println(neteamt)
	
	   Object output1 = recordSet.getObject('SIH_Sale_IVA_Tax')
	
		String result1 = output1
	
		print(result1)
	
		iva_Tax = result1
		
		println(iva_Tax)
		
		ivaamt=Double.parseDouble(iva_Tax)
		
		println(ivaamt)
	
	
		
		Object output2 = recordSet.getObject('SIH_Sale_IEPS_TAX')
		
			String result2 = output2
		
			print(result2)
		
			ieps_Tax = result2
		
			println(ieps_Tax)
			
			iepsamt=Double.parseDouble(ieps_Tax)
			
			println(iepsamt)
			
			
			
		Object output3 = recordSet.getObject('SIH_Sale_Discount')
			
			String result3 = output3
			
			print(result3)
			
			discount = result3
			
			println(discount)
			
			
			discountamt=Double.parseDouble(discount)
			
			println(discountamt)
	
}

total=iepsamt+
