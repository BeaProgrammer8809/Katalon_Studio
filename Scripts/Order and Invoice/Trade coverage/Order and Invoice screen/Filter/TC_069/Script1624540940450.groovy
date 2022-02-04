import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.image.BufferedImage as BufferedImage
import javax.imageio.ImageIO as ImageIO
import org.openqa.selenium.OutputType as OutputType
import org.openqa.selenium.Point as Point
import org.openqa.selenium.TakesScreenshot as TakesScreenshot
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import io.appium.java_client.MobileDriver as MobileDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(4)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_CATEGORA'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_CATEGORA'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_CATEGORA'), 
    'CATEGORÍA')

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_CATEGORA'), 
    0)

txtCategoryData = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/first Data'), 
    0)

println(txtCategoryData)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/first Data'), 
    0)

Mobile.delay(5)

MobileDriver<MobileElement> driver = MobileDriverFactory.getDriver()

String presentTickColor = '#a8d8aa'

MobileElement presentSeller = driver.findElementByXPath('(//*[@resource-id=\'com.ivy.bimbomx.mexico.view:id/selectedfilters\'])[2]')

CustomKeywords.'com.android.keywords.AndroidKeyword.elementScreenshot'(driver, presentSeller, 'GreenTick')

Point point1 = presentSeller.getCenter()

int centerx = point1.getX()

int centery = point1.getY()

File scrFile = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)

BufferedImage image = ImageIO.read(scrFile)

int clr = image.getRGB(centerx, centery)

int red = (clr & 16711680) >> 16

int green = (clr & 65280) >> 8

int blue = clr & 255

println((((red + ',') + green) + ',') + blue)

println('Red Color value = ' + red)

println('Green Color value = ' + green)

println('Blue Color value = ' + blue)

String rhex = Integer.toHexString(red)

println(rhex)

String ghex = Integer.toHexString(green)

println(ghex)

String bhex = Integer.toHexString(blue)

println(bhex)

String AShexcode1 = (('#' + rhex) + ghex) + bhex

println(AShexcode1)

Mobile.verifyMatch(presentTickColor, AShexcode1, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_069_1'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/first Data'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/Green Selected Filter'), 
    0)

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/Green Selected Filter'), 
    0)

if (Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/Green Selected Filter'), 
    0, FailureHandling.OPTIONAL)) {
    println(txtCategoryData + ' Category should get unselected by tapping on it again')

    Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_069_2'], 
        FailureHandling.STOP_ON_FAILURE)
}

	
Mobile.closeApplication()