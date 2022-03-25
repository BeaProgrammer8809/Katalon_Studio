import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Filter_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/MARCA_Menu'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/Marca_Sample'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/Marca_Sample'), 0, 
    FailureHandling.STOP_ON_FAILURE)

println('All brand are displayed under Marca menu')

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> list = driver.findElementsByXPath("//*[@resource-id='com.ivy.bimbomx.mexico.view.uat:id/grid_item_text']")

int len=list.size()

for(int i=1;i<=len;i++){
	GlobalVariable.index=i
	
	Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/ListObject_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
	
	Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/ListObject_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
}

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), [('testCaseName') : 'SP_TC_09_FilterScreen'], 
    FailureHandling.STOP_ON_FAILURE)

'***************************************--->SP_TC_10<----************************************************************'
Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/CATEGORIA_Menu'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/Category_Sample'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/Category_Sample'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('All Category products are displayed under Category menu')

List<WebElement> list1 = driver.findElementsByXPath("//*[@resource-id='com.ivy.bimbomx.mexico.view.uat:id/grid_item_text']")

int len1=list1.size()

for(int i=1;i<=len1;i++){
	GlobalVariable.index=i
	
	Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/ListObject_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
	
	Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/ListObject_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
}

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), [('testCaseName') : 'SP_TC_10_FilterScreen'], 
    FailureHandling.STOP_ON_FAILURE)

'***************************************--->SP_TC_11<----************************************************************'
Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/SEGMENTO_Menu'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/Segmento_Sample'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/Segmento_Sample'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('All Segment products are displayed under Segmento menu')

List<WebElement> list2 = driver.findElementsByXPath("//*[@resource-id='com.ivy.bimbomx.mexico.view.uat:id/grid_item_text']")

int len2=list2.size()

for(int i=1;i<=len2;i++){
	GlobalVariable.index=i
	
	Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/ListObject_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
	
	Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/ListObject_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
}

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), [('testCaseName') : 'SP_TC_11_FilterScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

