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

WebUI.callTestCase(findTestCase('Inv Summary_only Inv Rep/Trade coverage/Invoice summary/Inv Summary_only Inv Rep1/Collection/Inv Summary_Only Inv_Rep_Night Seller'), 
    [('local_retailerName') : 'MayStore1 & Cash'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

//2 Pack Cajeta Quemada 740g COR
skuName = 'ManitaSuert16gC'

println(skuName)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    skuName, 0)

not_run: Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    '021_SD_MUMB_PRO', 0)

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

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/txt_Product Buying Search'), skuName, 0)

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

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

txtInvoiceNo = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/txt_InvoiceNo'), 0)

println(txtInvoiceNo)

invoiceNumber = txtInvoiceNo.replaceAll('Invoice No : ', '')

println(invoiceNumber)

txtPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/pcs_Qty'), 0)

println('Pieces Count: ' + txtPiecesValue)

txtUnitPrice = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/U.PriceValue'), 0)

println('Unit Price: ' + txtUnitPrice)

txtProductTotalAmt = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/productTotal'), 0)

println('Total Price: ' + txtProductTotalAmt)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'Summary'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/TotalQty_icon'), 0)

txtCompDiscValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/Comp_Disc'), 
    0)

println('Comp Disc Value: ' + txtCompDiscValue)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'SummarySplit'], 
    FailureHandling.STOP_ON_FAILURE)

String compDisc = txtCompDiscValue.replace('- ', '')

println(compDisc)

int piecesValue = Integer.parseInt(txtPiecesValue)

println(piecesValue)

Float unitPrice = Float.parseFloat(txtUnitPrice)

println(unitPrice)

Float compDiscValue = Float.parseFloat(compDisc)

println(compDiscValue)

Float cvalue = piecesValue * unitPrice

println(cvalue)

calculatedTotalPrice = cvalue.toString()

println(calculatedTotalPrice)

String calculatedTotalAmt

if (Mobile.verifyMatch(txtProductTotalAmt, calculatedTotalPrice, false, FailureHandling.OPTIONAL)) {
    Mobile.verifyMatch(txtProductTotalAmt, calculatedTotalPrice, false, FailureHandling.STOP_ON_FAILURE)
} else {
    Float calculatedTotal = cvalue - compDiscValue

    println(calculatedTotal)

    calculatedTotal1 = calculatedTotal.floatValue()

    println(calculatedTotal1)

    calculatedTotalAmt = calculatedTotal1.toString()

    GlobalVariable.totalPrice = calculatedTotalAmt

    println(GlobalVariable.totalPrice)

    if (Mobile.verifyMatch(txtProductTotalAmt, calculatedTotalAmt, false, FailureHandling.OPTIONAL)) {
        Mobile.verifyMatch(txtProductTotalAmt, calculatedTotalAmt, false, FailureHandling.STOP_ON_FAILURE)
    } else {
        Mobile.verifyNotEqual(txtProductTotalAmt.length(), calculatedTotalAmt.length(), FailureHandling.STOP_ON_FAILURE)

        updatedCalculatedTotAmt = (GlobalVariable.totalPrice + '0')

        println(updatedCalculatedTotAmt)

        Mobile.verifyMatch(txtProductTotalAmt, updatedCalculatedTotAmt, false, FailureHandling.STOP_ON_FAILURE)

        GlobalVariable.totalPrice = updatedCalculatedTotAmt

        println(GlobalVariable.totalPrice)
    }
}

println(calculatedTotalAmt)

println('Before if: ' + calculatedTotalAmt)

println('Next updated Value:' + GlobalVariable.totalPrice)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/SplitClose'), 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtBottomTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/bottom_Value'), 0)

println(txtBottomTotalValue)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_Invoice'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_ICS_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_ICS_OK'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/btn_Create Ticket Invoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/btn_Create Ticket Invoice'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/PayMentCheckBox'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_OK'), 
    0)

Mobile.delay(3)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/printPreview_BackArrow'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/printPreview_BackArrow'), 
    0)

Mobile.delay(20, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/btn_Call Analysis'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/btn_Call Analysis'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Call Analysis1/btn_Close Call'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Call Analysis1/txt-Do you want to close the call'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Call Analysis1/btn_DYWTCC_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Call Analysis1/btn_DYWTCC_OK'), 
    0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Call Analysis1/lbl_Data upload completed Successfully.'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Call Analysis1/btn_DUCS_OK'), 
    0)

println(txtInvoiceNo)

println(GlobalVariable.totalPrice)

println(txtBottomTotalValue)

invoiceNumber = txtInvoiceNo.replaceAll('Invoice No : ', '')

println(invoiceNumber)

String dbInvoiceNo = ('\'' + invoiceNumber) + '\''

println(dbInvoiceNo)

Mobile.closeApplication()

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

//select sum(SIH_Amount+SIH_Tax) as SumOfNetAmount1,sum(SIH_Sale_Net_Amount+SIH_Sale_IEPS_TAX) as SumOfNetAmount2 from AppData_INT_Sales_Invoice_Header where SIH_No='MX12713_211001265003'
String queryString = ('select sum(SIH_Amount+SIH_Tax) as SumOfSihNetAmount from AppData_INT_Sales_Invoice_Header where SIH_No=' + 
dbInvoiceNo) + ''

println(queryString)

ResultSet rs = stm.executeQuery(queryString)

def recordSet = rs

String SIHNetAmount

String SIHSaleNetAmount

while (recordSet.next()) {
    Object netamt1 = recordSet.getObject('SumOfSihNetAmount')

    SIHNetAmount = netamt1.toString()

    println(SIHNetAmount)
}

println('sum of SIH NetAmount: ' + SIHNetAmount)

Mobile.verifyMatch(txtBottomTotalValue, SIHNetAmount, false, FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyMatch('12.20', SIHNetAmount, false, FailureHandling.STOP_ON_FAILURE)
//NetAmt Calculation End
//select sum(SIH_Sale_Net_Amount-SIH_Sale_IEPS_TAX) as SumOfSihNetAmount from AppData_INT_Sales_Invoice_Header where SIH_No='MX12713_211001266003'
String queryString1 = ('select sum(SIH_Sale_Net_Amount-SIH_Sale_IEPS_TAX) as SumOfSihNetAmount1 from AppData_INT_Sales_Invoice_Header where SIH_No=' + 
dbInvoiceNo) + ''

println(queryString1)

ResultSet rs1 = stm.executeQuery(queryString1)

def recordSet1 = rs1

String SIHNetAmount1

while (recordSet1.next()) {
    Object netamt2 = recordSet1.getObject('SumOfSihNetAmount1')

    SIHNetAmount1 = netamt2.toString()

    println(SIHNetAmount1)
}

println(SIHNetAmount1)

float sihNetValue = Float.parseFloat(SIHNetAmount1)

SIHNetamt1 = String.format('%.2f', sihNetValue)

println(SIHNetamt1)

//Mobile.verifyMatch('11.30', SIHNetamt1, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(GlobalVariable.totalPrice, SIHNetamt1, false, FailureHandling.STOP_ON_FAILURE)


Mobile.closeApplication()