package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

/**
 * Comprehensive unit tests for Source model
 * Focuses on increasing coverage for getters and setters
 */
public class SourceTest extends OmiseTest {

    @Test
    public void testAmountGetterAndSetter() {
        Source source = new Source();
        source.setAmount(100000L);
        assertEquals(100000L, source.getAmount());
    }

    @Test
    public void testBankGetterAndSetter() {
        Source source = new Source();
        source.setBank("bbl");
        assertEquals("bbl", source.getBank());
        
        source.setBank("scb");
        assertEquals("scb", source.getBank());
    }

    @Test
    public void testBarcodeGetterAndSetter() {
        Source source = new Source();
        source.setBarcode("1234567890");
        assertEquals("1234567890", source.getBarcode());
    }

    @Test
    public void testChargeStatusGetterAndSetter() {
        Source source = new Source();
        source.setChargeStatus(ChargeStatus.Successful);
        assertEquals(ChargeStatus.Successful, source.getChargeStatus());
        
        source.setChargeStatus(ChargeStatus.Pending);
        assertEquals(ChargeStatus.Pending, source.getChargeStatus());
        
        source.setChargeStatus(ChargeStatus.Failed);
        assertEquals(ChargeStatus.Failed, source.getChargeStatus());
    }

    @Test
    public void testCurrencyGetterAndSetter() {
        Source source = new Source();
        source.setCurrency("THB");
        assertEquals("THB", source.getCurrency());
        
        source.setCurrency("JPY");
        assertEquals("JPY", source.getCurrency());
    }

    @Test
    public void testEmailGetterAndSetter() {
        Source source = new Source();
        source.setEmail("customer@example.com");
        assertEquals("customer@example.com", source.getEmail());
    }

    @Test
    public void testIpGetterAndSetter() {
        Source source = new Source();
        source.setIp("192.168.1.1");
        assertEquals("192.168.1.1", source.getIp());
        
        source.setIp("10.0.0.1");
        assertEquals("10.0.0.1", source.getIp());
    }

    @Test
    public void testFlowGetterAndSetter() {
        Source source = new Source();
        source.setFlow(FlowType.Redirect);
        assertEquals(FlowType.Redirect, source.getFlow());
        
        source.setFlow(FlowType.Offline);
        assertEquals(FlowType.Offline, source.getFlow());
    }

    @Test
    public void testInstallmentTermGetterAndSetter() {
        Source source = new Source();
        source.setInstallmentTerm(3L);
        assertEquals(3L, source.getInstallmentTerm());
        
        source.setInstallmentTerm(6L);
        assertEquals(6L, source.getInstallmentTerm());
        
        source.setInstallmentTerm(12L);
        assertEquals(12L, source.getInstallmentTerm());
    }

    @Test
    public void testLocationGetterAndSetter() {
        Source source = new Source();
        source.setLocation("/sources/src_test_123");
        assertEquals("/sources/src_test_123", source.getLocation());
    }

    @Test
    public void testMobileNumberGetterAndSetter() {
        Source source = new Source();
        source.setMobileNumber("0812345678");
        assertEquals("0812345678", source.getMobileNumber());
    }

    @Test
    public void testNameGetterAndSetter() {
        Source source = new Source();
        source.setName("John Doe");
        assertEquals("John Doe", source.getName());
    }

    @Test
    public void testPhoneNumberGetterAndSetter() {
        Source source = new Source();
        source.setPhoneNumber("+66812345678");
        assertEquals("+66812345678", source.getPhoneNumber());
    }

    @Test
    public void testReferencesGetterAndSetter() {
        Source source = new Source();
        References references = new References();
        source.setReferences(references);
        assertNotNull(source.getReferences());
    }

    @Test
    public void testScannableCodeGetterAndSetter() {
        Source source = new Source();
        Barcode barcode = new Barcode();
        source.setScannableCode(barcode);
        assertNotNull(source.getScannableCode());
    }

    @Test
    public void testStoreIdGetterAndSetter() {
        Source source = new Source();
        source.setStoreId("store_123");
        assertEquals("store_123", source.getStoreId());
    }

