package com.amazon.device.iap.model;

import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Receipt {
    private static final String CANCEL_DATE = "endDate";
    private static final Date DATE_CANCELED = new Date(1);
    private static final String DEFERRED_DATE = "deferredDate";
    private static final String DEFERRED_SKU = "deferredSku";
    private static final String PRODUCT_TYPE = "itemType";
    private static final String PURCHASE_DATE = "purchaseDate";
    private static final String RECEIPT_ID = "receiptId";
    private static final String SKU = "sku";
    private static final String TERM_SKU = "termSku";
    private final Date cancelDate;
    private final Date deferredDate;
    private final String deferredSku;
    private final ProductType productType;
    private final Date purchaseDate;
    private final String receiptId;
    private final String sku;
    private final String termSku;

    public int hashCode() {
        Date date = this.cancelDate;
        int iHashCode = ((date == null ? 0 : date.hashCode()) + 31) * 31;
        ProductType productType = this.productType;
        int iHashCode2 = (iHashCode + (productType == null ? 0 : productType.hashCode())) * 31;
        Date date2 = this.purchaseDate;
        int iHashCode3 = (iHashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.deferredDate;
        int iHashCode4 = (iHashCode3 + (date3 == null ? 0 : date3.hashCode())) * 31;
        String str = this.receiptId;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sku;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deferredSku;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.termSku;
        return iHashCode7 + (str4 != null ? str4.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Receipt.class != obj.getClass()) {
            return false;
        }
        Receipt receipt = (Receipt) obj;
        Date date = this.cancelDate;
        if (date == null) {
            if (receipt.cancelDate != null) {
                return false;
            }
        } else if (!date.equals(receipt.cancelDate)) {
            return false;
        }
        if (this.productType != receipt.productType) {
            return false;
        }
        Date date2 = this.purchaseDate;
        if (date2 == null) {
            if (receipt.purchaseDate != null) {
                return false;
            }
        } else if (!date2.equals(receipt.purchaseDate)) {
            return false;
        }
        String str = this.receiptId;
        if (str == null) {
            if (receipt.receiptId != null) {
                return false;
            }
        } else if (!str.equals(receipt.receiptId)) {
            return false;
        }
        String str2 = this.sku;
        if (str2 == null) {
            if (receipt.sku != null) {
                return false;
            }
        } else if (!str2.equals(receipt.sku)) {
            return false;
        }
        String str3 = this.deferredSku;
        if (str3 == null) {
            if (receipt.deferredSku != null) {
                return false;
            }
        } else if (!str3.equals(receipt.deferredSku)) {
            return false;
        }
        Date date3 = this.deferredDate;
        if (date3 == null) {
            if (receipt.deferredDate != null) {
                return false;
            }
        } else if (!date3.equals(receipt.deferredDate) || !this.termSku.equals(receipt.termSku)) {
            return false;
        }
        return true;
    }

    public Receipt(ReceiptBuilder receiptBuilder) {
        f.a((Object) receiptBuilder.getSku(), "sku");
        f.a(receiptBuilder.getProductType(), "productType");
        if (ProductType.SUBSCRIPTION == receiptBuilder.getProductType()) {
            f.a(receiptBuilder.getPurchaseDate(), "purchaseDate");
        }
        this.receiptId = receiptBuilder.getReceiptId();
        this.sku = receiptBuilder.getSku();
        this.productType = receiptBuilder.getProductType();
        this.purchaseDate = receiptBuilder.getPurchaseDate();
        this.cancelDate = receiptBuilder.getCancelDate();
        this.deferredSku = receiptBuilder.getDeferredSku();
        this.deferredDate = receiptBuilder.getDeferredDate();
        this.termSku = receiptBuilder.getTermSku();
    }

    public String getReceiptId() {
        return this.receiptId;
    }

    public String getSku() {
        return this.sku;
    }

    public String getTermSku() {
        return this.termSku;
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

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("receiptId", this.receiptId);
            jSONObject.put("sku", this.sku);
            jSONObject.put("itemType", this.productType);
            jSONObject.put("purchaseDate", this.purchaseDate);
            jSONObject.put("endDate", this.cancelDate);
            jSONObject.put("deferredSku", this.deferredSku);
            jSONObject.put("deferredDate", this.deferredDate);
            jSONObject.put("termSku", this.termSku);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toString() {
        try {
            return toJSON().toString(4);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean isCanceled() {
        return this.cancelDate != null;
    }

    public boolean isDeferred() {
        return this.deferredDate != null;
    }
}
