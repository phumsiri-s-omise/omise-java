package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetDownloadUri() {
        Document document = new Document();
        String downloadUri = "https://api.omise.co/disputes/dspt_test/documents/docu_test/download";
        document.setDownloadUri(downloadUri);
        assertEquals(downloadUri, document.getDownloadUri());
    }

    @Test
    public void testGetSetFilename() {
        Document document = new Document();
        String filename = "invoice.pdf";
        document.setFilename(filename);
        assertEquals(filename, document.getFilename());
    }

    @Test
    public void testGetSetLocation() {
        Document document = new Document();
        String location = "https://api.omise.co/disputes/dspt_test/documents/docu_test";
        document.setLocation(location);
        assertEquals(location, document.getLocation());
    }

    // Edge case tests
    @Test
    public void testNullDownloadUri() {
        Document document = new Document();
        document.setDownloadUri(null);
        assertNull(document.getDownloadUri());
    }

    @Test
    public void testEmptyDownloadUri() {
        Document document = new Document();
        document.setDownloadUri("");
        assertEquals("", document.getDownloadUri());
    }

    @Test
    public void testNullFilename() {
        Document document = new Document();
        document.setFilename(null);
        assertNull(document.getFilename());
    }

    @Test
    public void testEmptyFilename() {
        Document document = new Document();
        document.setFilename("");
        assertEquals("", document.getFilename());
    }

    @Test
    public void testNullLocation() {
        Document document = new Document();
        document.setLocation(null);
        assertNull(document.getLocation());
    }

    @Test
    public void testEmptyLocation() {
        Document document = new Document();
        document.setLocation("");
        assertEquals("", document.getLocation());
    }

    // Various file types
    @Test
    public void testPdfFilename() {
        Document document = new Document();
        document.setFilename("document.pdf");
        assertEquals("document.pdf", document.getFilename());
    }

    @Test
    public void testJpgFilename() {
        Document document = new Document();
        document.setFilename("photo.jpg");
        assertEquals("photo.jpg", document.getFilename());
    }

    @Test
    public void testPngFilename() {
        Document document = new Document();
        document.setFilename("screenshot.png");
        assertEquals("screenshot.png", document.getFilename());
    }

    // DeleteRequestBuilder tests
    @Test
    public void testDeleteRequestBuilder() throws Exception {
        Document.DeleteRequestBuilder builder = new Document.DeleteRequestBuilder("dspt_test_123", "docu_test_456");
        
        assertEquals("DELETE", builder.method());
        assertTrue(builder.path().toString().contains("disputes/dspt_test_123/documents/docu_test_456"));
        assertNotNull(builder.type());
    }

    // GetRequestBuilder tests
    @Test
    public void testGetRequestBuilder() throws Exception {
        Document.GetRequestBuilder builder = new Document.GetRequestBuilder("dspt_test_123", "docu_test_456");
        
        assertTrue(builder.path().toString().contains("disputes/dspt_test_123/documents/docu_test_456"));
        assertNotNull(builder.type());
    }

    // ListRequestBuilder tests
    @Test
    public void testListRequestBuilder() throws Exception {
        Document.ListRequestBuilder builder = new Document.ListRequestBuilder("dspt_test_123");
        
        assertTrue(builder.path().toString().contains("disputes/dspt_test_123/documents"));
        assertNotNull(builder.type());
    }

    @Test
    public void testListRequestBuilderWithOptions() throws Exception {
        Document.ListRequestBuilder builder = new Document.ListRequestBuilder("dspt_test_123");
        ScopedList.Options options = new ScopedList.Options();
        
        builder.options(options);
        
        assertNotNull(builder.path());
        assertNotNull(builder.type());
    }

    // CreateRequestBuilder tests
    @Test
    public void testCreateRequestBuilderFile() throws Exception {
        Document.CreateRequestBuilder builder = new Document.CreateRequestBuilder("dspt_test_123");
        
        builder.file("file_data");
        
        assertEquals("POST", builder.method());
        assertTrue(builder.path().toString().contains("disputes/dspt_test_123/documents"));
        assertNotNull(builder.type());
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderNullFile() throws Exception {
        Document.CreateRequestBuilder builder = new Document.CreateRequestBuilder("dspt_test_123");
        
        builder.file(null);
        
        assertNotNull(builder.payload());
    }

    @Test
    public void testCreateRequestBuilderEmptyFile() throws Exception {
        Document.CreateRequestBuilder builder = new Document.CreateRequestBuilder("dspt_test_123");
        
        builder.file("");
        
        assertNotNull(builder.payload());
    }

    // Long filename test
    @Test
    public void testLongFilename() {
        Document document = new Document();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 255; i++) {
            sb.append("a");
        }
        String longFilename = sb.toString() + ".pdf";
        document.setFilename(longFilename);
        assertEquals(longFilename, document.getFilename());
    }

    // Special characters in filename
    @Test
    public void testFilenameWithSpaces() {
        Document document = new Document();
        document.setFilename("my document file.pdf");
        assertEquals("my document file.pdf", document.getFilename());
    }

    @Test
    public void testFilenameWithUnicode() {
        Document document = new Document();
        document.setFilename("文档.pdf");
        assertEquals("文档.pdf", document.getFilename());
    }
}
