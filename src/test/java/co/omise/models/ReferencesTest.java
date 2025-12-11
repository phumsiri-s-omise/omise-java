package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class ReferencesTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetBarcode() {
        References references = new References();
        String barcode = "123456789012";
        references.setBarcode(barcode);
        assertEquals(barcode, references.getBarcode());
    }

    @Test
    public void testGetSetCustomerAmount() {
        References references = new References();
        long customerAmount = 100000L;
        references.setCustomerAmount(customerAmount);
        assertEquals(customerAmount, references.getCustomerAmount());
    }

    @Test
    public void testGetSetCustomerCurrency() {
        References references = new References();
        String customerCurrency = "THB";
        references.setCustomerCurrency(customerCurrency);
        assertEquals(customerCurrency, references.getCustomerCurrency());
    }

    @Test
    public void testGetSetCustomerExchangeRate() {
        References references = new References();
        Double exchangeRate = 1.5;
        references.setCustomerExchangeRate(exchangeRate);
        assertEquals(exchangeRate, references.getCustomerExchangeRate());
    }

    @Test
    public void testGetSetDeviceId() {
        References references = new References();
        String deviceId = "device_123";
        references.setDeviceId(deviceId);
        assertEquals(deviceId, references.getDeviceId());
    }

    @Test
    public void testGetSetExpiresAt() {
        References references = new References();
        ZonedDateTime expiresAt = ZonedDateTime.now();
        references.setExpiresAt(expiresAt);
        assertEquals(expiresAt, references.getExpiresAt());
    }

    @Test
    public void testGetSetOmiseTaxId() {
        References references = new References();
        String omiseTaxId = "0105000000000";
        references.setOmiseTaxId(omiseTaxId);
        assertEquals(omiseTaxId, references.getOmiseTaxId());
    }

    @Test
    public void testGetSetPaymentCode() {
        References references = new References();
        String paymentCode = "PAY123456";
        references.setPaymentCode(paymentCode);
        assertEquals(paymentCode, references.getPaymentCode());
    }

    @Test
    public void testGetSetReferenceNumber1() {
        References references = new References();
        String refNumber1 = "REF001";
        references.setReferenceNumber1(refNumber1);
        assertEquals(refNumber1, references.getReferenceNumber1());
    }

    @Test
    public void testGetSetReferenceNumber2() {
        References references = new References();
        String refNumber2 = "REF002";
        references.setReferenceNumber2(refNumber2);
        assertEquals(refNumber2, references.getReferenceNumber2());
    }

    @Test
    public void testGetSetVaCode() {
        References references = new References();
        String vaCode = "VA123456";
        references.setVaCode(vaCode);
        assertEquals(vaCode, references.getVaCode());
    }

    // Edge case tests
    @Test
    public void testNullBarcode() {
        References references = new References();
        references.setBarcode(null);
        assertNull(references.getBarcode());
    }

    @Test
    public void testEmptyBarcode() {
        References references = new References();
        references.setBarcode("");
        assertEquals("", references.getBarcode());
    }

    @Test
    public void testZeroCustomerAmount() {
        References references = new References();
        references.setCustomerAmount(0L);
        assertEquals(0L, references.getCustomerAmount());
    }

    @Test
    public void testNegativeCustomerAmount() {
        References references = new References();
        references.setCustomerAmount(-1000L);
        assertEquals(-1000L, references.getCustomerAmount());
    }

    @Test
    public void testNullCustomerCurrency() {
        References references = new References();
        references.setCustomerCurrency(null);
        assertNull(references.getCustomerCurrency());
    }

    @Test
    public void testEmptyCustomerCurrency() {
        References references = new References();
        references.setCustomerCurrency("");
        assertEquals("", references.getCustomerCurrency());
    }

    @Test
    public void testNullCustomerExchangeRate() {
        References references = new References();
        references.setCustomerExchangeRate(null);
        assertNull(references.getCustomerExchangeRate());
    }

    @Test
    public void testZeroExchangeRate() {
        References references = new References();
        references.setCustomerExchangeRate(0.0);
        assertEquals(Double.valueOf(0.0), references.getCustomerExchangeRate());
    }

    @Test
    public void testNullDeviceId() {
        References references = new References();
        references.setDeviceId(null);
        assertNull(references.getDeviceId());
    }

    @Test
    public void testEmptyDeviceId() {
        References references = new References();
        references.setDeviceId("");
        assertEquals("", references.getDeviceId());
    }

    @Test
    public void testNullExpiresAt() {
        References references = new References();
        references.setExpiresAt(null);
        assertNull(references.getExpiresAt());
    }

    @Test
    public void testNullOmiseTaxId() {
        References references = new References();
        references.setOmiseTaxId(null);
        assertNull(references.getOmiseTaxId());
    }

    @Test
    public void testEmptyOmiseTaxId() {
        References references = new References();
        references.setOmiseTaxId("");
        assertEquals("", references.getOmiseTaxId());
    }

    @Test
    public void testNullPaymentCode() {
        References references = new References();
        references.setPaymentCode(null);
        assertNull(references.getPaymentCode());
    }

    @Test
    public void testEmptyPaymentCode() {
        References references = new References();
        references.setPaymentCode("");
        assertEquals("", references.getPaymentCode());
    }

    @Test
    public void testNullReferenceNumber1() {
        References references = new References();
        references.setReferenceNumber1(null);
        assertNull(references.getReferenceNumber1());
    }

    @Test
    public void testEmptyReferenceNumber1() {
        References references = new References();
        references.setReferenceNumber1("");
        assertEquals("", references.getReferenceNumber1());
    }

    @Test
    public void testNullReferenceNumber2() {
        References references = new References();
        references.setReferenceNumber2(null);
        assertNull(references.getReferenceNumber2());
    }

    @Test
    public void testEmptyReferenceNumber2() {
        References references = new References();
        references.setReferenceNumber2("");
        assertEquals("", references.getReferenceNumber2());
    }

    @Test
    public void testNullVaCode() {
        References references = new References();
        references.setVaCode(null);
        assertNull(references.getVaCode());
    }

    @Test
    public void testEmptyVaCode() {
        References references = new References();
        references.setVaCode("");
        assertEquals("", references.getVaCode());
    }

    // Large customer amount test
    @Test
    public void testLargeCustomerAmount() {
        References references = new References();
        long largeAmount = Long.MAX_VALUE;
        references.setCustomerAmount(largeAmount);
        assertEquals(largeAmount, references.getCustomerAmount());
    }

    // Various exchange rate tests
    @Test
    public void testHighExchangeRate() {
        References references = new References();
        references.setCustomerExchangeRate(100.0);
        assertEquals(Double.valueOf(100.0), references.getCustomerExchangeRate());
    }

    @Test
    public void testLowExchangeRate() {
        References references = new References();
        references.setCustomerExchangeRate(0.01);
        assertEquals(Double.valueOf(0.01), references.getCustomerExchangeRate());
    }

    @Test
    public void testPreciseExchangeRate() {
        References references = new References();
        references.setCustomerExchangeRate(1.23456789);
        assertEquals(Double.valueOf(1.23456789), references.getCustomerExchangeRate());
    }

    // Long barcode test
    @Test
    public void testLongBarcode() {
        References references = new References();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(i % 10);
        }
        String longBarcode = sb.toString();
        references.setBarcode(longBarcode);
        assertEquals(longBarcode, references.getBarcode());
    }

    // Combined reference numbers test
    @Test
    public void testBothReferenceNumbers() {
        References references = new References();
        references.setReferenceNumber1("REF-001");
        references.setReferenceNumber2("REF-002");
        
        assertEquals("REF-001", references.getReferenceNumber1());
        assertEquals("REF-002", references.getReferenceNumber2());
    }
}
