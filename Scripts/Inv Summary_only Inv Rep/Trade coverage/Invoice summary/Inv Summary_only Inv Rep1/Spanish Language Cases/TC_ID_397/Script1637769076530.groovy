import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
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

Mobile.callTestCase(findTestCase('Login/Mobile/Spanish language Login/Spanish Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Hamburger Icon'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/menu_Inicio del da_Start of the day'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Odometro/menu_Odmetro'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/txt_startingKM'), 0)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/txt_startingKM'), '100', 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Odometro/btn_Iniciar el viaje_Start Journey'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Spanish Language/Odometro/txtview_Guardado exitosamente._SS_popup'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Odometro/btn_DE ACUERDO_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Hamburger Icon'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Menu-Ruta del da_TC'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/btn_Search'), 0)

Mobile.delay(5)

GlobalVariable.RetailerName = 'may'

Mobile.setText(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Retailer Search/txtEdit-BuscarSearch'), 
    GlobalVariable.RetailerName, 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Profile Info/btn_Iniciar Visita_Start Visit'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Profile Info/btn_Iniciar Visita_Start Visit'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Profile Info/btn_Iniciar Visita_Start Visit'), 
    0)

Mobile.delay(5)

if (Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Collection/Collection_BackIcon'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Collection/Collection_BackIcon'), 
        0)

    Mobile.delay(5)

    if (Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Collection/Collection_BackIcon'), 
        0, FailureHandling.OPTIONAL)) {
        Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Collection/Collection_BackIcon'), 
            0)
    }
}

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/txtView-Producto Facturable_SA_Order  Invoice'), 
    0)

Mobile.verifyElementAttributeValue(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/txtView-Producto Facturable_SA_Order  Invoice'), 
    'text', 'Producto Facturable', 0)

txtOrderInvoice = Mobile.getText(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/txtView-Producto Facturable_SA_Order  Invoice'), 
    0)

Mobile.verifyMatch('Producto Facturable', txtOrderInvoice, false)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/txtView-Producto Facturable_SA_Order  Invoice'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/filter_popup/btn_filter_popup'), 
    0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/filter_popup/ctv_Nombre del Producto'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/filter_popup/btn_DE ACUERDO_Ok'), 
    0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

not_run: skuName = findTestData('Phase 1/Surendran/Invoice Summary/Product Mapping').getValue(1, 1)

not_run: println(skuName)

not_run: Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    skuName, 0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    '002', 0)

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

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/keypad/btn-DE ACUERDO_Ok'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/keypad/btn-DE ACUERDO_Ok'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/btn-Siguiente_OI_next'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/icon_Search'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/txt_Product Buying Search'), 0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/txt_Product Buying Search'), '002', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/ProductName'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/totalPrice'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Product Buy/txtView-DD_Clasificacin de compra_Select_Reason'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Return/Reason_DropDown/Reason_DD_Salable'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Return/input_Pieces Value'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/keypad/btn-DE ACUERDO_Ok'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Product Buy/btn_Hecho_Save'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/btn-Siguiente_OI_next'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/btn_Factura_SaveandGoInvoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/Final Invoice/popoup/btn_DE ACUERDO_1st and 2nd Done'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

not_run: Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/Final Invoice/popoup/btn_DE ACUERDO_1st and 2nd Done'), 
    0)

not_run: Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/Final Invoice/popoup/btn_DE ACUERDO_1st and 2nd Done'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/Delivery Summary/btn_Crear Ticket Factura_ticketInvoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/Final Invoice/Payment_Checkbox'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/Collection/btn_Enviar_Submit'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    '2233444', 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

txtFolioNo = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtView_Default ProdBuy'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtView_Default ProdBuy'), 
    'Default ProdBuy')

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    '1234449', 0)

Mobile.delay(0, FailureHandling.STOP_ON_FAILURE)

txtProdBuyFolioNo = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/Final Invoice/btn_Crear Factura Final_FinalInvoice'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/Final Invoice/PopUp1/btn_DE ACUERDO_DSPopup'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Trade Coverage/Store Activitys/Order And Invoice/Summary/Final Invoice/PopUp1/btn_DE ACUERDO_2ndDsPopup'), 
    0)

Mobile.delay(3)

printViewText = CustomKeywords.'com.android.keywords.AndroidKeyword.gettext'('com.ivy.bimbomx.mexico.view:id/preView')

println(printViewText)

String folioNo = printViewText.toString()

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_400_02'], 
    FailureHandling.STOP_ON_FAILURE)

if (folioNo.contains('NUM FOLIO:')) {
    println('FOLIO NO is visible in print view')

    if (folioNo.contains(txtFolioNo)) {
        println(('NUM FOLIO:  ' + txtFolioNo) + ' is Present in Print view')

        Mobile.scrollToText(txtProdBuyFolioNo)

        Mobile.delay(10)

        if (folioNo.contains(txtProdBuyFolioNo)) {
            println(('NUM FOLIO:  ' + txtProdBuyFolioNo) + ' is Present in Print view')
        } else {
            println('ProdBuy Folio No is not visible in screen')
        }
    } else {
        FailureHandling.STOP_ON_FAILURE
    }
} else {
    FailureHandling.STOP_ON_FAILURE
}

Mobile.closeApplication()
