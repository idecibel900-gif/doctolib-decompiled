package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0007\f\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0006\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/gd;", "", "", "a", "()J", DiagnosticsEntry.ID_KEY, "", "b", "()I", "typeId", "<init>", "()V", "c", "d", "e", "f", "Lio/didomi/sdk/gd$a;", "Lio/didomi/sdk/gd$b;", "Lio/didomi/sdk/gd$c;", "Lio/didomi/sdk/gd$d;", "Lio/didomi/sdk/gd$e;", "Lio/didomi/sdk/gd$f;", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class gd {

    /* JADX INFO: renamed from: io.didomi.sdk.gd$a, reason: from toString */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/didomi/sdk/gd$a;", "Lio/didomi/sdk/gd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "b", "I", "()I", "setTypeId", "(I)V", "typeId", "", "()J", DiagnosticsEntry.ID_KEY, "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class AdditionalDescription extends gd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String text;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdditionalDescription(String text, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.gd
        public long a() {
            return this.text.hashCode() + 3;
        }

        @Override // io.didomi.ssl.gd
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
            if (!(other instanceof AdditionalDescription)) {
                return false;
            }
            AdditionalDescription additionalDescription = (AdditionalDescription) other;
            return Intrinsics.areEqual(this.text, additionalDescription.text) && this.typeId == additionalDescription.typeId;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "AdditionalDescription(text=" + this.text + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ AdditionalDescription(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 3 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.gd$b, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/gd$b;", "Lio/didomi/sdk/gd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "setTypeId", "(I)V", "typeId", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Footer extends gd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private int typeId;

        public Footer() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.gd
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

    /* JADX INFO: renamed from: io.didomi.sdk.gd$c, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/gd$c;", "Lio/didomi/sdk/gd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "setTypeId", "(I)V", "typeId", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Header extends gd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private int typeId;

        public Header() {
            this(0, 1, null);
        }

        @Override // io.didomi.ssl.gd
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

    /* JADX INFO: renamed from: io.didomi.sdk.gd$d, reason: from toString */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/didomi/sdk/gd$d;", "Lio/didomi/sdk/gd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", Constants.ScionAnalytics.PARAM_LABEL, "b", "I", "()I", "setTypeId", "(I)V", "typeId", "", "()J", DiagnosticsEntry.ID_KEY, "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Subtitle extends gd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String label;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Subtitle(String label, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(label, "label");
            this.label = label;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.gd
        public long a() {
            return this.label.hashCode() + 3;
        }

        @Override // io.didomi.ssl.gd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) other;
            return Intrinsics.areEqual(this.label, subtitle.label) && this.typeId == subtitle.typeId;
        }

        public int hashCode() {
            return (this.label.hashCode() * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Subtitle(label=" + this.label + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Subtitle(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 2 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.gd$e, reason: from toString */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/didomi/sdk/gd$e;", "Lio/didomi/sdk/gd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", b.S, "b", "I", "()I", "setTypeId", "(I)V", "typeId", "<init>", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Title extends gd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String title;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Title(String title, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.gd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            Title title = (Title) other;
            return Intrinsics.areEqual(this.title, title.title) && this.typeId == title.typeId;
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "Title(title=" + this.title + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ Title(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 1 : i);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.gd$f, reason: from toString */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\nB)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u000f\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010!¨\u0006%"}, d2 = {"Lio/didomi/sdk/gd$f;", "Lio/didomi/sdk/gd;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", b.S, "b", "c", "setText", "(Ljava/lang/String;)V", "text", "Lio/didomi/sdk/gi;", "Lio/didomi/sdk/gi;", "e", "()Lio/didomi/sdk/gi;", "setType", "(Lio/didomi/sdk/gi;)V", "type", "I", "()I", "setTypeId", "(I)V", "typeId", "", "()J", DiagnosticsEntry.ID_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/gi;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class VendorsCount extends gd {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String title;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private String text;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        private gi type;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        private int typeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VendorsCount(String title, String text, gi type, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(type, "type");
            this.title = title;
            this.text = text;
            this.type = type;
            this.typeId = i;
        }

        @Override // io.didomi.ssl.gd
        public long a() {
            return this.type.ordinal() + 5 + this.text.hashCode();
        }

        @Override // io.didomi.ssl.gd
        /* JADX INFO: renamed from: b, reason: from getter */
        public int getTypeId() {
            return this.typeId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final gi getType() {
            return this.type;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VendorsCount)) {
                return false;
            }
            VendorsCount vendorsCount = (VendorsCount) other;
            return Intrinsics.areEqual(this.title, vendorsCount.title) && Intrinsics.areEqual(this.text, vendorsCount.text) && this.type == vendorsCount.type && this.typeId == vendorsCount.typeId;
        }

        public int hashCode() {
            return (((((this.title.hashCode() * 31) + this.text.hashCode()) * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.typeId);
        }

        public String toString() {
            return "VendorsCount(title=" + this.title + ", text=" + this.text + ", type=" + this.type + ", typeId=" + this.typeId + ')';
        }

        public /* synthetic */ VendorsCount(String str, String str2, gi giVar, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, giVar, (i2 & 8) != 0 ? 4 : i);
        }
    }

    public /* synthetic */ gd(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public long a() {
        return getTypeId();
    }

    /* JADX INFO: renamed from: b */
    public abstract int getTypeId();

    private gd() {
    }
}
