package co.omise.requests;

import co.omise.Serializer;
import co.omise.models.Dispute;
import co.omise.models.DisputeStatus;
import co.omise.models.DisputeReasonCode;
import co.omise.models.OmiseException;
import co.omise.models.ScopedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

import java.io.IOException;

public class DisputeRequestTest extends RequestTest {
    private static final String DISPUTE_ID = "dspt_test_5089off452g5m5te7xs";

    @Test
    public void testList() throws IOException, OmiseException {
        Request<ScopedList<Dispute>> request = new Dispute.ListRequestBuilder().build();
        ScopedList<Dispute> list = getTestRequester().sendRequest(request);
        assertRequested("GET", "/disputes", 200);

        assertEquals(1, list.getTotal());
        assertEquals(20, list.getLimit());
    }

    @Test
    public void testListWithStatus() throws IOException, OmiseException {
        Request<ScopedList<Dispute>> wonDisputesRequest = new Dispute.ListRequestBuilder()
                .status(DisputeStatus.Closed)
                .build();
        ScopedList<Dispute> wonDisputes = getTestRequester().sendRequest(wonDisputesRequest);
        assertRequested("GET", "/disputes/closed", 200);
        assertEquals(DisputeStatus.Won, wonDisputes.getData().get(0).getStatus());

        Request<ScopedList<Dispute>> openDisputesRequest = new Dispute.ListRequestBuilder()
                .status(DisputeStatus.Open)
                .build();
        ScopedList<Dispute> openDisputes = getTestRequester().sendRequest(openDisputesRequest);
        assertRequested("GET", "/disputes/open", 200);
        assertEquals(DisputeStatus.Open, openDisputes.getData().get(0).getStatus());

        Request<ScopedList<Dispute>> pendingDisputesRequest = new Dispute.ListRequestBuilder()
                .status(DisputeStatus.Pending)
                .build();
        ScopedList<Dispute> pendingDisputes = getTestRequester().sendRequest(pendingDisputesRequest);
        assertRequested("GET", "/disputes/pending", 200);
        assertEquals(DisputeStatus.Pending, pendingDisputes.getData().get(0).getStatus());
    }

    @Test
    public void testGet() throws IOException, OmiseException {
        Request<Dispute> request = new Dispute.GetRequestBuilder(DISPUTE_ID).build();
        Dispute dispute = getTestRequester().sendRequest(request);
        assertRequested("GET", "/disputes/" + DISPUTE_ID, 200);

        assertEquals("dspt_test_5089off452g5m5te7xs", dispute.getId());
        assertEquals(100000L, dispute.getAmount());
        assertEquals("thb", dispute.getCurrency());
        assertEquals("chrg_test_5089odjlzg9j7tw4i1q", dispute.getCharge());
        assertEquals("DESCRIPTION", dispute.getMetadata().get("description"));
        assertEquals("inv_N1ayTWJ2FV", dispute.getMetadata().get("invoice_id"));
        assertEquals("trxn_test_5d1cy88q3esdr60yr4m", dispute.getTransactions().get(0).getId());
        assertEquals(DisputeReasonCode.GoodsOrServicesNotProvided, dispute.getReasonCode());
        assertEquals("Services not provided or Merchandise not received", dispute.getReasonMessage());

        DateTimeFormatter formatter = Serializer.defaultSerializer().dateTimeFormatter();
        LocalDateTime closedAt = LocalDateTime.parse("2015-03-23T01:24:39Z", formatter);
        assertEquals(closedAt, dispute.getClosedAt().toLocalDateTime());
    }

    @Test
    public void testUpdate() throws IOException, OmiseException {
        Request<Dispute> request = new Dispute.UpdateRequestBuilder(DISPUTE_ID)
                .message("Your dispute message")
                .metadata("description", "DESCRIPTION")
                .metadata("invoice_id", "inv_N1ayTWJ2FV")
                .build();

        Dispute dispute = getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/disputes/" + DISPUTE_ID, 200);

        assertEquals("dspt_test_5089off452g5m5te7xs", dispute.getId());
        assertEquals("Your dispute message", dispute.getMessage());

        assertEquals("DESCRIPTION", dispute.getMetadata().get("description"));
        assertEquals("inv_N1ayTWJ2FV", dispute.getMetadata().get("invoice_id"));
    }

