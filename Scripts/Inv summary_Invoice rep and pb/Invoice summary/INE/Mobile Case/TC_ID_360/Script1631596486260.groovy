import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.stream.Collectors as Collectors
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import java.util.List as List

not_run: Mobile.startApplication(GlobalVariable.apk_File, false)

not_run: CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login_2'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'SellerType'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

not_run: Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Start of the day'), 0)

not_run: Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/menu_Odometer'), 0)

not_run: Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/txt_startingKM'), 0)

not_run: Mobile.hideKeyboard()

not_run: Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/txt_startingKM'), 
    '100', 0)

not_run: Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/btn_Start Journey'), 
    0)

not_run: Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/odometer_Popup_Saved Successfully.'), 
    0)

not_run: Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/odometer_Popup_OK'), 
    0)

not_run: Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/header_Trade Coverage'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/btn_Search'), 0)

not_run: retailerName = findTestData('Phase 1/Surendran/Order and Invoice/Retailer Mapping').getValue(1, 1)

not_run: println(retailerName)

Mobile.delay(5)

//LA LOMA
Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/txt_Search'), 
    'AGUSTIN JOSE MARCELO', 0)

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

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

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

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Icon_INE_component'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Icon_INE_component'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/Icon_INE_component'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    'INE_ClaveEntidad')

Mobile.verifyElementAttributeValue(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    'text', 'INE_ClaveEntidad', 0)

Mobile.verifyElementAttributeValue(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/lbl_INE_ClaveEntidad'), 
    'enabled', 'true', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/INE Complement Flag/DropDown_ClaveEntidad'), 
    0)

not_run: INE_ClaveEntidad = findTestData('Phase 1/Surendran/Invoice Summary/INE_Claveentidad').getAllData()

not_run: println(INE_ClaveEntidad)

not_run: println(INE_ClaveEntidad.size())

not_run: for (int i = 0; i < 10; i++) {
    println(INE_ClaveEntidad.get(i))

    AppiumDriver<?> addriver = MobileDriverFactory.getDriver()

    List<MobileElement> elements = addriver.findElementsById('android:id/text1')

    int count = elements.size()

    println('Total Count: ' + count)

    for (int j = 1; j < count; j++) {
        MobileElement element = elements.get(j)

        String text = element.getText()

        // Mobile.swipe(39, 183, 39, 61)
        println(text)

        if (text.contentEquals(INE_ClaveEntidad.get(i))) {
            println((('Actual Text: ' + INE_ClaveEntidad.get(i)) + 'Expected Text: ') + text)

            data1 = INE_ClaveEntidad.get(i)

            println(data1)

            println('Item Present')
        } else {
            println('Item not present')
        }
    }
}

AppiumDriver<?> addriver1 = MobileDriverFactory.getDriver()

List<MobileElement> elements = addriver1.findElementsById('android:id/text1')

int count = elements.size()

println('Total Count: ' + count)

List<MobileElement> list0 = new ArrayList<String>()

for (int k = 1; k < count; k++) {
    MobileElement element = elements.get(k)

    String text = element.getText()

    println(text)

    list0.add(text)
}

println(list0)

Mobile.delay(6)

Mobile.scrollToText('NAY', FailureHandling.STOP_ON_FAILURE)

Mobile.delay(4)

List<MobileElement> elements1 = addriver1.findElementsById('android:id/text1')

int count1 = elements1.size()

println('Total Count: ' + count1)

List<MobileElement> list1 = new ArrayList<String>()

for (int k = 1; k < count1; k++) {
    MobileElement element1 = elements1.get(k)

    String text1 = element1.getText()

    println(text1)

    list1.add(text1)
}

println(list1)

Mobile.delay(4)

Mobile.scrollToText('SIN', FailureHandling.STOP_ON_FAILURE)

Mobile.delay(7)

List<MobileElement> elements2 = addriver1.findElementsById('android:id/text1')

int count2 = elements2.size()

println('Total Count: ' + count2)

List<MobileElement> list2 = new ArrayList<String>()

for (int k = 1; k < count1; k++) {
    MobileElement element2 = elements2.get(k)

    String text2 = element2.getText()

    println(text2)

    list2.add(text2)
}

println(list2)

Mobile.delay(4)

Mobile.scrollToText('CR1', FailureHandling.STOP_ON_FAILURE)

Mobile.delay(4)

List<MobileElement> elements3 = addriver1.findElementsById('android:id/text1')

int count3 = elements3.size()

println('Total Count: ' + count3)

List<MobileElement> list3 = new ArrayList<String>()

for (int k = 1; k < count3; k++) {
    MobileElement element3 = elements3.get(k)

    String text3 = element3.getText()

    println(text3)

    list3.add(text3)
}

println(list3)

Mobile.delay(4)

println('List 0 :' + list0)

println('List 1 :' + list1)

println('List 2 :' + list2)

println('List 3 :' + list3)

List<MobileElement> listValues = new ArrayList<String>()

listValues.addAll(list0)

listValues.addAll(list1)

listValues.addAll(list2)

listValues.addAll(list3)

println(listValues)

List<MobileElement> newDataList = listValues.stream().distinct().collect(Collectors.toList())

println(newDataList)

int explistSize = newDataList.size()

println(explistSize)

INE_ClaveEntidad = findTestData('Phase 1/Surendran/Invoice Summary/INE_Claveentidad').getAllData()

println(INE_ClaveEntidad)

int listSizeValue = INE_ClaveEntidad.size()

println(listSizeValue)

Mobile.verifyEqual(listSizeValue, explistSize, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual('38', explistSize, FailureHandling.STOP_ON_FAILURE)

for (int i = 0; i < newDataList.size(); i++) {
    String Value = INE_ClaveEntidad.get(i).toArray().toString()

    actData = Value.replace('[', '').replace(']', '')

    println(actData)

    if (newDataList.get(i).equals(actData)) {
        Mobile.verifyMatch(actData, newDataList.get(i), false, FailureHandling.STOP_ON_FAILURE)

        println('Data Match')
    } else {
        println('List Not Match')

        Mobile.verifyMatch(actData, newDataList.get(i), false, FailureHandling.STOP_ON_FAILURE)
    }
}

