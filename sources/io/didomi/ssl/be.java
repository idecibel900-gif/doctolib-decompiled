package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0007\f\rB\t\b\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/be;", "", "", "a", "()J", DiagnosticsEntry.ID_KEY, "", "b", "()I", "typeId", "<init>", "()V", "c", "d", "Lio/didomi/sdk/be$a;", "Lio/didomi/sdk/be$b;", "Lio/didomi/sdk/be$c;", "Lio/didomi/sdk/be$d;", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class be {

    /* JADX INFO: renamed from: io.didomi.sdk.be$a, reason: from toString */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\f\b\u0086\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000bB\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/be$a;", "Lio/didomi/sdk/be;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/lang/CharSequence;", "c", "()Ljava/lang/CharSequence;", "list", "b", "I", "()I", "typeId", "<init>", "(Ljava/lang/CharSequence;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Content extends be {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final CharSequence list;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Content(CharSequence list, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.be
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final CharSequence getList() {
            return this.list;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Content)) {
                return false;
            }
            Content content = (Content) other;
            return Intrinsics.areEqual(this.list, content.list) && this.typeId == content.typeId;
        }

        public int hashCode() {
            return (this.list.hashCode() * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Content(list=" + ((Object) this.list) + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Content(CharSequence charSequence, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i2 & 2) != 0 ? 2 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.be$b, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lio/didomi/sdk/be$b;", "Lio/didomi/sdk/be;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "typeId", "<init>", "(I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Footer extends be {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final int typeId;

        public Footer() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.be
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
            this((i2 & 1) != 0 ? 100 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.be$c, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lio/didomi/sdk/be$c;", "Lio/didomi/sdk/be;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "typeId", "<init>", "(I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Header extends be {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final int typeId;

        public Header() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.be
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
            this((i2 & 1) != 0 ? 0 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.be$d, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\nB)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015¨\u0006\u0019"}, d2 = {"Lio/didomi/sdk/be$d;", "Lio/didomi/sdk/be;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", b.S, "b", "c", "listDescription", "e", "vendorsCount", "I", "()I", "typeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Title extends be {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String title;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final String listDescription;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        private final String vendorsCount;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        private final int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Title(String title, String listDescription, String vendorsCount, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(listDescription, "listDescription");
            Intrinsics.checkNotNullParameter(vendorsCount, "vendorsCount");
            this.title = title;
            this.listDescription = listDescription;
            this.vendorsCount = vendorsCount;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.be
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getListDescription() {
            return this.listDescription;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final String getVendorsCount() {
            return this.vendorsCount;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            Title title = (Title) other;
            return Intrinsics.areEqual(this.title, title.title) && Intrinsics.areEqual(this.listDescription, title.listDescription) && Intrinsics.areEqual(this.vendorsCount, title.vendorsCount) && this.typeId == title.typeId;
        }

        public int hashCode() {
            return (((((this.title.hashCode() * 31) + this.listDescription.hashCode()) * 31) + this.vendorsCount.hashCode()) * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Title(title=" + this.title + ", listDescription=" + this.listDescription + ", vendorsCount=" + this.vendorsCount + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Title(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i2 & 8) != 0 ? 1 : i);
        }
    }

    public /* synthetic */ be(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final long a() {
        return getTypeId();
    }

    /* JADX INFO: renamed from: b */
    public abstract int getTypeId();

    private be() {
    }
}
