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

WebUI.callTestCase(findTestCase('Login/Web/Bimbo Catalog Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Master-->Product Management-->Product Master'
Mobile.callTestCase(findTestCase('Order and Invoice/Navigation/Product Master'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(20)

WebUI.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/a_Linea'))

WebUI.verifyElementText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/a_Linea'), 'Línea')

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/a_Linea'))

WebUI.delay(10)

WebUI.waitForElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/input_Name_Line'), 0)

not_run: WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/input_Name_Line'), 'MUMB_LIN_N_003')

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/input_Name_Line'), findTestData('Phase 1/Surendran/Order and Invoice/Filter Data').getValue(
        4, 1))

WebUI.delay(10)

txtLineName = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/select_Line'))

println(txtLineName)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_059_Web_01'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.doubleClick(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/select_Line'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_ItemShortDescription'), 0)

txtWebProductname = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_ItemShortDescription'))

println(txtWebProductname)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_059_Web_02'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(4)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_LINEA'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_LINEA'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_LINEA'), 
    0)

GlobalVariable.filterDataName = txtLineName

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterScreen_ItemName'), 
    0)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_059_Mobile_01'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/btn_Apply'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    txtWebProductname, 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtSearchingProduct = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

println(txtSearchingProduct)

Mobile.hideKeyboard()

Mobile.verifyMatch(txtWebProductname, txtSearchingProduct, false)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_059_Mobile_02'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

