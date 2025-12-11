package co.omise.requests;

import co.omise.models.*;
import co.omise.models.schedules.Schedule;
import org.junit.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class RecipientRequestTest extends RequestTest {
    private static final String RECIPIENT_ID = "recp_test_50894vc13y8z4v51iuc";

    @Test
    public void testCreate() throws IOException, OmiseException {
        Request<Recipient> request = new Recipient.CreateRequestBuilder()
                .email("john.doe@example.com")
                .description("Default recipient")
                .build();
        Recipient recipient = getTestRequester().sendRequest(request);

        assertRequested("POST", "/recipients", 200);

        assertEquals(RECIPIENT_ID, recipient.getId());
        assertEquals("john.doe@example.com", recipient.getEmail());
        assertEquals("6789", recipient.getBankAccount().getLastDigits());
        assertEquals("1111", recipient.getBankAccount().getAccountNumber());
        assertEquals("Default recipient", recipient.getDescription());
    }

    @Test
    public void testGet() throws IOException, OmiseException {
        Request<Recipient> request = new Recipient.GetRequestBuilder(RECIPIENT_ID)
                .build();
        Recipient recipient = getTestRequester().sendRequest(request);

        assertRequested("GET", "/recipients/" + RECIPIENT_ID, 200);

        assertEquals(RECIPIENT_ID, recipient.getId());
        assertEquals("john.doe@example.com", recipient.getEmail());
        assertEquals(RecipientType.Individual, recipient.getType());
        assertEquals("6789", recipient.getBankAccount().getLastDigits());
    }

    @Test
    public void testUpdate() throws IOException, OmiseException {
        Request<Recipient> request = new Recipient.UpdateRequestBuilder(RECIPIENT_ID)
                .email("john@doe.com")
                .name("john@doe.com")
                .build();
        Recipient recipient = getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/recipients/" + RECIPIENT_ID, 200);

        assertEquals(RECIPIENT_ID, recipient.getId());
        assertEquals("john@doe.com", recipient.getEmail());
        assertEquals("john@doe.com", recipient.getName());
    }

    @Test
    public void testDestroy() throws IOException, OmiseException {
        Request<Recipient> request = new Recipient.DeleteRequestBuilder(RECIPIENT_ID).build();
        Recipient recipient = getTestRequester().sendRequest(request);

        assertRequested("DELETE", "/recipients/" + RECIPIENT_ID, 200);

        assertEquals(RECIPIENT_ID, recipient.getId());
        assertTrue(recipient.isDeleted());
    }

    @Test
    public void testList() throws IOException, OmiseException {
        Request<ScopedList<Recipient>> request = new Recipient.ListRequestBuilder()
                .build();
        ScopedList<Recipient> recipients = getTestRequester().sendRequest(request);

        assertRequested("GET", "/recipients", 200);

        assertEquals(1, recipients.getTotal());
        assertEquals(20, recipients.getLimit());

        Recipient recipient = recipients.getData().get(0);
        assertEquals(RECIPIENT_ID, recipient.getId());
        assertEquals("john.doe@example.com", recipient.getEmail());
    }

    @Test
    public void testCreateWithAllFields() throws IOException, OmiseException {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("user_id", "12345");
        metadata.put("department", "sales");

        BankAccount.Params bankAccount = new BankAccount.Params()
                .brand("bbl")
                .number("1234567890")
                .name("JOHN DOE");

        Request<Recipient> request = new Recipient.CreateRequestBuilder()
                .email("john.doe@example.com")
                .description("Test recipient")
                .name("John Doe")
                .type(RecipientType.Individual)
                .taxId("1234567890123")
                .bankAccount(bankAccount)
                .metadata(metadata)
                .build();

        Recipient recipient = getTestRequester().sendRequest(request);

        assertRequested("POST", "/recipients", 200);
        assertEquals(RECIPIENT_ID, recipient.getId());
        assertEquals("john.doe@example.com", recipient.getEmail());
    }

    @Test
    public void testCreateWithMetadataKeyValue() throws IOException, OmiseException {
        Request<Recipient> request = new Recipient.CreateRequestBuilder()
                .email("john.doe@example.com")
                .description("Test recipient")
                .metadata("order_id", "ORD-12345")
                .metadata("customer_type", "premium")
                .build();

        Recipient recipient = getTestRequester().sendRequest(request);

        assertRequested("POST", "/recipients", 200);
        assertEquals(RECIPIENT_ID, recipient.getId());
    }

    @Test
    public void testUpdateWithAllFields() throws IOException, OmiseException {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("updated", "true");

        BankAccount.Params bankAccount = new BankAccount.Params()
                .brand("kbank")
                .number("9876543210")
                .name("JOHN SMITH");

        Request<Recipient> request = new Recipient.UpdateRequestBuilder(RECIPIENT_ID)
                .email("john.smith@example.com")
                .name("John Smith")
                .description("Updated recipient")
                .type(RecipientType.Corporation)
                .taxId("9876543210987")
                .bankAccount(bankAccount)
                .metadata(metadata)
                .build();

        Recipient recipient = getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/recipients/" + RECIPIENT_ID, 200);
        assertEquals(RECIPIENT_ID, recipient.getId());
        assertEquals("john@doe.com", recipient.getEmail());
    }

    @Test
    public void testUpdateWithMetadataKeyValue() throws IOException, OmiseException {
        Request<Recipient> request = new Recipient.UpdateRequestBuilder(RECIPIENT_ID)
                .email("updated@example.com")
                .metadata("status", "verified")
                .metadata("last_updated", "2024-12-11")
                .build();

        Recipient recipient = getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/recipients/" + RECIPIENT_ID, 200);
        assertEquals(RECIPIENT_ID, recipient.getId());
    }

    @Test
    public void testListWithOptions() throws IOException, OmiseException {
        ScopedList.Options options = new ScopedList.Options()
                .limit(10)
                .offset(5);

        Request<ScopedList<Recipient>> request = new Recipient.ListRequestBuilder()
                .options(options)
                .build();

        ScopedList<Recipient> recipients = getTestRequester().sendRequest(request);

        assertRequested("GET", "/recipients", 200);
        assertEquals(1, recipients.getTotal());
    }

    @Test
    public void testListSchedules() throws IOException, OmiseException {
        Request<ScopedList<Schedule>> request = new Recipient.ListSchedulesRequestBuilder(RECIPIENT_ID)
                .build();

        ScopedList<Schedule> schedules = getTestRequester().sendRequest(request);

        assertRequested("GET", "/recipients/" + RECIPIENT_ID + "/schedules", 200);
        assertNotNull(schedules);
    }

    @Test
    public void testListSchedulesWithOptions() throws IOException, OmiseException {
        ScopedList.Options options = new ScopedList.Options()
                .limit(5);

        Request<ScopedList<Schedule>> request = new Recipient.ListSchedulesRequestBuilder(RECIPIENT_ID)
                .options(options)
                .build();

        ScopedList<Schedule> schedules = getTestRequester().sendRequest(request);

        assertRequested("GET", "/recipients/" + RECIPIENT_ID + "/schedules", 200);
        assertNotNull(schedules);
    }

    @Test
    public void testVerify() throws IOException, OmiseException {
        Request<Recipient> request = new Recipient.VerifyRequestBuilder(RECIPIENT_ID)
                .build();

        Recipient recipient = getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/recipients/" + RECIPIENT_ID + "/verify", 200);
        assertEquals(RECIPIENT_ID, recipient.getId());
    }

    @Test
    public void testRecipientGettersAndSetters() {
        Recipient recipient = new Recipient();
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime verifiedTime = ZonedDateTime.now().plusDays(1);

        // Test all setters
        recipient.setActivatedAt(now);
        recipient.setActive(true);
        recipient.setIsDefault(true);
        recipient.setDescription("Test description");
        recipient.setEmail("test@example.com");
        recipient.setFailureCode(RecipientFailureCode.AccountNotFound);
        recipient.setLocation("/recipients/test");
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");
        recipient.setMetadata(metadata);
        
        recipient.setName("Test Name");
        recipient.setSchedule("schd_test");
        recipient.setTaxId("1234567890");
        recipient.setType(RecipientType.Individual);
        recipient.setVerified(true);
        recipient.setVerifiedAt(verifiedTime);

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBrand("test_bank");
        recipient.setBankAccount(bankAccount);

        // Test all getters
        assertEquals(now, recipient.getActivatedAt());
        assertTrue(recipient.isActive());
        assertTrue(recipient.IsDefault());
        assertEquals("Test description", recipient.getDescription());
        assertEquals("test@example.com", recipient.getEmail());
        assertEquals(RecipientFailureCode.AccountNotFound, recipient.getFailureCode());
        assertEquals("/recipients/test", recipient.getLocation());
        assertEquals(metadata, recipient.getMetadata());
        assertEquals("Test Name", recipient.getName());
        assertEquals("schd_test", recipient.getSchedule());
        assertEquals("1234567890", recipient.getTaxId());
        assertEquals(RecipientType.Individual, recipient.getType());
        assertTrue(recipient.isVerified());
        assertEquals(verifiedTime, recipient.getVerifiedAt());
        assertEquals("test_bank", recipient.getBankAccount().getBrand());
    }

    @Test
    public void testRecipientFailureCodeEnum() {
        // Test all RecipientFailureCode enum values
        assertNotNull(RecipientFailureCode.AccountNotFound);
        assertNotNull(RecipientFailureCode.BankNotFound);
        assertNotNull(RecipientFailureCode.NameMismatch);
    }

    @Test
    public void testRecipientTypeEnum() {
        // Test RecipientType enum values exist
        assertNotNull(RecipientType.Individual);
        assertNotNull(RecipientType.Corporation);
    }
}