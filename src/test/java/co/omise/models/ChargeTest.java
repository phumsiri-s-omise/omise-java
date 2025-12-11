package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Comprehensive unit tests for Charge model
 * Focuses on increasing coverage for getters and setters
 */
public class ChargeTest extends OmiseTest {

    @Test
    public void testAmountGetterAndSetter() {
        Charge charge = new Charge();
        charge.setAmount(100000L);
        assertEquals(100000L, charge.getAmount());
    }

    @Test
    public void testAuthorizeUriGetterAndSetter() {
        Charge charge = new Charge();
        charge.setAuthorizeUri("https://example.com/authorize");
        assertEquals("https://example.com/authorize", charge.getAuthorizeUri());
    }

    @Test
    public void testAuthorizedGetterAndSetter() {
        Charge charge = new Charge();
        charge.setAuthorized(true);
        assertTrue(charge.isAuthorized());
        
        charge.setAuthorized(false);
        assertFalse(charge.isAuthorized());
    }

    @Test
    public void testAuthenticationGetterAndSetter() {
        Charge charge = new Charge();
        charge.setAuthentication(AuthenticationType.PASSKEY);
        assertEquals(AuthenticationType.PASSKEY, charge.getAuthentication());
    }

    @Test
    public void testAuthenticatedByGetterAndSetter() {
        Charge charge = new Charge();
        charge.setAuthenticatedBy("PASSKEY");
        assertEquals("PASSKEY", charge.getAuthenticatedBy());
    }

    @Test
    public void testBranchGetterAndSetter() {
        Charge charge = new Charge();
        charge.setBranch("branch_001");
        assertEquals("branch_001", charge.getBranch());
    }

    @Test
    public void testCapturableGetterAndSetter() {
        Charge charge = new Charge();
        charge.setCapturable(true);
        assertTrue(charge.isCapturable());
        
        charge.setCapturable(false);
        assertFalse(charge.isCapturable());
    }

    @Test
    public void testCaptureGetterAndSetter() {
        Charge charge = new Charge();
        charge.setCapture(true);
        assertTrue(charge.isCapture());
        
        charge.setCapture(false);
        assertFalse(charge.isCapture());
    }

    @Test
    public void testCardGetterAndSetter() {
        Charge charge = new Charge();
        Card card = new Card();
        card.setId("card_test_123");
        charge.setCard(card);
        assertEquals("card_test_123", charge.getCard().getId());
    }

    @Test
    public void testCurrencyGetterAndSetter() {
        Charge charge = new Charge();
        charge.setCurrency("THB");
        assertEquals("THB", charge.getCurrency());
    }

    @Test
    public void testCustomerGetterAndSetter() {
        Charge charge = new Charge();
        charge.setCustomer("cust_test_123");
        assertEquals("cust_test_123", charge.getCustomer());
    }

    @Test
    public void testDescriptionGetterAndSetter() {
        Charge charge = new Charge();
        charge.setDescription("Test charge description");
        assertEquals("Test charge description", charge.getDescription());
    }

    @Test
    public void testDeviceGetterAndSetter() {
        Charge charge = new Charge();
        charge.setDevice("device_001");
        assertEquals("device_001", charge.getDevice());
    }

    @Test
    public void testDisputableGetterAndSetter() {
        Charge charge = new Charge();
        charge.setDisputable(true);
        assertTrue(charge.isDisputable());
        
        charge.setDisputable(false);
        assertFalse(charge.isDisputable());
    }

    @Test
    public void testDisputeGetterAndSetter() {
        Charge charge = new Charge();
        Dispute dispute = new Dispute();
        dispute.setId("dspt_test_123");
        charge.setDispute(dispute);
        assertEquals("dspt_test_123", charge.getDispute().getId());
    }

    @Test
    public void testExpiredGetterAndSetter() {
        Charge charge = new Charge();
        charge.setExpired(true);
        assertTrue(charge.isExpired());
        
        charge.setExpired(false);
        assertFalse(charge.isExpired());
    }

    @Test
    public void testExpiredAtGetterAndSetter() {
        Charge charge = new Charge();
        ZonedDateTime now = ZonedDateTime.now();
        charge.setExpiredAt(now);
        assertEquals(now, charge.getExpiredAt());
    }

