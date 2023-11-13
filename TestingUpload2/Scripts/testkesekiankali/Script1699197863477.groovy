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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.13')

import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

def apiEndpoint = 'https://dev-api.fintelite.ai/v1/ocr/recognition'
def documentType = 'INVOICE'
def filePath = '/Users/vieriazzurri/Downloads/ted/AuntieAnnes.jpg'

def httpClient = HttpClients.createDefault()
def httpPost = new HttpPost(apiEndpoint)

// Create a multipart entity for the request
def multipartEntity = MultipartEntityBuilder.create()
multipartEntity.addTextBody("document_type", documentType)
multipartEntity.addBinaryBody("file", new File(filePath), ContentType.DEFAULT_BINARY, "AuntieAnnes.jpg")

httpPost.setEntity(multipartEntity.build())

def response = httpClient.execute(httpPost)

println "Response Status Code: ${response.statusLine.statusCode}"
println "Response Data: ${EntityUtils.toString(response.entity)}"
