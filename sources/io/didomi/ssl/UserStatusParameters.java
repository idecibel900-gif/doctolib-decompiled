package io.didomi.ssl;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.user.sync.model.ResponseConsents;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.rh, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u001e\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001\nB\u00ad\u0001\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u001f\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u001f\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0017\u0010 \u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010!\u001a\u0004\b\u001c\u0010\"¨\u0006'"}, d2 = {"Lio/didomi/sdk/rh;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/util/Set;", "e", "()Ljava/util/Set;", "enabledConsentPurposeIds", "b", "disabledConsentPurposeIds", "c", "g", "enabledLIPurposeIds", "d", "disabledLIPurposeIds", "f", "enabledConsentVendorIds", "disabledConsentVendorIds", "h", "enabledLIVendorIds", "disabledLIVendorIds", "i", "Z", "j", "()Z", "sendAPIEvent", "Ljava/lang/String;", "()Ljava/lang/String;", "eventAction", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;ZLjava/lang/String;)V", "k", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class UserStatusParameters {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final Set<String> enabledConsentPurposeIds;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final Set<String> disabledConsentPurposeIds;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final Set<String> enabledLIPurposeIds;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final Set<String> disabledLIPurposeIds;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private final Set<String> enabledConsentVendorIds;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private final Set<String> disabledConsentVendorIds;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    private final Set<String> enabledLIVendorIds;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    private final Set<String> disabledLIVendorIds;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
    private final boolean sendAPIEvent;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
    private final String eventAction;

    /* JADX INFO: renamed from: io.didomi.sdk.rh$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lio/didomi/sdk/rh$a;", "", "Lio/didomi/sdk/user/sync/model/ResponseConsents;", "syncConsents", "Lio/didomi/sdk/rh;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserStatusParameters a(ResponseConsents syncConsents) {
            if (syncConsents == null) {
                return new UserStatusParameters(null, null, null, null, null, null, null, null, false, null, 1023, null);
            }
            Set<String> setE = jb.e(syncConsents);
            if (setE == null) {
                setE = SetsKt.emptySet();
            }
            Set<String> setA = jb.a(syncConsents);
            if (setA == null) {
                setA = SetsKt.emptySet();
            }
            Set<String> setG = jb.g(syncConsents);
            if (setG == null) {
                setG = SetsKt.emptySet();
            }
            Set<String> setC = jb.c(syncConsents);
            if (setC == null) {
                setC = SetsKt.emptySet();
            }
            Set<String> setF = jb.f(syncConsents);
            if (setF == null) {
                setF = SetsKt.emptySet();
            }
            Set<String> setB = jb.b(syncConsents);
            if (setB == null) {
                setB = SetsKt.emptySet();
            }
            Set<String> setH = jb.h(syncConsents);
            if (setH == null) {
                setH = SetsKt.emptySet();
            }
            Set<String> setD = jb.d(syncConsents);
            if (setD == null) {
                setD = SetsKt.emptySet();
            }
            return new UserStatusParameters(setE, setA, setG, setC, setF, setB, setH, setD, false, null, 768, null);
        }

        private Companion() {
        }
    }

    public UserStatusParameters() {
        this(null, null, null, null, null, null, null, null, false, null, 1023, null);
    }

    public final Set<String> a() {
        return this.disabledConsentPurposeIds;
    }

    public final Set<String> b() {
        return this.disabledConsentVendorIds;
    }

    public final Set<String> c() {
        return this.disabledLIPurposeIds;
    }

    public final Set<String> d() {
        return this.disabledLIVendorIds;
    }

    public final Set<String> e() {
        return this.enabledConsentPurposeIds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserStatusParameters)) {
            return false;
        }
        UserStatusParameters userStatusParameters = (UserStatusParameters) other;
        return Intrinsics.areEqual(this.enabledConsentPurposeIds, userStatusParameters.enabledConsentPurposeIds) && Intrinsics.areEqual(this.disabledConsentPurposeIds, userStatusParameters.disabledConsentPurposeIds) && Intrinsics.areEqual(this.enabledLIPurposeIds, userStatusParameters.enabledLIPurposeIds) && Intrinsics.areEqual(this.disabledLIPurposeIds, userStatusParameters.disabledLIPurposeIds) && Intrinsics.areEqual(this.enabledConsentVendorIds, userStatusParameters.enabledConsentVendorIds) && Intrinsics.areEqual(this.disabledConsentVendorIds, userStatusParameters.disabledConsentVendorIds) && Intrinsics.areEqual(this.enabledLIVendorIds, userStatusParameters.enabledLIVendorIds) && Intrinsics.areEqual(this.disabledLIVendorIds, userStatusParameters.disabledLIVendorIds) && this.sendAPIEvent == userStatusParameters.sendAPIEvent && Intrinsics.areEqual(this.eventAction, userStatusParameters.eventAction);
    }

    public final Set<String> f() {
        return this.enabledConsentVendorIds;
    }

    public final Set<String> g() {
        return this.enabledLIPurposeIds;
    }

    public final Set<String> h() {
        return this.enabledLIVendorIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v32 */
    public int hashCode() {
        Set<String> set = this.enabledConsentPurposeIds;
        int iHashCode = (set == null ? 0 : set.hashCode()) * 31;
        Set<String> set2 = this.disabledConsentPurposeIds;
        int iHashCode2 = (iHashCode + (set2 == null ? 0 : set2.hashCode())) * 31;
        Set<String> set3 = this.enabledLIPurposeIds;
        int iHashCode3 = (iHashCode2 + (set3 == null ? 0 : set3.hashCode())) * 31;
        Set<String> set4 = this.disabledLIPurposeIds;
        int iHashCode4 = (iHashCode3 + (set4 == null ? 0 : set4.hashCode())) * 31;
        Set<String> set5 = this.enabledConsentVendorIds;
        int iHashCode5 = (iHashCode4 + (set5 == null ? 0 : set5.hashCode())) * 31;
        Set<String> set6 = this.disabledConsentVendorIds;
        int iHashCode6 = (iHashCode5 + (set6 == null ? 0 : set6.hashCode())) * 31;
        Set<String> set7 = this.enabledLIVendorIds;
        int iHashCode7 = (iHashCode6 + (set7 == null ? 0 : set7.hashCode())) * 31;
        Set<String> set8 = this.disabledLIVendorIds;
        int iHashCode8 = (iHashCode7 + (set8 == null ? 0 : set8.hashCode())) * 31;
        boolean z = this.sendAPIEvent;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode8 + r2) * 31;
        String str = this.eventAction;
        return i + (str != null ? str.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getEventAction() {
        return this.eventAction;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getSendAPIEvent() {
        return this.sendAPIEvent;
    }

    public String toString() {
        return "UserStatusParameters(enabledConsentPurposeIds=" + this.enabledConsentPurposeIds + ", disabledConsentPurposeIds=" + this.disabledConsentPurposeIds + ", enabledLIPurposeIds=" + this.enabledLIPurposeIds + ", disabledLIPurposeIds=" + this.disabledLIPurposeIds + ", enabledConsentVendorIds=" + this.enabledConsentVendorIds + ", disabledConsentVendorIds=" + this.disabledConsentVendorIds + ", enabledLIVendorIds=" + this.enabledLIVendorIds + ", disabledLIVendorIds=" + this.disabledLIVendorIds + ", sendAPIEvent=" + this.sendAPIEvent + ", eventAction=" + this.eventAction + ')';
    }

    public UserStatusParameters(Set<String> set, Set<String> set2, Set<String> set3, Set<String> set4, Set<String> set5, Set<String> set6, Set<String> set7, Set<String> set8, boolean z, String str) {
        this.enabledConsentPurposeIds = set;
        this.disabledConsentPurposeIds = set2;
        this.enabledLIPurposeIds = set3;
        this.disabledLIPurposeIds = set4;
        this.enabledConsentVendorIds = set5;
        this.disabledConsentVendorIds = set6;
        this.enabledLIVendorIds = set7;
        this.disabledLIVendorIds = set8;
        this.sendAPIEvent = z;
        this.eventAction = str;
    }

    public /* synthetic */ UserStatusParameters(Set set, Set set2, Set set3, Set set4, Set set5, Set set6, Set set7, Set set8, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? SetsKt.emptySet() : set2, (i & 4) != 0 ? SetsKt.emptySet() : set3, (i & 8) != 0 ? SetsKt.emptySet() : set4, (i & 16) != 0 ? SetsKt.emptySet() : set5, (i & 32) != 0 ? SetsKt.emptySet() : set6, (i & 64) != 0 ? SetsKt.emptySet() : set7, (i & 128) != 0 ? SetsKt.emptySet() : set8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? false : z, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : str);
    }
}
