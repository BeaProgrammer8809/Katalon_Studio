import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.DriverManager as DriverManager
import java.sql.ResultSet as ResultSet
import java.sql.Statement as Statement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/INE/Web Case/Store Master'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Advance Search'), 
    0)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Advance Search'))

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_RetailerName'), 
    0)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_RetailerName'), Name)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Search'))

WebUI.delay(3)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_Search_Code'), ArtrCode)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/td_Select Code'))

WebUI.delay(5)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/a_edit'))

WebUI.delay(5)

not_run: WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/lbl_Onsite_Invoice'))

not_run: WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/lbl_INE Enabled'))

not_run: WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_Credit Note use CFDI'), 
    'G02')

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Retailer Save'))

if (WebUI.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/error_Maximum length is 15'), 
    FailureHandling.OPTIONAL)) {
    giprValue = WebUI.getAttribute(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_Gipr'), 'value')

    println(giprValue)

    String updateGipr = giprValue.substring(0, 15)

    println(updateGipr)

    WebUI.clearText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_Gipr'))

    WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_Gipr'), updateGipr)

    WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Retailer Save'))
}

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('Login/Web/Clear Cache'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)

Mobile.startApplication(GlobalVariable.apk_File, false)

CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login_2'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'SellerType'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Start of the day'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/menu_Odometer'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/txt_startingKM'), 0)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/txt_startingKM'), '100', 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/btn_Start Journey'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/odometer_Popup_Saved Successfully.'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/odometer_Popup_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/header_Trade Coverage'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/btn_Search'), 0)

Mobile.delay(5)

//LA LOMA
Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/txt_Search'), 
    Name, 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Store Activity Screen Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Store Activities'), 
    0)

txtStoreActivities = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Store Activities'), 
    0)

println(txtStoreActivities)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/SA_Order and  Invoice'), 
    0)

Mobile.verifyElementAttributeValue(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/SA_Order and  Invoice'), 
    'text', 'Order and  Invoice', 0)

txtStoreActivities = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/SA_Order and  Invoice'), 
    0)

Mobile.verifyMatch('Order and  Invoice', txtStoreActivities, false)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/SA_Order and  Invoice'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

not_run: skuName = findTestData('Phase 1/Surendran/Invoice Summary/Product Mapping').getValue(1, 1)

not_run: println(skuName)

not_run: Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    skuName, 0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    'Chi', 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

txtSearchingProduct = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

println(txtSearchingProduct)

txtPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtPiecesValue)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

txtEnteredPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtEnteredPiecesValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtAfterOkPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtAfterOkPiecesValue)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

txtReturnValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtReturnValue)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

txtEnteredReturnValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtEnteredReturnValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtAfterOkReturnValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtAfterOkReturnValue)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

txtTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstSKU_Total'), 
    0)

println(txtTotalValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/icon_Search'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/txt_Product Buying Search'), 0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/txt_Product Buying Search'), 'Chi', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/ProductName'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/totalPrice'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Return/txtView_Select Reason'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Return/Reason_DropDown/Reason_DD_Salable'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Return/input_Pieces Value'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Return/btn_Done'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_Invoice'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_ICS_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_ICS_OK'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/btn_Create Ticket Invoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/btn_Create Ticket Invoice'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Icon_INE_component'), 
    0)

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Icon_INE_component'), 
    0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_Ambito'), 
    0)

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    0)

