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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

'Click on stock proposal'
Mobile.tap(findTestObject('Object Repository/Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> list = driver.findElementsByXPath("//*[@resource-id='com.ivy.bimbomx.mexico.view.uat:id/stock_and_order_listview_csq']")

int len = list.size()

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), [('testCaseName') : 'SP_TC_15'], FailureHandling.STOP_ON_FAILURE)

Mobile.comment('verifying C , E , S visible for all the product')

for (int i = 1; i <= len; i++) {
    GlobalVariable.index = i

    Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/CNum_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

    Mobile.verifyElementVisible(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/CNum_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

    Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/ENum_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

    Mobile.verifyElementVisible(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/ENum_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

    Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/SNum_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

    Mobile.verifyElementVisible(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/SNum_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
}

Mobile.closeApplication()