    @Test
    public void testStoreNameGetterAndSetter() {
        Source source = new Source();
        source.setStoreName("My Store");
        assertEquals("My Store", source.getStoreName());
    }

    @Test
    public void testTerminalIdGetterAndSetter() {
        Source source = new Source();
        source.setTerminalId("terminal_001");
        assertEquals("terminal_001", source.getTerminalId());
    }

    @Test
    public void testTypeGetterAndSetter() {
        Source source = new Source();
        source.setType(SourceType.PromptPay);
        assertEquals(SourceType.PromptPay, source.getType());
        
        source.setType(SourceType.BillPaymentTescoLotus);
        assertEquals(SourceType.BillPaymentTescoLotus, source.getType());
    }

    @Test
    public void testZeroInterestInstallmentsGetterAndSetter() {
        Source source = new Source();
        source.setZeroInterestInstallments(true);
        assertTrue(source.isZeroInterestInstallments());
        
        source.setZeroInterestInstallments(false);
        assertFalse(source.isZeroInterestInstallments());
    }

    @Test
    public void testPlatformTypeGetterAndSetter() {
        Source source = new Source();
        source.setPlatformType(PlatformType.Android);
        assertEquals(PlatformType.Android, source.getPlatformType());
        
        source.setPlatformType(PlatformType.iOS);
        assertEquals(PlatformType.iOS, source.getPlatformType());
        
        source.setPlatformType(PlatformType.Web);
        assertEquals(PlatformType.Web, source.getPlatformType());
    }

    @Test
    public void testSourceWithAllFields() {
        Source source = new Source();
        
        // Set all fields
        source.setAmount(50000L);
        source.setBank("kbank");
        source.setBarcode("9876543210");
        source.setChargeStatus(ChargeStatus.Successful);
        source.setCurrency("THB");
        source.setEmail("test@example.com");
        source.setIp("203.0.113.1");
        source.setFlow(FlowType.Redirect);
        source.setInstallmentTerm(6L);
        source.setLocation("/sources/src_test_456");
        source.setMobileNumber("0899999999");
        source.setName("Test User");
        source.setPhoneNumber("+66899999999");
        source.setStoreId("store_456");
        source.setStoreName("Test Store");
        source.setTerminalId("terminal_002");
        source.setType(SourceType.PromptPay);
        source.setZeroInterestInstallments(true);
        source.setPlatformType(PlatformType.Android);
        
        // Verify all fields
        assertEquals(50000L, source.getAmount());
        assertEquals("kbank", source.getBank());
        assertEquals("9876543210", source.getBarcode());
        assertEquals(ChargeStatus.Successful, source.getChargeStatus());
        assertEquals("THB", source.getCurrency());
        assertEquals("test@example.com", source.getEmail());
        assertEquals("203.0.113.1", source.getIp());
        assertEquals(FlowType.Redirect, source.getFlow());
        assertEquals(6L, source.getInstallmentTerm());
        assertEquals("/sources/src_test_456", source.getLocation());
        assertEquals("0899999999", source.getMobileNumber());
        assertEquals("Test User", source.getName());
        assertEquals("+66899999999", source.getPhoneNumber());
        assertEquals("store_456", source.getStoreId());
        assertEquals("Test Store", source.getStoreName());
        assertEquals("terminal_002", source.getTerminalId());
        assertEquals(SourceType.PromptPay, source.getType());
        assertTrue(source.isZeroInterestInstallments());
        assertEquals(PlatformType.Android, source.getPlatformType());
    }

    @Test
    public void testSourceWithNullValues() {
        Source source = new Source();
        
        // Test that getters return appropriate values when nothing is set
        assertEquals(0L, source.getAmount());
        assertNull(source.getBank());
        assertNull(source.getBarcode());
        assertNull(source.getChargeStatus());
        assertNull(source.getCurrency());
        assertNull(source.getEmail());
        assertNull(source.getIp());
        assertNull(source.getFlow());
        assertEquals(0L, source.getInstallmentTerm());
        assertNull(source.getLocation());
        assertNull(source.getMobileNumber());
        assertNull(source.getName());
        assertNull(source.getPhoneNumber());
        assertNull(source.getReferences());
        assertNull(source.getScannableCode());
        assertNull(source.getStoreId());
        assertNull(source.getStoreName());
        assertNull(source.getTerminalId());
        assertNull(source.getType());
        assertFalse(source.isZeroInterestInstallments());
        assertNull(source.getPlatformType());
    }

