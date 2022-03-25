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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Filter_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/MARCA_Menu'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/MARCA_Menu'), 0, FailureHandling.STOP_ON_FAILURE)

println "Marca product level is displayed in filter screen"

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/CATEGORIA_Menu'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/CATEGORIA_Menu'), 0, FailureHandling.STOP_ON_FAILURE)

println "Category product level is displayed in filter screen"

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/SEGMENTO_Menu'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/SEGMENTO_Menu'), 0, FailureHandling.STOP_ON_FAILURE)

println "Segment product level is displayed in filter screen"

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/LINEA_Menu'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/BIFilterScreen01/LINEA_Menu'), 0, FailureHandling.STOP_ON_FAILURE)

println "Line product level is displayed in the filter screen"

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), [('testCaseName') : 'SP_TC_08_SPScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

