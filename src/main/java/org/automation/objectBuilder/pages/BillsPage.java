package org.automation.objectBuilder.pages;

public class BillsPage {
    private  String store;
    private String amount;
    private String customerPhnNo;
    private String billDescription;
    private String customerEmail;
    private String memoText;

    public String getBillDescription() {
        return billDescription;
    }

    public BillsPage setBillDescription(String billDescription) {
        this.billDescription = billDescription;
        return this;
    }

    public String getMemoText() {
        return memoText;
    }

    public BillsPage setMemoText(String memoText) {
        this.memoText = memoText;
        return this;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public BillsPage setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public BillsPage setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getCustomerPhnNo() {
        return customerPhnNo;
    }

    public BillsPage setCustomerPhnNo(String customerPhnNo) {
        this.customerPhnNo = customerPhnNo;
        return this;
    }

    public String getStore() {
        return store;
    }

    public BillsPage setStore(String store) {
        this.store = store;
        return this;
    }
}
