import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement

not_run: Mobile.startApplication(GlobalVariable.apk_File, false)

not_run: CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Special filter'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Special filter'), 
    0)

txtSpecialFilter = Mobile.getAttribute(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Special filter'), 
    'resource-id', 0)

if (txtSpecialFilter.contains('spl_filter')) {
    println('Special Filter is visible')

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Special filter'), 
        0)
}

Mobile.delay(3)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Ordered'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Ordered'), 
    0)

txtOrdered = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Ordered'), 
    0)

Mobile.verifyMatch('Ordered', txtOrdered, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Purchased'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Purchased'), 
    0)

txtPurchased = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Purchased'), 
    0)

Mobile.verifyMatch('Purchased', txtPurchased, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Scheme'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Scheme'), 
    0)

txtScheme = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Scheme'), 
    0)

Mobile.verifyMatch('Scheme', txtScheme, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_SIH'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_SIH'), 
    0)

txtSIH = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_SIH'), 
    0)

Mobile.verifyMatch('SIH', txtSIH, false, FailureHandling.STOP_ON_FAILURE)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

List<MobileElement> elements = driver.findElementsById('com.ivy.bimbomx.mexico.view:id/grid_item_text')

int count = elements.size()

println(count)

for (int i = 0; i < count; i++) {
    MobileElement element = elements.get(i)

    String text = element.getText()

    String Elementtitle = 'Product Names: ' + text

    println(Elementtitle)
}

'TC_041--> To check the special filters available in order and invoice screen End'
Mobile.verifyEqual(4, count, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/BackIcon'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/BackIcon'), 0)

Mobile.delay(4)

txtProduct = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

println(txtProduct)

Mobile.hideKeyboard()

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

Mobile.verifyMatch(txtEnteredPiecesValue, txtAfterOkPiecesValue, false)

Mobile.verifyNotMatch(txtPiecesValue, txtAfterOkPiecesValue, false)

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

Mobile.verifyMatch(txtEnteredReturnValue, txtAfterOkReturnValue, false)

Mobile.verifyNotMatch(txtReturnValue, txtAfterOkReturnValue, false)

'TC_042--> To check the functionality of Ordered special filter'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Special filter'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_Ordered'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/Title_Ordered'), 
    0)

txtTitleOrdered = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/Title_Ordered'), 
    0)

println(txtTitleOrdered)

Mobile.verifyMatch('Ordered (1/1)', txtTitleOrdered, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

txtOrderProduct = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

println(txtOrderProduct)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

txtOrderPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtOrderPiecesValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

txtOrderReturnValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtOrderReturnValue)

Mobile.verifyMatch(txtProduct, txtOrderProduct, false)

Mobile.verifyMatch(txtAfterOkPiecesValue, txtOrderPiecesValue, false)

Mobile.verifyMatch(txtAfterOkReturnValue, txtOrderReturnValue, false)

'TC_50--> To check whether able to navigate to Product buying screen after applying the Ordered in special filter'
Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Product Buying'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Product Buying'), 0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Product Buying'), 'Product Buying')

'TC_50--> To check whether able to navigate to Product buying screen after applying the Ordered in special filter End'
if (Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Product Buying'), 0, FailureHandling.STOP_ON_FAILURE)) {
    println(('Application allow to navigate to product buying screen on clicking next button with ' + txtOrdered) + ' special" filter')
} else {
    FailureHandling.STOP_ON_FAILURE
}

Mobile.delay(3)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/BackIcon'), 0)

Mobile.delay(10)

'TC_043--> To check whether able to view all the sku\'s after applying the Ordered special filter Start'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Special filter'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_btn_All'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_btn_All'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_btn_All'), 
    'All')

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Special Filter/SF_btn_All'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

txtHeaderOrderandInvoice = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

println(txtHeaderOrderandInvoice)

if (txtHeaderOrderandInvoice.contains('Order and  Invoice')) {
    //Add print Screen
    println('1. The screen name should be changed back to Order and Invoice.')

    List<MobileElement> productList = driver.findElementsById('com.ivy.bimbomx.mexico.view:id/stock_and_order_listview_productname')

    int count1 = productList.size()

    println(count1)

    '2. All the sku\'s that was displayed before applying the Ordered special filter should be displayed after clicking the All button'
    for (int i = 0; i < count1; i++) {
        MobileElement element = productList.get(i)

        String text = element.getText()

        String Elementtitle = 'Product Names: ' + text

        println(Elementtitle)
    }
    
    Mobile.delay(4)
} else {
    FailureHandling.STOP_ON_FAILURE
}

Mobile.closeApplication()

