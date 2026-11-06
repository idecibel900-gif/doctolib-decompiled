package com.amazon.device.iap.internal.model;

import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class ReceiptBuilder {
    private Date cancelDate;
    private Date deferredDate;
    private String deferredSku;
    private ProductType productType;
    private Date purchaseDate;
    private String receiptId;
    private String sku;
    private String termSku;

    public Receipt build() {
        return new Receipt(this);
    }

    public String getReceiptId() {
        return this.receiptId;
    }

    public String getSku() {
        return this.sku;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public Date getCancelDate() {
        return this.cancelDate;
    }

    public Date getDeferredDate() {
        return this.deferredDate;
    }

    public String getDeferredSku() {
        return this.deferredSku;
    }

    public String getTermSku() {
        return this.termSku;
    }

    public ReceiptBuilder setReceiptId(String str) {
        this.receiptId = str;
        return this;
    }

    public ReceiptBuilder setSku(String str) {
        this.sku = str;
        return this;
    }

    public ReceiptBuilder setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public ReceiptBuilder setPurchaseDate(Date date) {
        this.purchaseDate = date;
        return this;
    }

    public ReceiptBuilder setCancelDate(Date date) {
        this.cancelDate = date;
        return this;
    }

    public ReceiptBuilder setDeferredDate(Date date) {
        this.deferredDate = date;
        return this;
    }

    public ReceiptBuilder setDeferredSku(String str) {
        this.deferredSku = str;
        return this;
    }

    public ReceiptBuilder setTermSku(String str) {
        this.termSku = str;
        return this;
    }
}
