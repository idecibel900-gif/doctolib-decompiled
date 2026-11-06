package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0003\u0007\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\t\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lio/didomi/sdk/pd;", "", "", "a", "()J", DiagnosticsEntry.ID_KEY, "", "b", "()I", "typeId", "<init>", "()V", "c", "d", "e", "f", "g", "h", "i", "Lio/didomi/sdk/pd$a;", "Lio/didomi/sdk/pd$b;", "Lio/didomi/sdk/pd$c;", "Lio/didomi/sdk/pd$d;", "Lio/didomi/sdk/pd$e;", "Lio/didomi/sdk/pd$f;", "Lio/didomi/sdk/pd$g;", "Lio/didomi/sdk/pd$h;", "Lio/didomi/sdk/pd$i;", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class pd {

    /* JADX INFO: renamed from: io.didomi.sdk.pd$a, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/didomi/sdk/pd$a;", "Lio/didomi/sdk/pd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "b", "I", "()I", "setTypeId", "(I)V", "typeId", "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class AdditionalDataProcessingHeader extends pd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String text;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdditionalDataProcessingHeader(String text, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.pd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdditionalDataProcessingHeader)) {
                return false;
            }
            AdditionalDataProcessingHeader additionalDataProcessingHeader = (AdditionalDataProcessingHeader) other;
            return Intrinsics.areEqual(this.text, additionalDataProcessingHeader.text) && this.typeId == additionalDataProcessingHeader.typeId;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "AdditionalDataProcessingHeader(text=" + this.text + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ AdditionalDataProcessingHeader(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 8 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pd$b, reason: from toString */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u001d¨\u0006!"}, d2 = {"Lio/didomi/sdk/pd$b;", "Lio/didomi/sdk/pd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "text", "b", "I", "d", "()I", "index", "Lio/didomi/sdk/m1;", "c", "Lio/didomi/sdk/m1;", "()Lio/didomi/sdk/m1;", "dataProcessing", "setTypeId", "(I)V", "typeId", "", "()J", DiagnosticsEntry.ID_KEY, "<init>", "(Ljava/lang/String;ILio/didomi/sdk/m1;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class AdditionalDataProcessingItem extends pd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String text;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final int index;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        private final m1 dataProcessing;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        private int typeId;

        public /* synthetic */ AdditionalDataProcessingItem(String str, int i, m1 m1Var, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, m1Var, (i3 & 8) != 0 ? 9 : i2);
        }

        @Override // io.didomi.ssl.pd
        public long a() {
            return this.index + 9;
        }

        @Override // io.didomi.ssl.pd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final m1 getDataProcessing() {
            return this.dataProcessing;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdditionalDataProcessingItem)) {
                return false;
            }
            AdditionalDataProcessingItem additionalDataProcessingItem = (AdditionalDataProcessingItem) other;
            return Intrinsics.areEqual(this.text, additionalDataProcessingItem.text) && this.index == additionalDataProcessingItem.index && Intrinsics.areEqual(this.dataProcessing, additionalDataProcessingItem.dataProcessing) && this.typeId == additionalDataProcessingItem.typeId;
        }

        public int hashCode() {
            return (((((this.text.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + this.dataProcessing.hashCode()) * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "AdditionalDataProcessingItem(text=" + this.text + ", index=" + this.index + ", dataProcessing=" + this.dataProcessing + ", typeId=" + this.typeId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdditionalDataProcessingItem(String text, int i, m1 dataProcessing, int i2) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(dataProcessing, "dataProcessing");
            this.text = text;
            this.index = i;
            this.dataProcessing = dataProcessing;
            this.typeId = i2;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pd$c, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\nB)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/pd$c;", "Lio/didomi/sdk/pd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", b.S, "b", "c", "status", "Z", "e", "()Z", "setChecked", "(Z)V", "isChecked", "I", "()I", "setTypeId", "(I)V", "typeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Bulk extends pd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String title;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final String status;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        private boolean isChecked;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bulk(String title, String status, boolean z, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(status, "status");
            this.title = title;
            this.status = status;
            this.isChecked = z;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.pd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Bulk)) {
                return false;
            }
            Bulk bulk = (Bulk) other;
            return Intrinsics.areEqual(this.title, bulk.title) && Intrinsics.areEqual(this.status, bulk.status) && this.isChecked == bulk.isChecked && this.typeId == bulk.typeId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int iHashCode = ((this.title.hashCode() * 31) + this.status.hashCode()) * 31;
            boolean z = this.isChecked;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return ((iHashCode + r1) * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Bulk(title=" + this.title + ", status=" + this.status + ", isChecked=" + this.isChecked + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Bulk(String str, String str2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, (i2 & 8) != 0 ? 6 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pd$d, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/didomi/sdk/pd$d;", "Lio/didomi/sdk/pd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "b", "I", "()I", "setTypeId", "(I)V", "typeId", "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Description extends pd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String text;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Description(String text, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.pd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Description)) {
                return false;
            }
            Description description = (Description) other;
            return Intrinsics.areEqual(this.text, description.text) && this.typeId == description.typeId;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Description(text=" + this.text + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Description(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 3 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pd$e, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/pd$e;", "Lio/didomi/sdk/pd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "setTypeId", "(I)V", "typeId", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Footer extends pd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private int typeId;

        public Footer() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.pd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Footer) && this.typeId == ((Footer) other).typeId;
        }

        public int hashCode() {
            return Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Footer(typeId=" + this.typeId + ')';
        }

        public Footer(int i) {
            super(null);
            this.typeId = i;
        }

        public /* synthetic */ Footer(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 10 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pd$f, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/pd$f;", "Lio/didomi/sdk/pd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "setTypeId", "(I)V", "typeId", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Header extends pd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private int typeId;

        public Header() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.pd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Header) && this.typeId == ((Header) other).typeId;
        }

        public int hashCode() {
            return Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Header(typeId=" + this.typeId + ')';
        }

        public Header(int i) {
            super(null);
            this.typeId = i;
        }

        public /* synthetic */ Header(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 1 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pd$g, reason: from toString */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u000bB1\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010!\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u0010\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010#¨\u0006'"}, d2 = {"Lio/didomi/sdk/pd$g;", "Lio/didomi/sdk/pd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Lio/didomi/sdk/Purpose;", "a", "Lio/didomi/sdk/Purpose;", "c", "()Lio/didomi/sdk/Purpose;", "purpose", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", b.S, "d", "subtitle", "Z", "f", "()Z", "setChecked", "(Z)V", "isChecked", "I", "()I", "setTypeId", "(I)V", "typeId", "", "()J", DiagnosticsEntry.ID_KEY, "<init>", "(Lio/didomi/sdk/Purpose;Ljava/lang/String;Ljava/lang/String;ZI)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Purpose extends pd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final io.didomi.ssl.Purpose purpose;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final String title;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        private final String subtitle;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        private boolean isChecked;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
        private int typeId;

        public /* synthetic */ Purpose(io.didomi.ssl.Purpose purpose, String str, String str2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(purpose, str, str2, z, (i2 & 16) != 0 ? 7 : i);
        }

        @Override // io.didomi.ssl.pd
        public long a() {
            return this.purpose.hashCode() + 7;
        }

        @Override // io.didomi.ssl.pd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final io.didomi.ssl.Purpose getPurpose() {
            return this.purpose;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getSubtitle() {
            return this.subtitle;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Purpose)) {
                return false;
            }
            Purpose purpose = (Purpose) other;
            return Intrinsics.areEqual(this.purpose, purpose.purpose) && Intrinsics.areEqual(this.title, purpose.title) && Intrinsics.areEqual(this.subtitle, purpose.subtitle) && this.isChecked == purpose.isChecked && this.typeId == purpose.typeId;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            int iHashCode = ((((this.purpose.hashCode() * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31;
            boolean z = this.isChecked;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return ((iHashCode + r1) * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Purpose(purpose=" + this.purpose + ", title=" + this.title + ", subtitle=" + this.subtitle + ", isChecked=" + this.isChecked + ", typeId=" + this.typeId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Purpose(io.didomi.ssl.Purpose purpose, String title, String subtitle, boolean z, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            this.purpose = purpose;
            this.title = title;
            this.subtitle = subtitle;
            this.isChecked = z;
            this.typeId = i;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pd$h, reason: from toString */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/didomi/sdk/pd$h;", "Lio/didomi/sdk/pd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "b", "I", "()I", "setTypeId", "(I)V", "typeId", "", "()J", DiagnosticsEntry.ID_KEY, "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Section extends pd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String text;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Section(String text, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.pd
        public long a() {
            return this.text.hashCode() + 5;
        }

        @Override // io.didomi.ssl.pd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Section)) {
                return false;
            }
            Section section = (Section) other;
            return Intrinsics.areEqual(this.text, section.text) && this.typeId == section.typeId;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Section(text=" + this.text + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Section(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 5 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pd$i, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/didomi/sdk/pd$i;", "Lio/didomi/sdk/pd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "b", "I", "()I", "setTypeId", "(I)V", "typeId", "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Title extends pd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String text;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Title(String text, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.pd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            Title title = (Title) other;
            return Intrinsics.areEqual(this.text, title.text) && this.typeId == title.typeId;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Title(text=" + this.text + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Title(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 2 : i);
        }
    }

    public /* synthetic */ pd(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public long a() {
        return getTypeId();
    }

    /* JADX INFO: renamed from: b */
    public abstract int getTypeId();

    private pd() {
    }
}
