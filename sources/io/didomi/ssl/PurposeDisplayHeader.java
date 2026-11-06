package io.didomi.ssl;

import android.text.Spanned;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.v9, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010!\u001a\u00020\u001d8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\u00020\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b\u000b\u0010$R\u001a\u0010(\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b\u0011\u0010'¨\u0006+"}, d2 = {"Lio/didomi/sdk/v9;", "Lio/didomi/sdk/o9;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Landroid/text/Spanned;", "a", "Landroid/text/Spanned;", "d", "()Landroid/text/Spanned;", Constants.ScionAnalytics.PARAM_LABEL, "", "b", "Ljava/lang/CharSequence;", "f", "()Ljava/lang/CharSequence;", "privacyPolicyLabel", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "privacyPolicyAccessibilityAction", "g", "privacyPolicyURL", "", "J", "getId", "()J", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/o9$a;", "Lio/didomi/sdk/o9$a;", "()Lio/didomi/sdk/o9$a;", "type", "Z", "()Z", "preventListAccessibilityAnnouncement", "<init>", "(Landroid/text/Spanned;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PurposeDisplayHeader implements o9 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final Spanned label;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final CharSequence privacyPolicyLabel;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final String privacyPolicyAccessibilityAction;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final String privacyPolicyURL;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final long id;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final o9.a type;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final boolean preventListAccessibilityAnnouncement;

    public PurposeDisplayHeader(Spanned label, CharSequence charSequence, String str, String privacyPolicyURL) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(privacyPolicyURL, "privacyPolicyURL");
        this.label = label;
        this.privacyPolicyLabel = charSequence;
        this.privacyPolicyAccessibilityAction = str;
        this.privacyPolicyURL = privacyPolicyURL;
        this.id = -2L;
        this.type = o9.a.Header;
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
    public final Spanned getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getPrivacyPolicyAccessibilityAction() {
        return this.privacyPolicyAccessibilityAction;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurposeDisplayHeader)) {
            return false;
        }
        PurposeDisplayHeader purposeDisplayHeader = (PurposeDisplayHeader) other;
        return Intrinsics.areEqual(this.label, purposeDisplayHeader.label) && Intrinsics.areEqual(this.privacyPolicyLabel, purposeDisplayHeader.privacyPolicyLabel) && Intrinsics.areEqual(this.privacyPolicyAccessibilityAction, purposeDisplayHeader.privacyPolicyAccessibilityAction) && Intrinsics.areEqual(this.privacyPolicyURL, purposeDisplayHeader.privacyPolicyURL);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final CharSequence getPrivacyPolicyLabel() {
        return this.privacyPolicyLabel;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getPrivacyPolicyURL() {
        return this.privacyPolicyURL;
    }

    @Override // io.didomi.ssl.o9
    public long getId() {
        return this.id;
    }

    public int hashCode() {
        int iHashCode = this.label.hashCode() * 31;
        CharSequence charSequence = this.privacyPolicyLabel;
        int iHashCode2 = (iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        String str = this.privacyPolicyAccessibilityAction;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.privacyPolicyURL.hashCode();
    }

    public String toString() {
        return "PurposeDisplayHeader(label=" + ((Object) this.label) + ", privacyPolicyLabel=" + ((Object) this.privacyPolicyLabel) + ", privacyPolicyAccessibilityAction=" + this.privacyPolicyAccessibilityAction + ", privacyPolicyURL=" + this.privacyPolicyURL + ')';
    }
}
