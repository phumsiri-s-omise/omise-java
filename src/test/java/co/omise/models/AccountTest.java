package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AccountTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetApiVersion() {
        Account account = new Account();
        String apiVersion = "2019-05-29";
        account.setApiVersion(apiVersion);
        assertEquals(apiVersion, account.getApiVersion());
    }

    @Test
    public void testGetSetAutoActivateRecipients() {
        Account account = new Account();
        account.setAutoActivateRecipients(true);
        assertTrue(account.isAutoActivateRecipients());
        
        account.setAutoActivateRecipients(false);
        assertFalse(account.isAutoActivateRecipients());
    }

    @Test
    public void testGetSetChainEnabled() {
        Account account = new Account();
        account.setChainEnabled(true);
        assertTrue(account.isChainEnabled());
        
        account.setChainEnabled(false);
        assertFalse(account.isChainEnabled());
    }

    @Test
    public void testGetSetChainReturnUri() {
        Account account = new Account();
        String chainReturnUri = "https://example.com/return";
        account.setChainReturnUri(chainReturnUri);
        assertEquals(chainReturnUri, account.getChainReturnUri());
    }

    @Test
    public void testGetSetCountry() {
        Account account = new Account();
        String country = "TH";
        account.setCountry(country);
        assertEquals(country, account.getCountry());
    }

    @Test
    public void testGetSetCurrency() {
        Account account = new Account();
        String currency = "THB";
        account.setCurrency(currency);
        assertEquals(currency, account.getCurrency());
    }

    @Test
    public void testGetSetEmail() {
        Account account = new Account();
        String email = "account@example.com";
        account.setEmail(email);
        assertEquals(email, account.getEmail());
    }

    @Test
    public void testGetSetLocation() {
        Account account = new Account();
        String location = "https://api.omise.co/account";
        account.setLocation(location);
        assertEquals(location, account.getLocation());
    }

    @Test
    public void testGetSetMetadataExportKeys() {
        Account account = new Account();
        Map<String, Object> metadataExportKeys = new HashMap<>();
        metadataExportKeys.put("key1", "value1");
        metadataExportKeys.put("key2", 123);
        account.setMetadataExportKeys(metadataExportKeys);
        assertEquals(metadataExportKeys, account.getMetadataExportKeys());
    }

    @Test
    public void testGetSetSupportedCurrencies() {
        Account account = new Account();
        List<String> currencies = new ArrayList<>();
        currencies.add("THB");
        currencies.add("USD");
        currencies.add("JPY");
        account.setSupportedCurrencies(currencies);
        assertEquals(currencies, account.getSupportedCurrencies());
    }

    @Test
    public void testGetSetTeamId() {
        Account account = new Account();
        String teamId = "team_test_123";
        account.setTeamId(teamId);
        assertEquals(teamId, account.getTeamId());
    }

    @Test
    public void testGetSetWebhookUri() {
        Account account = new Account();
        String webhookUri = "https://example.com/webhook";
        account.setWebhookUri(webhookUri);
        assertEquals(webhookUri, account.getWebhookUri());
    }

    @Test
    public void testGetSetZeroInterestInstallments() {
        Account account = new Account();
        account.setZeroInterestInstallments(true);
        assertTrue(account.isZeroInterestInstallments());
        
        account.setZeroInterestInstallments(false);
        assertFalse(account.isZeroInterestInstallments());
    }

    // Edge case tests
    @Test
    public void testNullApiVersion() {
        Account account = new Account();
        account.setApiVersion(null);
        assertNull(account.getApiVersion());
    }

    @Test
    public void testEmptyApiVersion() {
        Account account = new Account();
        account.setApiVersion("");
        assertEquals("", account.getApiVersion());
    }

    @Test
    public void testNullChainReturnUri() {
        Account account = new Account();
        account.setChainReturnUri(null);
        assertNull(account.getChainReturnUri());
    }

    @Test
    public void testEmptyChainReturnUri() {
        Account account = new Account();
        account.setChainReturnUri("");
        assertEquals("", account.getChainReturnUri());
    }

    @Test
    public void testNullCountry() {
        Account account = new Account();
        account.setCountry(null);
        assertNull(account.getCountry());
    }

    @Test
    public void testEmptyCountry() {
        Account account = new Account();
        account.setCountry("");
        assertEquals("", account.getCountry());
    }

    @Test
    public void testNullCurrency() {
        Account account = new Account();
        account.setCurrency(null);
        assertNull(account.getCurrency());
    }

    @Test
    public void testEmptyCurrency() {
        Account account = new Account();
        account.setCurrency("");
        assertEquals("", account.getCurrency());
    }

    @Test
    public void testNullEmail() {
        Account account = new Account();
        account.setEmail(null);
        assertNull(account.getEmail());
    }

    @Test
    public void testEmptyEmail() {
        Account account = new Account();
        account.setEmail("");
        assertEquals("", account.getEmail());
    }

    @Test
    public void testNullLocation() {
        Account account = new Account();
        account.setLocation(null);
        assertNull(account.getLocation());
    }

    @Test
    public void testNullMetadataExportKeys() {
        Account account = new Account();
        account.setMetadataExportKeys(null);
        assertNull(account.getMetadataExportKeys());
    }

    @Test
    public void testEmptyMetadataExportKeys() {
        Account account = new Account();
        Map<String, Object> emptyMap = new HashMap<>();
        account.setMetadataExportKeys(emptyMap);
        assertEquals(emptyMap, account.getMetadataExportKeys());
    }

    @Test
    public void testNullSupportedCurrencies() {
        Account account = new Account();
        account.setSupportedCurrencies(null);
        assertNull(account.getSupportedCurrencies());
    }

    @Test
    public void testEmptySupportedCurrencies() {
        Account account = new Account();
        List<String> emptyList = new ArrayList<>();
        account.setSupportedCurrencies(emptyList);
        assertEquals(emptyList, account.getSupportedCurrencies());
    }

    @Test
    public void testNullTeamId() {
        Account account = new Account();
        account.setTeamId(null);
        assertNull(account.getTeamId());
    }

    @Test
    public void testEmptyTeamId() {
        Account account = new Account();
        account.setTeamId("");
        assertEquals("", account.getTeamId());
    }

    @Test
    public void testNullWebhookUri() {
        Account account = new Account();
        account.setWebhookUri(null);
        assertNull(account.getWebhookUri());
    }

    @Test
    public void testEmptyWebhookUri() {
        Account account = new Account();
        account.setWebhookUri("");
        assertEquals("", account.getWebhookUri());
    }

    // GetRequestBuilder tests
    @Test
    public void testGetRequestBuilder() throws Exception {
        Account.GetRequestBuilder builder = new Account.GetRequestBuilder();
        
        assertTrue(builder.path().toString().contains("account"));
        assertNotNull(builder.type());
    }

    // UpdateRequestBuilder tests
    @Test
    public void testUpdateRequestBuilderChainEnabled() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        
        builder.chainEnabled(true);
        
        assertEquals("PATCH", builder.method());
        assertTrue(builder.path().toString().contains("account"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderChainReturnUri() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        
        builder.chainReturnUri("https://example.com/chain-return");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderMetadataExportKeys() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        Map<String, Object> metadataExportKeys = new HashMap<>();
        metadataExportKeys.put("export_key", "value");
        
        builder.metadataExportKeys(metadataExportKeys);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderWebhookUri() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        
        builder.webhookUri("https://example.com/updated-webhook");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderZeroInterestInstallments() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        
        builder.zeroInterestInstallments(true);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderChaining() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");
        
        builder
            .chainEnabled(true)
            .chainReturnUri("https://example.com/return")
            .webhookUri("https://example.com/webhook")
            .zeroInterestInstallments(true)
            .metadataExportKeys(metadata);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderAllFieldsFalse() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        
        builder
            .chainEnabled(false)
            .zeroInterestInstallments(false);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderNullValues() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        
        builder
            .chainReturnUri(null)
            .webhookUri(null)
            .metadataExportKeys(null);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderEmptyStrings() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        
        builder
            .chainReturnUri("")
            .webhookUri("");
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testUpdateRequestBuilderEmptyMetadata() throws Exception {
        Account.UpdateRequestBuilder builder = new Account.UpdateRequestBuilder();
        Map<String, Object> emptyMap = new HashMap<>();
        
        builder.metadataExportKeys(emptyMap);
        
        assertNotNull(builder.payload());
    }

    // Multiple currencies test
    @Test
    public void testMultipleSupportedCurrencies() {
        Account account = new Account();
        List<String> currencies = new ArrayList<>();
        currencies.add("THB");
        currencies.add("USD");
        currencies.add("JPY");
        currencies.add("EUR");
        currencies.add("GBP");
        currencies.add("SGD");
        currencies.add("MYR");
        
        account.setSupportedCurrencies(currencies);
        
        assertEquals(7, account.getSupportedCurrencies().size());
        assertTrue(account.getSupportedCurrencies().contains("THB"));
        assertTrue(account.getSupportedCurrencies().contains("USD"));
        assertTrue(account.getSupportedCurrencies().contains("EUR"));
    }

    // Complex metadata test
    @Test
    public void testComplexMetadataExportKeys() {
        Account account = new Account();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("string_key", "string_value");
        metadata.put("int_key", 123);
        metadata.put("boolean_key", true);
        metadata.put("null_key", null);
        
        account.setMetadataExportKeys(metadata);
        
        assertEquals(4, account.getMetadataExportKeys().size());
        assertEquals("string_value", account.getMetadataExportKeys().get("string_key"));
        assertEquals(123, account.getMetadataExportKeys().get("int_key"));
        assertEquals(true, account.getMetadataExportKeys().get("boolean_key"));
        assertNull(account.getMetadataExportKeys().get("null_key"));
    }
}
