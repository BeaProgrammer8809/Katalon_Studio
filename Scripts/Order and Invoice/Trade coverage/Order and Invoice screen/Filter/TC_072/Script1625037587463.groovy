import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement

WebUI.callTestCase(findTestCase('Login/Web/Bimbo Catalog Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

Mobile.callTestCase(findTestCase('Order and Invoice/Navigation/Product Master'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(20)

WebUI.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Marca_brand/a_Marca'))

WebUI.verifyElementText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Marca_brand/a_Marca'), 'Marca')

WebUI.click(findTestObject('Phase 1.1/Resource3/Web/Product Master/Marca_brand/a_Marca'))

WebUI.delay(10)

WebUI.waitForElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Marca_brand/input_Name_Marca'), 0)

not_run: WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Marca_brand/input_Name_Marca'), 'MUMB_BRAND_BN_03')

WebUI.setText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Marca_brand/input_Name_Marca'), findTestData('Phase 1/Surendran/Order and Invoice/Filter Data').getValue(
        1, 1))

WebUI.delay(10)

txtWebMarcaName = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Marca_brand/td_MarcaName'))

println(txtWebMarcaName)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_072_Web_01'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.doubleClick(findTestObject('Phase 1.1/Resource3/Web/Product Master/Marca_brand/td_MarcaName'))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Categoria_Category/td_CategoryName'), 
    0)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_072_Web_02'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.doubleClick(findTestObject('Phase 1.1/Resource3/Web/Product Master/Categoria_Category/td_CategoryName'))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Segmento_Segment/td_SegmentoName'), 0)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_072_Web_03'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.doubleClick(findTestObject('Phase 1.1/Resource3/Web/Product Master/Segmento_Segment/td_SegmentoName'))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/td_LineName'), 0)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_072_Web_04'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.doubleClick(findTestObject('Phase 1.1/Resource3/Web/Product Master/Line/td_LineName'))

WebUI.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_ItemShortDescription'), 0)

WebUI.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Web Screenshot'), [('testCaseName') : 'TC_072_Web_05'], 
    FailureHandling.STOP_ON_FAILURE)

txtWebProductname = WebUI.getText(findTestObject('Phase 1.1/Resource3/Web/Product Master/Item/td_ItemShortDescription'))

println(txtWebProductname)

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

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_MARCA'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_MARCA'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_MARCA'), 
    0)

GlobalVariable.filterDataName = txtWebMarcaName

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterScreen_ItemName'), 
    0)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_072_Mobile_01'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/btn_Apply'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

//FilterProducts
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

List<MobileElement> filterProductList = driver.findElementsById('com.ivy.bimbomx.mexico.view:id/stock_and_order_listview_productname')

int count1 = filterProductList.size()

println(count1)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_072_Mobile_02'], 
    FailureHandling.STOP_ON_FAILURE)

for (int i = 0; i < count1; i++) {
    MobileElement element = filterProductList.get(i)

    String text = element.getText()

    String Elementtitle = 'Filter Product Name: ' + text

    println(Elementtitle)
}

Mobile.delay(4)

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

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_072_Mobile_03'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

