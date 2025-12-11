package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChainTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetEmail() {
        Chain chain = new Chain();
        String email = "chain@example.com";
        chain.setEmail(email);
        assertEquals(email, chain.getEmail());
    }

    @Test
    public void testGetSetKey() {
        Chain chain = new Chain();
        String key = "pkey_test_123abc";
        chain.setKey(key);
        assertEquals(key, chain.getKey());
    }

    @Test
    public void testGetSetLocation() {
        Chain chain = new Chain();
        String location = "https://api.omise.co/chains/acch_test";
        chain.setLocation(location);
        assertEquals(location, chain.getLocation());
    }

    @Test
    public void testGetSetRevoked() {
        Chain chain = new Chain();
        chain.setRevoked(true);
        assertTrue(chain.isRevoked());
        
        chain.setRevoked(false);
        assertFalse(chain.isRevoked());
    }

    // Edge case tests
    @Test
    public void testNullEmail() {
        Chain chain = new Chain();
        chain.setEmail(null);
        assertNull(chain.getEmail());
    }

    @Test
    public void testEmptyEmail() {
        Chain chain = new Chain();
        chain.setEmail("");
        assertEquals("", chain.getEmail());
    }

    @Test
    public void testNullKey() {
        Chain chain = new Chain();
        chain.setKey(null);
        assertNull(chain.getKey());
    }

    @Test
    public void testEmptyKey() {
        Chain chain = new Chain();
        chain.setKey("");
        assertEquals("", chain.getKey());
    }

    @Test
    public void testNullLocation() {
        Chain chain = new Chain();
        chain.setLocation(null);
        assertNull(chain.getLocation());
    }

    @Test
    public void testEmptyLocation() {
        Chain chain = new Chain();
        chain.setLocation("");
        assertEquals("", chain.getLocation());
    }

    // ListRequestBuilder tests
    @Test
    public void testListRequestBuilder() throws Exception {
        Chain.ListRequestBuilder builder = new Chain.ListRequestBuilder();
        
        assertTrue(builder.path().toString().contains("chains"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithOptions() throws Exception {
        Chain.ListRequestBuilder builder = new Chain.ListRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // GetRequestBuilder tests
    @Test
    public void testGetRequestBuilder() throws Exception {
        Chain.GetRequestBuilder builder = new Chain.GetRequestBuilder("acch_test_123");
        
        assertTrue(builder.path().toString().contains("chains/acch_test_123"));
        assertNotNull(builder.type());
    }

    // RevokeRequestBuilder tests
    @Test
    public void testRevokeRequestBuilder() throws Exception {
        Chain.RevokeRequestBuilder builder = new Chain.RevokeRequestBuilder("acch_test_123");
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("chains/acch_test_123/revoke"));
        assertNotNull(builder.type());
    }

    // Various email formats
    @Test
    public void testValidEmailFormats() {
        Chain chain = new Chain();
        
        // Simple email
        chain.setEmail("user@example.com");
        assertEquals("user@example.com", chain.getEmail());
        
        // Email with subdomain
        chain.setEmail("user@mail.example.com");
        assertEquals("user@mail.example.com", chain.getEmail());
        
        // Email with plus
        chain.setEmail("user+tag@example.com");
        assertEquals("user+tag@example.com", chain.getEmail());
    }

    // Key format tests
    @Test
    public void testPublicKeyFormat() {
        Chain chain = new Chain();
        chain.setKey("pkey_test_5xyz7890abcdefgh");
        assertEquals("pkey_test_5xyz7890abcdefgh", chain.getKey());
    }

    @Test
    public void testLivePublicKeyFormat() {
        Chain chain = new Chain();
        chain.setKey("pkey_live_5abc1234567890de");
        assertEquals("pkey_live_5abc1234567890de", chain.getKey());
    }

    // Revoked state transitions
    @Test
    public void testRevokedStateTransition() {
        Chain chain = new Chain();
        
        // Initially not revoked
        chain.setRevoked(false);
        assertFalse(chain.isRevoked());
        
        // Revoke the chain
        chain.setRevoked(true);
        assertTrue(chain.isRevoked());
        
        // Cannot un-revoke (but setter allows it)
        chain.setRevoked(false);
        assertFalse(chain.isRevoked());
    }

    // Long key test
    @Test
    public void testLongKey() {
        Chain chain = new Chain();
        StringBuilder sb = new StringBuilder("pkey_");
        for (int i = 0; i < 100; i++) {
            sb.append("a");
        }
        String longKey = sb.toString();
        chain.setKey(longKey);
        assertEquals(longKey, chain.getKey());
    }

    // Location URL tests
    @Test
    public void testLocationUrl() {
        Chain chain = new Chain();
        
        // Standard location
        chain.setLocation("https://api.omise.co/chains/acch_test_123");
        assertTrue(chain.getLocation().startsWith("https://"));
        assertTrue(chain.getLocation().contains("chains"));
    }

    @Test
    public void testLocationWithQueryParams() {
        Chain chain = new Chain();
        chain.setLocation("https://api.omise.co/chains/acch_test_123?expand=true");
        assertTrue(chain.getLocation().contains("?expand=true"));
    }
}
