package co.omise.requests;

import co.omise.models.Customer;
import co.omise.models.OmiseException;
import co.omise.models.ScopedList;
import co.omise.models.Card;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomerRequestTest extends RequestTest {
    private static final String CUSTOMER_ID = "cust_test_4yq6txdpfadhbaqnwp3";

    @Test
    public void testCreate() throws IOException, OmiseException {
        Request<Customer> request = new Customer.CreateRequestBuilder()
                .email("john.doe@example.com")
                .description("John Doe (id: 30)")
                .linkedAccount("acc_id")
                .build();

        Customer customer = getTestRequester().sendRequest(request);

        assertRequested("POST", "/customers", 200);
        assertRequestBody("{\"card\":null,\"description\":\"John Doe (id: 30)\",\"email\":\"john.doe@example.com\",\"metadata\":null,\"linked_account\":\"acc_id\"}");


        assertEquals("customer", customer.getObject());
        assertEquals(CUSTOMER_ID, customer.getId());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals("John Doe (id: 30)", customer.getDescription());
    }

    @Test
    public void testGet() throws IOException, OmiseException {
        Request<Customer> request = new Customer.GetRequestBuilder(CUSTOMER_ID).build();
        Customer customer = getTestRequester().sendRequest(request);

        assertRequested("GET", "/customers/" + CUSTOMER_ID, 200);

        assertEquals("customer", customer.getObject());
        assertEquals(CUSTOMER_ID, customer.getId());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals("John Doe (id: 30)", customer.getDescription());
    }

    @Test
    public void testUpdate() throws IOException, OmiseException {
        Request<Customer> request = new Customer.UpdateRequestBuilder(CUSTOMER_ID)
                .email("john.doe.the.second@example.com")
                .linkedAccount("acc_id")
                .build();
        Customer customer = getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/customers/" + CUSTOMER_ID, 200);
        assertRequestBody("{\"email\":\"john.doe.the.second@example.com\",\"linked_account\":\"acc_id\"}");

        assertEquals(CUSTOMER_ID, customer.getId());
        assertEquals("john.doe.the.second@example.com", customer.getEmail());
    }

    @Test
    public void testUpdateCardOnly() throws IOException, OmiseException {
        Request<Customer> request = new Customer.UpdateRequestBuilder(CUSTOMER_ID)
                .card("card123")
                .build();
        getTestRequester().sendRequest(request);

        assertRequested("PATCH", "/customers/" + CUSTOMER_ID, 200);
        assertRequestBody("{\"card\":\"card123\"}");
    }

    @Test
    public void testDestroy() throws IOException, OmiseException {
        Request<Customer> request = new Customer.DeleteRequestBuilder(CUSTOMER_ID).build();
        Customer customer = getTestRequester().sendRequest(request);

        assertRequested("DELETE", "/customers/" + CUSTOMER_ID, 200);

        assertEquals(CUSTOMER_ID, customer.getId());
        assertTrue(customer.isDeleted());
    }

    @Test
    public void testGetList() throws IOException, OmiseException {
        Request<ScopedList<Customer>> request = new Customer.ListRequestBuilder().build();
        ScopedList<Customer> list = getTestRequester().sendRequest(request);

        assertRequested("GET", "/customers", 200);

        assertEquals(1, list.getTotal());
        assertEquals(20, list.getLimit());

        Customer customer = list.getData().get(0);
        assertEquals("customer", customer.getObject());
        assertEquals(CUSTOMER_ID, customer.getId());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals("John Doe (id: 30)", customer.getDescription());
    }

    @Test
    public void testCreateWithMetadata() throws IOException, OmiseException {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("user_id", "12345");
        metadata.put("plan", "premium");
        
        Request<Customer> request = new Customer.CreateRequestBuilder()
                .email("test@example.com")
                .description("Test Customer")
                .metadata(metadata)
                .build();

        Customer customer = getTestRequester().sendRequest(request);
        assertRequested("POST", "/customers", 200);
        assertEquals(CUSTOMER_ID, customer.getId());
    }

    @Test
    public void testCreateWithMetadataKeyValue() throws IOException, OmiseException {
        Request<Customer> request = new Customer.CreateRequestBuilder()
                .email("test@example.com")
                .metadata("order_id", "ORD-123")
                .metadata("customer_type", "vip")
                .build();

        Customer customer = getTestRequester().sendRequest(request);
        assertRequested("POST", "/customers", 200);
        assertEquals(CUSTOMER_ID, customer.getId());
    }

    @Test
    public void testUpdateWithMetadata() throws IOException, OmiseException {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("updated", "true");
        
        Request<Customer> request = new Customer.UpdateRequestBuilder(CUSTOMER_ID)
                .metadata(metadata)
                .build();
        Customer customer = getTestRequester().sendRequest(request);
        assertRequested("PATCH", "/customers/" + CUSTOMER_ID, 200);
        assertEquals(CUSTOMER_ID, customer.getId());
    }

    @Test
    public void testUpdateWithMetadataKeyValue() throws IOException, OmiseException {
        Request<Customer> request = new Customer.UpdateRequestBuilder(CUSTOMER_ID)
                .metadata("status", "active")
                .build();
        Customer customer = getTestRequester().sendRequest(request);
        assertRequested("PATCH", "/customers/" + CUSTOMER_ID, 200);
        assertEquals(CUSTOMER_ID, customer.getId());
    }

    @Test
    public void testListWithOptions() throws IOException, OmiseException {
        ScopedList.Options options = new ScopedList.Options()
                .limit(10)
                .offset(5);
        
        Request<ScopedList<Customer>> request = new Customer.ListRequestBuilder()
                .options(options)
                .build();
        ScopedList<Customer> list = getTestRequester().sendRequest(request);
        assertRequested("GET", "/customers", 200);
        assertEquals(1, list.getTotal());
    }

    @Test
    public void testUpdateWithDescription() throws IOException, OmiseException {
        Request<Customer> request = new Customer.UpdateRequestBuilder(CUSTOMER_ID)
                .description("Updated Description")
                .build();
        Customer customer = getTestRequester().sendRequest(request);
        assertRequested("PATCH", "/customers/" + CUSTOMER_ID, 200);
        assertEquals(CUSTOMER_ID, customer.getId());
    }

    @Test
    public void testCustomerGettersAndSetters() {
        Customer customer = new Customer();
        
        // Test all setters
        ScopedList<Card> cards = new ScopedList<>();
        customer.setCards(cards);
        customer.setDefaultCard("card_test_123");
        customer.setDescription("Test Description");
        customer.setEmail("test@example.com");
        customer.setLocation("/customers/test");
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");
        customer.setMetadata(metadata);
        
        // Test all getters
        assertEquals(cards, customer.getCards());
        assertEquals("card_test_123", customer.getDefaultCard());
        assertEquals("Test Description", customer.getDescription());
        assertEquals("test@example.com", customer.getEmail());
        assertEquals("/customers/test", customer.getLocation());
        assertEquals(metadata, customer.getMetadata());
    }
}