    @Test
    public void testExpiresAtGetterAndSetter() {
        Charge charge = new Charge();
        ZonedDateTime future = ZonedDateTime.now().plusDays(7);
        charge.setExpiresAt(future);
        assertEquals(future, charge.getExpiresAt());
    }

    @Test
    public void testFailureCodeGetterAndSetter() {
        Charge charge = new Charge();
        charge.setFailureCode("insufficient_fund");
        assertEquals("insufficient_fund", charge.getFailureCode());
    }

    @Test
    public void testFailureMessageGetterAndSetter() {
        Charge charge = new Charge();
        charge.setFailureMessage("Insufficient funds");
        assertEquals("Insufficient funds", charge.getFailureMessage());
    }

    @Test
    public void testMerchantAdviceCodeGetterAndSetter() {
        Charge charge = new Charge();
        charge.setMerchantAdviceCode("01");
        assertEquals("01", charge.getMerchantAdviceCode());
    }

    @Test
    public void testFeeGetterAndSetter() {
        Charge charge = new Charge();
        charge.setFee(365L);
        assertEquals(365L, charge.getFee());
    }

    @Test
    public void testFeeVatGetterAndSetter() {
        Charge charge = new Charge();
        charge.setFeeVat(26L);
        assertEquals(26L, charge.getFeeVat());
    }

    @Test
    public void testFundingAmountGetterAndSetter() {
        Charge charge = new Charge();
        charge.setFundingAmount(100000L);
        assertEquals(100000L, charge.getFundingAmount());
    }

    @Test
    public void testFundingCurrencyGetterAndSetter() {
        Charge charge = new Charge();
        charge.setFundingCurrency("USD");
        assertEquals("USD", charge.getFundingCurrency());
    }

    @Test
    public void testInterestGetterAndSetter() {
        Charge charge = new Charge();
        charge.setInterest(500L);
        assertEquals(500L, charge.getInterest());
    }

    @Test
    public void testInterestVatGetterAndSetter() {
        Charge charge = new Charge();
        charge.setInterestVat(35L);
        assertEquals(35L, charge.getInterestVat());
    }

    @Test
    public void testIpGetterAndSetter() {
        Charge charge = new Charge();
        charge.setIp("192.168.1.1");
        assertEquals("192.168.1.1", charge.getIp());
    }

    @Test
    public void testLinkGetterAndSetter() {
        Charge charge = new Charge();
        charge.setLink("link_test_123");
        assertEquals("link_test_123", charge.getLink());
    }

    @Test
    public void testLocationGetterAndSetter() {
        Charge charge = new Charge();
        charge.setLocation("/charges/chrg_test_123");
        assertEquals("/charges/chrg_test_123", charge.getLocation());
    }

    @Test
    public void testMetadataGetterAndSetter() {
        Charge charge = new Charge();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id", "12345");
        metadata.put("color", "red");
        charge.setMetadata(metadata);
        
        assertEquals(2, charge.getMetadata().size());
        assertEquals("12345", charge.getMetadata().get("order_id"));
        assertEquals("red", charge.getMetadata().get("color"));
    }

    @Test
    public void testNetGetterAndSetter() {
        Charge charge = new Charge();
        charge.setNet(99635L);
        assertEquals(99635L, charge.getNet());
    }

    @Test
    public void testPaidGetterAndSetter() {
        Charge charge = new Charge();
        charge.setPaid(true);
        assertTrue(charge.isPaid());
        
        charge.setPaid(false);
        assertFalse(charge.isPaid());
    }

    @Test
    public void testPaidAtGetterAndSetter() {
        Charge charge = new Charge();
        ZonedDateTime paidTime = ZonedDateTime.now();
        charge.setPaidAt(paidTime);
        assertEquals(paidTime, charge.getPaidAt());
    }

    @Test
    public void testPlatformFeeGetterAndSetter() {
        Charge charge = new Charge();
        PlatformFee platformFee = new PlatformFee();
        charge.setPlatformFee(platformFee);
        assertNotNull(charge.getPlatformFee());
    }

    @Test
    public void testRefundableGetterAndSetter() {
        Charge charge = new Charge();
        charge.setRefundable(true);
        assertTrue(charge.isRefundable());
        
        charge.setRefundable(false);
        assertFalse(charge.isRefundable());
    }

