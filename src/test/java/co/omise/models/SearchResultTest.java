package co.omise.models;

import co.omise.OmiseTest;
import co.omise.Serializer;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Comprehensive unit tests for SearchResult model
 * Focuses on increasing coverage for getters, setters, and Options builder
 */
public class SearchResultTest extends OmiseTest {

    @Test
    public void testScopeGetterAndSetter() {
        SearchResult<Charge> result = new SearchResult<>();
        result.setScope(SearchScope.Charge);
        assertEquals(SearchScope.Charge, result.getScope());
    }

    @Test
    public void testQueryGetterAndSetter() {
        SearchResult<Charge> result = new SearchResult<>();
        result.setQuery("test query");
        assertEquals("test query", result.getQuery());
    }

    @Test
    public void testFiltersGetterAndSetter() {
        SearchResult<Charge> result = new SearchResult<>();
        Map<String, String> filters = new HashMap<>();
        filters.put("status", "successful");
        filters.put("amount", "100000");
        
        result.setFilters(filters);
        
        assertNotNull(result.getFilters());
        assertEquals(2, result.getFilters().size());
        assertEquals("successful", result.getFilters().get("status"));
        assertEquals("100000", result.getFilters().get("amount"));
    }

    @Test
    public void testPageGetterAndSetter() {
        SearchResult<Charge> result = new SearchResult<>();
        result.setPage(1);
        assertEquals(1, result.getPage());
        
        result.setPage(5);
        assertEquals(5, result.getPage());
    }

    @Test
    public void testTotalPagesGetterAndSetter() {
        SearchResult<Charge> result = new SearchResult<>();
        result.setTotalPages(10);
        assertEquals(10, result.getTotalPages());
    }

    @Test
    public void testSearchResultWithAllFields() {
        SearchResult<Charge> result = new SearchResult<>();
        
        Map<String, String> filters = new HashMap<>();
        filters.put("currency", "thb");
        filters.put("status", "successful");
        
        result.setScope(SearchScope.Charge);
        result.setQuery("amount:100000");
        result.setFilters(filters);
        result.setPage(2);
        result.setTotalPages(5);
        
        assertEquals(SearchScope.Charge, result.getScope());
        assertEquals("amount:100000", result.getQuery());
        assertEquals(2, result.getFilters().size());
        assertEquals("thb", result.getFilters().get("currency"));
        assertEquals("successful", result.getFilters().get("status"));
        assertEquals(2, result.getPage());
        assertEquals(5, result.getTotalPages());
    }

    @Test
    public void testSearchResultWithNullValues() {
        SearchResult<Charge> result = new SearchResult<>();
        
        assertNull(result.getScope());
        assertNull(result.getQuery());
        assertNull(result.getFilters());
        assertEquals(0, result.getPage());
        assertEquals(0, result.getTotalPages());
    }

    @Test
    public void testSearchResultWithEmptyStrings() {
        SearchResult<Charge> result = new SearchResult<>();
        result.setQuery("");
        assertEquals("", result.getQuery());
    }

    @Test
    public void testSearchResultWithEmptyFilters() {
        SearchResult<Charge> result = new SearchResult<>();
        Map<String, String> emptyFilters = new HashMap<>();
        result.setFilters(emptyFilters);
        
        assertNotNull(result.getFilters());
        assertEquals(0, result.getFilters().size());
    }

    @Test
    public void testSearchResultWithMultipleScopes() {
        SearchResult<Charge> chargeResult = new SearchResult<>();
        chargeResult.setScope(SearchScope.Charge);
        assertEquals(SearchScope.Charge, chargeResult.getScope());
        
        SearchResult<Customer> customerResult = new SearchResult<>();
        customerResult.setScope(SearchScope.Customer);
        assertEquals(SearchScope.Customer, customerResult.getScope());
        
        SearchResult<Refund> refundResult = new SearchResult<>();
        refundResult.setScope(SearchScope.Refund);
        assertEquals(SearchScope.Refund, refundResult.getScope());
    }

    @Test
    public void testOptionsScope() {
        SearchResult.Options options = new SearchResult.Options();
        SearchResult.Options result = options.scope(SearchScope.Charge);
        
        assertNotNull(result);
        assertEquals(options, result);
    }

