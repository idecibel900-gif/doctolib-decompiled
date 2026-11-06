package io.didomi.ssl.models;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/models/GoogleConfig;", "", "additionalConsent", "Lio/didomi/sdk/models/AdditionalConsent;", "(Lio/didomi/sdk/models/AdditionalConsent;)V", "getAdditionalConsent", "()Lio/didomi/sdk/models/AdditionalConsent;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoogleConfig {

    @SerializedName("additionalConsent")
    private final AdditionalConsent additionalConsent;

    public GoogleConfig(AdditionalConsent additionalConsent) {
        this.additionalConsent = additionalConsent;
    }

    public static /* synthetic */ GoogleConfig copy$default(GoogleConfig googleConfig, AdditionalConsent additionalConsent, int i, Object obj) {
        if ((i & 1) != 0) {
            additionalConsent = googleConfig.additionalConsent;
        }
        return googleConfig.copy(additionalConsent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AdditionalConsent getAdditionalConsent() {
        return this.additionalConsent;
    }

    public final GoogleConfig copy(AdditionalConsent additionalConsent) {
        return new GoogleConfig(additionalConsent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GoogleConfig) && Intrinsics.areEqual(this.additionalConsent, ((GoogleConfig) other).additionalConsent);
    }

    public final AdditionalConsent getAdditionalConsent() {
        return this.additionalConsent;
    }

    public int hashCode() {
        AdditionalConsent additionalConsent = this.additionalConsent;
        if (additionalConsent == null) {
            return 0;
        }
        return additionalConsent.hashCode();
    }

    public String toString() {
        return "GoogleConfig(additionalConsent=" + this.additionalConsent + ')';
    }
}
