package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RecipientTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetActivatedAt() {
        Recipient recipient = new Recipient();
        ZonedDateTime now = ZonedDateTime.now();
        recipient.setActivatedAt(now);
        assertEquals(now, recipient.getActivatedAt());
    }

    @Test
    public void testGetSetActive() {
        Recipient recipient = new Recipient();
        recipient.setActive(true);
        assertTrue(recipient.isActive());
        
        recipient.setActive(false);
        assertFalse(recipient.isActive());
    }

    @Test
    public void testGetSetBankAccount() {
        Recipient recipient = new Recipient();
        BankAccount bankAccount = new BankAccount();
        recipient.setBankAccount(bankAccount);
        assertEquals(bankAccount, recipient.getBankAccount());
    }

    @Test
    public void testGetSetIsDefault() {
        Recipient recipient = new Recipient();
        recipient.setIsDefault(true);
        assertTrue(recipient.IsDefault());
        
        recipient.setIsDefault(false);
        assertFalse(recipient.IsDefault());
    }

    @Test
    public void testGetSetDescription() {
        Recipient recipient = new Recipient();
        String description = "Test recipient description";
        recipient.setDescription(description);
        assertEquals(description, recipient.getDescription());
    }

    @Test
    public void testGetSetEmail() {
        Recipient recipient = new Recipient();
        String email = "test@example.com";
        recipient.setEmail(email);
        assertEquals(email, recipient.getEmail());
    }

    @Test
    public void testGetSetFailureCode() {
        Recipient recipient = new Recipient();
        RecipientFailureCode failureCode = RecipientFailureCode.AccountNotFound;
        recipient.setFailureCode(failureCode);
        assertEquals(failureCode, recipient.getFailureCode());
    }

    @Test
    public void testGetSetLocation() {
        Recipient recipient = new Recipient();
        String location = "https://api.omise.co/recipients/recp_test";
        recipient.setLocation(location);
        assertEquals(location, recipient.getLocation());
    }

    @Test
    public void testGetSetMetadata() {
        Recipient recipient = new Recipient();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key1", "value1");
        metadata.put("key2", 123);
        recipient.setMetadata(metadata);
        assertEquals(metadata, recipient.getMetadata());
    }

    @Test
    public void testGetSetName() {
        Recipient recipient = new Recipient();
        String name = "John Doe";
        recipient.setName(name);
        assertEquals(name, recipient.getName());
    }

    @Test
    public void testGetSetSchedule() {
        Recipient recipient = new Recipient();
        String schedule = "schd_test_123";
        recipient.setSchedule(schedule);
        assertEquals(schedule, recipient.getSchedule());
    }

    @Test
    public void testGetSetTaxId() {
        Recipient recipient = new Recipient();
        String taxId = "1234567890";
        recipient.setTaxId(taxId);
        assertEquals(taxId, recipient.getTaxId());
    }

    @Test
    public void testGetSetType() {
        Recipient recipient = new Recipient();
        RecipientType type = RecipientType.Individual;
        recipient.setType(type);
        assertEquals(type, recipient.getType());
    }

    @Test
    public void testGetSetVerified() {
        Recipient recipient = new Recipient();
        recipient.setVerified(true);
        assertTrue(recipient.isVerified());
        
        recipient.setVerified(false);
        assertFalse(recipient.isVerified());
    }

    @Test
    public void testGetSetVerifiedAt() {
        Recipient recipient = new Recipient();
        ZonedDateTime now = ZonedDateTime.now();
        recipient.setVerifiedAt(now);
        assertEquals(now, recipient.getVerifiedAt());
    }

    // Edge case tests
    @Test
    public void testNullActivatedAt() {
        Recipient recipient = new Recipient();
        recipient.setActivatedAt(null);
        assertNull(recipient.getActivatedAt());
    }

    @Test
    public void testNullVerifiedAt() {
        Recipient recipient = new Recipient();
        recipient.setVerifiedAt(null);
        assertNull(recipient.getVerifiedAt());
    }

    @Test
    public void testNullBankAccount() {
        Recipient recipient = new Recipient();
        recipient.setBankAccount(null);
        assertNull(recipient.getBankAccount());
    }

    @Test
    public void testNullDescription() {
        Recipient recipient = new Recipient();
        recipient.setDescription(null);
        assertNull(recipient.getDescription());
    }

    @Test
    public void testEmptyDescription() {
        Recipient recipient = new Recipient();
        recipient.setDescription("");
        assertEquals("", recipient.getDescription());
    }

    @Test
    public void testNullEmail() {
        Recipient recipient = new Recipient();
        recipient.setEmail(null);
        assertNull(recipient.getEmail());
    }

    @Test
    public void testEmptyEmail() {
        Recipient recipient = new Recipient();
        recipient.setEmail("");
        assertEquals("", recipient.getEmail());
    }

    @Test
    public void testNullFailureCode() {
        Recipient recipient = new Recipient();
        recipient.setFailureCode(null);
        assertNull(recipient.getFailureCode());
    }

    @Test
    public void testNullLocation() {
        Recipient recipient = new Recipient();
        recipient.setLocation(null);
        assertNull(recipient.getLocation());
    }

    @Test
    public void testNullMetadata() {
        Recipient recipient = new Recipient();
        recipient.setMetadata(null);
        assertNull(recipient.getMetadata());
    }

    @Test
    public void testEmptyMetadata() {
        Recipient recipient = new Recipient();
        Map<String, Object> emptyMap = new HashMap<>();
        recipient.setMetadata(emptyMap);
        assertEquals(emptyMap, recipient.getMetadata());
    }

    @Test
    public void testNullName() {
        Recipient recipient = new Recipient();
        recipient.setName(null);
        assertNull(recipient.getName());
    }

    @Test
    public void testEmptyName() {
        Recipient recipient = new Recipient();
        recipient.setName("");
        assertEquals("", recipient.getName());
    }

    @Test
    public void testNullSchedule() {
        Recipient recipient = new Recipient();
        recipient.setSchedule(null);
        assertNull(recipient.getSchedule());
    }

    @Test
    public void testNullTaxId() {
        Recipient recipient = new Recipient();
        recipient.setTaxId(null);
        assertNull(recipient.getTaxId());
    }

    @Test
    public void testNullType() {
        Recipient recipient = new Recipient();
        recipient.setType(null);
        assertNull(recipient.getType());
    }

    // DeleteRequestBuilder tests
    @Test
    public void testDeleteRequestBuilder() throws Exception {
        Recipient.DeleteRequestBuilder builder = new Recipient.DeleteRequestBuilder("recp_test_123");
        
        assertEquals("DELETE", builder.method());
        assertTrue(builder.path().toString().contains("recipients/recp_test_123"));
        assertNotNull(builder.type());
    }

    // GetRequestBuilder tests
    @Test
    public void testGetRequestBuilder() throws Exception {
        Recipient.GetRequestBuilder builder = new Recipient.GetRequestBuilder("recp_test_123");
        
        assertTrue(builder.path().toString().contains("recipients/recp_test_123"));
        assertNotNull(builder.type());
    }

    // UpdateRequestBuilder tests
    @Test
    public void testUpdateRequestBuilderBankAccount() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        BankAccount.Params bankAccount = new BankAccount.Params();
        
        builder.bankAccount(bankAccount);
        
        assertEquals("PATCH", builder.method());
        assertTrue(builder.path().toString().contains("recipients/recp_test_123"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderDescription() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        
        builder.description("Updated description");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderEmail() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        
        builder.email("updated@example.com");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderMetadata() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");
        
        builder.metadata(metadata);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderMetadataKeyValue() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", 123);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderName() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        
        builder.name("New Name");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderTaxId() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        
        builder.taxId("9876543210");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderType() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        
        builder.type(RecipientType.Corporation);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderChaining() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        
        builder
            .name("Test Name")
            .email("test@example.com")
            .description("Test Description")
            .taxId("1234567890")
            .type(RecipientType.Individual)
            .metadata("key", "value");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderWithNullMetadataKeyValue() throws Exception {
        Recipient.UpdateRequestBuilder builder = new Recipient.UpdateRequestBuilder("recp_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", null);
        
        assertNotNull(builder.payload());
    }

    // ListRequestBuilder tests
    @Test
    public void testListRequestBuilder() throws Exception {
        Recipient.ListRequestBuilder builder = new Recipient.ListRequestBuilder();
        
        assertTrue(builder.path().toString().contains("recipients"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithOptions() throws Exception {
        Recipient.ListRequestBuilder builder = new Recipient.ListRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // CreateRequestBuilder tests
    @Test
    public void testCreateRequestBuilderBankAccount() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        BankAccount.Params bankAccount = new BankAccount.Params();
        
        builder.bankAccount(bankAccount);
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("recipients"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderDescription() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        
        builder.description("Test description");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderEmail() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        
        builder.email("create@example.com");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderMetadata() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("created", true);
        
        builder.metadata(metadata);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderMetadataKeyValue() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", 456);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderName() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        
        builder.name("Create Name");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderTaxId() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        
        builder.taxId("5555555555");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderType() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        
        builder.type(RecipientType.Individual);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderChaining() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        
        builder
            .name("New Recipient")
            .email("new@example.com")
            .description("New Description")
            .taxId("1111111111")
            .type(RecipientType.Corporation)
            .metadata("created", "yes");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderWithNullMetadataKeyValue() throws Exception {
        Recipient.CreateRequestBuilder builder = new Recipient.CreateRequestBuilder();
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", null);
        
        assertNotNull(builder.payload());
    }

    // ListSchedulesRequestBuilder tests
    @Test
    public void testListSchedulesRequestBuilder() throws Exception {
        Recipient.ListSchedulesRequestBuilder builder = new Recipient.ListSchedulesRequestBuilder("recp_test_123");
        
        assertTrue(builder.path().toString().contains("recipients/recp_test_123/schedules"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListSchedulesRequestBuilderWithOptions() throws Exception {
        Recipient.ListSchedulesRequestBuilder builder = new Recipient.ListSchedulesRequestBuilder("recp_test_123");
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // VerifyRequestBuilder tests
    @Test
    public void testVerifyRequestBuilder() throws Exception {
        Recipient.VerifyRequestBuilder builder = new Recipient.VerifyRequestBuilder("recp_test_123");
        
        assertEquals("PATCH", builder.method());
        assertTrue(builder.path().toString().contains("recipients/recp_test_123/verify"));
        assertNotNull(builder.type());
    }

    // RecipientType enum tests
    @Test
    public void testRecipientTypeIndividual() {
        RecipientType type = RecipientType.Individual;
        assertNotNull(type);
        assertEquals("Individual", type.name());
    }

    @Test
    public void testRecipientTypeCorporation() {
        RecipientType type = RecipientType.Corporation;
        assertNotNull(type);
        assertEquals("Corporation", type.name());
    }

    // RecipientFailureCode enum tests
    @Test
    public void testFailureCodeAccountNotFound() {
        RecipientFailureCode code = RecipientFailureCode.AccountNotFound;
        assertNotNull(code);
    }

    @Test
    public void testFailureCodeBankNotFound() {
        RecipientFailureCode code = RecipientFailureCode.BankNotFound;
        assertNotNull(code);
    }

    @Test
    public void testFailureCodeNameMismatch() {
        RecipientFailureCode code = RecipientFailureCode.NameMismatch;
        assertNotNull(code);
    }
}
