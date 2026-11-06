package io.didomi.ssl;

import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.view.mobile.DidomiToggle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.q9, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d\u0012\u0006\u0010&\u001a\u00020\b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0015\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\n\u0010\u001bR \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b#\u0010!R\"\u0010&\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\n\u0010%R\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001a\u0010,\u001a\u00020(8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010+R\u001a\u00100\u001a\u00020-8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b\n\u0010/R\u001a\u00102\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b1\u0010\u0012\u001a\u0004\b\u000f\u0010\u0014¨\u00065"}, d2 = {"Lio/didomi/sdk/q9;", "Lio/didomi/sdk/x9;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", Constants.ScionAnalytics.PARAM_LABEL, "b", "f", "accessibilityLabel", "Z", "i", "()Z", "shouldHideToggle", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "d", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "j", "()Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "(Lio/didomi/sdk/view/mobile/DidomiToggle$b;)V", "state", "", "e", "Ljava/util/List;", "g", "()Ljava/util/List;", "accessibilityStateActionDescription", "h", "accessibilityStateDescription", "(Z)V", "accessibilityAnnounceState", "accessibilityAnnounceStateLabel", "", "J", "getId", "()J", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/o9$a;", "Lio/didomi/sdk/o9$a;", "()Lio/didomi/sdk/o9$a;", "type", "k", "preventListAccessibilityAnnouncement", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLio/didomi/sdk/view/mobile/DidomiToggle$b;Ljava/util/List;Ljava/util/List;ZLjava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PurposeDisplayBulkAction implements x9 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String label;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final String accessibilityLabel;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean shouldHideToggle;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private DidomiToggle.b state;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private final List<String> accessibilityStateActionDescription;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private final List<String> accessibilityStateDescription;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    private boolean accessibilityAnnounceState;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    private final String accessibilityAnnounceStateLabel;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final long id;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final o9.a type;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final boolean preventListAccessibilityAnnouncement;

    public PurposeDisplayBulkAction(String label, String str, boolean z, DidomiToggle.b state, List<String> accessibilityStateActionDescription, List<String> accessibilityStateDescription, boolean z2, String str2) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(accessibilityStateActionDescription, "accessibilityStateActionDescription");
        Intrinsics.checkNotNullParameter(accessibilityStateDescription, "accessibilityStateDescription");
        this.label = label;
        this.accessibilityLabel = str;
        this.shouldHideToggle = z;
        this.state = state;
        this.accessibilityStateActionDescription = accessibilityStateActionDescription;
        this.accessibilityStateDescription = accessibilityStateDescription;
        this.accessibilityAnnounceState = z2;
        this.accessibilityAnnounceStateLabel = str2;
        this.id = -3L;
        this.type = o9.a.BulkAction;
        this.preventListAccessibilityAnnouncement = true;
    }

    public void a(DidomiToggle.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.state = bVar;
    }

    @Override // io.didomi.ssl.o9
    /* JADX INFO: renamed from: b, reason: from getter */
    public boolean getPreventListAccessibilityAnnouncement() {
        return this.preventListAccessibilityAnnouncement;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public boolean getAccessibilityAnnounceState() {
        return this.accessibilityAnnounceState;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getAccessibilityAnnounceStateLabel() {
        return this.accessibilityAnnounceStateLabel;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurposeDisplayBulkAction)) {
            return false;
        }
        PurposeDisplayBulkAction purposeDisplayBulkAction = (PurposeDisplayBulkAction) other;
        return Intrinsics.areEqual(this.label, purposeDisplayBulkAction.label) && Intrinsics.areEqual(this.accessibilityLabel, purposeDisplayBulkAction.accessibilityLabel) && this.shouldHideToggle == purposeDisplayBulkAction.shouldHideToggle && this.state == purposeDisplayBulkAction.state && Intrinsics.areEqual(this.accessibilityStateActionDescription, purposeDisplayBulkAction.accessibilityStateActionDescription) && Intrinsics.areEqual(this.accessibilityStateDescription, purposeDisplayBulkAction.accessibilityStateDescription) && this.accessibilityAnnounceState == purposeDisplayBulkAction.accessibilityAnnounceState && Intrinsics.areEqual(this.accessibilityAnnounceStateLabel, purposeDisplayBulkAction.accessibilityAnnounceStateLabel);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    public List<String> g() {
        return this.accessibilityStateActionDescription;
    }

    @Override // io.didomi.ssl.o9
    public long getId() {
        return this.id;
    }

    public List<String> h() {
        return this.accessibilityStateDescription;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = this.label.hashCode() * 31;
        String str = this.accessibilityLabel;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.shouldHideToggle;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode3 = (((((((iHashCode2 + r1) * 31) + this.state.hashCode()) * 31) + this.accessibilityStateActionDescription.hashCode()) * 31) + this.accessibilityStateDescription.hashCode()) * 31;
        boolean z2 = this.accessibilityAnnounceState;
        int i = (iHashCode3 + (z2 ? 1 : z2)) * 31;
        String str2 = this.accessibilityAnnounceStateLabel;
        return i + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getShouldHideToggle() {
        return this.shouldHideToggle;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public DidomiToggle.b getState() {
        return this.state;
    }

    public String toString() {
        return "PurposeDisplayBulkAction(label=" + this.label + ", accessibilityLabel=" + this.accessibilityLabel + ", shouldHideToggle=" + this.shouldHideToggle + ", state=" + this.state + ", accessibilityStateActionDescription=" + this.accessibilityStateActionDescription + ", accessibilityStateDescription=" + this.accessibilityStateDescription + ", accessibilityAnnounceState=" + this.accessibilityAnnounceState + ", accessibilityAnnounceStateLabel=" + this.accessibilityAnnounceStateLabel + ')';
    }

    public void a(boolean z) {
        this.accessibilityAnnounceState = z;
    }

    @Override // io.didomi.ssl.o9
    /* JADX INFO: renamed from: a, reason: from getter */
    public o9.a getType() {
        return this.type;
    }

    public /* synthetic */ PurposeDisplayBulkAction(String str, String str2, boolean z, DidomiToggle.b bVar, List list, List list2, boolean z2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, bVar, list, list2, z2, str3);
    }
}
