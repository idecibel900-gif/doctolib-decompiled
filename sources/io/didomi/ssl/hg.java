package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0007\f\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lio/didomi/sdk/hg;", "", "", "a", "()J", DiagnosticsEntry.ID_KEY, "", "b", "()I", "typeId", "<init>", "()V", "c", "d", "e", "f", "g", "Lio/didomi/sdk/hg$a;", "Lio/didomi/sdk/hg$b;", "Lio/didomi/sdk/hg$c;", "Lio/didomi/sdk/hg$d;", "Lio/didomi/sdk/hg$e;", "Lio/didomi/sdk/hg$f;", "Lio/didomi/sdk/hg$g;", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class hg {

    /* JADX INFO: renamed from: io.didomi.sdk.hg$a, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\nB)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/hg$a;", "Lio/didomi/sdk/hg;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", b.S, "b", "c", "status", "Z", "e", "()Z", "setChecked", "(Z)V", "isChecked", "I", "()I", "setTypeId", "(I)V", "typeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Bulk extends hg {

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

        @Override // io.didomi.ssl.hg
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
            this(str, str2, z, (i2 & 8) != 0 ? 5 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.hg$b, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/didomi/sdk/hg$b;", "Lio/didomi/sdk/hg;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "b", "I", "()I", "setTypeId", "(I)V", "typeId", "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Description extends hg {

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

        @Override // io.didomi.ssl.hg
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

    /* JADX INFO: renamed from: io.didomi.sdk.hg$c, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/hg$c;", "Lio/didomi/sdk/hg;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "setTypeId", "(I)V", "typeId", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Footer extends hg {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private int typeId;

        public Footer() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.hg
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
            this((i2 & 1) != 0 ? 7 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.hg$d, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/hg$d;", "Lio/didomi/sdk/hg;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "setTypeId", "(I)V", "typeId", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Header extends hg {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private int typeId;

        public Header() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.hg
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

    /* JADX INFO: renamed from: io.didomi.sdk.hg$e, reason: from toString */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/didomi/sdk/hg$e;", "Lio/didomi/sdk/hg;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "b", "I", "()I", "setTypeId", "(I)V", "typeId", "", "()J", DiagnosticsEntry.ID_KEY, "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Section extends hg {

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

        @Override // io.didomi.ssl.hg
        public long a() {
            return this.text.hashCode() + 4;
        }

        @Override // io.didomi.ssl.hg
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
            this(str, (i2 & 2) != 0 ? 4 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.hg$f, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/didomi/sdk/hg$f;", "Lio/didomi/sdk/hg;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "b", "I", "()I", "setTypeId", "(I)V", "typeId", "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Title extends hg {

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

        @Override // io.didomi.ssl.hg
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

    /* JADX INFO: renamed from: io.didomi.sdk.hg$g, reason: from toString */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\u000bBA\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\b\u0012\b\b\u0002\u0010'\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\"\u0010'\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010#\u001a\u0004\b\u0010\u0010$\"\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010)¨\u0006-"}, d2 = {"Lio/didomi/sdk/hg$g;", "Lio/didomi/sdk/hg;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Lio/didomi/sdk/Vendor;", "a", "Lio/didomi/sdk/Vendor;", "f", "()Lio/didomi/sdk/Vendor;", "vendor", "b", "Z", "c", "()Z", "setHasState", "(Z)V", "hasState", "Ljava/lang/String;", "e", "()Ljava/lang/String;", b.S, "d", "status", "g", "setChecked", "isChecked", "h", "setIAB", "isIAB", "I", "()I", "setTypeId", "(I)V", "typeId", "", "()J", DiagnosticsEntry.ID_KEY, "<init>", "(Lio/didomi/sdk/Vendor;ZLjava/lang/String;Ljava/lang/String;ZZI)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Vendor extends hg {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final io.didomi.ssl.Vendor vendor;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private boolean hasState;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        private final String title;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        private final String status;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
        private boolean isChecked;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
        private boolean isIAB;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
        private int typeId;

        public /* synthetic */ Vendor(io.didomi.ssl.Vendor vendor, boolean z, String str, String str2, boolean z2, boolean z3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(vendor, z, str, str2, z2, z3, (i2 & 64) != 0 ? 6 : i);
        }

        @Override // io.didomi.ssl.hg
        public long a() {
            return this.title.hashCode() + 6;
        }

        @Override // io.didomi.ssl.hg
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final boolean getHasState() {
            return this.hasState;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Vendor)) {
                return false;
            }
            Vendor vendor = (Vendor) other;
            return Intrinsics.areEqual(this.vendor, vendor.vendor) && this.hasState == vendor.hasState && Intrinsics.areEqual(this.title, vendor.title) && Intrinsics.areEqual(this.status, vendor.status) && this.isChecked == vendor.isChecked && this.isIAB == vendor.isIAB && this.typeId == vendor.typeId;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final io.didomi.ssl.Vendor getVendor() {
            return this.vendor;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final boolean getIsIAB() {
            return this.isIAB;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iHashCode = this.vendor.hashCode() * 31;
            boolean z = this.hasState;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int iHashCode2 = (((((iHashCode + r1) * 31) + this.title.hashCode()) * 31) + this.status.hashCode()) * 31;
            boolean z2 = this.isChecked;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            boolean z3 = this.isIAB;
            return ((i + (z3 ? 1 : z3)) * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Vendor(vendor=" + this.vendor + ", hasState=" + this.hasState + ", title=" + this.title + ", status=" + this.status + ", isChecked=" + this.isChecked + ", isIAB=" + this.isIAB + ", typeId=" + this.typeId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Vendor(io.didomi.ssl.Vendor vendor, boolean z, String title, String status, boolean z2, boolean z3, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(vendor, "vendor");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(status, "status");
            this.vendor = vendor;
            this.hasState = z;
            this.title = title;
            this.status = status;
            this.isChecked = z2;
            this.isIAB = z3;
            this.typeId = i;
        }
    }

    public /* synthetic */ hg(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public long a() {
        return getTypeId();
    }

    /* JADX INFO: renamed from: b */
    public abstract int getTypeId();

    private hg() {
    }
}
