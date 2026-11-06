package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ExperimentalPreviewRevenueCatPurchasesAPI;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0095\u0001\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bB\u0095\u0001\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001dB«\u0001\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010 J\t\u0010C\u001a\u00020DHÖ\u0001J\u0013\u0010E\u001a\u00020\u000e2\b\u0010F\u001a\u0004\u0018\u00010GH\u0096\u0002J\b\u0010H\u001a\u00020DH\u0016J\u0019\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020DHÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\r\u0010!R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b,\u0010$R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R \u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010+\u001a\u0004\b;\u0010.R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R*\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010+\u001a\u0004\b?\u0010@R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010B¨\u0006N"}, d2 = {"Lcom/revenuecat/purchases/models/StoreTransaction;", "Landroid/os/Parcelable;", "orderId", "", "productIds", "", "type", "Lcom/revenuecat/purchases/ProductType;", "purchaseTime", "", "purchaseToken", "purchaseState", "Lcom/revenuecat/purchases/models/PurchaseState;", "isAutoRenewing", "", "signature", "originalJson", "Lorg/json/JSONObject;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "storeUserID", "purchaseType", "Lcom/revenuecat/purchases/models/PurchaseType;", b.m, "subscriptionOptionId", "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)V", "presentedOfferingIdentifier", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)V", "subscriptionOptionIdForProductIDs", "", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/revenuecat/purchases/ReplacementMode;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMarketplace", "()Ljava/lang/String;", "getOrderId", "getOriginalJson", "()Lorg/json/JSONObject;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getProductIds", "()Ljava/util/List;", "getPurchaseState", "()Lcom/revenuecat/purchases/models/PurchaseState;", "getPurchaseTime", "()J", "getPurchaseToken", "getPurchaseType", "()Lcom/revenuecat/purchases/models/PurchaseType;", "getReplacementMode", "()Lcom/revenuecat/purchases/ReplacementMode;", "getSignature", b.O, "getSkus$annotations", "getSkus", "getStoreUserID", "getSubscriptionOptionId", "getSubscriptionOptionIdForProductIDs$annotations", "getSubscriptionOptionIdForProductIDs", "()Ljava/util/Map;", "getType", "()Lcom/revenuecat/purchases/ProductType;", "describeContents", "", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StoreTransaction implements Parcelable {
    public static final Parcelable.Creator<StoreTransaction> CREATOR = new Creator();
    private final Boolean isAutoRenewing;
    private final String marketplace;
    private final String orderId;
    private final JSONObject originalJson;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<String> productIds;
    private final PurchaseState purchaseState;
    private final long purchaseTime;
    private final String purchaseToken;
    private final PurchaseType purchaseType;
    private final ReplacementMode replacementMode;
    private final String signature;
    private final String storeUserID;
    private final String subscriptionOptionId;
    private final Map<String, String> subscriptionOptionIdForProductIDs;
    private final ProductType type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<StoreTransaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreTransaction createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            ProductType productTypeValueOf = ProductType.valueOf(parcel.readString());
            long j = parcel.readLong();
            String string2 = parcel.readString();
            PurchaseState purchaseStateValueOf = PurchaseState.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string3 = parcel.readString();
            JSONObject jSONObjectCreate = JSONObjectParceler.INSTANCE.create(parcel);
            PresentedOfferingContext presentedOfferingContextCreateFromParcel = parcel.readInt() == 0 ? null : PresentedOfferingContext.CREATOR.createFromParcel(parcel);
            String string4 = parcel.readString();
            PurchaseType purchaseTypeValueOf = PurchaseType.valueOf(parcel.readString());
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(i);
                int i2 = 0;
                while (i2 != i) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                    i2++;
                    string = string;
                }
                linkedHashMap = linkedHashMap2;
            }
            return new StoreTransaction(string, arrayListCreateStringArrayList, productTypeValueOf, j, string2, purchaseStateValueOf, boolValueOf, string3, jSONObjectCreate, presentedOfferingContextCreateFromParcel, string4, purchaseTypeValueOf, string5, string6, linkedHashMap, (ReplacementMode) parcel.readParcelable(StoreTransaction.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreTransaction[] newArray(int i) {
            return new StoreTransaction[i];
        }
    }

    @Deprecated
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getSkus$annotations() {
    }

    @ExperimentalPreviewRevenueCatPurchasesAPI
    public static /* synthetic */ void getSubscriptionOptionIdForProductIDs$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StoreTransaction(orderId=" + this.orderId + ", productIds=" + this.productIds + ", type=" + this.type + ", purchaseTime=" + this.purchaseTime + ", purchaseToken=" + this.purchaseToken + ", purchaseState=" + this.purchaseState + ", isAutoRenewing=" + this.isAutoRenewing + ", signature=" + this.signature + ", originalJson=" + this.originalJson + ", presentedOfferingContext=" + this.presentedOfferingContext + ", storeUserID=" + this.storeUserID + ", purchaseType=" + this.purchaseType + ", marketplace=" + this.marketplace + ", subscriptionOptionId=" + this.subscriptionOptionId + ", subscriptionOptionIdForProductIDs=" + this.subscriptionOptionIdForProductIDs + ", replacementMode=" + this.replacementMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.orderId);
        parcel.writeStringList(this.productIds);
        parcel.writeString(this.type.name());
        parcel.writeLong(this.purchaseTime);
        parcel.writeString(this.purchaseToken);
        parcel.writeString(this.purchaseState.name());
        Boolean bool = this.isAutoRenewing;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.signature);
        JSONObjectParceler.INSTANCE.write(this.originalJson, parcel, flags);
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        if (presentedOfferingContext == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            presentedOfferingContext.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.storeUserID);
        parcel.writeString(this.purchaseType.name());
        parcel.writeString(this.marketplace);
        parcel.writeString(this.subscriptionOptionId);
        Map<String, String> map = this.subscriptionOptionIdForProductIDs;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
        }
        parcel.writeParcelable(this.replacementMode, flags);
    }

    @ExperimentalPreviewRevenueCatPurchasesAPI
    public StoreTransaction(String str, List<String> productIds, ProductType type, long j, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, JSONObject originalJson, PresentedOfferingContext presentedOfferingContext, String str3, PurchaseType purchaseType, String str4, String str5, Map<String, String> map, ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState, "purchaseState");
        Intrinsics.checkNotNullParameter(originalJson, "originalJson");
        Intrinsics.checkNotNullParameter(purchaseType, "purchaseType");
        this.orderId = str;
        this.productIds = productIds;
        this.type = type;
        this.purchaseTime = j;
        this.purchaseToken = purchaseToken;
        this.purchaseState = purchaseState;
        this.isAutoRenewing = bool;
        this.signature = str2;
        this.originalJson = originalJson;
        this.presentedOfferingContext = presentedOfferingContext;
        this.storeUserID = str3;
        this.purchaseType = purchaseType;
        this.marketplace = str4;
        this.subscriptionOptionId = str5;
        this.subscriptionOptionIdForProductIDs = map;
        this.replacementMode = replacementMode;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final List<String> getProductIds() {
        return this.productIds;
    }

    public final ProductType getType() {
        return this.type;
    }

    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final PurchaseState getPurchaseState() {
        return this.purchaseState;
    }

    /* JADX INFO: renamed from: isAutoRenewing, reason: from getter */
    public final Boolean getIsAutoRenewing() {
        return this.isAutoRenewing;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final JSONObject getOriginalJson() {
        return this.originalJson;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final String getStoreUserID() {
        return this.storeUserID;
    }

    public final PurchaseType getPurchaseType() {
        return this.purchaseType;
    }

    public final String getMarketplace() {
        return this.marketplace;
    }

    public final String getSubscriptionOptionId() {
        return this.subscriptionOptionId;
    }

    public final /* synthetic */ Map getSubscriptionOptionIdForProductIDs() {
        return this.subscriptionOptionIdForProductIDs;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreTransaction(String str, List<String> productIds, ProductType type, long j, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, JSONObject originalJson, PresentedOfferingContext presentedOfferingContext, String str3, PurchaseType purchaseType, String str4, String str5, ReplacementMode replacementMode) {
        this(str, productIds, type, j, purchaseToken, purchaseState, bool, str2, originalJson, presentedOfferingContext, str3, purchaseType, str4, str5, MapsKt.emptyMap(), replacementMode);
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState, "purchaseState");
        Intrinsics.checkNotNullParameter(originalJson, "originalJson");
        Intrinsics.checkNotNullParameter(purchaseType, "purchaseType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public StoreTransaction(String str, List<String> productIds, ProductType type, long j, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, JSONObject originalJson, String str3, String str4, PurchaseType purchaseType, String str5, String str6, ReplacementMode replacementMode) {
        this(str, productIds, type, j, purchaseToken, purchaseState, bool, str2, originalJson, str3 != null ? new PresentedOfferingContext(str3) : null, str4, purchaseType, str5, str6, MapsKt.emptyMap(), replacementMode);
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState, "purchaseState");
        Intrinsics.checkNotNullParameter(originalJson, "originalJson");
        Intrinsics.checkNotNullParameter(purchaseType, "purchaseType");
    }

    public final String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    public final List<String> getSkus() {
        return this.productIds;
    }

    public boolean equals(Object other) {
        return (other instanceof StoreTransaction) && Intrinsics.areEqual(new ComparableData(this), new ComparableData((StoreTransaction) other));
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }
}
