package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Date;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BA\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB!\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\t\u0010+\u001a\u00020,HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020,HÖ\u0001R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010!\u001a\u0004\b&\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001a¨\u00062"}, d2 = {"Lcom/revenuecat/purchases/models/Transaction;", "Landroid/os/Parcelable;", "transactionIdentifier", "", "revenuecatId", "productIdentifier", "productId", b.Q, "Ljava/util/Date;", "storeTransactionId", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lcom/revenuecat/purchases/Store;)V", "jsonObject", "Lorg/json/JSONObject;", "locale", "Ljava/util/Locale;", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/Locale;)V", "displayName", "isSandbox", "", "originalPurchaseDate", b.x, "Lcom/revenuecat/purchases/models/Price;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lcom/revenuecat/purchases/Store;Ljava/lang/String;ZLjava/util/Date;Lcom/revenuecat/purchases/models/Price;)V", "getDisplayName", "()Ljava/lang/String;", "()Z", "getOriginalPurchaseDate", "()Ljava/util/Date;", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "getProductId$annotations", "()V", "getProductId", "getProductIdentifier", "getPurchaseDate", "getRevenuecatId$annotations", "getRevenuecatId", "getStore", "()Lcom/revenuecat/purchases/Store;", "getStoreTransactionId", "getTransactionIdentifier", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Transaction implements Parcelable {
    public static final Parcelable.Creator<Transaction> CREATOR = new Creator();
    private final String displayName;
    private final boolean isSandbox;
    private final Date originalPurchaseDate;
    private final Price price;
    private final String productId;
    private final String productIdentifier;
    private final Date purchaseDate;
    private final String revenuecatId;
    private final Store store;
    private final String storeTransactionId;
    private final String transactionIdentifier;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Transaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Transaction(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Date) parcel.readSerializable(), parcel.readString(), Store.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() != 0, (Date) parcel.readSerializable(), parcel.readInt() == 0 ? null : Price.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction[] newArray(int i) {
            return new Transaction[i];
        }
    }

    @Deprecated
    public static /* synthetic */ void getProductId$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getRevenuecatId$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) obj;
        return Intrinsics.areEqual(this.transactionIdentifier, transaction.transactionIdentifier) && Intrinsics.areEqual(this.revenuecatId, transaction.revenuecatId) && Intrinsics.areEqual(this.productIdentifier, transaction.productIdentifier) && Intrinsics.areEqual(this.productId, transaction.productId) && Intrinsics.areEqual(this.purchaseDate, transaction.purchaseDate) && Intrinsics.areEqual(this.storeTransactionId, transaction.storeTransactionId) && this.store == transaction.store && Intrinsics.areEqual(this.displayName, transaction.displayName) && this.isSandbox == transaction.isSandbox && Intrinsics.areEqual(this.originalPurchaseDate, transaction.originalPurchaseDate) && Intrinsics.areEqual(this.price, transaction.price);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.transactionIdentifier.hashCode() * 31) + this.revenuecatId.hashCode()) * 31) + this.productIdentifier.hashCode()) * 31) + this.productId.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31;
        String str = this.storeTransactionId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.store.hashCode()) * 31;
        String str2 = this.displayName;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.isSandbox)) * 31;
        Date date = this.originalPurchaseDate;
        int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
        Price price = this.price;
        return iHashCode4 + (price != null ? price.hashCode() : 0);
    }

    public String toString() {
        return "Transaction(transactionIdentifier=" + this.transactionIdentifier + ", revenuecatId=" + this.revenuecatId + ", productIdentifier=" + this.productIdentifier + ", productId=" + this.productId + ", purchaseDate=" + this.purchaseDate + ", storeTransactionId=" + this.storeTransactionId + ", store=" + this.store + ", displayName=" + this.displayName + ", isSandbox=" + this.isSandbox + ", originalPurchaseDate=" + this.originalPurchaseDate + ", price=" + this.price + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.transactionIdentifier);
        parcel.writeString(this.revenuecatId);
        parcel.writeString(this.productIdentifier);
        parcel.writeString(this.productId);
        parcel.writeSerializable(this.purchaseDate);
        parcel.writeString(this.storeTransactionId);
        parcel.writeString(this.store.name());
        parcel.writeString(this.displayName);
        parcel.writeInt(this.isSandbox ? 1 : 0);
        parcel.writeSerializable(this.originalPurchaseDate);
        Price price = this.price;
        if (price == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            price.writeToParcel(parcel, flags);
        }
    }

    public Transaction(String transactionIdentifier, String revenuecatId, String productIdentifier, String productId, Date purchaseDate, String str, Store store, String str2, boolean z, Date date, Price price) {
        Intrinsics.checkNotNullParameter(transactionIdentifier, "transactionIdentifier");
        Intrinsics.checkNotNullParameter(revenuecatId, "revenuecatId");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        this.transactionIdentifier = transactionIdentifier;
        this.revenuecatId = revenuecatId;
        this.productIdentifier = productIdentifier;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.storeTransactionId = str;
        this.store = store;
        this.displayName = str2;
        this.isSandbox = z;
        this.originalPurchaseDate = date;
        this.price = price;
    }

    public /* synthetic */ Transaction(String str, String str2, String str3, String str4, Date date, String str5, Store store, String str6, boolean z, Date date2, Price price, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, date, str5, store, str6, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? false : z, date2, price);
    }

    public final String getTransactionIdentifier() {
        return this.transactionIdentifier;
    }

    public final String getRevenuecatId() {
        return this.revenuecatId;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public final String getStoreTransactionId() {
        return this.storeTransactionId;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: isSandbox, reason: from getter */
    public final boolean getIsSandbox() {
        return this.isSandbox;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final Price getPrice() {
        return this.price;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public Transaction(String transactionIdentifier, String revenuecatId, String productIdentifier, String productId, Date purchaseDate, String str, Store store) {
        this(transactionIdentifier, revenuecatId, productIdentifier, productId, purchaseDate, str, store, null, false, null, null);
        Intrinsics.checkNotNullParameter(transactionIdentifier, "transactionIdentifier");
        Intrinsics.checkNotNullParameter(revenuecatId, "revenuecatId");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Transaction(String str, JSONObject jSONObject, Locale locale, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        this(str, jSONObject, locale);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Transaction(String productId, JSONObject jsonObject, Locale locale) throws JSONException {
        String string;
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String string2 = jsonObject.getString(DiagnosticsEntry.ID_KEY);
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"id\")");
        String string3 = jsonObject.getString(DiagnosticsEntry.ID_KEY);
        Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(\"id\")");
        Date date = JSONObjectExtensionsKt.getDate(jsonObject, "purchase_date");
        String it = jsonObject.optString("store_transaction_id");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Price price = null;
        it = StringsKt.isBlank(it) ? null : it;
        String it2 = jsonObject.getString(ProductResponseJsonKeys.STORE);
        Store.Companion companion = Store.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        Store storeFromString = companion.fromString(it2);
        String it3 = jsonObject.optString("display_name");
        Intrinsics.checkNotNullExpressionValue(it3, "it");
        String str = !StringsKt.isBlank(it3) ? it3 : null;
        boolean zOptBoolean = jsonObject.optBoolean(ProductResponseJsonKeys.IS_SANDBOX, false);
        Date dateOptDate = JSONObjectExtensionsKt.optDate(jsonObject, "original_purchase_date");
        JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject(b.x);
        if (jSONObjectOptJSONObject != null && (string = jSONObjectOptJSONObject.toString()) != null) {
            Json json = JsonTools.INSTANCE.getJson();
            json.getSerializersModule();
            price = ((SubscriptionInfoResponse.PriceResponse) json.decodeFromString(SubscriptionInfoResponse.PriceResponse.INSTANCE.serializer(), string)).toPrice(locale);
        }
        this(string2, string3, productId, productId, date, it, storeFromString, str, zOptBoolean, dateOptDate, price);
    }
}
