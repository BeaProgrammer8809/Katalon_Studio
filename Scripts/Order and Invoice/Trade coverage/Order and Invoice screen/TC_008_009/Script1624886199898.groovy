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

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Menu/Master'))

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Menu/Product Management'))

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Menu/Product Master'))

WebUI.delay(20)

WebUI.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/a_Item'))

WebUI.verifyElementText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/a_Item'), 'Item')

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/a_Item'))

WebUI.delay(35)

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/input_shortDescription'), '002_SD_MUMB_PRO')

WebUI.delay(30)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_ItemShortDescription1'))

'TC_008-->  Check whether the sku name is displaying correctly in Order and invoice screen'
WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_008_Web'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

txtWebShortDesc = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_Selected_ItemShortDescription'))

println(txtWebShortDesc)

WebUI.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Details/a_Edit'))

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Details/a_Edit'))

WebUI.delay(20)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Details/lbl_Conversion Qty'), 0)

txtWebConversionQty = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Details/Tray_Conversion_Qty'))

println(txtWebConversionQty)

WebUI.verifyNotMatch('0', txtWebConversionQty, false)

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/Edit Details/Tray_Conversion_Qty'))

'TC_009-->  Check whether the tray conversion quantity (C) is displaying correctly against each sku in Order and invoice screen'
WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_009_Web'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    '002_SD_MUMB_PRO', 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtSearchingProduct = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

println(txtSearchingProduct)

Mobile.hideKeyboard()

'TC_008-->  Check whether the sku name is displaying correctly in Order and invoice screen'
Mobile.verifyMatch(txtWebShortDesc, txtSearchingProduct, false)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_008_Mobile'], 
    FailureHandling.STOP_ON_FAILURE)

txtCQ = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/lbl_Coversion_Qty'), 
    0)

println(txtCQ)

String[] csQty = txtCQ.split('C: ')

println(csQty[1])

String csQtyValue = csQty[1].trim()

println(csQtyValue)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_009_Mobile'], 
    FailureHandling.STOP_ON_FAILURE)

'TC_009-->  Check whether the tray conversion quantity (C) is displaying correctly against each sku in Order and invoice screen'
Mobile.verifyMatch(txtWebConversionQty, csQtyValue, false)

Mobile.closeApplication()

