package co.omise.models;

import co.omise.OmiseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest extends OmiseTest {

    // Getters and setters tests
    @Test
    public void testGetSetBankCode() {
        BankAccount bankAccount = new BankAccount();
        String bankCode = "bbl";
        bankAccount.setBankCode(bankCode);
        assertEquals(bankCode, bankAccount.getBankCode());
    }

    @Test
    public void testGetSetBranchCode() {
        BankAccount bankAccount = new BankAccount();
        String branchCode = "001";
        bankAccount.setBranchCode(branchCode);
        assertEquals(branchCode, bankAccount.getBranchCode());
    }

    @Test
    public void testGetSetBrand() {
        BankAccount bankAccount = new BankAccount();
        String brand = "Bangkok Bank";
        bankAccount.setBrand(brand);
        assertEquals(brand, bankAccount.getBrand());
    }

    @Test
    public void testGetSetLastDigits() {
        BankAccount bankAccount = new BankAccount();
        String lastDigits = "1234";
        bankAccount.setLastDigits(lastDigits);
        assertEquals(lastDigits, bankAccount.getLastDigits());
    }

    @Test
    public void testGetSetName() {
        BankAccount bankAccount = new BankAccount();
        String name = "John Doe";
        bankAccount.setName(name);
        assertEquals(name, bankAccount.getName());
    }

    @Test
    public void testGetSetAccountType() {
        BankAccount bankAccount = new BankAccount();
        String accountType = "savings";
        bankAccount.setAccountType(accountType);
        assertEquals(accountType, bankAccount.getAccountType());
    }

    @Test
    public void testGetSetAccountNumber() {
        BankAccount bankAccount = new BankAccount();
        String accountNumber = "1234567890";
        bankAccount.setAccountNumber(accountNumber);
        assertEquals(accountNumber, bankAccount.getAccountNumber());
    }

    // Edge case tests
    @Test
    public void testNullBankCode() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankCode(null);
        assertNull(bankAccount.getBankCode());
    }

    @Test
    public void testEmptyBankCode() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankCode("");
        assertEquals("", bankAccount.getBankCode());
    }

    @Test
    public void testNullBranchCode() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBranchCode(null);
        assertNull(bankAccount.getBranchCode());
    }

    @Test
    public void testEmptyBranchCode() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBranchCode("");
        assertEquals("", bankAccount.getBranchCode());
    }

    @Test
    public void testNullBrand() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBrand(null);
        assertNull(bankAccount.getBrand());
    }

    @Test
    public void testEmptyBrand() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBrand("");
        assertEquals("", bankAccount.getBrand());
    }

    @Test
    public void testNullLastDigits() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setLastDigits(null);
        assertNull(bankAccount.getLastDigits());
    }

    @Test
    public void testEmptyLastDigits() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setLastDigits("");
        assertEquals("", bankAccount.getLastDigits());
    }

    @Test
    public void testNullName() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setName(null);
        assertNull(bankAccount.getName());
    }

    @Test
    public void testEmptyName() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setName("");
        assertEquals("", bankAccount.getName());
    }

    @Test
    public void testNullAccountType() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountType(null);
        assertNull(bankAccount.getAccountType());
    }

    @Test
    public void testEmptyAccountType() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountType("");
        assertEquals("", bankAccount.getAccountType());
    }

    @Test
    public void testNullAccountNumber() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(null);
        assertNull(bankAccount.getAccountNumber());
    }

    @Test
    public void testEmptyAccountNumber() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber("");
        assertEquals("", bankAccount.getAccountNumber());
    }

    // Params tests
    @Test
    public void testParamsBankCode() {
        BankAccount.Params params = new BankAccount.Params();
        params.bankCode("bbl");
        assertNotNull(params);
    }

    @Test
    public void testParamsBranchCode() {
        BankAccount.Params params = new BankAccount.Params();
        params.branchCode("001");
        assertNotNull(params);
    }

    @Test
    public void testParamsBrand() {
        BankAccount.Params params = new BankAccount.Params();
        params.brand("Bangkok Bank");
        assertNotNull(params);
    }

    @Test
    public void testParamsName() {
        BankAccount.Params params = new BankAccount.Params();
        params.name("John Doe");
        assertNotNull(params);
    }

    @Test
    public void testParamsNumber() {
        BankAccount.Params params = new BankAccount.Params();
        params.number("1234567890");
        assertNotNull(params);
    }

    @Test
    public void testParamsAccountType() {
        BankAccount.Params params = new BankAccount.Params();
        params.accountType("savings");
        assertNotNull(params);
    }

    @Test
    public void testParamsChaining() {
        BankAccount.Params params = new BankAccount.Params();
        params
            .bankCode("bbl")
            .branchCode("001")
            .brand("Bangkok Bank")
            .name("Jane Doe")
            .number("9876543210")
            .accountType("current");
        assertNotNull(params);
    }

    // Various account types
    @Test
    public void testSavingsAccountType() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountType("savings");
        assertEquals("savings", bankAccount.getAccountType());
    }

    @Test
    public void testCurrentAccountType() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountType("current");
        assertEquals("current", bankAccount.getAccountType());
    }

    @Test
    public void testCheckingAccountType() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountType("checking");
        assertEquals("checking", bankAccount.getAccountType());
    }

    // Various bank codes
    @Test
    public void testBblBankCode() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankCode("bbl");
        assertEquals("bbl", bankAccount.getBankCode());
    }

    @Test
    public void testScbBankCode() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankCode("scb");
        assertEquals("scb", bankAccount.getBankCode());
    }

    @Test
    public void testKbankBankCode() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankCode("kbank");
        assertEquals("kbank", bankAccount.getBankCode());
    }

    // Long account number test
    @Test
    public void testLongAccountNumber() {
        BankAccount bankAccount = new BankAccount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            sb.append(i % 10);
        }
        String longAccountNumber = sb.toString();
        bankAccount.setAccountNumber(longAccountNumber);
        assertEquals(longAccountNumber, bankAccount.getAccountNumber());
    }

    // Last digits variations
    @Test
    public void testTwoDigitLastDigits() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setLastDigits("12");
        assertEquals("12", bankAccount.getLastDigits());
    }

    @Test
    public void testFourDigitLastDigits() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setLastDigits("5678");
        assertEquals("5678", bankAccount.getLastDigits());
    }

    @Test
    public void testSixDigitLastDigits() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setLastDigits("234567");
        assertEquals("234567", bankAccount.getLastDigits());
    }
}
