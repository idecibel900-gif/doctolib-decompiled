package io.didomi.ssl;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.r9, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\n\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u000f\u0010\u001d¨\u0006!"}, d2 = {"Lio/didomi/sdk/r9;", "Lio/didomi/sdk/o9;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "titleLabel", "b", "d", "descriptionLabel", "", "c", "J", "getId", "()J", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/o9$a;", "Lio/didomi/sdk/o9$a;", "()Lio/didomi/sdk/o9$a;", "type", "Z", "()Z", "preventListAccessibilityAnnouncement", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PurposeDisplayCategoryHeader implements o9 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String titleLabel;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final String descriptionLabel;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final long id;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final o9.a type;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final boolean preventListAccessibilityAnnouncement;

    public PurposeDisplayCategoryHeader(String titleLabel, String descriptionLabel) {
        Intrinsics.checkNotNullParameter(titleLabel, "titleLabel");
        Intrinsics.checkNotNullParameter(descriptionLabel, "descriptionLabel");
        this.titleLabel = titleLabel;
        this.descriptionLabel = descriptionLabel;
        this.id = -1L;
        this.type = o9.a.CategoryHeader;
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

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getDescriptionLabel() {
        return this.descriptionLabel;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getTitleLabel() {
        return this.titleLabel;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurposeDisplayCategoryHeader)) {
            return false;
        }
        PurposeDisplayCategoryHeader purposeDisplayCategoryHeader = (PurposeDisplayCategoryHeader) other;
        return Intrinsics.areEqual(this.titleLabel, purposeDisplayCategoryHeader.titleLabel) && Intrinsics.areEqual(this.descriptionLabel, purposeDisplayCategoryHeader.descriptionLabel);
    }

    @Override // io.didomi.ssl.o9
    public long getId() {
        return this.id;
    }

    public int hashCode() {
        return (this.titleLabel.hashCode() * 31) + this.descriptionLabel.hashCode();
    }

    public String toString() {
        return "PurposeDisplayCategoryHeader(titleLabel=" + this.titleLabel + ", descriptionLabel=" + this.descriptionLabel + ')';
    }
}
