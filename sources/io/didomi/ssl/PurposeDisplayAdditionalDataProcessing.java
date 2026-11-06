package io.didomi.ssl;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.p9, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nB%\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00198\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u00020\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b\n\u0010 R\u001a\u0010$\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b\u000f\u0010#¨\u0006'"}, d2 = {"Lio/didomi/sdk/p9;", "Lio/didomi/sdk/o9;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "sectionDescription", "b", "d", "dataProcessingAccessibilityAction", "", "Lio/didomi/sdk/p9$a;", "c", "Ljava/util/List;", "e", "()Ljava/util/List;", "dataProcessingList", "", "J", "getId", "()J", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/o9$a;", "Lio/didomi/sdk/o9$a;", "()Lio/didomi/sdk/o9$a;", "type", "Z", "()Z", "preventListAccessibilityAnnouncement", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PurposeDisplayAdditionalDataProcessing implements o9 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String sectionDescription;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final String dataProcessingAccessibilityAction;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final List<DataProcessingItem> dataProcessingList;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final long id;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final o9.a type;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final boolean preventListAccessibilityAnnouncement;

    /* JADX INFO: renamed from: io.didomi.sdk.p9$a, reason: from toString */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/p9$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "name", "Lio/didomi/sdk/m1;", "Lio/didomi/sdk/m1;", "()Lio/didomi/sdk/m1;", "dataProcessing", "<init>", "(Ljava/lang/CharSequence;Lio/didomi/sdk/m1;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class DataProcessingItem {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final CharSequence name;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final m1 dataProcessing;

        public DataProcessingItem(CharSequence name, m1 dataProcessing) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(dataProcessing, "dataProcessing");
            this.name = name;
            this.dataProcessing = dataProcessing;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final m1 getDataProcessing() {
            return this.dataProcessing;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final CharSequence getName() {
            return this.name;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataProcessingItem)) {
                return false;
            }
            DataProcessingItem dataProcessingItem = (DataProcessingItem) other;
            return Intrinsics.areEqual(this.name, dataProcessingItem.name) && Intrinsics.areEqual(this.dataProcessing, dataProcessingItem.dataProcessing);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.dataProcessing.hashCode();
        }

        public String toString() {
            return "DataProcessingItem(name=" + ((Object) this.name) + ", dataProcessing=" + this.dataProcessing + ')';
        }
    }

    public PurposeDisplayAdditionalDataProcessing(String sectionDescription, String dataProcessingAccessibilityAction, List<DataProcessingItem> dataProcessingList) {
        Intrinsics.checkNotNullParameter(sectionDescription, "sectionDescription");
        Intrinsics.checkNotNullParameter(dataProcessingAccessibilityAction, "dataProcessingAccessibilityAction");
        Intrinsics.checkNotNullParameter(dataProcessingList, "dataProcessingList");
        this.sectionDescription = sectionDescription;
        this.dataProcessingAccessibilityAction = dataProcessingAccessibilityAction;
        this.dataProcessingList = dataProcessingList;
        this.id = -4L;
        this.type = o9.a.AdditionalDataProcessing;
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
    public final String getDataProcessingAccessibilityAction() {
        return this.dataProcessingAccessibilityAction;
    }

    public final List<DataProcessingItem> e() {
        return this.dataProcessingList;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurposeDisplayAdditionalDataProcessing)) {
            return false;
        }
        PurposeDisplayAdditionalDataProcessing purposeDisplayAdditionalDataProcessing = (PurposeDisplayAdditionalDataProcessing) other;
        return Intrinsics.areEqual(this.sectionDescription, purposeDisplayAdditionalDataProcessing.sectionDescription) && Intrinsics.areEqual(this.dataProcessingAccessibilityAction, purposeDisplayAdditionalDataProcessing.dataProcessingAccessibilityAction) && Intrinsics.areEqual(this.dataProcessingList, purposeDisplayAdditionalDataProcessing.dataProcessingList);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getSectionDescription() {
        return this.sectionDescription;
    }

    @Override // io.didomi.ssl.o9
    public long getId() {
        return this.id;
    }

    public int hashCode() {
        return (((this.sectionDescription.hashCode() * 31) + this.dataProcessingAccessibilityAction.hashCode()) * 31) + this.dataProcessingList.hashCode();
    }

    public String toString() {
        return "PurposeDisplayAdditionalDataProcessing(sectionDescription=" + this.sectionDescription + ", dataProcessingAccessibilityAction=" + this.dataProcessingAccessibilityAction + ", dataProcessingList=" + this.dataProcessingList + ')';
    }
}
