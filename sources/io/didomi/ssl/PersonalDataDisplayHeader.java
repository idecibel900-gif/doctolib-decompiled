package io.didomi.ssl;

import android.text.Spanned;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.r8, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00158\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u000b\u0010\u001cR\u001a\u0010!\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0010\u0010 ¨\u0006$"}, d2 = {"Lio/didomi/sdk/r8;", "Lio/didomi/sdk/o8;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Landroid/text/Spanned;", "a", "Landroid/text/Spanned;", "c", "()Landroid/text/Spanned;", Constants.ScionAnalytics.PARAM_LABEL, "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "sectionTitle", "", "J", "getId", "()J", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/o8$a;", "Lio/didomi/sdk/o8$a;", "()Lio/didomi/sdk/o8$a;", "type", "e", "Z", "()Z", "preventListAccessibilityAnnouncement", "<init>", "(Landroid/text/Spanned;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PersonalDataDisplayHeader implements o8 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final Spanned label;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final String sectionTitle;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final long id;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final o8.a type;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final boolean preventListAccessibilityAnnouncement;

    public PersonalDataDisplayHeader(Spanned label, String str) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.sectionTitle = str;
        this.id = -2L;
        this.type = o8.a.Header;
        this.preventListAccessibilityAnnouncement = true;
    }

    @Override // io.didomi.ssl.o8
    /* JADX INFO: renamed from: a, reason: from getter */
    public o8.a getType() {
        return this.type;
    }

    @Override // io.didomi.ssl.o8
    /* JADX INFO: renamed from: b, reason: from getter */
    public boolean getPreventListAccessibilityAnnouncement() {
        return this.preventListAccessibilityAnnouncement;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Spanned getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getSectionTitle() {
        return this.sectionTitle;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonalDataDisplayHeader)) {
            return false;
        }
        PersonalDataDisplayHeader personalDataDisplayHeader = (PersonalDataDisplayHeader) other;
        return Intrinsics.areEqual(this.label, personalDataDisplayHeader.label) && Intrinsics.areEqual(this.sectionTitle, personalDataDisplayHeader.sectionTitle);
    }

    @Override // io.didomi.ssl.o8
    public long getId() {
        return this.id;
    }

    public int hashCode() {
        int iHashCode = this.label.hashCode() * 31;
        String str = this.sectionTitle;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PersonalDataDisplayHeader(label=" + ((Object) this.label) + ", sectionTitle=" + this.sectionTitle + ')';
    }
}