    @Test
    public void testRefundedAmountGetterAndSetter() {
        Charge charge = new Charge();
        charge.setRefundedAmount(5000L);
        assertEquals(5000L, charge.getRefundedAmount());
    }

    @Test
    public void testTransactionFeesGetterAndSetter() {
        Charge charge = new Charge();
        TransactionFee transactionFee = new TransactionFee();
        charge.setTransactionFees(transactionFee);
        assertNotNull(charge.getTransactionFees());
    }

    @Test
    public void testRefundsGetterAndSetter() {
        Charge charge = new Charge();
        ScopedList<Refund> refunds = new ScopedList<>();
        charge.setRefunds(refunds);
        assertNotNull(charge.getRefunds());
    }

    @Test
    public void testReturnUriGetterAndSetter() {
        Charge charge = new Charge();
        charge.setReturnUri("https://example.com/return");
        assertEquals("https://example.com/return", charge.getReturnUri());
    }

    @Test
    public void testReversedGetterAndSetter() {
        Charge charge = new Charge();
        charge.setReversed(true);
        assertTrue(charge.isReversed());
        
        charge.setReversed(false);
        assertFalse(charge.isReversed());
    }

    @Test
    public void testReversedAtGetterAndSetter() {
        Charge charge = new Charge();
        ZonedDateTime reversedTime = ZonedDateTime.now();
        charge.setReversedAt(reversedTime);
        assertEquals(reversedTime, charge.getReversedAt());
    }

    @Test
    public void testReversibleGetterAndSetter() {
        Charge charge = new Charge();
        charge.setReversible(true);
        assertTrue(charge.isReversible());
        
        charge.setReversible(false);
        assertFalse(charge.isReversible());
    }

    @Test
    public void testScheduleGetterAndSetter() {
        Charge charge = new Charge();
        charge.setSchedule("schd_test_123");
        assertEquals("schd_test_123", charge.getSchedule());
    }

    @Test
    public void testSourceGetterAndSetter() {
        Charge charge = new Charge();
        Source source = new Source();
        source.setId("src_test_123");
        charge.setSource(source);
        assertEquals("src_test_123", charge.getSource().getId());
    }

    @Test
    public void testStatusGetterAndSetter() {
        Charge charge = new Charge();
        charge.setStatus(ChargeStatus.Successful);
        assertEquals(ChargeStatus.Successful, charge.getStatus());
        
        charge.setStatus(ChargeStatus.Failed);
        assertEquals(ChargeStatus.Failed, charge.getStatus());
        
        charge.setStatus(ChargeStatus.Pending);
        assertEquals(ChargeStatus.Pending, charge.getStatus());
    }

    @Test
    public void testTerminalGetterAndSetter() {
        Charge charge = new Charge();
        charge.setTerminal("term_test_123");
        assertEquals("term_test_123", charge.getTerminal());
    }

    @Test
    public void testTransactionGetterAndSetter() {
        Charge charge = new Charge();
        charge.setTransaction("trxn_test_123");
        assertEquals("trxn_test_123", charge.getTransaction());
    }

    @Test
    public void testVoidedGetterAndSetter() {
        Charge charge = new Charge();
        charge.setVoided(true);
        assertTrue(charge.isVoided());
        
        charge.setVoided(false);
        assertFalse(charge.isVoided());
    }

    @Test
    public void testZeroInterestInstallmentsGetterAndSetter() {
        Charge charge = new Charge();
        charge.setZeroInterestInstallments(true);
        assertTrue(charge.isZeroInterestInstallments());
        
        charge.setZeroInterestInstallments(false);
        assertFalse(charge.isZeroInterestInstallments());
    }

    @Test
    public void testAuthorizationTypeGetterAndSetter() {
        Charge charge = new Charge();
        charge.setAuthorizationType(AuthorizationType.PreAuth);
        assertEquals(AuthorizationType.PreAuth, charge.getAuthorizationType());
        
        charge.setAuthorizationType(AuthorizationType.FinalAuth);
        assertEquals(AuthorizationType.FinalAuth, charge.getAuthorizationType());
    }

