package io.didomi.ssl;

import com.opentok.android.PublisherKit;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.b7, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u000bB?\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e¨\u0006\u0018"}, d2 = {"Lio/didomi/sdk/b7;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "Lio/didomi/sdk/Purpose;", "a", "Ljava/util/Set;", "d", "()Ljava/util/Set;", "enabledPurposes", "b", "disabledPurposes", "c", "enabledLegitimatePurposes", "disabledLegitimatePurposes", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "e", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class InitialPurposesHolder {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final Set<Purpose> enabledPurposes;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final Set<Purpose> disabledPurposes;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final Set<Purpose> enabledLegitimatePurposes;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final Set<Purpose> disabledLegitimatePurposes;

    /* JADX INFO: renamed from: io.didomi.sdk.b7$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/didomi/sdk/b7$a;", "", "Lio/didomi/sdk/jh;", "userChoicesInfoProvider", "Lio/didomi/sdk/b7;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InitialPurposesHolder a(jh userChoicesInfoProvider) {
            Intrinsics.checkNotNullParameter(userChoicesInfoProvider, "userChoicesInfoProvider");
            return new InitialPurposesHolder(CollectionsKt.toSet(userChoicesInfoProvider.f()), CollectionsKt.toSet(userChoicesInfoProvider.b()), CollectionsKt.toSet(userChoicesInfoProvider.h()), CollectionsKt.toSet(userChoicesInfoProvider.d()));
        }

        private Companion() {
        }
    }

    public InitialPurposesHolder(Set<Purpose> enabledPurposes, Set<Purpose> disabledPurposes, Set<Purpose> enabledLegitimatePurposes, Set<Purpose> disabledLegitimatePurposes) {
        Intrinsics.checkNotNullParameter(enabledPurposes, "enabledPurposes");
        Intrinsics.checkNotNullParameter(disabledPurposes, "disabledPurposes");
        Intrinsics.checkNotNullParameter(enabledLegitimatePurposes, "enabledLegitimatePurposes");
        Intrinsics.checkNotNullParameter(disabledLegitimatePurposes, "disabledLegitimatePurposes");
        this.enabledPurposes = enabledPurposes;
        this.disabledPurposes = disabledPurposes;
        this.enabledLegitimatePurposes = enabledLegitimatePurposes;
        this.disabledLegitimatePurposes = disabledLegitimatePurposes;
    }

    public final Set<Purpose> a() {
        return this.disabledLegitimatePurposes;
    }

    public final Set<Purpose> b() {
        return this.disabledPurposes;
    }

    public final Set<Purpose> c() {
        return this.enabledLegitimatePurposes;
    }

    public final Set<Purpose> d() {
        return this.enabledPurposes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitialPurposesHolder)) {
            return false;
        }
        InitialPurposesHolder initialPurposesHolder = (InitialPurposesHolder) other;
        return Intrinsics.areEqual(this.enabledPurposes, initialPurposesHolder.enabledPurposes) && Intrinsics.areEqual(this.disabledPurposes, initialPurposesHolder.disabledPurposes) && Intrinsics.areEqual(this.enabledLegitimatePurposes, initialPurposesHolder.enabledLegitimatePurposes) && Intrinsics.areEqual(this.disabledLegitimatePurposes, initialPurposesHolder.disabledLegitimatePurposes);
    }

    public int hashCode() {
        return (((((this.enabledPurposes.hashCode() * 31) + this.disabledPurposes.hashCode()) * 31) + this.enabledLegitimatePurposes.hashCode()) * 31) + this.disabledLegitimatePurposes.hashCode();
    }

    public String toString() {
        return "InitialPurposesHolder(enabledPurposes=" + this.enabledPurposes + ", disabledPurposes=" + this.disabledPurposes + ", enabledLegitimatePurposes=" + this.enabledLegitimatePurposes + ", disabledLegitimatePurposes=" + this.disabledLegitimatePurposes + ')';
    }
}
