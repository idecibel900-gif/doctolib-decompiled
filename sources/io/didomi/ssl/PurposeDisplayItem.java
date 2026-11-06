package io.didomi.ssl;

import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.view.mobile.DidomiToggle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.w9, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\b\u0012\u0006\u0010+\u001a\u00020\b\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u00103\u001a\u00020.\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000204\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000204\u0012\u0006\u0010:\u001a\u00020\b¢\u0006\u0004\b=\u0010>J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010 \u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018R\u0017\u0010#\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u0017\u0010(\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010+\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u0017\u0010,\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b!\u0010\u0018R\u0017\u0010-\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\"\u00103\u001a\u00020.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u00101\"\u0004\b\u000b\u00102R \u00107\u001a\b\u0012\u0004\u0012\u00020\u0002048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b$\u00106R \u00108\u001a\b\u0012\u0004\u0012\u00020\u0002048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00105\u001a\u0004\b)\u00106R\"\u0010:\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010%\u001a\u0004\b\u001f\u0010'\"\u0004\b\u000b\u00109R\u001a\u0010<\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b;\u0010%\u001a\u0004\b\u0011\u0010'¨\u0006?"}, d2 = {"Lio/didomi/sdk/w9;", "Lio/didomi/sdk/x9;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "J", "getId", "()J", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/o9$a;", "b", "Lio/didomi/sdk/o9$a;", "()Lio/didomi/sdk/o9$a;", "type", "c", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "dataId", "d", "I", "k", "()I", "iconId", "e", Constants.ScionAnalytics.PARAM_LABEL, "f", "l", "labelEssential", "g", "Z", "n", "()Z", "isEssential", "h", "j", "hasTwoStates", "accessibilityLabel", "accessibilityActionDescription", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "m", "()Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "(Lio/didomi/sdk/view/mobile/DidomiToggle$b;)V", "state", "", "Ljava/util/List;", "()Ljava/util/List;", "accessibilityStateActionDescription", "accessibilityStateDescription", "(Z)V", "accessibilityAnnounceState", "o", "preventListAccessibilityAnnouncement", "<init>", "(JLio/didomi/sdk/o9$a;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Lio/didomi/sdk/view/mobile/DidomiToggle$b;Ljava/util/List;Ljava/util/List;Z)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PurposeDisplayItem implements x9 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final long id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final o9.a type;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final String dataId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final int iconId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private final String label;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private final String labelEssential;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    private final boolean isEssential;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    private final boolean hasTwoStates;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
    private final String accessibilityLabel;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
    private final String accessibilityActionDescription;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
    private DidomiToggle.b state;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata and from toString */
    private final List<String> accessibilityStateActionDescription;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata and from toString */
    private final List<String> accessibilityStateDescription;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata and from toString */
    private boolean accessibilityAnnounceState;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final boolean preventListAccessibilityAnnouncement;

    public PurposeDisplayItem(long j, o9.a type, String dataId, int i, String label, String labelEssential, boolean z, boolean z2, String accessibilityLabel, String accessibilityActionDescription, DidomiToggle.b state, List<String> accessibilityStateActionDescription, List<String> accessibilityStateDescription, boolean z3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(dataId, "dataId");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(labelEssential, "labelEssential");
        Intrinsics.checkNotNullParameter(accessibilityLabel, "accessibilityLabel");
        Intrinsics.checkNotNullParameter(accessibilityActionDescription, "accessibilityActionDescription");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(accessibilityStateActionDescription, "accessibilityStateActionDescription");
        Intrinsics.checkNotNullParameter(accessibilityStateDescription, "accessibilityStateDescription");
        this.id = j;
        this.type = type;
        this.dataId = dataId;
        this.iconId = i;
        this.label = label;
        this.labelEssential = labelEssential;
        this.isEssential = z;
        this.hasTwoStates = z2;
        this.accessibilityLabel = accessibilityLabel;
        this.accessibilityActionDescription = accessibilityActionDescription;
        this.state = state;
        this.accessibilityStateActionDescription = accessibilityStateActionDescription;
        this.accessibilityStateDescription = accessibilityStateDescription;
        this.accessibilityAnnounceState = z3;
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

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getAccessibilityActionDescription() {
        return this.accessibilityActionDescription;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public boolean getAccessibilityAnnounceState() {
        return this.accessibilityAnnounceState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurposeDisplayItem)) {
            return false;
        }
        PurposeDisplayItem purposeDisplayItem = (PurposeDisplayItem) other;
        return this.id == purposeDisplayItem.id && this.type == purposeDisplayItem.type && Intrinsics.areEqual(this.dataId, purposeDisplayItem.dataId) && this.iconId == purposeDisplayItem.iconId && Intrinsics.areEqual(this.label, purposeDisplayItem.label) && Intrinsics.areEqual(this.labelEssential, purposeDisplayItem.labelEssential) && this.isEssential == purposeDisplayItem.isEssential && this.hasTwoStates == purposeDisplayItem.hasTwoStates && Intrinsics.areEqual(this.accessibilityLabel, purposeDisplayItem.accessibilityLabel) && Intrinsics.areEqual(this.accessibilityActionDescription, purposeDisplayItem.accessibilityActionDescription) && this.state == purposeDisplayItem.state && Intrinsics.areEqual(this.accessibilityStateActionDescription, purposeDisplayItem.accessibilityStateActionDescription) && Intrinsics.areEqual(this.accessibilityStateDescription, purposeDisplayItem.accessibilityStateDescription) && this.accessibilityAnnounceState == purposeDisplayItem.accessibilityAnnounceState;
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
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((Long.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + this.dataId.hashCode()) * 31) + Integer.hashCode(this.iconId)) * 31) + this.label.hashCode()) * 31) + this.labelEssential.hashCode()) * 31;
        boolean z = this.isEssential;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.hasTwoStates;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode2 = (((((((((((i + r2) * 31) + this.accessibilityLabel.hashCode()) * 31) + this.accessibilityActionDescription.hashCode()) * 31) + this.state.hashCode()) * 31) + this.accessibilityStateActionDescription.hashCode()) * 31) + this.accessibilityStateDescription.hashCode()) * 31;
        boolean z3 = this.accessibilityAnnounceState;
        return iHashCode2 + (z3 ? 1 : z3);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getDataId() {
        return this.dataId;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getHasTwoStates() {
        return this.hasTwoStates;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getIconId() {
        return this.iconId;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getLabelEssential() {
        return this.labelEssential;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public DidomiToggle.b getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final boolean getIsEssential() {
        return this.isEssential;
    }

    public String toString() {
        return "PurposeDisplayItem(id=" + this.id + ", type=" + this.type + ", dataId=" + this.dataId + ", iconId=" + this.iconId + ", label=" + this.label + ", labelEssential=" + this.labelEssential + ", isEssential=" + this.isEssential + ", hasTwoStates=" + this.hasTwoStates + ", accessibilityLabel=" + this.accessibilityLabel + ", accessibilityActionDescription=" + this.accessibilityActionDescription + ", state=" + this.state + ", accessibilityStateActionDescription=" + this.accessibilityStateActionDescription + ", accessibilityStateDescription=" + this.accessibilityStateDescription + ", accessibilityAnnounceState=" + this.accessibilityAnnounceState + ')';
    }

    public void a(DidomiToggle.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.state = bVar;
    }

    public void a(boolean z) {
        this.accessibilityAnnounceState = z;
    }
}
