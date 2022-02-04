import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class TestListeners {
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	public void FailedTestcase(TestCaseContext testCaseContext) 
	{
		
		def status =testCaseContext.getTestCaseStatus()
		println status
		
		if (status == 'FAILED')
		{
			def testcaseId=testCaseContext.testCaseId
			def path2=testcaseId.replaceAll("Test Cases","./Screenshot")
			def actualfilepath=path2.replaceAll("/","\\\\\\\\")
			def newfilepath=actualfilepath + '.png'
			println newfilepath
			Mobile.takeScreenshot(newfilepath)
		}
		
     }
}


/*String path1='Test Cases/Phase2/Applying_Scheme/Trade_Coverage/TC_01'.replaceAll("Test Cases","Bimbo Mobile/Screenshot")
 
 println path1
 
 String path2=path1.replaceAll("/","\\\\")
 println path2*/







/*screenShotFilepath1 = '.\\Screenshot\\Phase1\\Inv Summary (Inv, Rep and Pb)\\'

filePath = ((screenShotFilepath1 + testCaseName) + '.jpeg')

println(filePath)

Mobile.takeScreenshot(filePath)

println(filePath)*/




