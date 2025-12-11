package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Comprehensive unit tests for Export model
 * Focuses on increasing coverage for getters and setters
 */
public class ExportTest extends OmiseTest {

    @Test
    public void testDownloadUriGetterAndSetter() {
        Export export = new Export();
        export.setDownloadUri("https://example.com/exports/export_123.csv");
        assertEquals("https://example.com/exports/export_123.csv", export.getDownloadUri());
    }

    @Test
    public void testFileTypeGetterAndSetter() {
        Export export = new Export();
        export.setFileType("csv");
        assertEquals("csv", export.getFileType());
        
        export.setFileType("xlsx");
        assertEquals("xlsx", export.getFileType());
    }

    @Test
    public void testFilterParamsGetterAndSetter() {
        Export export = new Export();
        Map<String, Object> filterParams = new HashMap<>();
        filterParams.put("from", "2023-01-01");
        filterParams.put("to", "2023-12-31");
        filterParams.put("status", "successful");
        
        export.setFilterParams(filterParams);
        
        assertNotNull(export.getFilterParams());
        assertEquals(3, export.getFilterParams().size());
        assertEquals("2023-01-01", export.getFilterParams().get("from"));
        assertEquals("2023-12-31", export.getFilterParams().get("to"));
        assertEquals("successful", export.getFilterParams().get("status"));
    }

    @Test
    public void testFilterTypeGetterAndSetter() {
        Export export = new Export();
        export.setFilterType("charge");
        assertEquals("charge", export.getFilterType());
        
        export.setFilterType("transaction");
        assertEquals("transaction", export.getFilterType());
    }

    @Test
    public void testLocationGetterAndSetter() {
        Export export = new Export();
        export.setLocation("/exports/expt_test_123");
        assertEquals("/exports/expt_test_123", export.getLocation());
    }

    @Test
    public void testNameGetterAndSetter() {
        Export export = new Export();
        export.setName("Monthly Charges Export");
        assertEquals("Monthly Charges Export", export.getName());
    }

    @Test
    public void testObjectTypeGetterAndSetter() {
        Export export = new Export();
        export.setObjectType("charge");
        assertEquals("charge", export.getObjectType());
        
        export.setObjectType("refund");
        assertEquals("refund", export.getObjectType());
    }

    @Test
    public void testRowsGetterAndSetter() {
        Export export = new Export();
        export.setRows(1500L);
        assertEquals(1500L, export.getRows());
    }

    @Test
    public void testStatusGetterAndSetter() {
        Export export = new Export();
        export.setStatus("pending");
        assertEquals("pending", export.getStatus());
        
        export.setStatus("completed");
        assertEquals("completed", export.getStatus());
        
        export.setStatus("failed");
        assertEquals("failed", export.getStatus());
    }

    @Test
    public void testTeamGetterAndSetter() {
        Export export = new Export();
        export.setTeam("team_test_123");
        assertEquals("team_test_123", export.getTeam());
    }

    @Test
    public void testExportWithAllFields() {
        Export export = new Export();
        
        // Set all fields
        export.setDownloadUri("https://example.com/exports/export_456.csv");
        export.setFileType("csv");
        
        Map<String, Object> filterParams = new HashMap<>();
        filterParams.put("from", "2024-01-01");
        filterParams.put("to", "2024-06-30");
        export.setFilterParams(filterParams);
        
        export.setFilterType("transaction");
        export.setLocation("/exports/expt_test_456");
        export.setName("H1 2024 Transactions");
        export.setObjectType("transaction");
        export.setRows(25000L);
        export.setStatus("completed");
        export.setTeam("team_test_456");
        
        // Verify all fields
        assertEquals("https://example.com/exports/export_456.csv", export.getDownloadUri());
        assertEquals("csv", export.getFileType());
        assertNotNull(export.getFilterParams());
        assertEquals(2, export.getFilterParams().size());
        assertEquals("2024-01-01", export.getFilterParams().get("from"));
        assertEquals("2024-06-30", export.getFilterParams().get("to"));
        assertEquals("transaction", export.getFilterType());
        assertEquals("/exports/expt_test_456", export.getLocation());
        assertEquals("H1 2024 Transactions", export.getName());
        assertEquals("transaction", export.getObjectType());
        assertEquals(25000L, export.getRows());
        assertEquals("completed", export.getStatus());
        assertEquals("team_test_456", export.getTeam());
    }