    @Test
    public void testAuthorizedAmountGetterAndSetter() {
        Charge charge = new Charge();
        charge.setAuthorizedAmount(50000L);
        assertEquals(50000L, charge.getAuthorizedAmount());
    }

    @Test
    public void testCapturedAmountGetterAndSetter() {
        Charge charge = new Charge();
        charge.setCapturedAmount(30000L);
        assertEquals(30000L, charge.getCapturedAmount());
    }

    @Test
    public void testWebhookEndpointsGetterAndSetter() {
        Charge charge = new Charge();
        List<String> webhookEndpoints = new ArrayList<>();
        webhookEndpoints.add("https://example.com/webhook1");
        webhookEndpoints.add("https://example.com/webhook2");
        charge.setWebhookEndpoints(webhookEndpoints);
        
        assertEquals(2, charge.getWebhookEndpoints().size());
        assertEquals("https://example.com/webhook1", charge.getWebhookEndpoints().get(0));
        assertEquals("https://example.com/webhook2", charge.getWebhookEndpoints().get(1));
    }

    @Test
    public void testMerchantAdviceGetterAndSetter() {
        Charge charge = new Charge();
        charge.setMerchantAdvice("Contact card issuer");
        assertEquals("Contact card issuer", charge.getMerchantAdvice());
    }

    @Test
    public void testMissing3DSFieldsGetterAndSetter() {
        Charge charge = new Charge();
        List<String> missing3DSFields = new ArrayList<>();
        missing3DSFields.add("cardholder_name");
        missing3DSFields.add("billing_address");
        charge.setMissing3DSFields(missing3DSFields);
        
        assertEquals(2, charge.getMissing3DSFields().size());
        assertEquals("cardholder_name", charge.getMissing3DSFields().get(0));
        assertEquals("billing_address", charge.getMissing3DSFields().get(1));
    }

    @Test
    public void testChargeWithAllFields() {
        Charge charge = new Charge();
        
        // Set all fields
        charge.setAmount(100000L);
        charge.setAuthorizeUri("https://example.com/authorize");
        charge.setAuthorized(true);
        charge.setAuthentication(AuthenticationType.PASSKEY);
        charge.setAuthenticatedBy("PASSKEY");
        charge.setBranch("branch_001");
        charge.setCapturable(true);
        charge.setCapture(true);
        charge.setCurrency("THB");
        charge.setCustomer("cust_test_123");
        charge.setDescription("Full charge test");
        charge.setDevice("device_001");
        charge.setDisputable(false);
        charge.setExpired(false);
        charge.setFailureCode(null);
        charge.setFailureMessage(null);
        charge.setFee(365L);
        charge.setFeeVat(26L);
        charge.setFundingAmount(100000L);
        charge.setFundingCurrency("USD");
        charge.setInterest(0L);
        charge.setInterestVat(0L);
        charge.setIp("192.168.1.1");
        charge.setLink(null);
        charge.setLocation("/charges/chrg_test_123");
        charge.setNet(99635L);
        charge.setPaid(true);
        charge.setRefundable(true);
        charge.setRefundedAmount(0L);
        charge.setReturnUri("https://example.com/return");
        charge.setReversed(false);
        charge.setReversible(false);
        charge.setSchedule(null);
        charge.setStatus(ChargeStatus.Successful);
        charge.setTerminal(null);
        charge.setTransaction("trxn_test_123");
        charge.setVoided(false);
        charge.setZeroInterestInstallments(false);
        charge.setAuthorizationType(AuthorizationType.PreAuth);
        charge.setAuthorizedAmount(100000L);
        charge.setCapturedAmount(100000L);
        charge.setMerchantAdvice(null);
        charge.setMerchantAdviceCode(null);
        
        // Verify all fields
        assertEquals(100000L, charge.getAmount());
        assertEquals("https://example.com/authorize", charge.getAuthorizeUri());
        assertTrue(charge.isAuthorized());
        assertEquals(AuthenticationType.PASSKEY, charge.getAuthentication());
        assertEquals("PASSKEY", charge.getAuthenticatedBy());
        assertEquals("branch_001", charge.getBranch());
        assertTrue(charge.isCapturable());
        assertTrue(charge.isCapture());
        assertEquals("THB", charge.getCurrency());
        assertEquals("cust_test_123", charge.getCustomer());
        assertEquals("Full charge test", charge.getDescription());
        assertEquals("device_001", charge.getDevice());
        assertFalse(charge.isDisputable());
        assertFalse(charge.isExpired());
        assertEquals(365L, charge.getFee());
        assertEquals(26L, charge.getFeeVat());
        assertEquals(100000L, charge.getFundingAmount());
        assertEquals("USD", charge.getFundingCurrency());
        assertEquals(0L, charge.getInterest());
        assertEquals(0L, charge.getInterestVat());
        assertEquals("192.168.1.1", charge.getIp());
        assertEquals("/charges/chrg_test_123", charge.getLocation());
        assertEquals(99635L, charge.getNet());
        assertTrue(charge.isPaid());
        assertTrue(charge.isRefundable());
        assertEquals(0L, charge.getRefundedAmount());
        assertEquals("https://example.com/return", charge.getReturnUri());
        assertFalse(charge.isReversed());
        assertFalse(charge.isReversible());
        assertEquals(ChargeStatus.Successful, charge.getStatus());
        assertEquals("trxn_test_123", charge.getTransaction());
        assertFalse(charge.isVoided());
        assertFalse(charge.isZeroInterestInstallments());
        assertEquals(AuthorizationType.PreAuth, charge.getAuthorizationType());
        assertEquals(100000L, charge.getAuthorizedAmount());
        assertEquals(100000L, charge.getCapturedAmount());
    }

