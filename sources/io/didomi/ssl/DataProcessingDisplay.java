package io.didomi.ssl;

import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.p1, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/p1;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", Constants.ScionAnalytics.PARAM_LABEL, "b", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "retentionTime", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class DataProcessingDisplay {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String label;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final Integer retentionTime;

    public DataProcessingDisplay(String label, Integer num) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.retentionTime = num;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getRetentionTime() {
        return this.retentionTime;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataProcessingDisplay)) {
            return false;
        }
        DataProcessingDisplay dataProcessingDisplay = (DataProcessingDisplay) other;
        return Intrinsics.areEqual(this.label, dataProcessingDisplay.label) && Intrinsics.areEqual(this.retentionTime, dataProcessingDisplay.retentionTime);
    }

    public int hashCode() {
        int iHashCode = this.label.hashCode() * 31;
        Integer num = this.retentionTime;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "DataProcessingDisplay(label=" + this.label + ", retentionTime=" + this.retentionTime + ')';
    }

    public /* synthetic */ DataProcessingDisplay(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num);
    }
}