    @Test
    public void testExportWithNullValues() {
        Export export = new Export();
        
        // Test that getters return appropriate values when nothing is set
        assertNull(export.getDownloadUri());
        assertNull(export.getFileType());
        assertNull(export.getFilterParams());
        assertNull(export.getFilterType());
        assertNull(export.getLocation());
        assertNull(export.getName());
        assertNull(export.getObjectType());
        assertEquals(0L, export.getRows());
        assertNull(export.getStatus());
        assertNull(export.getTeam());
    }

    @Test
    public void testExportWithEmptyStrings() {
        Export export = new Export();
        
        export.setDownloadUri("");
        export.setFileType("");
        export.setFilterType("");
        export.setLocation("");
        export.setName("");
        export.setObjectType("");
        export.setStatus("");
        export.setTeam("");
        
        assertEquals("", export.getDownloadUri());
        assertEquals("", export.getFileType());
        assertEquals("", export.getFilterType());
        assertEquals("", export.getLocation());
        assertEquals("", export.getName());
        assertEquals("", export.getObjectType());
        assertEquals("", export.getStatus());
        assertEquals("", export.getTeam());
    }

    @Test
    public void testFilterParamsWithEmptyMap() {
        Export export = new Export();
        Map<String, Object> emptyMap = new HashMap<>();
        export.setFilterParams(emptyMap);
        
        assertNotNull(export.getFilterParams());
        assertEquals(0, export.getFilterParams().size());
    }

    @Test
    public void testFilterParamsWithComplexValues() {
        Export export = new Export();
        Map<String, Object> filterParams = new HashMap<>();
        
        // Test various data types in filter params
        filterParams.put("string", "test");
        filterParams.put("integer", 123);
        filterParams.put("boolean", true);
        filterParams.put("double", 45.67);
        filterParams.put("long", 999999999L);
        
        export.setFilterParams(filterParams);
        
        assertEquals("test", export.getFilterParams().get("string"));
        assertEquals(123, export.getFilterParams().get("integer"));
        assertEquals(true, export.getFilterParams().get("boolean"));
        assertEquals(45.67, export.getFilterParams().get("double"));
        assertEquals(999999999L, export.getFilterParams().get("long"));
    }

    @Test
    public void testRowsWithZeroValue() {
        Export export = new Export();
        export.setRows(0L);
        assertEquals(0L, export.getRows());
    }

    @Test
    public void testRowsWithLargeValue() {
        Export export = new Export();
        long largeValue = 999999999999L;
        export.setRows(largeValue);
        assertEquals(largeValue, export.getRows());
    }

    @Test
    public void testRowsWithNegativeValue() {
        Export export = new Export();
        // Test negative value (edge case, might not be realistic)
        export.setRows(-1L);
        assertEquals(-1L, export.getRows());
    }

    @Test
    public void testMultipleFileTypes() {
        Export export = new Export();
        
        String[] fileTypes = {"csv", "xlsx", "json", "xml", "pdf"};
        
        for (String fileType : fileTypes) {
            export.setFileType(fileType);
            assertEquals(fileType, export.getFileType());
        }
    }

    @Test
    public void testMultipleObjectTypes() {
        Export export = new Export();
        
        String[] objectTypes = {"charge", "refund", "transfer", "customer", "transaction"};
        
        for (String objectType : objectTypes) {
            export.setObjectType(objectType);
            assertEquals(objectType, export.getObjectType());
        }
    }

    @Test
    public void testMultipleStatuses() {
        Export export = new Export();
        
        String[] statuses = {"pending", "processing", "completed", "failed", "expired"};
        
        for (String status : statuses) {
            export.setStatus(status);
            assertEquals(status, export.getStatus());
        }
    }

    @Test
    public void testDownloadUriWithDifferentProtocols() {
        Export export = new Export();
        
        export.setDownloadUri("https://secure.example.com/export.csv");
        assertEquals("https://secure.example.com/export.csv", export.getDownloadUri());
        
        export.setDownloadUri("http://example.com/export.csv");
        assertEquals("http://example.com/export.csv", export.getDownloadUri());
        
        export.setDownloadUri("s3://bucket/export.csv");
        assertEquals("s3://bucket/export.csv", export.getDownloadUri());
    }