    @Test
    public void testClose() throws IOException, OmiseException {
        Request<Dispute> request = new Dispute.CloseRequestBuilder(DISPUTE_ID)
                .status(DisputeStatus.Lost)
                .build();

        Dispute dispute = getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/disputes/" + DISPUTE_ID + "/close", 200);

        assertEquals("dspt_test_5089off452g5m5te7xs", dispute.getId());
        assertEquals(DisputeStatus.Lost, dispute.getStatus());
        assertNotNull(dispute.getClosedAt());
    }

    @Test
    public void testAccept() throws IOException, OmiseException {
        Request<Dispute> request = new Dispute.AcceptRequestBuilder(DISPUTE_ID).build();
        Dispute dispute = getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/disputes/" + DISPUTE_ID + "/accept", 200);

        assertEquals("dspt_test_5089off452g5m5te7xs", dispute.getId());
        assertEquals(DisputeStatus.Lost, dispute.getStatus());
        assertNotNull(dispute.getClosedAt());
    }

    @Test
    public void testCreateDispute() throws IOException, OmiseException {
        String chargeId = "chrg_test_5089odjlzg9j7tw4i1q";
        Request<Dispute> request = new Dispute.CreateDisputeRequestBuilder(chargeId).build();
        Dispute dispute = getTestRequester().sendRequest(request);

        assertRequested("POST", "/charges/" + chargeId + "/disputes", 200);

        assertEquals("dspt_test_5089off452g5m5te7xs", dispute.getId());
        assertEquals(DisputeStatus.Open, dispute.getStatus());
        assertEquals(chargeId, dispute.getCharge());
        assertEquals(DisputeReasonCode.UnauthorizedCharge, dispute.getReasonCode());
    }

    @Test
    public void testGetWithAllFields() throws IOException, OmiseException {
        Request<Dispute> request = new Dispute.GetRequestBuilder(DISPUTE_ID).build();
        Dispute dispute = getTestRequester().sendRequest(request);
        
        assertRequested("GET", "/disputes/" + DISPUTE_ID, 200);

        // Test all basic fields
        assertNotNull(dispute.getId());
        assertEquals("dspt_test_5089off452g5m5te7xs", dispute.getId());
        assertEquals(100000L, dispute.getAmount());
        assertEquals("thb", dispute.getCurrency());
        assertEquals("chrg_test_5089odjlzg9j7tw4i1q", dispute.getCharge());
        assertNotNull(dispute.getLocation());
        assertEquals("/disputes/dspt_test_5089off452g5m5te7xs", dispute.getLocation());

        // Test metadata
        assertNotNull(dispute.getMetadata());
        assertEquals("DESCRIPTION", dispute.getMetadata().get("description"));
        assertEquals("inv_N1ayTWJ2FV", dispute.getMetadata().get("invoice_id"));

        // Test transactions
        assertNotNull(dispute.getTransactions());
        assertTrue(dispute.getTransactions().size() > 0);
        assertEquals("trxn_test_5d1cy88q3esdr60yr4m", dispute.getTransactions().get(0).getId());

        // Test reason code and message
        assertEquals(DisputeReasonCode.GoodsOrServicesNotProvided, dispute.getReasonCode());
        assertEquals("Services not provided or Merchandise not received", dispute.getReasonMessage());

        // Test closed_at date
        assertNotNull(dispute.getClosedAt());
        DateTimeFormatter formatter = Serializer.defaultSerializer().dateTimeFormatter();
        LocalDateTime closedAt = LocalDateTime.parse("2015-03-23T01:24:39Z", formatter);
        assertEquals(closedAt, dispute.getClosedAt().toLocalDateTime());
    }

    @Test
    public void testUpdateWithMetadataMap() throws IOException, OmiseException {
        java.util.Map<String, Object> metadata = new java.util.HashMap<>();
        metadata.put("description", "DESCRIPTION");
        metadata.put("invoice_id", "inv_N1ayTWJ2FV");

        Request<Dispute> request = new Dispute.UpdateRequestBuilder(DISPUTE_ID)
                .message("Your dispute message")
                .metadata(metadata)
                .build();

        Dispute dispute = getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/disputes/" + DISPUTE_ID, 200);

        assertEquals("dspt_test_5089off452g5m5te7xs", dispute.getId());
        assertEquals("Your dispute message", dispute.getMessage());
        assertEquals("DESCRIPTION", dispute.getMetadata().get("description"));
        assertEquals("inv_N1ayTWJ2FV", dispute.getMetadata().get("invoice_id"));
    }

