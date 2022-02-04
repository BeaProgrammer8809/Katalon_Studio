package com.ty.keywords

import java.text.DecimalFormat
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.annotation.Keyword

public class MobileKeywords {

	@Keyword
	public static double taxIVA(double totalPrice) {
		def IVA = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 17)
		IVA = Double.parseDouble(IVA)
		DecimalFormat df=new DecimalFormat("0.00")
		def tax=totalPrice*(IVA/100)
		tax=df.format(tax)
		return Double.parseDouble(tax)
	}

	@Keyword
	public static double taxIEPS(double totalPrice) {
		def IEPS = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 8)
		IEPS = Double.parseDouble(IEPS)
		DecimalFormat df=new DecimalFormat("0.00")
		def tax=totalPrice*(IEPS/100)
		tax=df.format(tax)
		return Double.parseDouble(tax)
	}

	@Keyword
	public static String taxPercentage(double tax, double totalPrice) {
		DecimalFormat df=new DecimalFormat("0")
		def taxPercent=(tax/totalPrice)*100
		taxPercent=df.format(taxPercent)
		return (taxPercent)+'%'
	}

	@Keyword
	public static double tax(double totalPrice, double value) {
		DecimalFormat df=new DecimalFormat("0.00")
		def tax=value - totalPrice
		tax=df.format(tax)
		return Double.parseDouble(tax)
	}

	@Keyword
	public static double value(double totalSum, double tax) {
		 DecimalFormat df=new DecimalFormat("0.00")
		'totalSum=totalPrice1 + totalPrice2'
		 def value=tax + totalSum
		 value=df.format(value)
		 return Double.parseDouble(value)
	}
}