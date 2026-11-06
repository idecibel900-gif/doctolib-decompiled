package com.revenuecat.purchases.subscriberattributes;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.subscriberattributes.SpecialSubscriberAttributesKt;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB5\u0012\u0006\u0010\u0002\u001a\u00020\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u000fHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J=\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u000f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010%J\u0006\u0010&\u001a\u00020\rJ\b\u0010'\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "setTime", "Ljava/util/Date;", "isSynced", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;Ljava/util/Date;Z)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "(Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;Ljava/util/Date;Z)V", "getDateProvider", "()Lcom/revenuecat/purchases/common/DateProvider;", "()Z", "getKey", "()Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "getSetTime", "()Ljava/util/Date;", "getValue", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toBackendMap", "", "toJSONObject", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubscriberAttribute {
    private final DateProvider dateProvider;
    private final boolean isSynced;
    private final SubscriberAttributeKey key;
    private final Date setTime;
    private final String value;

    public static /* synthetic */ SubscriberAttribute copy$default(SubscriberAttribute subscriberAttribute, SubscriberAttributeKey subscriberAttributeKey, String str, DateProvider dateProvider, Date date, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriberAttributeKey = subscriberAttribute.key;
        }
        if ((i & 2) != 0) {
            str = subscriberAttribute.value;
        }
        if ((i & 4) != 0) {
            dateProvider = subscriberAttribute.dateProvider;
        }
        if ((i & 8) != 0) {
            date = subscriberAttribute.setTime;
        }
        if ((i & 16) != 0) {
            z = subscriberAttribute.isSynced;
        }
        boolean z2 = z;
        DateProvider dateProvider2 = dateProvider;
        return subscriberAttribute.copy(subscriberAttributeKey, str, dateProvider2, date, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SubscriberAttributeKey getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getSetTime() {
        return this.setTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSynced() {
        return this.isSynced;
    }

    public final SubscriberAttribute copy(SubscriberAttributeKey key, String value, DateProvider dateProvider, Date setTime, boolean isSynced) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(setTime, "setTime");
        return new SubscriberAttribute(key, value, dateProvider, setTime, isSynced);
    }

    public SubscriberAttribute(SubscriberAttributeKey key, String str, DateProvider dateProvider, Date setTime, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(setTime, "setTime");
        this.key = key;
        this.value = str;
        this.dateProvider = dateProvider;
        this.setTime = setTime;
        this.isSynced = z;
    }

    public final SubscriberAttributeKey getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SubscriberAttribute(SubscriberAttributeKey subscriberAttributeKey, String str, DateProvider dateProvider, Date date, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        DateProvider defaultDateProvider = (i & 4) != 0 ? new DefaultDateProvider() : dateProvider;
        this(subscriberAttributeKey, str, defaultDateProvider, (i & 8) != 0 ? defaultDateProvider.getNow() : date, (i & 16) != 0 ? false : z);
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final Date getSetTime() {
        return this.setTime;
    }

    public final boolean isSynced() {
        return this.isSynced;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SubscriberAttribute(String str, String str2, DateProvider dateProvider, Date date, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        DateProvider defaultDateProvider = (i & 4) != 0 ? new DefaultDateProvider() : dateProvider;
        this(str, str2, defaultDateProvider, (i & 8) != 0 ? defaultDateProvider.getNow() : date, (i & 16) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubscriberAttribute(String key, String str, DateProvider dateProvider, Date setTime, boolean z) {
        this(SpecialSubscriberAttributesKt.getSubscriberAttributeKey(key), str, (DateProvider) null, setTime, z, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(setTime, "setTime");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SubscriberAttribute(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String string = jsonObject.getString(SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(JSON_NAME_KEY)");
        this(SpecialSubscriberAttributesKt.getSubscriberAttributeKey(string), JSONObjectExtensionsKt.getNullableString(jsonObject, "value"), (DateProvider) null, new Date(jsonObject.getLong(SubscriberAttributeKt.JSON_NAME_SET_TIME)), jsonObject.getBoolean(SubscriberAttributeKt.JSON_NAME_IS_SYNCED), 4, (DefaultConstructorMarker) null);
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_KEY, this.key.getBackendKey());
        String str = this.value;
        if (str == null || jSONObject.put("value", str) == null) {
            jSONObject.put("value", JSONObject.NULL);
        }
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_SET_TIME, this.setTime.getTime());
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_IS_SYNCED, this.isSynced);
        return jSONObject;
    }

    public final Map<String, Object> toBackendMap() {
        return MapsKt.mapOf(TuplesKt.to("value", this.value), TuplesKt.to(SubscriberAttributeKt.BACKEND_NAME_TIMESTAMP, Long.valueOf(this.setTime.getTime())));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(SubscriberAttribute.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttribute");
        SubscriberAttribute subscriberAttribute = (SubscriberAttribute) other;
        return Intrinsics.areEqual(this.key, subscriberAttribute.key) && Intrinsics.areEqual(this.value, subscriberAttribute.value) && Intrinsics.areEqual(this.setTime, subscriberAttribute.setTime) && this.isSynced == subscriberAttribute.isSynced;
    }

    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        String str = this.value;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.setTime.hashCode()) * 31) + Boolean.hashCode(this.isSynced);
    }

    public String toString() {
        return "SubscriberAttribute(key=" + this.key + ", value=" + this.value + ", setTime=" + this.setTime + ", isSynced=" + this.isSynced + ')';
    }
}
