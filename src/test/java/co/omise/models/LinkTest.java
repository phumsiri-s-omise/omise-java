package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class LinkTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetAmount() {
        Link link = new Link();
        long amount = 100000L;
        link.setAmount(amount);
        assertEquals(amount, link.getAmount());
    }

    @Test
    public void testGetSetCharges() {
        Link link = new Link();
        ScopedList<Charge> charges = new ScopedList<>();
        link.setCharges(charges);
        assertEquals(charges, link.getCharges());
    }

    @Test
    public void testGetSetCurrency() {
        Link link = new Link();
        String currency = "THB";
        link.setCurrency(currency);
        assertEquals(currency, link.getCurrency());
    }

    @Test
    public void testGetSetDescription() {
        Link link = new Link();
        String description = "Payment link for order #123";
        link.setDescription(description);
        assertEquals(description, link.getDescription());
    }

    @Test
    public void testGetSetLocation() {
        Link link = new Link();
        String location = "https://api.omise.co/links/link_test";
        link.setLocation(location);
        assertEquals(location, link.getLocation());
    }

    @Test
    public void testGetSetMultiple() {
        Link link = new Link();
        link.setMultiple(true);
        assertTrue(link.isMultiple());
        
        link.setMultiple(false);
        assertFalse(link.isMultiple());
    }

    @Test
    public void testGetSetPaymentUri() {
        Link link = new Link();
        String paymentUri = "https://pay.omise.co/link_test";
        link.setPaymentUri(paymentUri);
        assertEquals(paymentUri, link.getPaymentUri());
    }

    @Test
    public void testGetSetTitle() {
        Link link = new Link();
        String title = "Order Payment";
        link.setTitle(title);
        assertEquals(title, link.getTitle());
    }

    @Test
    public void testGetSetUsed() {
        Link link = new Link();
        link.setUsed(true);
        assertTrue(link.isUsed());
        
        link.setUsed(false);
        assertFalse(link.isUsed());
    }

    @Test
    public void testGetSetUsedAt() {
        Link link = new Link();
        ZonedDateTime now = ZonedDateTime.now();
        link.setUsedAt(now);
        assertEquals(now, link.getUsedAt());
    }

    // Edge case tests
    @Test
    public void testZeroAmount() {
        Link link = new Link();
        link.setAmount(0L);
        assertEquals(0L, link.getAmount());
    }

    @Test
    public void testNullCharges() {
        Link link = new Link();
        link.setCharges(null);
        assertNull(link.getCharges());
    }

    @Test
    public void testNullCurrency() {
        Link link = new Link();
        link.setCurrency(null);
        assertNull(link.getCurrency());
    }

    @Test
    public void testEmptyCurrency() {
        Link link = new Link();
        link.setCurrency("");
        assertEquals("", link.getCurrency());
    }

    @Test
    public void testNullDescription() {
        Link link = new Link();
        link.setDescription(null);
        assertNull(link.getDescription());
    }

    @Test
    public void testEmptyDescription() {
        Link link = new Link();
        link.setDescription("");
        assertEquals("", link.getDescription());
    }

    @Test
    public void testNullLocation() {
        Link link = new Link();
        link.setLocation(null);
        assertNull(link.getLocation());
    }

    @Test
    public void testNullPaymentUri() {
        Link link = new Link();
        link.setPaymentUri(null);
        assertNull(link.getPaymentUri());
    }

    @Test
    public void testEmptyPaymentUri() {
        Link link = new Link();
        link.setPaymentUri("");
        assertEquals("", link.getPaymentUri());
    }

    @Test
    public void testNullTitle() {
        Link link = new Link();
        link.setTitle(null);
        assertNull(link.getTitle());
    }

    @Test
    public void testEmptyTitle() {
        Link link = new Link();
        link.setTitle("");
        assertEquals("", link.getTitle());
    }

    @Test
    public void testNullUsedAt() {
        Link link = new Link();
        link.setUsedAt(null);
        assertNull(link.getUsedAt());
    }

    // DeleteRequestBuilder tests
    @Test
    public void testDeleteRequestBuilder() throws Exception {
        Link.DeleteRequestBuilder builder = new Link.DeleteRequestBuilder("link_test_123");
        
        assertEquals("DELETE", builder.method());
        assertTrue(builder.path().toString().contains("links/link_test_123"));
        assertNotNull(builder.type());
    }

    // GetRequestBuilder tests
    @Test
    public void testGetRequestBuilder() throws Exception {
        Link.GetRequestBuilder builder = new Link.GetRequestBuilder("link_test_123");
        
        assertTrue(builder.path().toString().contains("links/link_test_123"));
        assertNotNull(builder.type());
    }

    // ListRequestBuilder tests
    @Test
    public void testListRequestBuilder() throws Exception {
        Link.ListRequestBuilder builder = new Link.ListRequestBuilder();
        
        assertTrue(builder.path().toString().contains("links"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithOptions() throws Exception {
        Link.ListRequestBuilder builder = new Link.ListRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // CreateRequestBuilder tests
    @Test
    public void testCreateRequestBuilderAmount() throws Exception {
        Link.CreateRequestBuilder builder = new Link.CreateRequestBuilder();
        
        builder.amount(50000L);
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("links"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderCurrency() throws Exception {
        Link.CreateRequestBuilder builder = new Link.CreateRequestBuilder();
        
        builder.currency("THB");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderDescription() throws Exception {
        Link.CreateRequestBuilder builder = new Link.CreateRequestBuilder();
        
        builder.description("Payment for services");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderMultiple() throws Exception {
        Link.CreateRequestBuilder builder = new Link.CreateRequestBuilder();
        
        builder.multiple(true);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderTitle() throws Exception {
        Link.CreateRequestBuilder builder = new Link.CreateRequestBuilder();
        
        builder.title("Service Payment");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderChaining() throws Exception {
        Link.CreateRequestBuilder builder = new Link.CreateRequestBuilder();
        
        builder
            .amount(100000L)
            .currency("THB")
            .title("Order #12345")
            .description("Payment for order")
            .multiple(false);
        
        assertNotNull(builder.payload());
    }

    // ListChargesRequestBuilder tests
    @Test
    public void testListChargesRequestBuilder() throws Exception {
        Link.ListChargesRequestBuilder builder = new Link.ListChargesRequestBuilder("link_test_123");
        
        assertTrue(builder.path().toString().contains("links/link_test_123/charges"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListChargesRequestBuilderWithOptions() throws Exception {
        Link.ListChargesRequestBuilder builder = new Link.ListChargesRequestBuilder("link_test_123");
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // Large amount test
    @Test
    public void testLargeAmount() {
        Link link = new Link();
        long largeAmount = Long.MAX_VALUE;
        link.setAmount(largeAmount);
        assertEquals(largeAmount, link.getAmount());
    }

    // Long description test
    @Test
    public void testLongDescription() {
        Link link = new Link();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            sb.append("a");
        }
        String longDescription = sb.toString();
        link.setDescription(longDescription);
        assertEquals(longDescription, link.getDescription());
    }
}
