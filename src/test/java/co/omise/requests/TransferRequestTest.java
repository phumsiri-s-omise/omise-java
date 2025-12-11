package co.omise.requests;

import co.omise.models.*;
import co.omise.models.schedules.Schedule;
import org.junit.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransferRequestTest extends RequestTest {
    private static final String TRANSFER_ID = "trsf_test_4yqacz8t3cbipcj766u";

    @Test
    public void testList() throws IOException, OmiseException {
        Request<ScopedList<Transfer>> request = new Transfer.ListRequestBuilder()
                .build();
        ScopedList<Transfer> list = getTestRequester().sendRequest(request);
        assertRequested("GET", "/transfers", 200);

        assertEquals(20, list.getLimit());
        assertEquals(1, list.getTotal());

        Transfer transfer = list.getData().get(0);
        assertEquals(TRANSFER_ID, transfer.getId());
        assertEquals(192188L, transfer.getAmount());
    }

    @Test
    public void testGet() throws IOException, OmiseException {
        Request<Transfer> request = new Transfer.GetRequestBuilder(TRANSFER_ID)
                .build();
        Transfer transfer = getTestRequester().sendRequest(request);
        assertRequested("GET", "/transfers/" + TRANSFER_ID, 200);

        assertEquals(TRANSFER_ID, transfer.getId());
        assertEquals(192188L, transfer.getAmount());
        assertEquals("6789", transfer.getBankAccount().getLastDigits());
        assertEquals("JOHN DOE", transfer.getBankAccount().getName());
    }

    @Test
    public void testCreate() throws IOException, OmiseException {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("description", "DESCRIPTION");
        metadata.put("invoice_id", "inv_N1ayTWJ2FV");

        Request<Transfer> request = new Transfer.CreateRequestBuilder()
                .amount(192188)
                .metadata(metadata)
                .build();
        Transfer transfer = getTestRequester().sendRequest(request);
        assertRequested("POST", "/transfers", 200);

        assertEquals(TRANSFER_ID, transfer.getId());
        assertEquals(192188L, transfer.getAmount());
        assertEquals("DESCRIPTION", transfer.getMetadata().get("description"));
        assertEquals("inv_N1ayTWJ2FV", transfer.getMetadata().get("invoice_id"));
    }

    @Test
    public void testUpdate() throws IOException, OmiseException {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("description", "DESCRIPTION");
        metadata.put("invoice_id", "inv_N1ayTWJ2FV");
        Request<Transfer> request = new Transfer.UpdateRequestBuilder(TRANSFER_ID)
                .amount(192189)
                .metadata(metadata)
                .build();
        Transfer transfer = getTestRequester().sendRequest(request);
        assertRequested("PATCH", "/transfers/" + TRANSFER_ID, 200);

        assertEquals(TRANSFER_ID, transfer.getId());
        assertEquals(192189L, transfer.getAmount());
        assertEquals("DESCRIPTION", transfer.getMetadata().get("description"));
        assertEquals("inv_N1ayTWJ2FV", transfer.getMetadata().get("invoice_id"));
    }

    @Test
    public void testDelete() throws IOException, OmiseException {
        Request<Transfer> request = new Transfer.DeleteRequestBuilder(TRANSFER_ID)
                .build();
        Transfer transfer = getTestRequester().sendRequest(request);
        assertRequested("DELETE", "/transfers/" + TRANSFER_ID, 200);
        assertEquals(TRANSFER_ID, transfer.getId());
        assertTrue(transfer.isDeleted());
    }

    @Test
    public void testTransferSentDate() throws IOException, OmiseException {
        Request<Transfer> request = new Transfer.GetRequestBuilder(TRANSFER_ID)
                .build();
        Transfer transfer = getTestRequester().sendRequest(request);
        assertRequested("GET", "/transfers/" + TRANSFER_ID, 200);
        assertEquals(2015, transfer.getSentAt().getYear());
        assertEquals(10, transfer.getSentAt().getHour());
    }

    @Test
    public void testTransferPaidDate() throws IOException, OmiseException {
        Request<Transfer> request = new Transfer.GetRequestBuilder(TRANSFER_ID)
                .build();
        Transfer transfer = getTestRequester().sendRequest(request);
        assertRequested("GET", "/transfers/" + TRANSFER_ID, 200);
        assertEquals(2015, transfer.getPaidAt().getYear());
        assertEquals(10, transfer.getPaidAt().getHour());
    }

    @Test
    public void testCreateWithMetadataKeyValue() throws IOException, OmiseException {
        Request<Transfer> request = new Transfer.CreateRequestBuilder()
                .amount(100000)
                .metadata("order_id", "ORD-123")
                .metadata("customer_id", "CUST-456")
                .build();
        Transfer transfer = getTestRequester().sendRequest(request);
        assertRequested("POST", "/transfers", 200);
        assertEquals(TRANSFER_ID, transfer.getId());
    }

    @Test
    public void testUpdateWithMetadataKeyValue() throws IOException, OmiseException {
        Request<Transfer> request = new Transfer.UpdateRequestBuilder(TRANSFER_ID)
                .amount(200000)
                .metadata("status", "updated")
                .build();
        Transfer transfer = getTestRequester().sendRequest(request);
        assertRequested("PATCH", "/transfers/" + TRANSFER_ID, 200);
        assertEquals(TRANSFER_ID, transfer.getId());
    }

    @Test
    public void testCreateWithRecipient() throws IOException, OmiseException {
        Request<Transfer> request = new Transfer.CreateRequestBuilder()
                .amount(150000)
                .recipient("recp_test_123")
                .build();
        Transfer transfer = getTestRequester().sendRequest(request);
        assertRequested("POST", "/transfers", 200);
        assertEquals(TRANSFER_ID, transfer.getId());
    }

    @Test
    public void testListWithOptions() throws IOException, OmiseException {
        ScopedList.Options options = new ScopedList.Options()
                .limit(10)
                .offset(5);
        
        Request<ScopedList<Transfer>> request = new Transfer.ListRequestBuilder()
                .options(options)
                .build();
        ScopedList<Transfer> list = getTestRequester().sendRequest(request);
        assertRequested("GET", "/transfers", 200);
        assertEquals(1, list.getTotal());
    }

    @Test
    public void testListSchedules() throws IOException, OmiseException {
        Request<ScopedList<Schedule>> request = new Transfer.ListSchedulesRequestBuilder()
                .build();
        ScopedList<Schedule> schedules = getTestRequester().sendRequest(request);
        assertRequested("GET", "/transfers/schedules", 200);
        assertNotNull(schedules);
    }

    @Test
    public void testListSchedulesWithOptions() throws IOException, OmiseException {
        ScopedList.Options options = new ScopedList.Options()
                .limit(5);
        
        Request<ScopedList<Schedule>> request = new Transfer.ListSchedulesRequestBuilder()
                .options(options)
                .build();
        ScopedList<Schedule> schedules = getTestRequester().sendRequest(request);
        assertRequested("GET", "/transfers/schedules", 200);
        assertNotNull(schedules);
    }

    @Test
    public void testTransferGettersAndSetters() {
        Transfer transfer = new Transfer();
        
        // Test all setters
        transfer.setAmount(100000L);
        transfer.setCurrency("THB");
        transfer.setFailFast(true);
        transfer.setFailureCode("insufficient_balance");
        transfer.setFailureMessage("Insufficient balance");
        transfer.setFee(250L);
        transfer.setFeeVat(17L);
        transfer.setLocation("/transfers/test");
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");
        transfer.setMetadata(metadata);
        
        transfer.setNet(99733L);
        transfer.setPaid(true);
        transfer.setPaidAt(ZonedDateTime.now());
        transfer.setRecipient("recp_test");
        transfer.setSchedule("schd_test");
        transfer.setSendable(true);
        transfer.setSent(true);
        transfer.setSentAt(ZonedDateTime.now());
        transfer.setTotalFee(267L);
        
        List<Transaction> transactions = new ArrayList<>();
        transfer.setTransactions(transactions);
        
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBrand("test_bank");
        transfer.setBankAccount(bankAccount);
        
        // Test all getters
        assertEquals(100000L, transfer.getAmount());
        assertEquals("THB", transfer.getCurrency());
        assertTrue(transfer.isFailFast());
        assertEquals("insufficient_balance", transfer.getFailureCode());
        assertEquals("Insufficient balance", transfer.getFailureMessage());
        assertEquals(250L, transfer.getFee());
        assertEquals(17L, transfer.getFeeVat());
        assertEquals("/transfers/test", transfer.getLocation());
        assertEquals(metadata, transfer.getMetadata());
        assertEquals(99733L, transfer.getNet());
        assertTrue(transfer.isPaid());
        assertNotNull(transfer.getPaidAt());
        assertEquals("recp_test", transfer.getRecipient());
        assertEquals("schd_test", transfer.getSchedule());
        assertTrue(transfer.isSendable());
        assertTrue(transfer.isSent());
        assertNotNull(transfer.getSentAt());
        assertEquals(267L, transfer.getTotalFee());
        assertEquals(transactions, transfer.getTransactions());
        assertEquals("test_bank", transfer.getBankAccount().getBrand());
    }
}