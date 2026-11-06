package io.didomi.ssl.models;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/models/AdditionalConsent;", "", "positive", "", "negative", "(Ljava/lang/String;Ljava/lang/String;)V", "getNegative", "()Ljava/lang/String;", "getPositive", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AdditionalConsent {

    @SerializedName("negative")
    private final String negative;

    @SerializedName("positive")
    private final String positive;

    public AdditionalConsent(String str, String str2) {
        this.positive = str;
        this.negative = str2;
    }

    public static /* synthetic */ AdditionalConsent copy$default(AdditionalConsent additionalConsent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = additionalConsent.positive;
        }
        if ((i & 2) != 0) {
            str2 = additionalConsent.negative;
        }
        return additionalConsent.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPositive() {
        return this.positive;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNegative() {
        return this.negative;
    }

    public final AdditionalConsent copy(String positive, String negative) {
        return new AdditionalConsent(positive, negative);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdditionalConsent)) {
            return false;
        }
        AdditionalConsent additionalConsent = (AdditionalConsent) other;
        return Intrinsics.areEqual(this.positive, additionalConsent.positive) && Intrinsics.areEqual(this.negative, additionalConsent.negative);
    }

    public final String getNegative() {
        return this.negative;
    }

    public final String getPositive() {
        return this.positive;
    }

    public int hashCode() {
        String str = this.positive;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.negative;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AdditionalConsent(positive=" + this.positive + ", negative=" + this.negative + ')';
    }
}