    @Test
    public void testOptionsQuery() {
        SearchResult.Options options = new SearchResult.Options();
        SearchResult.Options result = options.query("test");
        
        assertNotNull(result);
        assertEquals(options, result);
    }

    @Test
    public void testOptionsFilter() {
        SearchResult.Options options = new SearchResult.Options();
        SearchResult.Options result = options.filter("status", "successful");
        
        assertNotNull(result);
        assertEquals(options, result);
    }

    @Test
    public void testOptionsFilterMultiple() {
        SearchResult.Options options = new SearchResult.Options();
        options.filter("status", "successful")
               .filter("currency", "thb")
               .filter("amount", "100000");
        
        assertNotNull(options);
    }

    @Test
    public void testOptionsFilters() {
        SearchResult.Options options = new SearchResult.Options();
        Map<String, String> filters = new HashMap<>();
        filters.put("status", "successful");
        filters.put("currency", "thb");
        
        SearchResult.Options result = options.filters(filters);
        
        assertNotNull(result);
        assertEquals(options, result);
    }

    @Test
    public void testOptionsOrder() {
        SearchResult.Options options = new SearchResult.Options();
        SearchResult.Options result = options.order(Ordering.Chronological);
        
        assertNotNull(result);
        assertEquals(options, result);
    }

    @Test
    public void testOptionsPage() {
        SearchResult.Options options = new SearchResult.Options();
        SearchResult.Options result = options.page(2);
        
        assertNotNull(result);
        assertEquals(options, result);
    }

    @Test
    public void testOptionsDataPerPage() {
        SearchResult.Options options = new SearchResult.Options();
        SearchResult.Options result = options.dataPerPage(50);
        
        assertNotNull(result);
        assertEquals(options, result);
    }

    @Test
    public void testOptionsChaining() {
        SearchResult.Options options = new SearchResult.Options();
        
        SearchResult.Options result = options
            .scope(SearchScope.Charge)
            .query("amount:100000")
            .filter("status", "successful")
            .filter("currency", "thb")
            .order(Ordering.ReverseChronological)
            .page(1)
            .dataPerPage(20);
        
        assertNotNull(result);
        assertEquals(options, result);
    }