    @Test
    public void testChargeWithNullValues() {
        Charge charge = new Charge();
        
        // Test that getters return appropriate values when nothing is set
        assertEquals(0L, charge.getAmount());
        assertNull(charge.getAuthorizeUri());
        assertFalse(charge.isAuthorized());
        assertNull(charge.getAuthentication());
        assertNull(charge.getAuthenticatedBy());
        assertNull(charge.getBranch());
        assertFalse(charge.isCapturable());
        assertFalse(charge.isCapture());
        assertNull(charge.getCard());
        assertNull(charge.getCurrency());
        assertNull(charge.getCustomer());
        assertNull(charge.getDescription());
        assertNull(charge.getDevice());
        assertFalse(charge.isDisputable());
        assertNull(charge.getDispute());
        assertFalse(charge.isExpired());
        assertNull(charge.getExpiredAt());
        assertNull(charge.getExpiresAt());
        assertNull(charge.getFailureCode());
        assertNull(charge.getFailureMessage());
    }

    @Test
    public void testChargeMetadataWithNullInitialization() {
        Charge charge = new Charge();
        
        // Initially null
        assertNull(charge.getMetadata());
        
        // Set metadata
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key1", "value1");
        charge.setMetadata(metadata);
        
        assertNotNull(charge.getMetadata());
        assertEquals(1, charge.getMetadata().size());
    }

    @Test
    public void testChargeWithComplexMetadata() {
        Charge charge = new Charge();
        Map<String, Object> metadata = new HashMap<>();
        
        // Test various data types in metadata
        metadata.put("string", "test");
        metadata.put("integer", 123);
        metadata.put("boolean", true);
        metadata.put("double", 45.67);
        
        charge.setMetadata(metadata);
        
        assertEquals("test", charge.getMetadata().get("string"));
        assertEquals(123, charge.getMetadata().get("integer"));
        assertEquals(true, charge.getMetadata().get("boolean"));
        assertEquals(45.67, charge.getMetadata().get("double"));
    }

    @Test
    public void testChargeListsWithEmptyValues() {
        Charge charge = new Charge();
        
        List<String> emptyWebhooks = new ArrayList<>();
        charge.setWebhookEndpoints(emptyWebhooks);
        assertNotNull(charge.getWebhookEndpoints());
        assertEquals(0, charge.getWebhookEndpoints().size());
        
        List<String> empty3DSFields = new ArrayList<>();
        charge.setMissing3DSFields(empty3DSFields);
        assertNotNull(charge.getMissing3DSFields());
        assertEquals(0, charge.getMissing3DSFields().size());
    }

