package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DisputeTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetAdminMessage() {
        Dispute dispute = new Dispute();
        String adminMessage = "Admin message";
        dispute.setAdminMessage(adminMessage);
        assertEquals(adminMessage, dispute.getAdminMessage());
    }

    @Test
    public void testGetSetAmount() {
        Dispute dispute = new Dispute();
        long amount = 50000L;
        dispute.setAmount(amount);
        assertEquals(amount, dispute.getAmount());
    }

    @Test
    public void testGetSetCharge() {
        Dispute dispute = new Dispute();
        String charge = "chrg_test_123";
        dispute.setCharge(charge);
        assertEquals(charge, dispute.getCharge());
    }

    @Test
    public void testGetSetClosedAt() {
        Dispute dispute = new Dispute();
        ZonedDateTime now = ZonedDateTime.now();
        dispute.setClosedAt(now);
        assertEquals(now, dispute.getClosedAt());
    }

    @Test
    public void testGetSetCurrency() {
        Dispute dispute = new Dispute();
        String currency = "THB";
        dispute.setCurrency(currency);
        assertEquals(currency, dispute.getCurrency());
    }

    @Test
    public void testGetSetDocuments() {
        Dispute dispute = new Dispute();
        ScopedList<Document> documents = new ScopedList<>();
        dispute.setDocuments(documents);
        assertEquals(documents, dispute.getDocuments());
    }

    @Test
    public void testGetSetFundingAmount() {
        Dispute dispute = new Dispute();
        long fundingAmount = 50000L;
        dispute.setFundingAmount(fundingAmount);
        assertEquals(fundingAmount, dispute.getFundingAmount());
    }

    @Test
    public void testGetSetFundingCurrency() {
        Dispute dispute = new Dispute();
        String fundingCurrency = "USD";
        dispute.setFundingCurrency(fundingCurrency);
        assertEquals(fundingCurrency, dispute.getFundingCurrency());
    }

    @Test
    public void testGetSetLocation() {
        Dispute dispute = new Dispute();
        String location = "https://api.omise.co/disputes/dspt_test";
        dispute.setLocation(location);
        assertEquals(location, dispute.getLocation());
    }

    @Test
    public void testGetSetMessage() {
        Dispute dispute = new Dispute();
        String message = "Customer dispute message";
        dispute.setMessage(message);
        assertEquals(message, dispute.getMessage());
    }

    @Test
    public void testGetSetMetadata() {
        Dispute dispute = new Dispute();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("case_id", "case123");
        metadata.put("priority", 1);
        dispute.setMetadata(metadata);
        assertEquals(metadata, dispute.getMetadata());
    }

    @Test
    public void testGetSetReasonCode() {
        Dispute dispute = new Dispute();
        DisputeReasonCode reasonCode = DisputeReasonCode.UnauthorizedCharge;
        dispute.setReasonCode(reasonCode);
        assertEquals(reasonCode, dispute.getReasonCode());
    }

    @Test
    public void testGetSetReasonMessage() {
        Dispute dispute = new Dispute();
        String reasonMessage = "Fraudulent transaction detected";
        dispute.setReasonMessage(reasonMessage);
        assertEquals(reasonMessage, dispute.getReasonMessage());
    }

    @Test
    public void testGetSetStatus() {
        Dispute dispute = new Dispute();
        DisputeStatus status = DisputeStatus.Open;
        dispute.setStatus(status);
        assertEquals(status, dispute.getStatus());
    }

    @Test
    public void testGetSetTransactions() {
        Dispute dispute = new Dispute();
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction());
        dispute.setTransactions(transactions);
        assertEquals(transactions, dispute.getTransactions());
    }

    // Edge case tests
    @Test
    public void testNullAdminMessage() {
        Dispute dispute = new Dispute();
        dispute.setAdminMessage(null);
        assertNull(dispute.getAdminMessage());
    }

    @Test
    public void testEmptyAdminMessage() {
        Dispute dispute = new Dispute();
        dispute.setAdminMessage("");
        assertEquals("", dispute.getAdminMessage());
    }

    @Test
    public void testZeroAmount() {
        Dispute dispute = new Dispute();
        dispute.setAmount(0L);
        assertEquals(0L, dispute.getAmount());
    }

    @Test
    public void testNegativeAmount() {
        Dispute dispute = new Dispute();
        dispute.setAmount(-1000L);
        assertEquals(-1000L, dispute.getAmount());
    }

    @Test
    public void testNullCharge() {
        Dispute dispute = new Dispute();
        dispute.setCharge(null);
        assertNull(dispute.getCharge());
    }

    @Test
    public void testNullClosedAt() {
        Dispute dispute = new Dispute();
        dispute.setClosedAt(null);
        assertNull(dispute.getClosedAt());
    }

    @Test
    public void testNullCurrency() {
        Dispute dispute = new Dispute();
        dispute.setCurrency(null);
        assertNull(dispute.getCurrency());
    }

    @Test
    public void testEmptyCurrency() {
        Dispute dispute = new Dispute();
        dispute.setCurrency("");
        assertEquals("", dispute.getCurrency());
    }

    @Test
    public void testNullDocuments() {
        Dispute dispute = new Dispute();
        dispute.setDocuments(null);
        assertNull(dispute.getDocuments());
    }

    @Test
    public void testZeroFundingAmount() {
        Dispute dispute = new Dispute();
        dispute.setFundingAmount(0L);
        assertEquals(0L, dispute.getFundingAmount());
    }

    @Test
    public void testNullFundingCurrency() {
        Dispute dispute = new Dispute();
        dispute.setFundingCurrency(null);
        assertNull(dispute.getFundingCurrency());
    }

    @Test
    public void testNullLocation() {
        Dispute dispute = new Dispute();
        dispute.setLocation(null);
        assertNull(dispute.getLocation());
    }

    @Test
    public void testNullMessage() {
        Dispute dispute = new Dispute();
        dispute.setMessage(null);
        assertNull(dispute.getMessage());
    }

    @Test
    public void testEmptyMessage() {
        Dispute dispute = new Dispute();
        dispute.setMessage("");
        assertEquals("", dispute.getMessage());
    }

    @Test
    public void testNullMetadata() {
        Dispute dispute = new Dispute();
        dispute.setMetadata(null);
        assertNull(dispute.getMetadata());
    }

    @Test
    public void testEmptyMetadata() {
        Dispute dispute = new Dispute();
        Map<String, Object> emptyMap = new HashMap<>();
        dispute.setMetadata(emptyMap);
        assertEquals(emptyMap, dispute.getMetadata());
    }

    @Test
    public void testNullReasonCode() {
        Dispute dispute = new Dispute();
        dispute.setReasonCode(null);
        assertNull(dispute.getReasonCode());
    }

    @Test
    public void testNullReasonMessage() {
        Dispute dispute = new Dispute();
        dispute.setReasonMessage(null);
        assertNull(dispute.getReasonMessage());
    }

    @Test
    public void testNullStatus() {
        Dispute dispute = new Dispute();
        dispute.setStatus(null);
        assertNull(dispute.getStatus());
    }

    @Test
    public void testNullTransactions() {
        Dispute dispute = new Dispute();
        dispute.setTransactions(null);
        assertNull(dispute.getTransactions());
    }

    @Test
    public void testEmptyTransactions() {
        Dispute dispute = new Dispute();
        List<Transaction> emptyList = new ArrayList<>();
        dispute.setTransactions(emptyList);
        assertEquals(emptyList, dispute.getTransactions());
    }

    // ClosedRequestBuilder tests
    @Test
    public void testClosedRequestBuilder() throws Exception {
        Dispute.ClosedRequestBuilder builder = new Dispute.ClosedRequestBuilder();
        
        assertTrue(builder.path().toString().contains("disputes/closed"));
        assertNotNull(builder.type());
    }

    // ListRequestBuilder tests
    @Test
    public void testListRequestBuilder() throws Exception {
        Dispute.ListRequestBuilder builder = new Dispute.ListRequestBuilder();
        
        assertTrue(builder.path().toString().contains("disputes"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithOptions() throws Exception {
        Dispute.ListRequestBuilder builder = new Dispute.ListRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithStatusOpen() throws Exception {
        Dispute.ListRequestBuilder builder = new Dispute.ListRequestBuilder();
        
        builder.status(DisputeStatus.Open);
        
        assertTrue(builder.path().toString().contains("open"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithStatusPending() throws Exception {
        Dispute.ListRequestBuilder builder = new Dispute.ListRequestBuilder();
        
        builder.status(DisputeStatus.Pending);
        
        assertTrue(builder.path().toString().contains("pending"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithStatusClosed() throws Exception {
        Dispute.ListRequestBuilder builder = new Dispute.ListRequestBuilder();
        
        builder.status(DisputeStatus.Closed);
        
        assertTrue(builder.path().toString().contains("closed"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderChaining() throws Exception {
        Dispute.ListRequestBuilder builder = new Dispute.ListRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        builder.status(DisputeStatus.Open).options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // OpenRequestBuilder tests
    @Test
    public void testOpenRequestBuilder() throws Exception {
        Dispute.OpenRequestBuilder builder = new Dispute.OpenRequestBuilder();
        
        assertTrue(builder.path().toString().contains("disputes/open"));
        assertNotNull(builder.type());
    }

    // PendingRequestBuilder tests
    @Test
    public void testPendingRequestBuilder() throws Exception {
        Dispute.PendingRequestBuilder builder = new Dispute.PendingRequestBuilder();
        
        assertTrue(builder.path().toString().contains("disputes/pending"));
        assertNotNull(builder.type());
    }

    // GetRequestBuilder tests
    @Test
    public void testGetRequestBuilder() throws Exception {
        Dispute.GetRequestBuilder builder = new Dispute.GetRequestBuilder("dspt_test_123");
        
        assertTrue(builder.path().toString().contains("disputes/dspt_test_123"));
        assertNotNull(builder.type());
    }

    // UpdateRequestBuilder tests
    @Test
    public void testUpdateRequestBuilderMessage() throws Exception {
        Dispute.UpdateRequestBuilder builder = new Dispute.UpdateRequestBuilder("dspt_test_123");
        
        builder.message("Updated dispute message");
        
        assertEquals("PATCH", builder.method());
        assertTrue(builder.path().toString().contains("disputes/dspt_test_123"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderMetadata() throws Exception {
        Dispute.UpdateRequestBuilder builder = new Dispute.UpdateRequestBuilder("dspt_test_123");
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("updated", true);
        
        builder.metadata(metadata);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderMetadataKeyValue() throws Exception {
        Dispute.UpdateRequestBuilder builder = new Dispute.UpdateRequestBuilder("dspt_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", 456);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderChaining() throws Exception {
        Dispute.UpdateRequestBuilder builder = new Dispute.UpdateRequestBuilder("dspt_test_123");
        
        builder
            .message("Chained message")
            .metadata("reason", "customer_request")
            .metadata("priority", 2);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderWithNullMetadataKeyValue() throws Exception {
        Dispute.UpdateRequestBuilder builder = new Dispute.UpdateRequestBuilder("dspt_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", null);
        
        assertNotNull(builder.payload());
    }

    // CloseRequestBuilder tests
    @Test
    public void testCloseRequestBuilder() throws Exception {
        Dispute.CloseRequestBuilder builder = new Dispute.CloseRequestBuilder("dspt_test_123");
        
        assertEquals("PATCH", builder.method());
        assertTrue(builder.path().toString().contains("disputes/dspt_test_123/close"));
        assertNotNull(builder.type());
    }

    @Test
    public void testCloseRequestBuilderWithStatus() throws Exception {
        Dispute.CloseRequestBuilder builder = new Dispute.CloseRequestBuilder("dspt_test_123");
        
        builder.status(DisputeStatus.Won);
        
        assertNotNull(builder.payload());
    }

    // AcceptRequestBuilder tests
    @Test
    public void testAcceptRequestBuilder() throws Exception {
        Dispute.AcceptRequestBuilder builder = new Dispute.AcceptRequestBuilder("dspt_test_123");
        
        assertEquals("PATCH", builder.method());
        assertTrue(builder.path().toString().contains("disputes/dspt_test_123/accept"));
        assertNotNull(builder.type());
    }

    // CreateDisputeRequestBuilder tests
    @Test
    public void testCreateDisputeRequestBuilder() throws Exception {
        Dispute.CreateDisputeRequestBuilder builder = new Dispute.CreateDisputeRequestBuilder("chrg_test_123");
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("charges/chrg_test_123/disputes"));
        assertNotNull(builder.type());
    }

    // DisputeStatus enum tests
    @Test
    public void testDisputeStatusOpen() {
        DisputeStatus status = DisputeStatus.Open;
        assertNotNull(status);
        assertEquals("Open", status.name());
    }

    @Test
    public void testDisputeStatusPending() {
        DisputeStatus status = DisputeStatus.Pending;
        assertNotNull(status);
        assertEquals("Pending", status.name());
    }

    @Test
    public void testDisputeStatusClosed() {
        DisputeStatus status = DisputeStatus.Closed;
        assertNotNull(status);
        assertEquals("Closed", status.name());
    }

    @Test
    public void testDisputeStatusWon() {
        DisputeStatus status = DisputeStatus.Won;
        assertNotNull(status);
        assertEquals("Won", status.name());
    }

    @Test
    public void testDisputeStatusLost() {
        DisputeStatus status = DisputeStatus.Lost;
        assertNotNull(status);
        assertEquals("Lost", status.name());
    }

    // DisputeReasonCode enum tests
    @Test
    public void testReasonCodeUnauthorizedCharge() {
        DisputeReasonCode code = DisputeReasonCode.UnauthorizedCharge;
        assertNotNull(code);
    }

    @Test
    public void testReasonCodeNotAsDescribedOrDefectiveMerchandise() {
        DisputeReasonCode code = DisputeReasonCode.NotAsDescribedOrDefectiveMerchandise;
        assertNotNull(code);
    }

    @Test
    public void testReasonCodeGoodsOrServicesNotProvided() {
        DisputeReasonCode code = DisputeReasonCode.GoodsOrServicesNotProvided;
        assertNotNull(code);
    }

    @Test
    public void testReasonCodeCreditNotProcessed() {
        DisputeReasonCode code = DisputeReasonCode.CreditNotProcessed;
        assertNotNull(code);
    }

    @Test
    public void testReasonCodeDuplicateProcessing() {
        DisputeReasonCode code = DisputeReasonCode.DuplicateProcessing;
        assertNotNull(code);
    }

    @Test
    public void testReasonCodeOther() {
        DisputeReasonCode code = DisputeReasonCode.Other;
        assertNotNull(code);
    }

    @Test
    public void testReasonCodeTransactionNotRecognised() {
        DisputeReasonCode code = DisputeReasonCode.TransactionNotRecognised;
        assertNotNull(code);
    }

    @Test
    public void testReasonCodeCancelledRecurringTransaction() {
        DisputeReasonCode code = DisputeReasonCode.CancelledRecurringTransaction;
        assertNotNull(code);
    }

    // Large amount tests
    @Test
    public void testLargeAmount() {
        Dispute dispute = new Dispute();
        long largeAmount = Long.MAX_VALUE;
        dispute.setAmount(largeAmount);
        assertEquals(largeAmount, dispute.getAmount());
    }

    @Test
    public void testLargeFundingAmount() {
        Dispute dispute = new Dispute();
        long largeFundingAmount = Long.MAX_VALUE;
        dispute.setFundingAmount(largeFundingAmount);
        assertEquals(largeFundingAmount, dispute.getFundingAmount());
    }
}
