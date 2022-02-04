import java.text.SimpleDateFormat
import com.kms.katalon.core.util.KeywordUtil
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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement

SimpleDateFormat formatter = new SimpleDateFormat('dd-MM-yyyy')

Date date = new Date()

def PresentDate = formatter.format(date)

println(PresentDate)

def DateinCollection = CollectionDate
 
Date date1 = formatter.parse(PresentDate)
Date date2 = formatter.parse(DateinCollection)

if (date1.equals(date2)) 
{
	KeywordUtil.markFailed(date2 + " ====  The selected date is Present Date")
	
	System.out.println(date2 + " ====  The selected date is Present Date");
}

if (date1.after(date2)) {
        
	    KeywordUtil.markFailed(date2 + " ======Selected date is Past Date")
	
		System.out.println(date2 + " ======Selected date is Past Date");
}

if (date1.before(date2)) 
{
	KeywordUtil.markFailed(date2 + " =========Selected date is future Date")
	
	System.out.println(date2 + " =========Selected date is future Date")
}

