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

ArtrCode = findTestData('Phase 1/Surendran/Retailer Details/Cash Retailer').getValue(1, 1)

println(ArtrCode)

retailerName = findTestData('Phase 1/Surendran/Retailer Details/Cash Retailer').getValue(2, 1)

println(retailerName)

WebUI.callTestCase(findTestCase('Login/Web/Bimbo Catalog Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/INE/Web Case/Store Master'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Advance Search'), 
    0)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Advance Search'))

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_RetailerName'), 
    0)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_RetailerName'), retailerName)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/btn_Search'))

WebUI.delay(3)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_Search_Code'), ArtrCode)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/td_Select Code'))

WebUI.delay(5)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/a_edit'))

WebUI.delay(5)

WebUI.delay(5)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/lbl_Onsite_Invoice'))

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/lbl_INE Enabled'))

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Store Management/Store Master/input_Credit Note use CFDI'), 'G02')

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
    retailerName, 0)

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

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Icon_INE_component'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Icon_INE_component'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Icon_INE_component'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_Ambito'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_Ambito'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_Ambito'), 
    'INE_Ambito')

Mobile.verifyElementAttributeValue(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_Ambito'), 
    'text', 'INE_Ambito', 0)

'TC_ID_352 TCT'
Mobile.verifyElementAttributeValue(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_Ambito'), 
    'enabled', 'true', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/DropDown_Ambito'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Ambito_Federal'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Ambito_Federal'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Ambito_Federal'), 
    'Federal')

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Ambito_Local'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Ambito_Local'), 
    0)

'TC354_355 TCT'
Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Ambito_Local'), 
    'Local')

'TC356 TCT'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Ambito_Local'), 
    0)

Mobile.delay(0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    'INE_ClaveEntidad')

Mobile.verifyElementAttributeValue(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    'text', 'INE_ClaveEntidad', 0)

'TC357 TCT'
Mobile.verifyElementAttributeValue(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    'enabled', 'true', 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'TC359TCT'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/DropDown_ClaveEntidad'), 
    0)

GlobalVariable.inecomplement = 'BCS'

'TC361TCT'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Select_Value'), 
    0)