    @Test
    public void testFilterParamsWithNestedStructure() {
        Export export = new Export();
        Map<String, Object> filterParams = new HashMap<>();
        
        Map<String, String> dateRange = new HashMap<>();
        dateRange.put("from", "2024-01-01");
        dateRange.put("to", "2024-12-31");
        
        filterParams.put("date_range", dateRange);
        filterParams.put("currency", "THB");
        filterParams.put("min_amount", 100000);
        
        export.setFilterParams(filterParams);
        
        assertEquals(3, export.getFilterParams().size());
        assertTrue(export.getFilterParams().get("date_range") instanceof Map);
        assertEquals("THB", export.getFilterParams().get("currency"));
        assertEquals(100000, export.getFilterParams().get("min_amount"));
    }

    @Test
    public void testSetAndGetSequence() {
        Export export = new Export();
        
        // Test setting values in different order
        export.setRows(1000L);
        export.setName("Test Export");
        export.setStatus("pending");
        
        assertEquals(1000L, export.getRows());
        assertEquals("Test Export", export.getName());
        assertEquals("pending", export.getStatus());
        
        // Change values
        export.setRows(2000L);
        export.setName("Updated Export");
        export.setStatus("completed");
        
        assertEquals(2000L, export.getRows());
        assertEquals("Updated Export", export.getName());
        assertEquals("completed", export.getStatus());
    }

    @Test
    public void testExportWithLongName() {
        Export export = new Export();
        String longName = "This is a very long export name that might contain multiple words and special characters like numbers 123 and symbols !@#$%";
        export.setName(longName);
        assertEquals(longName, export.getName());
    }

    @Test
    public void testExportWithSpecialCharactersInName() {
        Export export = new Export();
        
        export.setName("Export with émojis 🎉 and ünïcödé");
        assertEquals("Export with émojis 🎉 and ünïcödé", export.getName());
    }

    @Test
    public void testLocationWithVariousFormats() {
        Export export = new Export();
        
        export.setLocation("/exports/expt_test_123");
        assertEquals("/exports/expt_test_123", export.getLocation());
        
        export.setLocation("/api/v1/exports/expt_test_456");
        assertEquals("/api/v1/exports/expt_test_456", export.getLocation());
        
        export.setLocation("exports/expt_test_789");
        assertEquals("exports/expt_test_789", export.getLocation());
    }

    @Test
    public void testFilterTypeVariations() {
        Export export = new Export();
        
        String[] filterTypes = {
            "charge",
            "refund", 
            "customer",
            "transaction",
            "transfer",
            "recipient",
            "dispute",
            "event"
        };
        
        for (String filterType : filterTypes) {
            export.setFilterType(filterType);
            assertEquals(filterType, export.getFilterType());
        }
    }

    @Test
    public void testTeamWithDifferentFormats() {
        Export export = new Export();
        
        export.setTeam("team_test_123");
        assertEquals("team_test_123", export.getTeam());
        
        export.setTeam("TEAM123");
        assertEquals("TEAM123", export.getTeam());
        
        export.setTeam("team-with-dashes");
        assertEquals("team-with-dashes", export.getTeam());
    }

    @Test
    public void testResetValues() {
        Export export = new Export();
        
        // Set initial values
        export.setName("Initial Name");
        export.setStatus("pending");
        export.setRows(100L);
        
        assertEquals("Initial Name", export.getName());
        assertEquals("pending", export.getStatus());
        assertEquals(100L, export.getRows());
        
        // Reset to null/zero
        export.setName(null);
        export.setStatus(null);
        export.setRows(0L);
        
        assertNull(export.getName());
        assertNull(export.getStatus());
        assertEquals(0L, export.getRows());
    }

    @Test
    public void testFilterParamsOverwrite() {
        Export export = new Export();
        
        // Set initial filter params
        Map<String, Object> params1 = new HashMap<>();
        params1.put("key1", "value1");
        export.setFilterParams(params1);
        assertEquals(1, export.getFilterParams().size());
        
        // Overwrite with new params
        Map<String, Object> params2 = new HashMap<>();
        params2.put("key2", "value2");
        params2.put("key3", "value3");
        export.setFilterParams(params2);
        
        assertEquals(2, export.getFilterParams().size());
        assertNull(export.getFilterParams().get("key1"));
        assertEquals("value2", export.getFilterParams().get("key2"));
        assertEquals("value3", export.getFilterParams().get("key3"));
    }
}
