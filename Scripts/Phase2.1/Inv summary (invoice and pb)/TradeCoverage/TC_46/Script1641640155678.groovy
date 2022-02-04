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
import java.text.DecimalFormat as DecimalFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadeAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/CommonData/CommonData').getValue('ProductName', 31)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/CommonData/CommonData').getValue('ProductName', 31)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

GlobalVariable.DropdownName = findTestData('Phase2.1/CommonData/CommonData').getValue('DropdownName', 5)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

GlobalVariable.index2 = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 3)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def ProductpieceQty = Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

println(ProductpieceQty)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

def Pieces = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

Double pieces = ((Pieces) as Double)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

def UPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

Double uprice = ((UPrice) as Double)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

def DiscountedSKUPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

Double DiscountedSKUPrice1 = ((DiscountedSKUPrice) as Double)

def TotalValue = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

Double TotalValue1 = ((TotalValue) as Double)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

def ItemAndCategoryDisc = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 
    0)

def ItemAndCategoryDisc2 = ItemAndCategoryDisc.split('-')

def ItemAndCategoryDisc23 = ItemAndCategoryDisc2[1]

def ItemAndCategoryDisc1 = ItemAndCategoryDisc23.replaceAll(' ', '')

println(ItemAndCategoryDisc1)

Double ItemAndCategoryDiscount = ((ItemAndCategoryDisc1) as Double)

def SkuGross = pieces * uprice

println(SkuGross)

println('product buying is not included in SKUgross value calculation')

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'), findTestData(
        'Phase2.1/TestData/Test_Data').getValue(2, 45), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText'), 
    findTestData('Phase2.1/TestData/Test_Data').getValue(3, 45), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

//def SecondGross = SkuGross - itemDisc
//println(SecondGross)
//def Totalprice = SecondGross - CategoryDiscount
//println(Totalprice)
Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_46'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyNotEqual(DiscountedSKUPrice1, TotalValue1, FailureHandling.STOP_ON_FAILURE)

println('Since DiscountedSKUPrice1 and TotalValue1 are not equal tax is mapped')

Mobile.verifyNotEqual(SkuGross, DiscountedSKUPrice1, FailureHandling.STOP_ON_FAILURE)

println('Since SkuGross and DiscountedSKUPrice1 are not equal  discounts are mapped')

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_46'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

