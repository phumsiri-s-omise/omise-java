package co.omise.requests;

import co.omise.models.Document;
import co.omise.models.OmiseException;
import co.omise.models.ScopedList;
import org.junit.Test;

import java.io.IOException;

public class DocumentRequestTest extends RequestTest {
    private static final String DISPUTE_ID = "dspt_test_5089off452g5m5te7xs";
    private static final String DOCUMENT_ID = "docu_test_5089off452g5m5te7xs";

    @Test
    public void testList() throws IOException, OmiseException {
        Request<ScopedList<Document>> request = new Document.ListRequestBuilder(DISPUTE_ID)
                .build();
        ScopedList<Document> list = getTestRequester().sendRequest(request);
        assertRequested("GET", "/disputes/" + DISPUTE_ID + "/documents", 200);

        assertEquals(20, list.getLimit());
        assertEquals(2, list.getTotal());

        Document document = list.getData().get(0);
        assertEquals(DOCUMENT_ID, document.getId());
        assertEquals("evidence.pdf", document.getFilename());
        assertNotNull(document.getDownloadUri());
    }

    @Test
    public void testListWithOptions() throws IOException, OmiseException {
        ScopedList.Options options = new ScopedList.Options()
                .limit(10)
                .offset(5);
        
        Request<ScopedList<Document>> request = new Document.ListRequestBuilder(DISPUTE_ID)
                .options(options)
                .build();
        ScopedList<Document> list = getTestRequester().sendRequest(request);
        assertRequested("GET", "/disputes/" + DISPUTE_ID + "/documents", 200);
        assertEquals(2, list.getTotal());
    }

    @Test
    public void testGet() throws IOException, OmiseException {
        Request<Document> request = new Document.GetRequestBuilder(DISPUTE_ID, DOCUMENT_ID)
                .build();
        Document document = getTestRequester().sendRequest(request);
        assertRequested("GET", "/disputes/" + DISPUTE_ID + "/documents/" + DOCUMENT_ID, 200);

        assertEquals(DOCUMENT_ID, document.getId());
        assertEquals("evidence.pdf", document.getFilename());
        assertEquals("/disputes/dspt_test_5089off452g5m5te7xs/documents/docu_test_5089off452g5m5te7xs", 
                     document.getLocation());
        assertTrue(document.getDownloadUri().contains("evidence.pdf"));
    }

    @Test
    public void testCreate() throws IOException, OmiseException {
        Request<Document> request = new Document.CreateRequestBuilder(DISPUTE_ID)
                .file("evidence.pdf")
                .build();
        Document document = getTestRequester().sendRequest(request);
        assertRequested("POST", "/disputes/" + DISPUTE_ID + "/documents", 200);

        assertEquals(DOCUMENT_ID, document.getId());
        assertEquals("evidence.pdf", document.getFilename());
    }

    @Test
    public void testDelete() throws IOException, OmiseException {
        Request<Document> request = new Document.DeleteRequestBuilder(DISPUTE_ID, DOCUMENT_ID)
                .build();
        Document document = getTestRequester().sendRequest(request);
        assertRequested("DELETE", "/disputes/" + DISPUTE_ID + "/documents/" + DOCUMENT_ID, 200);
        
        assertEquals(DOCUMENT_ID, document.getId());
        assertTrue(document.isDeleted());
    }

    @Test
    public void testDocumentGettersAndSetters() {
        Document document = new Document();
        
        // Test all setters
        document.setDownloadUri("https://example.com/download/file.pdf");
        document.setFilename("test-document.pdf");
        document.setLocation("/disputes/test/documents/test");
        
        // Test all getters
        assertEquals("https://example.com/download/file.pdf", document.getDownloadUri());
        assertEquals("test-document.pdf", document.getFilename());
        assertEquals("/disputes/test/documents/test", document.getLocation());
    }
}

