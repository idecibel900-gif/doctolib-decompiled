package io.didomi.ssl;

import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.u9, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0010\u0010\u001b¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/u9;", "Lio/didomi/sdk/s9;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", Constants.ScionAnalytics.PARAM_LABEL, "", "b", "J", "getId", "()J", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/o9$a;", "Lio/didomi/sdk/o9$a;", "()Lio/didomi/sdk/o9$a;", "type", "d", "Z", "()Z", "preventListAccessibilityAnnouncement", "<init>", "(Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PurposeDisplayFooterVendor implements s9 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String label;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final long id;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final o9.a type;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final boolean preventListAccessibilityAnnouncement;

    public PurposeDisplayFooterVendor(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.id = -5L;
        this.type = o9.a.VendorButton;
        this.preventListAccessibilityAnnouncement = true;
    }

    @Override // io.didomi.ssl.o9
    /* JADX INFO: renamed from: a, reason: from getter */
    public o9.a getType() {
        return this.type;
    }

    @Override // io.didomi.ssl.o9
    /* JADX INFO: renamed from: b, reason: from getter */
    public boolean getPreventListAccessibilityAnnouncement() {
        return this.preventListAccessibilityAnnouncement;
    }

    @Override // io.didomi.ssl.s9
    /* JADX INFO: renamed from: c, reason: from getter */
    public String getLabel() {
        return this.label;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PurposeDisplayFooterVendor) && Intrinsics.areEqual(this.label, ((PurposeDisplayFooterVendor) other).label);
    }

    @Override // io.didomi.ssl.o9
    public long getId() {
        return this.id;
    }

    public int hashCode() {
        return this.label.hashCode();
    }

    public String toString() {
        return "PurposeDisplayFooterVendor(label=" + this.label + ')';
    }
}