    @Test
    public void testListWithOptions() throws IOException, OmiseException {
        ScopedList.Options options = new ScopedList.Options()
                .limit(10)
                .offset(5);

        Request<ScopedList<Dispute>> request = new Dispute.ListRequestBuilder()
                .options(options)
                .build();

        ScopedList<Dispute> list = getTestRequester().sendRequest(request);
        assertRequested("GET", "/disputes", 200);

        assertNotNull(list);
        assertEquals(1, list.getTotal());
    }

    @Test
    public void testDisputeStatusEnumValues() {
        // Test that all DisputeStatus enum values are properly defined
        assertNotNull(DisputeStatus.Open);
        assertNotNull(DisputeStatus.Pending);
        assertNotNull(DisputeStatus.Won);
        assertNotNull(DisputeStatus.Lost);
        assertNotNull(DisputeStatus.Closed);
    }

    @Test
    public void testDisputeReasonCodeEnumValues() {
        // Test that key DisputeReasonCode enum values are properly defined
        assertNotNull(DisputeReasonCode.GoodsOrServicesNotProvided);
        assertNotNull(DisputeReasonCode.UnauthorizedCharge);
        assertNotNull(DisputeReasonCode.DuplicateProcessing);
        assertNotNull(DisputeReasonCode.CreditNotProcessed);
        assertNotNull(DisputeReasonCode.NotAsDescribedOrDefectiveMerchandise);
        assertNotNull(DisputeReasonCode.TransactionNotRecognised);
        assertNotNull(DisputeReasonCode.Other);
    }

    @Test
    public void testDisputeGettersAndSetters() {
        Dispute dispute = new Dispute();

        // Test amount
        dispute.setAmount(50000L);
        assertEquals(50000L, dispute.getAmount());

        // Test currency
        dispute.setCurrency("usd");
        assertEquals("usd", dispute.getCurrency());

        // Test charge
        dispute.setCharge("chrg_test_123");
        assertEquals("chrg_test_123", dispute.getCharge());

        // Test message
        dispute.setMessage("Test message");
        assertEquals("Test message", dispute.getMessage());

        // Test adminMessage
        dispute.setAdminMessage("Admin message");
        assertEquals("Admin message", dispute.getAdminMessage());

        // Test status
        dispute.setStatus(DisputeStatus.Pending);
        assertEquals(DisputeStatus.Pending, dispute.getStatus());

        // Test reasonCode
        dispute.setReasonCode(DisputeReasonCode.UnauthorizedCharge);
        assertEquals(DisputeReasonCode.UnauthorizedCharge, dispute.getReasonCode());

        // Test reasonMessage
        dispute.setReasonMessage("Reason message");
        assertEquals("Reason message", dispute.getReasonMessage());

        // Test location
        dispute.setLocation("/disputes/dspt_test_123");
        assertEquals("/disputes/dspt_test_123", dispute.getLocation());

        // Test fundingAmount
        dispute.setFundingAmount(45000L);
        assertEquals(45000L, dispute.getFundingAmount());

        // Test fundingCurrency
        dispute.setFundingCurrency("eur");
        assertEquals("eur", dispute.getFundingCurrency());
    }

    @Test
    public void testDisputeWithTransactions() throws IOException, OmiseException {
        Request<Dispute> request = new Dispute.GetRequestBuilder(DISPUTE_ID).build();
        Dispute dispute = getTestRequester().sendRequest(request);

        assertRequested("GET", "/disputes/" + DISPUTE_ID, 200);

        // Verify transactions list
        assertNotNull(dispute.getTransactions());
        assertFalse(dispute.getTransactions().isEmpty());
        
        // Verify first transaction details
        assertEquals("trxn_test_5d1cy88q3esdr60yr4m", dispute.getTransactions().get(0).getId());
        
        // Verify multiple transactions exist
        assertTrue(dispute.getTransactions().size() >= 2);
    }

}