    @Test
    public void testSourceWithEmptyStrings() {
        Source source = new Source();
        
        source.setBank("");
        source.setBarcode("");
        source.setCurrency("");
        source.setEmail("");
        source.setIp("");
        source.setLocation("");
        source.setMobileNumber("");
        source.setName("");
        source.setPhoneNumber("");
        source.setStoreId("");
        source.setStoreName("");
        source.setTerminalId("");
        
        assertEquals("", source.getBank());
        assertEquals("", source.getBarcode());
        assertEquals("", source.getCurrency());
        assertEquals("", source.getEmail());
        assertEquals("", source.getIp());
        assertEquals("", source.getLocation());
        assertEquals("", source.getMobileNumber());
        assertEquals("", source.getName());
        assertEquals("", source.getPhoneNumber());
        assertEquals("", source.getStoreId());
        assertEquals("", source.getStoreName());
        assertEquals("", source.getTerminalId());
    }

    @Test
    public void testAmountWithZeroAndNegative() {
        Source source = new Source();
        
        source.setAmount(0L);
        assertEquals(0L, source.getAmount());
        
        source.setAmount(-1000L);
        assertEquals(-1000L, source.getAmount());
    }

    @Test
    public void testAmountWithLargeValue() {
        Source source = new Source();
        long largeAmount = 999999999999L;
        source.setAmount(largeAmount);
        assertEquals(largeAmount, source.getAmount());
    }

    @Test
    public void testInstallmentTermVariations() {
        Source source = new Source();
        
        long[] terms = {0L, 3L, 4L, 6L, 9L, 10L, 12L, 18L, 24L, 36L};
        
        for (long term : terms) {
            source.setInstallmentTerm(term);
            assertEquals(term, source.getInstallmentTerm());
        }
    }

    @Test
    public void testMultipleBanks() {
        Source source = new Source();
        
        String[] banks = {"bbl", "kbank", "scb", "ktb", "bay", "gsb", "tbank"};
        
        for (String bank : banks) {
            source.setBank(bank);
            assertEquals(bank, source.getBank());
        }
    }

    @Test
    public void testMultipleCurrencies() {
        Source source = new Source();
        
        String[] currencies = {"THB", "JPY", "SGD", "USD", "EUR", "GBP"};
        
        for (String currency : currencies) {
            source.setCurrency(currency);
            assertEquals(currency, source.getCurrency());
        }
    }

    @Test
    public void testEmailFormats() {
        Source source = new Source();
        
        source.setEmail("user@example.com");
        assertEquals("user@example.com", source.getEmail());
        
        source.setEmail("user+tag@example.co.th");
        assertEquals("user+tag@example.co.th", source.getEmail());
        
        source.setEmail("user.name@subdomain.example.com");
        assertEquals("user.name@subdomain.example.com", source.getEmail());
    }