    @Test
    public void testChargeAmountsWithZeroValues() {
        Charge charge = new Charge();
        
        charge.setAmount(0L);
        assertEquals(0L, charge.getAmount());
        
        charge.setFee(0L);
        assertEquals(0L, charge.getFee());
        
        charge.setFeeVat(0L);
        assertEquals(0L, charge.getFeeVat());
        
        charge.setRefundedAmount(0L);
        assertEquals(0L, charge.getRefundedAmount());
        
        charge.setNet(0L);
        assertEquals(0L, charge.getNet());
    }

    @Test
    public void testChargeAmountsWithNegativeValues() {
        Charge charge = new Charge();
        
        // Test negative amounts (for refunds, etc.)
        charge.setRefundedAmount(-1000L);
        assertEquals(-1000L, charge.getRefundedAmount());
        
        charge.setNet(-500L);
        assertEquals(-500L, charge.getNet());
    }

    @Test
    public void testChargeAmountsWithLargeValues() {
        Charge charge = new Charge();
        
        long largeAmount = 999999999999L;
        charge.setAmount(largeAmount);
        assertEquals(largeAmount, charge.getAmount());
        
        charge.setAuthorizedAmount(largeAmount);
        assertEquals(largeAmount, charge.getAuthorizedAmount());
        
        charge.setCapturedAmount(largeAmount);
        assertEquals(largeAmount, charge.getCapturedAmount());
    }

    @Test
    public void testChargeAllBooleanFlags() {
        Charge charge = new Charge();
        
        // Test all boolean getters/setters with true
        charge.setAuthorized(true);
        charge.setCapturable(true);
        charge.setCapture(true);
        charge.setDisputable(true);
        charge.setExpired(true);
        charge.setPaid(true);
        charge.setRefundable(true);
        charge.setReversed(true);
        charge.setReversible(true);
        charge.setVoided(true);
        charge.setZeroInterestInstallments(true);
        
        assertTrue(charge.isAuthorized());
        assertTrue(charge.isCapturable());
        assertTrue(charge.isCapture());
        assertTrue(charge.isDisputable());
        assertTrue(charge.isExpired());
        assertTrue(charge.isPaid());
        assertTrue(charge.isRefundable());
        assertTrue(charge.isReversed());
        assertTrue(charge.isReversible());
        assertTrue(charge.isVoided());
        assertTrue(charge.isZeroInterestInstallments());
        
        // Test all boolean getters/setters with false
        charge.setAuthorized(false);
        charge.setCapturable(false);
        charge.setCapture(false);
        charge.setDisputable(false);
        charge.setExpired(false);
        charge.setPaid(false);
        charge.setRefundable(false);
        charge.setReversed(false);
        charge.setReversible(false);
        charge.setVoided(false);
        charge.setZeroInterestInstallments(false);
        
        assertFalse(charge.isAuthorized());
        assertFalse(charge.isCapturable());
        assertFalse(charge.isCapture());
        assertFalse(charge.isDisputable());
        assertFalse(charge.isExpired());
        assertFalse(charge.isPaid());
        assertFalse(charge.isRefundable());
        assertFalse(charge.isReversed());
        assertFalse(charge.isReversible());
        assertFalse(charge.isVoided());
        assertFalse(charge.isZeroInterestInstallments());
    }

    // CreateRequestBuilder Tests
    @Test
    public void testCreateRequestBuilderAmount() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.amount(100000L);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderCapture() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.capture(true);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderCard() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.card("card_test_123");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderCurrency() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.currency("THB");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderCustomer() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.customer("cust_test_123");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderDescription() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.description("Test charge");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderExpiresAt() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        ZonedDateTime expiresAt = ZonedDateTime.now().plusDays(7);
        Charge.CreateRequestBuilder result = builder.expiresAt(expiresAt);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderIp() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.ip("192.168.1.1");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderMetadata() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id", "12345");
        
        Charge.CreateRequestBuilder result = builder.metadata(metadata);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderMetadataKeyValue() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.metadata("order_id", "12345");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderMetadataKeyValueMultiple() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        builder.metadata("order_id", "12345")
               .metadata("color", "red")
               .metadata("size", "large");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderMetadataKeyValueWithExistingMetadata() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        
        Map<String, Object> initialMetadata = new HashMap<>();
        initialMetadata.put("key1", "value1");
        builder.metadata(initialMetadata);
        
