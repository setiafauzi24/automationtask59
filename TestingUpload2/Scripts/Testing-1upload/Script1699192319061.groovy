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

// Define the API endpoint
String apiEndpoint = 'https://dev-api.fintelite.ai/v1/ocr/recognition'

// Set the form data parameters
def formParams = [[('name') : 'document_type', ('value') : 'INVOICE'], [('name') : 'file', ('value') : '/Users/vieriazzurri/Downloads/ted/AuntieAnnes.jpg']]


//// Create a Test Object for the API request
TestObject requestObject = findTestObject('OCR Recognition Request') // Update with the actual Test Object name

// Create a new RequestObject for the API request
//RequestObject requestObject = new RequestObject('OCR Recognition Request')
//requestObject.setRestUrl(apiEndpoint)
//requestObject.setRestRequestMethod('POST')
//requestObject.setHttpHeaderProperties(['Content-Type': 'application/x-www-form-urlencoded'])
//requestObject.setHttpBody(formParams)

// Send the POST request
def response = WS.sendRequest(requestObject)

// Verify the response as needed
WS.verifyResponseStatusCode(response, 200) // Adjust the expected status code




