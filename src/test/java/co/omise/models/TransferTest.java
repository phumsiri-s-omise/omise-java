package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TransferTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetAmount() {
        Transfer transfer = new Transfer();
        long amount = 100000L;
        transfer.setAmount(amount);
        assertEquals(amount, transfer.getAmount());
    }

    @Test
    public void testGetSetBankAccount() {
        Transfer transfer = new Transfer();
        BankAccount bankAccount = new BankAccount();
        transfer.setBankAccount(bankAccount);
        assertEquals(bankAccount, transfer.getBankAccount());
    }

    @Test
    public void testGetSetCurrency() {
        Transfer transfer = new Transfer();
        String currency = "THB";
        transfer.setCurrency(currency);
        assertEquals(currency, transfer.getCurrency());
    }

    @Test
    public void testGetSetFailFast() {
        Transfer transfer = new Transfer();
        transfer.setFailFast(true);
        assertTrue(transfer.isFailFast());
        
        transfer.setFailFast(false);
        assertFalse(transfer.isFailFast());
    }

    @Test
    public void testGetSetFailureCode() {
        Transfer transfer = new Transfer();
        String failureCode = "insufficient_balance";
        transfer.setFailureCode(failureCode);
        assertEquals(failureCode, transfer.getFailureCode());
    }

    @Test
    public void testGetSetFailureMessage() {
        Transfer transfer = new Transfer();
        String message = "Insufficient balance";
        transfer.setFailureMessage(message);
        assertEquals(message, transfer.getFailureMessage());
    }

    @Test
    public void testGetSetFee() {
        Transfer transfer = new Transfer();
        long fee = 2500L;
        transfer.setFee(fee);
        assertEquals(fee, transfer.getFee());
    }

    @Test
    public void testGetSetFeeVat() {
        Transfer transfer = new Transfer();
        long feeVat = 175L;
        transfer.setFeeVat(feeVat);
        assertEquals(feeVat, transfer.getFeeVat());
    }

    @Test
    public void testGetSetLocation() {
        Transfer transfer = new Transfer();
        String location = "https://api.omise.co/transfers/trsf_test";
        transfer.setLocation(location);
        assertEquals(location, transfer.getLocation());
    }

    @Test
    public void testGetSetMetadata() {
        Transfer transfer = new Transfer();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id", "order123");
        metadata.put("customer_id", 456);
        transfer.setMetadata(metadata);
        assertEquals(metadata, transfer.getMetadata());
    }

    @Test
    public void testGetSetNet() {
        Transfer transfer = new Transfer();
        long net = 97500L;
        transfer.setNet(net);
        assertEquals(net, transfer.getNet());
    }

    @Test
    public void testGetSetPaid() {
        Transfer transfer = new Transfer();
        transfer.setPaid(true);
        assertTrue(transfer.isPaid());
        
        transfer.setPaid(false);
        assertFalse(transfer.isPaid());
    }

    @Test
    public void testGetSetPaidAt() {
        Transfer transfer = new Transfer();
        ZonedDateTime now = ZonedDateTime.now();
        transfer.setPaidAt(now);
        assertEquals(now, transfer.getPaidAt());
    }

    @Test
    public void testGetSetRecipient() {
        Transfer transfer = new Transfer();
        String recipient = "recp_test_123";
        transfer.setRecipient(recipient);
        assertEquals(recipient, transfer.getRecipient());
    }

    @Test
    public void testGetSetSchedule() {
        Transfer transfer = new Transfer();
        String schedule = "schd_test_123";
        transfer.setSchedule(schedule);
        assertEquals(schedule, transfer.getSchedule());
    }

    @Test
    public void testGetSetSendable() {
        Transfer transfer = new Transfer();
        transfer.setSendable(true);
        assertTrue(transfer.isSendable());
        
        transfer.setSendable(false);
        assertFalse(transfer.isSendable());
    }

    @Test
    public void testGetSetSent() {
        Transfer transfer = new Transfer();
        transfer.setSent(true);
        assertTrue(transfer.isSent());
        
        transfer.setSent(false);
        assertFalse(transfer.isSent());
    }

    @Test
    public void testGetSetSentAt() {
        Transfer transfer = new Transfer();
        ZonedDateTime now = ZonedDateTime.now();
        transfer.setSentAt(now);
        assertEquals(now, transfer.getSentAt());
    }

    @Test
    public void testGetSetTotalFee() {
        Transfer transfer = new Transfer();
        long totalFee = 2675L;
        transfer.setTotalFee(totalFee);
        assertEquals(totalFee, transfer.getTotalFee());
    }

    @Test
    public void testGetSetTransactions() {
        Transfer transfer = new Transfer();
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction());
        transfer.setTransactions(transactions);
        assertEquals(transactions, transfer.getTransactions());
    }

    // Edge case tests
    @Test
    public void testZeroAmount() {
        Transfer transfer = new Transfer();
        transfer.setAmount(0L);
        assertEquals(0L, transfer.getAmount());
    }

    @Test
    public void testNegativeAmount() {
        Transfer transfer = new Transfer();
        transfer.setAmount(-1000L);
        assertEquals(-1000L, transfer.getAmount());
    }

    @Test
    public void testNullBankAccount() {
        Transfer transfer = new Transfer();
        transfer.setBankAccount(null);
        assertNull(transfer.getBankAccount());
    }

    @Test
    public void testNullCurrency() {
        Transfer transfer = new Transfer();
        transfer.setCurrency(null);
        assertNull(transfer.getCurrency());
    }

    @Test
    public void testEmptyCurrency() {
        Transfer transfer = new Transfer();
        transfer.setCurrency("");
        assertEquals("", transfer.getCurrency());
    }

    @Test
    public void testNullFailureCode() {
        Transfer transfer = new Transfer();
        transfer.setFailureCode(null);
        assertNull(transfer.getFailureCode());
    }

    @Test
    public void testNullFailureMessage() {
        Transfer transfer = new Transfer();
        transfer.setFailureMessage(null);
        assertNull(transfer.getFailureMessage());
    }

    @Test
    public void testZeroFee() {
        Transfer transfer = new Transfer();
        transfer.setFee(0L);
        assertEquals(0L, transfer.getFee());
    }

    @Test
    public void testZeroFeeVat() {
        Transfer transfer = new Transfer();
        transfer.setFeeVat(0L);
        assertEquals(0L, transfer.getFeeVat());
    }

    @Test
    public void testNullLocation() {
        Transfer transfer = new Transfer();
        transfer.setLocation(null);
        assertNull(transfer.getLocation());
    }

    @Test
    public void testNullMetadata() {
        Transfer transfer = new Transfer();
        transfer.setMetadata(null);
        assertNull(transfer.getMetadata());
    }

    @Test
    public void testEmptyMetadata() {
        Transfer transfer = new Transfer();
        Map<String, Object> emptyMap = new HashMap<>();
        transfer.setMetadata(emptyMap);
        assertEquals(emptyMap, transfer.getMetadata());
    }

    @Test
    public void testZeroNet() {
        Transfer transfer = new Transfer();
        transfer.setNet(0L);
        assertEquals(0L, transfer.getNet());
    }

    @Test
    public void testNullPaidAt() {
        Transfer transfer = new Transfer();
        transfer.setPaidAt(null);
        assertNull(transfer.getPaidAt());
    }

    @Test
    public void testNullRecipient() {
        Transfer transfer = new Transfer();
        transfer.setRecipient(null);
        assertNull(transfer.getRecipient());
    }

    @Test
    public void testNullSchedule() {
        Transfer transfer = new Transfer();
        transfer.setSchedule(null);
        assertNull(transfer.getSchedule());
    }

    @Test
    public void testNullSentAt() {
        Transfer transfer = new Transfer();
        transfer.setSentAt(null);
        assertNull(transfer.getSentAt());
    }

    @Test
    public void testZeroTotalFee() {
        Transfer transfer = new Transfer();
        transfer.setTotalFee(0L);
        assertEquals(0L, transfer.getTotalFee());
    }

    @Test
    public void testNullTransactions() {
        Transfer transfer = new Transfer();
        transfer.setTransactions(null);
        assertNull(transfer.getTransactions());
    }

    @Test
    public void testEmptyTransactions() {
        Transfer transfer = new Transfer();
        List<Transaction> emptyList = new ArrayList<>();
        transfer.setTransactions(emptyList);
        assertEquals(emptyList, transfer.getTransactions());
    }

    // DeleteRequestBuilder tests
    @Test
    public void testDeleteRequestBuilder() throws Exception {
        Transfer.DeleteRequestBuilder builder = new Transfer.DeleteRequestBuilder("trsf_test_123");
        
        assertEquals("DELETE", builder.method());
        assertTrue(builder.path().toString().contains("transfers/trsf_test_123"));
        assertNotNull(builder.type());
    }

    // GetRequestBuilder tests
    @Test
    public void testGetRequestBuilder() throws Exception {
        Transfer.GetRequestBuilder builder = new Transfer.GetRequestBuilder("trsf_test_123");
        
        assertTrue(builder.path().toString().contains("transfers/trsf_test_123"));
        assertNotNull(builder.type());
    }

    // UpdateRequestBuilder tests
    @Test
    public void testUpdateRequestBuilderAmount() throws Exception {
        Transfer.UpdateRequestBuilder builder = new Transfer.UpdateRequestBuilder("trsf_test_123");
        
        builder.amount(50000L);
        
        assertEquals("PATCH", builder.method());
        assertTrue(builder.path().toString().contains("transfers/trsf_test_123"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderMetadata() throws Exception {
        Transfer.UpdateRequestBuilder builder = new Transfer.UpdateRequestBuilder("trsf_test_123");
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("updated", true);
        
        builder.metadata(metadata);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderMetadataKeyValue() throws Exception {
        Transfer.UpdateRequestBuilder builder = new Transfer.UpdateRequestBuilder("trsf_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", 789);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderChaining() throws Exception {
        Transfer.UpdateRequestBuilder builder = new Transfer.UpdateRequestBuilder("trsf_test_123");
        
        builder
            .amount(100000L)
            .metadata("updated_by", "admin")
            .metadata("reason", "adjustment");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderWithNullMetadataKeyValue() throws Exception {
        Transfer.UpdateRequestBuilder builder = new Transfer.UpdateRequestBuilder("trsf_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", null);
        
        assertNotNull(builder.payload());
    }

    // ListRequestBuilder tests
    @Test
    public void testListRequestBuilder() throws Exception {
        Transfer.ListRequestBuilder builder = new Transfer.ListRequestBuilder();
        
        assertTrue(builder.path().toString().contains("transfers"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithOptions() throws Exception {
        Transfer.ListRequestBuilder builder = new Transfer.ListRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // CreateRequestBuilder tests
    @Test
    public void testCreateRequestBuilderAmount() throws Exception {
        Transfer.CreateRequestBuilder builder = new Transfer.CreateRequestBuilder();
        
        builder.amount(100000L);
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("transfers"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderFailFast() throws Exception {
        Transfer.CreateRequestBuilder builder = new Transfer.CreateRequestBuilder();
        
        builder.failFast(true);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderMetadata() throws Exception {
        Transfer.CreateRequestBuilder builder = new Transfer.CreateRequestBuilder();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id", "order123");
        
        builder.metadata(metadata);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderMetadataKeyValue() throws Exception {
        Transfer.CreateRequestBuilder builder = new Transfer.CreateRequestBuilder();
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", 123);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderRecipient() throws Exception {
        Transfer.CreateRequestBuilder builder = new Transfer.CreateRequestBuilder();
        
        builder.recipient("recp_test_123");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderChaining() throws Exception {
        Transfer.CreateRequestBuilder builder = new Transfer.CreateRequestBuilder();
        
        builder
            .amount(200000L)
            .recipient("recp_test_456")
            .failFast(true)
            .metadata("order_id", "order789")
            .metadata("customer_id", 999);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderWithNullMetadataKeyValue() throws Exception {
        Transfer.CreateRequestBuilder builder = new Transfer.CreateRequestBuilder();
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", null);
        
        assertNotNull(builder.payload());
    }

    // ListSchedulesRequestBuilder tests
    @Test
    public void testListSchedulesRequestBuilder() throws Exception {
        Transfer.ListSchedulesRequestBuilder builder = new Transfer.ListSchedulesRequestBuilder();
        
        assertTrue(builder.path().toString().contains("transfers"));
        assertTrue(builder.path().toString().contains("schedules"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListSchedulesRequestBuilderWithOptions() throws Exception {
        Transfer.ListSchedulesRequestBuilder builder = new Transfer.ListSchedulesRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // MarkAsPaidRequestBuilder tests
    @Test
    public void testMarkAsPaidRequestBuilder() throws Exception {
        Transfer.MarkAsPaidRequestBuilder builder = new Transfer.MarkAsPaidRequestBuilder("trsf_test_123");
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("transfers/trsf_test_123/mark_as_paid"));
        assertNotNull(builder.type());
    }

    // MarkAsSentRequestBuilder tests
    @Test
    public void testMarkAsSentRequestBuilder() throws Exception {
        Transfer.MarkAsSentRequestBuilder builder = new Transfer.MarkAsSentRequestBuilder("trsf_test_123");
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("transfers/trsf_test_123/mark_as_sent"));
        assertNotNull(builder.type());
    }

    // Large amount tests
    @Test
    public void testLargeAmount() {
        Transfer transfer = new Transfer();
        long largeAmount = Long.MAX_VALUE;
        transfer.setAmount(largeAmount);
        assertEquals(largeAmount, transfer.getAmount());
    }

    @Test
    public void testLargeFee() {
        Transfer transfer = new Transfer();
        long largeFee = Long.MAX_VALUE;
        transfer.setFee(largeFee);
        assertEquals(largeFee, transfer.getFee());
    }

    @Test
    public void testLargeNet() {
        Transfer transfer = new Transfer();
        long largeNet = Long.MAX_VALUE;
        transfer.setNet(largeNet);
        assertEquals(largeNet, transfer.getNet());
    }
}