    @Test
    public void testIpAddressFormats() {
        Source source = new Source();
        
        // IPv4
        source.setIp("192.168.1.1");
        assertEquals("192.168.1.1", source.getIp());
        
        source.setIp("10.0.0.1");
        assertEquals("10.0.0.1", source.getIp());
        
        // IPv6
        source.setIp("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
        assertEquals("2001:0db8:85a3:0000:0000:8a2e:0370:7334", source.getIp());
    }

    @Test
    public void testPhoneNumberFormats() {
        Source source = new Source();
        
        source.setPhoneNumber("+66812345678");
        assertEquals("+66812345678", source.getPhoneNumber());
        
        source.setPhoneNumber("0812345678");
        assertEquals("0812345678", source.getPhoneNumber());
        
        source.setMobileNumber("0899999999");
        assertEquals("0899999999", source.getMobileNumber());
    }

    @Test
    public void testBarcodeFormats() {
        Source source = new Source();
        
        source.setBarcode("1234567890123");
        assertEquals("1234567890123", source.getBarcode());
        
        source.setBarcode("ABC123XYZ");
        assertEquals("ABC123XYZ", source.getBarcode());
    }

    @Test
    public void testStoreInformation() {
        Source source = new Source();
        
        source.setStoreId("STORE001");
        source.setStoreName("Main Branch Store");
        source.setTerminalId("TERM001");
        
        assertEquals("STORE001", source.getStoreId());
        assertEquals("Main Branch Store", source.getStoreName());
        assertEquals("TERM001", source.getTerminalId());
    }

    @Test
    public void testNameWithSpecialCharacters() {
        Source source = new Source();
        
        source.setName("สมชาย ใจดี");
        assertEquals("สมชาย ใจดี", source.getName());
        
        source.setName("John O'Brien");
        assertEquals("John O'Brien", source.getName());
        
        source.setName("María José");
        assertEquals("María José", source.getName());
    }

    @Test
    public void testLocationFormats() {
        Source source = new Source();
        
        source.setLocation("/sources/src_test_123");
        assertEquals("/sources/src_test_123", source.getLocation());
        
        source.setLocation("/api/v1/sources/src_test_456");
        assertEquals("/api/v1/sources/src_test_456", source.getLocation());
    }

    @Test
    public void testAllChargeStatuses() {
        Source source = new Source();
        
        source.setChargeStatus(ChargeStatus.Pending);
        assertEquals(ChargeStatus.Pending, source.getChargeStatus());
        
        source.setChargeStatus(ChargeStatus.Successful);
        assertEquals(ChargeStatus.Successful, source.getChargeStatus());
        
        source.setChargeStatus(ChargeStatus.Failed);
        assertEquals(ChargeStatus.Failed, source.getChargeStatus());
        
        source.setChargeStatus(ChargeStatus.Expired);
        assertEquals(ChargeStatus.Expired, source.getChargeStatus());
    }

    @Test
    public void testAllFlowTypes() {
        Source source = new Source();
        
        source.setFlow(FlowType.Redirect);
        assertEquals(FlowType.Redirect, source.getFlow());
        
        source.setFlow(FlowType.Offline);
        assertEquals(FlowType.Offline, source.getFlow());
        
        source.setFlow(FlowType.AppRedirect);
        assertEquals(FlowType.AppRedirect, source.getFlow());
    }

    @Test
    public void testAllPlatformTypes() {
        Source source = new Source();
        
        source.setPlatformType(PlatformType.Android);
        assertEquals(PlatformType.Android, source.getPlatformType());
        
        source.setPlatformType(PlatformType.iOS);
        assertEquals(PlatformType.iOS, source.getPlatformType());
        
        source.setPlatformType(PlatformType.Web);
        assertEquals(PlatformType.Web, source.getPlatformType());
    }

    @Test
    public void testVariousSourceTypes() {
        Source source = new Source();
        
        source.setType(SourceType.PromptPay);
        assertEquals(SourceType.PromptPay, source.getType());
        
        source.setType(SourceType.BillPaymentTescoLotus);
        assertEquals(SourceType.BillPaymentTescoLotus, source.getType());
        
        source.setType(SourceType.Alipay);
        assertEquals(SourceType.Alipay, source.getType());
        
        source.setType(SourceType.InternetBankingBay);
        assertEquals(SourceType.InternetBankingBay, source.getType());
    }

    @Test
    public void testResetValues() {
        Source source = new Source();
        
        // Set initial values
        source.setName("Initial Name");
        source.setEmail("initial@example.com");
        source.setAmount(10000L);
        
        assertEquals("Initial Name", source.getName());
        assertEquals("initial@example.com", source.getEmail());
        assertEquals(10000L, source.getAmount());
        
        // Reset to null/zero
        source.setName(null);
        source.setEmail(null);
        source.setAmount(0L);
        
        assertNull(source.getName());
        assertNull(source.getEmail());
        assertEquals(0L, source.getAmount());
    }

    @Test
    public void testZeroInterestInstallmentsFlagToggle() {
        Source source = new Source();
        
        assertFalse(source.isZeroInterestInstallments());
        
        source.setZeroInterestInstallments(true);
        assertTrue(source.isZeroInterestInstallments());
        
        source.setZeroInterestInstallments(false);
        assertFalse(source.isZeroInterestInstallments());
        
        source.setZeroInterestInstallments(true);
        assertTrue(source.isZeroInterestInstallments());
    }

    @Test
    public void testCreateRequestBuilderAmount() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.amount(100000L);
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderBank() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.bank("bbl");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderBarcode() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.barcode("1234567890");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderCurrency() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.currency("THB");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderEmail() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.email("test@example.com");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderIp() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.ip("192.168.1.1");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderInstallmentTerm() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.installmentTerm(6L);
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderMobileNumber() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.mobileNumber("0812345678");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderName() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.name("John Doe");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderStoreId() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.storeId("store_123");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderStoreName() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.storeName("My Store");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderTerminalId() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.terminalId("terminal_001");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderType() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.type(SourceType.PromptPay);
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderZeroInterestInstallments() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.zeroInterestInstallments(true);
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderPlatformType() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.platformType(PlatformType.Android);
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderShipping() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        Shipping shipping = new Shipping();
        builder.shipping(shipping);
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderPhoneNumber() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.phoneNumber("+66812345678");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderAddItem() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        Item item = new Item();
        builder.addItem(item);
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderAddMultipleItems() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        
        builder.addItem(item1);
        builder.addItem(item2);
        builder.addItem(item3);
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderBilling() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        Shipping billing = new Shipping();
        builder.billing(billing);
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderPromotionCode() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        builder.promotionCode("PROMO123");
        
        assertNotNull(builder);
    }

