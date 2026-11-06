package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0007\f\rB\t\b\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/bf;", "", "", "a", "()J", DiagnosticsEntry.ID_KEY, "", "b", "()I", "typeId", "<init>", "()V", "c", "d", "Lio/didomi/sdk/bf$a;", "Lio/didomi/sdk/bf$b;", "Lio/didomi/sdk/bf$c;", "Lio/didomi/sdk/bf$d;", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class bf {

    /* JADX INFO: renamed from: io.didomi.sdk.bf$a, reason: from toString */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB%\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\"\u0010\u0016\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0018¨\u0006\u001c"}, d2 = {"Lio/didomi/sdk/bf$a;", "Lio/didomi/sdk/bf;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", b.S, "b", "c", b.c, "I", "()I", "setTypeId", "(I)V", "typeId", "", "()J", DiagnosticsEntry.ID_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Description extends bf {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String title;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final String description;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Description(String title, String str, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
            this.description = str;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.bf
        public long a() {
            return super.a() + ((long) this.title.hashCode());
        }

        @Override // io.didomi.ssl.bf
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Description)) {
                return false;
            }
            Description description = (Description) other;
            return Intrinsics.areEqual(this.title, description.title) && Intrinsics.areEqual(this.description, description.description) && this.typeId == description.typeId;
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            String str = this.description;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Description(title=" + this.title + ", description=" + this.description + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Description(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? 3 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.bf$b, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/bf$b;", "Lio/didomi/sdk/bf;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "setTypeId", "(I)V", "typeId", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Footer extends bf {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private int typeId;

        public Footer() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.bf
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
            this((i2 & 1) != 0 ? 4 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.bf$c, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/bf$c;", "Lio/didomi/sdk/bf;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "setTypeId", "(I)V", "typeId", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Header extends bf {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private int typeId;

        public Header() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.bf
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

    /* JADX INFO: renamed from: io.didomi.sdk.bf$d, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\nB)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0015\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/didomi/sdk/bf$d;", "Lio/didomi/sdk/bf;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", b.S, "b", "c", "subtitle", "Z", "e", "()Z", "isIAB", "I", "()I", "setTypeId", "(I)V", "typeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Title extends bf {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String title;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final String subtitle;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        private final boolean isIAB;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Title(String title, String subtitle, boolean z, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            this.title = title;
            this.subtitle = subtitle;
            this.isIAB = z;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.bf
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getSubtitle() {
            return this.subtitle;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final boolean getIsIAB() {
            return this.isIAB;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            Title title = (Title) other;
            return Intrinsics.areEqual(this.title, title.title) && Intrinsics.areEqual(this.subtitle, title.subtitle) && this.isIAB == title.isIAB && this.typeId == title.typeId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int iHashCode = ((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31;
            boolean z = this.isIAB;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return ((iHashCode + r1) * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Title(title=" + this.title + ", subtitle=" + this.subtitle + ", isIAB=" + this.isIAB + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Title(String str, String str2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, (i2 & 8) != 0 ? 2 : i);
        }
    }

    public /* synthetic */ bf(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public long a() {
        return getTypeId();
    }

    /* JADX INFO: renamed from: b */
    public abstract int getTypeId();

    private bf() {
    }
}
