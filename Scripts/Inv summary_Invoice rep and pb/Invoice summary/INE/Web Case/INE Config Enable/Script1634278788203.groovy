import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import java.sql.DriverManager as DriverManager
import java.sql.ResultSet as ResultSet
import java.sql.Statement as Statement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

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

String queryString = 'select left(DATENAME(weekday,GETDATE()),3) as Day'

println(queryString)

ResultSet rs = stm.executeQuery(queryString)

def recordSet = rs

String day

while (recordSet.next()) {
    Object currentDay = recordSet.getObject('Day')

    day = currentDay.toString()

    println(day)
}

println('Day is: ' + day)

String parameter1 = ('\'%' + day) + '%\''

println(parameter1)

//Select top(1) * from ADM_Route_Retailer_Mapping where ARRM_ar_Id = 415 and ARRM_Isactive = 1 and ARRM_Visit_Day like '%Mon%'
String queryString2 = ('Select top(1) * from ADM_Route_Retailer_Mapping where ARRM_ar_Id = 415 and ARRM_Isactive = 1 and ARRM_Visit_Day like ' + 
parameter1) + ''

println(queryString2)

ResultSet rs2 = stm.executeQuery(queryString2)

def recordSet2 = rs2

String ARTRId

while (recordSet2.next()) {
    Object artrid1 = recordSet2.getObject('ARRM_ARTR_Id')

    ARTRId = artrid1.toString()

    println(ARTRId)
}

println(ARTRId)

//select  ARTR_Code,ARTR_Name from ADM_Retailer where ARTR_Id=35351 order by 1
String queryString3 = ('select  ARTR_Code,ARTR_Name from ADM_Retailer where ARTR_Id=' + ARTRId) + ' order by 1'

println(queryString3)

ResultSet rs3 = stm.executeQuery(queryString3)

def recordSet3 = rs3

String ArtrCode

String Name

while (recordSet3.next()) {
    Object artrcode = recordSet3.getObject('ARTR_Code')

    ArtrCode = artrcode.toString()

    Object artrName = recordSet3.getObject('ARTR_Name')

    Name = artrName.toString()
}

println('ARTR Code is: ' + ArtrCode)

println('Retailer Name: ' + Name)

Mobile.callTestCase(findTestCase('Login/Web/Bimbo Catalog Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/INE/Web Case/Store Master'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Advance Search'), 
    0)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Advance Search'))

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_RetailerName'), 
    0)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_RetailerName'), Name)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Search'))

WebUI.delay(3)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_Search_Code'), ArtrCode)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/td_Select Code1'))

WebUI.delay(5)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/a_edit'))

WebUI.delay(10)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/lbl_Onsite_Invoice'))

WebUI.delay(5)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/lbl_INE Enabled'))

WebUI.delay(5)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_Credit Note use CFDI'), CFDI)

WebUI.takeScreenshot()

WebUI.delay(5)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Retailer Save'))

WebUI.takeScreenshot()

not_run: WebUI.closeBrowser()

