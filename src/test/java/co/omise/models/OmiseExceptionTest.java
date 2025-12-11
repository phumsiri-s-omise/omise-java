package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

/**
 * Comprehensive unit tests for OmiseException
 * Focuses on increasing coverage for getters, setters, and toString
 */
public class OmiseExceptionTest extends OmiseTest {

    @Test
    public void testObjectGetterAndSetter() {
        OmiseException exception = new OmiseException();
        exception.setObject("error");
        assertEquals("error", exception.getObject());
    }

    @Test
    public void testLocationGetterAndSetter() {
        OmiseException exception = new OmiseException();
        exception.setLocation("https://www.omise.co/api-errors");
        assertEquals("https://www.omise.co/api-errors", exception.getLocation());
    }

    @Test
    public void testCodeGetterAndSetter() {
        OmiseException exception = new OmiseException();
        exception.setCode("invalid_card");
        assertEquals("invalid_card", exception.getCode());
    }

    @Test
    public void testHttpStatusCodeGetterAndSetter() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(400);
        assertEquals(400, exception.getHttpStatusCode());
    }

    @Test
    public void testMessageGetterAndSetter() {
        OmiseException exception = new OmiseException();
        exception.setMessage("Invalid card");
        assertEquals("Invalid card", exception.getMessage());
    }

    @Test
    public void testToString() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(400);
        exception.setCode("invalid_card");
        exception.setMessage("Invalid card");
        
        String expected = "(400/invalid_card) Invalid card";
        assertEquals(expected, exception.toString());
    }

    @Test
    public void testExceptionWithAllFields() {
        OmiseException exception = new OmiseException();
        
        exception.setObject("error");
        exception.setLocation("https://www.omise.co/api-errors");
        exception.setCode("authentication_failure");
        exception.setHttpStatusCode(401);
        exception.setMessage("Authentication failed");
        
        assertEquals("error", exception.getObject());
        assertEquals("https://www.omise.co/api-errors", exception.getLocation());
        assertEquals("authentication_failure", exception.getCode());
        assertEquals(401, exception.getHttpStatusCode());
        assertEquals("Authentication failed", exception.getMessage());
    }

    @Test
    public void testExceptionWithNullValues() {
        OmiseException exception = new OmiseException();
        
        assertNull(exception.getObject());
        assertNull(exception.getLocation());
        assertNull(exception.getCode());
        assertEquals(0, exception.getHttpStatusCode());
        assertNull(exception.getMessage());
    }

    @Test
    public void testToStringWithNullValues() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(500);
        exception.setCode(null);
        exception.setMessage(null);
        
        String result = exception.toString();
        assertTrue(result.contains("500"));
        assertTrue(result.contains("null"));
    }

    @Test
    public void testToStringWith404Error() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(404);
        exception.setCode("not_found");
        exception.setMessage("Resource not found");
        
        assertEquals("(404/not_found) Resource not found", exception.toString());
    }

    @Test
    public void testToStringWith500Error() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(500);
        exception.setCode("internal_server_error");
        exception.setMessage("Internal server error");
        
        assertEquals("(500/internal_server_error) Internal server error", exception.toString());
    }

    @Test
    public void testToStringWith401Error() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(401);
        exception.setCode("authentication_failure");
        exception.setMessage("Authentication failed");
        
        assertEquals("(401/authentication_failure) Authentication failed", exception.toString());
    }

    @Test
    public void testToStringWith402Error() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(402);
        exception.setCode("payment_required");
        exception.setMessage("Payment required");
        
        assertEquals("(402/payment_required) Payment required", exception.toString());
    }

    @Test
    public void testToStringWith403Error() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(403);
        exception.setCode("forbidden");
        exception.setMessage("Access forbidden");
        
        assertEquals("(403/forbidden) Access forbidden", exception.toString());
    }

    @Test
    public void testVariousErrorCodes() {
        OmiseException exception = new OmiseException();
        
        String[] errorCodes = {
            "invalid_card",
            "invalid_charge",
            "insufficient_fund",
            "stolen_or_lost_card",
            "failed_fraud_check",
            "failed_processing",
            "invalid_security_code",
            "rate_limit_exceeded",
            "service_not_available"
        };
        
        for (String errorCode : errorCodes) {
            exception.setCode(errorCode);
            assertEquals(errorCode, exception.getCode());
        }
    }

    @Test
    public void testVariousHttpStatusCodes() {
        OmiseException exception = new OmiseException();
        
        int[] statusCodes = {200, 201, 400, 401, 402, 403, 404, 422, 429, 500, 502, 503, 504};
        
        for (int statusCode : statusCodes) {
            exception.setHttpStatusCode(statusCode);
            assertEquals(statusCode, exception.getHttpStatusCode());
        }
    }

    @Test
    public void testMessageWithSpecialCharacters() {
        OmiseException exception = new OmiseException();
        
        exception.setMessage("Error: card 'declined' - insufficient funds!");
        assertEquals("Error: card 'declined' - insufficient funds!", exception.getMessage());
        
        exception.setMessage("Error with unicode: กรุณาตรวจสอบข้อมูล");
        assertEquals("Error with unicode: กรุณาตรวจสอบข้อมูล", exception.getMessage());
    }

    @Test
    public void testLongErrorMessage() {
        OmiseException exception = new OmiseException();
        String longMessage = "This is a very long error message that contains multiple sentences. " +
                           "It describes the error in great detail and provides helpful information " +
                           "about what went wrong and how to fix it. The message can span multiple lines " +
                           "and contain various punctuation marks and special characters.";
        
        exception.setMessage(longMessage);
        assertEquals(longMessage, exception.getMessage());
    }

    @Test
    public void testEmptyStrings() {
        OmiseException exception = new OmiseException();
        
        exception.setObject("");
        exception.setLocation("");
        exception.setCode("");
        exception.setMessage("");
        
        assertEquals("", exception.getObject());
        assertEquals("", exception.getLocation());
        assertEquals("", exception.getCode());
        assertEquals("", exception.getMessage());
    }

    @Test
    public void testToStringWithEmptyStrings() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(400);
        exception.setCode("");
        exception.setMessage("");
        
        assertEquals("(400/) ", exception.toString());
    }

    @Test
    public void testToStringWithZeroStatusCode() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(0);
        exception.setCode("unknown");
        exception.setMessage("Unknown error");
        
        assertEquals("(0/unknown) Unknown error", exception.toString());
    }

    @Test
    public void testToStringWithNegativeStatusCode() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(-1);
        exception.setCode("error");
        exception.setMessage("Error occurred");
        
        assertEquals("(-1/error) Error occurred", exception.toString());
    }

    @Test
    public void testLocationWithVariousFormats() {
        OmiseException exception = new OmiseException();
        
        exception.setLocation("/api/charges");
        assertEquals("/api/charges", exception.getLocation());
        
        exception.setLocation("https://api.omise.co/charges/chrg_test_123");
        assertEquals("https://api.omise.co/charges/chrg_test_123", exception.getLocation());
        
        exception.setLocation("/errors/invalid_card");
        assertEquals("/errors/invalid_card", exception.getLocation());
    }

    @Test
    public void testObjectTypeValues() {
        OmiseException exception = new OmiseException();
        
        exception.setObject("error");
        assertEquals("error", exception.getObject());
        
        exception.setObject("exception");
        assertEquals("exception", exception.getObject());
    }

    @Test
    public void testIsInstanceOfException() {
        OmiseException exception = new OmiseException();
        assertTrue(exception instanceof Exception);
    }

    @Test
    public void testImplementsOmiseObject() {
        OmiseException exception = new OmiseException();
        assertTrue(exception instanceof OmiseObject);
    }

    @Test
    public void testSetValuesMultipleTimes() {
        OmiseException exception = new OmiseException();
        
        // Set initial values
        exception.setCode("error_1");
        exception.setMessage("First error");
        exception.setHttpStatusCode(400);
        
        assertEquals("error_1", exception.getCode());
        assertEquals("First error", exception.getMessage());
        assertEquals(400, exception.getHttpStatusCode());
        
        // Update values
        exception.setCode("error_2");
        exception.setMessage("Second error");
        exception.setHttpStatusCode(500);
        
        assertEquals("error_2", exception.getCode());
        assertEquals("Second error", exception.getMessage());
        assertEquals(500, exception.getHttpStatusCode());
    }

    @Test
    public void testToStringChangesWithUpdates() {
        OmiseException exception = new OmiseException();
        
        exception.setHttpStatusCode(400);
        exception.setCode("bad_request");
        exception.setMessage("Bad request");
        
        String firstToString = exception.toString();
        assertEquals("(400/bad_request) Bad request", firstToString);
        
        // Update values
        exception.setHttpStatusCode(401);
        exception.setCode("unauthorized");
        exception.setMessage("Unauthorized access");
        
        String secondToString = exception.toString();
        assertEquals("(401/unauthorized) Unauthorized access", secondToString);
        assertNotEquals(firstToString, secondToString);
    }

    @Test
    public void testCommonOmiseErrorScenarios() {
        // Invalid card scenario
        OmiseException invalidCard = new OmiseException();
        invalidCard.setHttpStatusCode(400);
        invalidCard.setCode("invalid_card");
        invalidCard.setMessage("The card number is invalid");
        invalidCard.setObject("error");
        
        assertEquals("(400/invalid_card) The card number is invalid", invalidCard.toString());
        
        // Insufficient funds scenario
        OmiseException insufficientFunds = new OmiseException();
        insufficientFunds.setHttpStatusCode(402);
        insufficientFunds.setCode("insufficient_fund");
        insufficientFunds.setMessage("The card has insufficient funds");
        insufficientFunds.setObject("error");
        
        assertEquals("(402/insufficient_fund) The card has insufficient funds", insufficientFunds.toString());
        
        // Authentication failure scenario
        OmiseException authFailure = new OmiseException();
        authFailure.setHttpStatusCode(401);
        authFailure.setCode("authentication_failure");
        authFailure.setMessage("Invalid API key");
        authFailure.setObject("error");
        
        assertEquals("(401/authentication_failure) Invalid API key", authFailure.toString());
    }

    @Test
    public void testResetToNull() {
        OmiseException exception = new OmiseException();
        
        // Set values
        exception.setObject("error");
        exception.setLocation("/api/test");
        exception.setCode("test_error");
        exception.setMessage("Test message");
        
        // Reset to null
        exception.setObject(null);
        exception.setLocation(null);
        exception.setCode(null);
        exception.setMessage(null);
        
        assertNull(exception.getObject());
        assertNull(exception.getLocation());
        assertNull(exception.getCode());
        assertNull(exception.getMessage());
    }

    @Test
    public void testHttpStatusCodeBoundaries() {
        OmiseException exception = new OmiseException();
        
        // Test minimum int value
        exception.setHttpStatusCode(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, exception.getHttpStatusCode());
        
        // Test maximum int value
        exception.setHttpStatusCode(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, exception.getHttpStatusCode());
        
        // Test typical HTTP ranges
        exception.setHttpStatusCode(100); // Informational
        assertEquals(100, exception.getHttpStatusCode());
        
        exception.setHttpStatusCode(200); // Success
        assertEquals(200, exception.getHttpStatusCode());
        
        exception.setHttpStatusCode(300); // Redirection
        assertEquals(300, exception.getHttpStatusCode());
        
        exception.setHttpStatusCode(400); // Client errors
        assertEquals(400, exception.getHttpStatusCode());
        
        exception.setHttpStatusCode(500); // Server errors
        assertEquals(500, exception.getHttpStatusCode());
    }

    @Test
    public void testToStringWithComplexFormatting() {
        OmiseException exception = new OmiseException();
        exception.setHttpStatusCode(422);
        exception.setCode("invalid_parameter");
        exception.setMessage("Parameter 'amount' must be greater than 0");
        
        String result = exception.toString();
        assertTrue(result.startsWith("(422/"));
        assertTrue(result.contains("invalid_parameter"));
        assertTrue(result.contains("Parameter 'amount' must be greater than 0"));
    }

    @Test
    public void testCodeWithUnderscores() {
        OmiseException exception = new OmiseException();
        
        String[] codesWithUnderscores = {
            "invalid_card",
            "failed_fraud_check",
            "rate_limit_exceeded",
            "service_not_available",
            "authentication_failure"
        };
        
        for (String code : codesWithUnderscores) {
            exception.setCode(code);
            assertEquals(code, exception.getCode());
            assertTrue(exception.getCode().contains("_"));
        }
    }

    @Test
    public void testAllFieldsIndependence() {
        OmiseException exception = new OmiseException();
        
        // Set one field at a time and verify others remain unchanged
        exception.setObject("error");
        assertEquals("error", exception.getObject());
        assertNull(exception.getLocation());
        assertNull(exception.getCode());
        assertEquals(0, exception.getHttpStatusCode());
        assertNull(exception.getMessage());
        
        exception.setLocation("/api");
        assertEquals("error", exception.getObject());
        assertEquals("/api", exception.getLocation());
        assertNull(exception.getCode());
        assertEquals(0, exception.getHttpStatusCode());
        assertNull(exception.getMessage());
        
        exception.setCode("test");
        assertEquals("error", exception.getObject());
        assertEquals("/api", exception.getLocation());
        assertEquals("test", exception.getCode());
        assertEquals(0, exception.getHttpStatusCode());
        assertNull(exception.getMessage());
        
        exception.setHttpStatusCode(400);
        assertEquals("error", exception.getObject());
        assertEquals("/api", exception.getLocation());
        assertEquals("test", exception.getCode());
        assertEquals(400, exception.getHttpStatusCode());
        assertNull(exception.getMessage());
        
        exception.setMessage("Test message");
        assertEquals("error", exception.getObject());
        assertEquals("/api", exception.getLocation());
        assertEquals("test", exception.getCode());
        assertEquals(400, exception.getHttpStatusCode());
        assertEquals("Test message", exception.getMessage());
    }
}
