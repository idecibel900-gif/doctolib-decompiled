package com.revenuecat.purchases.common.networking;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.BackendHelperKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.openid.appauth.ResponseTypeValues;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000234B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003JQ\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\r\u00100\u001a\u00020\u0005H\u0000¢\u0006\u0002\b1J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult;", "", "responseCode", "", "payload", "", "origin", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "requestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "isLoadShedderResponse", "", "isFallbackURL", "(ILjava/lang/String;Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;Ljava/util/Date;Lcom/revenuecat/purchases/VerificationResult;ZZ)V", "backendErrorCode", "getBackendErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "backendErrorMessage", "getBackendErrorMessage", "()Ljava/lang/String;", "body", "Lorg/json/JSONObject;", "getBody", "()Lorg/json/JSONObject;", "()Z", "getOrigin", "()Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "getPayload", "getRequestDate", "()Ljava/util/Date;", "getResponseCode", "()I", "getVerificationResult", "()Lcom/revenuecat/purchases/VerificationResult;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "serialize", "serialize$purchases_defaultsBc8Release", "toString", "Companion", "Origin", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HTTPResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ETAG_HEADER_NAME = "X-RevenueCat-ETag";
    public static final String LOAD_SHEDDER_HEADER_NAME = "x-revenuecat-fortress";
    public static final String REQUEST_TIME_HEADER_NAME = "X-RevenueCat-Request-Time";
    public static final String SIGNATURE_HEADER_NAME = "X-Signature";
    private final Integer backendErrorCode;
    private final String backendErrorMessage;
    private final JSONObject body;
    private final boolean isFallbackURL;
    private final boolean isLoadShedderResponse;
    private final Origin origin;
    private final String payload;
    private final Date requestDate;
    private final int responseCode;
    private final VerificationResult verificationResult;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "", "(Ljava/lang/String;I)V", "BACKEND", "CACHE", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Origin {
        BACKEND,
        CACHE
    }

    public static /* synthetic */ HTTPResult copy$default(HTTPResult hTTPResult, int i, String str, Origin origin, Date date, VerificationResult verificationResult, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hTTPResult.responseCode;
        }
        if ((i2 & 2) != 0) {
            str = hTTPResult.payload;
        }
        if ((i2 & 4) != 0) {
            origin = hTTPResult.origin;
        }
        if ((i2 & 8) != 0) {
            date = hTTPResult.requestDate;
        }
        if ((i2 & 16) != 0) {
            verificationResult = hTTPResult.verificationResult;
        }
        if ((i2 & 32) != 0) {
            z = hTTPResult.isLoadShedderResponse;
        }
        if ((i2 & 64) != 0) {
            z2 = hTTPResult.isFallbackURL;
        }
        boolean z3 = z;
        boolean z4 = z2;
        VerificationResult verificationResult2 = verificationResult;
        Origin origin2 = origin;
        return hTTPResult.copy(i, str, origin2, date, verificationResult2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResponseCode() {
        return this.responseCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Origin getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getRequestDate() {
        return this.requestDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsLoadShedderResponse() {
        return this.isLoadShedderResponse;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsFallbackURL() {
        return this.isFallbackURL;
    }

    public final HTTPResult copy(int responseCode, String payload, Origin origin, Date requestDate, VerificationResult verificationResult, boolean isLoadShedderResponse, boolean isFallbackURL) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        return new HTTPResult(responseCode, payload, origin, requestDate, verificationResult, isLoadShedderResponse, isFallbackURL);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HTTPResult)) {
            return false;
        }
        HTTPResult hTTPResult = (HTTPResult) other;
        return this.responseCode == hTTPResult.responseCode && Intrinsics.areEqual(this.payload, hTTPResult.payload) && this.origin == hTTPResult.origin && Intrinsics.areEqual(this.requestDate, hTTPResult.requestDate) && this.verificationResult == hTTPResult.verificationResult && this.isLoadShedderResponse == hTTPResult.isLoadShedderResponse && this.isFallbackURL == hTTPResult.isFallbackURL;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.responseCode) * 31) + this.payload.hashCode()) * 31) + this.origin.hashCode()) * 31;
        Date date = this.requestDate;
        return ((((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.verificationResult.hashCode()) * 31) + Boolean.hashCode(this.isLoadShedderResponse)) * 31) + Boolean.hashCode(this.isFallbackURL);
    }

    public String toString() {
        return "HTTPResult(responseCode=" + this.responseCode + ", payload=" + this.payload + ", origin=" + this.origin + ", requestDate=" + this.requestDate + ", verificationResult=" + this.verificationResult + ", isLoadShedderResponse=" + this.isLoadShedderResponse + ", isFallbackURL=" + this.isFallbackURL + ')';
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0050  */
    /* JADX WARN: Code duplicated, block: B:19:0x006e  */
    public HTTPResult(int i, String payload, Origin origin, Date date, VerificationResult verificationResult, boolean z, boolean z2) {
        JSONObject jSONObject;
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        this.responseCode = i;
        this.payload = payload;
        this.origin = origin;
        this.requestDate = date;
        this.verificationResult = verificationResult;
        this.isLoadShedderResponse = z;
        this.isFallbackURL = z2;
        String str = null;
        payload = StringsKt.isBlank(payload) ? null : payload;
        if (payload != null) {
            try {
                jSONObject = new JSONObject(payload);
            } catch (JSONException e) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to parse payload as JSON: " + payload, e);
                jSONObject = null;
            }
            jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
        }
        this.body = jSONObject;
        if (!BackendHelperKt.isSuccessful(this)) {
            numValueOf = Integer.valueOf(jSONObject.optInt(ResponseTypeValues.CODE));
            numValueOf = numValueOf.intValue() <= 0 ? null : numValueOf;
        }
        this.backendErrorCode = numValueOf;
        if (!BackendHelperKt.isSuccessful(this)) {
            String it = jSONObject.optString("message");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!StringsKt.isBlank(it)) {
                str = it;
            }
        }
        this.backendErrorMessage = str;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    public final boolean isLoadShedderResponse() {
        return this.isLoadShedderResponse;
    }

    public final boolean isFallbackURL() {
        return this.isFallbackURL;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Companion;", "", "()V", "ETAG_HEADER_NAME", "", "LOAD_SHEDDER_HEADER_NAME", "REQUEST_TIME_HEADER_NAME", "SIGNATURE_HEADER_NAME", "deserialize", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "serialized", "deserialize$purchases_defaultsBc8Release", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HTTPResult deserialize$purchases_defaultsBc8Release(String serialized) throws JSONException {
            Origin originValueOf;
            VerificationResult verificationResultValueOf;
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            JSONObject jSONObject = new JSONObject(serialized);
            int i = jSONObject.getInt("responseCode");
            String payload = jSONObject.getString("payload");
            if (jSONObject.has("origin")) {
                String string = jSONObject.getString("origin");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(SERIALIZATION_NAME_ORIGIN)");
                originValueOf = Origin.valueOf(string);
            } else {
                originValueOf = Origin.CACHE;
            }
            Origin origin = originValueOf;
            Date date = jSONObject.has("requestDate") ? new Date(jSONObject.getLong("requestDate")) : null;
            if (jSONObject.has("verificationResult")) {
                String string2 = jSONObject.getString("verificationResult");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(SER…NAME_VERIFICATION_RESULT)");
                verificationResultValueOf = VerificationResult.valueOf(string2);
            } else {
                verificationResultValueOf = VerificationResult.NOT_REQUESTED;
            }
            VerificationResult verificationResult = verificationResultValueOf;
            boolean z = jSONObject.has("isLoadShedderResponse") ? jSONObject.getBoolean("isLoadShedderResponse") : false;
            boolean z2 = jSONObject.has("isFallbackURL") ? jSONObject.getBoolean("isFallbackURL") : false;
            Intrinsics.checkNotNullExpressionValue(payload, "payload");
            return new HTTPResult(i, payload, origin, date, verificationResult, z, z2);
        }
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final Integer getBackendErrorCode() {
        return this.backendErrorCode;
    }

    public final String getBackendErrorMessage() {
        return this.backendErrorMessage;
    }

    public final String serialize$purchases_defaultsBc8Release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("responseCode", this.responseCode);
        jSONObject.put("payload", this.payload);
        jSONObject.put("origin", this.origin.name());
        Date date = this.requestDate;
        jSONObject.put("requestDate", date != null ? Long.valueOf(date.getTime()) : null);
        jSONObject.put("verificationResult", this.verificationResult.name());
        jSONObject.put("isLoadShedderResponse", this.isLoadShedderResponse);
        jSONObject.put("isFallbackURL", this.isFallbackURL);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
        return string;
    }
}
