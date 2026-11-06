package com.revenuecat.purchases;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.RawDataContainer;
import com.revenuecat.purchases.models.Transaction;
import com.revenuecat.purchases.utils.DateHelper;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002Bw\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014B\u008b\u0001\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J$\u0010T\u001a\b\u0012\u0004\u0012\u00020\b0\u001b2\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002J\t\u0010V\u001a\u00020\rHÖ\u0001J\u0013\u0010W\u001a\u00020\u00182\b\u0010X\u001a\u0004\u0018\u00010YH\u0096\u0002J\u0010\u0010Z\u001a\u0004\u0018\u00010\t2\u0006\u0010[\u001a\u00020\bJ\u0010\u0010\\\u001a\u0004\u0018\u00010\t2\u0006\u0010]\u001a\u00020\bJ\u0012\u0010^\u001a\u0004\u0018\u00010\t2\u0006\u0010_\u001a\u00020\bH\u0007J\u0010\u0010`\u001a\u0004\u0018\u00010\t2\u0006\u0010[\u001a\u00020\bJ\u0010\u0010a\u001a\u0004\u0018\u00010\t2\u0006\u0010]\u001a\u00020\bJ\u0012\u0010b\u001a\u0004\u0018\u00010\t2\u0006\u0010_\u001a\u00020\bH\u0007J\b\u0010c\u001a\u00020\rH\u0016J\b\u0010d\u001a\u00020\bH\u0016J\u0019\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\rHÖ\u0001R'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001b8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R'\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u001b8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b(\u0010!\u0012\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR'\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u001b8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b,\u0010!\u0012\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u00101\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b4\u0010!\u0012\u0004\b2\u0010\u001d\u001a\u0004\b3\u00100R\u0014\u0010\u0017\u001a\u00020\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R'\u00109\u001a\b\u0012\u0004\u0012\u00020;0:8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b?\u0010!\u0012\u0004\b<\u0010\u001d\u001a\u0004\b=\u0010>R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bB\u00100R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\bF\u0010\u001d\u001a\u0004\bG\u0010HR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bI\u00100R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001c\u0010L\u001a\n M*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\bN\u0010\u001dR-\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020P0\u00078FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bS\u0010!\u0012\u0004\bQ\u0010\u001d\u001a\u0004\bR\u0010#¨\u0006j"}, d2 = {"Lcom/revenuecat/purchases/CustomerInfo;", "Landroid/os/Parcelable;", "Lcom/revenuecat/purchases/models/RawDataContainer;", "Lorg/json/JSONObject;", CustomerInfoResponseJsonKeys.ENTITLEMENTS, "Lcom/revenuecat/purchases/EntitlementInfos;", "allExpirationDatesByProduct", "", "", "Ljava/util/Date;", "allPurchaseDatesByProduct", "requestDate", "schemaVersion", "", "firstSeen", "originalAppUserId", "managementURL", "Landroid/net/Uri;", "originalPurchaseDate", "jsonObject", "(Lcom/revenuecat/purchases/EntitlementInfos;Ljava/util/Map;Ljava/util/Map;Ljava/util/Date;ILjava/util/Date;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Date;Lorg/json/JSONObject;)V", "originalSource", "Lcom/revenuecat/purchases/CustomerInfoOriginalSource;", "loadedFromCache", "", "(Lcom/revenuecat/purchases/EntitlementInfos;Ljava/util/Map;Ljava/util/Map;Ljava/util/Date;ILjava/util/Date;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Date;Lorg/json/JSONObject;Lcom/revenuecat/purchases/CustomerInfoOriginalSource;Z)V", "activeSubscriptions", "", "getActiveSubscriptions$annotations", "()V", "getActiveSubscriptions", "()Ljava/util/Set;", "activeSubscriptions$delegate", "Lkotlin/Lazy;", "getAllExpirationDatesByProduct", "()Ljava/util/Map;", "getAllPurchaseDatesByProduct", "allPurchasedProductIds", "getAllPurchasedProductIds$annotations", "getAllPurchasedProductIds", "allPurchasedProductIds$delegate", "allPurchasedSkus", "getAllPurchasedSkus$annotations", "getAllPurchasedSkus", "allPurchasedSkus$delegate", "getEntitlements", "()Lcom/revenuecat/purchases/EntitlementInfos;", "getFirstSeen", "()Ljava/util/Date;", "latestExpirationDate", "getLatestExpirationDate$annotations", "getLatestExpirationDate", "latestExpirationDate$delegate", "getLoadedFromCache$purchases_defaultsBc8Release", "()Z", "getManagementURL", "()Landroid/net/Uri;", "nonSubscriptionTransactions", "", "Lcom/revenuecat/purchases/models/Transaction;", "getNonSubscriptionTransactions$annotations", "getNonSubscriptionTransactions", "()Ljava/util/List;", "nonSubscriptionTransactions$delegate", "getOriginalAppUserId", "()Ljava/lang/String;", "getOriginalPurchaseDate", "getOriginalSource$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/CustomerInfoOriginalSource;", Constants.MessagePayloadKeys.RAW_DATA, "getRawData$annotations", "getRawData", "()Lorg/json/JSONObject;", "getRequestDate", "getSchemaVersion", "()I", "subscriberJSONObject", "kotlin.jvm.PlatformType", "getSubscriberJSONObject$annotations", "subscriptionsByProductIdentifier", "Lcom/revenuecat/purchases/SubscriptionInfo;", "getSubscriptionsByProductIdentifier$annotations", "getSubscriptionsByProductIdentifier", "subscriptionsByProductIdentifier$delegate", "activeIdentifiers", "expirations", "describeContents", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getExpirationDateForEntitlement", "entitlement", "getExpirationDateForProductId", "productId", "getExpirationDateForSku", "sku", "getPurchaseDateForEntitlement", "getPurchaseDateForProductId", "getPurchaseDateForSku", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<CustomerInfo> CREATOR = new Creator();

    /* JADX INFO: renamed from: activeSubscriptions$delegate, reason: from kotlin metadata */
    private final Lazy activeSubscriptions;
    private final Map<String, Date> allExpirationDatesByProduct;
    private final Map<String, Date> allPurchaseDatesByProduct;

    /* JADX INFO: renamed from: allPurchasedProductIds$delegate, reason: from kotlin metadata */
    private final Lazy allPurchasedProductIds;

    /* JADX INFO: renamed from: allPurchasedSkus$delegate, reason: from kotlin metadata */
    private final Lazy allPurchasedSkus;
    private final EntitlementInfos entitlements;
    private final Date firstSeen;
    private final JSONObject jsonObject;

    /* JADX INFO: renamed from: latestExpirationDate$delegate, reason: from kotlin metadata */
    private final Lazy latestExpirationDate;
    private final boolean loadedFromCache;
    private final Uri managementURL;

    /* JADX INFO: renamed from: nonSubscriptionTransactions$delegate, reason: from kotlin metadata */
    private final Lazy nonSubscriptionTransactions;
    private final String originalAppUserId;
    private final Date originalPurchaseDate;
    private final CustomerInfoOriginalSource originalSource;
    private final Date requestDate;
    private final int schemaVersion;
    private final JSONObject subscriberJSONObject;

    /* JADX INFO: renamed from: subscriptionsByProductIdentifier$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsByProductIdentifier;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CustomerInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            EntitlementInfos entitlementInfosCreateFromParcel = EntitlementInfos.CREATOR.createFromParcel(parcel);
            int i = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i);
            for (int i2 = 0; i2 != i; i2++) {
                linkedHashMap.put(parcel.readString(), parcel.readSerializable());
            }
            int i3 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                linkedHashMap2.put(parcel.readString(), parcel.readSerializable());
            }
            return new CustomerInfo(entitlementInfosCreateFromParcel, linkedHashMap, linkedHashMap2, (Date) parcel.readSerializable(), parcel.readInt(), (Date) parcel.readSerializable(), parcel.readString(), (Uri) parcel.readParcelable(CustomerInfo.class.getClassLoader()), (Date) parcel.readSerializable(), JSONObjectParceler.INSTANCE.create(parcel), CustomerInfoOriginalSource.valueOf(parcel.readString()), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo[] newArray(int i) {
            return new CustomerInfo[i];
        }
    }

    public static /* synthetic */ void getActiveSubscriptions$annotations() {
    }

    public static /* synthetic */ void getAllPurchasedProductIds$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getAllPurchasedSkus$annotations() {
    }

    public static /* synthetic */ void getLatestExpirationDate$annotations() {
    }

    public static /* synthetic */ void getNonSubscriptionTransactions$annotations() {
    }

    public static /* synthetic */ void getRawData$annotations() {
    }

    private static /* synthetic */ void getSubscriberJSONObject$annotations() {
    }

    public static /* synthetic */ void getSubscriptionsByProductIdentifier$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.entitlements.writeToParcel(parcel, flags);
        Map<String, Date> map = this.allExpirationDatesByProduct;
        parcel.writeInt(map.size());
        for (Map.Entry<String, Date> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeSerializable(entry.getValue());
        }
        Map<String, Date> map2 = this.allPurchaseDatesByProduct;
        parcel.writeInt(map2.size());
        for (Map.Entry<String, Date> entry2 : map2.entrySet()) {
            parcel.writeString(entry2.getKey());
            parcel.writeSerializable(entry2.getValue());
        }
        parcel.writeSerializable(this.requestDate);
        parcel.writeInt(this.schemaVersion);
        parcel.writeSerializable(this.firstSeen);
        parcel.writeString(this.originalAppUserId);
        parcel.writeParcelable(this.managementURL, flags);
        parcel.writeSerializable(this.originalPurchaseDate);
        JSONObjectParceler.INSTANCE.write(this.jsonObject, parcel, flags);
        parcel.writeString(this.originalSource.name());
        parcel.writeInt(this.loadedFromCache ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomerInfo(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, Date requestDate, int i, Date firstSeen, String originalAppUserId, Uri uri, Date date, JSONObject jsonObject, CustomerInfoOriginalSource originalSource, boolean z) {
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        Intrinsics.checkNotNullParameter(firstSeen, "firstSeen");
        Intrinsics.checkNotNullParameter(originalAppUserId, "originalAppUserId");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        this.entitlements = entitlements;
        this.allExpirationDatesByProduct = allExpirationDatesByProduct;
        this.allPurchaseDatesByProduct = allPurchaseDatesByProduct;
        this.requestDate = requestDate;
        this.schemaVersion = i;
        this.firstSeen = firstSeen;
        this.originalAppUserId = originalAppUserId;
        this.managementURL = uri;
        this.originalPurchaseDate = date;
        this.jsonObject = jsonObject;
        this.originalSource = originalSource;
        this.loadedFromCache = z;
        this.activeSubscriptions = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.CustomerInfo$activeSubscriptions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<String> invoke() {
                CustomerInfo customerInfo = this.this$0;
                return customerInfo.activeIdentifiers(customerInfo.getAllExpirationDatesByProduct());
            }
        });
        this.allPurchasedSkus = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.CustomerInfo$allPurchasedSkus$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<String> invoke() {
                List<Transaction> nonSubscriptionTransactions = this.this$0.getNonSubscriptionTransactions();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nonSubscriptionTransactions, 10));
                Iterator<T> it = nonSubscriptionTransactions.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Transaction) it.next()).getProductIdentifier());
                }
                return SetsKt.plus(CollectionsKt.toSet(arrayList), (Iterable) this.this$0.getAllExpirationDatesByProduct().keySet());
            }
        });
        this.allPurchasedProductIds = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.CustomerInfo$allPurchasedProductIds$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<String> invoke() {
                List<Transaction> nonSubscriptionTransactions = this.this$0.getNonSubscriptionTransactions();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nonSubscriptionTransactions, 10));
                Iterator<T> it = nonSubscriptionTransactions.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Transaction) it.next()).getProductIdentifier());
                }
                return SetsKt.plus(CollectionsKt.toSet(arrayList), (Iterable) this.this$0.getAllExpirationDatesByProduct().keySet());
            }
        });
        this.latestExpirationDate = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.CustomerInfo$latestExpirationDate$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Date invoke() {
                List listSortedWith = CollectionsKt.sortedWith(this.this$0.getAllExpirationDatesByProduct().values(), new Comparator() { // from class: com.revenuecat.purchases.CustomerInfo$latestExpirationDate$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues((Date) t, (Date) t2);
                    }
                });
                if (listSortedWith.isEmpty()) {
                    listSortedWith = null;
                }
                if (listSortedWith != null) {
                    return (Date) CollectionsKt.last(listSortedWith);
                }
                return null;
            }
        });
        this.nonSubscriptionTransactions = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.CustomerInfo$nonSubscriptionTransactions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<Transaction> invoke() throws JSONException {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = this.this$0.subscriberJSONObject.getJSONObject(CustomerInfoResponseJsonKeys.NON_SUBSCRIPTIONS);
                Iterator<String> itKeys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys, "nonSubscriptions.keys()");
                while (itKeys.hasNext()) {
                    String productId = itKeys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(productId);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject transactionJSONObject = jSONArray.getJSONObject(i2);
                        Intrinsics.checkNotNullExpressionValue(productId, "productId");
                        Intrinsics.checkNotNullExpressionValue(transactionJSONObject, "transactionJSONObject");
                        arrayList.add(new Transaction(productId, transactionJSONObject, null, 4, null));
                    }
                }
                return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.revenuecat.purchases.CustomerInfo$nonSubscriptionTransactions$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((Transaction) t).getPurchaseDate(), ((Transaction) t2).getPurchaseDate());
                    }
                });
            }
        });
        this.subscriptionsByProductIdentifier = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.CustomerInfo$subscriptionsByProductIdentifier$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, SubscriptionInfo> invoke() {
                CustomerInfoFactory customerInfoFactory = CustomerInfoFactory.INSTANCE;
                JSONObject subscriberJSONObject = this.this$0.subscriberJSONObject;
                Intrinsics.checkNotNullExpressionValue(subscriberJSONObject, "subscriberJSONObject");
                return customerInfoFactory.parseSubscriptionInfos(subscriberJSONObject, this.this$0.getRequestDate());
            }
        });
        this.subscriberJSONObject = jsonObject.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIBER);
    }

    public final EntitlementInfos getEntitlements() {
        return this.entitlements;
    }

    public final Map<String, Date> getAllExpirationDatesByProduct() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> getAllPurchaseDatesByProduct() {
        return this.allPurchaseDatesByProduct;
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final Date getFirstSeen() {
        return this.firstSeen;
    }

    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    public final Uri getManagementURL() {
        return this.managementURL;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public /* synthetic */ CustomerInfo(EntitlementInfos entitlementInfos, Map map, Map map2, Date date, int i, Date date2, String str, Uri uri, Date date3, JSONObject jSONObject, CustomerInfoOriginalSource customerInfoOriginalSource, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(entitlementInfos, map, map2, date, i, date2, str, uri, date3, jSONObject, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? CustomerInfoOriginalSource.INSTANCE.getDEFAULT() : customerInfoOriginalSource, (i2 & 2048) != 0 ? false : z);
    }

    /* JADX INFO: renamed from: getOriginalSource$purchases_defaultsBc8Release, reason: from getter */
    public final CustomerInfoOriginalSource getOriginalSource() {
        return this.originalSource;
    }

    /* JADX INFO: renamed from: getLoadedFromCache$purchases_defaultsBc8Release, reason: from getter */
    public final boolean getLoadedFromCache() {
        return this.loadedFromCache;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerInfo(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, Date requestDate, int i, Date firstSeen, String originalAppUserId, Uri uri, Date date, JSONObject jsonObject) {
        this(entitlements, allExpirationDatesByProduct, allPurchaseDatesByProduct, requestDate, i, firstSeen, originalAppUserId, uri, date, jsonObject, CustomerInfoOriginalSource.INSTANCE.getDEFAULT(), true);
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        Intrinsics.checkNotNullParameter(firstSeen, "firstSeen");
        Intrinsics.checkNotNullParameter(originalAppUserId, "originalAppUserId");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
    }

    public final Set<String> getActiveSubscriptions() {
        return (Set) this.activeSubscriptions.getValue();
    }

    public final Set<String> getAllPurchasedSkus() {
        return (Set) this.allPurchasedSkus.getValue();
    }

    public final Set<String> getAllPurchasedProductIds() {
        return (Set) this.allPurchasedProductIds.getValue();
    }

    public final Date getLatestExpirationDate() {
        return (Date) this.latestExpirationDate.getValue();
    }

    public final List<Transaction> getNonSubscriptionTransactions() {
        return (List) this.nonSubscriptionTransactions.getValue();
    }

    public final Map<String, SubscriptionInfo> getSubscriptionsByProductIdentifier() {
        return (Map) this.subscriptionsByProductIdentifier.getValue();
    }

    @Deprecated
    public final Date getExpirationDateForSku(String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        return this.allExpirationDatesByProduct.get(sku);
    }

    public final Date getExpirationDateForProductId(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        return this.allExpirationDatesByProduct.get(productId);
    }

    @Deprecated
    public final Date getPurchaseDateForSku(String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        return this.allPurchaseDatesByProduct.get(sku);
    }

    public final Date getPurchaseDateForProductId(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        return this.allPurchaseDatesByProduct.get(productId);
    }

    public final Date getExpirationDateForEntitlement(String entitlement) {
        Intrinsics.checkNotNullParameter(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getExpirationDate();
        }
        return null;
    }

    public final Date getPurchaseDateForEntitlement(String entitlement) {
        Intrinsics.checkNotNullParameter(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getLatestPurchaseDate();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.RawDataContainer
    /* JADX INFO: renamed from: getRawData, reason: avoid collision after fix types in other method and from getter */
    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<CustomerInfo\n latestExpirationDate: ");
        sb.append(getLatestExpirationDate());
        sb.append("\nactiveSubscriptions:  ");
        Set<String> activeSubscriptions = getActiveSubscriptions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(activeSubscriptions, 10));
        for (String str : activeSubscriptions) {
            arrayList.add(TuplesKt.to(str, MapsKt.mapOf(TuplesKt.to("expiresDate", getExpirationDateForProductId(str)))));
        }
        sb.append(MapsKt.toMap(arrayList));
        sb.append(",\nactiveEntitlements: ");
        Map<String, EntitlementInfo> active = this.entitlements.getActive();
        ArrayList arrayList2 = new ArrayList(active.size());
        Iterator<Map.Entry<String, EntitlementInfo>> it = active.entrySet().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().toString());
        }
        sb.append(arrayList2);
        sb.append(",\nentitlements: ");
        Map<String, EntitlementInfo> all = this.entitlements.getAll();
        ArrayList arrayList3 = new ArrayList(all.size());
        Iterator<Map.Entry<String, EntitlementInfo>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList3.add(it2.next().toString());
        }
        sb.append(arrayList3);
        sb.append(",\nnonSubscriptionTransactions: ");
        sb.append(getNonSubscriptionTransactions());
        sb.append(",\nrequestDate: ");
        sb.append(this.requestDate);
        sb.append("\n>");
        return sb.toString();
    }

    public boolean equals(Object other) {
        return (other instanceof CustomerInfo) && Intrinsics.areEqual(new ComparableData(this), new ComparableData((CustomerInfo) other));
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> activeIdentifiers(Map<String, ? extends Date> expirations) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Date> entry : expirations.entrySet()) {
            if (DateHelper.Companion.m4596isDateActiveSxA4cEA$default(DateHelper.INSTANCE, entry.getValue(), this.requestDate, 0L, 4, null).isActive()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.keySet();
    }
}
