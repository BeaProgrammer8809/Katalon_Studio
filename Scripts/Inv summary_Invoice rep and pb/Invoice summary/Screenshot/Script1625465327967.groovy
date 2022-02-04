import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

String path

String filePath


screenShotFilepath1 = '.\\Screenshot\\Phase1\\Inv Summary (Inv, Rep and Pb)\\'

filePath = ((screenShotFilepath1 + testCaseName) + '.jpeg')

println(filePath)

Mobile.takeScreenshot(filePath)

println(filePath)