    @Test
    public void testCreateRequestBuilderChaining() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        
        Source.CreateRequestBuilder result = builder
            .amount(100000L)
            .currency("THB")
            .type(SourceType.PromptPay)
            .email("test@example.com")
            .name("Test User")
            .ip("192.168.1.1")
            .bank("bbl")
            .installmentTerm(6L)
            .zeroInterestInstallments(true)
            .platformType(PlatformType.Android);
        
        assertNotNull(result);
        assertEquals(builder, result);
    }

    @Test
    public void testCreateRequestBuilderWithAllFields() {
        Source.CreateRequestBuilder builder = new Source.CreateRequestBuilder();
        
        Shipping shipping = new Shipping();
        Shipping billing = new Shipping();
        Item item1 = new Item();
        Item item2 = new Item();
        
        builder
            .amount(50000L)
            .bank("kbank")
            .barcode("9876543210")
            .currency("THB")
            .email("customer@example.com")
            .ip("10.0.0.1")
            .installmentTerm(3L)
            .mobileNumber("0899999999")
            .name("Jane Doe")
            .storeId("store_456")
            .storeName("Branch Store")
            .terminalId("terminal_002")
            .type(SourceType.Alipay)
            .zeroInterestInstallments(false)
            .platformType(PlatformType.iOS)
            .shipping(shipping)
            .phoneNumber("+66899999999")
            .addItem(item1)
            .addItem(item2)
            .billing(billing)
            .promotionCode("DISCOUNT50");
        
        assertNotNull(builder);
    }

    @Test
    public void testGetRequestBuilder() {
        Source.GetRequestBuilder builder = new Source.GetRequestBuilder("src_test_123");
        
        assertNotNull(builder);
    }

    @Test
    public void testGetRequestBuilderWithDifferentIds() {
        Source.GetRequestBuilder builder1 = new Source.GetRequestBuilder("src_test_001");
        Source.GetRequestBuilder builder2 = new Source.GetRequestBuilder("src_test_002");
        Source.GetRequestBuilder builder3 = new Source.GetRequestBuilder("src_live_123");
        
        assertNotNull(builder1);
        assertNotNull(builder2);
        assertNotNull(builder3);
    }
}
