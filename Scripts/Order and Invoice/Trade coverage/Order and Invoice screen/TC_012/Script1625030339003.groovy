import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

txtSIH = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/StockInHand'), 
    0)

println(txtSIH)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_012'], 
    FailureHandling.STOP_ON_FAILURE)

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

String arID = findTestData('Phase 1/Surendran/DataBase/Order and Invoice/TC_012').getValue(1, 1)

String queryString1 = ('select * from ADM_User_Route_Mapping where AURM_AR_Id in (' + arID) + ')'

println(queryString1)

ResultSet rs1 = stm.executeQuery(queryString1)

def recordSet1 = rs1

String arum_AdhId

String arum_userId

while (recordSet1.next()) {
    Object adhId = recordSet1.getObject('AURM_ADH_Id')

    arum_AdhId = adhId.toString()

    Object userId = recordSet1.getObject('AURM_User_Id')

    arum_userId = userId.toString()
}

println(arum_AdhId)

println(arum_userId)

//2nd Query
//select * from AppData_Opening_Stock_Header where OSH_ADH_id='3' and OSH_AUH_id='116'
String queryString2 = ((('select * from AppData_Opening_Stock_Header where OSH_ADH_id=' + arum_AdhId) + ' and OSH_AUH_id=') + 
arum_userId) + ''

println(queryString2)

ResultSet rs2 = stm.executeQuery(queryString2)

def recordSet2 = rs2

String oshId

while (recordSet2.next()) {
    Object OSH_id = recordSet2.getObject('OSH_id')

    oshId = OSH_id.toString()
}

println(oshId)

//3rd Query
//select * from AppData_Opening_Stock_Detail where OSD_OSH_id=8 and OSD_APH_id=14
String OSD_AphID = findTestData('Phase 1/Surendran/DataBase/Order and Invoice/TC_012').getValue(3, 1)

String queryString3 = ((('select * from AppData_Opening_Stock_Detail where OSD_OSH_id=' + oshId) + ' and OSD_APH_id=') + 
OSD_AphID) + ''

println(queryString3)

ResultSet rs3 = stm.executeQuery(queryString3)

def recordSet3 = rs3

String dbSHIValue

while (recordSet3.next()) {
    Object OSDQty = recordSet3.getObject('OSD_Qty')

    dbSHIValue = OSDQty.toString()
}

println(dbSHIValue)

Mobile.verifyMatch(txtSIH, dbSHIValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

