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

WebUI.callTestCase(findTestCase('Order and Invoice/Navigation/Product Master'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/a_Item'))

WebUI.verifyElementText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/a_Item'), 'Item')

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/a_Item'))

WebUI.delay(40)

WebUI.waitForElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/input_shortDescription'), 0)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/input_shortDescription'), '011_SD_MUMB_PRO')

WebUI.delay(10)

txtWebShortDesc = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_ItemShortDescription'))

println(txtWebShortDesc)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_ItemShortDescription'))

WebUI.delay(5)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_090_Web_01'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Details/a_Edit'))

WebUI.delay(5)

txtEditShortDesc = WebUI.getAttribute(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Item/txt_ShortDesc'), 
    'value')

println(txtEditShortDesc)

WebUI.verifyMatch(txtWebShortDesc, txtEditShortDesc, false)

WebUI.delay(5)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Item/lbl_Non-Salable SKU'), 0)

txtWebSalableValue = WebUI.getAttribute(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Item/txt_Salable SKU'), 
    'value')

println(txtWebSalableValue)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_090_Web_02'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Item/btn_Close_Icon'))

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/a_Linea'))

WebUI.delay(10)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/a_Item'))

WebUI.delay(30)

WebUI.waitForElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/input_shortDescription'), 0)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/input_shortDescription'), 'MUMBTRAY03')

WebUI.delay(10)

txtWebShortDesc1 = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_ItemShortDescription'))

println(txtWebShortDesc1)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_ItemShortDescription'))

WebUI.delay(5)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_090_Web_03'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Details/a_Edit'))

WebUI.delay(5)

txtEditShortDesc1 = WebUI.getAttribute(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Item/txt_ShortDesc'), 
    'value')

println(txtEditShortDesc1)

WebUI.verifyMatch(txtWebShortDesc1, txtEditShortDesc1, false)

WebUI.delay(5)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Item/lbl_Non-Salable SKU'), 0)

txtWebNonSalableValue = WebUI.getAttribute(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Item/txt_Salable SKU'), 
    'value')

println(txtWebNonSalableValue)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_090_Web_04'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Item/btn_Close_Icon'))

WebUI.verifyNotMatch(txtWebSalableValue, txtWebNonSalableValue, false, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(4)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

Mobile.delay(3)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    txtEditShortDesc, 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtValidsalableSKUSearchingProduct = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

println(txtValidsalableSKUSearchingProduct)

Mobile.hideKeyboard()

Mobile.verifyMatch(txtEditShortDesc, txtValidsalableSKUSearchingProduct, false, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyMatch(txtEditShortDesc, txtValidsalableSKUSearchingProduct, false, FailureHandling.STOP_ON_FAILURE)) {
    println('salable sku  come in order and invoice screen')

    Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_090_Mobile_01'], 
        FailureHandling.STOP_ON_FAILURE)
}

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/closeIcon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

Mobile.delay(3)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    txtEditShortDesc1, 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

Mobile.hideKeyboard()

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

if (Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0, FailureHandling.STOP_ON_FAILURE)) {
    println('Non salable sku should not come in order and invoice screen')

    Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_090_Mobile_02'], 
        FailureHandling.STOP_ON_FAILURE)
}

Mobile.closeApplication()

