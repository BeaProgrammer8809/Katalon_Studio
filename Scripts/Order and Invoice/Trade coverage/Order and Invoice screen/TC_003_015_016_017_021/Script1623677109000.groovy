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

Mobile.startApplication(GlobalVariable.apk_File, false)

CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login_1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/header_Trade Coverage'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/btn_Search'), 0)

retailerName = findTestData('Phase 1/Surendran/Order and Invoice/Retailer Mapping').getValue(1, 1)

println(retailerName)

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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Odometer Verification'), [:], FailureHandling.STOP_ON_FAILURE)

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

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

txttitle = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

println(txttitle)

String[] OAI = txttitle.split('\\(')

println(OAI[0])

String OAITitle = OAI[0].trim()

println(OAITitle)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_003_01'], 
    FailureHandling.STOP_ON_FAILURE)

'1. Screen title should be Order and Invoice'
Mobile.verifyMatch('Order and  Invoice', OAITitle, false, FailureHandling.STOP_ON_FAILURE)

println(OAI[1])

String skucount = OAI[1].replace(')', '')

println(skucount)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SIH_First'), 
    0)

txtSIH1 = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SIH_First'), 
    0)

println(txtSIH1)

String[] sihTitle = txtSIH1.split('\\(')

println(sihTitle[0])

String shiTitle = sihTitle[0].trim()

println(shiTitle)

'2.Grid with following columns SIH(name), SIH(qty), SO, Pieces, Returns, SRP, Total should be displayed.'
Mobile.verifyMatch('SIH', shiTitle, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_003_02'], 
    FailureHandling.STOP_ON_FAILURE)

println(shiTitle[1])

String sihCount = sihTitle[1].replace(')', '')

println(sihCount)

Mobile.verifyMatch(skucount, sihCount, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SIH'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SIH'), 
    0)

txtGirdSIH = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SIH'), 
    0)

Mobile.verifyMatch('SIH', txtGirdSIH, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SO'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SO'), 
    0)

txtGirdSO = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SO'), 
    0)

Mobile.verifyMatch('SO', txtGirdSO, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_Pieces'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_Pieces'), 
    0)

txtGirdPieces = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_Pieces'), 
    0)

Mobile.verifyMatch('Pieces', txtGirdPieces, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_Returns'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_Returns'), 
    0)

txtGirdReturns = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_Returns'), 
    0)

Mobile.verifyMatch('Returns', txtGirdReturns, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SRP'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SRP'), 
    0)

txtGirdSRP = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_SRP'), 
    0)

Mobile.verifyMatch('SRP', txtGirdSRP, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_Total'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_Total'), 
    0)

txtGirdTotal = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/gridHeader_Total'), 
    0)

Mobile.verifyMatch('Total', txtGirdTotal, false)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_003_03'], 
    FailureHandling.STOP_ON_FAILURE)

'3. Value, Total Qty and Next button should be present at the bottom'
Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/lbl_bottomValue'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/lbl_bottomValue'), 
    0)

txtBottomValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/lbl_bottomValue'), 
    0)

Mobile.verifyMatch('Value', txtBottomValue, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/lbl_bottomTotal Qty'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/lbl_bottomTotal Qty'), 
    0)

txtBottomTotalQty = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/lbl_bottomTotal Qty'), 
    0)

Mobile.verifyMatch('Total Qty', txtBottomTotalQty, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

txtBottomNext = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.verifyMatch('Next', txtBottomNext, false)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_003_04'], 
    FailureHandling.STOP_ON_FAILURE)

'4. Special filter, Normal filter and search icon should be displayed at the top of the screen with back button.'
Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Special filter'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Special filter'), 
    0)

txtSpecialFilter = Mobile.getAttribute(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Special filter'), 
    'resource-id', 0)

println(txtSpecialFilter)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

txtNormalFilter = Mobile.getAttribute(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    'resource-id', 0)

println(txtNormalFilter)

'TC_015 -->Check whether keypad is displaying while tapping on piece field'
Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

txtPiecesCount = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtPiecesCount)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_017_01'], 
    FailureHandling.STOP_ON_FAILURE)

txtenteredPiecesCount = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtenteredPiecesCount)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_Cancel'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_Cancel'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

txtAfterCancePieceValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtAfterCancePieceValue)

Mobile.verifyNotMatch(txtenteredPiecesCount, txtAfterCancePieceValue, false, FailureHandling.STOP_ON_FAILURE)

txtAfterCancelPiecesCount = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtAfterCancelPiecesCount)

'017-->Check whether piece field is updated with entered qty while clicking cancel in keypad'
Mobile.verifyMatch(txtPiecesCount, txtAfterCancelPiecesCount, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_017_02'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

txtKeyPad = Mobile.getAttribute(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    'resource-id', 0)

println(txtKeyPad)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_015'], 
    FailureHandling.STOP_ON_FAILURE)

'015-->Check whether keypad is displaying while tapping on piece field'
if (txtKeyPad.contains('typed_value')) {
    println('KeyPad is displayed ' //Add ScreenShots
        )
}

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

txtenteredPieces = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtenteredPieces)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

txtAfterEnterPieceValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtAfterEnterPieceValue)

Mobile.verifyNotMatch(txtPiecesCount, txtAfterEnterPieceValue, false, FailureHandling.STOP_ON_FAILURE)

'016-->Check whether able to enter only piece qty for an sku'
Mobile.verifyMatch(txtAfterEnterPieceValue, txtenteredPieces, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_016'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

txtReturnsValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtReturnsValue)

'TC_021-->Check whether able to enter both piece and replacement (returns) qty for an sku(Enter some qty in Piece and Returns (say: 10, 5) and verify it is entered)'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

txtEnteredReturn = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtEnteredReturn)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyNotMatch(txtReturnsValue, txtEnteredReturn, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyNotMatch(txtAfterEnterPieceValue, txtEnteredReturn, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_017'], 
    FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyNotMatch(txtAfterEnterPieceValue, txtEnteredReturn, false, FailureHandling.STOP_ON_FAILURE)) {
    println('Seller should be able to enter both piece and returns qty and the entered qty should be updated correctly')

    println('Piece Value is: ' + txtAfterEnterPieceValue)

    println('Returns Value is: ' + txtEnteredReturn)

    Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_021'], 
        FailureHandling.STOP_ON_FAILURE)
} else {
    FailureHandling.STOP_ON_FAILURE

    Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_021_Failed'], 
        FailureHandling.STOP_ON_FAILURE)
}

Mobile.closeApplication()