    @Test
    public void testOptionsQueryWithSerializer() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge)
               .query("test")
               .filter("status", "successful")
               .order(Ordering.Chronological)
               .page(1)
               .dataPerPage(20);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertNotNull(queryMap);
        assertTrue(queryMap.containsKey("scope"));
        assertTrue(queryMap.containsKey("query"));
        assertTrue(queryMap.containsKey("filters[status]"));
        assertTrue(queryMap.containsKey("order"));
        assertTrue(queryMap.containsKey("page"));
        assertTrue(queryMap.containsKey("per_page"));
    }

    @Test
    public void testOptionsQueryWithNullSerializer() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Customer)
               .query("email:test@example.com")
               .page(2);
        
        Serializer nullSerializer = null;
        Map<String, String> queryMap = options.query(nullSerializer);
        
        assertNotNull(queryMap);
    }

    @Test
    public void testOptionsQueryWithEmptyQuery() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge)
               .query("")
               .page(1);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertNotNull(queryMap);
        assertFalse(queryMap.containsKey("query"));
    }

    @Test
    public void testOptionsQueryWithNullQuery() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge)
               .page(1);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertNotNull(queryMap);
        assertFalse(queryMap.containsKey("query"));
    }

    @Test
    public void testOptionsQueryWithNoFilters() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge)
               .query("test")
               .page(1);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertNotNull(queryMap);
        // Should not contain any filters[*] keys
        for (String key : queryMap.keySet()) {
            assertFalse(key.startsWith("filters["));
        }
    }

    @Test
    public void testOptionsQueryWithEmptyFilters() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge)
               .query("test")
               .filters(new HashMap<>())
               .page(1);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertNotNull(queryMap);
        // Should not contain any filters[*] keys
        for (String key : queryMap.keySet()) {
            assertFalse(key.startsWith("filters["));
        }
    }

    @Test
    public void testOptionsQueryWithZeroPage() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge)
               .page(0);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertNotNull(queryMap);
        assertFalse(queryMap.containsKey("page"));
    }

    @Test
    public void testOptionsQueryWithZeroDataPerPage() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge)
               .dataPerPage(0);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertNotNull(queryMap);
        assertFalse(queryMap.containsKey("per_page"));
    }

    @Test
    public void testOptionsQueryWithMultipleFilters() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge)
               .filter("status", "successful")
               .filter("currency", "thb")
               .filter("amount", "100000");
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertNotNull(queryMap);
        assertTrue(queryMap.containsKey("filters[status]"));
        assertTrue(queryMap.containsKey("filters[currency]"));
        assertTrue(queryMap.containsKey("filters[amount]"));
        assertEquals("successful", queryMap.get("filters[status]"));
        assertEquals("thb", queryMap.get("filters[currency]"));
        assertEquals("100000", queryMap.get("filters[amount]"));
    }

    @Test
    public void testOptionsBody() {
        SearchResult.Options options = new SearchResult.Options();
        assertNull(options.body(Serializer.defaultSerializer()));
        assertNull(options.body(null));
    }

    @Test
    public void testSearchRequestBuilder() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge).query("test");
        
        SearchResult.SearchRequestBuilder<Charge> builder = 
            new SearchResult.SearchRequestBuilder<>(options);
        
        assertNotNull(builder);
    }

    @Test
    public void testSearchRequestBuilderWithDifferentOptions() {
        SearchResult.Options options1 = new SearchResult.Options();
        options1.scope(SearchScope.Charge);
        
        SearchResult.Options options2 = new SearchResult.Options();
        options2.scope(SearchScope.Customer);
        
        SearchResult.Options options3 = new SearchResult.Options();
        options3.scope(SearchScope.Refund);
        
        SearchResult.SearchRequestBuilder<Charge> builder1 = 
            new SearchResult.SearchRequestBuilder<>(options1);
        SearchResult.SearchRequestBuilder<Customer> builder2 = 
            new SearchResult.SearchRequestBuilder<>(options2);
        SearchResult.SearchRequestBuilder<Refund> builder3 = 
            new SearchResult.SearchRequestBuilder<>(options3);
        
        assertNotNull(builder1);
        assertNotNull(builder2);
        assertNotNull(builder3);
    }

    @Test
    public void testPageNumberVariations() {
        SearchResult<Charge> result = new SearchResult<>();
        
        result.setPage(0);
        assertEquals(0, result.getPage());
        
        result.setPage(1);
        assertEquals(1, result.getPage());
        
        result.setPage(100);
        assertEquals(100, result.getPage());
        
        result.setPage(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, result.getPage());
    }

    @Test
    public void testTotalPagesVariations() {
        SearchResult<Charge> result = new SearchResult<>();
        
        result.setTotalPages(0);
        assertEquals(0, result.getTotalPages());
        
        result.setTotalPages(1);
        assertEquals(1, result.getTotalPages());
        
        result.setTotalPages(1000);
        assertEquals(1000, result.getTotalPages());
        
        result.setTotalPages(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, result.getTotalPages());
    }

    @Test
    public void testQueryWithSpecialCharacters() {
        SearchResult<Charge> result = new SearchResult<>();
        
        result.setQuery("amount:>100000");
        assertEquals("amount:>100000", result.getQuery());
        
        result.setQuery("email:test+tag@example.com");
        assertEquals("email:test+tag@example.com", result.getQuery());
        
        result.setQuery("description:\"Test Query\"");
        assertEquals("description:\"Test Query\"", result.getQuery());
    }

    @Test
    public void testFiltersWithVariousKeys() {
        SearchResult<Charge> result = new SearchResult<>();
        Map<String, String> filters = new HashMap<>();
        
        filters.put("status", "successful");
        filters.put("amount", "100000");
        filters.put("currency", "thb");
        filters.put("captured", "true");
        filters.put("paid", "true");
        
        result.setFilters(filters);
        
        assertEquals(5, result.getFilters().size());
        assertEquals("successful", result.getFilters().get("status"));
        assertEquals("100000", result.getFilters().get("amount"));
        assertEquals("thb", result.getFilters().get("currency"));
        assertEquals("true", result.getFilters().get("captured"));
        assertEquals("true", result.getFilters().get("paid"));
    }

    @Test
    public void testOptionsWithAllOrdering() {
        SearchResult.Options chronological = new SearchResult.Options();
        chronological.order(Ordering.Chronological);
        assertNotNull(chronological);
        
        SearchResult.Options reverseChronological = new SearchResult.Options();
        reverseChronological.order(Ordering.ReverseChronological);
        assertNotNull(reverseChronological);
    }

    @Test
    public void testOptionsQueryMapIsUnmodifiable() {
        SearchResult.Options options = new SearchResult.Options();
        options.scope(SearchScope.Charge).query("test").page(1);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertNotNull(queryMap);
        
        try {
            queryMap.put("new_key", "new_value");
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            // Expected - map should be unmodifiable
        }
    }

    @Test
    public void testSearchResultTypeSafety() {
        // Test with different generic types
        SearchResult<Charge> chargeResult = new SearchResult<>();
        chargeResult.setScope(SearchScope.Charge);
        assertNotNull(chargeResult);
        
        SearchResult<Customer> customerResult = new SearchResult<>();
        customerResult.setScope(SearchScope.Customer);
        assertNotNull(customerResult);
        
        SearchResult<Refund> refundResult = new SearchResult<>();
        refundResult.setScope(SearchScope.Refund);
        assertNotNull(refundResult);
        
        SearchResult<Transfer> transferResult = new SearchResult<>();
        transferResult.setScope(SearchScope.Transfer);
        assertNotNull(transferResult);
    }

    @Test
    public void testOptionsFilterWithNullFilters() {
        SearchResult.Options options = new SearchResult.Options();
        
        // First filter call with null filters should initialize and add
        SearchResult.Options result = options.filter("key1", "value1");
        assertNotNull(result);
        
        // Second filter call should work normally
        result = options.filter("key2", "value2");
        assertNotNull(result);
    }

    @Test
    public void testOptionsCompleteWorkflow() {
        // Simulate a complete search workflow
        SearchResult.Options options = new SearchResult.Options();
        
        // Build options
        options.scope(SearchScope.Charge)
               .query("amount:100000")
               .filter("status", "successful")
               .filter("currency", "thb")
               .filter("paid", "true")
               .order(Ordering.ReverseChronological)
               .page(1)
               .dataPerPage(20);
        
        // Generate query map
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        // Verify all parameters are present
        assertNotNull(queryMap);
        assertTrue(queryMap.size() >= 6);
        assertEquals("amount:100000", queryMap.get("query"));
        assertEquals("successful", queryMap.get("filters[status]"));
        assertEquals("thb", queryMap.get("filters[currency]"));
        assertEquals("true", queryMap.get("filters[paid]"));
        assertEquals("1", queryMap.get("page"));
        assertEquals("20", queryMap.get("per_page"));
        
        // Create builder
        SearchResult.SearchRequestBuilder<Charge> builder = 
            new SearchResult.SearchRequestBuilder<>(options);
        assertNotNull(builder);
    }

    @Test
    public void testResetValues() {
        SearchResult<Charge> result = new SearchResult<>();
        
        // Set values
        result.setScope(SearchScope.Charge);
        result.setQuery("test");
        result.setPage(5);
        result.setTotalPages(10);
        
        // Reset to null/zero
        result.setScope(null);
        result.setQuery(null);
        result.setPage(0);
        result.setTotalPages(0);
        
        assertNull(result.getScope());
        assertNull(result.getQuery());
        assertEquals(0, result.getPage());
        assertEquals(0, result.getTotalPages());
    }

    @Test
    public void testOptionsWithLargePageNumbers() {
        SearchResult.Options options = new SearchResult.Options();
        options.page(1000).dataPerPage(100);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        assertEquals("1000", queryMap.get("page"));
        assertEquals("100", queryMap.get("per_page"));
    }

    @Test
    public void testMultipleFilterUpdates() {
        SearchResult.Options options = new SearchResult.Options();
        
        // Add filters using filters() method
        Map<String, String> filters1 = new HashMap<>();
        filters1.put("status", "successful");
        options.filters(filters1);
        
        // Replace with new filters
        Map<String, String> filters2 = new HashMap<>();
        filters2.put("currency", "thb");
        filters2.put("amount", "100000");
        options.filters(filters2);
        
        Serializer serializer = Serializer.defaultSerializer();
        Map<String, String> queryMap = options.query(serializer);
        
        // Should have the new filters, not the old ones
        assertFalse(queryMap.containsKey("filters[status]"));
        assertTrue(queryMap.containsKey("filters[currency]"));
        assertTrue(queryMap.containsKey("filters[amount]"));
    }
}
