package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RefundTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetAmount() {
        Refund refund = new Refund();
        long amount = 50000L;
        refund.setAmount(amount);
        assertEquals(amount, refund.getAmount());
    }

    @Test
    public void testGetSetCharge() {
        Refund refund = new Refund();
        String charge = "chrg_test_123";
        refund.setCharge(charge);
        assertEquals(charge, refund.getCharge());
    }

    @Test
    public void testGetSetCurrency() {
        Refund refund = new Refund();
        String currency = "THB";
        refund.setCurrency(currency);
        assertEquals(currency, refund.getCurrency());
    }

    @Test
    public void testGetSetFundingAmount() {
        Refund refund = new Refund();
        long fundingAmount = 50000L;
        refund.setFundingAmount(fundingAmount);
        assertEquals(fundingAmount, refund.getFundingAmount());
    }

    @Test
    public void testGetSetFundingCurrency() {
        Refund refund = new Refund();
        String fundingCurrency = "USD";
        refund.setFundingCurrency(fundingCurrency);
        assertEquals(fundingCurrency, refund.getFundingCurrency());
    }

    @Test
    public void testGetSetLocation() {
        Refund refund = new Refund();
        String location = "https://api.omise.co/charges/chrg_test/refunds/rfnd_test";
        refund.setLocation(location);
        assertEquals(location, refund.getLocation());
    }

    @Test
    public void testGetSetMetadata() {
        Refund refund = new Refund();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("reason", "customer_request");
        metadata.put("ticket_id", 12345);
        refund.setMetadata(metadata);
        assertEquals(metadata, refund.getMetadata());
    }

    @Test
    public void testGetSetStatus() {
        Refund refund = new Refund();
        RefundStatus status = RefundStatus.Closed;
        refund.setStatus(status);
        assertEquals(status, refund.getStatus());
    }

    @Test
    public void testGetSetTerminal() {
        Refund refund = new Refund();
        String terminal = "term_test_123";
        refund.setTerminal(terminal);
        assertEquals(terminal, refund.getTerminal());
    }

    @Test
    public void testGetSetTransaction() {
        Refund refund = new Refund();
        String transaction = "trxn_test_123";
        refund.setTransaction(transaction);
        assertEquals(transaction, refund.getTransaction());
    }

    @Test
    public void testGetSetVoided() {
        Refund refund = new Refund();
        refund.setVoided(true);
        assertTrue(refund.isVoided());
        
        refund.setVoided(false);
        assertFalse(refund.isVoided());
    }

    // Edge case tests
    @Test
    public void testZeroAmount() {
        Refund refund = new Refund();
        refund.setAmount(0L);
        assertEquals(0L, refund.getAmount());
    }

    @Test
    public void testNullCharge() {
        Refund refund = new Refund();
        refund.setCharge(null);
        assertNull(refund.getCharge());
    }

    @Test
    public void testNullCurrency() {
        Refund refund = new Refund();
        refund.setCurrency(null);
        assertNull(refund.getCurrency());
    }

    @Test
    public void testZeroFundingAmount() {
        Refund refund = new Refund();
        refund.setFundingAmount(0L);
        assertEquals(0L, refund.getFundingAmount());
    }

    @Test
    public void testNullFundingCurrency() {
        Refund refund = new Refund();
        refund.setFundingCurrency(null);
        assertNull(refund.getFundingCurrency());
    }

    @Test
    public void testNullLocation() {
        Refund refund = new Refund();
        refund.setLocation(null);
        assertNull(refund.getLocation());
    }

    @Test
    public void testNullMetadata() {
        Refund refund = new Refund();
        refund.setMetadata(null);
        assertNull(refund.getMetadata());
    }

    @Test
    public void testEmptyMetadata() {
        Refund refund = new Refund();
        Map<String, Object> emptyMap = new HashMap<>();
        refund.setMetadata(emptyMap);
        assertEquals(emptyMap, refund.getMetadata());
    }

    @Test
    public void testNullStatus() {
        Refund refund = new Refund();
        refund.setStatus(null);
        assertNull(refund.getStatus());
    }

    @Test
    public void testNullTerminal() {
        Refund refund = new Refund();
        refund.setTerminal(null);
        assertNull(refund.getTerminal());
    }

    @Test
    public void testNullTransaction() {
        Refund refund = new Refund();
        refund.setTransaction(null);
        assertNull(refund.getTransaction());
    }

    // ListRefundsRequestBuilder tests
    @Test
    public void testListRefundsRequestBuilder() throws Exception {
        Refund.ListRefundsRequestBuilder builder = new Refund.ListRefundsRequestBuilder();
        
        assertTrue(builder.path().toString().contains("refunds"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRefundsRequestBuilderWithOptions() throws Exception {
        Refund.ListRefundsRequestBuilder builder = new Refund.ListRefundsRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // ListRequestBuilder tests
    @Test
    public void testListRequestBuilder() throws Exception {
        Refund.ListRequestBuilder builder = new Refund.ListRequestBuilder("chrg_test_123");
        
        assertTrue(builder.path().toString().contains("charges/chrg_test_123/refunds"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithOptions() throws Exception {
        Refund.ListRequestBuilder builder = new Refund.ListRequestBuilder("chrg_test_123");
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // CreateRequestBuilder tests
    @Test
    public void testCreateRequestBuilderAmount() throws Exception {
        Refund.CreateRequestBuilder builder = new Refund.CreateRequestBuilder("chrg_test_123");
        
        builder.amount(25000L);
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("charges/chrg_test_123/refunds"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderMetadata() throws Exception {
        Refund.CreateRequestBuilder builder = new Refund.CreateRequestBuilder("chrg_test_123");
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("refund_reason", "duplicate");
        
        builder.metadata(metadata);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderMetadataKeyValue() throws Exception {
        Refund.CreateRequestBuilder builder = new Refund.CreateRequestBuilder("chrg_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", 999);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderIsVoid() throws Exception {
        Refund.CreateRequestBuilder builder = new Refund.CreateRequestBuilder("chrg_test_123");
        
        builder.isVoid(true);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderChaining() throws Exception {
        Refund.CreateRequestBuilder builder = new Refund.CreateRequestBuilder("chrg_test_123");
        
        builder
            .amount(10000L)
            .isVoid(false)
            .metadata("reason", "customer_request")
            .metadata("agent", "support");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderWithNullMetadataKeyValue() throws Exception {
        Refund.CreateRequestBuilder builder = new Refund.CreateRequestBuilder("chrg_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", null);
        
        assertNotNull(builder.payload());
    }

    // GetRequestBuilder tests
    @Test
    public void testGetRequestBuilder() throws Exception {
        Refund.GetRequestBuilder builder = new Refund.GetRequestBuilder("chrg_test_123", "rfnd_test_456");
        
        assertTrue(builder.path().toString().contains("charges/chrg_test_123/refunds/rfnd_test_456"));
        assertNotNull(builder.type());
    }

    // RefundStatus enum tests
    @Test
    public void testRefundStatusClosed() {
        RefundStatus status = RefundStatus.Closed;
        assertNotNull(status);
        assertEquals("Closed", status.name());
    }

    // Large amount test
    @Test
    public void testLargeAmount() {
        Refund refund = new Refund();
        long largeAmount = Long.MAX_VALUE;
        refund.setAmount(largeAmount);
        assertEquals(largeAmount, refund.getAmount());
    }

    @Test
    public void testLargeFundingAmount() {
        Refund refund = new Refund();
        long largeFundingAmount = Long.MAX_VALUE;
        refund.setFundingAmount(largeFundingAmount);
        assertEquals(largeFundingAmount, refund.getFundingAmount());
    }
}
