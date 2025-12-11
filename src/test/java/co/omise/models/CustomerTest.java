package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetCards() {
        Customer customer = new Customer();
        ScopedList<Card> cards = new ScopedList<>();
        customer.setCards(cards);
        assertEquals(cards, customer.getCards());
    }

    @Test
    public void testGetSetDefaultCard() {
        Customer customer = new Customer();
        String defaultCard = "card_test_123";
        customer.setDefaultCard(defaultCard);
        assertEquals(defaultCard, customer.getDefaultCard());
    }

    @Test
    public void testGetSetDescription() {
        Customer customer = new Customer();
        String description = "Premium customer";
        customer.setDescription(description);
        assertEquals(description, customer.getDescription());
    }

    @Test
    public void testGetSetEmail() {
        Customer customer = new Customer();
        String email = "customer@example.com";
        customer.setEmail(email);
        assertEquals(email, customer.getEmail());
    }

    @Test
    public void testGetSetLocation() {
        Customer customer = new Customer();
        String location = "https://api.omise.co/customers/cust_test";
        customer.setLocation(location);
        assertEquals(location, customer.getLocation());
    }

    @Test
    public void testGetSetMetadata() {
        Customer customer = new Customer();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("customer_tier", "gold");
        metadata.put("loyalty_points", 1000);
        customer.setMetadata(metadata);
        assertEquals(metadata, customer.getMetadata());
    }

    // Edge case tests
    @Test
    public void testNullCards() {
        Customer customer = new Customer();
        customer.setCards(null);
        assertNull(customer.getCards());
    }

    @Test
    public void testNullDefaultCard() {
        Customer customer = new Customer();
        customer.setDefaultCard(null);
        assertNull(customer.getDefaultCard());
    }

    @Test
    public void testEmptyDefaultCard() {
        Customer customer = new Customer();
        customer.setDefaultCard("");
        assertEquals("", customer.getDefaultCard());
    }

    @Test
    public void testNullDescription() {
        Customer customer = new Customer();
        customer.setDescription(null);
        assertNull(customer.getDescription());
    }

    @Test
    public void testEmptyDescription() {
        Customer customer = new Customer();
        customer.setDescription("");
        assertEquals("", customer.getDescription());
    }

    @Test
    public void testNullEmail() {
        Customer customer = new Customer();
        customer.setEmail(null);
        assertNull(customer.getEmail());
    }

    @Test
    public void testEmptyEmail() {
        Customer customer = new Customer();
        customer.setEmail("");
        assertEquals("", customer.getEmail());
    }

    @Test
    public void testNullLocation() {
        Customer customer = new Customer();
        customer.setLocation(null);
        assertNull(customer.getLocation());
    }

    @Test
    public void testNullMetadata() {
        Customer customer = new Customer();
        customer.setMetadata(null);
        assertNull(customer.getMetadata());
    }

    @Test
    public void testEmptyMetadata() {
        Customer customer = new Customer();
        Map<String, Object> emptyMap = new HashMap<>();
        customer.setMetadata(emptyMap);
        assertEquals(emptyMap, customer.getMetadata());
    }

    // DeleteRequestBuilder tests
    @Test
    public void testDeleteRequestBuilder() throws Exception {
        Customer.DeleteRequestBuilder builder = new Customer.DeleteRequestBuilder("cust_test_123");
        
        assertEquals("DELETE", builder.method());
        assertTrue(builder.path().toString().contains("customers/cust_test_123"));
        assertNotNull(builder.type());
    }

    // GetRequestBuilder tests
    @Test
    public void testGetRequestBuilder() throws Exception {
        Customer.GetRequestBuilder builder = new Customer.GetRequestBuilder("cust_test_123");
        
        assertTrue(builder.path().toString().contains("customers/cust_test_123"));
        assertNotNull(builder.type());
    }

    // UpdateRequestBuilder tests
    @Test
    public void testUpdateRequestBuilderCard() throws Exception {
        Customer.UpdateRequestBuilder builder = new Customer.UpdateRequestBuilder("cust_test_123");
        
        builder.card("card_test_456");
        
        assertEquals("PATCH", builder.method());
        assertTrue(builder.path().toString().contains("customers/cust_test_123"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderDefaultCard() throws Exception {
        Customer.UpdateRequestBuilder builder = new Customer.UpdateRequestBuilder("cust_test_123");
        
        builder.defaultCard("card_test_789");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderDescription() throws Exception {
        Customer.UpdateRequestBuilder builder = new Customer.UpdateRequestBuilder("cust_test_123");
        
        builder.description("Updated customer description");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderEmail() throws Exception {
        Customer.UpdateRequestBuilder builder = new Customer.UpdateRequestBuilder("cust_test_123");
        
        builder.email("updated@example.com");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderMetadata() throws Exception {
        Customer.UpdateRequestBuilder builder = new Customer.UpdateRequestBuilder("cust_test_123");
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("updated", true);
        
        builder.metadata(metadata);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderMetadataKeyValue() throws Exception {
        Customer.UpdateRequestBuilder builder = new Customer.UpdateRequestBuilder("cust_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", 123);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderLinkedAccount() throws Exception {
        Customer.UpdateRequestBuilder builder = new Customer.UpdateRequestBuilder("cust_test_123");
        
        builder.linkedAccount("acct_test_456");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderChaining() throws Exception {
        Customer.UpdateRequestBuilder builder = new Customer.UpdateRequestBuilder("cust_test_123");
        
        builder
            .card("card_test_111")
            .defaultCard("card_test_111")
            .email("chain@example.com")
            .description("Chained updates")
            .linkedAccount("acct_test_222")
            .metadata("tier", "platinum")
            .metadata("points", 2000);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderWithNullMetadataKeyValue() throws Exception {
        Customer.UpdateRequestBuilder builder = new Customer.UpdateRequestBuilder("cust_test_123");
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", null);
        
        assertNotNull(builder.payload());
    }

    // ListRequestBuilder tests
    @Test
    public void testListRequestBuilder() throws Exception {
        Customer.ListRequestBuilder builder = new Customer.ListRequestBuilder();
        
        assertTrue(builder.path().toString().contains("customers"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithOptions() throws Exception {
        Customer.ListRequestBuilder builder = new Customer.ListRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // CreateRequestBuilder tests
    @Test
    public void testCreateRequestBuilderCard() throws Exception {
        Customer.CreateRequestBuilder builder = new Customer.CreateRequestBuilder();
        
        builder.card("card_test_123");
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("customers"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderDescription() throws Exception {
        Customer.CreateRequestBuilder builder = new Customer.CreateRequestBuilder();
        
        builder.description("New customer description");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderEmail() throws Exception {
        Customer.CreateRequestBuilder builder = new Customer.CreateRequestBuilder();
        
        builder.email("create@example.com");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderMetadata() throws Exception {
        Customer.CreateRequestBuilder builder = new Customer.CreateRequestBuilder();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("created", true);
        
        builder.metadata(metadata);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderMetadataKeyValue() throws Exception {
        Customer.CreateRequestBuilder builder = new Customer.CreateRequestBuilder();
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", 456);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderLinkedAccount() throws Exception {
        Customer.CreateRequestBuilder builder = new Customer.CreateRequestBuilder();
        
        builder.linkedAccount("acct_test_789");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderChaining() throws Exception {
        Customer.CreateRequestBuilder builder = new Customer.CreateRequestBuilder();
        
        builder
            .card("card_test_333")
            .email("newcustomer@example.com")
            .description("Brand new customer")
            .linkedAccount("acct_test_444")
            .metadata("source", "website")
            .metadata("campaign", "summer2024");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderWithNullMetadataKeyValue() throws Exception {
        Customer.CreateRequestBuilder builder = new Customer.CreateRequestBuilder();
        
        builder.metadata("key1", "value1");
        builder.metadata("key2", null);
        
        assertNotNull(builder.payload());
    }

    // ListSchedulesRequestBuilder tests
    @Test
    public void testListSchedulesRequestBuilder() throws Exception {
        Customer.ListSchedulesRequestBuilder builder = new Customer.ListSchedulesRequestBuilder("cust_test_123");
        
        assertTrue(builder.path().toString().contains("customers/cust_test_123/schedules"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListSchedulesRequestBuilderWithOptions() throws Exception {
        Customer.ListSchedulesRequestBuilder builder = new Customer.ListSchedulesRequestBuilder("cust_test_123");
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // Complex metadata tests
    @Test
    public void testComplexMetadata() {
        Customer customer = new Customer();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("string", "value");
        metadata.put("integer", 123);
        metadata.put("boolean", true);
        metadata.put("null_value", null);
        
        customer.setMetadata(metadata);
        
        assertEquals(4, customer.getMetadata().size());
        assertEquals("value", customer.getMetadata().get("string"));
        assertEquals(123, customer.getMetadata().get("integer"));
        assertEquals(true, customer.getMetadata().get("boolean"));
        assertNull(customer.getMetadata().get("null_value"));
    }
}