        // Add more metadata using key-value method
        builder.metadata("key2", "value2");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderPlatformFee() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        PlatformFee.Params platformFee = new PlatformFee.Params();
        Charge.CreateRequestBuilder result = builder.platformFee(platformFee);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderReference() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.reference("ref_123");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderReturnUri() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.returnUri("https://example.com/return");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderSource() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.source("src_test_123");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderZeroInterestInstallments() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.zeroInterestInstallments(true);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderAuthentication() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.authentication(AuthenticationType.PASSKEY);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderAuthorizationType() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.authorizationType(AuthorizationType.PreAuth);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderWebhookEndpoints() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        List<String> webhooks = new ArrayList<>();
        webhooks.add("https://example.com/webhook");
        
        Charge.CreateRequestBuilder result = builder.webhookEndpoints(webhooks);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderFirstCharge() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.firstCharge("chrg_test_123");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderLinkedAccount() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.linkedAccount("acct_test_123");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderRecurringReason() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.recurringReason("subscription");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderTransactionIndicator() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        Charge.CreateRequestBuilder result = builder.transactionIndicator("recurring");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderChaining() {
        Charge.CreateRequestBuilder builder = new Charge.CreateRequestBuilder();
        
        ZonedDateTime expiresAt = ZonedDateTime.now().plusDays(7);
        List<String> webhooks = new ArrayList<>();
        webhooks.add("https://example.com/webhook");
        
        Charge.CreateRequestBuilder result = builder
            .amount(100000L)
            .capture(true)
            .card("card_test_123")
            .currency("THB")
            .customer("cust_test_123")
            .description("Test charge")
            .expiresAt(expiresAt)
            .ip("192.168.1.1")
            .returnUri("https://example.com/return")
            .source("src_test_123")
            .zeroInterestInstallments(false)
            .authentication(AuthenticationType.PASSKEY)
            .authorizationType(AuthorizationType.PreAuth)
            .webhookEndpoints(webhooks)
            .firstCharge("chrg_test_456")
            .linkedAccount("acct_test_123")
            .recurringReason("subscription")
            .transactionIndicator("recurring");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    // ListRequestBuilder Tests
    @Test
    public void testListRequestBuilderOptions() {
        Charge.ListRequestBuilder builder = new Charge.ListRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        Charge.ListRequestBuilder result = builder.options(options);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testListRequestBuilderWithNullOptions() {
        Charge.ListRequestBuilder builder = new Charge.ListRequestBuilder();
        Charge.ListRequestBuilder result = builder.options(null);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    // GetRequestBuilder Tests
    @Test
    public void testGetRequestBuilder() {
        Charge.GetRequestBuilder builder = new Charge.GetRequestBuilder("chrg_test_123");
        
        assertNotNull(builder);
    }

    @Test
    public void testGetRequestBuilderWithDifferentIds() {
        Charge.GetRequestBuilder builder1 = new Charge.GetRequestBuilder("chrg_test_001");
        Charge.GetRequestBuilder builder2 = new Charge.GetRequestBuilder("chrg_test_002");
        Charge.GetRequestBuilder builder3 = new Charge.GetRequestBuilder("chrg_live_123");
        
        assertNotNull(builder1);
        assertNotNull(builder2);
        assertNotNull(builder3);
    }

    // UpdateRequestBuilder Tests
    @Test
    public void testUpdateRequestBuilderDescription() {
        Charge.UpdateRequestBuilder builder = new Charge.UpdateRequestBuilder("chrg_test_123");
        Charge.UpdateRequestBuilder result = builder.description("Updated description");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testUpdateRequestBuilderMetadata() {
        Charge.UpdateRequestBuilder builder = new Charge.UpdateRequestBuilder("chrg_test_123");
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("updated", "true");
        
        Charge.UpdateRequestBuilder result = builder.metadata(metadata);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testUpdateRequestBuilderMetadataKeyValue() {
        Charge.UpdateRequestBuilder builder = new Charge.UpdateRequestBuilder("chrg_test_123");
        Charge.UpdateRequestBuilder result = builder.metadata("key", "value");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testUpdateRequestBuilderMetadataKeyValueMultiple() {
        Charge.UpdateRequestBuilder builder = new Charge.UpdateRequestBuilder("chrg_test_123");
        builder.metadata("key1", "value1")
               .metadata("key2", "value2")
               .metadata("key3", "value3");
        
        assertNotNull(builder);
    }

    @Test
    public void testUpdateRequestBuilderMetadataKeyValueWithExistingMetadata() {
        Charge.UpdateRequestBuilder builder = new Charge.UpdateRequestBuilder("chrg_test_123");
        
        Map<String, Object> initialMetadata = new HashMap<>();
        initialMetadata.put("existing", "value");
        builder.metadata(initialMetadata);
        
        builder.metadata("new", "value");
        
        assertNotNull(builder);
    }

    @Test
    public void testUpdateRequestBuilderChaining() {
        Charge.UpdateRequestBuilder builder = new Charge.UpdateRequestBuilder("chrg_test_123");
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");
        
        Charge.UpdateRequestBuilder result = builder
            .description("Updated charge")
            .metadata(metadata)
            .metadata("additional", "data");
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    // CaptureRequestBuilder Tests
    @Test
    public void testCaptureRequestBuilder() {
        Charge.CaptureRequestBuilder builder = new Charge.CaptureRequestBuilder("chrg_test_123");
        
        assertNotNull(builder);
    }

    @Test
    public void testCaptureRequestBuilderCaptureAmount() {
        Charge.CaptureRequestBuilder builder = new Charge.CaptureRequestBuilder("chrg_test_123");
        Charge.CaptureRequestBuilder result = builder.captureAmount(50000L);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    // ExpireRequestBuilder Tests
    @Test
    public void testExpireRequestBuilder() {
        Charge.ExpireRequestBuilder builder = new Charge.ExpireRequestBuilder("chrg_test_123");
        
        assertNotNull(builder);
    }

    // MarkAsFailedRequestBuilder Tests
    @Test
    public void testMarkAsFailedRequestBuilder() {
        Charge.MarkAsFailedRequestBuilder builder = new Charge.MarkAsFailedRequestBuilder("chrg_test_123");
        
        assertNotNull(builder);
    }

    // MarkAsPaidRequestBuilder Tests
    @Test
    public void testMarkAsPaidRequestBuilder() {
        Charge.MarkAsPaidRequestBuilder builder = new Charge.MarkAsPaidRequestBuilder("chrg_test_123");
        
        assertNotNull(builder);
    }

    // ReverseRequestBuilder Tests
    @Test
    public void testReverseRequestBuilder() {
        Charge.ReverseRequestBuilder builder = new Charge.ReverseRequestBuilder("chrg_test_123");
        
        assertNotNull(builder);
    }

    // ListEventsRequestBuilder Tests
    @Test
    public void testListEventsRequestBuilder() {
        Charge.ListEventsRequestBuilder builder = new Charge.ListEventsRequestBuilder("chrg_test_123");
        
        assertNotNull(builder);
    }

    @Test
    public void testListEventsRequestBuilderOptions() {
        Charge.ListEventsRequestBuilder builder = new Charge.ListEventsRequestBuilder("chrg_test_123");
        ScopedList.Options options = new ScopedList.Options();
        
        Charge.ListEventsRequestBuilder result = builder.options(options);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testListEventsRequestBuilderWithNullOptions() {
        Charge.ListEventsRequestBuilder builder = new Charge.ListEventsRequestBuilder("chrg_test_123");
        Charge.ListEventsRequestBuilder result = builder.options(null);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    // ListSchedulesRequestBuilder Tests
    @Test
    public void testListSchedulesRequestBuilder() {
        Charge.ListSchedulesRequestBuilder builder = new Charge.ListSchedulesRequestBuilder();
        
        assertNotNull(builder);
    }

    @Test
    public void testListSchedulesRequestBuilderOptions() {
        Charge.ListSchedulesRequestBuilder builder = new Charge.ListSchedulesRequestBuilder();
        ScopedList.Options options = new ScopedList.Options();
        
        Charge.ListSchedulesRequestBuilder result = builder.options(options);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testListSchedulesRequestBuilderWithNullOptions() {
        Charge.ListSchedulesRequestBuilder builder = new Charge.ListSchedulesRequestBuilder();
        Charge.ListSchedulesRequestBuilder result = builder.options(null);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }
}
