import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import java.sql.DriverManager as DriverManager
import java.sql.ResultSet as ResultSet
import java.sql.Statement as Statement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

serverName = findTestData('DataBase Credentials/Database Info').getValue(1, 1)

println(serverName)

dataBaseName = findTestData('DataBase Credentials/Database Info').getValue(2, 1)

println(dataBaseName)

userName = findTestData('DataBase Credentials/Database Info').getValue(3, 1)

println(userName)

passWord = findTestData('DataBase Credentials/Database Info').getValue(4, 1)

println(passWord)

String conn = (((((('jdbc:sqlserver://' + serverName) + ';databaseName=') + dataBaseName) + ';user=') + userName) + ';password=') + 
passWord

println(conn)

connection = DriverManager.getConnection(conn)

Statement stm = connection.createStatement()

String agID = 8

String queryString1 = ('select * from ADM_Groups where AG_Id in  (' + agID) + ')'

println(queryString1)

ResultSet rs1 = stm.executeQuery(queryString1)

def recordSet1 = rs1

String dbAgCode

while (recordSet1.next()) {
    Object code = recordSet1.getObject('AG_Code')

    dbAgCode = code.toString()
}

println(dbAgCode)

rs1.close()

stm.close()

connection.close()

WebUI.callTestCase(findTestCase('Login/Web/Bimbo Catalog Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.callTestCase(findTestCase('Order and Invoice/Navigation/Price Group'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/Product Price_1/input_Name'), 
    0)

WebUI.delay(5)

println(dbAgCode)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/Product Price_1/input_Name'), dbAgCode)

WebUI.delay(5)

WebUI.doubleClick(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/Product Price_1/select_Name'))

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/Price Group Detail/AG_Code'), 
    0)

txtCode = WebUI.getAttribute(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/Price Group Detail/AG_Code'), 
    'value')

println(txtCode)

WebUI.verifyMatch(dbAgCode, txtCode, false)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/Price Group Detail/btn_SaveandProceed'))

WebUI.delay(10)

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/dropdown_Company'), 
    0)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/dropdown_Company'))

GlobalVariable.selectData = 'RIC - Ricolino'

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/select_Data'))

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/dropdown_Brand'))

WebUI.delay(2)

GlobalVariable.selectData = 'MUMB_BRAND_01 - MUMB_BRAND_BN_01'

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/select_Data'))

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/dropdown_Category'))

WebUI.delay(2)

GlobalVariable.selectData = 'MUMB_CAT_01 - MUMB_CAT_N_01'

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/select_Data'))

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/dropdown_Segment'))

WebUI.delay(2)

GlobalVariable.selectData = 'MUMB_SEG_001 - MUMB_SEG_N_001'

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/select_Data'))

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/dropdown_Line'))

WebUI.delay(2)

GlobalVariable.selectData = 'MUMB_LIN_001 - MUMB_LIN_N_001'

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/select_Data'))

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/btn_Filter'))

WebUI.delay(10)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/input_Search_SKU'), findTestData(
        'Phase 1/Anen/Product Buying Screen/Product Buying Screen TD').getValue('sku', 1))

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/select_UOM'))

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/select_UOM_Piece'))

WebUI.delay(5)

txtSKUName = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/SKUName'))

println(txtSKUName)

txtCashPurchase = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/cash_Purchase'))

println(txtCashPurchase)

txtCreditPurchase = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Price Management/Price Group/SKU Price List/credit_Purchase'))

println(txtCreditPurchase)

Mobile.verifyMatch(txtCashPurchase, txtCreditPurchase, false, FailureHandling.STOP_ON_FAILURE)

String SKUName = txtSKUName.replaceAll('[^\\d.]', '')

println(SKUName)

String webCashValue = txtCashPurchase.substring(0, txtCashPurchase.length() - 2)

println(webCashValue)

String webCreditValue = txtCreditPurchase.substring(0, txtCreditPurchase.length() - 2)

println(webCreditValue)

WebUI.closeBrowser()

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    SKUName, 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

txtSearchingProduct = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Sku name 1st row - Copy'), 
    0)

println(txtSearchingProduct)

txtSRPValue = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/SRP 1st row'), 0)

println(txtSRPValue)

not_run: Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_013_Mobile'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_089'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(webCashValue, txtSRPValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(webCreditValue, txtSRPValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

