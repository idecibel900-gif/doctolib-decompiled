package io.didomi.ssl.consent.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/consent/model/ConsentChoices;", "", "enabled", "", "", "disabled", "(Ljava/util/Collection;Ljava/util/Collection;)V", "getDisabled", "()Ljava/util/Collection;", "getEnabled", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ConsentChoices {

    @SerializedName("disabled")
    private final Collection<String> disabled;

    @SerializedName("enabled")
    private final Collection<String> enabled;

    public ConsentChoices(Collection<String> collection, Collection<String> collection2) {
        this.enabled = collection;
        this.disabled = collection2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsentChoices copy$default(ConsentChoices consentChoices, Collection collection, Collection collection2, int i, Object obj) {
        if ((i & 1) != 0) {
            collection = consentChoices.enabled;
        }
        if ((i & 2) != 0) {
            collection2 = consentChoices.disabled;
        }
        return consentChoices.copy(collection, collection2);
    }

    public final Collection<String> component1() {
        return this.enabled;
    }

    public final Collection<String> component2() {
        return this.disabled;
    }

    public final ConsentChoices copy(Collection<String> enabled, Collection<String> disabled) {
        return new ConsentChoices(enabled, disabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentChoices)) {
            return false;
        }
        ConsentChoices consentChoices = (ConsentChoices) other;
        return Intrinsics.areEqual(this.enabled, consentChoices.enabled) && Intrinsics.areEqual(this.disabled, consentChoices.disabled);
    }

    public final Collection<String> getDisabled() {
        return this.disabled;
    }

    public final Collection<String> getEnabled() {
        return this.enabled;
    }

    public int hashCode() {
        Collection<String> collection = this.enabled;
        int iHashCode = (collection == null ? 0 : collection.hashCode()) * 31;
        Collection<String> collection2 = this.disabled;
        return iHashCode + (collection2 != null ? collection2.hashCode() : 0);
    }

    public String toString() {
        return "ConsentChoices(enabled=" + this.enabled + ", disabled=" + this.disabled + ')';
    }
}
